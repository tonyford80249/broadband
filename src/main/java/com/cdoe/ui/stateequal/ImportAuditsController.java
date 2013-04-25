
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import com.cdoe.biz.model.jasper.ImportPriorYearAuditCollection;
import com.cdoe.biz.model.jasper.ImportPriorYearAuditDatasource;
import com.cdoe.services.stateequal.IAuditSummaryReportManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.stateequal.IImportAuditsManager;
import com.cdoe.ui.form.stateequal.ImportAuditsForm;
import com.cdoe.ui.form.stateequal.ResetAuditsForm;
import com.cdoe.util.UserInfo;
import net.sf.jasperreports.engine.JRDataSource;

@Controller
@RequestMapping("/secure/ImportAudits")
public class ImportAuditsController {

	private static final Logger logger = Logger.getLogger(ImportAuditsController.class);
	
	@Autowired
	private IImportAuditsManager importAuditsManager;
        @Autowired
        private IAuditSummaryReportManager auditSummaryReportManager;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
    	ImportAuditsForm importAuditsForm = importAuditsManager.setupImportAuditsForm();
    	model.addAttribute("importAuditsForm", importAuditsForm);
    	ResetAuditsForm resetAuditsForm = importAuditsManager.setupResetAuditsForm();
    	model.addAttribute("resetAuditsForm", resetAuditsForm);
        
         UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
         
        //importAuditsManager.saveGeneratedData(userInfo.getDistrictMap());
        
		return ".ImportAudits-index";
    }
    
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(Model model,  HttpServletRequest request) {
                HttpSession session = request.getSession();
                  
                UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
                  
                ImportAuditsForm importAuditsForm = importAuditsManager.setupImportAuditsForm();
            
 		importAuditsManager.uploadAudits(importAuditsForm);
                
                try {
                                      
                ImportPriorYearAuditCollection collection = auditSummaryReportManager.createImportPriorYearAuditCollection(importAuditsManager.extractAuditIds(importAuditsForm), userInfo.getDistrictMap());
                
                ImportPriorYearAuditDatasource datasource = auditSummaryReportManager.createImportPriorYearAuditDatasource(collection);
                                
                auditSummaryReportManager.generateReport(datasource, auditSummaryReportManager.createPaymentReportFilenameConstructor());
                            
                }
                catch(Exception e) {
                 logger.error("Exception occured during import prior audit upload", e);   
                }
                
                
    	//ResetAuditsForm resetAuditsForm = importAuditsManager.setupResetAuditsForm();
    	//model.addAttribute("resetAuditsForm", resetAuditsForm);
	//	model.addAttribute("saved", true);
	//	return ".ImportAudits-index";
                
       return index(model, request.getSession());         
    }

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String reset(Model model, @ModelAttribute ResetAuditsForm resetAuditsForm, HttpServletRequest request) {
 		importAuditsManager.rejectAudit(resetAuditsForm.getResetAuditId(), resetAuditsForm.getResetOrganizationCode());
    	//ImportAuditsForm importAuditsForm = importAuditsManager.setupImportAuditsForm();
    	//model.addAttribute("importAuditsForm", importAuditsForm);
	//	model.addAttribute("saved", true);
	//	return ".ImportAudits-index";
                
        return index(model, request.getSession());        
    }

}