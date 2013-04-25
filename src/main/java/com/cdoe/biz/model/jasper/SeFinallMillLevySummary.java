package com.cdoe.biz.model.jasper;

/**
 *
 * @author Tony Ford
 */
public class SeFinallMillLevySummary {
 private String fiscalYear;
 private String county;
 private String districtName;
 private String districtNumber;
 private Double netAssessedValuation;
 private Double totalProgramMillLevy;
 private Double categoricalBuyoutMillLevy;
 private Double holdHarmlessMillLevy;
 private Double excessHoldHarmlessMillLevy;
 private Double voterApprovedMillLevy;
 private Double abatementMillLevy;
 private Double bondRedemptionMillLevy;
 private Double transportationMillLevy;
 private Double specialBuildingTechnologyMillLevy;
 private Double fulldayKindergartenMillLevy;
 private Double otherMillLevy;
 private Double totalMillLevy;
 private Boolean totalRecord;

    public SeFinallMillLevySummary(String fiscalYear, String county, String districtName, String districtNumber, Double netAssessedValuation, Double totalProgramMillLevy, Double categoricalBuyoutMillLevy, Double holdHarmlessMillLevy, Double excessHoldHarmlessMillLevy, Double voterApprovedMillLevy, Double abatementMillLevy, Double bondRedemptionMillLevy, Double transportationMillLevy, Double specialBuildingTechnologyMillLevy, Double fulldayKindergartenMillLevy, Double otherMillLevy, Double totalMillLevy) {
        this.fiscalYear = fiscalYear;
        this.county = county;
        this.districtName = districtName;
        this.districtNumber = districtNumber;
        this.netAssessedValuation = netAssessedValuation;
        this.totalProgramMillLevy = totalProgramMillLevy;
        this.categoricalBuyoutMillLevy = categoricalBuyoutMillLevy;
        this.holdHarmlessMillLevy = holdHarmlessMillLevy;
        this.excessHoldHarmlessMillLevy = excessHoldHarmlessMillLevy;
        this.voterApprovedMillLevy = voterApprovedMillLevy;
        this.abatementMillLevy = abatementMillLevy;
        this.bondRedemptionMillLevy = bondRedemptionMillLevy;
        this.transportationMillLevy = transportationMillLevy;
        this.specialBuildingTechnologyMillLevy = specialBuildingTechnologyMillLevy;
        this.fulldayKindergartenMillLevy = fulldayKindergartenMillLevy;
        this.otherMillLevy = otherMillLevy;
        this.totalMillLevy = totalMillLevy;
    }
    
     public SeFinallMillLevySummary(String fiscalYear, String county, String districtName, String districtNumber, Double netAssessedValuation, Double totalProgramMillLevy, Double categoricalBuyoutMillLevy, Double holdHarmlessMillLevy, Double excessHoldHarmlessMillLevy, Double voterApprovedMillLevy, Double abatementMillLevy, Double bondRedemptionMillLevy, Double transportationMillLevy, Double specialBuildingTechnologyMillLevy, Double fulldayKindergartenMillLevy, Double otherMillLevy, Double totalMillLevy,Boolean totalRecord) {
        this.fiscalYear = fiscalYear;
        this.county = county;
        this.districtName = districtName;
        this.districtNumber = districtNumber;
        this.netAssessedValuation = netAssessedValuation;
        this.totalProgramMillLevy = totalProgramMillLevy;
        this.categoricalBuyoutMillLevy = categoricalBuyoutMillLevy;
        this.holdHarmlessMillLevy = holdHarmlessMillLevy;
        this.excessHoldHarmlessMillLevy = excessHoldHarmlessMillLevy;
        this.voterApprovedMillLevy = voterApprovedMillLevy;
        this.abatementMillLevy = abatementMillLevy;
        this.bondRedemptionMillLevy = bondRedemptionMillLevy;
        this.transportationMillLevy = transportationMillLevy;
        this.specialBuildingTechnologyMillLevy = specialBuildingTechnologyMillLevy;
        this.fulldayKindergartenMillLevy = fulldayKindergartenMillLevy;
        this.otherMillLevy = otherMillLevy;
        this.totalMillLevy = totalMillLevy;
        this.totalRecord = totalRecord;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
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

    public Double getNetAssessedValuation() {
        return netAssessedValuation;
    }

    public void setNetAssessedValuation(Double netAssessedValuation) {
        this.netAssessedValuation = netAssessedValuation;
    }

    public Double getTotalProgramMillLevy() {
        return totalProgramMillLevy;
    }

    public void setTotalProgramMillLevy(Double totalProgramMillLevy) {
        this.totalProgramMillLevy = totalProgramMillLevy;
    }

    public Double getCategoricalBuyoutMillLevy() {
        return categoricalBuyoutMillLevy;
    }

    public void setCategoricalBuyoutMillLevy(Double categoricalBuyoutMillLevy) {
        this.categoricalBuyoutMillLevy = categoricalBuyoutMillLevy;
    }

    public Double getHoldHarmlessMillLevy() {
        return holdHarmlessMillLevy;
    }

    public void setHoldHarmlessMillLevy(Double holdHarmlessMillLevy) {
        this.holdHarmlessMillLevy = holdHarmlessMillLevy;
    }

    public Double getExcessHoldHarmlessMillLevy() {
        return excessHoldHarmlessMillLevy;
    }

    public void setExcessHoldHarmlessMillLevy(Double excessHoldHarmlessMillLevy) {
        this.excessHoldHarmlessMillLevy = excessHoldHarmlessMillLevy;
    }

    public Double getVoterApprovedMillLevy() {
        return voterApprovedMillLevy;
    }

    public void setVoterApprovedMillLevy(Double voterApprovedMillLevy) {
        this.voterApprovedMillLevy = voterApprovedMillLevy;
    }

    public Double getAbatementMillLevy() {
        return abatementMillLevy;
    }

    public void setAbatementMillLevy(Double abatementMillLevy) {
        this.abatementMillLevy = abatementMillLevy;
    }

    public Double getBondRedemptionMillLevy() {
        return bondRedemptionMillLevy;
    }

    public void setBondRedemptionMillLevy(Double bondRedemptionMillLevy) {
        this.bondRedemptionMillLevy = bondRedemptionMillLevy;
    }

    public Double getTransportationMillLevy() {
        return transportationMillLevy;
    }

    public void setTransportationMillLevy(Double transportationMillLevy) {
        this.transportationMillLevy = transportationMillLevy;
    }

    public Double getSpecialBuildingTechnologyMillLevy() {
        return specialBuildingTechnologyMillLevy;
    }

    public void setSpecialBuildingTechnologyMillLevy(Double specialBuildingTechnologyMillLevy) {
        this.specialBuildingTechnologyMillLevy = specialBuildingTechnologyMillLevy;
    }

    public Double getFulldayKindergartenMillLevy() {
        return fulldayKindergartenMillLevy;
    }

    public void setFulldayKindergartenMillLevy(Double fulldayKindergartenMillLevy) {
        this.fulldayKindergartenMillLevy = fulldayKindergartenMillLevy;
    }

    public Double getOtherMillLevy() {
        return otherMillLevy;
    }

    public void setOtherMillLevy(Double otherMillLevy) {
        this.otherMillLevy = otherMillLevy;
    }

    public Double getTotalMillLevy() {
        return totalMillLevy;
    }

    public void setTotalMillLevy(Double totalMillLevy) {
        this.totalMillLevy = totalMillLevy;
    }

    public Boolean isTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Boolean totalRecord) {
        this.totalRecord = totalRecord;
    }

   
 
 
}
