/**
 * 
 */
package com.cdoe.ui.validator.stateequal;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.stateequal.OtherStateShareAdjustmentsForm;

/**
 * @author dyn-8
 *
 */
public class OtherStateShareAdjustmentsValidator implements Validator {

	/**
	 * Default constructor
	 */
	public OtherStateShareAdjustmentsValidator() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return OtherStateShareAdjustmentsValidator.class.equals(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		OtherStateShareAdjustmentsForm form = (OtherStateShareAdjustmentsForm) target;
		if (form.getDistrictNumber() == null || form.getDistrictNumber().length() == 0 || "NONE".equals(form.getDistrictNumber())) {
			errors.rejectValue("districtNumber", "districtNumber", "District Code cannot be null");
		}
		if (form.getFiscalYear() == null || form.getFiscalYear().length() == 0) {
			errors.rejectValue("fiscalYear", "fiscalYear", "Fiscal Year cannot be null");
		}
		if (form.getMonth() == null || form.getMonth().length() == 0) {
			errors.rejectValue("month", "month", "Month cannot be null");
		}
		if (form.getAdjustmentType() == null || form.getAdjustmentType().length() == 0) {
			errors.rejectValue("adjustmentType", "adjustmentType", "Adjustment Type cannot be null");
		}
		if (form.getAmount() == null) {
			errors.rejectValue("amount", "amount", "Amount Cannot be null");
		}
	}

}
