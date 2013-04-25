
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.transportation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.cdoe.biz.model.transportation.Prorate;
import com.cdoe.services.transportation.IDistributionAmountsManager;
import com.cdoe.ui.form.transportation.ProrateForm;
import com.resqsoft.util.RequestUtils;

@Controller
@RequestMapping("/secure/DistributionAmounts")
public class DistributionAmountsController {

	private static final Logger logger = Logger.getLogger(DistributionAmountsController.class);
	
	@Autowired
	private IDistributionAmountsManager distributionAmountsManager;
	
	@Autowired
	private Validator prorateValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
		String fiscalYear = (String)session.getAttribute("fiscalYear");
		ProrateForm form = distributionAmountsManager.setupForm(fiscalYear);
    	
    	model.addAttribute("prorateForm", form);
		return ".DistributionAmounts-index";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute ProrateForm prorateForm, BindingResult result, HttpServletRequest request) {
    	prorateValidator.validate(prorateForm, result);
		if (result.hasErrors()) {
			return ".DistributionAmounts-index";
		}
		if (request.getParameter("saveChanges") != null)
			distributionAmountsManager.saveOrUpdate(prorateForm);
		else if (request.getParameter("runFirstPayment") != null)
			distributionAmountsManager.runFirstPayment(prorateForm);
		else if (request.getParameter("runSecondPayment") != null)
			distributionAmountsManager.runSecondPayment(prorateForm);
		else if (request.getParameter("saveFundingSources") != null)
			distributionAmountsManager.updateProrateNote(prorateForm);
		
		model.addAttribute("saved", true);
		return ".DistributionAmounts-index";
    }
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {
    	ProrateForm form = distributionAmountsManager.setupForm(id);
    	model.addAttribute("prorateForm", form);
		return ".DistributionAmounts-index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, HttpServletRequest request) {
    	distributionAmountsManager.delete(Prorate.class, id);
		return "redirect:" + RequestUtils.getContextPath(request) + "/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	List<Prorate> prorates = distributionAmountsManager.findAll(Prorate.class);
    	model.addAttribute("prorates", prorates);
		return ".DistributionAmounts-list";
    }
	
}