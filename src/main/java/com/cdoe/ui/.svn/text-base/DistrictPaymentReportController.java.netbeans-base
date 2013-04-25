
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui;

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
import com.cdoe.services.stateequal.IDistrictPaymentReportManager;
import com.cdoe.ui.form.transportation.ProrateForm;
import com.cdoe.util.UserInfo;
import com.resqsoft.util.RequestUtils;

@Controller
@RequestMapping("/secure/DistrictPaymentReport")
public class DistrictPaymentReportController {

	private static final Logger logger = Logger.getLogger(DistrictPaymentReportController.class);
	
	@Autowired
	private IDistrictPaymentReportManager districtPaymentReportManager;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String fiscalYear =  (String) session.getAttribute("fiscalYear");
                UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
    	ProrateForm form = districtPaymentReportManager.setupForm(fiscalYear, userInfo);
    	model.addAttribute("prorateForm", form);
		return ".DistrictPaymentReport-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute ProrateForm prorateForm, BindingResult result, HttpServletRequest request) {
  		if (result.hasErrors()) {
			return ".DistrictPaymentReport-index";
	}
		
		
		
		
		
		
		
//		try {
//		districtPaymentReportManager.createDistrictReport("c://cdoe//PaymentReport.xls", prorateForm);
//		} catch (Exception e) {
//			System.out.println("Could not create DistrictPaymentReport");
//		}
		return ".DistrictPaymentReport-index";
    }
    
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {
    	ProrateForm form = districtPaymentReportManager.setupForm(id);
    	model.addAttribute("prorateForm", form);
		return ".DistrictPaymentReport-index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, HttpServletRequest request) {
    	districtPaymentReportManager.delete(Prorate.class, id);
		return "redirect:" + RequestUtils.getContextPath(request) + "/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	List<Prorate> prorates = districtPaymentReportManager.findAll(Prorate.class);
    	model.addAttribute("prorates", prorates);
		return ".DistrictPaymentReport-list";
    }
	
}