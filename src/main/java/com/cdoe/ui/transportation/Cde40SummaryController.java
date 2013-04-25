/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.transportation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.services.transportation.ICde40SummaryManager;
import com.cdoe.ui.form.grid.TransportationGrid;
import com.cdoe.ui.form.transportation.TransportationForm;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;
import com.resqsoft.util.RequestUtils;

@Controller
@RequestMapping("/secure/Cde40Summary")
public class Cde40SummaryController {

	private static final Logger logger = Logger
			.getLogger(Cde40SummaryController.class);

	@Autowired
	private ICde40SummaryManager cde40SummaryManager;

	@Autowired
	private Validator cde40SummaryValidator;


	@InitBinder
	public void initListBinder(WebDataBinder binder) {
	    binder.setAutoGrowCollectionLimit(1000);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {            
                final String FISCAL_YEAR =  "fiscalYear";
                
                UserInfo userInfo = (UserInfo) request.getSession().getAttribute(UserInfo.USER_INFO_ATTR);
                
		HttpSession session = request.getSession();
		String fiscalYear =  (String) session.getAttribute(FISCAL_YEAR);
                
                if (fiscalYear == null) {
                 fiscalYear = DateUtil.getFiscalYear();    
                 
                 session.setAttribute(FISCAL_YEAR, fiscalYear);
                }
                
		TransportationForm form = cde40SummaryManager.setupForm(fiscalYear, userInfo);
		model.addAttribute("transportationForm", form);
		return ".Cde40Summary-index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model,
			@ModelAttribute TransportationForm transportationForm,
			BindingResult result, HttpServletRequest request) {
		
		
		logger.debug("saveButton" +  request.getParameter("saveButton")  +  "value2" +  request.getParameter("rejectDistrict") + "value3" +  request.getParameter("downLoadToExcel"));
		
		if ( request.getParameter("saveButton") != null) {
			if (validCde40TransReimburseData(transportationForm, result)) {
				cde40SummaryManager.saveOrUpdate(transportationForm);
				transportationForm.setMessage("Cde40 Transportation Reimbursement Information saved successfully for the selected districts");
				model.addAttribute("saved", true);
			}
		}
		else if (request.getParameter("rejectDistrict") != null) {
			logger.debug("Reject district Path");
			cde40SummaryManager.rejectDistrictForms(transportationForm);
			transportationForm.setMessage("Cde40 Transportation Reimbursement Information rejected successfully for the selected districts");
			model.addAttribute("saved", true);
		}
		return ".Cde40Summary-index";
	}
	
	private boolean validCde40TransReimburseData(TransportationForm transportationForm, BindingResult result) {
		List<TransportationGrid> transGridList = transportationForm.getTransportationGridList();
		for (TransportationGrid transGrid : transGridList) {
			if (transGrid.getSelect() != null
					&& "true".equalsIgnoreCase(transGrid.getSelect())) {
				cde40SummaryValidator.validate(transGrid, result);
				if (result.hasErrors()) {
					transportationForm.setMessage(result.getFieldError().getDefaultMessage() + " for district code " + transGrid.getDistrictNumber());
					return false;
				}
			}
		}
		return true;
	 
	}

}