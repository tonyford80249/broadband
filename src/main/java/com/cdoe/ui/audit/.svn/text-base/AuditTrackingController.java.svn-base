
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.audit.IAuditTrackingManager;
import com.cdoe.ui.form.audit.AuditTrackingForm;

@Controller
@RequestMapping("/secure/AuditTracking")
public class AuditTrackingController {

	private static final Logger logger = Logger.getLogger(AuditTrackingController.class);
	
	@Autowired
	private IAuditTrackingManager audTrackingManager;
	
	@Autowired
	private Validator auditFpcValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
    	AuditTrackingForm form = audTrackingManager.setupForm();
    	model.addAttribute("auditFpcForm", form);
		return ".AuditTracking-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute AuditTrackingForm auditFpcForm, BindingResult result, HttpServletRequest request) {
    	auditFpcValidator.validate(auditFpcForm, result);
		if (result.hasErrors()) {
			return ".AuditTracking-index";
		}
		audTrackingManager.saveOrUpdate(auditFpcForm);
		model.addAttribute("saved", true);
		return ".AuditTracking-index";
    }
    
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {
    	AuditTrackingForm form = audTrackingManager.setupForm(id);
    	model.addAttribute("auditFpcForm", form);
		return ".AuditTracking-index";
    }
    
  	
}