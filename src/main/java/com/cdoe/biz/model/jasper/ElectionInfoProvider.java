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
public class ElectionInfoProvider implements  JRDataSourceProvider {

    @Override
    public boolean supportsGetFieldsOperation() {
        return true;
    }

    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
       JRField[] fieldsAre = new JRField[7];
                
        fieldsAre[0] = JrDatasourceBasicField.newInstance(ElectionInfoDatasource.FISCAL_YEAR, "The audit id of the imported audit.", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(ElectionInfoDatasource.DISTRICT_NUMBER, "the organization number of the organization that is under audit.", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(ElectionInfoDatasource.DISTIRCT_NAME, "The name of the organzation under audit.", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(ElectionInfoDatasource.VOTES_FOR, "The date the audit was available for import.", Integer.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(ElectionInfoDatasource.VOTES_AGAINST, "The date the audit was imported", Integer.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(ElectionInfoDatasource.DOLLAR_AMOUNT, "The audit id of the imported audit.", Double.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(ElectionInfoDatasource.BALLOT_LANGAUGE, "The audit id of the imported audit.", String.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(ElectionInfoDatasource.COUNTY, "The audit id of the imported audit.", String.class);
        
        
                        
        return fieldsAre;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
        return new ElectionInfoDatasource(createElectionInfoCollection());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
        
    }
    
    
    public static final List<ElectionInfo> createElectionInfoCollection() {
     List<ElectionInfo> electionData = new ArrayList<ElectionInfo>();
     
     electionData.add(new ElectionInfo("2012", "0010", "Mappleton", "Adams", 120, 340, 1000000.00, "build new school."));
     electionData.add(new ElectionInfo("2012", "0020", "Bennett 29J", "Adams", 438, 1066, 351640.00, "$651640 for 2013 then amount raised by 7.5 mil."));
     electionData.add(new ElectionInfo("2012", "0030", "Englewood 1", "Arapahoe", 2504, 2297, 1500000.00, "$750000 in FY2012 then $1.5M thereafter."));
     electionData.add(new ElectionInfo("2012", "0040", "Byers 32J", "Arapahoe", 338, 235, 330000.00, "Annually for 3 years."));
     electionData.add(new ElectionInfo("2012", "0050", "Sierra Grande R-30", "Costilla", 295, 201, 335000.00, "5.1 mil to continue after payment in full of GO bonds - should be able to collect for override in FY11-12."));
     electionData.add(new ElectionInfo("2012", "0060", "Douglas County Re-1", "Douglas", 30785, 37440, 20000000.00, ""));
     electionData.add(new ElectionInfo("2012", "0070", "Eagle Re-50J", "Eagle", 4189, 5033, 6000000.00, ""));
     electionData.add(new ElectionInfo("2012", "0040", "Kiowa C-2", "Elbert", 327, 459, 150000.00, ""));
     electionData.add(new ElectionInfo("2012", "0050", "Cheyene Mountain 12", "Elpaso", 4225, 3627, 1700000.00, "Maximum mil levy for all purpose shall not exceed 50 mils."));
     electionData.add(new ElectionInfo("2012", "0060", "Roaring Ford Re-1", "Garfield", 1673, 2832, 3000000.00, ""));
     electionData.add(new ElectionInfo("2012", "0070", "Garfield 16", "Gsrfield", 498, 715, 1204026.00, ""));
     electionData.add(new ElectionInfo("2012", "0040", "Straiton R-4", "Kit Carson", 177, 186, 76120.00, ""));
     electionData.add(new ElectionInfo("2012", "0050", "Burlington Re-6J", "Kit Carson", 655, 720, 600000.00, "$600,000 for five years then decrease to $300,000 thereafter."));
     electionData.add(new ElectionInfo("2012", "0060", "Thompson R-2J", "Larimer", 10938, 16900, 12800000.00, ""));
     electionData.add(new ElectionInfo("2012", "0070", "Park R-3", "Larimer", 1491, 1832, 750000.00, ""));
     electionData.add(new ElectionInfo("2012", "0050", "DeBeque 49J", "Mesa", 117, 130, 350000.00, "annually for 6 years."));    
     electionData.add(new ElectionInfo("2012", "0060", "Mesa County Valley 51", "Mesa", 14415, 22951, 12500000.00, "annually for 6 years."));
     electionData.add(new ElectionInfo("2012", "0070", "Mancos RE-6", "Adams", 342, 518, 276000.00, ""));
     electionData.add(new ElectionInfo("2012", "0040", "Pueblo 70", "Pueblo", 5130, 9430, 3400000.00, "Not to exceed 5.95 mils, sunset Dec 2016."));
     electionData.add(new ElectionInfo("2012", "0050", "Woodland Park Re-2", "Teller", null, null, 950000.00, "$950,000 for 2013 then amount raised by 3.8 mil."));
     electionData.add(new ElectionInfo("2012", "0060", "Weld Re-1", "Weld", 655, 1158, 1837327.00, "For FY12-13 then set mill to combine with previous override to collect amount not greater than 25t% of total program."));
     
     
     return electionData;
    }
    
}
