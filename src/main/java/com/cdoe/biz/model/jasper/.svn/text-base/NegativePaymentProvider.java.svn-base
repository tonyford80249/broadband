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
public class NegativePaymentProvider implements  JRDataSourceProvider {

    @Override
    public boolean supportsGetFieldsOperation() {
      return true;
    }

    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
        JRField[] fieldsAre = new JRField[7];
                
        fieldsAre[0] = JrDatasourceBasicField.newInstance(NegativePaymentDatasource.FISCAL_YEAR, "The audit id of the imported audit.", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(NegativePaymentDatasource.DISTRICT_NUMBER, "the organization number of the organization that is under audit.", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(NegativePaymentDatasource.DISTIRCT_NAME, "The name of the organzation under audit.", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(NegativePaymentDatasource.CURRENT_ENTITLEMENT, "The date the audit was available for import.", Double.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(NegativePaymentDatasource.MONTH_ENTITLEMENT, "The date the audit was imported", Double.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(NegativePaymentDatasource.PREVIOUS_ENTITLEMENT, "The audit id of the imported audit.", Double.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(NegativePaymentDatasource.COUNTY, "The audit id of the imported audit.", String.class);
        
        
                        
        return fieldsAre;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
        return new NegativePaymentDatasource(createNegativePayments());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
        
    }
    
    public static List<NegativePayment> createNegativePayments() {
      List<NegativePayment> result  = new ArrayList<NegativePayment>();
      
      result.add(new NegativePayment("ARAPAHOE", "2012-2013", "0540", "CLEAR CREEK", 0.0, 0.0, 0.0));
      result.add(new NegativePayment("EAGLE", "2012-2013", "0910", "EAGLE COUNTY", -26036.06, 4764802.89, 2790839.95));
      result.add(new NegativePayment("GRAND", "2012-2013", "1340", "WEST GRAND", 0.0, 0.0, 0.0));
      result.add(new NegativePayment("GUNNISON", "2012-2013", "1360", "GUNNISON WATERSHED", -122131.31, 851333.55, 973464.85));
      result.add(new NegativePayment("HINDSDALE", "2012-2013", "1380", "HINDSDAL COUNTY", -39187.60, 31020.25, 70207.85));
      result.add(new NegativePayment("PARK", "2012-2013", "1570", "PARK ESTES PARK", 0.0, 0.0, 0.0));
      result.add(new NegativePayment("DE BEQUE", "2012-2013", "1980", "", 0.0, 0.0, 0.0));
      result.add(new NegativePayment("PLATEAU", "2012-2013", "1990", "PLATEAU VALLEY", -139937.83, 195308.78, 326246.60));
      result.add(new NegativePayment("CREEDE", "2012-2013", "2010", "CREEDE SCHOOL DISTRICT", -1564.21, 196510.20, 198074.40));
      result.add(new NegativePayment("CORTEZ", "2012-2013", "2035", "MONTEZUMA-CORTEZ", -29373.56, 3773593.20, 3802966.75));      
      result.add(new NegativePayment("PARK", "2012-2013", "2610", "PARTK COUNTY", 0.0, 0.0, 0.0));
      result.add(new NegativePayment("ASPEN", "2012-2013", "2640", "ASPEN", -358306.32, 1014271.24, 1372577.55));
      result.add(new NegativePayment("MEEKER", "2012-2013", "2710", "MEEKER", 0.0, 0.0, 0.0));
      result.add(new NegativePayment("SLOPE", "2012-2013", "2830", "TELLURIDE", -64511.45, 674624.45, 739135.90));
      result.add(new NegativePayment("JULES", "2012-2013", "2862", "JULESBURG", -849883.88, 2295620.77, 3145504.65));
      result.add(new NegativePayment("PAWNEE", "2012-2013", "3148", "PAWNEE", 0.0, 0.0, 0.0));
      
      result.add(new NegativePayment(null, "2012-2013", "XXX1", "CHARTER SCHOOL INSTITUTE", 6680514.36, null, null));
      result.add(new NegativePayment("ADAMS", "2012-2013", "XXX2", "MAPLETON 1", 2560682.88, null, null));
      result.add(new NegativePayment("ADAMS", "2012-2013", "XXX3", "ADAMS 12 FIVE START SCHOOLS", 12766155.75, null, null));
      result.add(new NegativePayment("ADAMS", "2012-2013", "XXX4", "ADAMS COUNTY", 3336430.14, null, null));
      result.add(new NegativePayment("ADAMS", "2012-2013", "XXX5", "BRIGHTON 27J", 5793664.59, null, null));
      result.add(new NegativePayment("ADAMS", "2012-2013", "XXX6", "BENNETT 29J", 402893.44, null, null));
      result.add(new NegativePayment("ADAMS", "2012-2013", "XXX7", "STRASBURG 31J", 448932.85, null, null));
      result.add(new NegativePayment("ADAMS", "2012-2013", "XXX8", "WESTMINSTER 50", 5016315.73, null, null));
      
      result.add(new NegativePayment("ALAMOSA", "2012-2013", "XXX9", "ALAMOSA RE-11J", 877898.23, null, null));
      result.add(new NegativePayment("ALAMOSA", "2012-2013", "XX10", "SANGRE DE CRISTO RE-22J", 145982.78, null, null));
      
      result.add(new NegativePayment("ARAPAHOE", "2012-2013", "XX11", "ENGLEWOOD 1", 944644.38, null, null));
      result.add(new NegativePayment("ARAPAHOE", "2012-2013", "XX12", "SHERIDAN 2", 597349.78, null, null));
      result.add(new NegativePayment("ARAPAHOE", "2012-2013", "XX13", "CHERRY CREEK 5", 20577953.30, null, null));
      result.add(new NegativePayment("ARAPAHOE", "2012-2013", "XX14", "LITTLETON 6", 4970463.27, null, null));
      result.add(new NegativePayment("ARAPAHOE", "2012-2013", "XX15", "DEER TRAIL 26J", 45963.95, null, null));
      result.add(new NegativePayment("ARAPAHOE", "2012-2013", "XX16", "ADAMS-ARAPAHOE 28J", 13976418.47, null, null));
      result.add(new NegativePayment("ARAPAHOE", "2012-2013", "XX17", "BYERS 32J", 252308.29, null, null));
      
      result.add(new NegativePayment("ARCHULETA", "2012-2013", "XX18", "ARCHULETA CONTY 50 JT", 971121.63, null, null));
      
      result.add(new NegativePayment("BACA", "2012-2013", "XX19", "WALSH RE-1", 52307.79, null, null));
      result.add(new NegativePayment("BACA", "2012-2013", "XX20", "PRITCHETT RE-3", 70870.02, null, null));
      result.add(new NegativePayment("BACA", "2012-2013", "XX21", "SPRINGFIELD RE-4", 132258.25, null, null));
      result.add(new NegativePayment("BACA", "2012-2013", "XX22", "VILAS RE-5", 3241.12, null, null));
      result.add(new NegativePayment("BACA", "2012-2013", "XX23", "CAMPO RE-6", 52255.74, null, null));
      
      result.add(new NegativePayment("BENT", "2012-2013", "XX24", "LAS ANIMAS RE-1", 209629.45, null, null));
      result.add(new NegativePayment("BENT", "2012-2013", "XX25", "MC CLAVE RE-2", 160638.37, null, null));
      
      result.add(new NegativePayment("BOULDER", "2012-2013", "XX26", "ST VRAIN VALLEY RE 1J", 8719113.73, null, null));
      result.add(new NegativePayment("BOULDER", "2012-2013", "XX27", "BOULDER VALLEY RE 2", 4888478.93, null, null));
      
                                                                  
      return result;
    }
    
}
