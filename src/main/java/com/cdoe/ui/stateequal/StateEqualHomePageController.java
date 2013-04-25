
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.IReferenceDataManager;
import com.cdoe.util.DateUtil;
@Controller
@RequestMapping("/secure/StateEqualHomePage")
public class StateEqualHomePageController {

	private static final Logger logger = Logger.getLogger(StateEqualHomePageController.class);
	
	@Autowired
	private IReferenceDataManager referenceDataManager;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
		String[] lastAndNextPaymentsMonthYear = {"January, 2013", "February, 2013"};
		try {
			lastAndNextPaymentsMonthYear = referenceDataManager.getLastAndNextPaymentsMonthYear();
			if(lastAndNextPaymentsMonthYear == null || lastAndNextPaymentsMonthYear[0] == null || "".equals(lastAndNextPaymentsMonthYear)) {
				//lastAndNextPaymentsMonthYear = new String[2];
				lastAndNextPaymentsMonthYear[0] = DateUtil.getFormattedDate("MMMM, yyyy");
				lastAndNextPaymentsMonthYear[1] = DateUtil.getFormattedDateNextMonth("MMMM, yyyy");
			}
		} catch (Exception e) {
			logger.debug("Error getting the last payment month information" +  e.getMessage());
			 lastAndNextPaymentsMonthYear[0] = "January, 2013";
			 lastAndNextPaymentsMonthYear[1] = "February, 2013";
		}
		model.addAttribute("lastAndNextPaymentsMonthYear" , lastAndNextPaymentsMonthYear);
		
		return ".StateEqualHomePage-index";
    }
	
}