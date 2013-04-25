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
public class SeMillLevyOverrideProvider implements  JRDataSourceProvider {
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
        
        fieldsAre[0] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.DISTRICT_NAME, "The District Name", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.DISTRICT_NUMBER, "The District Number", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.ALLOWABLE_OVERRIDE, "The County the school or institution is in", Double.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.COST_OF_LIVING, "description of the values being compared", Double.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.GRAND_TOTAL_PROG, "first value", Double.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.MIN_OVERRIDE_ALLOWED, "second value", Double.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.PROPERTY_TAX_REVENUE, "used to provide custom formatting for the report", Double.class);
        fieldsAre[7] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.QUARTER_OF_TOTAL_PROG, "first fiscal year", Double.class);
        fieldsAre[8] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.REMAINING_BALANCE, "first fiscal month", Double.class);
        fieldsAre[9] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.TAX_YEAR, "second fiscal year", String.class);
        fieldsAre[10] = JrDatasourceBasicField.newInstance(SeMillLevyOverrideDatasource.TOTAL_OVERRIDE_ALLOWED, "second fiscal month", Double.class);
        
        
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
        return new SeMillLevyOverrideDatasource(createSeMillLevyOverride());
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
    public static final SeMillLevyOverride createSeMillLevyOverride() {
      //String districtNumber, String districtName, String taxYear, Double grandTotalProg, Double costOfLiving, Double minOverrideAllowed, Double quarterOfTotalProg, Double totalOverrideAllowed, Double allowableOverride, Double propertyTaxRevenue, Double remainingBalance  
        
      SeMillLevyOverride override = new SeMillLevyOverride("0010","MAPLETON 1","2013",54867827.17,50000.00,200000.00,13716956.79, 13766956.79,13716956.79,54917849.94, 95000.00);
      
      return override;
    }
}
