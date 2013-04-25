package com.cdoe.ui.form.stateequal;

import org.springframework.format.annotation.NumberFormat;

/**
 * Java Bean backing the 2nd form for Enter/Update Other State Share Adjustemnts
 * @author dyn-8
 *
 */
public class OtherStateShareAdjustmentsForm {
	
	private Long id;
	private String districtNumber; 
	private String fiscalYear;
	private String month;
	private String adjustmentType;
	private String adjustmentNotes;
    @NumberFormat(pattern="###,###.00")
	private Double amount;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDistrictNumber() {
		return districtNumber;
	}
	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getAdjustmentType() {
		return adjustmentType;
	}
	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}
	public String getAdjustmentNotes() {
		return adjustmentNotes;
	}
	public void setAdjustmentNotes(String adjustmentNotes) {
		this.adjustmentNotes = adjustmentNotes;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
