
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator.stateequal;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.stateequal.CalculateEntitlementsForm;

public class CalculateEntitlementsValidator implements Validator {

	private static final Logger logger = Logger.getLogger(CalculateEntitlementsValidator.class);
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		CalculateEntitlementsForm form = (CalculateEntitlementsForm) target;
		if (form.getFiscalMonth() == null ||"".equals(form.getFiscalMonth()) || "NONE".equalsIgnoreCase(form.getFiscalMonth())) {
			errors.rejectValue("errorMessage", "String",  "Please select the month of Entitlement Calculation ");
			return;
		}
		
		if (form.getFiscalYear() == null ||"".equals(form.getFiscalYear()) || "NONE".equalsIgnoreCase(form.getFiscalYear())) {
			errors.rejectValue("errorMessage", "String",  "Please select the fiscal year  of Entitlement Calculation ");
		
		}
		
	}

}