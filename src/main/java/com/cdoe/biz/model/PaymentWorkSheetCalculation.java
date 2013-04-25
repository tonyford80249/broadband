package com.cdoe.biz.model;

import java.util.Formatter;

/**
 *
 * @author dyn-9
 */
public class PaymentWorkSheetCalculation {
   
    private String title;
    private Number value;
    private String formatString;    

    public PaymentWorkSheetCalculation(String title, Number value, String formatString) {
        this.title = title;
        this.value = value;
        this.formatString = formatString;
    }

    public String getTitle() {
        return title;
    }

    public Number getValue() {
        return value;
    }

    public String getFormatString() {
        return formatString;
    }

    public String getFormattedValue() {
       if (this.value == null) {
        if (this.getFormatString() == null) {
         return " ";                   
        }   
        if (this.getFormatString().contains("%f")) {
         this.value = new Double(0.0);   
        }
        else if (this.getFormatString().contains("%d")) {
         this.value = new Long(0);   
        }
        else {
         return "0";   
        }
       } 
       
       Formatter tempFormatter = new java.util.Formatter();
 
       return tempFormatter.format(formatString, value).toString();

    }
    
    
}
