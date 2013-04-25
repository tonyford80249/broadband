
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.audit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.audit.IValidateSASIDsManager;
import com.cdoe.ui.form.audit.AuditSasidExceptionForm;
@Controller
@RequestMapping("/secure/ValidateSASIDs")
public class ValidateSASIDsController {

	private static final Logger logger = Logger.getLogger(ValidateSASIDsController.class);
	
	@Autowired
	private IValidateSASIDsManager  validateSASIDsManager; 
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
		AuditSasidExceptionForm form = validateSASIDsManager.setupForm();
    	model.addAttribute("auditSasidExceptionForm", form);
	
		return ".ValidateSASIDs-index";
    }
	
}