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
public class StateEqual360DatasourceProvider implements  JRDataSourceProvider {

    @Override
    public boolean supportsGetFieldsOperation() {
        return true;
    }

    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
        JRField[] fieldsAre = new JRField[8];
                
        fieldsAre[0] = JrDatasourceBasicField.newInstance(StateEqual360Datasource.COUNTY, "The county the district is in", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(StateEqual360Datasource.VALUE, "The value associated with a title", Double.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(StateEqual360Datasource.TITLE, "value description or heading", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(StateEqual360Datasource.HEADING_INDICATOR, "indicates that this is a heading for a new section", Boolean.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(StateEqual360Datasource.CURRENT_FISCAL_YEAR, "The fiscal year in which the paymennts were made.", String.class);        
        fieldsAre[5] = JrDatasourceBasicField.newInstance(StateEqual360Datasource.DISTRICT_NAME, "The name of the district", String.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(StateEqual360Datasource.DISTRICT_NUMBER, "The district number.", String.class);
        fieldsAre[7] = JrDatasourceBasicField.newInstance(StateEqual360Datasource.HEADING_INDICATOR2, "indicates that this is a heading for a new section", Boolean.class);
        
        
        return fieldsAre;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
       return new StateEqual360Datasource(createStateEqual360Collection());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
      
    }
    
    /**
     * 
     * @param vargs 
     */
    public static void main(String[] vargs) {
     StateEqual360Collection collection = createStateEqual360Collection();   
     
     for (StateEqual360Calculation calc: collection.getCalculations()) {
      System.out.printf("%s %s\r\n", calc.getTitle(),calc.getFormattedValue() != null ? calc.getFormattedValue() : " ");   
     }
    }
    
    /**
     * 
     * @return 
     */
    public static final StateEqual360Collection createStateEqual360Collection() {
     final String REGULAR_TYPE = "%12d";
     final String FLOATING_TYPE = "%12.6f";
     final String MONEY_TYPE = "$ %,12.2f";
     final String MILEAGE_TYPE = "%12.1f miles";
     final String COUNT_TYPE = "%12.1f";
     
     StateEqual360Collection collection = new StateEqual360Collection();
     collection.setDistrictNumber("0010");
     collection.setDistrictName("MAPPLETON");
     collection.setFiscalYear("Fy 2012-2013");
     collection.setCounty("Jenkins");
     
     //(Boolean heading, String title, Number value, String formatString)
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,false,"VARIABLES SECTION",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"PUPIL COUNTS",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("V1.  FY11 Grades 1 - 12 FTE",6805.0,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V1.1  Kindergarten FTE",281.0,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V2.  FY12 Special Education Preschool FTE",30.0,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V3.  FY12 October FTE Count (sum of lines V1. V1.1 and V2)",7116.0,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V4.  FY12 Multi-District On-Line Pupil Count",1506.5,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V4.1 FY12 ASCENT Pupil Count",0.0,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V5.  FY12 October FTE Count (minus on-line pupil count)",5609.5,FLOATING_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"FUNDING ELEMENTS",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("V21.  FY12 BAse Funding",5634.77,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V22.  FY12 Base Minimum Funding",7055.39,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V22.5  FY12 On-line Funding & ASCENT Funding",6795.00,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V23.  FY12 Cost of Living Factor",1.222,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V24.  FY12 At-risk 'Base' Factor",0.120,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V25.  FY12 At-risk 'Base' Factor - (FY01 year stays constant)",0.115,FLOATING_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"TAXES",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("V30.  FY12 Specific Ownership Tax",817980.60,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V31.  FY12 Assesed Valuation",453631720.0,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V32.  FY11 Mill Levy (FINAL)",0.026080,FLOATING_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"PRIOR YEAR FUNDING",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("V40.  FY11 Total Program",52921520.14,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V41.  FY11 Total Program Per-Puple Funding",5634.77,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V42.  FY11 'true' Formula Per-Pupile Funding",6116.30,MONEY_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"CATEGORICAL FUNDING",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("V50.  Transportation payments",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("      paid in FY12",469912.24,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V51.  Vocational Education payments",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("      paid in FY12",null,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V52.  English Language Proficiency Act payments",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("      paid in FY12",253978.00,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V53.  Special Education - Childdren with Disabilities",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("      paid in FY12",716297.00,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V54.  Special Education - Gifted/Talented payments",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("      paid in FY12",51732.13,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V56.  Total Categorical Funding",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("      sum of lines V50, V51, V52, V53, V54 and V55",1491919.37,MONEY_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"OTHER",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("V60.  FY10 Inflation",0.019,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V61.  CY09 Inflation",0.006,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V62.  FY12 Allowable Spending",999999999.00,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V63.  FY12 Actual Additional Funding Paid",999999999.00,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("V64.  FY95 Hold Harmless Amount - (FY95 year stays constant)",214049.00,MONEY_TYPE));
          
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("FORMULA SECTION",null,null));     
     collection.getCalculations().add(new StateEqual360Calculation(true,"FUNDED PUPIL COUNT",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("FC1.0  FY12 October FTE Count - enter line V5",5609.5,COUNT_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("FC2.0  FY11 October FTE Count - enter line V13",5650.0,COUNT_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("FC3.0  FY10 October FTE Count - enter line V14",5151.0,COUNT_TYPE));
     
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"SIZE FACTOR",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("SZ1.  Size Factor for Eligible District with Charter School(s) If line V11 is greater than zero and line FC9 is less than or equal to 500, go to line SZ2 else go to line SZ6",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("SZ2.  Alternate Funded Pupil Count for Eligle District with Charter School - enter line FC9 minus (line V11 times .65)",678.9567,COUNT_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("SZ3.  If line SZ2 is less than 276 - enter 276 minus line SZ2 times .00376159 plus 1.5457 (go to line SZ13)",0.7865,FLOATING_TYPE));
     
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"PERSONNEL COSTS FACTOR",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("PL1.  If lione FC9 is less than 453.5 - enter .825 minus (.0000639 times (453.5 minus line FC7)) (go to line PL6)",0.0000,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("PL2.  If line FC9 is less than 1567.5 - enter .8595 minus (.0000310 times (1567.5 minus line FC9)) (go to line PL6",0.678412,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("PL3.  If line FC9 is less than 6682 - enter .885 minus (.000050 times (6682 minus line FC9)) (go to line PL6)",0.0,FLOATING_TYPE));
     
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"PER-PUPIL FUNDING",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("PP1.  Base Funding - enter line V21",5634.77,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("PP2.  Personnel Costs factor - enter line PL6",0.8846,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("PP3.  Cost of Living Factor - enter line V23",1.222,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("PP9.  FORMULA FUNDING WITHOUT AT-RISK - enter line PP7 times line PP8",40509500.30,MONEY_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"AT-RISK PUPILS",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("AR1.  Free Lunch I(grades 1 - 8) - enter line V6",2717.00,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("AR2.  October Membership (grades 1 - 8) - enter line V9",4536.00,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("AR3.  Percent 1-8 Free Lunch Count - enter line AR1 divided by line AR2",0.5990,COUNT_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("AR4.  Projected k-12 At-Risk Count using 1-8 percent enter (line AR3 times line V10) plus V18 (ELL Count)",4307.4,COUNT_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("AR16.  At-risk 'Base' Fundng - enter line PP7 times line AR8 times line AR15",2188504.27,MONEY_TYPE));
  
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"ON-LINE FORMULA FUNDING",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("OL1.  FY12 On-line Pupil Count - enter line V4 plus line V20",1506.5,COUNT_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("OL2.  FY12 On-line Funding - enter - line V22.5",6795.00,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("OL3.  Total ON-LINE FORMULA FUNDING - enter linen OL1 times line OL2",1236667.50,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("OL6.  TOTAL ON-LINE & ASCENT FORMULA FUNDING (enter line OL3 plus OL5)",10236667.00,MONEY_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"459 SIZE FACTOR (SMOOTHING)",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("SM1.  If line FC9 less/equal to 459, enter 1 (go to line TB1)",0.0,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("SM2.  If line AR7 is less/equal line V8, enter 1 (go to line TB1)",0.0,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("SM3.  Per-Pupil Funding without size factor - enter line PP7 divided by line SZ13",6741.332894,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("SM4.  Size factor using 459 Funded Pupil Count enter - (1027 minus 459) times .00020599 plus 1.1215",1.238500,COUNT_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("SM8.  TOTAL FORMULA USING 459 SIZE FACTOR (enter line SM6 divided by 459 times line SM7) plus OL3",113829444.75,MONEY_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"TABOR FORMULA FUNDING",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("TB1. FY11 Total Program - enter line V40",52921520.14,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TB2. FY10 Inflationn - enter line V60",0.019,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TB3. FY12 Enrollment Growth - enter (line FC9 minus line V12) divided by line V12",0.019,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TB4. FY12 TABOR FORMULA FUNDING enter line TB1 times (1 plus TB2 plus line TB3)",55022504.49,MONEY_TYPE));
     
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"MINIMUM FORMULA FUNDING",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("MF1.  FY12 'Base Minimum' Funding - enter line V22",7055.39,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("MF2.  Funded Pupil Count - enter line FC7",5835.8,COUNT_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("MF3.  FY12 On-line & ASCENT Funding (enter line V22.5)",6795.00,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("MF5.  Guaranteed Minimum Funding - enter line MF1 times line MF2 plus line MF3 times line MF4",51410512.46,MONEY_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"TOTAL FORMULA FUNDING",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));     
     collection.getCalculations().add(new StateEqual360Calculation("TF1.  Formula Funding without At-risk - enter line PP9",40509500.30,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TF2.  Formula At-risk Funding - enter line AR19",4417207.82,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TF3.  Formula Funding - enter line TF1 plus line TF2",44926708.12,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TF4.  Total Formula Funding (including on-line funding) - enter line TF3 plus line TF4",55163375.62,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TF11. TOTAL FORMULA FUNDING enter the lesser of lines TF8, TF9 or TF10",55022504.49,MONEY_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"ADDITIONAL FUNDING",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("AF1.  If line TB4 equals line TF11 and line V63 is not equal to 888.888.888.88 go to line AF2 else go to line TP1",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("AF2.  Formula Funding enter the lesser of lines TF8 or TF9",55163375.62,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("AF3.  TABOR Formula Funding - enter line TB4",55022504.49,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("AF4.  Allowable Spending - enter line V62",999999999.00,MONEY_TYPE));
     
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"TOTAL PROGRAM FUNDING",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("TP1.  Total Formula Funding - enter line TF11",55022504.49,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TP2.  Total Additional Funding - enter line AF6",140871.13,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TP3.  TOTAL PROGRAM FUNDING - enter line TP1 plus line TP2",55163375.62,MONEY_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"MILL LEVY",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("ML1.  Mill Levy from prior year - enter line V32",0.026080,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("ML2.  Mill Levy to buyout Total Program Funding (line TP3 minus (line FC9 times line V26) minus line V30)",0.119800,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("ML3.  Mill Levy at TABOR maximum (line V33 times (1 plus line TB2 plus line TB3))",2.291947,FLOATING_TYPE));
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"CATEGORICAL BUYOUT MILL LEVY",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("CB1.  Categorical Program Funding - enter line v56",1491919.37,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("CB2.  Mill Levy to buyout Categorical Programs enter line CB1 divided by line V31",0.003289,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("CB3.  Categorical Buyout Mill Levy (CALC) enter then lesser of line CB2 or (line ML1 minus line ML6) or (line ML3 minus line ML6) if less than zero enter zero",0.0,FLOATING_TYPE));
     
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"GRAND TOTAL PROGRAM FUNDING",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("GT1.  TOTAL PROGRAM FUNDING -  enter line TP3",55163375.62,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("GT2.  PROPERTY TAX REVENUES - enter line ML6 times line v31",11830715.26,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("GT3.  SPECIFIC OWNERSHIP TAX - enter line v30",817980.60,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("GT4.  STATE SHARE - enter line GT1 minus GT2 minus GT3",42514679.76,MONEY_TYPE));
     
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"TOTAL PROGRAM FUNDING CHARTER INSTITUTE",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("GT8.  Adjusted District In-school per pupil funding",6702.27,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("GT9.  District on-line per pupil funding",55163375.62,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("GT10.  Charter Institute School Total Program Funding",0.00,MONEY_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("GT11.  DISTRICT ADJUSTED TOTAL PROG FUNDING (GT1 + GT7 - GT7.5 - GT10)",48025109.10,MONEY_TYPE));
     
     
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation(true,"TOTAL PROPERTY TAX MILL LEVIES",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("",null,null));
     collection.getCalculations().add(new StateEqual360Calculation("TM1.  Total Program - enter line ML6",0.026080,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TM2.  Categorical Buyout - enter line CB5",0.0,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TM3.  Hold Harmless Override - enter line v64 divided by line v31",0.000472,FLOATING_TYPE));
     collection.getCalculations().add(new StateEqual360Calculation("TM4.  Excess Hold Harmless Override - enter line v65 divided by line v31",0.0,FLOATING_TYPE));
     
     
     
     
      
     return collection;
    }
    
}
