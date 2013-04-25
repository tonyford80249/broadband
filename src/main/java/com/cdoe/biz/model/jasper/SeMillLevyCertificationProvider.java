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
public class SeMillLevyCertificationProvider implements  JRDataSourceProvider{

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
       JRField[] fieldsAre = new JRField[14];
                
        fieldsAre[0] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.COUNTY, "The county the district is in", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.VALUE1, "The colum1 value associated with a title", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.VALUE2, "The column2 value associated with a title", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.VALUE3, "The column3 value associated with a title", String.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.TITLE, "value description or heading", String.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.IS_BOLD, "Indicates that the title needs to be in bold.", Boolean.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.TAX_YEAR, "The fiscal year in which the paymennts were made.", String.class);        
        fieldsAre[7] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.DISTRICT_NAME, "The name of the district", String.class);
        fieldsAre[8] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.DISTRICT_NUMBER, "The district number.", String.class);
        fieldsAre[9] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.APPROVER_NAME, "The approver name.", String.class);
        fieldsAre[10] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.APPROVER_PHONE, "The approver phone.", String.class);
        fieldsAre[11] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.IS_INDENTED, "Indicates that the title needs to be indented", Boolean.class);
        fieldsAre[12] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.CERT_DATE1, "The date of certification", Date.class);
        fieldsAre[13] = JrDatasourceBasicField.newInstance(SeMillLevyCertificationDatasource.CERT_DATE2, "The date of certification", Date.class);
        
        
        return fieldsAre;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
        return new SeMillLevyCertificationDatasource(createSeMillLevyCertificationCollection());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
        
    }
    
    /**
     * 
     * @param vargs 
     */
    public static final void main(String[] vargs) {
     SeMillLevyCertificationCollection collection = createSeMillLevyCertificationCollection();
     
     for (SeMillLevyCertificationCalculation calc : collection.getCalculations()) {
      System.out.printf("title : %s  value1 : %s value2 : %s value3 : %s \r\n", calc.getTitle(), calc.getColumn1FormattedValue(), calc.getColumn2FormattedValue(), calc.getColumn3FormattedValue());   
     }
    }
    
    /**
     * 
     * @return 
     */
    public static final SeMillLevyCertificationCollection createSeMillLevyCertificationCollection() {
     final String REGULAR_TYPE = "%12d";
     final String FLOATING_TYPE = "%12.6f";
     final String MILLS_TYPE = "%12.6f mills";
     final String MONEY_TYPE = "$ %,12.2f";
     final String MILEAGE_TYPE = "%12.1f miles";
     final String COUNT_TYPE = "%12.1f";
     
     SeMillLevyCertificationCollection collection = new SeMillLevyCertificationCollection();
     collection.setDistrictNumber("310");
     collection.setDistrictName("St Vrain");
     collection.setCounty("Boulder");
     collection.setTaxYear("2011");
     collection.setApproverName("James Brown");
     collection.setApproverPhone("(303) 777-9311");
     collection.setColumn1CertificationDate(new Date());
     collection.setColumn3CertificationDate(new Date());
     
     //(String title, Number column1Value, Number column2Value, Number column3Value, String formatString)
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("1. Total Program",24.995,null,24.995, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("2. Categorical Buyout",0.0,null,0.0, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("3. Overrides: ",null,null,null, null));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("a. Voter Approved",7.050,7.320,7.320, MILLS_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("b. Hold Harmless",1.21,null,1.21, MILLS_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("c. Excess Hold Harmless",0.0,0.950,0.953, MILLS_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("4. Abatement",0.120,0.150,0.150, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("5. Total General Fund",32.171,32.474,32.474, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("6. Bond Redemption Fund",0.0,15.140,15.140, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("7. Transportation Fund",2.11,null,2.11, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("8. Special Building and Technology Fund",3.2,null,3.2, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("9. Full Day Kindergarten Fund",1.4,null,1.4, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("10. Other (Loan, Charter School)",1.3,null,1.3, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("11. Total",49.106,50.046,null, MILLS_TYPE));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Assessed Valuation",null,null,null, null,true,false));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Gross Assessed Valuation",2359807724.0,null,2359807724.0, MONEY_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Tax Increamenting Financing",-21284308.0,null,-21284308.0, MONEY_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Net Assessed Valuation",2338523416.0,null,2338523416.0, MONEY_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Abatements (Total across all counties)",2359807724.0,null,2359807724.0, MONEY_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Information for certification to county treasurer:",null,null,null, null,true,false));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Full Funding mill levy",79.869,null,79.869, MILLS_TYPE,false,true));
     collection.getCalculations().add(new SeMillLevyCertificationCalculation("Funding rceived from state",103133649.89,null,103133649.89, MONEY_TYPE,false,true));
  
     
     
     return collection;
    }
}
