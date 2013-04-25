
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Java bean object serves as a data container to hold values for the DataGrid.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class AuditEqualGrid {
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
		private String organizationCode;
		
		public String getOrganizationCode () {
			return this.organizationCode;
	   	}
	
		public void setOrganizationCode (String organizationCode) {
		    this.organizationCode = organizationCode;
		}
}