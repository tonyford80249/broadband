
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator;

import org.apache.log4j.Logger;

import com.resqsoft.util.StringUtils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.ReportForm;
import com.cdoe.ui.form.VDataForm;

public class ReportViewPrintValidator implements Validator {

	private static final Logger logger = Logger.getLogger(ReportViewPrintValidator.class);
        
        private static final String DEFAULT_MESSAGE = "You must select the month and year the report is going to be generated for.";
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ReportForm form = (ReportForm) target;
                
		if (form.getReports() == null || form.getReports().isEmpty()) {                       
	          errors.rejectValue("reports", "integer", "You must select at least one report to be generated.");
		}
                if (form.getMonth() == null) {
                  errors.rejectValue("month", "integer", DEFAULT_MESSAGE);  
                }
                if (form.getYear() == null) {
                  errors.rejectValue("year", "integer", DEFAULT_MESSAGE);  
                }
		
	}

}