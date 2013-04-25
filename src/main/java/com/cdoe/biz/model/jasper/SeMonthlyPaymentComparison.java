package com.cdoe.biz.model.jasper;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 
 *    <b>description</b> This a model object used in jasper report framework.
 *                        This model supports the district monthly payment report and contains values for the month.
 * </p>
 *
 * @author Tony Ford
 */
public class SeMonthlyPaymentComparison {
 private String county;
 private String districtName;
 private String districtNumber;
 private String fiscalYear1;
 private String fiscalMonth1;
 private String fiscalYear2;
 private String fiscalMonth2;
 private List<SeMonthlyPaymentComparisonCalculation> calcuation = new ArrayList<SeMonthlyPaymentComparisonCalculation>();

    public SeMonthlyPaymentComparison() {
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
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

    public List<SeMonthlyPaymentComparisonCalculation> getCalcuation() {
        return calcuation;
    }

    public void setCalcuation(List<SeMonthlyPaymentComparisonCalculation> calcuation) {
        this.calcuation = calcuation;
    }

    public String getFiscalYear1() {
        return fiscalYear1;
    }

    public void setFiscalYear1(String fiscalYear1) {
        this.fiscalYear1 = fiscalYear1;
    }

    public String getFiscalMonth1() {
        return fiscalMonth1;
    }

    public void setFiscalMonth1(String fiscalMonth1) {
        this.fiscalMonth1 = fiscalMonth1;
    }

    public String getFiscalYear2() {
        return fiscalYear2;
    }

    public void setFiscalYear2(String fiscalYear2) {
        this.fiscalYear2 = fiscalYear2;
    }

    public String getFiscalMonth2() {
        return fiscalMonth2;
    }

    public void setFiscalMonth2(String fiscalMonth2) {
        this.fiscalMonth2 = fiscalMonth2;
    }
 
 
}
