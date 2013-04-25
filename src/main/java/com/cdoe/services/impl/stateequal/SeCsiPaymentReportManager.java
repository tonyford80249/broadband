package com.cdoe.services.impl.stateequal;

import com.cdoe.services.stateequal.ISeCsiPaymentReportManager;
import com.cdoe.biz.impl.stateequal.CSICalculationsDAO;
import com.cdoe.biz.model.FiscalMonth;
import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.model.equal.CsiPaymentAdapter;
import com.cdoe.biz.model.jasper.CsiPayment;
import com.cdoe.biz.model.jasper.CsiPaymentCollection;
import com.cdoe.biz.model.jasper.CsiPaymentDatasource;
import com.cdoe.util.FilenameConstructor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class SeCsiPaymentReportManager extends ReportManagerBase implements ISeCsiPaymentReportManager {
   public static class CsiPaymentReporFilenameConstructor implements FilenameConstructor {

       private String month;

        /**
         *
         * @param district
         * @param month
         * @param fiscalYear
         */
        public CsiPaymentReporFilenameConstructor(String month) {
            this.month = month;
        }

        public String getMonth() {
            return month;
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
            String absolutePath = defaultDirectory + defaultFileName + SEPARATOR + month + "." + defaultExtention;

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
     private static final Logger LOGGER = Logger.getLogger(SeCsiPaymentReportManager.class);
     private CSICalculationsDAO csiDAO;

     /**
      * 
      */
    public SeCsiPaymentReportManager() {
    }
    
    /**
     * 
     * @param month
     * @return 
     */
    public FilenameConstructor createCsiPaymentReporFilenameConstructor(String month) {
     return new CsiPaymentReporFilenameConstructor(month);   
    }
    
    
    /**
     * 
     * @param fiscalYear
     * @return 
     */
    @Override
    public List<Csi> getCsiPaymentInfo(final String fiscalYear) {
      return csiDAO.getByFiscalYear(fiscalYear);   
    }
    
    /**
     * 
     * @param csiInfo
     * @return 
     */
    @Override
    public List<CsiPaymentAdapter> computeCsiPaymentInfo(List<Csi> csiInfo) {
      List<CsiPaymentAdapter> result = new ArrayList<CsiPaymentAdapter>();
      
      for (Csi csi : csiInfo) {
       CsiPaymentAdapter payment = new  CsiPaymentAdapter(csi);
       
       payment.computePayment();
       
       result.add(payment);       
      }
      
      return result;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public Map<String,String> getCSIListing() {
      Map<String,String> schools = new HashMap<String,String>();   
        
      schools.put("4010", "Animas High School");  
      schools.put("4020", "Calvert Academy");
      schools.put("4030", "Caprock Academy");  
      schools.put("4040", "Colorado Early Colleges Fort Collins");  
      schools.put("4050", "Colorado Springs Charter Academy");  
      schools.put("4060", "Colorado Springs Early Colleges");  
      schools.put("4070", "Community Leadership Academy");  
      schools.put("4080", "Early College of Arvada");
      schools.put("4090", "Frontier Charter School");  
      schools.put("4100", "Goal Academy");
      schools.put("4110", "High Point Academy");
      schools.put("4120", "Mountain Middle School");
      schools.put("4130", "Pikes Peak Prep");
      schools.put("4140", "Provost Academy Colorado");
      schools.put("4150", "Ricardo Flores Magon Academy");
      schools.put("4160", "Ross Montessori");
      schools.put("4170", "Scholars to Leaders Academy");
      schools.put("4180", "Stone Creek School");
      schools.put("4190", "The Pinnacle Charter School");
      schools.put("4200", "The Vanguard School");
      schools.put("4210", "Thomas MacLaren School");
      schools.put("4220", "TR Paul Academy");
      schools.put("4230", "Youth and Family Academy");
      
      return schools;
    }
    
    /**
     * 
     * @param csiPayments
     * @param fiscalMonth
     * @param fiscalYear
     * @return 
     */
    @Override
    public CsiPaymentDatasource createCsiPaymentDatasource(List<CsiPaymentAdapter> csiPayments, FiscalMonth fiscalMonth, String fiscalYear) {
       CsiPaymentCollection collection = new CsiPaymentCollection(); 
       collection.setFiscalYear(fiscalYear);
       collection.setMonth(fiscalMonth.name());
        
       for (CsiPaymentAdapter payment : csiPayments) {
        CsiPayment cisPayment = new CsiPayment();
        
        cisPayment.setChaterSchool(payment.getChaterSchoolOrInstitute());
        cisPayment.setCounty(payment.getDistrictName());
        cisPayment.setAssistanceWithholding(payment.getAssistanceFund());
        cisPayment.setAtRiskAdjustment(payment.getAtRiskAdjustment());
        cisPayment.setCdeWithholding(payment.getAdministrativeOverhead());
        cisPayment.setInstituteWithholding(payment.getInstituteAdminOverhead());
        cisPayment.setInterceptWithholding(payment.getInterceptProgramWithholding());
        cisPayment.setKfactor(payment.getPprFdkFactor());
        cisPayment.setPupilCount(payment.getCsiCppCnt());
        cisPayment.setMonthlyEntitlement(payment.getMonthlyEntitlement());
        cisPayment.setPerPupilRevenue(payment.getPerPupilRevenue());
        cisPayment.setTotalFunding(payment.getTotalFunding());
        cisPayment.setDistributionAmount(payment.getCharterSchoolDistribution());
        
        collection.getMonthlyPayments().add(cisPayment);
       }
     
     
       return new CsiPaymentDatasource(collection);
    }

    /**
     * 
     * @param csiDAO 
     */
    public void setCsiDAO(CSICalculationsDAO csiDAO) {
        this.csiDAO = csiDAO;
    }
    
    
    
    /**
     * 
     * @param districts 
     */
    @Override
    public void saveGenerateData(Map<String,String> districts) {
      final double[] pecentages = {0.75,0.84,0.92,0.98,1.0,0.95,0.90,0.78,0.73};
      final boolean[] hideOrShow = {false,true,false,false,true};
      final double maxPupilCount = 2500.0;
      final double maxPupilRevenue = 7000;
      final double maxKFactor = 7500;
      final double maxIp = 200000.00;
      
      
      Map<String,String> schools =  getCSIListing();
      
      Iterator<String> districtIter = districts.keySet().iterator();
      
      Iterator<String> schoolIter = schools.keySet().iterator();
      
      int index = 0;
      String districtId = districtIter.next();
      while (schoolIter.hasNext()) {
       String schoolId = schoolIter.next();
      
       Csi insertNew = new Csi();
       
       insertNew.setDistrictNumber(districtId);
       insertNew.setFiscalYear("20122013");
       insertNew.setCsiNumber(schoolId);
       insertNew.setCsiCppCnt(maxPupilCount * pecentages[index++ % pecentages.length]); //projected funded pupil count
       
       if (hideOrShow[index++ % hideOrShow.length]) {
        insertNew.setPprFdkFactor(maxKFactor  * pecentages[index++ % pecentages.length]);
       }
              
       insertNew.setPerPupilRevenue(maxPupilRevenue * pecentages[index++ % pecentages.length]);
       
       if (hideOrShow[index++ % hideOrShow.length]) {
       insertNew.setInterceptProgramWithholding(maxIp * pecentages[index++ % pecentages.length]);
       }
       
       insertNew.setAtRiskAdjustment(0.00);
       
       /**
        * SAVE DATA
        */
       csiDAO.save(insertNew);
              
       if (districtIter.hasNext()) {
        districtId = districtIter.next();   
       }
      }
      
    }
             
}
