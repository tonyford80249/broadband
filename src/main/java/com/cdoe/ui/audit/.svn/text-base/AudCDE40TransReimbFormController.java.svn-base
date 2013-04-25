
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

import com.cdoe.services.audit.IAudCDE40TransReimbFormManager;
import com.cdoe.biz.model.audit.AuditTran;
import com.cdoe.ui.form.audit.AuditTranForm;

@Controller
@RequestMapping("/secure/AudCDE40TransReimbForm")
public class AudCDE40TransReimbFormController {

	private static final Logger logger = Logger.getLogger(AudCDE40TransReimbFormController.class);
	
	@Autowired
	private IAudCDE40TransReimbFormManager audCDE40TransReimbFormManager;
	
	@Autowired
	private Validator auditTranValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
    	AuditTranForm form = audCDE40TransReimbFormManager.setupForm();
    	model.addAttribute("auditTranForm", form);
		return ".AudCDE40TransReimbForm-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute AuditTranForm auditTranForm, BindingResult result, HttpServletRequest request) {
    	auditTranValidator.validate(auditTranForm, result);
		if (result.hasErrors()) {
			return ".AudCDE40TransReimbForm-index";
		}
		audCDE40TransReimbFormManager.saveOrUpdate(auditTranForm);
		model.addAttribute("saved", true);
		return ".AudCDE40TransReimbForm-index";
    }
    
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {
    	AuditTranForm form = audCDE40TransReimbFormManager.setupForm(id);
    	model.addAttribute("auditTranForm", form);
		return ".AudCDE40TransReimbForm-index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, HttpServletRequest request) {
    	audCDE40TransReimbFormManager.delete(AuditTran.class, id);
		return "redirect:" + RequestUtils.getContextPath(request) + "/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	List<AuditTran> auditTrans = audCDE40TransReimbFormManager.findAll(AuditTran.class);
    	model.addAttribute("auditTrans", auditTrans);
		return ".AudCDE40TransReimbForm-list";
    }
	
}