package com.cdoe.services.stateequal;

import com.cdoe.biz.model.jasper.ImportPriorYearAuditCollection;
import com.cdoe.biz.model.jasper.ImportPriorYearAuditDatasource;
import com.cdoe.util.FilenameConstructor;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Tony Ford
 */
public interface IAuditSummaryReportManager {

    /**
     *
     * @param auditIds
     * @param districtMap
     * @return
     */
    ImportPriorYearAuditCollection createImportPriorYearAuditCollection(List<Integer> auditIds, Map<String, String> districtMap);

    /**
     *
     * @param collection
     * @return
     */
    ImportPriorYearAuditDatasource createImportPriorYearAuditDatasource(ImportPriorYearAuditCollection collection);

    /**
     *
     * @param district
     * @param month
     * @param fiscalYear
     * @return
     */
    FilenameConstructor createPaymentReportFilenameConstructor();
    
    /**
     * 
     * @param datasource
     * @param constructor
     * @throws Exception 
     */
    public void generateReport(JRDataSource datasource, FilenameConstructor constructor) throws Exception;
    
}
