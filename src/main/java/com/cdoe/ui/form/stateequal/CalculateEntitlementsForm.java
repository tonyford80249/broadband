package com.cdoe.ui.form.stateequal;

import java.util.ArrayList;
import java.util.List;

import com.cdoe.ui.form.grid.DisplayAdjustmentGrid;

/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 */
public class CalculateEntitlementsForm {
	
	
	private String fiscalYear;
	private String fiscalMonth;
	private String calculationType;
	private String message;
	

	public CalculateEntitlementsForm() {
		super();
		
	}
	
	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getFiscalMonth() {
		return fiscalMonth;
	}

	public void setFiscalMonth(String fiscalMonth) {
		this.fiscalMonth = fiscalMonth;
	}

	public String getCalculationType() {
		return calculationType;
	}

	public void setCalculationType(String calculationType) {
		this.calculationType = calculationType;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
		
	private List<String> calculationPeriodDropdownList = new ArrayList<String>();
	private List<String> fiscalYearList = new ArrayList<String>();
	private List<String> fiscalMonthList = new ArrayList<String>();
	private List<String> calculationTypeDropdownList = new ArrayList<String>();
	
	public List<String> getCalculationPeriodDropdownList() {
        return this.calculationPeriodDropdownList;
    }
	
	
	
	
	public List<String> getFiscalYearList() {
        return this.fiscalYearList;
    }
	
	
	public List<String> getFiscalMonthList() {
        return this.fiscalMonthList;
    }
	
	
	
	public List<String> getCalculationTypeDropdownList() {
        return this.calculationTypeDropdownList;
    }
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	

}
