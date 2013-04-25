/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.cdoe.biz.model.jasper.MillLevyOverrideCalcDatasource;
import com.cdoe.biz.model.jasper.SeMillLevyOverrideDatasource;
import com.cdoe.services.stateequal.IMillLevyOverrideWorksheetManager;
import com.cdoe.ui.form.stateequal.MillLevyOverrideForm;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;

@Controller
@RequestMapping("/secure/MillLevyOverrideWorksheet")
public class MillLevyOverrideWorksheetController {

	private static final Logger logger = Logger
			.getLogger(MillLevyOverrideWorksheetController.class);

	@Autowired
	private IMillLevyOverrideWorksheetManager millLevyOverrideWorksheetManager;

	@Autowired
	MappingJacksonJsonView standardJsonView;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
		String fiscalYear = (String) session.getAttribute("fiscalYear");
		String districtCode = null;

		if (userInfo.isAdminUser()) {
			districtCode = userInfo.getAllDistrictCodes().get(0);
		} else {
			districtCode = userInfo.getUsersDistricts().get(0);
		}

		MillLevyOverrideForm form = millLevyOverrideWorksheetManager.setupForm(
				districtCode, fiscalYear);
		String districtName = userInfo.getDistrictMap().get(districtCode);
		form.setDistrictName(districtName);
		model.addAttribute("millLevyOverrideForm", form);
		initModelDropdowns(model, session);
		return ".MillLevyOverrideWorksheet-index";
	}

	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public ModelAndView retrieve(@RequestParam String districtNumber,
			@RequestParam String propertyTaxYear, HttpServletRequest request,
			@ModelAttribute MillLevyOverrideForm millLevyOverrideForm) {

		try {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
			if (districtNumber == null || "".equals(districtNumber)
					|| propertyTaxYear == null || "".equals(propertyTaxYear)) {
				millLevyOverrideForm.setErrorMessage("");
			}

			String districtName = userInfo.getDistrictMap().get(districtNumber);
			millLevyOverrideForm = millLevyOverrideWorksheetManager.setupForm(
					districtNumber, propertyTaxYear);
			millLevyOverrideForm.setDistrictName(districtName);
			parameterMap.put("millLevyOverrideForm", millLevyOverrideForm);
			return new ModelAndView(standardJsonView, parameterMap);
		} catch (Throwable t) {
			logger.error("Exception occurred during retrieve.", t);
		} finally {
			logger.info("generating json response ");
		}

		return null;
	}

	/*
	 * @method - Create the override Mill Levy report
	 */

	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public ModelAndView overrideCalcReport(Model model, @ModelAttribute MillLevyOverrideForm millLevyOverrideForm,HttpServletRequest request) {
		final String reportName = "millLevyOverrideCalc";
		final String format = "Pdf";
	
		try {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			SeMillLevyOverrideDatasource datasource = millLevyOverrideWorksheetManager.createDataSource(millLevyOverrideForm);
			parameterMap.put("customJRDatasource", datasource);
			String reportId = reportName + "Report" + format + "View";
			return new ModelAndView(reportId, parameterMap);

		} catch (Throwable t) {
			logger.error("Exception during Millevy report generation", t);
		}

		return null;
	}

	private void initModelDropdowns(Model model, HttpSession session) {
		UserInfo userInfo = (UserInfo) session
				.getAttribute(UserInfo.USER_INFO_ATTR);
		model.addAttribute("propertyTaxYearList",
				DateUtil.getShortYears(DateUtil.getCurrentFiscalYearShort(), 5));
		model.addAttribute("districtCodeList", userInfo.getAllDistrictCodes());
	}

	

}