package com.cdoe.biz.model.jasper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Tony Ford
 */
public class YtdPaymentCollection {
  private static final Logger LOG = Logger.getLogger(YtdPaymentCollection.class.getName());
  
  /**
   * 
   */
 private Map<DistrictInfo,SEMonthlyPayment> monthlyPayment = new HashMap<DistrictInfo,SEMonthlyPayment>();    
 
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
    public YtdPaymentCollection() {
    }

    /**
     * 
     * @return 
     */
    public Map<DistrictInfo, SEMonthlyPayment> getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * 
     * @param monthlyPayment 
     */
    public void setMonthlyPayment(Map<DistrictInfo, SEMonthlyPayment> monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
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
    public String getCurrentMonth() {
        return currentMonth;
    }

    /**
     * 
     * @param currentMonth 
     */
    public void setCurrentMonth(String currentMonth) {
        this.currentMonth = currentMonth;
    }
        
}
