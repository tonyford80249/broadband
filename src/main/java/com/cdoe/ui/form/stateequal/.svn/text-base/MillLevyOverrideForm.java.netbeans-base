
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.stateequal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.NumberFormat;

import com.cdoe.ui.form.grid.CommentInfoGrid;

/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class MillLevyOverrideForm {
	
	
	private List<CommentInfoGrid> commentInfoGrid = new ArrayList<CommentInfoGrid>();

	private long id;
	private String districtCode;
	private String districtName;
	private String propertyTaxYear;
	private String fiscalMonth;
	
	@NumberFormat(pattern="###,###,###,###.##")
	private double grandTotalProg;
	@NumberFormat(pattern="###,###,###,###.##")
	private double costOfLiving;
	@NumberFormat(pattern="###,###,###,###.##")
	private double minOverrideAllowed;
	@NumberFormat(pattern="###,###,###,###.##")
	private double quarterOfTotalProg;
	@NumberFormat(pattern="###,###,###,###.##")
	private double totalOverrideAllowed;
	@NumberFormat(pattern="###,###,###,###.##")
	private double allowableOverride;
	@NumberFormat(pattern="###,###,###,###.##")
	private double propertyTaxRevenue;
	@NumberFormat(pattern="###,###,###,###.##")
	private double remainingBalance;
	
	
	
	@NumberFormat(pattern="###,###,###,###.##")
	private double holdHarmless;
	@NumberFormat(pattern="###,###,###,###.##")
	private double excessHoldHarmless;
	@NumberFormat(pattern="###,###,###,###.##")
	private double voterApprovedOverride;
	
	
	public double getHoldHarmless() {
		return holdHarmless;
	}

	public void setHoldHarmless(double holdHarmless) {
		this.holdHarmless = holdHarmless;
	}

	public double getExcessHoldHarmless() {
		return excessHoldHarmless;
	}

	public void setExcessHoldHarmless(double excessHoldHarmless) {
		this.excessHoldHarmless = excessHoldHarmless;
	}

	public double getVoterApprovedOverride() {
		return voterApprovedOverride;
	}

	public void setVoterApprovedOverride(double voterApprovedOverride) {
		this.voterApprovedOverride = voterApprovedOverride;
	}

	public void setPropertyTaxYearList(List<String> propertyTaxYearList) {
		this.propertyTaxYearList = propertyTaxYearList;
	}

	
	
	
	
	public List<CommentInfoGrid> getCommentInfoGrid() {
		return commentInfoGrid;
	}

	public void setCommentInfoGrid(List<CommentInfoGrid> commentInfoGrid) {
		this.commentInfoGrid = commentInfoGrid;
	}

	
	public double getMinOverrideAllowed() {
		return minOverrideAllowed;
	}

	public void setMinOverrideAllowed(double minOverrideAllowed) {
		this.minOverrideAllowed = minOverrideAllowed;
	}

	public double getTotalOverrideAllowed() {
		return totalOverrideAllowed;
	}

	public void setTotalOverrideAllowed(double totalOverrideAllowed) {
		this.totalOverrideAllowed = totalOverrideAllowed;
	}

	public double getAllowableOverride() {
		return allowableOverride;
	}

	public void setAllowableOverride(double allowableOverride) {
		this.allowableOverride = allowableOverride;
	}

	public double getPropertyTaxRevenue() {
		return propertyTaxRevenue;
	}

	public void setPropertyTaxRevenue(double propertyTaxRevenue) {
		this.propertyTaxRevenue = propertyTaxRevenue;
	}

	public double getRemainingBalance() {
		return remainingBalance;
	}

	public void setRemainingBalance(double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}

	
	
	
    public double getGrandTotalProg() {
		return grandTotalProg;
	}

	public void setGrandTotalProg(double grandTotalProg) {
		this.grandTotalProg = grandTotalProg;
	}

	public double getCostOfLiving() {
		return costOfLiving;
	}

	public void setCostOfLiving(double costOfLiving) {
		this.costOfLiving = costOfLiving;
	}

	public void setDistrictCodeList(List<String> districtCodeList) {
		this.districtCodeList = districtCodeList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	public String getPropertyTaxYear() {
		return propertyTaxYear;
	}
	public void setPropertyTaxYear(String propertyTaxYear) {
		this.propertyTaxYear = propertyTaxYear;
	}
	
	public String getFiscalMonth() {
		return fiscalMonth;
	}
	public void setFiscalMonth(String fiscalMonth) {
		this.fiscalMonth = fiscalMonth;
	}
	
	private List<String> districtCodeList = new ArrayList<String>();

	public List<String> getDistrictCodeList() {
		return this.districtCodeList;
	}
	
	private List<String> propertyTaxYearList = new ArrayList<String>();

	public List<String> getPropertyTaxYearList() {
		return this.propertyTaxYearList;
	}
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public double getQuarterOfTotalProg() {
		return quarterOfTotalProg;
	}
	

	public void setQuarterOfTotalProg(double quarterOfTotalProg) {
		this.quarterOfTotalProg = quarterOfTotalProg;
	}

	
}