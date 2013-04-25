package com.cdoe.util;

import com.cdoe.biz.model.PaymentWorkBook;
import com.cdoe.biz.model.PaymentWorkSheet;
import com.cdoe.biz.model.PaymentWorkSheetCalculation;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Tony Ford
 */
public class PaymentWorkBookJRDataSourceProvider extends PaymentWorksheetJRDataSourceProvider {

    /**
     * 
     */
    public PaymentWorkBookJRDataSourceProvider() {
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
                
          JRField[] suprFields = super.getFields(jr);
                 
          JRField[] fieldsAre = new JRField[suprFields.length + 2];  
          
          int x = 0;
          for (JRField field : suprFields) {
           fieldsAre[x++] = field;  
          }
          
          
          fieldsAre[x++] = super.createBasicField(PaymentWorkbookDatasource.WORKSHEET_COUNT, Integer.class);
          
          fieldsAre[x++] = super.createBasicField(PaymentWorkbookDatasource.WORKSHEET_TOTAL, Integer.class);
          
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
        return new PaymentWorkbookDatasource(createPaymentWorkBook());
    }
    
    
    /**
     * 
     * @return 
     */
    private static PaymentWorkBook createPaymentWorkBook() {
     final String REGULAR_TYPE = "%10d";
     final String FLOATING_TYPE = "%10.4f";
     final String MONEY_TYPE = "$ %,11.2f";
     final String MILEAGE_TYPE = "%11.1f miles";
     
     PaymentWorkBook workbook = new PaymentWorkBook();
     
     PaymentWorkSheet worksheet3 =  new PaymentWorkSheet();
     
     worksheet3.setDistrictName("FOUNTAIN 8");
     worksheet3.setDistrictNumber("1000");
     worksheet3.setFiscalYear("2012-2013");
     worksheet3.setCounty("Denver");
     worksheet3.setPupilCount(6745L);
    
               
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("1. Number of pupils", 3498,REGULAR_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("2. Current total oprating expenditures for pupil transportation (line 1C from CDE-40", 123456.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("3. Net current operating expenses (Line 1 minus Line 2)", 550213.88,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("4. Mileage traveled for transporting migrant education pupils (Line 2 CDE-40)", 71116.0,MILEAGE_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("5. Mileage traveled for regular pupil transportation on the mileage count date (Line 3 CDE-40 -- Nearest to October 1", 12506.5,MILEAGE_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("6. Days of school held when pupil were transporgted in 2011-2012 fiscal year school team (Linee 4 CDE-40)", 130.0,FLOATING_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("7. Regular education pupil transportation mileage", 88294.1,MILEAGE_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("8. Transportation reimbursable muileage (Line 4 plus Line 7)", 45389.3,MILEAGE_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("9. Mileage entitlement (Line 8 times .3787)", 101101.9,MILEAGE_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("10. Excess costs (Line 3 minus Line 9)", 10000.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("11. Excess costs entitlement (Line 10 times .3387)", 30000.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("12. Mileage entitlement plus excess cost entitlement (Line 9 plus Line 11)", 120387.0,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("13. Maximum reimbursement entitlement (Line 3 times .90)", 500000.0,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("14. Calculated reimbursement entitlement for 2010-2011 (Less of Lines 12 or 13)", 22987.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("15. Calculated reimbursement entitlement for 2009-2010 (see attached list)", 19746.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("16. Reimbursement entitlement for 2010-2011 not including financial aid board (Greater of Lines 14 and 15)", 31765.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("17. Financial aid for providing board (number of days board was paid for pupils in lieu of transportation -- times $1)", 67928.99,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("18. Reimbursement entitlement for 2010-2011 (Lines 16 plus Line 17)", 12000.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("19. Adance reimbursement entitlement for 2010-2011", 2000.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("20. Final reimbursement entitlement for 2010-2011 (Line 18 minus Line 19)", 712898.99,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("21. Final reimbursement entitlement prorated (Line 20 times .51718479)", 100787.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("22. Advance reimbursement entitlement for 2011-2012 (Line 18 times .2)", 1119998.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("23. Additional reimbursement for court desegregation order", 90836.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("24. Total payment for 2010-2011 (Line 21 plus Line 22 plus Line 23)", 1000000.00,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("25. Total actual miles traveled for activity trips, field trips, athletic trips, etc. for 2010-2011", 180005.0,MONEY_TYPE));
     worksheet3.getCalculations().add(new PaymentWorkSheetCalculation("26. Total actual miles traveled for any purpose in 2010-2011 (excluding transportation support vehicles", 212889.0,MONEY_TYPE));
     
     workbook.getSheets().add(worksheet3);
     
     PaymentWorkSheet worksheet2 =  new PaymentWorkSheet();
     
     worksheet2.setDistrictName("MC Clave RE-2");
     worksheet2.setDistrictNumber("0310");
     worksheet2.setFiscalYear("2012-2013");
     worksheet2.setCounty("Denver");
     worksheet2.setPupilCount(8982L);
    
               
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("1. Number of pupils", 3498,REGULAR_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("2. Current total oprating expenditures for pupil transportation (line 1C from CDE-40", 123456.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("3. Net current operating expenses (Line 1 minus Line 2)", 550213.88,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("4. Mileage traveled for transporting migrant education pupils (Line 2 CDE-40)", 71116.0,MILEAGE_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("5. Mileage traveled for regular pupil transportation on the mileage count date (Line 3 CDE-40 -- Nearest to October 1", 12506.5,MILEAGE_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("6. Days of school held when pupil were transporgted in 2011-2012 fiscal year school team (Linee 4 CDE-40)", 130.0,FLOATING_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("7. Regular education pupil transportation mileage", 88294.1,MILEAGE_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("8. Transportation reimbursable muileage (Line 4 plus Line 7)", 45389.3,MILEAGE_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("9. Mileage entitlement (Line 8 times .3787)", 101101.9,MILEAGE_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("10. Excess costs (Line 3 minus Line 9)", 10000.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("11. Excess costs entitlement (Line 10 times .3387)", 30000.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("12. Mileage entitlement plus excess cost entitlement (Line 9 plus Line 11)", 120387.0,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("13. Maximum reimbursement entitlement (Line 3 times .90)", 500000.0,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("14. Calculated reimbursement entitlement for 2010-2011 (Less of Lines 12 or 13)", 22987.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("15. Calculated reimbursement entitlement for 2009-2010 (see attached list)", 19746.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("16. Reimbursement entitlement for 2010-2011 not including financial aid board (Greater of Lines 14 and 15)", 31765.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("17. Financial aid for providing board (number of days board was paid for pupils in lieu of transportation -- times $1)", 67928.99,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("18. Reimbursement entitlement for 2010-2011 (Lines 16 plus Line 17)", 12000.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("19. Adance reimbursement entitlement for 2010-2011", 2000.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("20. Final reimbursement entitlement for 2010-2011 (Line 18 minus Line 19)", 712898.99,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("21. Final reimbursement entitlement prorated (Line 20 times .51718479)", 100787.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("22. Advance reimbursement entitlement for 2011-2012 (Line 18 times .2)", 1119998.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("23. Additional reimbursement for court desegregation order", 90836.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("24. Total payment for 2010-2011 (Line 21 plus Line 22 plus Line 23)", 1000000.00,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("25. Total actual miles traveled for activity trips, field trips, athletic trips, etc. for 2010-2011", 180005.0,MONEY_TYPE));
     worksheet2.getCalculations().add(new PaymentWorkSheetCalculation("26. Total actual miles traveled for any purpose in 2010-2011 (excluding transportation support vehicles", 212889.0,MONEY_TYPE));
     
     workbook.getSheets().add(worksheet2);
     
     PaymentWorkSheet worksheet =  new PaymentWorkSheet();
     
     worksheet.setDistrictName("DPS");
     worksheet.setDistrictNumber("303");
     worksheet.setFiscalYear("2012-2013");
     worksheet.setCounty("Denver");
     worksheet.setPupilCount(23980L);
    
               
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("1. Number of pupils", 3498,REGULAR_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("2. Current total oprating expenditures for pupil transportation (line 1C from CDE-40", 123456.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("3. Net current operating expenses (Line 1 minus Line 2)", 550213.88,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("4. Mileage traveled for transporting migrant education pupils (Line 2 CDE-40)", 71116.0,MILEAGE_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("5. Mileage traveled for regular pupil transportation on the mileage count date (Line 3 CDE-40 -- Nearest to October 1", 12506.5,MILEAGE_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("6. Days of school held when pupil were transporgted in 2011-2012 fiscal year school team (Linee 4 CDE-40)", 130.0,FLOATING_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("7. Regular education pupil transportation mileage", 88294.1,MILEAGE_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("8. Transportation reimbursable muileage (Line 4 plus Line 7)", 45389.3,MILEAGE_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("9. Mileage entitlement (Line 8 times .3787)", 101101.9,MILEAGE_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("10. Excess costs (Line 3 minus Line 9)", 10000.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("11. Excess costs entitlement (Line 10 times .3387)", 30000.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("12. Mileage entitlement plus excess cost entitlement (Line 9 plus Line 11)", 120387.0,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("13. Maximum reimbursement entitlement (Line 3 times .90)", 500000.0,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("14. Calculated reimbursement entitlement for 2010-2011 (Less of Lines 12 or 13)", 22987.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("15. Calculated reimbursement entitlement for 2009-2010 (see attached list)", 19746.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("16. Reimbursement entitlement for 2010-2011 not including financial aid board (Greater of Lines 14 and 15)", 31765.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("17. Financial aid for providing board (number of days board was paid for pupils in lieu of transportation -- times $1)", 67928.99,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("18. Reimbursement entitlement for 2010-2011 (Lines 16 plus Line 17)", 12000.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("19. Adance reimbursement entitlement for 2010-2011", 2000.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("20. Final reimbursement entitlement for 2010-2011 (Line 18 minus Line 19)", 712898.99,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("21. Final reimbursement entitlement prorated (Line 20 times .51718479)", 100787.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("22. Advance reimbursement entitlement for 2011-2012 (Line 18 times .2)", 1119998.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("23. Additional reimbursement for court desegregation order", 90836.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("24. Total payment for 2010-2011 (Line 21 plus Line 22 plus Line 23)", 1000000.00,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("25. Total actual miles traveled for activity trips, field trips, athletic trips, etc. for 2010-2011", 180005.0,MONEY_TYPE));
     worksheet.getCalculations().add(new PaymentWorkSheetCalculation("26. Total actual miles traveled for any purpose in 2010-2011 (excluding transportation support vehicles", 212889.0,MONEY_TYPE));
     
     workbook.getSheets().add(worksheet);
     
     
     return workbook;
    }
    
}
