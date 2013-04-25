package com.cdoe.util;


import com.cdoe.biz.model.PaymentWorkSheet;
import com.cdoe.biz.model.PaymentWorkSheetCalculation;
import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
/**
 * 
 * @author Tony Ford
 */
public class PaymentWorksheetDatasource implements JRDataSource {
    public static final String DISTRICT_NAME = "districtName";
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String DISTRICT_COUNTY = "districtCounty";
    public static final String FISCAL_YEAR = "fiscalYear";
    public static final String PUPIL_COUINT = "pupilCount";
    public static final String TITLE = "title";
    public static final String CALCULATION = "calculation";
    
    private PaymentWorkSheet paymnetWorkSheet;
    private Iterator<PaymentWorkSheetCalculation> iterator = null;
    private PaymentWorkSheetCalculation currentCalculation = null;

    /**
     * 
     * @return 
     */
    protected PaymentWorkSheet getPaymnetWorkSheet() {
        return paymnetWorkSheet;
    }

    /**
     * 
     * @param paymnetWorkSheet 
     */
    protected void setPaymnetWorkSheet(PaymentWorkSheet paymnetWorkSheet) {
        this.paymnetWorkSheet = paymnetWorkSheet;
        
        this.iterator = null;
        
        this.currentCalculation = null;
    }

    
    /**
     * 
     * @param paymnetWorkSheet 
     */
    public PaymentWorksheetDatasource(PaymentWorkSheet paymnetWorkSheet) {
        this.paymnetWorkSheet = paymnetWorkSheet;
    }
    
    /**
     * 
     * @return
     * @throws JRException 
     */
    public boolean next() throws JRException {
        currentCalculation = null;
        
        if (iterator == null && paymnetWorkSheet != null) {
          iterator = paymnetWorkSheet.getCalculations().iterator();   
        }
        
        if (iterator == null) {
         return false;   
        }
        
        return iterator.hasNext();
    }

    /**
     * 
     * @param jrf
     * @return
     * @throws JRException 
     */
    public Object getFieldValue(JRField jrf) throws JRException {
        if (currentCalculation == null && iterator.hasNext()) {
            currentCalculation  = iterator.next();  
        }
        
        if (jrf.getName().equals(DISTRICT_NAME)) {
         return paymnetWorkSheet.getDistrictName();  
        }
        else if (jrf.getName().equals(DISTRICT_NUMBER)) {
          return paymnetWorkSheet.getDistrictNumber();  
        }
        else if (jrf.getName().equals(DISTRICT_COUNTY)) {
          return paymnetWorkSheet.getCounty();  
        }
         else if (jrf.getName().equals(FISCAL_YEAR)) {
          return paymnetWorkSheet.getFiscalYear(); 
        }
         else if (jrf.getName().equals(PUPIL_COUINT)) {
          return paymnetWorkSheet.getPupilCount();    
         }
          else if (jrf.getName().equals(TITLE)) {                      
          return currentCalculation != null ? currentCalculation.getTitle() : null;
        }
          else if (jrf.getName().equals(CALCULATION)) {                    
          return currentCalculation != null ? currentCalculation.getFormattedValue() : null;
        }
        
        return null;
    }

}
