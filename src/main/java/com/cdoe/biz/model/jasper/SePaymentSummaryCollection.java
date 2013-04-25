package com.cdoe.biz.model.jasper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony Ford
 */
public class SePaymentSummaryCollection {
 private String fiscalYear;
 private String fiscalMonth;
 private List<SePaymentSummary> paymentSummary = new ArrayList<SePaymentSummary>();

 /**
  * 
  */
    public SePaymentSummaryCollection() {
    }

    /**
     * 
     * @return 
     */
    public String getFiscalYear() {
        return fiscalYear;
    }

    /**
     * 
     * @param fiscalYear 
     */
    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    /**
     * 
     * @return 
     */
    public String getFiscalMonth() {
        return fiscalMonth;
    }

    /**
     * 
     * @param fiscalMonth 
     */
    public void setFiscalMonth(String fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
    }

    /**
     * 
     * @return 
     */
    public List<SePaymentSummary> getPaymentSummary() {
        return paymentSummary;
    }

    /**
     * 
     * @param paymentSummary 
     */
    public void setPaymentSummary(List<SePaymentSummary> paymentSummary) {
        this.paymentSummary = paymentSummary;
    }
 
 
}
