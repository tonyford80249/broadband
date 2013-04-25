
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.audit;

import java.util.List;

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

import com.cdoe.biz.model.audit.AuditTracking;
import com.cdoe.services.audit.IUploadStudentsManager;
import com.cdoe.ui.form.audit.AuditSasidExceptionForm;
import com.cdoe.ui.form.audit.AuditTrackingForm;
import com.resqsoft.util.RequestUtils;

@Controller
@RequestMapping("/secure/UploadStudents")
public class UploadStudentsController {

	private static final Logger logger = Logger.getLogger(UploadStudentsController.class);
	
	@Autowired
	private IUploadStudentsManager UploadStudentsManager;
	
	@Autowired
	private Validator auditTrackingValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
		AuditSasidExceptionForm form = UploadStudentsManager.setupForm();
    	model.addAttribute("auditTrackingForm", form);
		return ".UploadStudents-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute AuditTrackingForm auditTrackingForm, BindingResult result, HttpServletRequest request) {
    	auditTrackingValidator.validate(auditTrackingForm, result);
		if (result.hasErrors()) {
			return ".UploadStudents-index";
		}
		UploadStudentsManager.saveOrUpdate(auditTrackingForm);
		model.addAttribute("saved", true);
		return ".UploadStudents-index";
    }
    
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {
		AuditSasidExceptionForm form = UploadStudentsManager.setupForm(id);
    	model.addAttribute("auditTrackingForm", form);
		return ".UploadStudents-index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, HttpServletRequest request) {
    	UploadStudentsManager.delete(AuditTracking.class, id);
		return "redirect:" + RequestUtils.getContextPath(request) + "/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	List<AuditTracking> auditTrackings = UploadStudentsManager.findAll(AuditTracking.class);
    	model.addAttribute("auditTrackings", auditTrackings);
		return ".UploadStudents-list";
    }
	
}