package com.cdoe.ui.form.stateequal;

import java.util.ArrayList;
import java.util.List;

import com.cdoe.ui.form.grid.DisplayAdjustmentGrid;

/**
 * Java bean object representing a business entity which will be used by Spring
 * Form to pass data to and from the view, controller, and service layer.
 * 
 */
public class MonthlyPaymentsForm {

	public MonthlyPaymentsForm() {
		super();

	}

	private String fiscalYear;

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	private String fiscalMonth;
	public String getFiscalMonth() {
		return fiscalMonth;
	}

	public void setFiscalMonth(String fiscalMonth) {
		this.fiscalMonth = fiscalMonth;
	}

	

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private List<String> districtCodeList = new ArrayList<String>();

	public List<String> getDistrictCodeList() {
		return this.districtCodeList;
	}

	private List<String> fiscalYearList = new ArrayList<String>();

	public List<String> getFiscalYearList() {
		return this.fiscalYearList;
	}

	private List<String> fiscalMonthList = new ArrayList<String>();

	public List<String> getFiscalMonthList() {
		return this.fiscalMonthList;
	}

}
