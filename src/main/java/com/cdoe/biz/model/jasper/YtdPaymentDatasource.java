package com.cdoe.biz.model.jasper;

import java.util.Iterator;
import java.util.Map.Entry;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 */
public class YtdPaymentDatasource  implements JRDataSource {
    public static final String DISTRICT_NAME = "districtName";
    public static final String DISTRICT_NUMBER = "districtNumber";    
    public static final String CURRENT_FISCAL_YEAR = "fiscalYear";
    public static final String CURRENT_MONTH = "month";
    public static final String CURRENT_FUNDING = "funding";
    public static final String CURRENT_SWAP = "swap";
    public static final String CURRENT_CHARTER_DEBT = "debt";
    public static final String CURRENT_AUDIT = "audit";
    public static final String CURRENT_CSI = "csi";
    public static final String CURRENT_OTHER = "other";
    public static final String NET_PAYMENT = "netPayment";
    public static final String PRIOR_PAYMENT = "priorPayment";
    public static final String VARIANCE = "variance";
    public static final String TOTAL_PROJECTED = "projected";
    public static final String TOTAL_PAID = "paid";
    public static final String TOTAL_REMAINING = "remaining";
    public static final String RPT_CURRENT_MONTH = "currentMonth";
    
    private YtdPaymentCollection collection;      
    private  Iterator<Entry<DistrictInfo, SEMonthlyPayment>> iterator = null;
    private Entry<DistrictInfo, SEMonthlyPayment> currentYtdMonthlyPayment = null;

    /**
     * 
     * @param collection 
     */
    public YtdPaymentDatasource(YtdPaymentCollection collection) {
        this.collection = collection;
    }
    
    
    /**
     * 
     * @return
     * @throws JRException 
     */
    @Override
    public boolean next() throws JRException
    {                
         currentYtdMonthlyPayment = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.getMonthlyPayment().entrySet().iterator();
        }

        if (this.iterator == null) {
            return false;
        }

        return this.iterator.hasNext();
    }

    /**
     * 
     * @param jrf
     * @return
     * @throws JRException 
     */
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        if (currentYtdMonthlyPayment == null) {
            currentYtdMonthlyPayment = this.iterator.next();
        }

        if (jrf.getName().equals(CURRENT_FISCAL_YEAR) && collection != null) {
            return collection.getFiscalYear();
        }                 
        else if (jrf.getName().equals(RPT_CURRENT_MONTH) && collection != null) {
            return collection.getCurrentMonth();
        } 
        else if (jrf.getName().equals(DISTRICT_NUMBER) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getKey().getDistrictNumber();
        } else if (jrf.getName().equals(DISTRICT_NAME) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getKey().getDistrictName();
        } else if (jrf.getName().equals(CURRENT_MONTH) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getMonth();
        } else if (jrf.getName().equals(CURRENT_FUNDING) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getFunding();
        } else if (jrf.getName().equals(CURRENT_SWAP) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getSwap();
        } else if (jrf.getName().equals(CURRENT_CHARTER_DEBT) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getCharterDebt();
        } else if (jrf.getName().equals(CURRENT_AUDIT) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getAudit();
        } else if (jrf.getName().equals(CURRENT_CSI) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getCsi();
        } else if (jrf.getName().equals(CURRENT_OTHER) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getOther();
        } else if (jrf.getName().equals(NET_PAYMENT) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getNetPayment();
        } else if (jrf.getName().equals(PRIOR_PAYMENT) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getPriorPayment();
        } else if (jrf.getName().equals(VARIANCE) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getVariance();
        } else if (jrf.getName().equals(TOTAL_PROJECTED) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getTotalProjectedShare();
        } else if (jrf.getName().equals(TOTAL_PAID) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getTotalPaidShare();
        } else if (jrf.getName().equals(TOTAL_REMAINING) && currentYtdMonthlyPayment != null) {
            return currentYtdMonthlyPayment.getValue().getTotalRemainingShare();
        }

        return null;
    }
    
}
