package com.cdoe.biz.model.jasper;

/**
 *
 * @author Tony Ford
 */
public class ElectionInfo {
 private String fiscalYear;
 private String districtNumber;
 private String districtName;
 private String county;
 private Integer votesFor;
 private Integer votesAgainst;
 private Double dollarAmount;
 private String ballotLanguage;

    public ElectionInfo(String fiscalYear, String districtNumber, String districtName, String county, Integer votesFor, Integer votesAgainst, Double dollarAmount, String ballotLanguage) {
        this.fiscalYear = fiscalYear;
        this.districtNumber = districtNumber;
        this.districtName = districtName;
        this.county = county;
        this.votesFor = votesFor;
        this.votesAgainst = votesAgainst;
        this.dollarAmount = dollarAmount;
        this.ballotLanguage = ballotLanguage;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getVotesFor() {
        return votesFor;
    }

    public void setVotesFor(Integer votesFor) {
        this.votesFor = votesFor;
    }

    public Integer getVotesAgainst() {
        return votesAgainst;
    }

    public void setVotesAgainst(Integer votesAgainst) {
        this.votesAgainst = votesAgainst;
    }

    public Double getDollarAmount() {
        return dollarAmount;
    }

    public void setDollarAmount(Double dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    public String getBallotLanguage() {
        return ballotLanguage;
    }

    public void setBallotLanguage(String ballotLanguage) {
        this.ballotLanguage = ballotLanguage;
    }
 
}
