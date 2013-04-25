
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
public class AuditBillingForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private List<AuditBillingGrid> auditBillingGridList = new ArrayList<AuditBillingGrid>();
	
	public List<AuditBillingGrid> getAuditBillingGridList() {
	    return this.auditBillingGridList;
	}
	
	private String userId; 
	
	public String getUserId () {
        return this.userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }
	private Date updateTimestamp; 
	
	public Date getUpdateTimestamp () {
        return this.updateTimestamp;
    }

    public void setUpdateTimestamp (Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
	private Double totalAllocationDifference; 
	
	public Double getTotalAllocationDifference () {
        return this.totalAllocationDifference;
    }

    public void setTotalAllocationDifference (Double totalAllocationDifference) {
        this.totalAllocationDifference = totalAllocationDifference;
    }
	private Double dailyRate; 
	
	public Double getDailyRate () {
        return this.dailyRate;
    }

    public void setDailyRate (Double dailyRate) {
        this.dailyRate = dailyRate;
    }
	private Double orgDays; 
	
	public Double getOrgDays () {
        return this.orgDays;
    }

    public void setOrgDays (Double orgDays) {
        this.orgDays = orgDays;
    }
	private Double orgTotalAllocation; 
	
	public Double getOrgTotalAllocation () {
        return this.orgTotalAllocation;
    }

    public void setOrgTotalAllocation (Double orgTotalAllocation) {
        this.orgTotalAllocation = orgTotalAllocation;
    }
	private Double auditDays; 
	
	public Double getAuditDays () {
        return this.auditDays;
    }

    public void setAuditDays (Double auditDays) {
        this.auditDays = auditDays;
    }
	private Double auditTotalAllocation; 
	
	public Double getAuditTotalAllocation () {
        return this.auditTotalAllocation;
    }

    public void setAuditTotalAllocation (Double auditTotalAllocation) {
        this.auditTotalAllocation = auditTotalAllocation;
    }
	private String organizationCode; 
	
	public String getOrganizationCode () {
        return this.organizationCode;
    }

    public void setOrganizationCode (String organizationCode) {
        this.organizationCode = organizationCode;
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
}