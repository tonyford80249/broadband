
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
public class SeFinallMillLevySummaryDatasource implements JRDataSource {
    public static final String COUNTY = "county";    
    public static final String FISCAL_YEAR = "fiscalYear";    
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String DISTIRCT_NAME = "districtName";
    public static final String NET_ASSESSED_VALUATION = "netAssessedValuation";
    public static final String TOTAL_PROGRAM_MILL = "totalProgramMillLevy";
    public static final String CATEGORY_BUYOUT_MILL = "categoricalBuyoutMillLevy";
    public static final String HOLD_HARMLESS_MILL = "holdHarmlessMillLevy";
    public static final String EXCESS_HOLDHARMLESS_MILL = "excessHoldHarmlessMillLevy";
    public static final String VOTER_APPROVED_MILL = "voterApprovedMillLevy";
    public static final String ABATEMENT_MILL = "abatementMillLevy";
    public static final String BOND_REDEMPTION_MILL = "bondRedemptionMillLevy";
    public static final String TRANSPORTATION_MILL = "transportationMillLevy";
    public static final String SPECIAL_BUILDING_MILL = "specialBuildingTechnologyMillLevy";
    public static final String FULLDAY_KINDERGARTEN_MILL = "fulldayKindergartenMillLevy";
    public static final String OTHER_MILL = "otherMillLevy";
    public static final String TOTAL_MILL = "totalMillLevy";
    public static final String IS_TOTAL_REC = "isTotalLine";
    
    
    private List<SeFinallMillLevySummary> collection;
    private Iterator<SeFinallMillLevySummary> iterator = null;
    private SeFinallMillLevySummary currentFinalMillLevy = null;

    /**
     * 
     * @param collection 
     */
    public SeFinallMillLevySummaryDatasource(List<SeFinallMillLevySummary> collection) {
        this.collection = collection;
    }
    
    
    @Override
    public boolean next() throws JRException {
        currentFinalMillLevy = null;

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
         if (currentFinalMillLevy == null) {
            currentFinalMillLevy = this.iterator.next();
        }

        if (jrf.getName().equals(FISCAL_YEAR) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getFiscalYear();
        } else if (jrf.getName().equals(DISTRICT_NUMBER) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getDistrictNumber();
        } else if (jrf.getName().equals(DISTIRCT_NAME) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getDistrictName();
        } else if (jrf.getName().equals(NET_ASSESSED_VALUATION) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getNetAssessedValuation();
        } else if (jrf.getName().equals(TOTAL_PROGRAM_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getTotalProgramMillLevy();
        } else if (jrf.getName().equals(CATEGORY_BUYOUT_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getCategoricalBuyoutMillLevy();
        } else if (jrf.getName().equals(HOLD_HARMLESS_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getHoldHarmlessMillLevy();
        } else if (jrf.getName().equals(EXCESS_HOLDHARMLESS_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getExcessHoldHarmlessMillLevy();
        } else if (jrf.getName().equals(VOTER_APPROVED_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getVoterApprovedMillLevy();
        } else if (jrf.getName().equals(ABATEMENT_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getAbatementMillLevy();
        } else if (jrf.getName().equals(BOND_REDEMPTION_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getBondRedemptionMillLevy();
        } else if (jrf.getName().equals(TRANSPORTATION_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getTransportationMillLevy();
        } else if (jrf.getName().equals(SPECIAL_BUILDING_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getSpecialBuildingTechnologyMillLevy();
        } else if (jrf.getName().equals(FULLDAY_KINDERGARTEN_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getFulldayKindergartenMillLevy();
        } else if (jrf.getName().equals(OTHER_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getOtherMillLevy();
        } else if (jrf.getName().equals(TOTAL_MILL) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getTotalMillLevy();
        } else if (jrf.getName().equals(IS_TOTAL_REC) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.isTotalRecord();
        } else if (jrf.getName().equals(COUNTY) && currentFinalMillLevy != null) {
            return currentFinalMillLevy.getCounty();
        } 
        
                                
        return null;
    }
    
}
