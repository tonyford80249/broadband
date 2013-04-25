package com.cdoe.biz.model.jasper;

/**
 *
 * @author Tony Ford
 */
public class ImportPriorYearAudit {
 private String organizationCode;
 private String organizationName;
 private String fiscalYear;
 private Double auditedFTECount;
 private Double auditedCPPCount;
 private Double auditedOnlineCount;
 private Double newFundedPupilCount;
 private Double revisedTotalProgramFunding;
 private Double revisedPerPupilFunding;

    public ImportPriorYearAudit(String organizationCode, String organizationName, String fiscalYear, Double auditedFTECount, Double auditedCPPCount, Double newFundedPupilCount, Double revisedTotalProgramFunding, Double revisedPerPupilFunding) {
        this.organizationCode = organizationCode;
        this.organizationName = organizationName;
        this.fiscalYear = fiscalYear;
        this.auditedFTECount = auditedFTECount;
        this.auditedCPPCount = auditedCPPCount;
        this.newFundedPupilCount = newFundedPupilCount;
        this.revisedTotalProgramFunding = revisedTotalProgramFunding;
        this.revisedPerPupilFunding = revisedPerPupilFunding;
    }

    public ImportPriorYearAudit(String organizationCode, String organizationName, String fiscalYear, Double auditedFTECount, Double auditedCPPCount, Double auditedOnlineCount, Double newFundedPupilCount, Double revisedTotalProgramFunding, Double revisedPerPupilFunding) {
        this.organizationCode = organizationCode;
        this.organizationName = organizationName;
        this.fiscalYear = fiscalYear;
        this.auditedFTECount = auditedFTECount;
        this.auditedCPPCount = auditedCPPCount;
        this.auditedOnlineCount = auditedOnlineCount;
        this.newFundedPupilCount = newFundedPupilCount;
        this.revisedTotalProgramFunding = revisedTotalProgramFunding;
        this.revisedPerPupilFunding = revisedPerPupilFunding;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public Double getAuditedFTECount() {
        return auditedFTECount;
    }

    public void setAuditedFTECount(Double auditedFTECount) {
        this.auditedFTECount = auditedFTECount;
    }

    public Double getAuditedCPPCount() {
        return auditedCPPCount;
    }

    public void setAuditedCPPCount(Double auditedCPPCount) {
        this.auditedCPPCount = auditedCPPCount;
    }

    public Double getAuditedOnlineCount() {
        return auditedOnlineCount;
    }

    public void setAuditedOnlineCount(Double auditedOnlineCount) {
        this.auditedOnlineCount = auditedOnlineCount;
    }

    public Double getNewFundedPupilCount() {
        return newFundedPupilCount;
    }

    public void setNewFundedPupilCount(Double newFundedPupilCount) {
        this.newFundedPupilCount = newFundedPupilCount;
    }

    public Double getRevisedTotalProgramFunding() {
        return revisedTotalProgramFunding;
    }

    public void setRevisedTotalProgramFunding(Double revisedTotalProgramFunding) {
        this.revisedTotalProgramFunding = revisedTotalProgramFunding;
    }

    public Double getRevisedPerPupilFunding() {
        return revisedPerPupilFunding;
    }

    public void setRevisedPerPupilFunding(Double revisedPerPupilFunding) {
        this.revisedPerPupilFunding = revisedPerPupilFunding;
    }

 
  
 
 
}
