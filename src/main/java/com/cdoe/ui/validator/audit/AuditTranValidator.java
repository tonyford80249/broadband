
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator.audit;

import org.apache.log4j.Logger;

import com.resqsoft.util.StringUtils;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.audit.AuditFpcForm;

public class AuditTranValidator implements Validator {

	private static final Logger logger = Logger.getLogger(AuditTranValidator.class);
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		AuditFpcForm form = (AuditFpcForm) target;
		
	}

}