
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator.transportation;

import org.apache.log4j.Logger;

import com.resqsoft.util.StringUtils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.transportation.TransportationForm;

public class TransportationValidator implements Validator {

	private static final Logger logger = Logger.getLogger(TransportationValidator.class);
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		TransportationForm form = (TransportationForm) target;
		if (form.getNetCurrentOperExpend() == null || form.getNetCurrentOperExpend() <= 0) {
			errors.rejectValue("netCurrentOperExpend", "integer", "Net Current Operating Expenditure should be valid integer");
		}
		
		if (form.getPupilTran() == null || form.getPupilTran() <= 0) {
			errors.rejectValue("pupilTran", "integer", "Value should be valid integer");
		}
		if (form.getRegDMiles() == null || form.getRegDMiles() <= 0) {
			errors.rejectValue("regDMiles", "integer", "Value should be valid integer");
		}
		if (form.getRegDays() == null || form.getRegDays() <= 0) {
			errors.rejectValue("regDays", "integer", "The nos of school days should be greater than zero");
		}
		if (form.getTotalReimMileage() == null || form.getTotalReimMileage() <= 0) {
			errors.rejectValue("totalReimMileage", "integer", "Total Mileage should be greater than 0");
		}
		if (form.getMileageEntitlement() == null || form.getMileageEntitlement() <= 0) {
			errors.rejectValue("mileageEntitlement", "integer", "Value should be valid integer");
		}
		if (form.getExCosts() == null || form.getExCosts() <= 0) {
			errors.rejectValue("exCosts", "integer", "Value should be valid integer");
		}
		if (form.getExReim() == null || form.getExReim() <= 0) {
			errors.rejectValue("exReim", "integer", "Value should be valid integer");
		}
		if (form.getMaxReimEntitlement() == null || form.getMaxReimEntitlement() <= 0) {
			errors.rejectValue("maxReimEntitlement", "integer", "Value should be valid integer");
		}
		if (form.getReimTran() == null || form.getReimTran() <= 0) {
			errors.rejectValue("reimTran", "integer", "Value should be valid integer");
		}
		if (form.getReimTranLy() == null || form.getReimTranLy() <= 0) {
			errors.rejectValue("reimTranLy", "integer", "Value should be valid integer");
		}
		if (form.getBoardTran() == null || form.getBoardTran() < 0) {
			errors.rejectValue("boardTran", "integer", "Value should be valid integer");
		}
		if (form.getTotalReimEntitlement() == null || form.getTotalReimEntitlement() <= 0) {
			errors.rejectValue("totalReimEntitlement", "integer", "Value should be valid integer");
		}
		
		if (form.getFinalReimEntitlement() == null || form.getFinalReimEntitlement() <= 0) {
			errors.rejectValue("finalReimEntitlement", "integer", "Value should be valid integer");
		}
		if (form.getFinalReimProrated() == null || form.getFinalReimProrated() <= 0) {
			errors.rejectValue("finalReimProrated", "integer", "Value should be valid integer");
		}
		if (form.getAdvPay() == null || form.getAdvPay() <= 0) {
			errors.rejectValue("advPay", "integer", "Value should be valid integer");
		}
		if (form.getDesegReim() == null || form.getDesegReim() <= 0) {
			errors.rejectValue("desegReim", "integer", "Value should be valid integer");
		}
		if (form.getDistrictDistribution() == null || form.getDistrictDistribution() <= 0) {
			errors.rejectValue("districtDistribution", "integer", "Value should be valid integer");
		}
		if (form.getActMiles() == null || form.getActMiles() <= 0) {
			errors.rejectValue("actMiles", "integer", "Value should be valid integer");
		}
		if (form.getTotalMiles() == null || form.getTotalMiles() <= 0) {
			errors.rejectValue("totalMiles", "integer", "Value should be valid integer");
		}
		
	}

}