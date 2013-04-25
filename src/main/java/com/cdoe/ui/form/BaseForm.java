/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdoe.ui.form;

import com.cdoe.ui.form.grid.TransportationGrid;
import com.cdoe.util.DateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author romeo
 */
public class BaseForm {
    private String districtName;
    private String districtNumber;
    private String fiscalYear;
    private long id;
    private boolean valid;
    private String formattedFiscalYear;
    private List<TransportationGrid> transportationGridList = new ArrayList<TransportationGrid>();

    public BaseForm() {
    }

    public BaseForm( String districtNumber, String districtName,String fiscalYear) {
        this.districtName = districtName;
        this.districtNumber = districtNumber;
        this.fiscalYear = fiscalYear;
        this.valid =true;
    }
    
    
    public String getCurrentFiscalYear() {
        return DateUtil.getFiscalYear();
    }
    
    public String getPreviousFiscalYear() {
     return DateUtil.getPrevFiscalYear();
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public String getDistrictNumber() {
        return this.districtNumber;
    }

    public String getFiscalYear() {
        return this.fiscalYear;
    }

    public String getFormattedCurrentFiscalYear() {
        return DateUtil.getFiscalYearFormattedLong();
    }

    public String getFormattedFiscalYear() {
        return this.formattedFiscalYear;
    }

    public long getId() {
        return id;
    }

    public boolean getValid() {
        return this.valid;
    }

    public void setCurrentFiscalYear(String any) {
    }
    
    public void setPreviousFiscalYear(String any) {
        
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setDistrictNumber(String districtNumber) {
        this.districtNumber = districtNumber;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public void setFormattedCurrentFiscalYear(String any) {
    }

    public void setFormattedFiscalYear(String fiscalYear) {
        this.formattedFiscalYear = fiscalYear;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    	
    public List<TransportationGrid> getTransportationGridList() {
	    return this.transportationGridList;
    }
    
}
