package com.cdoe.ui.form;

import com.cdoe.biz.model.ISeViewableReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Tony Ford
 */
public class SeViewReportsForm {
    private List<ISeViewableReport> generatedReports = new ArrayList<ISeViewableReport>();
    private Map<String,String> availableYears = new TreeMap<String,String>(Collections.reverseOrder());
    private List<String> availableMonths = new ArrayList<String>();
    private Map<String,String> reportTypes = new TreeMap<String,String>();
    private String year;
    private String month;
    private String reportType;
    private List<Long> reports = new ArrayList<Long>();
    
    public SeViewReportsForm() {
    }

    public List<ISeViewableReport> getGeneratedReports() {
        return generatedReports;
    }

    public void setGeneratedReports(List<ISeViewableReport> generatedReports) {
        this.generatedReports = generatedReports;
    }

    public Map<String, String> getAvailableYears() {
        return availableYears;
    }

    public void setAvailableYears(Map<String, String> availableYears) {
        this.availableYears = availableYears;
    }

    public List<String> getAvailableMonths() {
        return availableMonths;
    }

    public void setAvailableMonths(List<String> availableMonths) {
        this.availableMonths = availableMonths;
    }

    public Map<String, String> getReportTypes() {
        return reportTypes;
    }

    public void setReportTypes(Map<String, String> reportTypes) {
        this.reportTypes = reportTypes;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public List<Long> getReports() {
        return reports;
    }

    public void setReports(List<Long> reports) {
        this.reports = reports;
    }
          
}
