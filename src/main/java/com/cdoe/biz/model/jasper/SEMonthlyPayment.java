package com.cdoe.biz.model.jasper;

/**
 * <p> 
 *    <b>description</b> This a model object used in jasper report framework.
 *                        This model supports the district monthly payment report and contains values for the month.
 * </p>
 *
 * @author Tony Ford
 */
public class SEMonthlyPayment {
 /**
  * month
  */   
 private String month;
 
 /**
  * current month funding
  */
 private Double funding;
 
 /**
  * current month swap
  */
 private Double swap;
 
 /**
  * current month charter debt
  */
 private Double charterDebt;
 
 /**
  * current month audit
  */
 private Double audit;
 
 /**
  * current month csi
  */
 private Double csi;
 
 /**
  * current month other
  */
 private Double other;
 
 /**
  * net month payment
  */
 private Double netPayment;
 
 /**
  * prior month's  payment
  */
 private Double priorPayment;
 
 /**
  * variance
  */
 private Double variance;
 
 /**
  * 2011-12 total projected state share
  */
 private Double totalProjectedShare;
 
 /**
  * 2011-12 year to date state share paid
  */
 private Double totalPaidShare;
 
 /**
  * 2011-12 remaining state share to be paid
  */
 private Double totalRemainingShare;

    /**
     * 
     */
    public SEMonthlyPayment() {
    }

    /**
     * 
     * @param month
     * @param funding
     * @param swap
     * @param charterDebt
     * @param audit
     * @param csi
     * @param other
     * @param netPayment
     * @param priorPayment
     * @param variance
     * @param totalProjectedShare
     * @param totalPaidShare
     * @param totalRemainingShare 8
     */
    public SEMonthlyPayment(String month, Double funding, Double swap, Double charterDebt, Double audit, Double csi, Double other, Double netPayment, Double priorPayment, Double variance, Double totalProjectedShare, Double totalPaidShare, Double totalRemainingShare) {
        this.month = month;
        this.funding = funding;
        this.swap = swap;
        this.charterDebt = charterDebt;
        this.audit = audit;
        this.csi = csi;
        this.other = other;
        this.netPayment = netPayment;
        this.priorPayment = priorPayment;
        this.variance = variance;
        this.totalProjectedShare = totalProjectedShare;
        this.totalPaidShare = totalPaidShare;
        this.totalRemainingShare = totalRemainingShare;
    }

    
    /**
     * 
     * @param sePaymentInfo 
     */
    public SEMonthlyPayment(SeMonthlyAdapter sePaymentInfo) {
      this.month = sePaymentInfo.getCurrentMonth().getShortText();
        this.funding = sePaymentInfo.getSeMonthly().getEntitle();
        this.swap = sePaymentInfo.getSeMonthly().getSwapAdj();
        this.charterDebt = sePaymentInfo.getSeMonthly().getChrtAdj();
        this.audit = sePaymentInfo.getSeMonthly().getAuditAdj();
        this.csi = sePaymentInfo.getSeMonthly().getCsiAdminAdj();
        this.other = sePaymentInfo.getSeMonthly().getOtherAdj();
        this.netPayment = sePaymentInfo.getSeMonthly().getPayment();
        this.priorPayment = sePaymentInfo.getPriorPayment();
        this.variance = sePaymentInfo.getVariance();
        this.totalProjectedShare = sePaymentInfo.getSeMonthly().getStateEqual();
        this.totalPaidShare = sePaymentInfo.getTotalPaidShare();
        this.totalRemainingShare = sePaymentInfo.getTotalRemainingShare();
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
    public Double getFunding() {
        return funding;
    }

    /**
     * 
     * @param funding 
     */
    public void setFunding(Double funding) {
        this.funding = funding;
    }

    /**
     * 
     * @return 
     */
    public Double getSwap() {
        return swap;
    }

    /**
     * 
     * @param swap 
     */    
    public void setSwap(Double swap) {
        this.swap = swap;
    }

    /**
     * 
     * @return 
     */
    public Double getCharterDebt() {
        return charterDebt;
    }

    /**
     * 
     * @param charterDebt 
     */
    public void setCharterDebt(Double charterDebt) {
        this.charterDebt = charterDebt;
    }

    /**
     * 
     * @return 
     */
    public Double getAudit() {
        return audit;
    }

    /**
     * 
     * @param audit 
     */
    public void setAudit(Double audit) {
        this.audit = audit;
    }

    /**
     * 
     * @return 
     */
    public Double getCsi() {
        return csi;
    }

    /**
     * 
     * @param csi 
     */
    public void setCsi(Double csi) {
        this.csi = csi;
    }

    /**
     * 
     * @return 
     */
    public Double getOther() {
        return other;
    }

    /**
     * 
     * @param other 
     */
    public void setOther(Double other) {
        this.other = other;
    }

    /**
     * 
     * @return 
     */
    public Double getNetPayment() {
        return netPayment;
    }

    /**
     * 
     * @param netPayment 
     */
    public void setNetPayment(Double netPayment) {
        this.netPayment = netPayment;
    }

    /**
     * 
     * @return 
     */
    public Double getPriorPayment() {
        return priorPayment;
    }

    /**
     * 
     * @param priorPayment 
     */
    public void setPriorPayment(Double priorPayment) {
        this.priorPayment = priorPayment;
    }

    /**
     * 
     * @return 
     */
    public Double getVariance() {
        return variance;
    }

    /**
     * 
     * @param variance 
     */
    public void setVariance(Double variance) {
        this.variance = variance;
    }

    /**
     * 
     * @return 
     */
    public Double getTotalProjectedShare() {
        return totalProjectedShare;
    }

    /**
     * 
     * @param totalProjectedShare 
     */
    public void setTotalProjectedShare(Double totalProjectedShare) {
        this.totalProjectedShare = totalProjectedShare;
    }

    /**
     * 
     * @return 
     */
    public Double getTotalPaidShare() {
        return totalPaidShare;
    }

    /**
     * 
     * @param totalPaidShare 
     */
    public void setTotalPaidShare(Double totalPaidShare) {
        this.totalPaidShare = totalPaidShare;
    }

    /**
     * 
     * @return 
     */
    public Double getTotalRemainingShare() {
        return totalRemainingShare;
    }

    /**
     * 
     * @param totalRemainingShare 
     */
    public void setTotalRemainingShare(Double totalRemainingShare) {
        this.totalRemainingShare = totalRemainingShare;
    }
 
 
}
