
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.stateequal;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.cdoe.ui.form.grid.*;

/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class CsiForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private String csiKindFteCnt;
	
	public String getCsiKindFteCnt () {
        return this.csiKindFteCnt;
    }

    public void setCsiKindFteCnt (String csiKindFteCnt) {
        this.csiKindFteCnt = csiKindFteCnt;
    }
	private String csiCppCnt;
	
	public String getCsiCppCnt () {
        return this.csiCppCnt;
    }

    public void setCsiCppCnt (String csiCppCnt) {
        this.csiCppCnt = csiCppCnt;
    }
	private String districtNumber;
	
	public String getDistrictNumber () {
        return this.districtNumber;
    }

    public void setDistrictNumber (String districtNumber) {
        this.districtNumber = districtNumber;
    }
	private String csiNumber;
	
	public String getCsiNumber () {
        return this.csiNumber;
    }

    public void setCsiNumber (String csiNumber) {
        this.csiNumber = csiNumber;
    }
	private String dateChanged;
	
	public String getDateChanged () {
        return this.dateChanged;
    }

    public void setDateChanged (String dateChanged) {
        this.dateChanged = dateChanged;
    }
	private String changeType;
	
	public String getChangeType () {
        return this.changeType;
    }

    public void setChangeType (String changeType) {
        this.changeType = changeType;
    }
	private String csiK12FteCnt;
	
	public String getCsiK12FteCnt () {
        return this.csiK12FteCnt;
    }

    public void setCsiK12FteCnt (String csiK12FteCnt) {
        this.csiK12FteCnt = csiK12FteCnt;
    }
	private String csiSupplementalK;
	
	public String getCsiSupplementalK () {
        return this.csiSupplementalK;
    }

    public void setCsiSupplementalK (String csiSupplementalK) {
        this.csiSupplementalK = csiSupplementalK;
    }
	private String csiOnlineCnt;
	
	public String getCsiOnlineCnt () {
        return this.csiOnlineCnt;
    }

    public void setCsiOnlineCnt (String csiOnlineCnt) {
        this.csiOnlineCnt = csiOnlineCnt;
    }
	private String csiFl18Cnt;
	
	public String getCsiFl18Cnt () {
        return this.csiFl18Cnt;
    }

    public void setCsiFl18Cnt (String csiFl18Cnt) {
        this.csiFl18Cnt = csiFl18Cnt;
    }
	private String csiFlK12Cnt;
	
	public String getCsiFlK12Cnt () {
        return this.csiFlK12Cnt;
    }

    public void setCsiFlK12Cnt (String csiFlK12Cnt) {
        this.csiFlK12Cnt = csiFlK12Cnt;
    }
	private String csiMem18Cnt;
	
	public String getCsiMem18Cnt () {
        return this.csiMem18Cnt;
    }

    public void setCsiMem18Cnt (String csiMem18Cnt) {
        this.csiMem18Cnt = csiMem18Cnt;
    }
	private String csiMemK12Cnt;
	
	public String getCsiMemK12Cnt () {
        return this.csiMemK12Cnt;
    }

    public void setCsiMemK12Cnt (String csiMemK12Cnt) {
        this.csiMemK12Cnt = csiMemK12Cnt;
    }
	private String csiAscentCnt;
	
	public String getCsiAscentCnt () {
        return this.csiAscentCnt;
    }

    public void setCsiAscentCnt (String csiAscentCnt) {
        this.csiAscentCnt = csiAscentCnt;
    }
	private String fiscalYear;
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
	private List<String> districtNumberList = new ArrayList<String>();
	
	public List<String> getDistrictNumberList() {
        return this.districtNumberList;
    }
    
}