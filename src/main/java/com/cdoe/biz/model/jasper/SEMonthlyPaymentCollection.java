package com.cdoe.biz.model.jasper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *     <b>description</b> This a model object used in jasper report framework.
 *                        This model supports the district monthly payment report.
 * </p>
 *
 * @author Tony Ford
 */
public class SEMonthlyPaymentCollection {
    /**
     * 
     */
 private List<SEMonthlyPayment> monthlyPayment = new ArrayList<SEMonthlyPayment>();  
 
 /**
  * fiscal year in which payments where made
  */
  private String fiscalYear;
  
  /**
   * month in which report was generated.
   */
  private String currentMonth;
  
  /**
   * 
   */
  private String districtName;
  
  /*
   * 
   */
  private String districtNumber;
  
  /**
   * 
   */
  private Date currentDate;

    /**
     * 
     */
    public SEMonthlyPaymentCollection() {
    }

    /**
     * 
     * @return 
     */
    public List<SEMonthlyPayment> getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * 
     * @param monthlyPayment 
     */
    public void setMonthlyPayment(List<SEMonthlyPayment> monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(String currentMonth) {
        this.currentMonth = currentMonth;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictNumber() {
        return districtNumber;
    }

    public void setDistrictNumber(String districtNumber) {
        this.districtNumber = districtNumber;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
 
 
}
