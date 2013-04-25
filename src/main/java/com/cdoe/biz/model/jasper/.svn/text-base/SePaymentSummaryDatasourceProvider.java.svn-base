package com.cdoe.biz.model.jasper;

import com.cdoe.util.JrDatasourceBasicField;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRDataSourceProvider;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Tony Ford
 */
public class SePaymentSummaryDatasourceProvider implements  JRDataSourceProvider{

    @Override
    public boolean supportsGetFieldsOperation() {
      return true;
    }

    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
       JRField[] fieldsAre = new JRField[12];
        
        fieldsAre[0] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.CURRENT_MONTH, "The month that the payment applies to", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.ACCOUNT, "An account number", Double.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.MONTHLY_ENTITLEMENT, "The entitlement for the current month", Double.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.MONTHLY_PAYMENT, "The payment for the current month", Double.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.YTD_AUDIT, "year to date Audit adjustments", Double.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.YTD_CSI, "year to date CSI adjustments", Double.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.YTD_OTHER, "year to date other adjustments", Double.class);
        fieldsAre[7] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.YTD_CHARTER, "year to date charter adjustments", Double.class);
        fieldsAre[8] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.YTD_SWAP, "year to date swap adjustments", Double.class);
        fieldsAre[9] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.CURRENT_FISCAL_YEAR, "The fiscal year in which the paymennts were made.", String.class);        
        fieldsAre[10] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.DISTRICT_NAME, "The name of the district", String.class);
        fieldsAre[11] = JrDatasourceBasicField.newInstance(SePaymentSummaryDatasource.DISTRICT_NUMBER, "The district number.", String.class);
        
        
        return fieldsAre;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
        return new SePaymentSummaryDatasource(createSePaymentSummaryCollection());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
     
    }
    
    /**
     * 
     * @return 
     */
    public static final SePaymentSummaryCollection createSePaymentSummaryCollection() {
     SePaymentSummaryCollection collection = new SePaymentSummaryCollection();
     
     collection.setFiscalYear("20122013");
     collection.setFiscalMonth("December");
     
     SePaymentSummary s1 = new SePaymentSummary();
     
     s1.setDistrictNumber("0010");
     s1.setDistrictName("MAPLETON");
     s1.setEntitlement(2948034.44);
     s1.setPayment(2948034.44);
     s1.setAccountingNumber("0101");
     s1.setAudit12(0.00);
     s1.setCharter12(0.00);
     s1.setCsi12(0.00);
     s1.setOther12(0.00);
     s1.setSwap12(0.00);
     
     collection.getPaymentSummary().add(s1);
     
     
     
     SePaymentSummary s2 = new SePaymentSummary();
     //1
     s2 = new SePaymentSummary();s2.setDistrictNumber("0220");s2.setDistrictName("ARCHULETA COUNTY 50 JT"); s2.setEntitlement(293546.78);s2.setPayment(264954.59);s2.setAccountingNumber("0220");s2.setAudit12(0.00);s2.setCharter12(0.00);s2.setCsi12(0.00);s2.setOther12(-4765.37);s2.setSwap12(0.00);collection.getPaymentSummary().add(s2);
     
     //2
     s2 = new SePaymentSummary();s2.setDistrictNumber("0470");s2.setDistrictName("ST VRAIN VALLEY RE 1J"); s2.setEntitlement(10264729.61);s2.setPayment(8328675.47);s2.setAccountingNumber("0470");s2.setAudit12(0.00);s2.setCharter12(-3014027.01);s2.setCsi12(0.00);s2.setOther12(-55607.52);s2.setSwap12(-196674.89);collection.getPaymentSummary().add(s2);
     
     //3
     s2 = new SePaymentSummary();s2.setDistrictNumber("0550");s2.setDistrictName("NORTH CONEJOS RE-1J"); s2.setEntitlement(532973.75);s2.setPayment(513174.79);s2.setAccountingNumber("0550");s2.setAudit12(0.00);s2.setCharter12(0.00);s2.setCsi12(0.00);s2.setOther12(-3299.83);s2.setSwap12(0.00);collection.getPaymentSummary().add(s2);
    
     //4
     s2 = new SePaymentSummary();s2.setDistrictNumber("0860");s2.setDistrictName("CUSTER COUNTY SCHOOL DISTRICT C-1"); s2.setEntitlement(69781.51);s2.setPayment(63470.56);s2.setAccountingNumber("0860");s2.setAudit12(0.00);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-1051.83);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //5
     s2 = new SePaymentSummary();s2.setDistrictNumber("0870");s2.setDistrictName("DELTA COUNTY 50(J)"); s2.setEntitlement(1788144.09);s2.setPayment(1683244.11);s2.setAccountingNumber("0870");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-10724.33);s2.setSwap12(-81104.2);collection.getPaymentSummary().add(s2);
     
     //6
     s2 = new SePaymentSummary();s2.setDistrictNumber("0910");s2.setDistrictName("EAGLE COUNTY RE 50"); s2.setEntitlement(886272.38);s2.setPayment(791079.94);s2.setAccountingNumber("0910");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(20939.02);s2.setSwap12(-64790.91);collection.getPaymentSummary().add(s2);
     
     //7
     s2 = new SePaymentSummary();s2.setDistrictNumber("0970");s2.setDistrictName("CALHAN RJ-1"); s2.setEntitlement(264947.75);s2.setPayment(259605.9);s2.setAccountingNumber("0970");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(2887.98);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //8
     s2 = new SePaymentSummary();s2.setDistrictNumber("1030");s2.setDistrictName("MANITOU SPRINGS 14"); s2.setEntitlement(566279.04);s2.setPayment(547808.17);s2.setAccountingNumber("1030");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-3078.48);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //9
     s2 = new SePaymentSummary();s2.setDistrictNumber("1110");s2.setDistrictName("FALCON 49"); s2.setEntitlement(6472201.87);s2.setPayment(5705347.51);s2.setAccountingNumber("1110");s2.setAudit12(0.0);s2.setCharter12(-1101599.53);s2.setCsi12(0.0);s2.setOther12(-28776.22);s2.setSwap12(-86839.86);collection.getPaymentSummary().add(s2);
     
     //10
     s2 = new SePaymentSummary();s2.setDistrictNumber("0550");s2.setDistrictName("NORTH CONEJOS RE-1J"); s2.setEntitlement(532973.75);s2.setPayment(513174.79);s2.setAccountingNumber("0550");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-3299.83);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //11
     s2 = new SePaymentSummary();s2.setDistrictNumber("1600");s2.setDistrictName("HOEHNE REORGANIZED 3"); s2.setEntitlement(142386.2);s2.setPayment(126861.17);s2.setAccountingNumber("1600");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-2587.5);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //12
     s2 = new SePaymentSummary();s2.setDistrictNumber("1620");s2.setDistrictName("AGUILAR REORGANIZED 6"); s2.setEntitlement(78392.44);s2.setPayment(70899.16);s2.setAccountingNumber("1620");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-1248.88);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //13
     s2 = new SePaymentSummary();s2.setDistrictNumber("1330");s2.setDistrictName("GILPIN COUNTY RE-1"); s2.setEntitlement(138297.59);s2.setPayment(132382.61);s2.setAccountingNumber("1330");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-985.83);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //14
     s2 = new SePaymentSummary();s2.setDistrictNumber("2570");s2.setDistrictName("SWINK 33"); s2.setEntitlement(216845.99);s2.setPayment(204429.66);s2.setAccountingNumber("2570");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-2069.39);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //15
     s2 = new SePaymentSummary();s2.setDistrictNumber("2750");s2.setDistrictName("SARGENT RE-33J"); s2.setEntitlement(200958.64);s2.setPayment(189863.19);s2.setAccountingNumber("2750");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-1849.24);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //16
     s2 = new SePaymentSummary();s2.setDistrictNumber("2830");s2.setDistrictName("TELLURIDE R-1"); s2.setEntitlement(125981.75);s2.setPayment(112161.41);s2.setAccountingNumber("2830");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-2303.39);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //17
     s2 = new SePaymentSummary();s2.setDistrictNumber("3000");s2.setDistrictName("SUMMIT RE-1"); s2.setEntitlement(196326.2);s2.setPayment(157207.69);s2.setAccountingNumber("3000");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-6519.75);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //18
     s2 = new SePaymentSummary();s2.setDistrictNumber("3020");s2.setDistrictName("WOODLAND PARK RE-2"); s2.setEntitlement(917200.45);s2.setPayment(850490.62);s2.setAccountingNumber("3020");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-5718.3);s2.setSwap12(-64800.0);collection.getPaymentSummary().add(s2);
     
     //19
     s2 = new SePaymentSummary();s2.setDistrictNumber("3085");s2.setDistrictName("EATON RE-2"); s2.setEntitlement(504014.13);s2.setPayment(482379.35);s2.setAccountingNumber("3085");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-3605.8);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //20
     s2 = new SePaymentSummary();s2.setDistrictNumber("0020");s2.setDistrictName("ADAMS 12 FIVE STAR SCHOOLS"); s2.setEntitlement(19291561.99);s2.setPayment(16958519.83);s2.setAccountingNumber("0020");s2.setAudit12(0.0);s2.setCharter12(-2972739.66);s2.setCsi12(0.0);s2.setOther12(-278697.58);s2.setSwap12(-270190.64);collection.getPaymentSummary().add(s2);
     
     //21     
     s2 = new SePaymentSummary();s2.setDistrictNumber("0100");s2.setDistrictName("ALAMOSA RE-11J"); s2.setEntitlement(882948.13);s2.setPayment(794785.42);s2.setAccountingNumber("0100");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-6424.79);s2.setSwap12(-99233.0);collection.getPaymentSummary().add(s2);
     
     //22
     s2 = new SePaymentSummary();s2.setDistrictNumber("0240");s2.setDistrictName("PRITCHETT RE-3"); s2.setEntitlement(55155.36);s2.setPayment(53459.92);s2.setAccountingNumber("0240");s2.setAudit12(2345.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-282.57);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //23
     s2 = new SePaymentSummary();s2.setDistrictNumber("0480");s2.setDistrictName("BOULDER VALLEY RE 2"); s2.setEntitlement(5752757.41);s2.setPayment(4508890.04);s2.setAccountingNumber("0480");s2.setAudit12(0.0);s2.setCharter12(-1559264.18);s2.setCsi12(0.0);s2.setOther12(-60422.69);s2.setSwap12(-203934.56);collection.getPaymentSummary().add(s2);
     
     //24
     s2 = new SePaymentSummary();s2.setDistrictNumber("0490");s2.setDistrictName("BUENA VISTA R-31"); s2.setEntitlement(300927.8);s2.setPayment(258139.28);s2.setAccountingNumber("0490");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-2977.42);s2.setSwap12(-49846.0);collection.getPaymentSummary().add(s2);
     
     //25
     s2 = new SePaymentSummary();s2.setDistrictNumber("0880");s2.setDistrictName("DENVER COUNTY 1"); s2.setEntitlement(21411944.11);s2.setPayment(19526520.09);s2.setAccountingNumber("0880");s2.setAudit12(0.0);s2.setCharter12(-1196291.09);s2.setCsi12(0.0);s2.setOther12(-169219.26);s2.setSwap12(-306780.29);collection.getPaymentSummary().add(s2);
     
     //26
     s2 = new SePaymentSummary();s2.setDistrictNumber("0960");s2.setDistrictName("AGATE 300"); s2.setEntitlement(33467.39);s2.setPayment(32233.04);s2.setAccountingNumber("0960");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-205.73);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     //27
     s2 = new SePaymentSummary();s2.setDistrictNumber("1000");s2.setDistrictName("FOUNTAIN 8"); s2.setEntitlement(3552872.18);s2.setPayment(3443683.97);s2.setAccountingNumber("1000");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-14535.04);s2.setSwap12(-43956.0);collection.getPaymentSummary().add(s2);
     
     //28
     s2 = new SePaymentSummary();s2.setDistrictNumber("1010");s2.setDistrictName("COLORADO SPRINGS 11"); s2.setEntitlement(9994517.32);s2.setPayment(9762967.15);s2.setAccountingNumber("1010");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(287148.31);s2.setSwap12(-105611.0);collection.getPaymentSummary().add(s2);
     
     //29
     s2 = new SePaymentSummary();s2.setDistrictNumber("1050");s2.setDistrictName("ELLICOTT 22"); s2.setEntitlement(494898.18);s2.setPayment(471397.86);s2.setAccountingNumber("1050");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-2132.97);s2.setSwap12(-21405.0);collection.getPaymentSummary().add(s2);
     
     //30
     s2 = new SePaymentSummary();s2.setDistrictNumber("1120");s2.setDistrictName("EDISON 54 JT"); s2.setEntitlement(156124.74);s2.setPayment(152323.85);s2.setAccountingNumber("1120");s2.setAudit12(0.0);s2.setCharter12(0.0);s2.setCsi12(0.0);s2.setOther12(-633.48);s2.setSwap12(0.0);collection.getPaymentSummary().add(s2);
     
     return collection;
    }
}



