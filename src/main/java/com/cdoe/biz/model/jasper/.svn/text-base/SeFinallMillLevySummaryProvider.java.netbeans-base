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
public class SeFinallMillLevySummaryProvider implements  JRDataSourceProvider {

    @Override
    public boolean supportsGetFieldsOperation() {
        return true;
    }

    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
       JRField[] fieldsAre = new JRField[18];
                
        fieldsAre[0] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.FISCAL_YEAR, "The audit id of the imported audit.", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.DISTRICT_NUMBER, "the organization number of the organization that is under audit.", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.DISTIRCT_NAME, "The name of the organzation under audit.", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.ABATEMENT_MILL, "an abatement mill levy", Double.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.BOND_REDEMPTION_MILL, "mill levy", Double.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.CATEGORY_BUYOUT_MILL, "mill levy.", Double.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.EXCESS_HOLDHARMLESS_MILL, "mill levy.", Double.class);
        fieldsAre[7] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.FULLDAY_KINDERGARTEN_MILL, "mill levy.", Double.class);
        fieldsAre[8] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.HOLD_HARMLESS_MILL, "mill levy.", Double.class);
        fieldsAre[9] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.NET_ASSESSED_VALUATION, "mill levy.", String.class);
        fieldsAre[10] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.OTHER_MILL, "mill levy.", String.class);
        fieldsAre[11] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.SPECIAL_BUILDING_MILL, "mill levy.", String.class);
        fieldsAre[12] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.TOTAL_MILL, "mill levy.", Double.class);
        fieldsAre[13] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.TOTAL_PROGRAM_MILL, "mill levy", Double.class);
        fieldsAre[14] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.TRANSPORTATION_MILL, "mill levy.", Double.class);
        fieldsAre[15] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.VOTER_APPROVED_MILL, "mill levy.", Double.class);
        fieldsAre[16] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.IS_TOTAL_REC, "identifies total line", Boolean.class);
        fieldsAre[17] = JrDatasourceBasicField.newInstance(SeFinallMillLevySummaryDatasource.COUNTY, "county", String.class);
       
        
                        
        return fieldsAre;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
       return new SeFinallMillLevySummaryDatasource(createSeFinallMillLevySummaryCollection());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
        
    }
    
    /**
     * 
     * @return 
     */
    public static List<SeFinallMillLevySummary> createSeFinallMillLevySummaryCollection() {
      List<SeFinallMillLevySummary> result = new ArrayList<SeFinallMillLevySummary>();
            
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "MAPPLETON 1", "0010", 453631720.00, 26.080, 0.0, 0.472, 0.0, 10.295, 0.014, 6.879, 0.0, 0.0, 0.0, 0.0, 43.740));
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "MAPPLETON 1", "0010", 453631720.00, 26.080, 0.0, 0.472, 0.0, 10.295, 0.014, 6.879, 0.0, 0.0, 0.0, 0.0, 43.740,true));
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "ADAMS 12 FIVE STAR", "0020", 1444051750.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "BROOMFIELD", "ADAMS 12 FIVE STAR", "0020", 266520467.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "NORTHGLEN-THORTON 12 TOTAL", "0020", 1730572217.00, 27.0, 0.0, 0.0, 0.0, 20.456, 0.055, 22.765, 0.0, 0.0, 0.0, 0.0, 70.276,true));
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "ADAMS 14", "0030", 556858540.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "ADAMS 14", "0030", 556858540.00, 24.688, 0.0, 0.0, 0.0, 8.781, 0.033, 11.475, 0.0, 0.0, 0.0, 0.0, 44.977,true));
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "BRIGHTON 27J", "0040", 753613410.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "BROOMFIELD", "BRIGHTON 27J", "0040", 10655.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "WELD", "BRIGHTON 27J", "0040", 23833910.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "BRIGHTON 27J", "0040", 777457975.00, 26.262, 0.0, 0.0, 0.0, 0.965, 0.077, 18.325, 0.0, 0.0, 0.0, 0.0, 45.629,true));
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "BENNETT 29J", "0050", 48416130.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "BENNETT 29J", "0050", 35471920.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "BENNETT 29J", "0050", 83888050.00, 22.285, 0.0, 0.0, 0.0, 0.0, 0.115, 10.971, 0.0, 0.0, 0.0, 0.0, 33.371,true));
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "STRASBURG 31J", "0060", 62010550.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "ARAPAHOE", "STRASBURG 31J", "0060", 15129840.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "STRASBURG 31J", "0060", 77140390.00, 27.00, 0.0, 0.0, 0.0, 3.889, 0.038, 11.567, 0.0, 0.0, 0.0, 0.0, 42.494,true));
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "WESTMINSTER 50", "0070", 512605120.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "WESTMINSTER 50", "0070", 512605120.00, 27.0, 0.0, 1.012, 0.0, 15.304, 0.029, 18.128, 0.0, 0.0, 0.0, 0.0, 61.473,true));
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ALAMOSA", "ALAMOSA RE-11J", "0080", 119496251.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "CONJOS", "ALAMOSA RE-11J", "0080", 1734465.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "ALAMOSA RE-11J", "0080", 121230716.00, 27.0, 0.0, 0.0, 0.0, 0.0, 0.089, 14.756, 0.0, 0.0, 0.0, 0.0, 41.845,true));
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ALAMOSA", "SANGRE DE CRISTO RE-22J", "0090", 20327349.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "SAGUACHE", "SANGRE DE CRISTO RE-22J", "0090", 3417705.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "SANGRE DE CRISTO RE-22J", "0090", 23745054.00, 27.0, 0.0, 0.0, 0.0, 0.0, 0.012, 14.097, 0.0, 0.0, 0.0, 0.0, 41.109,true));
      
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ARAPAHOE", "ENGLEWOOD 1", "0100", 404882670.0, 21.895, 0.0, 0.0, 0.0, 9.647, 0.485, 13.831, 0.0, 0.0, 0.0, 0.0, 45.858));
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "ENGLEWOOD 1", "0100", 404882670.0, 21.895, 0.0, 0.0, 0.0, 9.647, 0.485, 13.831, 0.0, 0.0, 0.0, 0.0, 45.858,true));
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ARAPAHOE", "SHERIDAN 2", "0110", 148489250.0, null, null, null, null, null, null, null, null, null, null, null, null));      
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "SHERIDAN 2", "0110", 148489250.0, 20.947, 0.0, 0.0, 0.0, 6.734, 0.732, 10.351, 0.0, 0.0, 0.0, 0.0, 38.764,true));      
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ARAPAHOE", "CHERRY CREEK 5", "0120", 4291424053.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "CHERRY CREEK 5", "0120", 4291424053.00, 25.712, 0.0, 1.504, 0.090, 112.295, 2.066, 12.7, 0.0, 0.0, 0.0, 0.0, 54.367,true));
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ARAPAHOE", "LITTLETON 6", "0130", 1259563640.0, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "LITTLETON 6", "0130", 1259563640.0, 25.353, 0.0, 1.838, 0.0, 21.038, 1.057, 8.244, 0.0, 0.0, 0.0, 0.0, 57.530,true));
      
      
      result.add(new SeFinallMillLevySummary("2012-2013", "ARAPAHOE", "DEER TRAIL 26J", "0140", 18923010.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "ADAMS", "DEER TRAIL 26J", "0140", 3691330.00, null, null, null, null, null, null, null, null, null, null, null, null));
      result.add(new SeFinallMillLevySummary("2012-2013", "N/A", "DEER TRAIL 26J", "0140", 22614340.00, 27.0, 4.56, 0.288, 3.12, 2.976, 0.183, 5.21, 6.63, 7.16, 8.47, 9.316, 48.293,true));
      
            
      return result;
    }
}
