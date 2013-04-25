package com.cdoe.biz.model;

import com.cdoe.util.CalendarMonth;


/**
 *
 * @author Tony Ford
 */
public enum FiscalMonth {
 JULY(1,"July","JUL"),
 AUGUST(2,"August","AUG"),
 SEPTEMBER(3,"September","SEP"),
 OCTOBER(4,"October","OCT"),
 NOVEMBER(5,"November","NOV"),
 DECEMBER(6,"December","DEC"),
 JANUARY(7,"January","JAN"),
 FEBRUARY(8,"February","FEB"),
 MARCH(9,"March","MAR"),
 APRIL(10,"April","APR"),
 MAY(11,"May","MAY"),
 JUNE(12,"June","JUN");
 
 private int value;
 private String text;
 private String shortText;

  /**
   * 
   * @param value
   * @param text
   * @param shortText 
   */
    private FiscalMonth(int value, String text, String shortText) {
        this.value = value;
        this.text = text;
        this.shortText = shortText;
    }
 


    /**
     * 
     * @return 
     */
    public int getValue() {
        return value;
    }

    /**
     * 
     * @return 
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @return 
     */
    public String getShortText() {
        return shortText;
    }
    
    /**
     * 
     * @return 
     */
    public static FiscalMonth getCurrentMonth() {
     CalendarMonth currentMonth = CalendarMonth.getCurrentMonth();   
     
     
     return getInstance(currentMonth.name());
    }

    /**
     * 
     * @param month
     * @return 
     */
     public static FiscalMonth getInstance(String month) {
        for (FiscalMonth candidate : JULY.values()) {
         if (candidate.name().equalsIgnoreCase(month)) {
          return candidate;  
         }  
        }
        
        return null;
    }
    
    /**
     * 
     * @param month
     * @return 
     */
     public static FiscalMonth getInstance(Integer month) {
        for (FiscalMonth candidate : JULY.values()) {
         if (candidate.getValue() == month) {
          return candidate;  
         }  
        }
        
        return null;
    }
   
      /**
     *
     * @return
     */
    public FiscalMonth next() {
        int select = this.ordinal() + 1;
        if (select > 11) {
            select = 0;
        }

        for (FiscalMonth candidate : values()) {
            if (candidate.ordinal() == select) {
                return candidate;
            }
        }

        return null;
    }

    /**
     *
     * @return
     */
    public FiscalMonth prev() {
        int select = this.ordinal() - 1;
        if (select < 0) {
            select = 11;
        }

        for (FiscalMonth candidate : values()) {
            if (candidate.ordinal() == select) {
                return candidate;
            }
        }

        return null;
    }
 
}
