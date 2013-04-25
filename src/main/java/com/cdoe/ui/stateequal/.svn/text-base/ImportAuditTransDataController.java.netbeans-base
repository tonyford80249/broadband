
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

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

import com.cdoe.services.stateequal.IImportAuditTransDataManager;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.ui.form.transportation.TransportationForm;

@Controller
@RequestMapping("/secure/ImportAuditTransData")
public class ImportAuditTransDataController {

	private static final Logger logger = Logger.getLogger(ImportAuditTransDataController.class);
	
	@Autowired
	private IImportAuditTransDataManager importAuditTransDataManager;
	
	@Autowired
	private Validator transportationValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
    	TransportationForm form = importAuditTransDataManager.setupForm();
    	model.addAttribute("transportationForm", form);
		return ".ImportAuditTransData-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute TransportationForm transportationForm, BindingResult result, HttpServletRequest request) {
    	transportationValidator.validate(transportationForm, result);
		if (result.hasErrors()) {
			return ".ImportAuditTransData-index";
		}
		importAuditTransDataManager.saveOrUpdate(transportationForm);
		model.addAttribute("saved", true);
		return ".ImportAuditTransData-index";
    }
    
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {
    	TransportationForm form = importAuditTransDataManager.setupForm(id);
    	model.addAttribute("transportationForm", form);
		return ".ImportAuditTransData-index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, HttpServletRequest request) {
    	importAuditTransDataManager.delete(Transportation.class, id);
		return "redirect:" + RequestUtils.getContextPath(request) + "/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	List<Transportation> transportations = importAuditTransDataManager.findAll(Transportation.class);
    	model.addAttribute("transportations", transportations);
		return ".ImportAuditTransData-list";
    }
	
}