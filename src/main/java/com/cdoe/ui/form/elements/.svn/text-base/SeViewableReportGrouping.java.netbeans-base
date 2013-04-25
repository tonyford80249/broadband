package com.cdoe.ui.form.elements;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony Ford
 */
public class SeViewableReportGrouping implements Comparable<SeViewableReportGrouping> {
 private String fiscalYear;
 private String fiscalMonth;
 private Integer fiscalMonthInt;
 private String reportId;
 private String reportName;
 private List<SeViewableReport> reports = new ArrayList<SeViewableReport>();

    public SeViewableReportGrouping() {
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

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public List<SeViewableReport> getReports() {
        return reports;
    }

    public void setReports(List<SeViewableReport> reports) {
        this.reports = reports;
    }

    public Integer getFiscalMonthInt() {
        return fiscalMonthInt;
    }

    public void setFiscalMonthInt(Integer fiscalMonthInt) {
        this.fiscalMonthInt = fiscalMonthInt;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.fiscalYear != null ? this.fiscalYear.hashCode() : 0);
        hash = 67 * hash + (this.fiscalMonth != null ? this.fiscalMonth.hashCode() : 0);
        hash = 67 * hash + (this.reportId != null ? this.reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SeViewableReportGrouping other = (SeViewableReportGrouping) obj;
        if ((this.fiscalYear == null) ? (other.fiscalYear != null) : !this.fiscalYear.equals(other.fiscalYear)) {
            return false;
        }
        if ((this.fiscalMonth == null) ? (other.fiscalMonth != null) : !this.fiscalMonth.equals(other.fiscalMonth)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(SeViewableReportGrouping o) {
        int result = this.fiscalYear.compareTo(o.fiscalYear);
        
        if (result == 0) {
         result = this.fiscalMonthInt.compareTo(o.fiscalMonthInt);
         
         if (result == 0) {
           result = this.reportId.compareTo(o.reportId);  
         }
        }
        
        
        return result;
    }
 
 
}
