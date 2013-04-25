
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.format.annotation.NumberFormat;

/**
 * Java bean object serves as a data container to hold values for the DataGrid.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class CapitalOutlayGrid {
	
		private long id;
	
		public long getId() {
			return id;
		}
	
		public void setId(long id) {
			this.id = id;
		}

		@NumberFormat(pattern="###,###,###,##0.00")
		private Double prevDepreciatedAmt;
		
		
		public Double getPrevDepreciatedAmt () {
			return this.prevDepreciatedAmt;
	   	}
	
		
		public void setPrevDepreciatedAmt (Double prevDepreciatedAmt) {
		    this.prevDepreciatedAmt = prevDepreciatedAmt;
		}
		
		@NumberFormat(pattern="###,###,###,##0.00")
		private Double remainingAmt;
		
		public Double getRemainingAmt () {
			return this.remainingAmt;
	   	}
	
		public void setRemainingAmt (Double remainingAmt) {
		    this.remainingAmt = remainingAmt;
		}
		
		@NumberFormat(pattern="###,###,###,##0.00")
		private Double depreciationPy;
		
		public Double getDepreciationPy () {
			return this.depreciationPy;
	   	}
	
		public void setDepreciationPy (Double depreciationPy) {
		    this.depreciationPy = depreciationPy;
		}
		
		@NumberFormat(pattern="#0.0")
		private Double contractorMiles;
		
		public Double getContractorMiles () {
			return this.contractorMiles;
	   	}
	
		public void setContractorMiles (Double contractorMiles) {
		    this.contractorMiles = contractorMiles;
		}
		
		@NumberFormat(pattern="###,###,###,##0.00")
		private Double outlayExclusion;
		
		public Double getOutlayExclusion () {
			return this.outlayExclusion;
	   	}
	
		public void setOutlayExclusion (Double outlayExclusion) {
		    this.outlayExclusion = outlayExclusion;
		}
		
		@NumberFormat(pattern="###,###,###,##0.00")
		private Double depreciationCycle;
		
		public Double getDepreciationCycle () {
			return this.depreciationCycle;
	   	}
	
		public void setDepreciationCycle (Double depreciationCycle) {
		    this.depreciationCycle = depreciationCycle;
		}
		
		@NumberFormat(pattern="###,###,###,##0.00")
		private Double totalPurchasePrice;
		
		public Double getTotalPurchasePrice () {
			return this.totalPurchasePrice;
	   	}
	
		public void setTotalPurchasePrice (Double totalPurchasePrice) {
		    this.totalPurchasePrice = totalPurchasePrice;
		}
		private Long relatedYear;
		
		public Long getRelatedYear () {
			return this.relatedYear;
	   	}
	
		public void setRelatedYear (Long relatedYear) {
		    this.relatedYear = relatedYear;
		}
		
		private String fiscalYear;

		public String getFiscalYear() {
			return this.fiscalYear;
		}

		public void setFiscalYear(String fiscalYear) {
			this.fiscalYear = fiscalYear;
		}

}