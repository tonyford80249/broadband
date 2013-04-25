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
 *
 * @author Tony Ford
 */
public class SeMonthlyPaymentComparisonProvider implements  JRDataSourceProvider {

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
        JRField[] fieldsAre = new JRField[11];
        
        fieldsAre[0] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.DISTRICT_NAME, "The District Name", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.DISTRICT_NUMBER, "The District Number", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.COUNTY, "The County the school or institution is in", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.DESC, "description of the values being compared", String.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.VALUE1, "first value", String.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.VALUE2, "second value", String.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.FORMAT_CODE, "used to provide custom formatting for the report", Integer.class);
        fieldsAre[7] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.FISCAL_YEAR_1, "first fiscal year", String.class);
        fieldsAre[8] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.FISCAL_MONTH_1, "first fiscal month", String.class);
        fieldsAre[9] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.FISCAL_YEAR_2, "second fiscal year", String.class);
        fieldsAre[10] = JrDatasourceBasicField.newInstance(SeMonthlyPaymentComparisonDatasource.FISCAL_MONTH_2, "second fiscal month", String.class);
        
        
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
        return new SeMonthlyPaymentComparisonDatasource(createSeMonthlyPaymentComparison());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
        
    }
    
    /**
     * 
     * @return 
     */
    public static final SeMonthlyPaymentComparison createSeMonthlyPaymentComparison() {
      final String REGULAR_TYPE = "%10d";
      final String FLOATING_TYPE = "%10.4f";
      final String MONEY_TYPE = "$ %,11.2f";
      final String MILEAGE_TYPE = "%11.1f miles";
      final String COUNT_TYPE = "%11.1f";
     
      SeMonthlyPaymentComparison comparison = new SeMonthlyPaymentComparison();
      comparison.setCounty("ADAMS");
      comparison.setDistrictName("MAPLETON");
      comparison.setFiscalMonth1("July");
      comparison.setFiscalYear1("2011-2012");
      comparison.setFiscalYear2("2012-2013");
      comparison.setFiscalMonth2("August");
      
      
      SeMonthlyPaymentComparisonCalculation line1 = new SeMonthlyPaymentComparisonCalculation("Funded Pupil Count",new Double(7342.3),COUNT_TYPE,new Double(7342.3),COUNT_TYPE);
      SeMonthlyPaymentComparisonCalculation line2 = new SeMonthlyPaymentComparisonCalculation("Total At-Risk Pupils",new Double(4307.4),COUNT_TYPE,new Double(4307.4),COUNT_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank1 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank1.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      
      SeMonthlyPaymentComparisonCalculation line3 = new SeMonthlyPaymentComparisonCalculation("Total Program Funding",new Double(48025109.18),MONEY_TYPE,new Double(48025109.18),MONEY_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank2 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank2.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      
      SeMonthlyPaymentComparisonCalculation line4 = new SeMonthlyPaymentComparisonCalculation("Assessed Valuation",new Double(453631720.00),MONEY_TYPE,new Double(453631720.00),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line5 = new SeMonthlyPaymentComparisonCalculation("Total Program Mill Levy",new Double(26080.00),MONEY_TYPE,new Double(26080.00),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line6 = new SeMonthlyPaymentComparisonCalculation("Property Tax Revenues",new Double(11830715.26),MONEY_TYPE,new Double(11830715.26),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line7 = new SeMonthlyPaymentComparisonCalculation("Specific Ownership Tax",new Double(817980.60),MONEY_TYPE,new Double(817980.60),MONEY_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank3 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank3.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      
      SeMonthlyPaymentComparisonCalculation line8 = new SeMonthlyPaymentComparisonCalculation("Annual State Share",new Double(35376413.32),MONEY_TYPE,new Double(35376413.32),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line9 = new SeMonthlyPaymentComparisonCalculation("Divide By",new Double(12),COUNT_TYPE,new Double(12),COUNT_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank4 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank4.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total1 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total1.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      SeMonthlyPaymentComparisonCalculation line10 = new SeMonthlyPaymentComparisonCalculation("Year-to-date State Share to be Paid",null,null,null,null);
      SeMonthlyPaymentComparisonCalculation line11 = new SeMonthlyPaymentComparisonCalculation("Year-to-date State Share Already Paid",null,null,null,null);
      //SeMonthlyPaymentComparisonCalculation blank5 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank5.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total2 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total2.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      SeMonthlyPaymentComparisonCalculation line12 =  new SeMonthlyPaymentComparisonCalculation("Gross State Share Payment",new Double(2948034.44),MONEY_TYPE,new Double(2948034.44),MONEY_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank6 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank6.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      
      SeMonthlyPaymentComparisonCalculation line13 = new SeMonthlyPaymentComparisonCalculation("Per Pupil Operating Revenues (PPOR)",new Double(6540.88),MONEY_TYPE,new Double(6540.88),MONEY_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank7 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank7.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total3 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total3.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      SeMonthlyPaymentComparisonCalculation line14 = new SeMonthlyPaymentComparisonCalculation("Annual OODS Withholding",new Double(0.00),MONEY_TYPE,new Double(0.00),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line15 = new SeMonthlyPaymentComparisonCalculation("Divide By",new Double(0),COUNT_TYPE,new Double(0),COUNT_TYPE);
      // SeMonthlyPaymentComparisonCalculation blank8 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank8.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total4 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total4.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      SeMonthlyPaymentComparisonCalculation line16 = new SeMonthlyPaymentComparisonCalculation("Year-to-date OODS to be Withheld",null,null,null,null);
      SeMonthlyPaymentComparisonCalculation line17 = new SeMonthlyPaymentComparisonCalculation("Year-to-date Already Withheld",null,null,null,null);
      // SeMonthlyPaymentComparisonCalculation blank9 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank9.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total5 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total5.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      SeMonthlyPaymentComparisonCalculation line18 = new SeMonthlyPaymentComparisonCalculation("OODS Monthly Withholding",new Double(0.00),MONEY_TYPE,new Double(0.00),MONEY_TYPE);
      // SeMonthlyPaymentComparisonCalculation blank10 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank10.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      
      SeMonthlyPaymentComparisonCalculation line19 = new SeMonthlyPaymentComparisonCalculation("Other Adjustments",null,null,null,null);
      line19.setFormatCode(SeMonthlyPaymentComparisonCalculation.HEADER_LINE);
      
      
      SeMonthlyPaymentComparisonCalculation line20 = new SeMonthlyPaymentComparisonCalculation("SWAP Withholding",new Double(0),MONEY_TYPE,new Double(0),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line21 = new SeMonthlyPaymentComparisonCalculation("Charter School Debt Withholding",new Double(0),MONEY_TYPE,new Double(0),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line22 = new SeMonthlyPaymentComparisonCalculation("Impact Assistance Grants (DOW)",null,null,null,null);
      SeMonthlyPaymentComparisonCalculation line23 = new SeMonthlyPaymentComparisonCalculation("Charter School Institute",new Double(0),MONEY_TYPE,new Double(0),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line24 = new SeMonthlyPaymentComparisonCalculation("Other (Rescissions)",new Double(0),MONEY_TYPE,new Double(0),MONEY_TYPE);
     //  SeMonthlyPaymentComparisonCalculation blank11 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank11.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total8 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total8.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      SeMonthlyPaymentComparisonCalculation line25 = new SeMonthlyPaymentComparisonCalculation("Total Adjustments",new Double(0),MONEY_TYPE,new Double(0),MONEY_TYPE);
      // SeMonthlyPaymentComparisonCalculation blank12 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank12.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total9 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total9.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      SeMonthlyPaymentComparisonCalculation line26 = new SeMonthlyPaymentComparisonCalculation("Net State Share (Payment Amount)",new Double(2948034.44),MONEY_TYPE,new Double(2948034.44),MONEY_TYPE);
      line26.setFormatCode(SeMonthlyPaymentComparisonCalculation.UNDER_LINE);
      
      comparison.getCalcuation().add(line1);
      comparison.getCalcuation().add(line2);
      //comparison.getCalcuation().add(blank1);
      comparison.getCalcuation().add(line3);
      //comparison.getCalcuation().add(blank2);
      comparison.getCalcuation().add(line4);
      comparison.getCalcuation().add(line5);
      comparison.getCalcuation().add(line6);
      comparison.getCalcuation().add(line7);
      //comparison.getCalcuation().add(blank3);
      comparison.getCalcuation().add(line8);
      comparison.getCalcuation().add(line9);
      //comparison.getCalcuation().add(blank4);
      comparison.getCalcuation().add(total1);
      comparison.getCalcuation().add(line10);
      comparison.getCalcuation().add(line11);
      //comparison.getCalcuation().add(blank5);
      comparison.getCalcuation().add(total2);
      comparison.getCalcuation().add(line12);
      //comparison.getCalcuation().add(blank6);      
      comparison.getCalcuation().add(line13);
      //comparison.getCalcuation().add(blank7);
      comparison.getCalcuation().add(total3);
      comparison.getCalcuation().add(line14);
      comparison.getCalcuation().add(line15);
      //comparison.getCalcuation().add(blank8);
      comparison.getCalcuation().add(total4);
      comparison.getCalcuation().add(line16);
      comparison.getCalcuation().add(line17);
      //comparison.getCalcuation().add(blank9);
      comparison.getCalcuation().add(total5);
      comparison.getCalcuation().add(line18);
      //comparison.getCalcuation().add(blank10);      
      comparison.getCalcuation().add(line19);
      comparison.getCalcuation().add(line20);
      comparison.getCalcuation().add(line21);
      comparison.getCalcuation().add(line22);
      comparison.getCalcuation().add(line23);
      comparison.getCalcuation().add(line24);
      //comparison.getCalcuation().add(blank11);
      comparison.getCalcuation().add(total8);
      comparison.getCalcuation().add(line25);
      //comparison.getCalcuation().add(blank12);
      comparison.getCalcuation().add(total9);
      comparison.getCalcuation().add(line26);      
      
      
      
      
      
      return comparison;
    }
    
}
