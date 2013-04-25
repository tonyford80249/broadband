
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.format.annotation.NumberFormat;

import com.cdoe.ui.form.grid.*;

/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class ProrateForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private String fiscalYear;
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
	private Double prorateFactor1stPayment;
	
	public Double getProrateFactor1stPayment () {
        return this.prorateFactor1stPayment;
    }

    public void setProrateFactor1stPayment (Double prorateFactor1stPayment) {
        this.prorateFactor1stPayment = prorateFactor1stPayment;
    }
	private Double prorateFactor2ndPayment;
	
	public Double getProrateFactor2ndPayment () {
        return this.prorateFactor2ndPayment;
    }

    public void setProrateFactor2ndPayment (Double prorateFactor2ndPayment) {
        this.prorateFactor2ndPayment = prorateFactor2ndPayment;
    }
	private String fundingSources;
	
	public String getFundingSources () {
        return this.fundingSources;
    }

    public void setFundingSources (String fundingSources) {
        this.fundingSources = fundingSources;
    }
    
    @NumberFormat(pattern = "###,###,###,#0.00")
	private Double totalFirstPayment;
	
	public Double getTotalFirstPayment () {
        return this.totalFirstPayment;
    }

    public void setTotalFirstPayment (Double totalFirstPayment) {
        this.totalFirstPayment = totalFirstPayment;
    }
    
    @NumberFormat(pattern = "###,###,###,##0.00")
	private Double totalSecondPayment;
	
	public Double getTotalSecondPayment () {
        return this.totalSecondPayment;
    }

    public void setTotalSecondPayment (Double totalSecondPayment) {
        this.totalSecondPayment = totalSecondPayment;
    }
    
    @NumberFormat(pattern = "###,###,###,###.00")	
	private Double totalDistribution;
	
	public Double getTotalDistribution () {
        return this.totalDistribution;
    }

    public void setTotalDistribution (Double totalDistribution) {
        this.totalDistribution = totalDistribution;
    }
    
    private List<ProrateTransportationGrid> prorateTransportationGridList = new ArrayList<ProrateTransportationGrid>();
	
	public List<ProrateTransportationGrid> getProrateTransportationGridList() {
	    return this.prorateTransportationGridList;
	}
}