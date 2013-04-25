
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

import com.cdoe.biz.model.audit.AuditEqual;
import com.cdoe.services.audit.ICreateUpdateAuditManager;
import com.cdoe.ui.form.audit.AuditEqualForm;
import com.resqsoft.util.RequestUtils;

@Controller
@RequestMapping("/secure/CreateUpdateAudit")
public class CreateUpdateAuditController {

	private static final Logger logger = Logger.getLogger(CreateUpdateAuditController.class);
	
	@Autowired
	private ICreateUpdateAuditManager CreateUpdateAuditManager;
	
	@Autowired
	private Validator auditEqualValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
    	AuditEqualForm form = CreateUpdateAuditManager.setupForm();
    	model.addAttribute("auditEqualForm", form);
		return ".CreateUpdateAudit-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute AuditEqualForm auditEqualForm, BindingResult result, HttpServletRequest request) {
    	auditEqualValidator.validate(auditEqualForm, result);
		if (result.hasErrors()) {
			return ".CreateUpdateAudit-index";
		}
		CreateUpdateAuditManager.saveOrUpdate(auditEqualForm);
		model.addAttribute("saved", true);
		return ".CreateUpdateAudit-index";
    }
    
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {
    	AuditEqualForm form = CreateUpdateAuditManager.setupForm(id);
    	model.addAttribute("auditEqualForm", form);
		return ".CreateUpdateAudit-index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, HttpServletRequest request) {
    	CreateUpdateAuditManager.delete(AuditEqual.class, id);
		return "redirect:" + RequestUtils.getContextPath(request) + "/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	List<AuditEqual> auditEquals = CreateUpdateAuditManager.findAll(AuditEqual.class);
    	model.addAttribute("auditEquals", auditEquals);
		return ".CreateUpdateAudit-list";
    }
	
}