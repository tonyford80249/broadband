package com.cdoe.biz.model.jasper;

import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 */
public class NegativePaymentDatasource implements JRDataSource {
    public static final String COUNTY = "county";    
    public static final String FISCAL_YEAR = "fiscalYear";    
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String DISTIRCT_NAME = "districtName";
    public static final String MONTH_ENTITLEMENT = "monthlyEntitlement";
    public static final String CURRENT_ENTITLEMENT = "currentEntitlement";
    public static final String PREVIOUS_ENTITLEMENT = "previousEntitlement";
    
    
    
    private List<NegativePayment> collection;
    private Iterator<NegativePayment> iterator = null;
    private NegativePayment currentNegativePayment = null;

    /**
     * 
     * @param collection 
     */
    public NegativePaymentDatasource(List<NegativePayment> collection) {
        this.collection = collection;
    }
    
    
    @Override
    public boolean next() throws JRException {
        currentNegativePayment = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.iterator();
        }

        if (this.iterator == null) {
            return false;
        }

        return this.iterator.hasNext();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        if (currentNegativePayment == null) {
            currentNegativePayment = this.iterator.next();
        }

        if (jrf.getName().equals(FISCAL_YEAR) && currentNegativePayment != null) {
            return currentNegativePayment.getFiscalYear();
        } else if (jrf.getName().equals(DISTRICT_NUMBER) && currentNegativePayment != null) {
            return currentNegativePayment.getDistrictNumber();
        } else if (jrf.getName().equals(DISTIRCT_NAME) && currentNegativePayment != null) {
            return currentNegativePayment.getDistrictName();
        } else if (jrf.getName().equals(MONTH_ENTITLEMENT) && currentNegativePayment != null) {
            return currentNegativePayment.getMonthlyEntitlement();
        } else if (jrf.getName().equals(CURRENT_ENTITLEMENT) && currentNegativePayment != null) {
            return currentNegativePayment.getCurrentEntitlement();
        } else if (jrf.getName().equals(PREVIOUS_ENTITLEMENT) && currentNegativePayment != null) {
            return currentNegativePayment.getPreviousEntitlement();
        } else if (jrf.getName().equals(COUNTY) && currentNegativePayment != null) {
            return currentNegativePayment.getCounty();
        } 
        
        
        
        return null;
    }
    
}
