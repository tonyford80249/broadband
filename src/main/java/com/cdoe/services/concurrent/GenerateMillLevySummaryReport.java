package com.cdoe.services.concurrent;


import com.cdoe.services.IGenerateMillLevySummaryReport;
import com.cdoe.biz.model.jasper.SeFinallMillLevySummary;
import com.cdoe.services.stateequal.IMillLevySummaryReportManager;
import com.cdoe.util.UserInfo;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class GenerateMillLevySummaryReport implements IGenerateMillLevySummaryReport {
    private static final Logger LOGGER = Logger.getLogger(GenerateMillLevySummaryReport.class);
    private DefaultMonitor monitor = new DefaultMonitor();
    private IMillLevySummaryReportManager millLevySummaryReportManager;
    private String fiscalYear;
    private UserInfo userInfo;   

    /**
     * 
     */
    public GenerateMillLevySummaryReport() {
     monitor.setStatus(TaskStatus.NOT_STARTED);    
     monitor.setStatusDetail("Generate MillLevy Summary Report -- NOT STARTED");  
     monitor.setTaskIdentifer(this.getTaskIdentifer());      
    }

    @Override
    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    @Override
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setMillLevySummaryReportManager(IMillLevySummaryReportManager millLevySummaryReportManager) {
        this.millLevySummaryReportManager = millLevySummaryReportManager;
    }
    
    
    
    @Override
    public TaskMonitor getMonitor() {
        return this.monitor;
    }

    @Override
    public TaskIdentifer getTaskIdentifer() {
        return TaskIdentifer.MillLevySummaryReport;
    }

    @Override
    public TaskMonitor call() throws Exception {
       try {
            monitor.setStatus(TaskStatus.INPROGRESS);
            monitor.setStatusDetail("State Equal MillLevy Summary Report Generation -- IN PROGRESS.");
            
           

            monitor.setProgress(.1);
            
            List<SeFinallMillLevySummary> dataCollection = millLevySummaryReportManager.createCollection(fiscalYear, userInfo.getDistrictMap(), userInfo.getDistrictPrimaryCountyMap());

            monitor.setProgress(.5);
            
            JRDataSource datasource = millLevySummaryReportManager.createMillLevySummaryDatasource(dataCollection);
            
            monitor.setProgress(.75);
                        
            millLevySummaryReportManager.generateReport(datasource, millLevySummaryReportManager.createMillLevySummaryReportFilenameConstructor());
                        
            monitor.setProgress(1);
                        
              
            monitor.setStatus(TaskStatus.SUCCESS);
            monitor.setStatusDetail("State Equal  MillLevy Summary Report --COMPLETE");
        } catch (Throwable t) {
            monitor.setStatus(TaskStatus.FAILURE);
            monitor.setStatusDetail(t.toString());
            
            LOGGER.error("Exception occurred during State Equal  MillLevy Summary Report Generation.", t);
        }

        return this.monitor;
    }
    
}
