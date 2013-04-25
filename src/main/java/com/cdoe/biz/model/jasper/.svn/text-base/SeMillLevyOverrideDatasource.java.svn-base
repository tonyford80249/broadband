package com.cdoe.biz.model.jasper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 */
public class SeMillLevyOverrideDatasource implements JRDataSource {
    public static final String DISTRICT_NAME = "districtName";
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String TAX_YEAR = "taxYear";
    public static final String GRAND_TOTAL_PROG = "grandTotalProg";
    public static final String COST_OF_LIVING = "costOfLiving";
    public static final String MIN_OVERRIDE_ALLOWED = "minOverrideAllowed";
    public static final String QUARTER_OF_TOTAL_PROG = "quarterOfTotalProg";
    public static final String TOTAL_OVERRIDE_ALLOWED = "totalOverrideAllowed";
    public static final String ALLOWABLE_OVERRIDE = "allowableOverride";
    public static final String PROPERTY_TAX_REVENUE = "propertyTaxRevenue";
    public static final String REMAINING_BALANCE = "remainingBalance";
    
    private List<SeMillLevyOverride> collection;
    private Iterator<SeMillLevyOverride> iterator = null;
    private SeMillLevyOverride currentMillLevyOverride = null;

    public SeMillLevyOverrideDatasource(SeMillLevyOverride millLevyOveride) {
     if (millLevyOveride != null)   {
      this.collection = new ArrayList<SeMillLevyOverride>();
      this.collection.add(millLevyOveride);
     }      
    }
    
    
     /**
     * 
     * @return
     * @throws JRException 
     */
    @Override
    public boolean next() throws JRException {
        currentMillLevyOverride = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.iterator();
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
         if (currentMillLevyOverride == null) {
            currentMillLevyOverride = this.iterator.next();
        }

        if (jrf.getName().equals(DISTRICT_NAME) && currentMillLevyOverride != null) {
            return currentMillLevyOverride.getDistrictName();
        } else if (jrf.getName().equals(DISTRICT_NUMBER) && currentMillLevyOverride != null) {
            return currentMillLevyOverride.getDistrictNumber();
        } else if (jrf.getName().equals(TAX_YEAR) && currentMillLevyOverride != null) {
            return currentMillLevyOverride.getTaxYear();
        }  else if (jrf.getName().equals(GRAND_TOTAL_PROG) && currentMillLevyOverride != null) {
        	return currentMillLevyOverride.getGrandTotalProg();
        }  else if (jrf.getName().equals(COST_OF_LIVING) && currentMillLevyOverride != null) {
            return currentMillLevyOverride.getCostOfLiving();
        } else if (jrf.getName().equals(MIN_OVERRIDE_ALLOWED) && currentMillLevyOverride != null) {
            return currentMillLevyOverride.getMinOverrideAllowed();
        }  else if (jrf.getName().equals(QUARTER_OF_TOTAL_PROG) && currentMillLevyOverride != null) {
            return currentMillLevyOverride.getQuarterOfTotalProg();
        }  else if (jrf.getName().equals(TOTAL_OVERRIDE_ALLOWED) && currentMillLevyOverride != null) {
            return currentMillLevyOverride.getTotalOverrideAllowed();
        }  else if (jrf.getName().equals(ALLOWABLE_OVERRIDE) && currentMillLevyOverride != null) {
            return currentMillLevyOverride.getAllowableOverride();
        }  else if (jrf.getName().equals(PROPERTY_TAX_REVENUE) && currentMillLevyOverride != null) {
            return currentMillLevyOverride.getPropertyTaxRevenue();
        }  else if (jrf.getName().equals(REMAINING_BALANCE) && currentMillLevyOverride != null) {
            return currentMillLevyOverride.getRemainingBalance();
        }

        return null;
    }
    
}
