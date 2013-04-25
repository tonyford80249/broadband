
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form;

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
public class NewCapitalOutlayForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private Long relatedYear;
	
	public Long getRelatedYear () {
        return this.relatedYear;
    }

    public void setRelatedYear (Long relatedYear) {
        this.relatedYear = relatedYear;
    }
	private Long baseYear;
	
	public Long getBaseYear () {
        return this.baseYear;
    }

    public void setBaseYear (Long baseYear) {
        this.baseYear = baseYear;
    }
	private Long capitalOutlayTotalFunding;
	
	public Long getCapitalOutlayTotalFunding () {
        return this.capitalOutlayTotalFunding;
    }

    public void setCapitalOutlayTotalFunding (Long capitalOutlayTotalFunding) {
        this.capitalOutlayTotalFunding = capitalOutlayTotalFunding;
    }
	private Long outlayExclusion;
	
	public Long getOutlayExclusion () {
        return this.outlayExclusion;
    }

    public void setOutlayExclusion (Long outlayExclusion) {
        this.outlayExclusion = outlayExclusion;
    }
	private Long contractorMiles;
	
	public Long getContractorMiles () {
        return this.contractorMiles;
    }

    public void setContractorMiles (Long contractorMiles) {
        this.contractorMiles = contractorMiles;
    }
	private Long depreciationPy;
	
	public Long getDepreciationPy () {
        return this.depreciationPy;
    }

    public void setDepreciationPy (Long depreciationPy) {
        this.depreciationPy = depreciationPy;
    }
	private Long remainingAmt;
	
	public Long getRemainingAmt () {
        return this.remainingAmt;
    }

    public void setRemainingAmt (Long remainingAmt) {
        this.remainingAmt = remainingAmt;
    }
	private Long prevDepreciatedAmt;
	
	public Long getPrevDepreciatedAmt () {
        return this.prevDepreciatedAmt;
    }

    public void setPrevDepreciatedAmt (Long prevDepreciatedAmt) {
        this.prevDepreciatedAmt = prevDepreciatedAmt;
    }
	private Long depreciationCycle;
	
	public Long getDepreciationCycle () {
        return this.depreciationCycle;
    }

    public void setDepreciationCycle (Long depreciationCycle) {
        this.depreciationCycle = depreciationCycle;
    }
	private Long totalPurchasePrice;
	
	public Long getTotalPurchasePrice () {
        return this.totalPurchasePrice;
    }

    public void setTotalPurchasePrice (Long totalPurchasePrice) {
        this.totalPurchasePrice = totalPurchasePrice;
    }
	private String fiscalYear;
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
	private String districtNumber;
	
	public String getDistrictNumber () {
        return this.districtNumber;
    }

    public void setDistrictNumber (String districtNumber) {
        this.districtNumber = districtNumber;
    }
}