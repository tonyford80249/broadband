package com.cdoe.biz.model.jasper;

import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 */
public class SEMonthlyPaymentDatasource implements JRDataSource {

    public static final String DISTRICT_NAME = "districtName";
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String CURRENT_DATE = "currentDate";
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
    private SEMonthlyPaymentCollection collection;
    private Iterator<SEMonthlyPayment> iterator = null;
    private SEMonthlyPayment currentSEMonthlyPayment = null;

    /**
     *
     * @param collection
     */
    public SEMonthlyPaymentDatasource(SEMonthlyPaymentCollection collection) {
        this.collection = collection;
    }

    /**
     *
     * @return @throws JRException
     */
    public boolean next() throws JRException {
        currentSEMonthlyPayment = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.getMonthlyPayment().iterator();
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
    public Object getFieldValue(JRField jrf) throws JRException {
        if (currentSEMonthlyPayment == null) {
            currentSEMonthlyPayment = this.iterator.next();
        }

        if (jrf.getName().equals(CURRENT_FISCAL_YEAR) && collection != null) {
            return collection.getFiscalYear();
        } 
        else if (jrf.getName().equals(CURRENT_DATE) && collection != null) {
            return collection.getCurrentDate();
        }
        else if (jrf.getName().equals(DISTRICT_NUMBER) && collection != null) {
            return collection.getDistrictNumber();
        }
        else if (jrf.getName().equals(DISTRICT_NAME) && collection != null) {
            return collection.getDistrictName();
        }
        else if (jrf.getName().equals(RPT_CURRENT_MONTH) && collection != null) {
            return collection.getCurrentMonth();
        } else if (jrf.getName().equals(CURRENT_MONTH) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getMonth();
        } else if (jrf.getName().equals(CURRENT_FUNDING) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getFunding();
        } else if (jrf.getName().equals(CURRENT_SWAP) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getSwap();
        } else if (jrf.getName().equals(CURRENT_CHARTER_DEBT) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getCharterDebt();
        } else if (jrf.getName().equals(CURRENT_AUDIT) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getAudit();
        } else if (jrf.getName().equals(CURRENT_CSI) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getCsi();
        } else if (jrf.getName().equals(CURRENT_OTHER) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getOther();
        } else if (jrf.getName().equals(NET_PAYMENT) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getNetPayment();
        } else if (jrf.getName().equals(PRIOR_PAYMENT) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getPriorPayment();
        } else if (jrf.getName().equals(VARIANCE) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getVariance();
        } else if (jrf.getName().equals(TOTAL_PROJECTED) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getTotalProjectedShare();
        } else if (jrf.getName().equals(TOTAL_PAID) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getTotalPaidShare();
        } else if (jrf.getName().equals(TOTAL_REMAINING) && currentSEMonthlyPayment != null) {
            return currentSEMonthlyPayment.getTotalRemainingShare();
        }

        return null;
    }
}
