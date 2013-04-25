
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
public class AuditTrackingForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private List<NoNameGrid> noNameGridList = new ArrayList<NoNameGrid>();
	
	public List<NoNameGrid> getNoNameGridList() {
	    return this.noNameGridList;
	}
	
	private String supervisor; 
	
	public String getSupervisor () {
        return this.supervisor;
    }

    public void setSupervisor (String supervisor) {
        this.supervisor = supervisor;
    }
	private String secondaryAuditorComments; 
	
	public String getSecondaryAuditorComments () {
        return this.secondaryAuditorComments;
    }

    public void setSecondaryAuditorComments (String secondaryAuditorComments) {
        this.secondaryAuditorComments = secondaryAuditorComments;
    }
	private String finalizedBy; 
	
	public String getFinalizedBy () {
        return this.finalizedBy;
    }

    public void setFinalizedBy (String finalizedBy) {
        this.finalizedBy = finalizedBy;
    }
	private String reviewedBy; 
	
	public String getReviewedBy () {
        return this.reviewedBy;
    }

    public void setReviewedBy (String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }
	private Date reclosedAfterAppeal; 
	
	public Date getReclosedAfterAppeal () {
        return this.reclosedAfterAppeal;
    }

    public void setReclosedAfterAppeal (Date reclosedAfterAppeal) {
        this.reclosedAfterAppeal = reclosedAfterAppeal;
    }
	private Date auditRefinalized; 
	
	public Date getAuditRefinalized () {
        return this.auditRefinalized;
    }

    public void setAuditRefinalized (Date auditRefinalized) {
        this.auditRefinalized = auditRefinalized;
    }
	private Date auditReopened; 
	
	public Date getAuditReopened () {
        return this.auditReopened;
    }

    public void setAuditReopened (Date auditReopened) {
        this.auditReopened = auditReopened;
    }
	private Date auditClosed; 
	
	public Date getAuditClosed () {
        return this.auditClosed;
    }

    public void setAuditClosed (Date auditClosed) {
        this.auditClosed = auditClosed;
    }
	private Date reportAppealed; 
	
	public Date getReportAppealed () {
        return this.reportAppealed;
    }

    public void setReportAppealed (Date reportAppealed) {
        this.reportAppealed = reportAppealed;
    }
	private Date draftReportIssued; 
	
	public Date getDraftReportIssued () {
        return this.draftReportIssued;
    }

    public void setDraftReportIssued (Date draftReportIssued) {
        this.draftReportIssued = draftReportIssued;
    }
	private Date draftReportCompleted; 
	
	public Date getDraftReportCompleted () {
        return this.draftReportCompleted;
    }

    public void setDraftReportCompleted (Date draftReportCompleted) {
        this.draftReportCompleted = draftReportCompleted;
    }
	private Date initialFieldWorkCompleted; 
	
	public Date getInitialFieldWorkCompleted () {
        return this.initialFieldWorkCompleted;
    }

    public void setInitialFieldWorkCompleted (Date initialFieldWorkCompleted) {
        this.initialFieldWorkCompleted = initialFieldWorkCompleted;
    }
	private Date fieldWorkStarted; 
	
	public Date getFieldWorkStarted () {
        return this.fieldWorkStarted;
    }

    public void setFieldWorkStarted (Date fieldWorkStarted) {
        this.fieldWorkStarted = fieldWorkStarted;
    }
	private Date districtContacted; 
	
	public Date getDistrictContacted () {
        return this.districtContacted;
    }

    public void setDistrictContacted (Date districtContacted) {
        this.districtContacted = districtContacted;
    }
	private Double totalAuditLiability; 
	
	public Double getTotalAuditLiability () {
        return this.totalAuditLiability;
    }

    public void setTotalAuditLiability (Double totalAuditLiability) {
        this.totalAuditLiability = totalAuditLiability;
    }
	private Date reportFinalized; 
	
	public Date getReportFinalized () {
        return this.reportFinalized;
    }

    public void setReportFinalized (Date reportFinalized) {
        this.reportFinalized = reportFinalized;
    }
	private String primaryAuditorComments; 
	
	public String getPrimaryAuditorComments () {
        return this.primaryAuditorComments;
    }

    public void setPrimaryAuditorComments (String primaryAuditorComments) {
        this.primaryAuditorComments = primaryAuditorComments;
    }
	private String supervisorComments; 
	
	public String getSupervisorComments () {
        return this.supervisorComments;
    }

    public void setSupervisorComments (String supervisorComments) {
        this.supervisorComments = supervisorComments;
    }
	private String auditType; 
	
	public String getAuditType () {
        return this.auditType;
    }

    public void setAuditType (String auditType) {
        this.auditType = auditType;
    }
	private Date openDate; 
	
	public Date getOpenDate () {
        return this.openDate;
    }

    public void setOpenDate (Date openDate) {
        this.openDate = openDate;
    }
	private String fiscalYear5; 
	
	public String getFiscalYear5 () {
        return this.fiscalYear5;
    }

    public void setFiscalYear5 (String fiscalYear5) {
        this.fiscalYear5 = fiscalYear5;
    }
	private String fiscalYear4; 
	
	public String getFiscalYear4 () {
        return this.fiscalYear4;
    }

    public void setFiscalYear4 (String fiscalYear4) {
        this.fiscalYear4 = fiscalYear4;
    }
	private String fiscalYear3; 
	
	public String getFiscalYear3 () {
        return this.fiscalYear3;
    }

    public void setFiscalYear3 (String fiscalYear3) {
        this.fiscalYear3 = fiscalYear3;
    }
	private String fiscalYear2; 
	
	public String getFiscalYear2 () {
        return this.fiscalYear2;
    }

    public void setFiscalYear2 (String fiscalYear2) {
        this.fiscalYear2 = fiscalYear2;
    }
	private String fiscalYear1; 
	
	public String getFiscalYear1 () {
        return this.fiscalYear1;
    }

    public void setFiscalYear1 (String fiscalYear1) {
        this.fiscalYear1 = fiscalYear1;
    }
	private String alert; 
	
	public String getAlert () {
        return this.alert;
    }

    public void setAlert (String alert) {
        this.alert = alert;
    }
	private String auditFrequency; 
	
	public String getAuditFrequency () {
        return this.auditFrequency;
    }

    public void setAuditFrequency (String auditFrequency) {
        this.auditFrequency = auditFrequency;
    }
	private String progress; 
	
	public String getProgress () {
        return this.progress;
    }

    public void setProgress (String progress) {
        this.progress = progress;
    }
	private String secondaryAuditor; 
	
	public String getSecondaryAuditor () {
        return this.secondaryAuditor;
    }

    public void setSecondaryAuditor (String secondaryAuditor) {
        this.secondaryAuditor = secondaryAuditor;
    }
	private String primaryAuditor; 
	
	public String getPrimaryAuditor () {
        return this.primaryAuditor;
    }

    public void setPrimaryAuditor (String primaryAuditor) {
        this.primaryAuditor = primaryAuditor;
    }
	private Date statusDate; 
	
	public Date getStatusDate () {
        return this.statusDate;
    }

    public void setStatusDate (Date statusDate) {
        this.statusDate = statusDate;
    }
	private String auditStatus; 
	
	public String getAuditStatus () {
        return this.auditStatus;
    }

    public void setAuditStatus (String auditStatus) {
        this.auditStatus = auditStatus;
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
}