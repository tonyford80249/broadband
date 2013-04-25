package com.cdoe.ui.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Tony Ford
 */
public class ReportForm {

    public static final String RPT360 = "rpt360";
    public static final String RPTFundSummary = "rptFundSummary";
    public static final String RPTMonthlyPayment = "rptMonthlyPayments";
    public static final String RPTCsiPayment = "rptCsiPayments";
    public static final String RPTMonthlyComparison = "rptMonthlyComparison";
    public static final String RPTYtdWithholdings = "rptYtdWitholdings";
    public static final String RPTMillLevy = "rptMillLevy";
    public static final String RPTElections = "rptElections";
    public static final String RPTTotalEntitlement = "rptTotalEntitlements";
    public static final String RPTNegativePayments = "rptNegativePayments";
    public static final String RPTCofrPayments = "rptCofrPayments";
    public static final String RPTStateWideReports = "commonGrouping";
    public static final String RPTAuditUploadSummary = "rptAuditUploadSummary";//cvc-datatype-valid.1.2.1
    private List<ReportDetailForm> availableReports = new ArrayList<ReportDetailForm>();
    private List<String> availableMonths = new ArrayList<String>();
    private Map<String, String> availableYears = new TreeMap<String, String>(Collections.reverseOrder());
    private String month;
    private String year;
    private String extraMonth;
    private String rpt360DistrictNumber;
    private String rptFundSummaryDistrictNumber;
    private String rptMonthlyPaymentsDistrictNumber;
    private String rptMonthlyComparisonDistrictNumber;
    private String rptAuditUploadSummaryDistrictNumber;
    private List<String> reports;

    /**
     * 
     */
    public ReportForm() {
    }

    /**
     * 
     * @return 
     */
    public List<ReportDetailForm> getAvailableReports() {
        return availableReports;
    }

    /**
     * 
     * @param availableReports 
     */
    public void setAvailableReports(List<ReportDetailForm> availableReports) {
        this.availableReports = availableReports;
    }

    /**
     * 
     * @return 
     */
    public List<String> getAvailableMonths() {
        return availableMonths;
    }

    /**
     * 
     * @param availableMonths 
     */
    public void setAvailableMonths(List<String> availableMonths) {
        this.availableMonths = availableMonths;
    }

    /**
     * 
     * @return 
     */
    public Map<String, String> getAvailableYears() {
        return availableYears;
    }

    /**
     * 
     * @param availableYears 
     */
    public void setAvailableYears(Map<String, String> availableYears) {
        this.availableYears = availableYears;
    }

    /**
     * 
     * @return 
     */
    public String getMonth() {
        return month;
    }

    /**
     * 
     * @param month 
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * 
     * @return 
     */
    public String getExtraMonth() {
        return extraMonth;
    }

    /**
     * 
     * @param extraMonth 
     */
    public void setExtraMonth(String extraMonth) {
        this.extraMonth = extraMonth;
    }

    /**
     * 
     * @return 
     */
    public String getYear() {
        return year;
    }

    /**
     * 
     * @param year 
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 
     * @return 
     */
    public List<String> getReports() {
        return reports;
    }

    /**
     * 
     * @param reports 
     */
    public void setReports(List<String> reports) {
        this.reports = reports;
    }

    /**
     * 
     * @return 
     */
    public String getRpt360DistrictNumber() {
        return rpt360DistrictNumber;
    }

    /**
     * 
     * @param rpt360DistrictNumber 
     */
    public void setRpt360DistrictNumber(String rpt360DistrictNumber) {
        this.rpt360DistrictNumber = rpt360DistrictNumber;
    }

    /**
     * 
     * @return 
     */
    public String getRptFundSummaryDistrictNumber() {
        return rptFundSummaryDistrictNumber;
    }

    /**
     * 
     * @param rptFundSummaryDistrictNumber 
     */
    public void setRptFundSummaryDistrictNumber(String rptFundSummaryDistrictNumber) {
        this.rptFundSummaryDistrictNumber = rptFundSummaryDistrictNumber;
    }

    /**
     * 
     * @return 
     */
    public String getRptMonthlyPaymentsDistrictNumber() {
        return rptMonthlyPaymentsDistrictNumber;
    }

    /**
     * 
     * @param rptMonthlyPaymentsDistrictNumber 
     */
    public void setRptMonthlyPaymentsDistrictNumber(String rptMonthlyPaymentsDistrictNumber) {
        this.rptMonthlyPaymentsDistrictNumber = rptMonthlyPaymentsDistrictNumber;
    }

    /**
     * 
     * @return 
     */
    public String getRptMonthlyComparisonDistrictNumber() {
        return rptMonthlyComparisonDistrictNumber;
    }

    /**
     * 
     * @param rptMonthlyComparisonDistrictNumber 
     */
    public void setRptMonthlyComparisonDistrictNumber(String rptMonthlyComparisonDistrictNumber) {
        this.rptMonthlyComparisonDistrictNumber = rptMonthlyComparisonDistrictNumber;
    }

    /**
     * 
     * @return 
     */
    public String getRptAuditUploadSummaryDistrictNumber() {
        return rptAuditUploadSummaryDistrictNumber;
    }

    /**
     * 
     * @param rptAuditUploadSummaryDistrictNumber 
     */
    public void setRptAuditUploadSummaryDistrictNumber(String rptAuditUploadSummaryDistrictNumber) {
        this.rptAuditUploadSummaryDistrictNumber = rptAuditUploadSummaryDistrictNumber;
    }

    /**
     * 
     * @return 
     */
    public static Map<String, String> getReportTypes() {
        Map<String, String> reportTypeDefinition = new HashMap<String, String>();

        reportTypeDefinition.put(RPT360, "StateEqual 360 Report");
        reportTypeDefinition.put(RPTFundSummary, "Funding Summary Report");
        reportTypeDefinition.put(RPTMonthlyPayment, "Monthly Payment Report");
        //reportTypeDefinition.put(RPTCsiPayment, "Charter School Institute Payments Report");
        reportTypeDefinition.put(RPTMonthlyComparison, "Monthly Payment Comparison Report");
        //reportTypeDefinition.put(RPTYtdWithholdings, "Year To Date Payments and Withholdings Report");
        //reportTypeDefinition.put(RPTMillLevy, "MillLevy Report");
        //reportTypeDefinition.put(RPTElections, "Eleections Report");
        //reportTypeDefinition.put(RPTTotalEntitlement, "Total Entitlement Report");
        //reportTypeDefinition.put(RPTNegativePayments, "Negative Payment Report");
        //reportTypeDefinition.put(RPTCofrPayments, "Coffers Payments Report");
        reportTypeDefinition.put(RPTStateWideReports, "All Other Reports");
        

        return reportTypeDefinition;
    }
}
