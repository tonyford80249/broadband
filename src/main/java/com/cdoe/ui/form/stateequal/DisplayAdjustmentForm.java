package com.cdoe.ui.form.stateequal;

import java.util.ArrayList;
import java.util.List;

import com.cdoe.ui.form.grid.DisplayAdjustmentGrid;

/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 */
public class DisplayAdjustmentForm {
	
	private String districtCode;
	private String districtName;
	private String fiscalMonth;
	private String fiscalYear;
	private String adjustmentType;
	private List<DisplayAdjustmentGrid> displayAdjustmentGridList;
	
	public DisplayAdjustmentForm() {
		super();
		displayAdjustmentGridList = new ArrayList<DisplayAdjustmentGrid>();
	}
	
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getFiscalMonth() {
		return fiscalMonth;
	}
	public void setFiscalMonth(String fiscalMonth) {
		this.fiscalMonth = fiscalMonth;
	}
	
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	
	public String getAdjustmentType() {
		return adjustmentType;
	}
	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}
	
	public List<DisplayAdjustmentGrid> getDisplayAdjustmentGridList() {
		return displayAdjustmentGridList;
	}
	public void setDisplayAdjustmentGridList(
			List<DisplayAdjustmentGrid> displayAdjustmentGridList) {
		this.displayAdjustmentGridList = displayAdjustmentGridList;
	}
	
	

}
