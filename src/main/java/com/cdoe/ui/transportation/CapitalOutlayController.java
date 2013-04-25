
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

import com.cdoe.biz.model.transportation.CapitalOutlay;
import com.cdoe.services.transportation.ICapitalOutlayManager;
import com.cdoe.ui.form.transportation.CapitalOutlayForm;
import com.resqsoft.util.RequestUtils;

@Controller
@RequestMapping("/secure/CapitalOutlay")
public class CapitalOutlayController {

	private static final Logger logger = Logger.getLogger(CapitalOutlayController.class);
	
	@Autowired
	private ICapitalOutlayManager capitalOutlayManager;
	
	@Autowired
	private Validator capitalOutlayValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		logger.debug ("Dist Name and Nos" + session.getAttribute("districtNos"));
		String districtNos = (String) session.getAttribute("districtNos");
		String preparerEmailId = (String) session.getAttribute("preparerEmailId");
		String preparerPhoneNos = (String) session.getAttribute("preparerPhoneNos");
		String preparerName = (String) session.getAttribute("preparerName");
		String districtName = (String) session.getAttribute("districtName");
    	CapitalOutlayForm form = capitalOutlayManager.setupForm(districtNos);
    	form.setPreparerEmailId(preparerEmailId);
    	form.setPreparerPhoneNos(preparerPhoneNos);
    	form.setPreparerName(preparerName);
    	form.setDistrictNumber(districtNos);
    	form.setDistrictName(districtName);
    	
    	model.addAttribute("capitalOutlayForm", form);
		return ".CapitalOutlay-index";
    }
    
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute CapitalOutlayForm capitalOutlayForm, BindingResult result, HttpServletRequest request) {
    	capitalOutlayValidator.validate(capitalOutlayForm, result);
		if (result.hasErrors()) {
			capitalOutlayForm.setMessage(result.getFieldError().getDefaultMessage());
			return ".CapitalOutlay-index";
		}
		capitalOutlayManager.saveOrUpdate(capitalOutlayForm);
		model.addAttribute("saved", true);
		capitalOutlayForm.setMessage("Capital Outlay Information saved successfully");
		return ".CapitalOutlay-index";
    }
    
	
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	List<CapitalOutlay> capitalOutlays = capitalOutlayManager.findAll(CapitalOutlay.class);
    	model.addAttribute("capitalOutlays", capitalOutlays);
		return ".CapitalOutlay-list";
    }
	
}