package com.cdoe.biz.model.jasper;

import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 * 
 */
public class SeMillLevyCertificationDatasource implements JRDataSource {
    public static final String DISTRICT_NAME = "districtName";
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String COUNTY = "county";
    public static final String TAX_YEAR = "taxYear";
    public static final String APPROVER_NAME = "approverName";
    public static final String APPROVER_PHONE = "approverPhone";
    public static final String IS_BOLD = "isBold";
    public static final String IS_INDENTED = "isIndented";
    public static final String TITLE = "title";
    public static final String VALUE1 = "column1Value";
    public static final String VALUE2 = "column2Value";
    public static final String VALUE3 = "column3Value";
    public static final String CERT_DATE1 = "column1AsOfDate";
    public static final String CERT_DATE2 = "column3AsOfDate";
    
    private SeMillLevyCertificationCollection collection;
    private Iterator<SeMillLevyCertificationCalculation> iterator = null;
    private SeMillLevyCertificationCalculation currentMillLevyCalculation = null;

    /**
     * 
     * @param collection 
     */
    public SeMillLevyCertificationDatasource(SeMillLevyCertificationCollection collection) {
        this.collection = collection;
    }

   
    
    
    @Override
    public boolean next() throws JRException {
      currentMillLevyCalculation = null;

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
       if (currentMillLevyCalculation == null) {
            currentMillLevyCalculation = this.iterator.next();
        }

        if (jrf.getName().equals(DISTRICT_NAME) && collection != null) {
            return collection.getDistrictName();
        } else if (jrf.getName().equals(DISTRICT_NUMBER) && collection != null) {
            return collection.getDistrictNumber();
        } else if (jrf.getName().equals(TAX_YEAR) && collection != null) {
            return collection.getTaxYear();
        } else if (jrf.getName().equals(COUNTY) && collection != null) {
            return collection.getCounty();
        } else if (jrf.getName().equals(APPROVER_NAME) && collection != null) {
            return collection.getApproverName();
        } else if (jrf.getName().equals(APPROVER_PHONE) && collection != null) {
            return collection.getApproverPhone();
        } else if (jrf.getName().equals(CERT_DATE1) && collection != null) {
            return collection.getColumn1CertificationDate();
        } else if (jrf.getName().equals(CERT_DATE2) && collection != null) {
            return collection.getColumn3CertificationDate();
        } else if (jrf.getName().equals(IS_BOLD) && currentMillLevyCalculation != null) {
            return currentMillLevyCalculation.getBold();
        } else if (jrf.getName().equals(IS_INDENTED) && currentMillLevyCalculation != null) {
            return currentMillLevyCalculation.getIndented();
        } else if (jrf.getName().equals(TITLE) && currentMillLevyCalculation != null) {
            return currentMillLevyCalculation.getTitle();
        } else if (jrf.getName().equals(VALUE1) && currentMillLevyCalculation != null) {
            return currentMillLevyCalculation.getColumn1FormattedValue();
        } else if (jrf.getName().equals(VALUE2) && currentMillLevyCalculation != null) {
            return currentMillLevyCalculation.getColumn2FormattedValue();
        } else if (jrf.getName().equals(VALUE3) && currentMillLevyCalculation != null) {
            return currentMillLevyCalculation.getColumn3FormattedValue();
        }


        return null;
    }
    
}
