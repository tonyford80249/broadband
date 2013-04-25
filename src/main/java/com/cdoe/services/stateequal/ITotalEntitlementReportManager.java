package com.cdoe.services.stateequal;

import com.cdoe.biz.model.jasper.SeTotalEntitlement;
import com.cdoe.biz.model.jasper.SeTotalEntitlementDatasource;
import com.cdoe.services.impl.stateequal.TotalEntitlementReportManager.TotalEntitlementReportFilenameConstructor;
import com.cdoe.util.FilenameConstructor;
import com.cdoe.util.UserInfo;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Tony Ford
 */
public interface ITotalEntitlementReportManager {

    /**
     *
     * @param totalEntitlementCollection
     * @return
     */
    SeTotalEntitlementDatasource createSeTotalEntitlementDatasource(List<SeTotalEntitlement> totalEntitlementCollection);

    /**
     *
     * @param fiscalYear
     * @param userInfo
     * @return
     */
    List<SeTotalEntitlement> createTotalEntitlementCollection(String fiscalYear, UserInfo userInfo);

    /**
     *
     * @return
     */
    TotalEntitlementReportFilenameConstructor createTotalEntitlementReportFilenameConstructor();
    
    /**
     * 
     * @param datasource
     * @param constructor
     * @throws Exception 
     */
    public void generateReport(JRDataSource datasource, FilenameConstructor constructor) throws Exception;
    
}
