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
public class ImportPriorYearAuditProvider implements  JRDataSourceProvider {

    @Override
    public boolean supportsGetFieldsOperation() {
        return true;
    }

    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
         JRField[] fieldsAre = new JRField[9];
                
        fieldsAre[0] = JrDatasourceBasicField.newInstance(ImportPriorYearAuditDatasource.FISCAL_YEAR, "The audit id of the imported audit.", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(ImportPriorYearAuditDatasource.DISTRICT_NUMBER, "the organization number of the organization that is under audit.", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(ImportPriorYearAuditDatasource.DISTIRCT_NAME, "The name of the organzation under audit.", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(ImportPriorYearAuditDatasource.AUDIT_CPP_COUNT, "The date the audit was available for import.", Double.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(ImportPriorYearAuditDatasource.AUDIT_FTE_COUNT, "The date the audit was imported", Double.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(ImportPriorYearAuditDatasource.AUDIT_ONLINE_COUNT, "The audit id of the imported audit.", Double.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(ImportPriorYearAuditDatasource.FUNDED_PUPIL_COUNT, "the organization number of the organization that is under audit.", Double.class);
        fieldsAre[7] = JrDatasourceBasicField.newInstance(ImportPriorYearAuditDatasource.PER_PUPIL_FUNDING, "The name of the organzation under audit.", Double.class);
        fieldsAre[8] = JrDatasourceBasicField.newInstance(ImportPriorYearAuditDatasource.TOTAL_PROGRAM_FUNDING, "The date the audit was available for import.", Double.class);
        
                        
        return fieldsAre;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
        return new ImportPriorYearAuditDatasource(createPriorYearAudits());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
      
    }
    
    public static ImportPriorYearAuditCollection createPriorYearAudits() {
      ImportPriorYearAuditCollection collection = new  ImportPriorYearAuditCollection();
      
      //String organizationCode, String organizationName, String fiscalYear, Double auditedFTECount, Double auditedCPPCount, Double newFundedPupilCount, Double revisedTotalProgramFunding, Double revisedPerPupilFunding
      collection.getAudits().add(new ImportPriorYearAudit("1110","FALCON 49", "20122013", 1300.0,1250.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("0910","EAGLE COUNTY RE 50", "20122013", 2300.0,3250.0,1780.0,2200000.00,1190000.00));
      collection.getAudits().add(new ImportPriorYearAudit("0060","STRASBURG 31J", "20122013", 3100.0,2250.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("3010","CRIPPLE CREEK-VICTOR RE-1", "20122013", 4300.0,1450.0,7480.0,4200000.00,1490000.00));
      collection.getAudits().add(new ImportPriorYearAudit("1520","DURANGO 9-R", "20122013", 1500.0,1550.0,5780.0,1500000.00,1590000.00));
      collection.getAudits().add(new ImportPriorYearAudit("2650","GRANADA RE-1", "20122013", 6300.0,1650.0,7660.0,1600000.00,1690000.00));
      collection.getAudits().add(new ImportPriorYearAudit("2010","CREEDE SCHOOL DISTRICT", "20122013", 7300.0,7250.0,7780.0,7200000.00,7090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("1620","AGUILAR REORGANIZED 6", "20122013", 8300.0,1850.0,7880.0,1800000.00,1080000.00));
      collection.getAudits().add(new ImportPriorYearAudit("1480","STRATTON R-4", "20122013", 1900.0,9250.0,980.0,1900000.00,9090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("3200","YUMA 1", "20122013", 1300.0,1250.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("1010","COLORADO SPRINGS 11", "20122013", 23300.0,34250.0,1280.0,3200000.00,2090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("1828","VALLEY RE-1", "20122013", 43300.0,2250.0,1380.0,1300000.00,2090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("1420","JEFFERSON COUNTY R-1", "20122013", 15300.0,2250.0,2180.0,3200000.00,4090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("1080","LEWIS-PALMER 38", "20122013", 4300.0,1350.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("1180","ROARING FORK RE-1", "20122013", 5300.0,1450.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("3090","KEENESBURG RE-3(J)", "20122013", 6300.0,1250.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("2750","SARGENT RE-33J", "20122013", 7300.0,1250.0,680.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("0470","ST VRAIN VALLEY RE 1J", "20122013", 8300.0,7250.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("0260","VILAS RE-5", "20122013", 1200.0,1850.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("0990","WIDEFIELD 3", "20122013", 1300.0,1950.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("1990","PLATEAU VALLEY 50", "20122013", 1400.0,1350.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("1380","HINSDALE COUNTY RE 1", "20122013", 1500.0,1250.0,780.0,1200000.00,1090000.00));
      collection.getAudits().add(new ImportPriorYearAudit("0900","DOUGLAS COUNTY RE 1", "20122013", 1800.0,1260.0,780.0,1200000.00,1090000.00));
      
      return collection;
    }
}
