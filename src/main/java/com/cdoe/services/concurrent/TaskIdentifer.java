package com.cdoe.services.concurrent;

/**
 *  <p>
 *    <b> description </b>  enter description.
 * </p>
 * @author Tony Ford
 */
public enum TaskIdentifer {
  MonthlyComparisonReport("monthlyComparisonReportTask"),
  MonthlyPaymentReport("monthlyPaymentReportTask"),
  YtdPaymentWithholdingReport("ytdPaymentWithholdingReportTask"),
  MonthlyPaymentProcessing("monthlyPaymentProcessingTask"),
  CofrsPaymentReport("cofrsPaymentReportTask"),
  CsiPaymentReport("csiPaymentReportTask"),
  MillLevySummaryReport("millLevySummaryReportTask"),
  TotalEntitlementReport("totalEntitlementReportTask"),
  NegativePaymentReport("negativePaymentReportTask"),
  ElectionReport("electionReportTask"),
  ExceptionListReport("exceptionListReportTask");
   
  private String beanIdentifer;

    private TaskIdentifer(String beanIdentifer) {
        this.beanIdentifer = beanIdentifer;
    }

    public String getBeanIdentifer() {
        return beanIdentifer;
    }
    
}
