package com.cdoe.biz.model.jasper;

import java.util.Date;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRDataSourceProvider;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;

import com.cdoe.util.JrDatasourceBasicField;

/**
 *
 * @author Sandeep Sarkar
 */
public class MillLevyOverrideCalcProvider implements  JRDataSourceProvider{

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
       JRField[] overrideCalcfields = new JRField[12];
                
        overrideCalcfields[0] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.GRAND_TOTAL_PROG, "The county the district is in", String.class);
        overrideCalcfields[1] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.MIN_OVERRIDE_ALLOWED, "The colum1 value associated with a title", String.class);
        overrideCalcfields[2] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.QUARTER_OF_TOTAL_PROG, "The column2 value associated with a title", String.class);
        overrideCalcfields[3] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.ALLOWABLE_OVERRIDE, "The column3 value associated with a title", String.class);
        overrideCalcfields[4] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.TITLE, "value description or heading", String.class);
        overrideCalcfields[5] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.IS_BOLD, "Indicates that the title needs to be in bold.", Boolean.class);
        overrideCalcfields[6] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.MIN_OVERRIDE_ALLOWED, "The fiscal year in which the paymennts were made.", String.class);        
        overrideCalcfields[7] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.DISTRICT_NAME, "The name of the district", String.class);
        overrideCalcfields[8] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.DISTRICT_NUMBER, "The district number.", String.class);
        overrideCalcfields[9] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.IS_INDENTED, "Indicates that the title needs to be indented", Boolean.class);
        overrideCalcfields[10] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.PROPERTY_TAX_REVENUE, "The date of certification", Date.class);
        overrideCalcfields[11] = JrDatasourceBasicField.newInstance(MillLevyOverrideCalcDatasource.QUARTER_OF_TOTAL_PROG, "The date of certification", Date.class);
        
        
        return overrideCalcfields;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
        return new MillLevyOverrideCalcDatasource(createMillLevyOverrideCalcCollection());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
        
    }
    
    /**
     * 
     * @param vargs 
     */
    public static final void main(String[] vargs) {
    	MillLevyOverrideCalcCollection collection = createMillLevyOverrideCalcCollection();
     
     for (MillLevyOverrideCalculation calc : collection.getCalculations()) {
      System.out.printf("title : %s  value1 : %s \r\n", calc.getTitle(), calc.getColumn1FormattedValue());   
     }
    }
    
    /**
     * 
     * @return 
     */
    public static final MillLevyOverrideCalcCollection createMillLevyOverrideCalcCollection() {
     final String REGULAR_TYPE = "%12d";
     final String MONEY_TYPE = "$ %12.2f";
     
     MillLevyOverrideCalcCollection collection = new MillLevyOverrideCalcCollection();
     collection.setDistrictNumber("310");
     collection.setDistrictName("St Vrain");
     collection.setTaxYear("2011");
     
     //(String title, Number column1Value, Number column2Value, Number column3Value, String formatString)
     collection.getCalculations().add(new MillLevyOverrideCalculation("1. Projected Total Program - Formula Funding",1222124.995, MONEY_TYPE));
     collection.getCalculations().add(new MillLevyOverrideCalculation("2. 25% of Total Program",250000.0, MONEY_TYPE, false, true));
     collection.getCalculations().add(new MillLevyOverrideCalculation("3. Minimum Overrides Allowed: ",345000.0, MONEY_TYPE));
     collection.getCalculations().add(new MillLevyOverrideCalculation("4. Allowable Override ",6403200.41,MONEY_TYPE));
     collection.getCalculations().add(new MillLevyOverrideCalculation("5. Greater of 25% of Total Program or 200,000",4300000.01, MONEY_TYPE, false, true));
     collection.getCalculations().add(new MillLevyOverrideCalculation("6. Plus cost of Living Adjustments",123400.02, MONEY_TYPE));
     collection.getCalculations().add(new MillLevyOverrideCalculation("7 Total Allowable Override",78012340.120, MONEY_TYPE));
     collection.getCalculations().add(new MillLevyOverrideCalculation("8. Total Existing Override Property Tax Revenues ",506200.0, MONEY_TYPE));
     collection.getCalculations().add(new MillLevyOverrideCalculation("9. Remaining Balance at  25% Limit",1.4, MONEY_TYPE));
    
     return collection;
    }
}
