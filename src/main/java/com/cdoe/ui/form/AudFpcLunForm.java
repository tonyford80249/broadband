
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form;

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
public class AudFpcLunForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private String districtNumber;
	
	public String getDistrictNumber () {
        return this.districtNumber;
    }

    public void setDistrictNumber (String districtNumber) {
        this.districtNumber = districtNumber;
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
	private Long sNumber;
	
	public Long getSNumber () {
        return this.sNumber;
    }

    public void setSNumber (Long sNumber) {
        this.sNumber = sNumber;
    }
	private Long sFundedCnt;
	
	public Long getSFundedCnt () {
        return this.sFundedCnt;
    }

    public void setSFundedCnt (Long sFundedCnt) {
        this.sFundedCnt = sFundedCnt;
    }
	private Long sLunchCnt;
	
	public Long getSLunchCnt () {
        return this.sLunchCnt;
    }

    public void setSLunchCnt (Long sLunchCnt) {
        this.sLunchCnt = sLunchCnt;
    }
	private Long sOnlineCnt;
	
	public Long getSOnlineCnt () {
        return this.sOnlineCnt;
    }

    public void setSOnlineCnt (Long sOnlineCnt) {
        this.sOnlineCnt = sOnlineCnt;
    }
	private Long sFl18Cnt;
	
	public Long getSFl18Cnt () {
        return this.sFl18Cnt;
    }

    public void setSFl18Cnt (Long sFl18Cnt) {
        this.sFl18Cnt = sFl18Cnt;
    }
	private Long sFlK12Cnt;
	
	public Long getSFlK12Cnt () {
        return this.sFlK12Cnt;
    }

    public void setSFlK12Cnt (Long sFlK12Cnt) {
        this.sFlK12Cnt = sFlK12Cnt;
    }
	private Long sMem18Cnt;
	
	public Long getSMem18Cnt () {
        return this.sMem18Cnt;
    }

    public void setSMem18Cnt (Long sMem18Cnt) {
        this.sMem18Cnt = sMem18Cnt;
    }
	private Long sMemK12Cnt;
	
	public Long getSMemK12Cnt () {
        return this.sMemK12Cnt;
    }

    public void setSMemK12Cnt (Long sMemK12Cnt) {
        this.sMemK12Cnt = sMemK12Cnt;
    }
	private Long sCpkpCnt;
	
	public Long getSCpkpCnt () {
        return this.sCpkpCnt;
    }

    public void setSCpkpCnt (Long sCpkpCnt) {
        this.sCpkpCnt = sCpkpCnt;
    }
	private Long sFundedCntK;
	
	public Long getSFundedCntK () {
        return this.sFundedCntK;
    }

    public void setSFundedCntK (Long sFundedCntK) {
        this.sFundedCntK = sFundedCntK;
    }
	private String fiscalYear;
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
}