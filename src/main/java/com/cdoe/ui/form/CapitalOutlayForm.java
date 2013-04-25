
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
public class CapitalOutlayForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	private String districtNumber;
	
	public String getDistrictNumber () {
        return this.districtNumber;
    }

    public void setDistrictNumber (String districtNumber) {
        this.districtNumber = districtNumber;
    }
    
    private String districtName;
	
  	public String getDistrictName () {
          return this.districtName;
     }

      public void setDistrictName (String districtName) {
          this.districtName = districtName;
      }
    
	private Long baseYear;
	
	public Long getBaseYear () {
        return this.baseYear;
    }

    public void setBaseYear (Long baseYear) {
        this.baseYear = baseYear;
    }
    
    
    @NumberFormat(pattern="###,###,###,###.##")
	private Double capitalOutlayTotalFunding;
	
	public Double getCapitalOutlayTotalFunding () {
        return this.capitalOutlayTotalFunding;
    }

    public void setCapitalOutlayTotalFunding (Double capitalOutlayTotalFunding) {
        this.capitalOutlayTotalFunding = capitalOutlayTotalFunding;
    }
	
	private String fiscalYear;
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
    
    private long version;
	
    public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	private List<CapitalOutlayGrid> capitalOutlayGridList = new ArrayList<CapitalOutlayGrid>();

	public List<CapitalOutlayGrid> getCapitalOutlayGridList() {
		return this.capitalOutlayGridList;
	}

	
	private String preparerPhoneNos;
	private String preparerName;
	private String preparerEmailId;
	
	
	public String getPreparerEmailId() {
		return preparerEmailId;
	}

	public void setPreparerEmailId(String preparerEmailId) {
		this.preparerEmailId = preparerEmailId;
	}

	public String getPreparerPhoneNos() {
		return preparerPhoneNos;
	}

	public void setPreparerPhoneNos(String preparerPhoneNos) {
		this.preparerPhoneNos = preparerPhoneNos;
	}

	public String getPreparerName() {
		return preparerName;
	}

	public void setPreparerName(String preparerName) {
		this.preparerName = preparerName;
	}

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}