package com.cdoe.biz.model.jasper;

import java.util.Formatter;

/**
 * <p> 
 *    <b>description</b> This a model object used in jasper report framework.
 *                        This model supports the district monthly payment report and contains values for the month.
 * </p>
 *
 * @author Tony Ford
 */
public class SeMonthlyPaymentComparisonCalculation {
 public static final int BLANK_LINE = 1;
 public static final int TOTAL_LINE = 2;
 public static final int HEADER_LINE = 3;
 public static final int UNDER_LINE = 4;
         
 private String description;
 private Number calculation1;
 private String formatString1;  
 private Number calculation2; 
 private String formatString2;
 private Integer formatCode = 0;

 /**
  * 
  * @param description
  * @param calculation1
  * @param formatString1
  * @param calcualtion2
  * @param formatString2 
  */
    public SeMonthlyPaymentComparisonCalculation(String description, Number calculation1, String formatString1, Number calcualtion2, String formatString2) {
        this.description = description;
        this.calculation1 = calculation1;
        this.formatString1 = formatString1;
        this.calculation2 = calcualtion2;
        this.formatString2 = formatString2;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        switch(this.formatCode) {
           case 1 : return "";
           case 2 : return "";           
        }
        
        return description;
    }

    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return 
     */
    public Number getCalculation1() {
        return calculation1;
    }

    /**
     * 
     * @param calculation1 
     */
    public void setCalculation1(Number calculation1) {
        this.calculation1 = calculation1;
    }

    /**
     * 
     * @return 
     */
    public String getFormatString1() {
        return formatString1;
    }

    /**
     * 
     * @param formatString1 
     */
    public void setFormatString1(String formatString1) {
        this.formatString1 = formatString1;
    }

    /**
     * 
     * @return 
     */
    public Number getCalcualtion2() {
        return calculation2;
    }

    /**
     * 
     * @param calcualtion2 
     */
    public void setCalcualtion2(Number calcualtion2) {
        this.calculation2 = calcualtion2;
    }

    /**
     * 
     * @return 
     */
    public String getFormatString2() {
        return formatString2;
    }

    /**
     * 
     * @param formatString2 
     */
    public void setFormatString2(String formatString2) {
        this.formatString2 = formatString2;
    }

    public Number getCalculation2() {
        return calculation2;
    }

    public void setCalculation2(Number calculation2) {
        this.calculation2 = calculation2;
    }

    public Integer getFormatCode() {
        return formatCode;
    }

    public void setFormatCode(Integer formatCode) {
        this.formatCode = formatCode;
    }
    
    
    
    /**
     * 
     * @return 
     */
    public String getFormattedValue1() {
       switch(this.formatCode) {
           case 1 : return "";
           case 2 : return "_____________";
           case 3 : return "";           
       }
       
       if (this.calculation1 == null) {
        if (this.getFormatString1() == null) {
         return " ";                   
        }   
        if (this.getFormatString1().contains("%f")) {
         this.calculation1 = new Double(0.0);   
        }
        else if (this.getFormatString1().contains("%d")) {
         this.calculation1 = new Long(0);   
        }
        else {
         return "0";   
        }
       } 
       
       Formatter tempFormatter = new java.util.Formatter();
 
       return tempFormatter.format(this.formatString1, this.calculation1).toString();

    }
    
    /**
     * 
     * @return 
     */
    public String getFormattedValue2() {
       switch(this.formatCode) {
           case 1 : return "";
           case 2 : return "_____________";
           case 3 : return "";           
       }
       
       if (this.calculation2== null) {
        if (this.getFormatString2() == null) {
         return " ";                   
        }   
        if (this.getFormatString2().contains("%f")) {
         this.calculation2 = new Double(0.0);   
        }
        else if (this.getFormatString2().contains("%d")) {
         this.calculation2 = new Long(0);   
        }
        else {
         return "0";   
        }
       } 
       
       Formatter tempFormatter = new java.util.Formatter();
 
       return tempFormatter.format(this.formatString2, this.calculation2).toString();

    }
 
}
