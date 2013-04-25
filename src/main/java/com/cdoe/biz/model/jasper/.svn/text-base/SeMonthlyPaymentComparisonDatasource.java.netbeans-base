package com.cdoe.biz.model.jasper;

import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * <p> 
 *    <b>description</b> This a model object used in jasper report framework.
 *                        This model supports the district monthly payment report and contains values for the month.
 * </p>
 *
 * @author Tony Ford
 */
public class SeMonthlyPaymentComparisonDatasource implements JRDataSource {
    public static final String FISCAL_YEAR_1 = "firstFiscalYear";   
    public static final String FISCAL_MONTH_1 = "firstFiscalMonth";
    public static final String FISCAL_YEAR_2 = "secondFiscalYear";   
    public static final String FISCAL_MONTH_2 = "secondFiscalMonth";
    public static final String DESC = "description";
    public static final String VALUE1 = "value1";
    public static final String VALUE2 = "value2";
    public static final String COUNTY = "county";
    public static final String DISTRICT_NAME = "districtName";
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String FORMAT_CODE = "formatCode";
  
    private SeMonthlyPaymentComparison collection;
    private Iterator<SeMonthlyPaymentComparisonCalculation> iterator = null;
    private SeMonthlyPaymentComparisonCalculation currentSEMonthlyComparison = null;

    /**
     * 
     * @param collection 
     */
    public SeMonthlyPaymentComparisonDatasource(SeMonthlyPaymentComparison collection) {
        this.collection = collection;
    }

    

    /**
     * 
     * @return
     * @throws JRException 
     */
    @Override
    public boolean next() throws JRException {
        currentSEMonthlyComparison = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.getCalcuation().iterator();
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
         if (currentSEMonthlyComparison == null) {
            currentSEMonthlyComparison = this.iterator.next();
        }

        if (jrf.getName().equals(DISTRICT_NAME) && collection != null) {
            return collection.getDistrictName();
        } 
        else if (jrf.getName().equals(DISTRICT_NUMBER) && collection != null) {
            return collection.getDistrictNumber();
        }
        else if (jrf.getName().equals(COUNTY) && collection != null) {
            return collection.getCounty();
        }
         else if (jrf.getName().equals(DESC) && currentSEMonthlyComparison != null) {
            return currentSEMonthlyComparison.getDescription();
        } else if (jrf.getName().equals(VALUE1) && currentSEMonthlyComparison != null) {
            return currentSEMonthlyComparison.getFormattedValue1();
        } else if (jrf.getName().equals(VALUE2) && currentSEMonthlyComparison != null) {
            return currentSEMonthlyComparison.getFormattedValue2();
        } 
        else if (jrf.getName().equals(FORMAT_CODE) && currentSEMonthlyComparison != null) {
            return currentSEMonthlyComparison.getFormatCode();
        }                 
        else if (jrf.getName().equals(FISCAL_YEAR_1) && collection != null) {
            return collection.getFiscalYear1();
        } 
        else if (jrf.getName().equals(FISCAL_MONTH_1) && collection != null) {
            return collection.getFiscalMonth1();
        } 
        else if (jrf.getName().equals(FISCAL_YEAR_2) && collection != null) {
            return collection.getFiscalYear2();
        } 
        else if (jrf.getName().equals(FISCAL_MONTH_2) && collection != null) {
            return collection.getFiscalMonth2();
        } 

        return null;
    }
  
}
