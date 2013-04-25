
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AdjustmentForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private Long adjustmentNumber;
	
	public Long getAdjustmentNumber () {
        return this.adjustmentNumber;
    }

    public void setAdjustmentNumber (Long adjustmentNumber) {
        this.adjustmentNumber = adjustmentNumber;
    }
	private String districtName;
	
	public String getDistrictName () {
        return this.districtName;
    }

    public void setDistrictName (String districtName) {
        this.districtName = districtName;
    }
	private String districtCode;
	
	public String getDistrictCode () {
        return this.districtCode;
    }

    public void setDistrictCode (String districtCode) {
        this.districtCode = districtCode;
    }
	private String active;
	
	public String getActive () {
        return this.active;
    }

    public void setActive (String active) {
        this.active = active;
    }
	private String begFiscalYear;
	
	public String getBegFiscalYear () {
        return this.begFiscalYear;
    }

    public void setBegFiscalYear (String begFiscalYear) {
        this.begFiscalYear = begFiscalYear;
    }
	private String begFiscalMonth;
	
	public String getBegFiscalMonth () {
        return this.begFiscalMonth;
    }

    public void setBegFiscalMonth (String begFiscalMonth) {
        this.begFiscalMonth = begFiscalMonth;
    }
	private String endFiscalYear;
	
	public String getEndFiscalYear () {
        return this.endFiscalYear;
    }

    public void setEndFiscalYear (String endFiscalYear) {
        this.endFiscalYear = endFiscalYear;
    }
	private String endFiscalMonth;
	
	public String getEndFiscalMonth () {
        return this.endFiscalMonth;
    }

    public void setEndFiscalMonth (String endFiscalMonth) {
        this.endFiscalMonth = endFiscalMonth;
    }
	private String frequency;
	
	public String getFrequency () {
        return this.frequency;
    }

    public void setFrequency (String frequency) {
        this.frequency = frequency;
    }
	private String adjustmentType;
	
	public String getAdjustmentType () {
        return this.adjustmentType;
    }

    public void setAdjustmentType (String adjustmentType) {
        this.adjustmentType = adjustmentType;
    }
	private Long amount;
	
	public Long getAmount () {
        return this.amount;
    }

    public void setAmount (Long amount) {
        this.amount = amount;
    }
	private String notes;
	
	public String getNotes () {
        return this.notes;
    }

    public void setNotes (String notes) {
        this.notes = notes;
    }
	private List<String> endFiscalMonthList = new ArrayList<String>();
	
	public List<String> getEndFiscalMonthList() {
        return this.endFiscalMonthList;
    }
	private List<String> endFiscalYearList = new ArrayList<String>();
	
	public List<String> getEndFiscalYearList() {
        return this.endFiscalYearList;
    }
	private List<String> districtCodeList = new ArrayList<String>();
	
	public List<String> getDistrictCodeList() {
        return this.districtCodeList;
    }
	private List<String> begFiscalYearList = new ArrayList<String>();
	
	public List<String> getBegFiscalYearList() {
        return this.begFiscalYearList;
    }
	private List<String> begFiscalMonthList = new ArrayList<String>();
	
	public List<String> getBegFiscalMonthList() {
        return this.begFiscalMonthList;
    }
	private List<String> frequencyList = new ArrayList<String>();
	
	public List<String> getFrequencyList() {
        return this.frequencyList;
    }
	private List<String> adjustmentTypeList = new ArrayList<String>();
	
	public List<String> getAdjustmentTypeList() {
        return this.adjustmentTypeList;
    }
}