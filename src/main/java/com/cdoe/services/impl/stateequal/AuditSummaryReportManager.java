package com.cdoe.services.impl.stateequal;

import com.cdoe.services.stateequal.IAuditSummaryReportManager;
import com.cdoe.biz.audit.IAuditEqualDAO;
import com.cdoe.biz.audit.IAuditFteByGrade;
import com.cdoe.biz.model.audit.AuditEqual;
import com.cdoe.biz.model.audit.AuditFteByGrade;
import com.cdoe.biz.model.jasper.ImportPriorYearAudit;
import com.cdoe.biz.model.jasper.ImportPriorYearAuditCollection;
import com.cdoe.biz.model.jasper.ImportPriorYearAuditDatasource;
import com.cdoe.util.FilenameConstructor;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tony Ford
 */
public class AuditSummaryReportManager extends ReportManagerBase implements IAuditSummaryReportManager {
   public static class AuditSummaryReportFilenameConstructor implements FilenameConstructor {

        public AuditSummaryReportFilenameConstructor() {
        }

        
       

       
        /**
         *
         * @param defaultDirectory
         * @param defaultFileName
         * @param defaultExtention
         * @return
         */
        @Override
        public String construct(String defaultDirectory, String defaultFileName, String defaultExtention) {
            Date now = new Date();
            
            String formattedDate = now.toString().replace(" ", SEPARATOR).replace(":", "-");
            
            String absolutePath = defaultDirectory + defaultFileName + SEPARATOR + formattedDate + "." + defaultExtention;

            return absolutePath;
        }

        /**
         *
         * @param defaultPath
         * @return
         */
        @Override
        public File construct(String defaultPath) {
            return new File(defaultPath);
        }
    }
   
  private IAuditEqualDAO auditEqualDAO;
  private IAuditFteByGrade auditFteByGradeDAO;
  
   
  /**
   * 
   * @param auditIds
   * @param districtMap
   * @return 
   */
    @Override
 public ImportPriorYearAuditCollection createImportPriorYearAuditCollection(List<Integer> auditIds, Map<String, String> districtMap) {
      Map<String,ImportPriorYearAudit> cache = new HashMap<String,ImportPriorYearAudit>();
        
        
      List<AuditEqual> auditEqualData = auditEqualDAO.findByAuditsOnly(auditIds);
      
      for (AuditEqual record : auditEqualData) {
       String key =  buildKey(record.getDistrictNumber(), record.getFiscalYear()); 
       
       ImportPriorYearAudit currentCalculation = null;
       
       if (cache.containsKey(key)) {
        currentCalculation = cache.get(key);   
        
        currentCalculation.setNewFundedPupilCount(currentCalculation.getNewFundedPupilCount() +  (record.getFundedPupilCount() != null ? record.getFundedPupilCount().doubleValue() : 0.0));
        currentCalculation.setRevisedTotalProgramFunding(currentCalculation.getRevisedTotalProgramFunding() + (record.getGrandTotalProgram() != null ? record.getGrandTotalProgram() : 0.0));
        currentCalculation.setRevisedPerPupilFunding(currentCalculation.getRevisedPerPupilFunding() + (record.getBasePerPupilFund() != null ? record.getBasePerPupilFund() : 0.0));
                
       }
       else {
        currentCalculation = new ImportPriorYearAudit(record.getDistrictNumber(),districtMap.get(record.getDistrictNumber()), record.getFiscalYear(), 0.0,0.0,0.0, record.getFundedPupilCount() != null ? record.getFundedPupilCount().doubleValue() : 0.0,record.getGrandTotalProgram() != null ? record.getGrandTotalProgram() : 0.0,record.getBasePerPupilFund() != null ? record.getBasePerPupilFund() : 0.0);    
        
        cache.put(key, currentCalculation);
       }
       
      }   
      
      List<AuditFteByGrade> auditFteByGradeData =auditFteByGradeDAO.findByAuditsOnly(auditIds);
      
      for (AuditFteByGrade record : auditFteByGradeData) {
       String key =  buildKey(record.getDistrictNumber(), record.getFiscalYear()); 
       
       ImportPriorYearAudit currentCalculation = null;
       
       if (cache.containsKey(key)) {
        currentCalculation = cache.get(key);   

        
        currentCalculation.setAuditedFTECount(currentCalculation.getAuditedFTECount() +  (!record.getGradeLevel().equalsIgnoreCase("CPP") && record.getFundedCount() != null ? record.getFundedCount() : 0.0));
        currentCalculation.setAuditedCPPCount(currentCalculation.getAuditedCPPCount() + (record.getGradeLevel().equalsIgnoreCase("CPP") && record.getFundedCount() != null ? record.getFundedCount() : 0.0));
        currentCalculation.setAuditedOnlineCount(currentCalculation.getAuditedOnlineCount() + (record.getOnlineTot() != null ? record.getOnlineTot() : 0.0));
                
       }
       else {
        currentCalculation = new ImportPriorYearAudit(record.getDistrictNumber(),districtMap.get(record.getDistrictNumber()), record.getFiscalYear(), !record.getGradeLevel().equalsIgnoreCase("CPP") && record.getFundedCount() != null ? record.getFundedCount() : 0.0, record.getGradeLevel().equalsIgnoreCase("CPP") && record.getFundedCount() != null ? record.getFundedCount() : 0.0, record.getOnlineTot() != null ? record.getOnlineTot() : 0.0, 0.0, 0.0, 0.0);    
        
        cache.put(key, currentCalculation);
       }   
      }
      
      ImportPriorYearAuditCollection collection = new  ImportPriorYearAuditCollection();
      
      for (ImportPriorYearAudit priorYearAudit : cache.values()) {
       collection.getAudits().add(priorYearAudit);   
      }              
  
  return collection;    
 }   
 
 /**
  * 
  * @param collection
  * @return 
  */
    @Override
 public ImportPriorYearAuditDatasource createImportPriorYearAuditDatasource(ImportPriorYearAuditCollection collection) {
    return new ImportPriorYearAuditDatasource(collection);
 }
 
  
    /**
     * 
     * @return 
     */
    @Override
    public FilenameConstructor createPaymentReportFilenameConstructor() {
        return new AuditSummaryReportFilenameConstructor();
    }
 
 /**
  * 
  * @param districtNumber
  * @param fiscalYear
  * @return 
  */
 private String buildKey(String districtNumber, String fiscalYear) {
  return districtNumber + ":" + fiscalYear;
 }

    public void setAuditEqualDAO(IAuditEqualDAO auditEqualDAO) {
        this.auditEqualDAO = auditEqualDAO;
    }

    public void setAuditFteByGradeDAO(IAuditFteByGrade auditFteByGradeDAO) {
        this.auditFteByGradeDAO = auditFteByGradeDAO;
    }
 
 
}
