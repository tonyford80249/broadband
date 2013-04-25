
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
public class StateEqualGrid {
		private String districtNumber;
		
		public String getDistrictNumber () {
			return this.districtNumber;
	   	}
	
		public void setDistrictNumber (String districtNumber) {
		    this.districtNumber = districtNumber;
		}
		private Long adjStateAssess;
		
		public Long getAdjStateAssess () {
			return this.adjStateAssess;
	   	}
	
		public void setAdjStateAssess (Long adjStateAssess) {
		    this.adjStateAssess = adjStateAssess;
		}
}