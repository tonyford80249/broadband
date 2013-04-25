package com.cdoe.ui.form.grid;

import org.springframework.format.annotation.NumberFormat;

/**
 * Java bean object serves as a data container to hold values for the DataGrid.
 */
public class DisplayAdjustmentGrid {
	
	private Long id;
	private String districtCode;
	private String districtName;
	private String adjustmentType;
	private String frequency;
	private String beginFiscalYearMonth;
	private String endFiscalYearMonth;
    @NumberFormat(pattern="###,###,###.00")
	private Double amount;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public String getAdjustmentType() {
		return adjustmentType;
	}
	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}
	
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	public String getBeginFiscalYearMonth() {
		return beginFiscalYearMonth;
	}
	public void setBeginFiscalYearMonth(String beginFiscalYearMonth) {
		this.beginFiscalYearMonth = beginFiscalYearMonth;
	}
	
	public String getEndFiscalYearMonth() {
		return endFiscalYearMonth;
	}
	public void setEndFiscalYearMonth(String endFiscalYearMonth) {
		this.endFiscalYearMonth = endFiscalYearMonth;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
