
package com.cdoe.services.concurrent;

import com.cdoe.services.IGenerateElectionReport;
import com.cdoe.biz.model.jasper.ElectionInfo;
import com.cdoe.services.stateequal.IElectionReportManager;
import com.cdoe.util.UserInfo;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class GenerateElectionReport implements IGenerateElectionReport {
    private static final Logger LOGGER = Logger.getLogger(GenerateElectionReport.class);
    
    private DefaultMonitor monitor = new DefaultMonitor();
    private IElectionReportManager electionReportManager;
    private String fiscalYear;
    private UserInfo userInfo;   

    /**
     * 
     */
    public GenerateElectionReport() {
     monitor.setStatus(TaskStatus.NOT_STARTED);    
     monitor.setStatusDetail("Generate Election Report -- NOT STARTED");  
     monitor.setTaskIdentifer(this.getTaskIdentifer());      
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
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @Override
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    
    @Override
    public TaskMonitor getMonitor() {
        return this.monitor;
    }

    @Override
    public TaskIdentifer getTaskIdentifer() {
        return TaskIdentifer.ElectionReport;
    }

    @Override
    public TaskMonitor call() throws Exception {
         try {
            monitor.setStatus(TaskStatus.INPROGRESS);
            monitor.setStatusDetail("State Equal Election Report Generation -- IN PROGRESS.");
            
           

            monitor.setProgress(.1);
            
            List<ElectionInfo> dataCollection = electionReportManager.createCollection(fiscalYear, userInfo.getDistrictMap(), userInfo.getDistrictPrimaryCountyMap());

            monitor.setProgress(.5);
            
            JRDataSource datasource = electionReportManager.createElectionInfoDatasource(dataCollection);
            
            monitor.setProgress(.75);
                        
            electionReportManager.generateReport(datasource, electionReportManager.createFilenameConstructor());
                        
            monitor.setProgress(1);
                        
              
            monitor.setStatus(TaskStatus.SUCCESS);
            monitor.setStatusDetail("State Equal  Election Report --COMPLETE");
        } catch (Throwable t) {
            monitor.setStatus(TaskStatus.FAILURE);
            monitor.setStatusDetail(t.toString());
            
            LOGGER.error("Exception occurred during State Equal Election Report Generation.", t);
        }

        return this.monitor;
    }

    public void setElectionReportManager(IElectionReportManager electionReportManager) {
        this.electionReportManager = electionReportManager;
    }
    
}
