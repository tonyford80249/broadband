
package com.cdoe.biz.model.jasper;

import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 */
public class SePaymentSummaryDatasource implements JRDataSource{
    public static final String DISTRICT_NAME = "districtName";
    public static final String DISTRICT_NUMBER = "districtNumber";    
    public static final String CURRENT_FISCAL_YEAR = "fiscalYear";
    public static final String CURRENT_MONTH = "month";
    public static final String ACCOUNT = "accountingNumber";
    public static final String MONTHLY_ENTITLEMENT = "entitlement";
    public static final String MONTHLY_PAYMENT = "payment";
    public static final String YTD_SWAP = "swap12";
    public static final String YTD_CHARTER = "charter12";
    public static final String YTD_AUDIT = "audit12";
    public static final String YTD_CSI = "csi12";
    public static final String YTD_OTHER = "other12";
    
    
    private SePaymentSummaryCollection collection;      
    private  Iterator<SePaymentSummary> iterator = null;
    private SePaymentSummary currentSePaymentSummary = null;

    /**
     * 
     * @param collection 
     */
    public SePaymentSummaryDatasource(SePaymentSummaryCollection collection) {
        this.collection = collection;
    }
    
    
    @Override
    public boolean next() throws JRException {
          currentSePaymentSummary = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.getPaymentSummary().iterator();
        }

        if (this.iterator == null) {
            return false;
        }

        return this.iterator.hasNext();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        if (currentSePaymentSummary == null) {
            currentSePaymentSummary = this.iterator.next();
        }

        if (jrf.getName().equals(CURRENT_FISCAL_YEAR) && collection != null) {
            return collection.getFiscalYear();
        }                 
        else if (jrf.getName().equals(CURRENT_MONTH) && collection != null) {
            return collection.getFiscalMonth();
        } 
        else if (jrf.getName().equals(DISTRICT_NUMBER) && currentSePaymentSummary != null) {
            return currentSePaymentSummary.getDistrictNumber();
        } else if (jrf.getName().equals(DISTRICT_NAME) && currentSePaymentSummary != null) {
            return currentSePaymentSummary.getDistrictName();
        } else if (jrf.getName().equals(ACCOUNT) && currentSePaymentSummary != null) {
            return currentSePaymentSummary.getAccountingNumber();
        } else if (jrf.getName().equals(MONTHLY_ENTITLEMENT) && currentSePaymentSummary != null) {
            return currentSePaymentSummary.getEntitlement();
        } else if (jrf.getName().equals(MONTHLY_PAYMENT) && currentSePaymentSummary != null) {
            return currentSePaymentSummary.getPayment();
        } else if (jrf.getName().equals(YTD_SWAP) && currentSePaymentSummary != null) {
            return currentSePaymentSummary.getSwap12();
        } else if (jrf.getName().equals(YTD_CHARTER) && currentSePaymentSummary != null) {
            return currentSePaymentSummary.getCharter12();
        } else if (jrf.getName().equals(YTD_AUDIT) && currentSePaymentSummary != null) {
            return currentSePaymentSummary.getAudit12();
        } else if (jrf.getName().equals(YTD_CSI) && currentSePaymentSummary != null) {
            return currentSePaymentSummary.getCsi12();
        } else if (jrf.getName().equals(YTD_OTHER) && currentSePaymentSummary != null) {
            return currentSePaymentSummary.getOther12();
        } 

        return null;
    }
    
}
