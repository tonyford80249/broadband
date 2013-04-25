package com.cdoe.biz.model.jasper;

/**
 *
 * @author Tony Ford
 */
public class AuditException {
 private String distrctNumber;   
 private String districtName;   
 private String fiscalYear;
 private String school;
 private String grade;
 private String lastName;
 private String firstName;
 private String middleName;
 private String exception;
 private Double fteAdjust;

    public AuditException(String distrctNumber, String districtName, String fiscalYear, String school, String grade, String lastName, String firstName, String middleName, String exception) {
        this.distrctNumber = distrctNumber;
        this.districtName = districtName;
        this.fiscalYear = fiscalYear;
        this.school = school;
        this.grade = grade;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.exception = exception;
    }

    public AuditException(String distrctNumber, String districtName, String fiscalYear, String school, String grade, String lastName, String firstName, String middleName, String exception, Double fteAdjust) {
        this.distrctNumber = distrctNumber;
        this.districtName = districtName;
        this.fiscalYear = fiscalYear;
        this.school = school;
        this.grade = grade;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.exception = exception;
        this.fteAdjust = fteAdjust;
    }

   

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Double getFteAdjust() {
        return fteAdjust;
    }

    public void setFteAdjust(Double fteAdjust) {
        this.fteAdjust = fteAdjust;
    }

    public String getDistrctNumber() {
        return distrctNumber;
    }

    public void setDistrctNumber(String distrctNumber) {
        this.distrctNumber = distrctNumber;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
 
}
