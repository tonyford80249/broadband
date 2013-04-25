
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator.transportation;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.grid.TransportationGrid;

public class Cde40SummaryValidator implements Validator {

	private static final Logger logger = Logger.getLogger(Cde40SummaryValidator.class);
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
                
		TransportationGrid form = (TransportationGrid) target;
			
		if (form.getOperTran() == null || form.getOperTran() <= 0) {
			errors.rejectValue("operTran", "double", "Total Current Operating Expenditure should be greater than zero");
		}
		
		if (form.getPupilTran() == null || form.getPupilTran() <= 0) {
			errors.rejectValue("pupilTran", "integer", "Nos of Pupils transported  should be  greater than zero");
		}
		if (form.getRegDMiles() == null || form.getRegDMiles() <= 0) {
			errors.rejectValue("regDMiles", "double", "Reguler Miles value should be greater than zero");
		}
		if (form.getSchoolDays() == null || form.getSchoolDays() <= 0) {
			errors.rejectValue("schoolDays", "integer", "School days Value should be greater than zero");
		}
		
		if (form.getBoardTran() != null && form.getBoardTran() < 0) {
			errors.rejectValue("boardTran", "integer", "Boarding days cannot be less than zero");
		}
	
		if (form.getActMiles() == null || form.getActMiles() <= 0) {
			errors.rejectValue("actMiles", "double", "Actual Miles should be greater than zero");
		}
		if (form.getTotalMiles() == null || form.getTotalMiles() <= 0) {
			errors.rejectValue("totalMiles", "double", "Total Miles should be greater than zero");
		}
		
	
	}

}