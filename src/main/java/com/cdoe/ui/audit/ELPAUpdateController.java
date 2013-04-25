
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.audit;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.audit.IBillingUpdateManager;
import com.cdoe.ui.form.audit.AuditElpaForm;
import com.cdoe.ui.form.audit.AuditEqualForm;

@Controller
@RequestMapping("/secure/ELPAUpdate")
public class ELPAUpdateController {

	private static final Logger logger = Logger.getLogger(ELPAUpdateController.class);
	
	@Autowired
	private IBillingUpdateManager BillingUpdateManager;
	
	@Autowired
	private Validator auditEqualValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
    	AuditEqualForm form = BillingUpdateManager.setupForm();
    	model.addAttribute("auditEqualForm", form);
		return ".BillingUpdate-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute AuditEqualForm auditEqualForm, BindingResult result, HttpServletRequest request) {
    	auditEqualValidator.validate(auditEqualForm, result);
		if (result.hasErrors()) {
			return ".BillingUpdate-index";
		}
		BillingUpdateManager.saveOrUpdate(auditEqualForm);
		model.addAttribute("saved", true);
		return ".BillingUpdate-index";
    }
}