
package com.cdoe.biz.model.jasper;

import java.util.Formatter;

/**
 *
 * @author Tony Ford
 */
public class SeMillLevyCertificationCalculation {
    private Boolean bold = Boolean.FALSE;
    private Boolean indented = Boolean.FALSE;
    private String title;    
    private Number column1Value;
    private Number column2Value;
    private Number column3Value;
    private String formatString1; 
    private String formatString2; 
    private String formatString3; 

    /**
     * 
     * @param title
     * @param column1Value
     * @param column2Value
     * @param column3Value
     * @param formatString 
     */
    public SeMillLevyCertificationCalculation(String title, Number column1Value, Number column2Value, Number column3Value, String formatString) {
        this.title = title;
        this.column1Value = column1Value;
        this.column2Value = column2Value;
        this.column3Value = column3Value;
        this.formatString1 = formatString;
        this.formatString2 = formatString;
        this.formatString3 = formatString;
    }
    
    /**
     * 
     * @param title
     * @param column1Value
     * @param column2Value
     * @param column3Value
     * @param formatString1
     * @param formatString2
     * @param formatString3 
     */
    public SeMillLevyCertificationCalculation(String title, Number column1Value, Number column2Value, Number column3Value, String formatString1, String formatString2, String formatString3) {
        this.title = title;
        this.column1Value = column1Value;
        this.column2Value = column2Value;
        this.column3Value = column3Value;
        this.formatString1 = formatString1;
        this.formatString2 = formatString2;
        this.formatString3 = formatString3;
    }
    
    /**
     * 
     * @param title
     * @param column1Value
     * @param column2Value
     * @param column3Value
     * @param formatString
     * @param bold
     * @param indented 
     */
    public SeMillLevyCertificationCalculation(String title, Number column1Value, Number column2Value, Number column3Value, String formatString, Boolean bold, Boolean indented) {
        this.title = title;
        this.column1Value = column1Value;
        this.column2Value = column2Value;
        this.column3Value = column3Value;
        this.formatString1 = formatString;
        this.formatString2 = formatString;
        this.formatString3 = formatString;
        this.bold = bold;
        this.indented = indented;
    }
    
    /**
     * 
     * @param title
     * @param column1Value
     * @param column2Value
     * @param column3Value
     * @param formatString1
     * @param formatString2
     * @param formatString3
     * @param bold
     * @param indented 
     */
    public SeMillLevyCertificationCalculation(String title, Number column1Value, Number column2Value, Number column3Value, String formatString1, String formatString2, String formatString3, Boolean bold, Boolean indented) {
        this.title = title;
        this.column1Value = column1Value;
        this.column2Value = column2Value;
        this.column3Value = column3Value;
        this.formatString1 = formatString1;
        this.formatString2 = formatString2;
        this.formatString3 = formatString3;
        this.bold = bold;
        this.indented = indented;
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

    public Number getColumn2Value() {
        return column2Value;
    }

    public void setColumn2Value(Number column2Value) {
        this.column2Value = column2Value;
    }

    public Number getColumn3Value() {
        return column3Value;
    }

    public void setColumn3Value(Number column3Value) {
        this.column3Value = column3Value;
    }

    public String getFormatString1() {
        return formatString1;
    }

    public void setFormatString1(String formatString1) {
        this.formatString1 = formatString1;
    }

    public String getFormatString2() {
        return formatString2;
    }

    public void setFormatString2(String formatString2) {
        this.formatString2 = formatString2;
    }

    public String getFormatString3() {
        return formatString3;
    }

    public void setFormatString3(String formatString3) {
        this.formatString3 = formatString3;
    }

   
    
    /**
     * 
     * @return 
     */
     public String getColumn1FormattedValue() {
       if (this.column1Value == null) {
           return " ";
//        if (this.getFormatString() == null) {
//         return " ";                   
//        }   
//        if (this.getFormatString().contains("%f")) {
//         this.column1Value = new Double(0.0);   
//        }
//        else if (this.getFormatString().contains("%d")) {
//         this.column1Value = new Long(0);   
//        }
//        else {
//         return "0";   
//        }
       } 
       
       Formatter tempFormatter = new java.util.Formatter();
 
       return tempFormatter.format(formatString1, this.column1Value).toString();

    }
     
     /**
     * 
     * @return 
     */
     public String getColumn2FormattedValue() {
       if (this.column2Value == null) {
           return " ";
//        if (this.getFormatString() == null) {
//         return " ";                   
//        }   
//        if (this.getFormatString().contains("%f")) {
//         this.column2Value = new Double(0.0);   
//        }
//        else if (this.getFormatString().contains("%d")) {
//         this.column2Value = new Long(0);   
//        }
//        else {
//         return "0";   
//        }
       } 
       
       Formatter tempFormatter = new java.util.Formatter();
 
       return tempFormatter.format(formatString2, this.column2Value).toString();

    }
     
     /**
     * 
     * @return 
     */
     public String getColumn3FormattedValue() {
       if (this.column3Value == null) {
          return " ";
          
//        if (this.getFormatString() == null) {
//         return " ";                   
//        }   
//        if (this.getFormatString().contains("%f")) {
//         this.column3Value = new Double(0.0);   
//        }
//        else if (this.getFormatString().contains("%d")) {
//         this.column3Value = new Long(0);   
//        }
//        else {
//         return "0";   
//        }
       } 
       
       Formatter tempFormatter = new java.util.Formatter();
 
       return tempFormatter.format(formatString3, this.column3Value).toString();

    }
}
