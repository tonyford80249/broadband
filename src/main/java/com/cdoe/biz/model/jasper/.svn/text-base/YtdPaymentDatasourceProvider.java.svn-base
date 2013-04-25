package com.cdoe.biz.model.jasper;

import com.cdoe.util.JrDatasourceBasicField;
import java.util.Date;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRDataSourceProvider;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Tony Ford
 */
public class YtdPaymentDatasourceProvider implements  JRDataSourceProvider{

    @Override
    public boolean supportsGetFieldsOperation() {
        return true;
    }

    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
        JRField[] fieldsAre = new JRField[17];
        
        fieldsAre[0] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.CURRENT_MONTH, "The month that the payment applies to", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.CURRENT_FUNDING, "Funding for the month", Double.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.CURRENT_SWAP, "swap for the month", Double.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.CURRENT_CHARTER_DEBT, "charter debt for the month", Double.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.CURRENT_AUDIT, "Audit for the month", Double.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.CURRENT_CSI, "CSI for the month", Double.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.CURRENT_OTHER, "other for the month", Double.class);
        fieldsAre[7] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.NET_PAYMENT, "payment for the month", Double.class);
        fieldsAre[8] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.PRIOR_PAYMENT, "prior months payment", Double.class);
        fieldsAre[9] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.VARIANCE, "variance", Double.class);
        fieldsAre[10] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.TOTAL_PROJECTED, "total projected share", Double.class);
        fieldsAre[11] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.TOTAL_PAID, "total paid year to date", Double.class);
        fieldsAre[12] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.TOTAL_REMAINING, "total remaining to be paid", Double.class);
        fieldsAre[13] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.CURRENT_FISCAL_YEAR, "The fiscal year in which the paymennts were made.", String.class);
        fieldsAre[14] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.RPT_CURRENT_MONTH, "The month of the report.", String.class);        
        fieldsAre[15] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.DISTRICT_NAME, "The name of the district", String.class);
        fieldsAre[16] = JrDatasourceBasicField.newInstance(YtdPaymentDatasource.DISTRICT_NUMBER, "The district number.", String.class);
        
        
        return fieldsAre;
    }

    /**
     * 
     * @param jr
     * @return
     * @throws JRException 
     */
    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
       return new YtdPaymentDatasource(createYtdPaymentCollection());
    }

    /**
     * 
     * @param jrds
     * @throws JRException 
     */
    @Override
    public void dispose(JRDataSource jrds) throws JRException {
        
    }
    
    /**
     * 
     * @return 
     */
    public static YtdPaymentCollection createYtdPaymentCollection() {
     YtdPaymentCollection collection  = new YtdPaymentCollection();   
     collection.setFiscalYear("2012-2013");
     collection.setCurrentMonth("MAY");
     
     
     
     /**
      * 
      */
     SEMonthlyPayment julyPayment = new SEMonthlyPayment();
     julyPayment.setMonth("MAY");
     julyPayment.setAudit(0.0);
     julyPayment.setCharterDebt(0.0);
     julyPayment.setCsi(0.0);
     julyPayment.setFunding(2948034.44);
     julyPayment.setNetPayment(2948034.44);
     julyPayment.setPriorPayment(2948034.44);
     julyPayment.setOther(0.0);
     julyPayment.setSwap(0.0);
     julyPayment.setVariance(null);
     julyPayment.setTotalProjectedShare(35376413.32);
     julyPayment.setTotalPaidShare(32308147.15);
     julyPayment.setTotalRemainingShare(3068266.17);
     
     collection.getMonthlyPayment().put(new DistrictInfo("MAPLETON","0010"), julyPayment);
     
     /**
      * 
      */
     SEMonthlyPayment augustPayment = new SEMonthlyPayment();
     augustPayment.setMonth("MAY");
     augustPayment.setAudit(0.0);
     augustPayment.setCharterDebt(0.0);
     augustPayment.setCsi(0.0);
     augustPayment.setFunding(17345996.14);
     augustPayment.setNetPayment(17041605.20);
     augustPayment.setPriorPayment(17043949.12);
     augustPayment.setOther(-304390.94);
     augustPayment.setSwap(0.0);
     augustPayment.setVariance(-2343.92);
     augustPayment.setTotalProjectedShare(208151953.73);
     augustPayment.setTotalPaidShare(190160054.18);
     augustPayment.setTotalRemainingShare(17991899.55);
     
     collection.getMonthlyPayment().put(new DistrictInfo("ADAMS 12 FIVE STAR S","0020"), augustPayment);
     
     /**
      * 
      */
     SEMonthlyPayment septemberPayment = new SEMonthlyPayment();
     septemberPayment.setMonth("MAY");
     septemberPayment.setAudit(0.0);
     septemberPayment.setCharterDebt(0.0);
     septemberPayment.setCsi(0.0);
     septemberPayment.setFunding(2655194.69);
     septemberPayment.setNetPayment(2649321.69);
     septemberPayment.setPriorPayment(2649321.69);
     septemberPayment.setOther(-5873.00);
     septemberPayment.setSwap(0.0);
     septemberPayment.setVariance(0.0);
     septemberPayment.setTotalProjectedShare(31862336.25);
     septemberPayment.setTotalPaidShare(29090528.74);
     septemberPayment.setTotalRemainingShare(2771807.51);
     
     collection.getMonthlyPayment().put(new DistrictInfo("ADAMS COUNTY","0030"), septemberPayment);
     
     /**
      * 
      */
     SEMonthlyPayment octoberPayment = new SEMonthlyPayment();
     octoberPayment.setMonth("MAY");
     octoberPayment.setAudit(0.0);
     octoberPayment.setCharterDebt(0.0);
     octoberPayment.setCsi(0.0);
     octoberPayment.setFunding(5868219.53);
     octoberPayment.setNetPayment(5671941.61);
     octoberPayment.setPriorPayment(5671941.61);
     octoberPayment.setOther(-196277.92);
     octoberPayment.setSwap(0.0);
     octoberPayment.setVariance(0.0);
     octoberPayment.setTotalProjectedShare(70418634.32);
     octoberPayment.setTotalPaidShare(64318052.11);
     octoberPayment.setTotalRemainingShare(6100582.21);
     
     collection.getMonthlyPayment().put(new DistrictInfo("BRIGHTON","0040"), octoberPayment);
     
     /**
      * 
      */
     SEMonthlyPayment novemberPayment = new SEMonthlyPayment();
     novemberPayment.setMonth("MAY");
     novemberPayment.setAudit(0.0);
     novemberPayment.setCharterDebt(0.0);
     novemberPayment.setCsi(0.0);
     novemberPayment.setFunding(416134.79);
     novemberPayment.setNetPayment(416134.79);
     novemberPayment.setPriorPayment(416134.79);
     novemberPayment.setOther(0.0);
     novemberPayment.setSwap(0.0);
     novemberPayment.setVariance(0.0);
     novemberPayment.setTotalProjectedShare(4993617.50);
     novemberPayment.setTotalPaidShare(4559986.03);
     novemberPayment.setTotalRemainingShare(433631.47);
     
     collection.getMonthlyPayment().put(new DistrictInfo("BENNETT","0050"), novemberPayment);
     
     /**
      * 
      */
     SEMonthlyPayment decemberPayment = new SEMonthlyPayment();
     decemberPayment.setMonth("MAY");
     decemberPayment.setAudit(0.0);
     decemberPayment.setCharterDebt(0.0);
     decemberPayment.setCsi(0.0);
     decemberPayment.setFunding(346692.76);
     decemberPayment.setNetPayment(346962.76);
     decemberPayment.setPriorPayment(346692.76);
     decemberPayment.setOther(0.0);
     decemberPayment.setSwap(0.0);
     decemberPayment.setVariance(0.0);
     decemberPayment.setTotalProjectedShare(4160313.10);
     decemberPayment.setTotalPaidShare(3797723.76);
     decemberPayment.setTotalRemainingShare(362589.34);
     
     collection.getMonthlyPayment().put(new DistrictInfo("STRASBURG","0060"), decemberPayment);
     
     /**
      * 
      */
     SEMonthlyPayment janruaryPayment = new SEMonthlyPayment();
     janruaryPayment.setMonth("MAY");
     janruaryPayment.setAudit(0.0);
     janruaryPayment.setCharterDebt(0.0);
     janruaryPayment.setCsi(0.0);
     janruaryPayment.setFunding(4286840.43);
     janruaryPayment.setNetPayment(4246277.43);
     janruaryPayment.setPriorPayment(4246277.43);
     janruaryPayment.setOther(0.0);
     janruaryPayment.setSwap(-40563.00);
     janruaryPayment.setVariance(0.0);
     janruaryPayment.setTotalProjectedShare(51442085.15);
     janruaryPayment.setTotalPaidShare(46989418.59);
     janruaryPayment.setTotalRemainingShare(4452666.56);
     
     collection.getMonthlyPayment().put(new DistrictInfo("WESTMINSTER","0070"), janruaryPayment);
     
     /**
      * 
      */
             
     SEMonthlyPayment februaryPayment = new SEMonthlyPayment();
     februaryPayment.setMonth("MAY");
     februaryPayment.setAudit(0.0);
     februaryPayment.setCharterDebt(-8269.00);
     februaryPayment.setCsi(0.0);
     februaryPayment.setFunding(809408.87);
     februaryPayment.setNetPayment(801139.87);
     februaryPayment.setPriorPayment(801139.87);
     februaryPayment.setOther(0.0);
     februaryPayment.setSwap(0.0);
     februaryPayment.setVariance(0.0);
     februaryPayment.setTotalProjectedShare(9712906.44);
     februaryPayment.setTotalPaidShare(8870186.96);
     februaryPayment.setTotalRemainingShare(842719.48);
     
     collection.getMonthlyPayment().put(new DistrictInfo("ALAMOSA","0080"), februaryPayment);
     
     /**
      * 
      */
     SEMonthlyPayment marchPayment = new SEMonthlyPayment();
     marchPayment.setMonth("MAY");
     marchPayment.setAudit(0.0);
     marchPayment.setCharterDebt(0.0);
     marchPayment.setCsi(0.0);
     marchPayment.setFunding(154774.34);
     marchPayment.setNetPayment(154774.34);
     marchPayment.setPriorPayment(154774.34);
     marchPayment.setOther(0.0);
     marchPayment.setSwap(0.0);
     marchPayment.setVariance(0.0);
     marchPayment.setTotalProjectedShare(1857292.04);
     marchPayment.setTotalPaidShare(1696161.91);
     marchPayment.setTotalRemainingShare(161130.13);
     
     collection.getMonthlyPayment().put(new DistrictInfo("SANGRE DE CRISTO","0090"), marchPayment);
     
     /**
      * 
      */
     SEMonthlyPayment aprilPayment = new SEMonthlyPayment();
     aprilPayment.setMonth("MAY");
     aprilPayment.setAudit(0.0);
     aprilPayment.setCharterDebt(0.0);
     aprilPayment.setCsi(0.0);
     aprilPayment.setFunding(840765.70);
     aprilPayment.setNetPayment(840765.70);
     aprilPayment.setPriorPayment(840765.70);
     aprilPayment.setOther(0.0);
     aprilPayment.setSwap(0.0);
     aprilPayment.setVariance(0.0);
     aprilPayment.setTotalProjectedShare(10089188.45);
     aprilPayment.setTotalPaidShare(9199521.27);
     aprilPayment.setTotalRemainingShare(889667.18);
     
     collection.getMonthlyPayment().put(new DistrictInfo("ENGLEWOOD","0100"), aprilPayment);
     
     /**
      * 
      */
     SEMonthlyPayment mayPayment = new SEMonthlyPayment();
     mayPayment.setMonth("MAY");
     mayPayment.setAudit(-6594.00);
     mayPayment.setCharterDebt(0.00);
     mayPayment.setCsi(0.00);
     mayPayment.setFunding(660654.93);
     mayPayment.setNetPayment(654060.93);
     mayPayment.setPriorPayment(654060.93);
     mayPayment.setOther(0.0);
     mayPayment.setSwap(0.00);
     mayPayment.setVariance(0.00);
     mayPayment.setTotalProjectedShare(7927859.16);
     mayPayment.setTotalPaidShare(7238976.95);
     mayPayment.setTotalRemainingShare(688882.21);
     
     collection.getMonthlyPayment().put(new DistrictInfo("SHERIDAN","0110"), mayPayment);
     
     return collection;
    }
    
}
