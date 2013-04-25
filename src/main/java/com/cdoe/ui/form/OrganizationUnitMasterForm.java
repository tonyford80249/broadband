
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form;


/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class OrganizationUnitMasterForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private String organizationCode;
	
	public String getOrganizationCode () {
        return this.organizationCode;
    }

    public void setOrganizationCode (String organizationCode) {
        this.organizationCode = organizationCode;
    }
	private String organizationName;
	
	public String getOrganizationName () {
        return this.organizationName;
    }

    public void setOrganizationName (String organizationName) {
        this.organizationName = organizationName;
    }
}