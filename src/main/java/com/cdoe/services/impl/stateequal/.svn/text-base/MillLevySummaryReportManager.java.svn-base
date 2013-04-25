package com.cdoe.services.impl.stateequal;

import com.cdoe.services.stateequal.IMillLevySummaryReportManager;
import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.biz.model.jasper.SeFinallMillLevySummary;
import com.cdoe.biz.model.jasper.SeFinallMillLevySummaryDatasource;
import com.cdoe.biz.stateequal.IMillLevyDAO;
import com.cdoe.util.FilenameConstructor;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tony Ford
 */
public class MillLevySummaryReportManager  extends ReportManagerBase implements IMillLevySummaryReportManager {
  public static class MillLevySummaryReportFilenameConstructor implements FilenameConstructor {

        public MillLevySummaryReportFilenameConstructor() {
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
  
  /**
   * 
   */
  private IMillLevyDAO millLevyDAO;

    public MillLevySummaryReportManager() {
    }
 
  
  
  /**
   * 
   * @param fiscalYear
   * @param districtMap
   * @return 
   */
    @Override
 public List<SeFinallMillLevySummary> createCollection(String fiscalYear, Map<String, String> districtMap, Map<String, String> countyMap) {
        List<SeFinallMillLevySummary> result = new ArrayList<SeFinallMillLevySummary>();
        List<MillLevy> millLevyInfo = millLevyDAO.findByFiscalYear(fiscalYear);
        
        for (MillLevy millLevy : millLevyInfo) {
         //String fiscalYear, String county, String districtName, String districtNumber, Double netAssessedValuation, Double totalProgramMillLevy, Double categoricalBuyoutMillLevy, Double holdHarmlessMillLevy, Double excessHoldHarmlessMillLevy, Double voterApprovedMillLevy, Double abatementMillLevy, Double bondRedemptionMillLevy, Double transportationMillLevy, Double specialBuildingTechnologyMillLevy, Double fulldayKindergartenMillLevy, Double otherMillLevy, Double totalMillLevy,Boolean totalRecord   
          result.add(new SeFinallMillLevySummary(fiscalYear,countyMap.get(millLevy.getDistrictNumber()), districtMap.get(millLevy.getDistrictNumber()), millLevy.getDistrictNumber(), millLevy.getNetAssessedValuation(), null, null, null, null, null, null, null, null, null, null, null, null));      
          result.add(new SeFinallMillLevySummary(fiscalYear,countyMap.get(millLevy.getDistrictNumber()), districtMap.get(millLevy.getDistrictNumber()), millLevy.getDistrictNumber(), millLevy.getNetAssessedValuation(), millLevy.getCertifiedTpMillLevy(), millLevy.getCertifiedCatbuyMillLevy(), millLevy.getCertifiedHhMillLevy(), millLevy.getCertifiedEhhMillLevy(), millLevy.getCertifiedOverrideMillLevy(), millLevy.getCertifiedAbateMillLevy(), millLevy.getCertifiedBondMillLevy(), millLevy.getCertifiedTransportMillLevy(), millLevy.getCertifiedSbtMillLevy(), millLevy.getCertifiedFdkMillLevy(), millLevy.getCertifiedOtherMillLevy(), millLevy.getTotalAllCertifiedMills(),true));    
        }
  
  
  return result;   
 }
 
 /**
  * 
  * @param summaryData
  * @return 
  */
    @Override
 public SeFinallMillLevySummaryDatasource createMillLevySummaryDatasource(List<SeFinallMillLevySummary> summaryData) {
  return new SeFinallMillLevySummaryDatasource(summaryData);
 }   
 
 
 /**
  * 
  * @return 
  */
    @Override
 public MillLevySummaryReportFilenameConstructor createMillLevySummaryReportFilenameConstructor() {
  return new MillLevySummaryReportFilenameConstructor();   
 }

    public void setMillLevyDAO(IMillLevyDAO millLevyDAO) {
        this.millLevyDAO = millLevyDAO;
    }
 
 
}
