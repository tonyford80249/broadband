package com.cdoe.biz.model.jasper;

import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 */
public class StateEqual360Datasource implements JRDataSource {

    public static final String DISTRICT_NAME = "districtName";
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String CURRENT_FISCAL_YEAR = "fiscalYear";
    public static final String COUNTY = "county";
    public static final String HEADING_INDICATOR = "headingIndicator";
    public static final String HEADING_INDICATOR2 = "heading2Indicator";
    public static final String TITLE = "title";
    public static final String VALUE = "value";
    private StateEqual360Collection collection;
    private Iterator<StateEqual360Calculation> iterator = null;
    private StateEqual360Calculation currentStateEqualCalculation = null;

    /**
     *
     * @param collection
     */
    public StateEqual360Datasource(StateEqual360Collection collection) {
        this.collection = collection;
    }

    @Override
    public boolean next() throws JRException {
        currentStateEqualCalculation = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.getCalculations().iterator();
        }

        if (this.iterator == null) {
            return false;
        }

        return this.iterator.hasNext();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        if (currentStateEqualCalculation == null) {
            currentStateEqualCalculation = this.iterator.next();
        }

        if (jrf.getName().equals(CURRENT_FISCAL_YEAR) && collection != null) {
            return collection.getFiscalYear();
        } else if (jrf.getName().equals(DISTRICT_NUMBER) && collection != null) {
            return collection.getDistrictNumber();
        } else if (jrf.getName().equals(DISTRICT_NAME) && collection != null) {
            return collection.getDistrictName();
        } else if (jrf.getName().equals(COUNTY) && collection != null) {
            return collection.getCounty();
        } else if (jrf.getName().equals(HEADING_INDICATOR) && currentStateEqualCalculation != null) {
            return currentStateEqualCalculation.getHeading();
        } else if (jrf.getName().equals(HEADING_INDICATOR2) && currentStateEqualCalculation != null) {
            return currentStateEqualCalculation.getHeading2();
        } else if (jrf.getName().equals(TITLE) && currentStateEqualCalculation != null) {
            return currentStateEqualCalculation.getTitle();
        } else if (jrf.getName().equals(VALUE) && currentStateEqualCalculation != null) {
            return currentStateEqualCalculation.getFormattedValue();
        }


        return null;
    }
}
