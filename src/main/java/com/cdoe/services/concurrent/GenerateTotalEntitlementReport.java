package com.cdoe.services.concurrent;


import com.cdoe.services.IGenerateTotalEntitlementReport;
import com.cdoe.biz.model.jasper.SeTotalEntitlement;
import com.cdoe.services.impl.stateequal.TotalEntitlementReportManager;
import com.cdoe.services.stateequal.ITotalEntitlementReportManager;
import com.cdoe.util.UserInfo;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class GenerateTotalEntitlementReport implements IGenerateTotalEntitlementReport {
    private static final Logger LOGGER = Logger.getLogger(GenerateTotalEntitlementReport.class);
    
    private DefaultMonitor monitor = new DefaultMonitor();
    private ITotalEntitlementReportManager totalEntitlementReportManager;
    private UserInfo userInfo;    
    private String fiscalYear;

    public GenerateTotalEntitlementReport() {
      monitor.setStatus(TaskStatus.NOT_STARTED);    
     monitor.setStatusDetail("Generate Total Entitlement Report -- NOT STARTED");  
     monitor.setTaskIdentifer(this.getTaskIdentifer());      
    }
    
    
    @Override
    public TaskMonitor getMonitor() {
        return monitor;
    }

    @Override
    public TaskIdentifer getTaskIdentifer() {
        return TaskIdentifer.TotalEntitlementReport;
    }

    @Override
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @Override
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String getFiscalYear() {
        return fiscalYear;
    }

    @Override
    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
    
    

    @Override
    public TaskMonitor call() throws Exception {
        try {
            monitor.setStatus(TaskStatus.INPROGRESS);
            monitor.setStatusDetail("State Equal Total Entitlement Report Generation -- IN PROGRESS.");
            
           

            monitor.setProgress(.10);
            
            List<SeTotalEntitlement> collection = totalEntitlementReportManager.createTotalEntitlementCollection(fiscalYear, userInfo);
            
            monitor.setProgress(.50);                   

            
            JRDataSource datasource = totalEntitlementReportManager.createSeTotalEntitlementDatasource(collection);

            monitor.setProgress(.75);
            
            totalEntitlementReportManager.generateReport(datasource, totalEntitlementReportManager.createTotalEntitlementReportFilenameConstructor());
            
            
            monitor.setProgress(1);
              
            monitor.setStatus(TaskStatus.SUCCESS);
            monitor.setStatusDetail("State Equal Total Entitlement Report --COMPLETE");
        } catch (Throwable t) {
            monitor.setStatus(TaskStatus.FAILURE);
            monitor.setStatusDetail(t.toString());
            
            LOGGER.error("Exception occurred during State Equal Total Entitlement Report Generation.", t);
        }

        return this.monitor;
    }

    public void setTotalEntitlementReportManager(ITotalEntitlementReportManager totalEntitlementReportManager) {
        this.totalEntitlementReportManager = totalEntitlementReportManager;
    }
    
}
