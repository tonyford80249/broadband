
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.validator.stateequal;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cdoe.ui.form.grid.ElectionItemGrid;
import com.cdoe.ui.form.stateequal.ElectionForm;

public class ElectionsDetailValidator implements Validator {

	private static final Logger logger = Logger.getLogger(ElectionsDetailValidator.class);
	
	@Override
	public boolean supports(Class clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ElectionForm form = (ElectionForm) target;
		boolean electionHeld = true;
		boolean categoryVoted = false;
		
		
		if (form.getDistrictCode() == null ||"".equals(form.getDistrictCode()) || "NONE".equalsIgnoreCase(form.getDistrictCode())) {
			errors.rejectValue("errorMessage", "String",  "Please select the district code for which the election is relevant");
			return;
		} else if (form.getFiscalYear() == null ||"".equals(form.getFiscalYear()) || "NONE".equalsIgnoreCase(form.getFiscalYear())) {
			errors.rejectValue("errorMessage", "String",  "Please select the fiscal year for which the election is relevant");
			return;
		}	
		
		if (form.getElectionHeld() != null	&& "false".equalsIgnoreCase(form.getElectionHeld())) {
			electionHeld = false;
	
		}
		List<ElectionItemGrid> electionItemGridList = form.getElectionItemGridList();
		for (ElectionItemGrid electionItem : electionItemGridList) {
			if (electionItem.getCategoryHeld() != null && "true".equalsIgnoreCase(electionItem.getCategoryHeld())) {
				categoryVoted = true;
				if (electionItem.getForVoteCount() == 0 || electionItem.getForVoteCount() == 0 || electionItem.getCategoryAmount() == 0) {
					errors.rejectValue("errorMessage", "category",  "Votes For, Votes Against and Amount cannot be zero if category is selected");
					return;
				}
			}
		}
		
		if (electionHeld == true && categoryVoted == false ) {
			errors.rejectValue("errorMessage", "String", "Atleast one category must be voted if election held is true for a district");
		} else	if ( electionHeld == false && categoryVoted == true ) {
			errors.rejectValue("errorMessage", "String", "No category can be voted if election held is false for a district");
				
		}
		
		
		
		if (form.getElectionHeld() == null && "".equals(form.getElectionHeld() )) {
			errors.rejectValue("errorMessage", "String",  "At least one option for 'Election' must be selected");
		}
		
	}

}