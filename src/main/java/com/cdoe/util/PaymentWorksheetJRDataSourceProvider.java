package com.cdoe.util;

import com.cdoe.biz.model.PaymentWorkSheet;
import com.cdoe.biz.model.PaymentWorkSheetCalculation;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRDataSourceProvider;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRPropertiesHolder;
import net.sf.jasperreports.engine.JRPropertiesMap;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Tony Ford
 */
public class PaymentWorksheetJRDataSourceProvider implements  JRDataSourceProvider {
    /**
     *
     */
    public class BasicField implements  JRField {
        private String name;
        private String description = "data field";
        private Class type;

        public BasicField(String name, Class type) {
            this.name = name;
            this.type = type;
        }

        public BasicField(String name, String description, Class type) {
            this.name = name;
            this.description = description;
            this.type = type;
        }
        
        public String getName() {
           return name;
        }

        public String getDescription() {
           return description;
        }

        public void setDescription(String string) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Class getValueClass() {
            return type;
        }

        public String getValueClassName() {
            return type.getName();
        }

        public boolean hasProperties() {
            return false;
        }

        public JRPropertiesMap getPropertiesMap() {
           return  new JRPropertiesMap();
        }

        public JRPropertiesHolder getParentProperties() {
            return null;
        }

        @Override
        public Object clone() {
          return this;
        }
        
    }
    
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
      JRField[] fieldsAre = new JRField[7];  
      
      fieldsAre[0] = new BasicField(PaymentWorksheetDatasource.DISTRICT_NAME,String.class);
      fieldsAre[1] = new BasicField(PaymentWorksheetDatasource.DISTRICT_NUMBER,String.class);
      fieldsAre[2] = new BasicField(PaymentWorksheetDatasource.DISTRICT_COUNTY,String.class);
      fieldsAre[3] = new BasicField(PaymentWorksheetDatasource.FISCAL_YEAR,String.class);
      fieldsAre[4] = new BasicField(PaymentWorksheetDatasource.PUPIL_COUINT,Long.class);
      fieldsAre[5] = new BasicField(PaymentWorksheetDatasource.TITLE,String.class);
      fieldsAre[6] = new BasicField(PaymentWorksheetDatasource.CALCULATION,String.class);
      
      return fieldsAre;
    }
    
    /**
     * 
     * @param fieldName
     * @param type
     * @return 
     */
    public BasicField createBasicField(String fieldName, Class type) {
     return new BasicField(fieldName, type);   
    }

    /**
     * 
     * @param jr
     * @return
     * @throws JRException 
     */
    public JRDataSource create(JasperReport jr) throws JRException {
     return  new PaymentWorksheetDatasource(createPaymentWorkSheet());
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
     * @param vargs 
     */
    public static final void main(String[] vargs) {
     PaymentWorkSheet worksheet = createPaymentWorkSheet();   
       
       int count = 0;
       for (PaymentWorkSheetCalculation calculation : worksheet.getCalculations()) {
        System.out.print("count= " + (++count) + " ");   
     
        System.out.println(calculation.getTitle() + " " + calculation.getFormattedValue());   
       }
    }
    
    /**
     * 
     * @return 
     */
    private static PaymentWorkSheet createPaymentWorkSheet() {
     final String REGULAR_TYPE = "%10d";
     final String FLOATING_TYPE = "%10.4f";
     final String MONEY_TYPE = "$ %,11.2f";
     final String MILEAGE_TYPE = "%11.1f miles";
     
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
     
     
     return worksheet;
    }
    
}
