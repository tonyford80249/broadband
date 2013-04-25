package com.cdoe.biz.model.jasper;

/**
 * <p> 
 *    <b>description</b> This a model object used in jasper report framework.
 *                        This model supports the district monthly payment report and contains values for the month.
 * </p>
 *
 * @author Tony Ford
 */
public class Message {
 private String reportName;
 private String districtName;
 private String districtNumber;
 private String fiscalYear;
 private String fiscalMonth;
 private String generalInfo;

    public Message(String reportName, String districtName, String districtNumber, String fiscalYear, String fiscalMonth, String generalInfo) {
        this.reportName = reportName;
        this.districtName = districtName;
        this.districtNumber = districtNumber;
        this.fiscalYear = fiscalYear;
        this.fiscalMonth = fiscalMonth;
        this.generalInfo = generalInfo;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictNumber() {
        return districtNumber;
    }

    public void setDistrictNumber(String districtNumber) {
        this.districtNumber = districtNumber;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getFiscalMonth() {
        return fiscalMonth;
    }

    public void setFiscalMonth(String fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
    }

    public String getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(String generalInfo) {
        this.generalInfo = generalInfo;
    }
 
}
