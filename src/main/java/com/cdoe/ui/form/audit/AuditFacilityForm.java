
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
public class AuditFacilityForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private List<AuditFacilityGrid> auditFacilityGridList = new ArrayList<AuditFacilityGrid>();
	
	public List<AuditFacilityGrid> getAuditFacilityGridList() {
	    return this.auditFacilityGridList;
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
	private String comments; 
	
	public String getComments () {
        return this.comments;
    }

    public void setComments (String comments) {
        this.comments = comments;
    }
	private String organizationName; 
	
	public String getOrganizationName () {
        return this.organizationName;
    }

    public void setOrganizationName (String organizationName) {
        this.organizationName = organizationName;
    }
	private String firstName; 
	
	public String getFirstName () {
        return this.firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
	private String organizationCode; 
	
	public String getOrganizationCode () {
        return this.organizationCode;
    }

    public void setOrganizationCode (String organizationCode) {
        this.organizationCode = organizationCode;
    }
	private String lastName; 
	
	public String getLastName () {
        return this.lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
	private String fiscalYear; 
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
	private String sasid; 
	
	public String getSasid () {
        return this.sasid;
    }

    public void setSasid (String sasid) {
        this.sasid = sasid;
    }
}