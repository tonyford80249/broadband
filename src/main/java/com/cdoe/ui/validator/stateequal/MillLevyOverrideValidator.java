
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator.stateequal;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.stateequal.MillLevyOverrideForm;

public class MillLevyOverrideValidator implements Validator {

	private static final Logger logger = Logger.getLogger(MillLevyOverrideValidator.class);
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		MillLevyOverrideForm form = (MillLevyOverrideForm) target;
		if (form.getDistrictCode() == null ||"".equals(form.getDistrictCode()) || "NONE".equalsIgnoreCase(form.getDistrictCode())) {
			errors.rejectValue("errorMessage", "String",  "Please select the district code for Mill Levy Override Calculation");
		}
		
		if (form.getPropertyTaxYear() == null ||"".equals(form.getPropertyTaxYear()) || "NONE".equalsIgnoreCase(form.getPropertyTaxYear())) {
			errors.rejectValue("errorMessage", "String",  "Please select the Property Tax Year  for Mill Levy Override Calculation");
		}
		
	}

}