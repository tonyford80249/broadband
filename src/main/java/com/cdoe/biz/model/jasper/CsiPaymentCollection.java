package com.cdoe.biz.model.jasper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony Ford
 */
public class CsiPaymentCollection {
 private String fiscalYear;
 private String month;
 private List<CsiPayment> monthlyPayments = new ArrayList<CsiPayment>();

    public CsiPaymentCollection() {
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<CsiPayment> getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setMonthlyPayments(List<CsiPayment> monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }
 
}
