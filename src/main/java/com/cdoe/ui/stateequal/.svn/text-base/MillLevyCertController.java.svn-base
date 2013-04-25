
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;



import com.cdoe.biz.model.jasper.SeMillLevyCertificationDatasource;
import com.cdoe.services.impl.stateequal.ReportManagerBase;
import com.cdoe.services.stateequal.IMillLevyCertManager;
import com.cdoe.ui.form.stateequal.MillLevyForm;
import com.cdoe.ui.validator.stateequal.MillLevyValidator;
import org.apache.log4j.Logger;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.cdoe.util.DateUtil;
import com.cdoe.util.FilenameConstructor;
import com.cdoe.util.UserInfo;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
@RequestMapping("/secure/MillLevyCert")
public class MillLevyCertController {

	private static final Logger LOGGER = Logger.getLogger(MillLevyCertController.class);
	
	@Autowired
	private IMillLevyCertManager millLevyCertManager;
	
	@Autowired
	private MillLevyValidator millLevyValidator;
        
        @Autowired
        private MappingJacksonJsonView standardJsonView;
                       
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
        
        String districtNumber =  userInfo.getAllDistrictCodes().get(0);
        String districtName =  userInfo.getDistrictMap().get(districtNumber);
        String fiscalYear = DateUtil.getCurrentFiscalYear();
       
        
    	MillLevyForm form = millLevyCertManager.setupForm(districtNumber, districtName, userInfo.getDistrictPrimaryCountyMap().get(districtNumber), fiscalYear);
    	model.addAttribute("pageInfo", form);
        model.addAttribute("pageCss", "MillLevyCert");
        model.addAttribute("districtCodeList", userInfo.getAllDistrictCodes());
        model.addAttribute("taxYears",DateUtil.convertToCalendarYears(DateUtil.getLongFiscalYears(-7)));
        
        
        //model.addAttribute("districtNumber", districtNumber);
        //model.addAttribute("districtName", districtName);
        //model.addAttribute("taxYear",fiscalYear);
        
        //millLevyCertManager.saveSpawnData(userInfo.getDistrictMap());
        
        
        
    	//initModelDropdowns(model, session);
		return ".MillLevyCert-index";
    }
    
     @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ModelAndView retrieve(@RequestParam String districtNumber, @RequestParam String fiscalYear, HttpServletRequest request) {
       try {           
        Map<String, Object> parameterMap = new HashMap<String, Object>(); 
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
        
         MillLevyForm updatedForm = millLevyCertManager.setupForm(districtNumber,userInfo.getDistrictMap().get(districtNumber), userInfo.getDistrictPrimaryCountyMap().get(districtNumber), DateUtil.convertCalendarYearToFiscalYear(fiscalYear));
         
         //parameterMap.put("pageCss", "MillLevyCert");
         //parameterMap.put("districtCodeList", userInfo.getAllDistrictCodes());
         //parameterMap.put("taxYears",DateUtil.convertToCalendarYears(DateUtil.getLongFiscalYears(-7)));        
         parameterMap.put("millLevyForm", updatedForm);

         return new ModelAndView(standardJsonView, parameterMap);
       }
       catch(Exception e){
        LOGGER.error("MillLevy Certification Exception", e);
       }
       
       return null;
     }
     
     
    
        
       /**
        * 
        * @param model
        * @param form
        * @param result
        * @param request
        * @return 
        */ 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(Model model, @ModelAttribute MillLevyForm form, BindingResult result, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
        
        form.setApprovedFinal(true);
        
    	millLevyValidator.validate(form, result);
	if (result.hasErrors()) {
	      return new ModelAndView(".MillLevyCert-index", model.asMap());
	}
		//millLevyCertManager.saveSpawnData(userInfo.getDistrictMap());
             
        millLevyCertManager.saveOrUpdate(form);
        
	Map<String, Object> parameterMap = new HashMap<String, Object>(); 
                          
        parameterMap.put("saved", true);
        parameterMap.put("pageInfo", form);
        parameterMap.put("pageCss", "MillLevyCert");
        parameterMap.put("districtCodeList", userInfo.getAllDistrictCodes());
        parameterMap.put("taxYears",DateUtil.convertToCalendarYears(DateUtil.getLongFiscalYears(-7)));
          
        return new ModelAndView(".MillLevyCert-index", parameterMap);	
    }
    
    /**
     * 
     * @param model
     * @param form
     * @param result
     * @param request
     * @return 
     */
    @RequestMapping(value = "/compute", method = RequestMethod.POST)
    public ModelAndView compute(Model model, @ModelAttribute MillLevyForm form, BindingResult result, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");                
        
    	millLevyValidator.validate(form, result);
	if (result.hasErrors()) {
	      return new ModelAndView(".MillLevyCert-index", model.asMap());
	}
	
        millLevyCertManager.performCalculations(form);
        
        Map<String, Object> parameterMap = new HashMap<String, Object>(); 
                          
        parameterMap.put("computed", true);
        parameterMap.put("pageInfo", form);
        parameterMap.put("pageCss", "MillLevyCert");
        parameterMap.put("districtCodeList", userInfo.getAllDistrictCodes());
        parameterMap.put("taxYears",DateUtil.convertToCalendarYears(DateUtil.getLongFiscalYears(-7)));
          
        return new ModelAndView(".MillLevyCert-index", parameterMap);	
    }
    
    
    /**
     * 
     * @param model
     * @param districtNumber
     * @param taxYear
     * @param request
     * @return 
     */
    @RequestMapping(value = "/report/millLevyCert.pdf", method = RequestMethod.GET)
    public ModelAndView report1(Model model, @RequestParam String districtNumber, @RequestParam String taxYear, HttpServletRequest request) {        
      final String reportName = "millLevyCert";
      final String format = "Pdf";  
      HttpSession session = request.getSession();
      UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
      
      
             
     try {      
      Map<String, Object> parameterMap = new HashMap<String, Object>();
      
      MillLevyForm updatedForm = millLevyCertManager.setupForm(districtNumber,userInfo.getDistrictMap().get(districtNumber), userInfo.getDistrictPrimaryCountyMap().get(districtNumber), DateUtil.convertCalendarYearToFiscalYear(taxYear));
     
      SeMillLevyCertificationDatasource datasource  = millLevyCertManager.createDataSource(updatedForm);
     
      parameterMap.put("customJRDatasource", datasource);
      
      String reportId = reportName + "Report" + format + "View";
      
      return new ModelAndView(reportId, parameterMap);
            
      //FilenameConstructor filenameConstructor = millLevyCertManager.createFilenameConstructor();
     
      //millLevyReportManager.generateReport(datasource, filenameConstructor);
     
     }
     catch(Throwable t) {
      LOGGER.error("Exception during Millevy report generation", t);   
     }
     
     return null;        
    }
    
	 private void initModelDropdowns(Model model, HttpSession session) {
			//UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
	    	UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
			model.addAttribute("districtCodeList", userInfo.getAllDistrictCodes());
			model.addAttribute("fiscalYearList", DateUtil.getShortYears(DateUtil.getCurrentFiscalYearShort(), 5));
                        	//millLevyCertManager.saveSpawnData(userInfo.getDistrictMap());
	    }
	
}