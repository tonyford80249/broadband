
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
public class AuditContactForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	private String contactName; 
	
	public String getContactName () {
        return this.contactName;
    }

    public void setContactName (String contactName) {
        this.contactName = contactName;
    }
	private String contactPhone; 
	
	public String getContactPhone () {
        return this.contactPhone;
    }

    public void setContactPhone (String contactPhone) {
        this.contactPhone = contactPhone;
    }
	private String contactType; 
	
	public String getContactType () {
        return this.contactType;
    }

    public void setContactType (String contactType) {
        this.contactType = contactType;
    }
	private String contactEmail; 
	
	public String getContactEmail () {
        return this.contactEmail;
    }

    public void setContactEmail (String contactEmail) {
        this.contactEmail = contactEmail;
    }
	private Integer auditId; 
	
	public Integer getAuditId () {
        return this.auditId;
    }

    public void setAuditId (Integer auditId) {
        this.auditId = auditId;
    }
	private String districtNumber; 
	
	public String getDistrictNumber () {
        return this.districtNumber;
    }

    public void setDistrictNumber (String districtNumber) {
        this.districtNumber = districtNumber;
    }
}