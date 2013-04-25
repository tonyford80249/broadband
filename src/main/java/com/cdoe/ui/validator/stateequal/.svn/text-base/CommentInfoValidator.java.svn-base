
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator.stateequal;

import org.apache.log4j.Logger;

import com.resqsoft.util.StringUtils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.stateequal.CommentInfoForm;

public class CommentInfoValidator implements Validator {

	private static final Logger logger = Logger.getLogger(CommentInfoValidator.class);
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		CommentInfoForm form = (CommentInfoForm) target;
		if (form.getDistrictCode() == null ||"".equals(form.getDistrictCode()) || "NONE".equalsIgnoreCase(form.getDistrictCode())) {
			errors.rejectValue("errorMessage", "String",  "Please select the district code for which the message is relevant");
			return;
		}
		
		if (form.getFiscalYear() == null ||"".equals(form.getFiscalYear()) || "NONE".equalsIgnoreCase(form.getFiscalYear())) {
			errors.rejectValue("errorMessage", "String",  "Please select the fiscal year for which the message is relevant");
		
		}
		
	}

}