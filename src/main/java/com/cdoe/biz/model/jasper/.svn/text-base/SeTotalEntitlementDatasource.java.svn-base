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
public class SeTotalEntitlementDatasource implements JRDataSource {
    public static final String FISCAL_YEAR = "fiscalYear";    
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String DISTIRCT_NAME = "districtName";
    public static final String PREVIOUS_STATE_EQUAL = "previousStateEqual";
    public static final String CURRENT_STATE_EQUAL = "currentStateEqual";
    
        
    private List<SeTotalEntitlement> collection;
    private Iterator<SeTotalEntitlement> iterator = null;
    private SeTotalEntitlement currentSeTotalEntitlement = null;

    /**
     * 
     * @param collection 
     */
    public SeTotalEntitlementDatasource(List<SeTotalEntitlement> collection) {
        this.collection = collection;
    }
    
    
    
    @Override
    public boolean next() throws JRException {
        currentSeTotalEntitlement = null;

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
        if (currentSeTotalEntitlement == null) {
            currentSeTotalEntitlement = this.iterator.next();
        }

        if (jrf.getName().equals(FISCAL_YEAR) && currentSeTotalEntitlement != null) {
            return currentSeTotalEntitlement.getFiscalYear();
        } else if (jrf.getName().equals(DISTRICT_NUMBER) && currentSeTotalEntitlement != null) {
            return currentSeTotalEntitlement.getDistrictNumber();
        } else if (jrf.getName().equals(DISTIRCT_NAME) && currentSeTotalEntitlement != null) {
            return currentSeTotalEntitlement.getDistrictName();
        } else if (jrf.getName().equals(PREVIOUS_STATE_EQUAL) && currentSeTotalEntitlement != null) {
            return currentSeTotalEntitlement.getPreviousStateEqual();
        } else if (jrf.getName().equals(CURRENT_STATE_EQUAL) && currentSeTotalEntitlement != null) {
            return currentSeTotalEntitlement.getCurrentStateEqual();
        } 
        
        
        
        return null;
    }
    
}
