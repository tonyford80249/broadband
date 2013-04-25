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
public class SEMonthlyPaymentDatasourceProvider implements  JRDataSourceProvider{

    /**
     * 
     * @return 
     */
    public boolean supportsGetFieldsOperation() {
        return true;
    }

    /**
     * 
     * @param jr
     * @return
     * @throws JRException
     * @throws UnsupportedOperationException 
     */
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
        JRField[] fieldsAre = new JRField[18];
        
        fieldsAre[0] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.CURRENT_MONTH, "The month that the payment applies to", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.CURRENT_FUNDING, "Funding for the month", Double.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.CURRENT_SWAP, "swap for the month", Double.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.CURRENT_CHARTER_DEBT, "charter debt for the month", Double.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.CURRENT_AUDIT, "Audit for the month", Double.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.CURRENT_CSI, "CSI for the month", Double.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.CURRENT_OTHER, "other for the month", Double.class);
        fieldsAre[7] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.NET_PAYMENT, "payment for the month", Double.class);
        fieldsAre[8] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.PRIOR_PAYMENT, "prior months payment", Double.class);
        fieldsAre[9] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.VARIANCE, "variance", Double.class);
        fieldsAre[10] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.TOTAL_PROJECTED, "total projected share", Double.class);
        fieldsAre[11] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.TOTAL_PAID, "total paid year to date", Double.class);
        fieldsAre[12] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.TOTAL_REMAINING, "total remaining to be paid", Double.class);
        fieldsAre[13] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.CURRENT_FISCAL_YEAR, "The fiscal year in which the paymennts were made.", String.class);
        fieldsAre[14] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.RPT_CURRENT_MONTH, "The month of the report.", String.class);        
        fieldsAre[15] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.DISTRICT_NAME, "The name of the district", String.class);
        fieldsAre[16] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.DISTRICT_NUMBER, "The district number.", String.class);
        fieldsAre[17] = JrDatasourceBasicField.newInstance(SEMonthlyPaymentDatasource.CURRENT_DATE, "The date the report was generated.", Date.class);
        
        return fieldsAre;
    }

    /**
     * 
     * @param jr
     * @return
     * @throws JRException 
     */
    public JRDataSource create(JasperReport jr) throws JRException {
        return new SEMonthlyPaymentDatasource(createSEMonthlyPaymentCollection());
    }

    /**
     * 
     * @param jrds
     * @throws JRException 
     */
    public void dispose(JRDataSource jrds) throws JRException {
       
    }
    
   
    
    
    /**
     * 
     * @return 
     */
    public static SEMonthlyPaymentCollection createSEMonthlyPaymentCollection() {
     SEMonthlyPaymentCollection collection = new SEMonthlyPaymentCollection();   
     collection.setFiscalYear("2012-2013");
     collection.setCurrentMonth("MAY");
     collection.setDistrictNumber("0010");
     collection.setDistrictName("MAPLETON");
     collection.setCurrentDate(new Date());
     
     /**
      * 
      */
     SEMonthlyPayment julyPayment = new SEMonthlyPayment();
     julyPayment.setMonth("JUL");
     julyPayment.setAudit(0.0);
     julyPayment.setCharterDebt(0.0);
     julyPayment.setCsi(0.0);
     julyPayment.setFunding(3007537.61);
     julyPayment.setNetPayment(3007537.61);
     julyPayment.setPriorPayment(null);
     julyPayment.setOther(0.0);
     julyPayment.setSwap(0.0);
     julyPayment.setVariance(null);
     julyPayment.setTotalProjectedShare(36090451.36);
     julyPayment.setTotalPaidShare(3007537.61);
     julyPayment.setTotalRemainingShare(33082913.75);
     
     collection.getMonthlyPayment().add(julyPayment);
     
     /**
      * 
      */
     SEMonthlyPayment augustPayment = new SEMonthlyPayment();
     augustPayment.setMonth("AUG");
     augustPayment.setAudit(340.00);
     augustPayment.setCharterDebt(1243.44);
     augustPayment.setCsi(200.00);
     augustPayment.setFunding(5678123.12);
     augustPayment.setNetPayment(5000123.12);
     augustPayment.setPriorPayment(3007537.61);
     augustPayment.setOther(100.50);
     augustPayment.setSwap(333.33);
     augustPayment.setVariance(898.11);
     augustPayment.setTotalProjectedShare(36090451.36);
     augustPayment.setTotalPaidShare(8007660.73);
     augustPayment.setTotalRemainingShare(28082790.63);
     
     collection.getMonthlyPayment().add(augustPayment);
     
     /**
      * 
      */
     SEMonthlyPayment septemberPayment = new SEMonthlyPayment();
     septemberPayment.setMonth("SEP");
     septemberPayment.setAudit(440.00);
     septemberPayment.setCharterDebt(1043.44);
     septemberPayment.setCsi(223.00);
     septemberPayment.setFunding(4678123.12);
     septemberPayment.setNetPayment(3000123.12);
     septemberPayment.setPriorPayment(5000123.12);
     septemberPayment.setOther(120.50);
     septemberPayment.setSwap(433.33);
     septemberPayment.setVariance(398.11);
     septemberPayment.setTotalProjectedShare(36090451.36);
     septemberPayment.setTotalPaidShare(11007783.85);
     septemberPayment.setTotalRemainingShare(25082667.51);
     
     collection.getMonthlyPayment().add(septemberPayment);
     
     /**
      * 
      */
     SEMonthlyPayment octoberPayment = new SEMonthlyPayment();
     octoberPayment.setMonth("OCT");
     octoberPayment.setAudit(840.00);
     octoberPayment.setCharterDebt(943.44);
     octoberPayment.setCsi(1223.00);
     octoberPayment.setFunding(7678123.12);
     octoberPayment.setNetPayment(6777111.88);
     octoberPayment.setPriorPayment(3000123.12);
     octoberPayment.setOther(6328773.50);
     octoberPayment.setSwap(23989836.33);
     octoberPayment.setVariance(2387443.11);
     octoberPayment.setTotalProjectedShare(36090451.36);
     octoberPayment.setTotalPaidShare(17784895.73);
     octoberPayment.setTotalRemainingShare(18305555.63);
     
     collection.getMonthlyPayment().add(octoberPayment);
     
     /**
      * 
      */
     SEMonthlyPayment novemberPayment = new SEMonthlyPayment();
     novemberPayment.setMonth("NOV");
     novemberPayment.setAudit(1840.00);
     novemberPayment.setCharterDebt(1943.44);
     novemberPayment.setCsi(11223.00);
     novemberPayment.setFunding(3678123.12);
     novemberPayment.setNetPayment(3101888.23);
     novemberPayment.setPriorPayment(6777111.88);
     novemberPayment.setOther(812.50);
     novemberPayment.setSwap(6253.33);
     novemberPayment.setVariance(199.11);
     novemberPayment.setTotalProjectedShare(36090451.36);
     novemberPayment.setTotalPaidShare(20886783.96);
     novemberPayment.setTotalRemainingShare(15203667.4);
     
     collection.getMonthlyPayment().add(novemberPayment);
     
     /**
      * 
      */
     SEMonthlyPayment decemberPayment = new SEMonthlyPayment();
     decemberPayment.setMonth("DEC");
     decemberPayment.setAudit(3340.00);
     decemberPayment.setCharterDebt(4443.44);
     decemberPayment.setCsi(553.00);
     decemberPayment.setFunding(3678123.12);
     decemberPayment.setNetPayment(1345888.23);
     decemberPayment.setPriorPayment(3101888.23);
     decemberPayment.setOther(712.50);
     decemberPayment.setSwap(253.33);
     decemberPayment.setVariance(2199.11);
     decemberPayment.setTotalProjectedShare(36090451.36);
     decemberPayment.setTotalPaidShare(22232672.19);
     decemberPayment.setTotalRemainingShare(13857779.17);
     
     collection.getMonthlyPayment().add(decemberPayment);
     
     /**
      * 
      */
     SEMonthlyPayment janruaryPayment = new SEMonthlyPayment();
     janruaryPayment.setMonth("JAN");
     janruaryPayment.setAudit(1240.00);
     janruaryPayment.setCharterDebt(2343.44);
     janruaryPayment.setCsi(453.00);
     janruaryPayment.setFunding(3678123.12);
     janruaryPayment.setNetPayment(11345888.23);
     janruaryPayment.setPriorPayment(1345888.23);
     janruaryPayment.setOther(122.50);
     janruaryPayment.setSwap(353.33);
     janruaryPayment.setVariance(87.11);
     janruaryPayment.setTotalProjectedShare(36090451.36);
     janruaryPayment.setTotalPaidShare(33578560.42);
     janruaryPayment.setTotalRemainingShare(2511890.94);
     
     collection.getMonthlyPayment().add(janruaryPayment);
     
     /**
      * 
      */
             
     SEMonthlyPayment februaryPayment = new SEMonthlyPayment();
     februaryPayment.setMonth("FEB");
     februaryPayment.setAudit(1140.00);
     februaryPayment.setCharterDebt(1343.44);
     februaryPayment.setCsi(653.00);
     februaryPayment.setFunding(3678123.12);
     februaryPayment.setNetPayment(377112.23);
     februaryPayment.setPriorPayment(11345888.23);
     februaryPayment.setOther(22.50);
     februaryPayment.setSwap(53.33);
     februaryPayment.setVariance(7.11);
     februaryPayment.setTotalProjectedShare(36090451.36);
     februaryPayment.setTotalPaidShare(33955672.65);
     februaryPayment.setTotalRemainingShare(2134778.71);
     
     collection.getMonthlyPayment().add(februaryPayment);
     
     /**
      * 
      */
     SEMonthlyPayment marchPayment = new SEMonthlyPayment();
     marchPayment.setMonth("MAR");
     marchPayment.setAudit(1140.00);
     marchPayment.setCharterDebt(1343.44);
     marchPayment.setCsi(653.00);
     marchPayment.setFunding(3678123.12);
     marchPayment.setNetPayment(377112.23);
     marchPayment.setPriorPayment(11345888.23);
     marchPayment.setOther(22.50);
     marchPayment.setSwap(53.33);
     marchPayment.setVariance(7.11);
     marchPayment.setTotalProjectedShare(36090451.36);
     marchPayment.setTotalPaidShare(33955672.65);
     marchPayment.setTotalRemainingShare(2134778.71);
     
     collection.getMonthlyPayment().add(marchPayment);
     
     /**
      * 
      */
     SEMonthlyPayment aprilPayment = new SEMonthlyPayment();
     aprilPayment.setMonth("APR");
     aprilPayment.setAudit(40.00);
     aprilPayment.setCharterDebt(23.44);
     aprilPayment.setCsi(53.00);
     aprilPayment.setFunding(3678123.12);
     aprilPayment.setNetPayment(23212.23);
     aprilPayment.setPriorPayment(377112.23);
     aprilPayment.setOther(2.50);
     aprilPayment.setSwap(5.33);
     aprilPayment.setVariance(7.11);
     aprilPayment.setTotalProjectedShare(36090451.36);
     aprilPayment.setTotalPaidShare(33978884.88);
     aprilPayment.setTotalRemainingShare(2111566.48);
     
     collection.getMonthlyPayment().add(aprilPayment);
     
     /**
      * 
      */
     SEMonthlyPayment mayPayment = new SEMonthlyPayment();
     mayPayment.setMonth("MAY");
     mayPayment.setAudit(0.00);
     mayPayment.setCharterDebt(0.00);
     mayPayment.setCsi(0.00);
     mayPayment.setFunding(3678123.12);
     mayPayment.setNetPayment(3451.99);
     mayPayment.setPriorPayment(23212.23);
     mayPayment.setOther(0.00);
     mayPayment.setSwap(0.00);
     mayPayment.setVariance(0.00);
     mayPayment.setTotalProjectedShare(36090451.36);
     mayPayment.setTotalPaidShare(33982336.87);
     mayPayment.setTotalRemainingShare(2108114.49);
     
     collection.getMonthlyPayment().add(mayPayment);
     
     return collection;
    }
    
}
