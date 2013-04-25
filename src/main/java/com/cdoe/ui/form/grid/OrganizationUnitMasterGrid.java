
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
public class OrganizationUnitMasterGrid {
		private String organizationName;
		
		public String getOrganizationName () {
			return this.organizationName;
	   	}
	
		public void setOrganizationName (String organizationName) {
		    this.organizationName = organizationName;
		}
		private Long firstPayment;
		
		public Long getFirstPayment () {
			return this.firstPayment;
	   	}
	
		public void setFirstPayment (Long firstPayment) {
		    this.firstPayment = firstPayment;
		}
		private Long secondPayment;
		
		public Long getSecondPayment () {
			return this.secondPayment;
	   	}
	
		public void setSecondPayment (Long secondPayment) {
		    this.secondPayment = secondPayment;
		}
		private Long districtDistribution;
		
		public Long getDistrictDistribution () {
			return this.districtDistribution;
	   	}
	
		public void setDistrictDistribution (Long districtDistribution) {
		    this.districtDistribution = districtDistribution;
		}
		private String districtNumber;
		
		public String getDistrictNumber () {
			return this.districtNumber;
	   	}
	
		public void setDistrictNumber (String districtNumber) {
		    this.districtNumber = districtNumber;
		}
}