package com.cdoe.biz.model.jasper;

import com.cdoe.util.JrDatasourceBasicField;
import java.util.Date;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRDataSourceProvider;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;

/**
 * <p> 
 *    <b>description</b> This a model object used in jasper report framework.
 *                        This model supports the district monthly payment report and contains values for the month.
 * </p>
 *
 * @author Tony Ford
 */
public class CsiPaymentDatasourceProvider implements  JRDataSourceProvider {

    /**
     * 
     * @return 
     */
    @Override
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
    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
        JRField[] fieldsAre = new JRField[15];
        
        fieldsAre[0] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.FISCAL_YEAR, "The fiscal year in which the payment was made", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.FISCAL_MONTH, "The month that the payment was maid", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.COUNTY, "Area or County the school or institute is in.", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.ASSISTANCE_WITHHOLDING, "Withholding for Assistance Fund at 1%", Double.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.AT_RISK_ADJUSTMENT, "At-Risk adjustment (July - December)", Double.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.CDE_WITHHOLDING, "Withholding for CDE Administrative Overhead at 1%", Double.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.DISTRIBUTION_AMOUNT, "Amount to be distributed to Institute charter school", Double.class);
        fieldsAre[7] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.ENTITLEMENT, "Monthly Entitlement", Double.class);
        fieldsAre[8] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.INSTITUTE_WITHHOLDING, "Withholding for Institute Admininstrative Overhead at 3%", Double.class);
        fieldsAre[9] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.INTERCEPT_WITHHOLDING, "Withholding for Treasure's Intercept Program", Double.class);
        fieldsAre[10] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.KFACTOR, "District PPR for Full Day Factor", Double.class);
        fieldsAre[11] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.PUPIL_COUNT, "Projected Funded Pupil Count", Double.class);
        fieldsAre[12] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.REVENUE, "projected per pupil revenue", Double.class);
        fieldsAre[13] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.SCHOOL, "Name of school or institute.", String.class);
        fieldsAre[14] = JrDatasourceBasicField.newInstance(CsiPaymentDatasource.TOTAL_FUNDING, "Total Funding From Public School Finance Act.", Double.class);        
        
        
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
        return new CsiPaymentDatasource(createCsiPaymentCollection());
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
    public static final CsiPaymentCollection createCsiPaymentCollection() {
     CsiPaymentCollection collection = new CsiPaymentCollection();
     
     collection.setFiscalYear("20122013");
     collection.setMonth("November");
     
     /**
      * 
      */
     CsiPayment payment1 = new CsiPayment();
     payment1.setCounty("Adams 12 Five Star");
     payment1.setChaterSchool("Pinnacle Charter School");
     payment1.setPupilCount(1974.0);
     payment1.setKfactor(null);
     payment1.setPerPupilRevenue(6423.02);
     payment1.setTotalFunding(12679041.48);
     payment1.setMonthlyEntitlement(1056586.79);
     payment1.setCdeWithholding(-10565.87);
     payment1.setAssistanceWithholding(0.00);
     payment1.setInstituteWithholding(-31697.60);
     payment1.setInterceptWithholding(-195188.97);
     payment1.setAtRiskAdjustment(0.00);
     payment1.setDistributionAmount(819134.35);
     
     collection.getMonthlyPayments().add(payment1);
     
     /**
      * 
      */
     CsiPayment payment2 = new CsiPayment();
     payment2.setCounty("Commerce City");
     payment2.setChaterSchool("Community Leadership Academy");
     payment2.setPupilCount(465.0);
     payment2.setKfactor(null);
     payment2.setPerPupilRevenue(6819.71);
     payment2.setTotalFunding(2171165.15);
     payment2.setMonthlyEntitlement(264263.76);
     payment2.setCdeWithholding(-2642.64);
     payment2.setAssistanceWithholding(0.00);
     payment2.setInstituteWithholding(-7927.91);
     payment2.setInterceptWithholding(-55619.79);
     payment2.setAtRiskAdjustment(0.00);
     payment2.setDistributionAmount(198073.42);
     
     
     collection.getMonthlyPayments().add(payment2);
     
      /**
      * 
      */
     CsiPayment payment3 = new CsiPayment();
     payment3.setCounty("Brighton");
     payment3.setChaterSchool("Academy at High Point");
     payment3.setPupilCount(637.0);
     payment3.setKfactor(null);
     payment3.setPerPupilRevenue(6260.38);
     payment3.setTotalFunding(3987862.06);
     payment3.setMonthlyEntitlement(332321.84);
     payment3.setCdeWithholding(-3323.22);
     payment3.setAssistanceWithholding(0.00);
     payment3.setInstituteWithholding(-9969.66);
     payment3.setInterceptWithholding(68536.88);
     payment3.setAtRiskAdjustment(0.00);
     payment3.setDistributionAmount(250492.08);
     
     collection.getMonthlyPayments().add(payment3);
     
      /**
      * 
      */
     CsiPayment payment4 = new CsiPayment();
     payment4.setCounty("Westminister");
     payment4.setChaterSchool("Early College of Arvada");
     payment4.setPupilCount(231.0);
     payment4.setKfactor(null);
     payment4.setPerPupilRevenue(6228.55);
     payment4.setTotalFunding(1438795.05);
     payment4.setMonthlyEntitlement(119899.59);
     payment4.setCdeWithholding(-1199.00);
     payment4.setAssistanceWithholding(0.00);
     payment4.setInstituteWithholding(-3596.99);
     payment4.setInterceptWithholding(0.00);
     payment4.setAtRiskAdjustment(0.00);
     payment4.setDistributionAmount(115103.60);
     
     collection.getMonthlyPayments().add(payment4);
     
     
      /**
      * 
      */
     CsiPayment payment5 = new CsiPayment();
     payment5.setCounty("Westminister");
     payment5.setChaterSchool("GOAL Online Academy");
     payment5.setPupilCount(2187.0);
     payment5.setKfactor(null);
     payment5.setPerPupilRevenue(5915.71);
     payment5.setTotalFunding(12937657.77);
     payment5.setMonthlyEntitlement(1078138.15);
     payment5.setCdeWithholding(-10781.38);
     payment5.setAssistanceWithholding(0.00);
     payment5.setInstituteWithholding(-32344.14);
     payment5.setInterceptWithholding(null);
     payment5.setAtRiskAdjustment(0.00);
     payment5.setDistributionAmount(1035012.63);
     
     collection.getMonthlyPayments().add(payment5);
     
      /**
      * 
      */
     CsiPayment payment6 = new CsiPayment();
     payment6.setCounty("Westminister");
     payment6.setChaterSchool("Ricardo FLores Magnon Academ");
     payment6.setPupilCount(277.1);
     payment6.setKfactor(null);
     payment6.setPerPupilRevenue(6968.88);
     payment6.setTotalFunding(1931076.65);
     payment6.setMonthlyEntitlement(160923.05);
     payment6.setCdeWithholding(-1609.23);
     payment6.setAssistanceWithholding(0.00);
     payment6.setInstituteWithholding(-4827.69);
     payment6.setInterceptWithholding(null);
     payment6.setAtRiskAdjustment(0.00);
     payment6.setDistributionAmount(67858.13);
     
     collection.getMonthlyPayments().add(payment6);
     
      /**
      * 
      */
     CsiPayment payment7 = new CsiPayment();
     payment7.setCounty("Eagle");
     payment7.setChaterSchool("Stone Creek Elementary");
     payment7.setPupilCount(130.9);
     payment7.setKfactor(null);
     payment7.setPerPupilRevenue(6479.96);
     payment7.setTotalFunding(848226.76);
     payment7.setMonthlyEntitlement(70685.56);
     payment7.setCdeWithholding(-706.86);
     payment7.setAssistanceWithholding(0.00);
     payment7.setInstituteWithholding(-2120.57);
     payment7.setInterceptWithholding(null);
     payment7.setAtRiskAdjustment(0.00);
     payment7.setDistributionAmount(67858.13);
     
     collection.getMonthlyPayments().add(payment7);
     
      /**
      * 
      */
     CsiPayment payment8 = new CsiPayment();
     payment8.setCounty("Calhan");
     payment8.setChaterSchool("Frontier Academy");
     payment8.setPupilCount(63.5);
     payment8.setKfactor(null);
     payment8.setPerPupilRevenue(7179.78);
     payment8.setTotalFunding(455916.03);
     payment8.setMonthlyEntitlement(37993.00);
     payment8.setCdeWithholding(-379.93);
     payment8.setAssistanceWithholding(0.00);
     payment8.setInstituteWithholding(-1139.79);
     payment8.setInterceptWithholding(null);
     payment8.setAtRiskAdjustment(0.00);
     payment8.setDistributionAmount(36473.28);
     
     collection.getMonthlyPayments().add(payment8);
     
      /**
      * 
      */
     CsiPayment payment9 = new CsiPayment();
     payment9.setCounty("Colorado Springs");
     payment9.setChaterSchool("Pikes Peak Prep (21st Century");     
     payment9.setPupilCount(275.7);
     payment9.setKfactor(null);
     payment9.setPerPupilRevenue(6339.73);
     payment9.setTotalFunding(1747863.56);
     payment9.setMonthlyEntitlement(145655.30);
     payment9.setCdeWithholding(-1456.56);
     payment9.setAssistanceWithholding(0.00);
     payment9.setInstituteWithholding(-4369.66);
     payment9.setInterceptWithholding(-17750.00);
     payment9.setAtRiskAdjustment(0.00);
     payment9.setDistributionAmount(122079.09);
     
     collection.getMonthlyPayments().add(payment9);
     
      /**
      * 
      */
     CsiPayment payment10 = new CsiPayment();
     payment10.setCounty("Colorado Springs");
     payment10.setChaterSchool("Scholars to Leaders Academy");
     payment10.setPupilCount(232.2);
     payment10.setKfactor(null);
     payment10.setPerPupilRevenue(6565.23);
     payment10.setTotalFunding(1524446.41);
     payment10.setMonthlyEntitlement(127037.20);
     payment10.setCdeWithholding(-1270.37);
     payment10.setAssistanceWithholding(0.00);
     payment10.setInstituteWithholding(-3811.12);
     payment10.setInterceptWithholding(null);
     payment10.setAtRiskAdjustment(0.00);
     payment10.setDistributionAmount(121955.71);
     
     collection.getMonthlyPayments().add(payment10);
     
      /**
      * 
      */
     CsiPayment payment11 = new CsiPayment();
     payment11.setCounty("Colorado Springs");
     payment11.setChaterSchool("Maciaren Charter School");     
     payment11.setPupilCount(161.0);
     payment11.setKfactor(null);
     payment11.setPerPupilRevenue(6079.70);
     payment11.setTotalFunding(978831.70);
     payment11.setMonthlyEntitlement(81569.31);
     payment11.setCdeWithholding(-815.69);
     payment11.setAssistanceWithholding(0.00);
     payment11.setInstituteWithholding(-2447.08);
     payment11.setInterceptWithholding(null);
     payment11.setAtRiskAdjustment(0.00);
     payment11.setDistributionAmount(78306.54);
     
     collection.getMonthlyPayments().add(payment11);
     
      /**
      * 
      */
     CsiPayment payment12 = new CsiPayment();
     payment12.setCounty("Colorado Springs");
     payment12.setChaterSchool("Colorado Springs Charter Acade");
     payment12.setPupilCount(395.6);
     payment12.setKfactor(null);
     payment12.setPerPupilRevenue(6097.02);
     payment12.setTotalFunding(2411981.11);
     payment12.setMonthlyEntitlement(200998.43);
     payment12.setCdeWithholding(-2009.98);
     payment12.setAssistanceWithholding(0.00);
     payment12.setInstituteWithholding(-6029.95);
     payment12.setInterceptWithholding(-44127.30);
     payment12.setAtRiskAdjustment(0.00);
     payment12.setDistributionAmount(148831.20);
     
     collection.getMonthlyPayments().add(payment12);
     
      /**
      * 
      */
     CsiPayment payment13 = new CsiPayment();
     payment13.setCounty("Poudre");
     payment13.setChaterSchool("Calvert Online");
     payment13.setPupilCount(171.5);
     payment13.setKfactor(6142.41);
     payment13.setPerPupilRevenue(5915.71);
     payment13.setTotalFunding(1023143.64);
     payment13.setMonthlyEntitlement(85261.97);
     payment13.setCdeWithholding(-852.62);
     payment13.setAssistanceWithholding(0.00);
     payment13.setInstituteWithholding(-2556.86);
     payment13.setInterceptWithholding(null);
     payment13.setAtRiskAdjustment(0.00);
     payment13.setDistributionAmount(81851.49);
     
     collection.getMonthlyPayments().add(payment13);
     
     return collection;
    }
    
}
