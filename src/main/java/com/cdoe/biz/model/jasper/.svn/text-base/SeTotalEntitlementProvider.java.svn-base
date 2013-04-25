package com.cdoe.biz.model.jasper;

import com.cdoe.util.JrDatasourceBasicField;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRDataSourceProvider;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Tony Ford
 */
public class SeTotalEntitlementProvider implements  JRDataSourceProvider {

    @Override
    public boolean supportsGetFieldsOperation() {
        return true;
    }

    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
        JRField[] fieldsAre = new JRField[5];
                
        fieldsAre[0] = JrDatasourceBasicField.newInstance(SeTotalEntitlementDatasource.FISCAL_YEAR, "The audit id of the imported audit.", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(SeTotalEntitlementDatasource.DISTRICT_NUMBER, "the organization number of the organization that is under audit.", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(SeTotalEntitlementDatasource.DISTIRCT_NAME, "The name of the organzation under audit.", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(SeTotalEntitlementDatasource.CURRENT_STATE_EQUAL, "The date the audit was available for import.", Double.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(SeTotalEntitlementDatasource.PREVIOUS_STATE_EQUAL, "The date the audit was imported", Double.class);        
        
                        
        return fieldsAre;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
        return new SeTotalEntitlementDatasource(createSeTotalEntitlementCollection());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
       
    }
    
    public static List<SeTotalEntitlement> createSeTotalEntitlementCollection() {
     List<SeTotalEntitlement> result = new ArrayList<SeTotalEntitlement>();
     
     result.add(new SeTotalEntitlement("2012-2013", "0010", "Mappleton 1", 36090451.36, 35196741.86));
     result.add(new SeTotalEntitlement("2012-2013", "0020", "ADAMS 12 FIVE STAR SCHOOLS", 217985307.04, 207186734.00));
     result.add(new SeTotalEntitlement("2012-2013", "0030", "ADAMS COUNTY 14", 30018254.76, 31688072.58));
     result.add(new SeTotalEntitlement("2012-2013", "0040", "BRIGHTON 27J", 70176224.86, 70070652.80));
     result.add(new SeTotalEntitlement("2012-2013", "0050", "BENNETT 29J", 4994020.81, 4967470.89));
     result.add(new SeTotalEntitlement("2012-2013", "0060", "STRASBURG 31J", 3886430.25, 41136557.61));
     result.add(new SeTotalEntitlement("2012-2013", "0070", "WESTMINSTER 50", 49389087.23, 51194280.28));
     result.add(new SeTotalEntitlement("2012-2013", "0080", "ALAMOSA  RE-11J", 9488797.67, 9663127.87));
     result.add(new SeTotalEntitlement("2012-2013", "0090", "SANGRE DE CRISTO", 8029172.88, 7885676.97));
     result.add(new SeTotalEntitlement("2012-2013", "0100", "ENGLEWOOD 1", 9752186.98, 10016111.27));
     result.add(new SeTotalEntitlement("2012-2013", "0110", "SHERIDAN 2", 8029172.88, 7885676.97));     
     result.add(new SeTotalEntitlement("2012-2013", "0120", "CHERRY CREEK 5", 36090451.36, 35196741.86));
     result.add(new SeTotalEntitlement("2012-2013", "0130", "LITTLETON 6", 217985307.04, 207186734.00));
     result.add(new SeTotalEntitlement("2012-2013", "0140", "DEER TRAIL 26J", 30018254.76, 31688072.58));
     result.add(new SeTotalEntitlement("2012-2013", "0150", "ADAMS-ARAPAHOE 28J", 70176224.86, 70070652.80));
     result.add(new SeTotalEntitlement("2012-2013", "0160", "BYERS 32J", 4994020.81, 4967470.89));
     result.add(new SeTotalEntitlement("2012-2013", "0170", "ARCHULETA COUNTY", 3886430.25, 41136557.61));
     result.add(new SeTotalEntitlement("2012-2013", "0180", "WALSH RE-1", 49389087.23, 51194280.28));
     result.add(new SeTotalEntitlement("2012-2013", "0190", "PRITCHET  RE-3", 9488797.67, 9663127.87));
     result.add(new SeTotalEntitlement("2012-2013", "0200", "SPRINGFIELD", 8029172.88, 7885676.97));
     result.add(new SeTotalEntitlement("2012-2013", "0210", "VILAS", 9752186.98, 10016111.27));
     result.add(new SeTotalEntitlement("2012-2013", "0220", "CAMPO RE-6", 8029172.88, 7885676.97));
     
     
     return result;
    }
    
}
