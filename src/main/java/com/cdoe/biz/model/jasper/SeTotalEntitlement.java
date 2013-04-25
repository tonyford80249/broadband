package com.cdoe.biz.model.jasper;

/**
 *
 * @author Tony Ford
 */
public class SeTotalEntitlement {
 private String fiscalYear;
 private String districtNumber;
 private String districtName;
 private Double previousStateEqual;
 private Double currentStateEqual;

    public SeTotalEntitlement(String fiscalYear, String districtNumber, String districtName, Double previousStateEqual, Double currentStateEqual) {
        this.fiscalYear = fiscalYear;
        this.districtNumber = districtNumber;
        this.districtName = districtName;
        this.previousStateEqual = previousStateEqual;
        this.currentStateEqual = currentStateEqual;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getDistrictNumber() {
        return districtNumber;
    }

    public void setDistrictNumber(String districtNumber) {
        this.districtNumber = districtNumber;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Double getPreviousStateEqual() {
        return previousStateEqual;
    }

    public void setPreviousStateEqual(Double previousStateEqual) {
        this.previousStateEqual = previousStateEqual;
    }

    public Double getCurrentStateEqual() {
        return currentStateEqual;
    }

    public void setCurrentStateEqual(Double currentStateEqual) {
        this.currentStateEqual = currentStateEqual;
    }
 
 
 
}
