package com.cdoe.ui;

import com.cdoe.ui.view.GenericExcelView;
import com.cdoe.ui.view.GenericlPdfView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 * 
 * @author Tony Ford
 */
@Controller
public class DynamicExcelDownload implements ApplicationContextAware {
	private static final Logger LOGGER = Logger
			.getLogger(DynamicExcelDownload.class);
	private static final String SEPARATOR = "/";

	private ApplicationContext applicationContext;

	/**
     * 
     */
	public DynamicExcelDownload() {
	}

	/**
	 * A more generic and dynamic form of report2 that requires less code to
	 * implement a report.
	 * 
	 * @param title
	 * @param reportId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dynamic/report/monthlypayment/{year}/{month}/{reportName}.{reportFormat}", method = RequestMethod.GET)
	public ModelAndView report1(@PathVariable("year") String year,
			@PathVariable("month") String month,
			@PathVariable("reportName") String reportName,
			@PathVariable("reportFormat") String reportFormat, Model model) {
		final String REPORT_LOCATION = "/WEB-INF/upload/staging/payment/";

		if ("xls".equalsIgnoreCase(reportFormat)) {
			GenericExcelView dynamicView = (GenericExcelView) this.applicationContext
					.getBean("xceldocument");

			dynamicView.setUrl(REPORT_LOCATION + year + SEPARATOR + month
					+ SEPARATOR + reportName);

			dynamicView.setReportName(reportName);

			return new ModelAndView(dynamicView, model.asMap());
		} else {
			GenericlPdfView dynamicView = (GenericlPdfView) this.applicationContext
					.getBean("pdfdocument");

			dynamicView.setUrl(REPORT_LOCATION + year + SEPARATOR + month
					+ SEPARATOR + reportName);

			dynamicView.setReportName(reportName);

			return new ModelAndView(dynamicView, model.asMap());
		}

	}

	/**
	 * A more generic and dynamic form of report2 that requires less code to
	 * implement a report.
	 * 
	 * @param title
	 * @param reportId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dynamic/report/monthlycomparison/{year}/{month}/{reportName}.{reportFormat}", method = RequestMethod.GET)
	public ModelAndView report2(@PathVariable("year") String year,
			@PathVariable("month") String month,
			@PathVariable("reportName") String reportName,
			@PathVariable("reportFormat") String reportFormat, Model model) {
		final String REPORT_LOCATION = "/WEB-INF/upload/staging/comparison/";

		if ("xls".equalsIgnoreCase(reportFormat)) {
			GenericExcelView dynamicView = (GenericExcelView) this.applicationContext
					.getBean("xceldocument");

			dynamicView.setUrl(REPORT_LOCATION + year + SEPARATOR + month
					+ SEPARATOR + reportName);

			dynamicView.setReportName(reportName);

			return new ModelAndView(dynamicView, model.asMap());
		} else {
			GenericlPdfView dynamicView = (GenericlPdfView) this.applicationContext
					.getBean("pdfdocument");

			dynamicView.setUrl(REPORT_LOCATION + year + SEPARATOR + month
					+ SEPARATOR + reportName);

			dynamicView.setReportName(reportName);

			return new ModelAndView(dynamicView, model.asMap());
		}

	}

	/**
	 * A more generic and dynamic form of report2 that requires less code to
	 * implement a report.
	 * 
	 * @param title
	 * @param reportId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dynamic/report/statewide/{year}/{month}/{reportName}.{reportFormat}", method = RequestMethod.GET)
	public ModelAndView report3(@PathVariable("year") String year,
			@PathVariable("month") String month,
			@PathVariable("reportName") String reportName,
			@PathVariable("reportFormat") String reportFormat, Model model) {
		final String REPORT_LOCATION = "/WEB-INF/upload/staging/statewide/";

		if ("xls".equalsIgnoreCase(reportFormat)) {
			GenericExcelView dynamicView = (GenericExcelView) this.applicationContext
					.getBean("xceldocument");

			dynamicView.setUrl(REPORT_LOCATION + year + SEPARATOR + month
					+ SEPARATOR + reportName);

			dynamicView.setReportName(reportName);

			return new ModelAndView(dynamicView, model.asMap());
		} else {
			GenericlPdfView dynamicView = (GenericlPdfView) this.applicationContext
					.getBean("pdfdocument");

			dynamicView.setUrl(REPORT_LOCATION + year + SEPARATOR + month
					+ SEPARATOR + reportName);

			dynamicView.setReportName(reportName);

			return new ModelAndView(dynamicView, model.asMap());
		}

	}

	/**
	 * 
	 * @param applicationContext
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
