package com.cdoe.services.impl.audit;

import com.cdoe.services.audit.IExceptionListReportManager;
import com.cdoe.biz.audit.IAuditSasidExceptionDAO;
import com.cdoe.biz.model.audit.AuditSasidException;
import com.cdoe.biz.model.jasper.AuditException;
import com.cdoe.biz.model.jasper.AuditExceptionDatasource;
import com.cdoe.services.impl.stateequal.ReportManagerBase;
import com.cdoe.util.FilenameConstructor;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class ExceptionListReportManager extends ReportManagerBase implements IExceptionListReportManager{
    public static class ExceptionListReportFilenameConstructor implements FilenameConstructor {
        
        private String districtNumber;
        private boolean atRisk;

        /**
         * 
         * @param districtNumber 
         */
        public ExceptionListReportFilenameConstructor(String districtNumber) {
            this.districtNumber = districtNumber;
        }

        /**
         * 
         * @param districtNumber
         * @param atRisk 
         */
        public ExceptionListReportFilenameConstructor(String districtNumber, boolean atRisk) {
            this.districtNumber = districtNumber;
            this.atRisk = atRisk;
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
             String absolutePath = null;
             
             
             if (atRisk) {
              absolutePath = defaultDirectory + defaultFileName +SEPARATOR + "AtRisk" + SEPARATOR + districtNumber + "." + defaultExtention;   
             } else {
              absolutePath = defaultDirectory + defaultFileName + SEPARATOR + districtNumber + "." + defaultExtention;   
             }
             
            

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
    public static class Reorder implements Comparator<AuditSasidException> {

        @Override
        public int compare(AuditSasidException o1, AuditSasidException o2) {
          int ans = 0;   
          
          if (ans == 0 && o1.getStudOctDistrict() == null && o2.getStudOctDistrict() != null) {
           ans = 1;   
          }
          
          if (ans == 0 && o1.getStudOctDistrict() != null && o2.getStudOctDistrict() == null) {
           ans = -1;   
          }
          
          if (ans == 0) {
           ans =  o1.getStudOctDistrict().compareTo(o2.getStudOctDistrict());
          }
          
          if (ans == 0 && o1.getFiscalYear() == null && o2.getFiscalYear() != null) {
           ans = 1;   
          }
          
          if (ans == 0 && o1.getFiscalYear() != null && o2.getFiscalYear() == null) {
           ans = -1;   
          }
          
          if (ans == 0) {
           ans = o1.getFiscalYear().compareTo(o2.getFiscalYear());  
          }
          
          if (ans == 0 && o1.getStudOctSchool() == null && o2.getStudOctSchool() != null) {
           ans = 1;   
          }
          
          if (ans == 0 && o1.getStudOctSchool() != null && o2.getStudOctSchool() == null) {
           ans = -1;     
          }
          
          if (ans == 0) {
           ans = o1.getStudOctSchool().compareTo(o2.getStudOctSchool());   
          }
          
          if (ans == 0 && o1.getStudentGrade() == null && o2.getStudentGrade() != null) {
           ans = 1;     
          }
          
          if (ans == 0 && o1.getStudentGrade() != null && o2.getStudentGrade() == null) {
           ans = -1;   
          }
          
          if (ans == 0) {
           ans = o1.getStudentGrade().compareTo(o2.getStudentGrade());   
          }
          
          if (ans == 0 && o1.getStudentLastName() == null && o2.getStudentLastName() != null) {
           ans = 1;    
          }
          
          if (ans == 0 && o1.getStudentLastName() != null && o2.getStudentLastName() == null) {
           ans = -1;    
          }
          
          if (ans == 0) {
           ans = o1.getStudentLastName().compareTo(o2.getStudentLastName());   
          }
          
          if (ans == 0 && o1.getStudentFirstName() == null && o2.getStudentFirstName() != null) {
           ans  = 1;   
          }
          
          if (ans == 0 && o1.getStudentFirstName() != null && o2.getStudentFirstName() == null) {
           ans = -1;   
          }
          
          if (ans == 0) {
           ans = o1.getStudentFirstName().compareTo(o2.getStudentFirstName());   
          }
          
          return ans;
        }
        
    }
    
    
    private static final Logger LOGGER = Logger.getLogger(ExceptionListReportManager.class);
    private IAuditSasidExceptionDAO auditSasidExceptionDAO;  
    
    /**
     * 
     * @param districtNumber
     * @param districtMap
     * @return 
     */
    @Override
    public  List<AuditException> createPupilCountExceptionList(String districtNumber,String districtName) {
        List<AuditException> collection = new ArrayList<AuditException>();
        List<AuditSasidException> result = auditSasidExceptionDAO.findPupilExceptionsByDistrict(districtNumber);
        
        Collections.sort(result, new Reorder());
        
        for (AuditSasidException exception : result) {
         collection.add(new AuditException(districtNumber, districtName, exception.getFiscalYear(), exception.getStudOctSchool(),exception.getStudentGrade(), exception.getStudentLastName(), exception.getStudentFirstName(), exception.getStudentMiddleInitial(), exception.getSasidException(), exception.getNewFTE()));   
        }
        
     return collection;   
    }
    
    /**
     * 
     * @param districtNumber
     * @param districtMap
     * @return 
     */
    @Override
    public  List<AuditException> createAtRiskExceptionList(String districtNumber, String districtName) {
        List<AuditException> collection = new ArrayList<AuditException>();
        List<AuditSasidException> result = auditSasidExceptionDAO.findAtRiskExceptionsByDistrict(districtNumber);
        
        Collections.sort(result, new Reorder());
        
        for (AuditSasidException exception : result) {
         collection.add(new AuditException(districtNumber, districtName, exception.getFiscalYear(), exception.getStudOctSchool(),exception.getStudentGrade(), exception.getStudentLastName(), exception.getStudentFirstName(), exception.getStudentMiddleInitial(), exception.getSasidException()));      
        }
        
     return collection;   
    }

    /**
     * 
     * @param collection
     * @return 
     */
    @Override
    public JRDataSource createDatasource(List<AuditException> collection) {
     return new AuditExceptionDatasource(collection);   
    }
    
    
    /**
     * 
     * @return 
     */
    @Override
    public ExceptionListReportFilenameConstructor  createFilenameConstructor(String districtNumber, boolean atRisk) {
     return new ExceptionListReportFilenameConstructor(districtNumber, atRisk);   
    }
    
    public void setAuditSasidExceptionDAO(IAuditSasidExceptionDAO auditSasidExceptionDAO) {
        this.auditSasidExceptionDAO = auditSasidExceptionDAO;
    }
                    
}
