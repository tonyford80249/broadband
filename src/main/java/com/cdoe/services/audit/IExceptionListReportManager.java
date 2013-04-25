package com.cdoe.services.audit;

import com.cdoe.biz.model.jasper.AuditException;
import com.cdoe.services.impl.audit.ExceptionListReportManager.ExceptionListReportFilenameConstructor;
import com.cdoe.util.FilenameConstructor;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Tony Ford
 */
public interface IExceptionListReportManager {

    /**
     *
     * @param districtNumber
     * @param districtMap
     * @return
     */
    List<AuditException> createAtRiskExceptionList(String districtNumber, String districtName);

    /**
     *
     * @param collection
     * @return
     */
    JRDataSource createDatasource(List<AuditException> collection);

    /**
     *
     * @return
     */
    public ExceptionListReportFilenameConstructor  createFilenameConstructor(String districtNumber, boolean atRisk);

    /**
     *
     * @param districtNumber
     * @param districtMap
     * @return
     */
    List<AuditException> createPupilCountExceptionList(String districtNumber, String districtName);
    
    
    /**
     * 
     * @param datasource
     * @param constructor
     * @throws Exception 
     */
    void generateReport(JRDataSource datasource, FilenameConstructor constructor) throws Exception;
    
}
