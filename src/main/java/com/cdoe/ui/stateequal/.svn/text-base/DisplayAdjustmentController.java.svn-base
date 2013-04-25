
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.stateequal.IDisplayAdjustmentManager;
import com.cdoe.ui.form.stateequal.DisplayAdjustmentForm;
import com.cdoe.ui.validator.stateequal.DisplayAdjustmentsValidator;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;

@Controller
@RequestMapping("/secure/DisplayAdjustment")
public class DisplayAdjustmentController {

	private static final Logger logger = Logger.getLogger(DisplayAdjustmentController.class);
	
	@Autowired
	private IDisplayAdjustmentManager displayAdjustmentManager;
	@Autowired
	private IReferenceDataManager referenceDataManager;
	@Autowired
	private DisplayAdjustmentsValidator displayAdjustmentsValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
    	DisplayAdjustmentForm form = displayAdjustmentManager.setupForm();
    	initModelDropdowns(model, session);
    	model.addAttribute("displayAdjustmentForm", form);
		return ".DisplayAdjustment-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute DisplayAdjustmentForm form, BindingResult result, HttpSession session) {
		displayAdjustmentsValidator.validate(form, result);
		if (result.hasErrors()) {
			model.addAttribute("message", "Error in search criteria - please correct and re-try");
		} else {
			form = displayAdjustmentManager.getAdjustments(form);
			if (form.getDisplayAdjustmentGridList() == null || form.getDisplayAdjustmentGridList().size() < 1) {
				model.addAttribute("message", "Data not found");
			}
		}
		initModelDropdowns(model, session);
		return ".DisplayAdjustment-index";
    }
    
	private void initModelDropdowns(Model model, HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
		List<String> districtCodes = userInfo.getAllDistrictCodes();
		districtCodes.add(0, "ALL");
		model.addAttribute("districtCodeNameDropdownList", districtCodes);
		model.addAttribute("fiscalYearList", DateUtil.getShortYears(DateUtil.getCurrentFiscalYearShort(), 5));
		model.addAttribute("fiscalMonthList", DateUtil.getFullMonthList(false));
		List<String> adjustments = referenceDataManager.getStateEqualAdjustments();
		adjustments.add(0, "ALL");
		adjustments.add("AUDIT");
		model.addAttribute("adjustmentTypeList", adjustments);
	}
}