package com.cdoe.services.stateequal;

import com.cdoe.biz.model.jasper.SeFinallMillLevySummary;
import com.cdoe.biz.model.jasper.SeFinallMillLevySummaryDatasource;
import com.cdoe.services.impl.stateequal.MillLevySummaryReportManager.MillLevySummaryReportFilenameConstructor;
import com.cdoe.util.FilenameConstructor;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Tony Ford
 */
public interface IMillLevySummaryReportManager {

    /**
     *
     * @param fiscalYear
     * @param districtMap
     * @return
     */
    List<SeFinallMillLevySummary> createCollection(String fiscalYear, Map<String, String> districtMap, Map<String, String> countyMap);

    /**
     *
     * @param summaryData
     * @return
     */
    SeFinallMillLevySummaryDatasource createMillLevySummaryDatasource(List<SeFinallMillLevySummary> summaryData);

    /**
     *
     * @return
     */
    MillLevySummaryReportFilenameConstructor createMillLevySummaryReportFilenameConstructor();
    
    
    /**
     * 
     * @param datasource
     * @param constructor
     * @throws Exception 
     */
    public void generateReport(JRDataSource datasource, FilenameConstructor constructor) throws Exception;
    
}
