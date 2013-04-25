/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.stateequal.ICalculateEntitlementsManager;
import com.cdoe.ui.form.stateequal.CalculateEntitlementsForm;
import com.cdoe.util.DateUtil;

@Controller
@RequestMapping("/secure/CalculateEntitlements")
public class CalculateEntitlementsController {

	private static final Logger logger = Logger
			.getLogger(CalculateEntitlementsController.class);

	@Autowired
	private IReferenceDataManager referenceDataManager;
	
	@Autowired
	private ICalculateEntitlementsManager calculateEntitlementManager;
	
	//@Autowired
	private Validator calculateEntitlementsValidator;
	
	static List<String> calculationType = new ArrayList<String>();
	static {
		
		calculationType.add("Monthly: July - November");
		calculationType.add("Mid-Year: December");
		calculationType.add("January");
		calculationType.add("Monthly: February - May");
		calculationType.add("End of Year Closeout - June");
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		CalculateEntitlementsForm calculateEntitlementsForm = new CalculateEntitlementsForm();
		initModelDropdowns(model, session);
		model.addAttribute("calculateEntitlementsForm",calculateEntitlementsForm);
		return ".CalculateEntitlements-index";
	}

	private void initModelDropdowns(Model model, HttpSession session) {
		// UserInfo userInfo = (UserInfo)
		// session.getAttribute(UserInfo.USER_INFO_ATTR);
		
		model.addAttribute("fiscalYearList",DateUtil.getShortYears(DateUtil.getCurrentFiscalYearShort(), 5));
		model.addAttribute("fiscalMonthList", DateUtil.getFullMonthList(false));
		model.addAttribute("calculationTypeDropdownList",calculationType);
	}

	@RequestMapping(value = "/calculateEntitlements", method = RequestMethod.POST)
	public String calculateEntitlements(Model model, @ModelAttribute CalculateEntitlementsForm calculateEntitlementsForm,	
										BindingResult result, HttpServletRequest request) {

		calculateEntitlementsValidator.validate(calculateEntitlementsForm, result);
		if (result.hasErrors()) {
			calculateEntitlementsForm.setMessage(result.getFieldError().getDefaultMessage());
			initModelDropdowns(model, request.getSession());
			model.addAttribute("calculateEntitlementsForm", calculateEntitlementsForm);
			return ".CalculateEntitlements-index";
		}
		logger.debug(calculateEntitlementsForm.getFiscalMonth());
		logger.debug(calculateEntitlementsForm.getFiscalYear());
		logger.debug(calculateEntitlementsForm.getCalculationType());
		String fiscalMonth = calculateEntitlementsForm.getFiscalMonth();
		String fiscalYear = calculateEntitlementsForm.getFiscalYear();
		try {
			if (calculateEntitlementsForm.getCalculationType().equals("January"))
				calculateEntitlementManager.processStateAverageFreeLunch(fiscalYear);
			else
				calculateEntitlementManager.calculateEntitlements(calculateEntitlementsForm);
		} catch (Exception e) {
			calculateEntitlementsForm.setMessage(" Processing Error " + e.getMessage());
		}
		initModelDropdowns(model, request.getSession());
		model.addAttribute("calculateEntitlements", true);
		return ".CalculateEntitlements-index";
	}

}