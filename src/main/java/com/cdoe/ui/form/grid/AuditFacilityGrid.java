
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
public class AuditFacilityGrid {
		private String firstName;
		
		public String getFirstName () {
			return this.firstName;
	   	}
	
		public void setFirstName (String firstName) {
		    this.firstName = firstName;
		}
		private String lastName;
		
		public String getLastName () {
			return this.lastName;
	   	}
	
		public void setLastName (String lastName) {
		    this.lastName = lastName;
		}
}