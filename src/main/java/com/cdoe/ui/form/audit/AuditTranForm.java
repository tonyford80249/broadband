
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.audit;

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
public class AuditTranForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private Integer auditId; 
	
	public Integer getAuditId () {
        return this.auditId;
    }

    public void setAuditId (Integer auditId) {
        this.auditId = auditId;
    }
	private String fiscalYear; 
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
	private Double totalMiles; 
	
	public Double getTotalMiles () {
        return this.totalMiles;
    }

    public void setTotalMiles (Double totalMiles) {
        this.totalMiles = totalMiles;
    }
	private Double actMiles; 
	
	public Double getActMiles () {
        return this.actMiles;
    }

    public void setActMiles (Double actMiles) {
        this.actMiles = actMiles;
    }
	private Double advPay; 
	
	public Double getAdvPay () {
        return this.advPay;
    }

    public void setAdvPay (Double advPay) {
        this.advPay = advPay;
    }
	private Double reimAdvPay; 
	
	public Double getReimAdvPay () {
        return this.reimAdvPay;
    }

    public void setReimAdvPay (Double reimAdvPay) {
        this.reimAdvPay = reimAdvPay;
    }
	private Double advPayLy; 
	
	public Double getAdvPayLy () {
        return this.advPayLy;
    }

    public void setAdvPayLy (Double advPayLy) {
        this.advPayLy = advPayLy;
    }
	private Double reimTranLy; 
	
	public Double getReimTranLy () {
        return this.reimTranLy;
    }

    public void setReimTranLy (Double reimTranLy) {
        this.reimTranLy = reimTranLy;
    }
	private Double reimTran; 
	
	public Double getReimTran () {
        return this.reimTran;
    }

    public void setReimTran (Double reimTran) {
        this.reimTran = reimTran;
    }
	private Double desegReim; 
	
	public Double getDesegReim () {
        return this.desegReim;
    }

    public void setDesegReim (Double desegReim) {
        this.desegReim = desegReim;
    }
	private Double exReim; 
	
	public Double getExReim () {
        return this.exReim;
    }

    public void setExReim (Double exReim) {
        this.exReim = exReim;
    }
	private Long boardTran; 
	
	public Long getBoardTran () {
        return this.boardTran;
    }

    public void setBoardTran (Long boardTran) {
        this.boardTran = boardTran;
    }
	private Long regMiles; 
	
	public Long getRegMiles () {
        return this.regMiles;
    }

    public void setRegMiles (Long regMiles) {
        this.regMiles = regMiles;
    }
	private Long schoolDays; 
	
	public Long getSchoolDays () {
        return this.schoolDays;
    }

    public void setSchoolDays (Long schoolDays) {
        this.schoolDays = schoolDays;
    }
	private Long pupilTran; 
	
	public Long getPupilTran () {
        return this.pupilTran;
    }

    public void setPupilTran (Long pupilTran) {
        this.pupilTran = pupilTran;
    }
	private Double operTran; 
	
	public Double getOperTran () {
        return this.operTran;
    }

    public void setOperTran (Double operTran) {
        this.operTran = operTran;
    }
	private Long indCont; 
	
	public Long getIndCont () {
        return this.indCont;
    }

    public void setIndCont (Long indCont) {
        this.indCont = indCont;
    }
	private Double capOutTran; 
	
	public Double getCapOutTran () {
        return this.capOutTran;
    }

    public void setCapOutTran (Double capOutTran) {
        this.capOutTran = capOutTran;
    }
	private Double migMiles; 
	
	public Double getMigMiles () {
        return this.migMiles;
    }

    public void setMigMiles (Double migMiles) {
        this.migMiles = migMiles;
    }
	private Double regDMiles; 
	
	public Double getRegDMiles () {
        return this.regDMiles;
    }

    public void setRegDMiles (Double regDMiles) {
        this.regDMiles = regDMiles;
    }
	private String changeType; 
	
	public String getChangeType () {
        return this.changeType;
    }

    public void setChangeType (String changeType) {
        this.changeType = changeType;
    }
	private String dateChanged; 
	
	public String getDateChanged () {
        return this.dateChanged;
    }

    public void setDateChanged (String dateChanged) {
        this.dateChanged = dateChanged;
    }
	private String districtNumber; 
	
	public String getDistrictNumber () {
        return this.districtNumber;
    }

    public void setDistrictNumber (String districtNumber) {
        this.districtNumber = districtNumber;
    }
}