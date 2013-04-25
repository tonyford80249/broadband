
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
public class FinanceForm {

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
	private Double ppOperRev;
	
	public Double getPpOperRev () {
        return this.ppOperRev;
    }

    public void setPpOperRev (Double ppOperRev) {
        this.ppOperRev = ppOperRev;
    }
	private Long bondRedMill;
	
	public Long getBondRedMill () {
        return this.bondRedMill;
    }

    public void setBondRedMill (Long bondRedMill) {
        this.bondRedMill = bondRedMill;
    }
	private Double sb184Mill;
	
	public Double getSb184Mill () {
        return this.sb184Mill;
    }

    public void setSb184Mill (Double sb184Mill) {
        this.sb184Mill = sb184Mill;
    }
	private Double overrideMill;
	
	public Double getOverrideMill () {
        return this.overrideMill;
    }

    public void setOverrideMill (Double overrideMill) {
        this.overrideMill = overrideMill;
    }
	private Double overrideAmt;
	
	public Double getOverrideAmt () {
        return this.overrideAmt;
    }

    public void setOverrideAmt (Double overrideAmt) {
        this.overrideAmt = overrideAmt;
    }
	private Double taxCredit;
	
	public Double getTaxCredit () {
        return this.taxCredit;
    }

    public void setTaxCredit (Double taxCredit) {
        this.taxCredit = taxCredit;
    }
	private Long abatements;
	
	public Long getAbatements () {
        return this.abatements;
    }

    public void setAbatements (Long abatements) {
        this.abatements = abatements;
    }
	private Double ommittedProp;
	
	public Double getOmmittedProp () {
        return this.ommittedProp;
    }

    public void setOmmittedProp (Double ommittedProp) {
        this.ommittedProp = ommittedProp;
    }
	private Long povertyCount;
	
	public Long getPovertyCount () {
        return this.povertyCount;
    }

    public void setPovertyCount (Long povertyCount) {
        this.povertyCount = povertyCount;
    }
	private Long smallAttendance;
	
	public Long getSmallAttendance () {
        return this.smallAttendance;
    }

    public void setSmallAttendance (Long smallAttendance) {
        this.smallAttendance = smallAttendance;
    }
	private Double lowIncomeFund;
	
	public Double getLowIncomeFund () {
        return this.lowIncomeFund;
    }

    public void setLowIncomeFund (Double lowIncomeFund) {
        this.lowIncomeFund = lowIncomeFund;
    }
	private Double recision;
	
	public Double getRecision () {
        return this.recision;
    }

    public void setRecision (Double recision) {
        this.recision = recision;
    }
	private Long adaMill;
	
	public Long getAdaMill () {
        return this.adaMill;
    }

    public void setAdaMill (Long adaMill) {
        this.adaMill = adaMill;
    }
	private String fiscalYear;
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
}