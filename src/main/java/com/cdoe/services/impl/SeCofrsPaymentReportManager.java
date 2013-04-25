package com.cdoe.services.impl;

import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.jasper.SePaymentSummary;
import com.cdoe.biz.model.jasper.SePaymentSummaryCollection;
import com.cdoe.biz.model.jasper.SePaymentSummaryDatasource;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.services.ISeCofrsPaymentReportManager;
import com.cdoe.services.impl.stateequal.ReportManagerBase;
import com.cdoe.util.FilenameConstructor;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class SeCofrsPaymentReportManager extends ReportManagerBase implements ISeCofrsPaymentReportManager {

    public static class CofrsPaymentReportFilenameConstructor implements FilenameConstructor {

       private String month;
       private Collection<String> disitricts;

        /**
         *
         * @param district
         * @param month
         * @param fiscalYear
         */
        public CofrsPaymentReportFilenameConstructor(String month) {
            this.month = month;
        }

        public String getMonth() {
            return month;
        }

        public CofrsPaymentReportFilenameConstructor(String month, Collection<String> disitricts) {
            this.month = month;
            this.disitricts = disitricts;
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
            
            if (this.disitricts != null && !this.disitricts.isEmpty()) {
               absolutePath = defaultDirectory + defaultFileName  + SEPARATOR + zipDistricts() + month + "." + defaultExtention;                 
            }
            else {
             absolutePath = defaultDirectory + defaultFileName + SEPARATOR + month + "." + defaultExtention;   
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
        
        /**
         * 
         * @return 
         */
        public String zipDistricts() {
         String zipped = "";
         
         int count = 0;
         for (String districtNumber : this.disitricts)   {
          ++count;
          if (count > 4) {
                 break;
          }   
          zipped += districtNumber + SEPARATOR;
         }
         
         return zipped;
        }
    }
    private static final Logger LOGGER = Logger.getLogger(SeCofrsPaymentReportManager.class);
    private IStateEqualDAO stateEqualDAO;

    /**
     * 
     */
    public SeCofrsPaymentReportManager() {
    }

    /**
     * 
     * @param districtNumber
     * @param fiscalYear
     * @return 
     */
    @Override
    public List<StateEqual> getCofrsPaymentInfo(String fiscalYear) {
        return stateEqualDAO.findByFiscalYear(fiscalYear);
    }

    /**
     * 
     * @param districtMap
     * @param fiscalYear
     * @param month
     * @param cofrsPaymentInfo
     * @return 
     */
    @Override
    public JRDataSource createMonthlyPaymnetDatasource(Map<String, String> districtMap, String fiscalYear, String month, List<StateEqual> cofrsPaymentInfo) {
        SePaymentSummaryCollection collection = new SePaymentSummaryCollection();

        collection.setFiscalYear(fiscalYear);
        collection.setFiscalMonth(month);

        for (StateEqual stateEqualRecord : cofrsPaymentInfo) {
            SePaymentSummary cofrsPayment = new SePaymentSummary();

            cofrsPayment.setDistrictNumber(stateEqualRecord.getDistrictNumber());
            cofrsPayment.setDistrictName(districtMap.get(stateEqualRecord.getDistrictNumber()));
            cofrsPayment.setEntitlement(stateEqualRecord.getMonthEntitle());
            cofrsPayment.setPayment(stateEqualRecord.getMonthPayment());
            cofrsPayment.setAccountingNumber(stateEqualRecord.getDistrictNumber());
            cofrsPayment.setAudit12(stateEqualRecord.getYtdAuditRepay());
            cofrsPayment.setCharter12(stateEqualRecord.getCharterDebtYtd());
            cofrsPayment.setCsi12(stateEqualRecord.getCsiAdminYtd());
            cofrsPayment.setOther12(stateEqualRecord.getYtdOther());
            cofrsPayment.setSwap12(stateEqualRecord.getYtdSwap());

            collection.getPaymentSummary().add(cofrsPayment);
        }

        return new SePaymentSummaryDatasource(collection);
    }
    
    
    /**
     * 
     * @param month
     * @return 
     */
    @Override
    public FilenameConstructor createCofrsPaymentReportFilenameConstructor(String month) {
        return new CofrsPaymentReportFilenameConstructor(month);
    }
    
    
    /**
     * 
     * @param month
     * @param districts
     * @return 
     */
    @Override
    public FilenameConstructor createCofrsPaymentReportFilenameConstructor(String month, Collection<String> districts) {
        return new CofrsPaymentReportFilenameConstructor(month,districts);
    }
    

    public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
        this.stateEqualDAO = stateEqualDAO;
    }
    
    
    
}
