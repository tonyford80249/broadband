
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator.transportation;

import org.apache.log4j.Logger;

import com.resqsoft.util.StringUtils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.transportation.ProrateForm;

public class ProrateValidator implements Validator {

	private static final Logger logger = Logger.getLogger(ProrateValidator.class);
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProrateForm form = (ProrateForm) target;
		if (form.getTotalFirstPayment() == null || form.getTotalFirstPayment() <= 0) {
			errors.rejectValue("totalFirstPayment", "double", "First Payment value should be greater than zero");
		}
		
		/*if (form.getTotalSecondPayment() == null || form.getTotalSecondPayment() <= 0) {
			errors.rejectValue("totalSecondPayment", "integer", "Value should be valid integer");
		}
		
		if (form.getTotalDistribution() == null || form.getTotalDistribution() <= 0) {
			errors.rejectValue("totalDistribution", "integer", "Value should be valid integer");
		}*/
		
	}

}