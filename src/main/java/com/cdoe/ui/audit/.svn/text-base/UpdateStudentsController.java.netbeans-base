
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.audit;

import org.apache.log4j.Logger;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.resqsoft.util.RequestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.audit.IValidateSASIDsManager;
import com.cdoe.biz.model.audit.AuditSasidException;
import com.cdoe.ui.form.audit.AuditSasidExceptionForm;

@Controller
@RequestMapping("/secure/UpdateStudents")
public class UpdateStudentsController {

	private static final Logger logger = Logger.getLogger(UpdateStudentsController.class);
	
	@Autowired
	private IValidateSASIDsManager UpdateStudentsManager;
	
	@Autowired
	private Validator auditSasidExceptionValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
    	AuditSasidExceptionForm form = UpdateStudentsManager.setupForm();
    	model.addAttribute("auditSasidExceptionForm", form);
		return ".UpdateStudents-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute AuditSasidExceptionForm auditSasidExceptionForm, BindingResult result, HttpServletRequest request) {
    	auditSasidExceptionValidator.validate(auditSasidExceptionForm, result);
		if (result.hasErrors()) {
			return ".UpdateStudents-index";
		}
		UpdateStudentsManager.saveOrUpdate(auditSasidExceptionForm);
		model.addAttribute("saved", true);
		return ".UpdateStudents-index";
    }
    
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {
    	AuditSasidExceptionForm form = UpdateStudentsManager.setupForm(id);
    	model.addAttribute("auditSasidExceptionForm", form);
		return ".UpdateStudents-index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, HttpServletRequest request) {
    	UpdateStudentsManager.delete(AuditSasidException.class, id);
		return "redirect:" + RequestUtils.getContextPath(request) + "/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	List<AuditSasidException> auditSasidExceptions = UpdateStudentsManager.findAll(AuditSasidException.class);
    	model.addAttribute("auditSasidExceptions", auditSasidExceptions);
		return ".UpdateStudents-list";
    }
	
}