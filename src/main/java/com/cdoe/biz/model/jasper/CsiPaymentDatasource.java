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
public class CsiPaymentDatasource implements JRDataSource {
    public static final String COUNTY = "county";
    public static final String SCHOOL = "chaterSchool";
    public static final String PUPIL_COUNT = "pupilCount";
    public static final String KFACTOR = "kfactor";
    public static final String REVENUE = "perPupilRevenue";
    public static final String TOTAL_FUNDING = "totalFunding";
    public static final String ENTITLEMENT = "monthlyEnttlement";
    public static final String CDE_WITHHOLDING = "cdeWithholding";
    public static final String ASSISTANCE_WITHHOLDING = "assistanceWithholding";
    public static final String INSTITUTE_WITHHOLDING = "instituteWithholding";
    public static final String INTERCEPT_WITHHOLDING = "interceptWithholding";
    public static final String AT_RISK_ADJUSTMENT = "atRiskAdjustment";
    public static final String DISTRIBUTION_AMOUNT = "distributionAmount";
    public static final String FISCAL_YEAR = "fiscalYear";
    public static final String FISCAL_MONTH = "fiscalMonth";
    
    /**
     * 
     */
    private CsiPaymentCollection collection;
    
    /**
     * 
     */
    private Iterator<CsiPayment> iterator = null;
    
    /**
     * 
     */
    private CsiPayment currentCsiPayment = null;

    /**
     * 
     * @param collection 
     */
    public CsiPaymentDatasource(CsiPaymentCollection collection) {
        this.collection = collection;
    }
    
    
    /**
     * 
     * @return
     * @throws JRException 
     */
    @Override
    public boolean next() throws JRException {
       currentCsiPayment = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.getMonthlyPayments().iterator();
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
        if (currentCsiPayment == null) {
            currentCsiPayment = this.iterator.next();
        }
        
        if (jrf.getName().equals(FISCAL_YEAR) && collection != null) {
            return collection.getFiscalYear();
        } 
        else if (jrf.getName().equals(FISCAL_MONTH) && collection != null) {
            return collection.getMonth();
        }
        else if (jrf.getName().equals(COUNTY) && currentCsiPayment != null) {
            return currentCsiPayment.getCounty();
        }
        else if (jrf.getName().equals(SCHOOL) && currentCsiPayment != null) {
            return currentCsiPayment.getChaterSchool();
        }
        else if (jrf.getName().equals(PUPIL_COUNT) && currentCsiPayment != null) {
            return currentCsiPayment.getPupilCount();
        } else if (jrf.getName().equals(KFACTOR) && currentCsiPayment != null) {
            return currentCsiPayment.getKfactor();
        } else if (jrf.getName().equals(REVENUE) && currentCsiPayment != null) {
            return currentCsiPayment.getPerPupilRevenue();
        } else if (jrf.getName().equals(TOTAL_FUNDING) && currentCsiPayment != null) {
            return currentCsiPayment.getTotalFunding();
        } else if (jrf.getName().equals(ENTITLEMENT) && currentCsiPayment != null) {
            return currentCsiPayment.getMonthlyEntitlement();
        } else if (jrf.getName().equals(CDE_WITHHOLDING) && currentCsiPayment != null) {
            return currentCsiPayment.getCdeWithholding();
        } else if (jrf.getName().equals(ASSISTANCE_WITHHOLDING) && currentCsiPayment != null) {
            return currentCsiPayment.getAssistanceWithholding();
        } else if (jrf.getName().equals(INSTITUTE_WITHHOLDING) && currentCsiPayment != null) {
            return currentCsiPayment.getInstituteWithholding();
        } else if (jrf.getName().equals(INTERCEPT_WITHHOLDING) && currentCsiPayment != null) {
            return currentCsiPayment.getInterceptWithholding();
        } else if (jrf.getName().equals(AT_RISK_ADJUSTMENT) && currentCsiPayment != null) {
            return currentCsiPayment.getAtRiskAdjustment();
        } else if (jrf.getName().equals(DISTRIBUTION_AMOUNT) && currentCsiPayment != null) {
            return currentCsiPayment.getDistributionAmount();
        } 
        
        
        return null;
    }
    
}
