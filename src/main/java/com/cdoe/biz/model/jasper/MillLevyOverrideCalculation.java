
package com.cdoe.biz.model.jasper;

import java.util.Formatter;

/**
 *
 * @author Sandeep Sarkar
 */
public class MillLevyOverrideCalculation {
    private Boolean bold = Boolean.FALSE;
    private Boolean indented = Boolean.FALSE;
    private String title;    
    private Number column1Value;
    private String formatString1; 
  
    /**
     * 
     * @param title
     * @param column1Value
     * @param formatString 
     */
    public MillLevyOverrideCalculation(String title, Number column1Value, String formatString) {
        this.title = title;
        this.column1Value = column1Value;
        this.formatString1 = formatString;
       
    }
    
    
    /**
     * 
     * @param title
     * @param column1Value
     * @param formatString 
     */
    public MillLevyOverrideCalculation(String title, Number column1Value, String formatString, Boolean bold, Boolean indented) {
        this.title = title;
        this.column1Value = column1Value;
        this.formatString1 = formatString;
        this.indented = indented;
        this.bold = bold;
    }
    
    public Boolean getBold() {
        return bold;
    }

    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    public Boolean getIndented() {
        return indented;
    }

    public void setIndented(Boolean indented) {
        this.indented = indented;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Number getColumn1Value() {
        return column1Value;
    }

    public void setColumn1Value(Number column1Value) {
        this.column1Value = column1Value;
    }
    
    public String getFormatString1() {
        return formatString1;
    }

    public void setFormatString1(String formatString1) {
        this.formatString1 = formatString1;
    }



    
    /**
     * 
     * @return 
     */
     public String getColumn1FormattedValue() {
       if (this.column1Value == null) {
           return " ";

       } 
       Formatter tempFormatter = new java.util.Formatter();
       return tempFormatter.format(formatString1, this.column1Value).toString();
    }
     
   
}
