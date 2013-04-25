/**
 * 
 */
package com.cdoe.ui.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.stateequal.AuditRepaymentAdjustmentForm;
import com.cdoe.util.DateUtil;

/**
 * @author dyn-8
 *
 */
public class AuditRepaymentAdjustmentValidator implements Validator {

	/**
	 * Default Constructor
	 */
	public AuditRepaymentAdjustmentValidator() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return AuditRepaymentAdjustmentForm.class.equals(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		AuditRepaymentAdjustmentForm form = (AuditRepaymentAdjustmentForm) target;
		if (form.getDistrictNumber() == null || form.getDistrictNumber().length() == 0 || "NONE".equals(form.getDistrictNumber()) ) {
			errors.rejectValue("districtNumber",  "StringError" , "District Code cannot be null");
		}
		if (form.getBeginFiscalYear() == null || form.getBeginFiscalYear().length() == 0) {
			errors.rejectValue("beginFiscalYear",  "StringError" , "Begin Fiscal Year cannot be null");
		}
		if (form.getBeginFiscalMonth() == null || form.getBeginFiscalMonth().length() == 0) {
			errors.rejectValue("beginFiscalMonth",  "StringError" , "Begin Fiscal Month cannot be null");
		}
		if (form.getEndFiscalYear() == null || form.getEndFiscalYear().length() == 0) {
			errors.rejectValue("endFiscalYear",  "StringError", "End Fiscal Year cannot be null");
		}
		if (form.getEndFiscalMonth() == null || form.getEndFiscalMonth().length() == 0) {
			errors.rejectValue("endFiscalMonth",  "StringError", "End Fiscal Month cannot be null");
		}
		if (form.getFrequency() == null || form.getFrequency().length() == 0) {
			errors.rejectValue("frequency",  "StringError", "Frequency cannot be null");
		}
		if (form.getAmount() == null || form.getAmount() <= 0) {
			errors.rejectValue("amount",  "StringError" , "Amount cannot be null or less than or equal to 0");
		}
		
		try {
			if (compareIntegerStrings(form.getBeginFiscalYear(), form.getEndFiscalYear())  ) {
				errors.rejectValue("beginFiscalYear", "Begin Fiscal Year cannot be  greater than ending fiscal year");
			} else if (form.getBeginFiscalYear().equals(form.getEndFiscalYear())) {
				String beginMonthNos = DateUtil.getMonthNos(form.getBeginFiscalMonth());
				String endMonthNos = DateUtil.getMonthNos(form.getEndFiscalMonth());
				if (compareIntegerStrings(beginMonthNos,  endMonthNos)){
					errors.rejectValue("beginFiscalMonth", "StringError" ,"Begin Fiscal Month cannot be earlier than End Fiscal Month if Begin and End Fiscal Year are same");
				}
			}
		} catch (Exception e) {
			errors.rejectValue("endFiscalYear", "Begin Fiscal Month/Year could not be compared with End Fiscal Year/Month");
			
		}
		
		
		
	}
	
	private boolean compareIntegerStrings(String int1, String int2) throws Exception {
		boolean result;
		
		int firstInteger = Integer.parseInt(int1);
		int secondInteger = Integer.parseInt(int2);
		return result = (firstInteger > secondInteger) ? true : false;
	}

}
