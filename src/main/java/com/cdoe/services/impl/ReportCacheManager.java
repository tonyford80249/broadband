package com.cdoe.services.impl;

import com.cdoe.biz.model.GeneratedReport;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Tony Ford
 */
public class ReportCacheManager {
 private static ReportCacheManager instance = null;
 private Set<GeneratedReport> availableReports = new HashSet<GeneratedReport>();   

    private ReportCacheManager() {
    }
    
    /**
     * 
     * @param absolutePath
     * @return 
     */
    public GeneratedReport getReport(String absolutePath) {
     for (GeneratedReport report : this.availableReports) {
      if (report.getAbsolutePath().equals(absolutePath))  {
       return report;   
      }
     }
     
     return null;
    }
    
    /**
     * 
     * @return 
     */
    public Set<GeneratedReport> getAvailableReports() {
        return availableReports;
    }

    /**
     * 
     * @param availableReports 
     */
    public void setAvailableReports(Set<GeneratedReport> availableReports) {
        this.availableReports = availableReports;
    }
 
    
    /**
     * 
     * @return 
     */
 public synchronized static ReportCacheManager getInstance() {
   if (instance == null)  {
    instance = new ReportCacheManager();   
   }
   
   return instance;
 }
}
