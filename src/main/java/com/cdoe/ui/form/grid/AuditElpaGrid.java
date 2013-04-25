
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
public class AuditElpaGrid {
		private Double orgCTotal;
		
		public Double getOrgCTotal () {
			return this.orgCTotal;
	   	}
	
		public void setOrgCTotal (Double orgCTotal) {
		    this.orgCTotal = orgCTotal;
		}
		private Double orgAbTotal;
		
		public Double getOrgAbTotal () {
			return this.orgAbTotal;
	   	}
	
		public void setOrgAbTotal (Double orgAbTotal) {
		    this.orgAbTotal = orgAbTotal;
		}
		private Double cRate;
		
		public Double getCRate () {
			return this.cRate;
	   	}
	
		public void setCRate (Double cRate) {
		    this.cRate = cRate;
		}
		private Double abRate;
		
		public Double getAbRate () {
			return this.abRate;
	   	}
	
		public void setAbRate (Double abRate) {
		    this.abRate = abRate;
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
		private Double auditAbTotal;
		
		public Double getAuditAbTotal () {
			return this.auditAbTotal;
	   	}
	
		public void setAuditAbTotal (Double auditAbTotal) {
		    this.auditAbTotal = auditAbTotal;
		}
		private Double auditTotalAllocation;
		
		public Double getAuditTotalAllocation () {
			return this.auditTotalAllocation;
	   	}
	
		public void setAuditTotalAllocation (Double auditTotalAllocation) {
		    this.auditTotalAllocation = auditTotalAllocation;
		}
}