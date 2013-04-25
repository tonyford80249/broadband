
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator;

import org.apache.log4j.Logger;

import com.resqsoft.util.StringUtils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.VDataForm;

public class VDataValidator implements Validator {

	private static final Logger logger = Logger.getLogger(VDataValidator.class);
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		VDataForm form = (VDataForm) target;
		if (form.getVNumber() == null || form.getVNumber() <= 0) {
			errors.rejectValue("vNumber", "integer", "Value should be valid integer");
		}
		
	}

}