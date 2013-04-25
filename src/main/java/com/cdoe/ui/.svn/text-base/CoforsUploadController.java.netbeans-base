
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui;

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
import com.cdoe.services.ICoforsUploadManager;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.ui.form.transportation.TransportationForm;

@Controller
@RequestMapping("/secure/CoforsUpload")
public class CoforsUploadController {

	private static final Logger logger = Logger.getLogger(CoforsUploadController.class);
	
	@Autowired
	private ICoforsUploadManager coforsUploadManager;
	
	@Autowired
	private Validator transportationValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
    	TransportationForm form = coforsUploadManager.setupForm();
    	model.addAttribute("transportationForm", form);
		return ".CoforsUpload-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute TransportationForm transportationForm, BindingResult result, HttpServletRequest request) {
    	transportationValidator.validate(transportationForm, result);
		if (result.hasErrors()) {
			return ".CoforsUpload-index";
		}
		coforsUploadManager.saveOrUpdate(transportationForm);
		model.addAttribute("saved", true);
		return ".CoforsUpload-index";
    }
    
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {
    	TransportationForm form = coforsUploadManager.setupForm(id);
    	model.addAttribute("transportationForm", form);
		return ".CoforsUpload-index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, HttpServletRequest request) {
    	coforsUploadManager.delete(Transportation.class, id);
		return "redirect:" + RequestUtils.getContextPath(request) + "/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	List<Transportation> transportations = coforsUploadManager.findAll(Transportation.class);
    	model.addAttribute("transportations", transportations);
		return ".CoforsUpload-list";
    }
	
}