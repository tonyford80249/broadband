package com.cdoe.ui.validator.stateequal;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.stateequal.DisplayAdjustmentForm;

public class DisplayAdjustmentsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DisplayAdjustmentsValidator.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DisplayAdjustmentForm form = (DisplayAdjustmentForm) target;
		if (form.getDistrictCode() == null || form.getDistrictCode().contains("NONE")) {
			errors.rejectValue("districtCode", "District number cannot be null");
		}
	}

}
