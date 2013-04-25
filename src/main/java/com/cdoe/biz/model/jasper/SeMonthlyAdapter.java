package com.cdoe.biz.model.jasper;

import com.cdoe.biz.model.FiscalMonth;
import com.cdoe.biz.model.equal.SeMonthly;

/**
 *
 * @author Tony Ford
 */
public class SeMonthlyAdapter implements Comparable<SeMonthlyAdapter> {
 private SeMonthly seMonthly;
 private Double priorPayment;
 private Double variance;
 private Double totalPaidShare;
 private Double totalRemainingShare;
 private FiscalMonth currentMonth;

    public SeMonthlyAdapter(SeMonthly seMonthly) {
        this.seMonthly = seMonthly;
        
        this.currentMonth = FiscalMonth.getInstance(seMonthly.getMonth());
    }

    public SeMonthly getSeMonthly() {
        return seMonthly;
    }

    public void setSeMonthly(SeMonthly seMonthly) {
        this.seMonthly = seMonthly;
    }

    public Double getPriorPayment() {
        return priorPayment;
    }

    public void setPriorPayment(Double priorPayment) {
        this.priorPayment = priorPayment;
    }

    public Double getVariance() {
        return variance;
    }

    public void setVariance(Double variance) {
        this.variance = variance;
    }

    public Double getTotalPaidShare() {
        return totalPaidShare;
    }

    public void setTotalPaidShare(Double totalPaidShare) {
        this.totalPaidShare = totalPaidShare;
    }

    public Double getTotalRemainingShare() {
        return totalRemainingShare;
    }

    public void setTotalRemainingShare(Double totalRemainingShare) {
        this.totalRemainingShare = totalRemainingShare;
    }

    public FiscalMonth getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(FiscalMonth currentMonth) {
        this.currentMonth = currentMonth;
    }

    @Override
    public int compareTo(SeMonthlyAdapter other) {
     return this.currentMonth.compareTo(other.currentMonth);   
    }
  
}
