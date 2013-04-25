
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.stateequal.IHelpManager;
import com.cdoe.ui.form.stateequal.HelpForm;
import com.cdoe.util.UserInfo;

@Controller
@RequestMapping("/secure/HelpInfo")
public class HelpController {

	private static final Logger logger = Logger.getLogger(HelpController.class);
	
	@Autowired
	private IHelpManager helpInfoManager;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
    	HelpForm form = helpInfoManager.setupForm();
    	
    	model.addAttribute("helpInfoForm", form);
		return ".HelpInfo-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute HelpForm helpInfoForm, BindingResult result, HttpServletRequest request) {
    	
		if (result.hasErrors()) {
			helpInfoForm = helpInfoManager.setupForm();
			helpInfoForm.setErrorMessage(result.getFieldError().getDefaultMessage());
		
			model.addAttribute("helpInfoForm", helpInfoForm);
			return ".HelpInfo-index";
		}
		String enteredBy  =  ((UserInfo) request.getSession().getAttribute("USER_INFO")).getUserId();//getUserName();
		
		helpInfoForm.setEnteredBy(enteredBy);
		helpInfoForm.setActive("Y");
		helpInfoForm.setEnteredDate(Calendar.getInstance().getTime());
		//helpInfoForm.setFiscalYear(fiscalYear)
		logger.debug(helpInfoForm.getNote());
		logger.debug(enteredBy);
		helpInfoManager.saveOrUpdate(helpInfoForm);
		model.addAttribute("saved", true);
		helpInfoForm = helpInfoManager.setupForm();
		//initModelDropdowns(model, request.getSession());
		model.addAttribute("helpInfoForm", helpInfoForm);
		return ".HelpInfo-index";
    }
    
	
}