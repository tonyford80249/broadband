package com.cdoe.services.stateequal;

import com.cdoe.biz.model.jasper.ElectionInfo;
import com.cdoe.biz.model.jasper.ElectionInfoDatasource;
import com.cdoe.services.impl.stateequal.ElectionReportManager.ElectionReportFilenameConstructor;
import com.cdoe.util.FilenameConstructor;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Tony Ford
 */
public interface IElectionReportManager {

    /**
     *
     * @param fiscalYear
     * @param districtMap
     * @param countyMap
     * @return
     */
    List<ElectionInfo> createCollection(String fiscalYear, Map<String, String> districtMap, Map<String, String> countyMap);

    /**
     *
     * @param collection
     * @return
     */
    ElectionInfoDatasource createElectionInfoDatasource(List<ElectionInfo> collection);

    /**
     *
     * @return
     */
    ElectionReportFilenameConstructor createFilenameConstructor();
    
    /**
     * 
     * @param datasource
     * @param constructor
     * @throws Exception 
     */
    public void generateReport(JRDataSource datasource, FilenameConstructor constructor) throws Exception;
    
}
