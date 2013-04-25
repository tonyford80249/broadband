/**
 * 
 */
/*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.jasper;

/**
 * @author ResQSoft Engineer
 *
 */
public enum ReportOutputFormat {
    
    PDF("PDF","application/pdf", "pdf"), HTML("HTML","text/html", "html"), RTF("RTF","application/rtf", "rtf"), CSV(
           "CSV", "text/csv", "csv");
    
    private String contentType;
    
    private String fileExt;
    
    private String name;
    
    private ReportOutputFormat(String name, String ct, String ext) {
        this.name = name;
        this.contentType = ct;
        this.fileExt = ext;
    }
    
    /**
     * @return the contentType
     */
    public String getContentType() {

        return this.contentType;
    }
    
    
    /**
     * @return the fileExt
     */
    public String getFileExt() {

        return this.fileExt;
    }
    
    
    /**
     * @return the name
     */
    public String getName() {

        return this.name;
    }
    
}
