package com.cdoe.biz.model.jasper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tony Ford
 */
public class SeMillLevyCertificationCollection {
 private String districtNumber;
 private String districtName;
 private String county;
 private String taxYear;
 private String approverName;
 private String approverPhone;
 private Date column1CertificationDate;
 private Date column3CertificationDate;
 
 private List<SeMillLevyCertificationCalculation> calculations = new ArrayList<SeMillLevyCertificationCalculation>();   

    public SeMillLevyCertificationCollection() {
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(String taxYear) {
        this.taxYear = taxYear;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public String getApproverPhone() {
        return approverPhone;
    }

    public void setApproverPhone(String approverPhone) {
        this.approverPhone = approverPhone;
    }

    public List<SeMillLevyCertificationCalculation> getCalculations() {
        return calculations;
    }

    public void setCalculations(List<SeMillLevyCertificationCalculation> calculations) {
        this.calculations = calculations;
    }

    public Date getColumn1CertificationDate() {
        return column1CertificationDate;
    }

    public void setColumn1CertificationDate(Date column1CertificationDate) {
        this.column1CertificationDate = column1CertificationDate;
    }

    

    public Date getColumn3CertificationDate() {
        return column3CertificationDate;
    }

    public void setColumn3CertificationDate(Date column3CertificationDate) {
        this.column3CertificationDate = column3CertificationDate;
    }
 
 
}
