package com.cdoe.biz.model.jasper;

/**
 * <p> 
 *    <b>description</b> This a model object used in jasper report framework.
 *                        This model supports the district monthly payment report and contains values for the month.
 * </p>
 *
 * @author Tony Ford
 */
public class CsiPayment {
 /**
  * Area or County the school or institute is in.
  */   
 private String county;
 
 /**
  * Name of school or institute
  */
 private String chaterSchool;
 
 /**
  * Projected Funded Pupil Count
  */
 private Double pupilCount; 
 
 /**
  * District PPR for Full Day Factor
  */
 private Double kfactor;
 
 
 /**
  * projected per pupil revenue
  */
 private Double perPupilRevenue;
 
 /**
  * Total Funding From Public School Finance Act
  */
 private Double totalFunding;
 
 /**
  * Monthly Entitlement
  */
 private Double monthlyEntitlement;
 
 /**
  * Withholding for CDE Administrative Overhead at 1%
  */
 private Double cdeWithholding;
 
 /**
  * Withholding for Assistance Fund at 1%
  */
 private Double assistanceWithholding;
 
 /**
  * Withholding for Institute Admininstrative Overhead at 3%
  */
 private Double instituteWithholding;
 
 /**
  * Withholding for Treasure's Intercept Program
  */
 private Double interceptWithholding;
 
 /**
  * At-Risk adjustment (July - December)
  */
 private Double atRiskAdjustment;
 
 /**
  * Amount to be distributed to Institute charter school
  */
 private Double distributionAmount;

 /**
  * 
  */
    public CsiPayment() {
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getChaterSchool() {
        return chaterSchool;
    }

    public void setChaterSchool(String chaterSchool) {
        this.chaterSchool = chaterSchool;
    }

    public Double getPupilCount() {
        return pupilCount;
    }

    public void setPupilCount(Double pupilCount) {
        this.pupilCount = pupilCount;
    }

    public Double getKfactor() {
        return kfactor;
    }

    public void setKfactor(Double kfactor) {
        this.kfactor = kfactor;
    }

    public Double getPerPupilRevenue() {
        return perPupilRevenue;
    }

    public void setPerPupilRevenue(Double perPupilRevenue) {
        this.perPupilRevenue = perPupilRevenue;
    }

    public Double getTotalFunding() {
        return totalFunding;
    }

    public void setTotalFunding(Double totalFunding) {
        this.totalFunding = totalFunding;
    }

    public Double getMonthlyEntitlement() {
        return monthlyEntitlement;
    }

    public void setMonthlyEntitlement(Double monthlyEntitlement) {
        this.monthlyEntitlement = monthlyEntitlement;
    }

    public Double getCdeWithholding() {
        return cdeWithholding;
    }

    public void setCdeWithholding(Double cdeWithholding) {
        this.cdeWithholding = cdeWithholding;
    }

    public Double getAssistanceWithholding() {
        return assistanceWithholding;
    }

    public void setAssistanceWithholding(Double assistanceWithholding) {
        this.assistanceWithholding = assistanceWithholding;
    }

    public Double getInstituteWithholding() {
        return instituteWithholding;
    }

    public void setInstituteWithholding(Double instituteWithholding) {
        this.instituteWithholding = instituteWithholding;
    }

    public Double getInterceptWithholding() {
        return interceptWithholding;
    }

    public void setInterceptWithholding(Double interceptWithholding) {
        this.interceptWithholding = interceptWithholding;
    }

    public Double getAtRiskAdjustment() {
        return atRiskAdjustment;
    }

    public void setAtRiskAdjustment(Double atRiskAdjustment) {
        this.atRiskAdjustment = atRiskAdjustment;
    }

    public Double getDistributionAmount() {
        return distributionAmount;
    }

    public void setDistributionAmount(Double distributionAmount) {
        this.distributionAmount = distributionAmount;
    }
 
}
