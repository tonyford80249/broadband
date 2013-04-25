package com.cdoe.biz.model.jasper;

import java.util.Formatter;

/**
 *
 * @author Tony Ford
 */
public class StateEqual360Calculation {
    private Boolean heading = Boolean.FALSE;
    private Boolean heading2 = Boolean.FALSE;
    private String title;    
    private Number value;
    private String formatString;    

    /**
     * 
     * @param title
     * @param value
     * @param formatString 
     */
    public StateEqual360Calculation(String title, Number value, String formatString) {
        this.title = title;
        this.value = value;
        this.formatString = formatString;
    }

    /**
     * 
     * @param heading
     * @param title
     * @param value
     * @param formatString 
     */
    public StateEqual360Calculation(Boolean heading, String title, Number value, String formatString) {
        this.heading = heading;
        this.title = title;
        this.value = value;
        this.formatString = formatString;
    }

    public StateEqual360Calculation(Boolean heading2, Boolean heading, String title, Number value, String formatString) {
        this.heading2 = heading2;
        this.heading = heading;
        this.title = title;
        this.value = value;
        this.formatString = formatString;
    }
    /**
     * 
     * @return 
     */
    public Boolean getHeading() {
        return heading;
    }

    /**
     * 
     * @param heading 
     */
    public void setHeading(Boolean heading) {
        this.heading = heading;
    }

    public Boolean getHeading2() {
        return heading2;
    }

    public void setHeading2(Boolean heading2) {
        this.heading2 = heading2;
    }

    /**
     * 
     * @return 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return 
     */
    public Number getValue() {
        return value;
    }

    /**
     * 
     * @param value 
     */
    public void setValue(Number value) {
        this.value = value;
    }

    /**
     * 
     * @return 
     */
    public String getFormatString() {
        return formatString;
    }

    /**
     * 
     * @param formatString 
     */
    public void setFormatString(String formatString) {
        this.formatString = formatString;
    }
    
    /**
     * 
     * @return 
     */
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
