
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
public class AuditBillingGrid {
		private String fiscalYear;
		
		public String getFiscalYear () {
			return this.fiscalYear;
	   	}
	
		public void setFiscalYear (String fiscalYear) {
		    this.fiscalYear = fiscalYear;
		}
		private Double dailyRate;
		
		public Double getDailyRate () {
			return this.dailyRate;
	   	}
	
		public void setDailyRate (Double dailyRate) {
		    this.dailyRate = dailyRate;
		}
		private Double orgTotalAllocation;
		
		public Double getOrgTotalAllocation () {
			return this.orgTotalAllocation;
	   	}
	
		public void setOrgTotalAllocation (Double orgTotalAllocation) {
		    this.orgTotalAllocation = orgTotalAllocation;
		}
		private Double totalAllocationDifference;
		
		public Double getTotalAllocationDifference () {
			return this.totalAllocationDifference;
	   	}
	
		public void setTotalAllocationDifference (Double totalAllocationDifference) {
		    this.totalAllocationDifference = totalAllocationDifference;
		}
		private Double orgDays;
		
		public Double getOrgDays () {
			return this.orgDays;
	   	}
	
		public void setOrgDays (Double orgDays) {
		    this.orgDays = orgDays;
		}
		private Double auditTotalAllocation;
		
		public Double getAuditTotalAllocation () {
			return this.auditTotalAllocation;
	   	}
	
		public void setAuditTotalAllocation (Double auditTotalAllocation) {
		    this.auditTotalAllocation = auditTotalAllocation;
		}
}