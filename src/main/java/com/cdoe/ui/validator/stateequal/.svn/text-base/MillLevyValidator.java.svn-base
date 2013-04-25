
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator.stateequal;

import org.apache.log4j.Logger;

import com.resqsoft.util.StringUtils;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.stateequal.MillLevyForm;

public class MillLevyValidator implements Validator {

	private static final Logger logger = Logger.getLogger(MillLevyValidator.class);
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}
        

	@Override
	public void validate(Object target, Errors errors) {
		MillLevyForm form = (MillLevyForm) target;
                if (form.isApprovedFinal() && form.getEntrCompletedBy() == null) {
                 errors.rejectValue("entrCompletedBy", "float", "Value should be valid name");   
                }
                if (form.isApprovedFinal() && form.getEntrPhoneNumber() == null) {
                 errors.rejectValue("entrPhoneNumber", "float", "Value should be valid phone");   
                }
                
		if (form.getEntrGrossAssessed() == null || form.getEntrGrossAssessed() <= 0.0) {
			errors.rejectValue("entrGrossAssessed", "float", "Value should be valid amount");
		}
                if (form.getEntrNetAssessed() == null && form.getEntrNetAssessed() <= 0.0) {
			errors.rejectValue("entrNetAssessed", "float", "Value should be valid amount");
		}
                if (form.getEntrTaxincreament() == null) {
			errors.rejectValue("entrTaxincreament", "float", "Value should be valid amount");
		}
                if (form.getEntrAssessedAbatement() == null  || form.getEntrAssessedAbatement() < 0.0) {
			errors.rejectValue("entrAssessedAbatement", "float", "Value should be valid amount");
		}
              
                /**
                 * 
                 */
                if (form.getEntrBondRedemption() == null || form.getEntrBondRedemption() < 0.0) {
			errors.rejectValue("entrBondRedemption", "float", "Value should be valid amount");
		}
                
                if (form.getEntrKindergarten() == null || form.getEntrKindergarten() < 0.0) {
			errors.rejectValue("entrKindergarten", "float", "Value should be valid amount");
		}
                if (form.getEntrOther() == null || form.getEntrOther() < 0.0) {
			errors.rejectValue("entrOther", "float", "Value should be valid amount");
		}
                if (form.getEntrSpecialFund() == null || form.getEntrSpecialFund() < 0.0) {
			errors.rejectValue("entrSpecialFund", "float", "Value should be valid amount");
		}
                if (form.getEntrTransportationFund() == null || form.getEntrTransportationFund() < 0.0) {
			errors.rejectValue("entrTransportationFund", "float", "Value should be valid amount");
		}
                if (form.getEntrVoterApproved() == null || form.getEntrVoterApproved() < 0.0) {
			errors.rejectValue("entrVoterApproved", "float", "Value should be valid amount");
		}
		
	}

}