package com.cdoe.services.concurrent;

import com.cdoe.services.IGenerateExceptionListReport;
import com.cdoe.biz.model.jasper.AuditException;
import com.cdoe.biz.model.jasper.ElectionInfo;
import com.cdoe.services.audit.IExceptionListReportManager;
import com.cdoe.services.stateequal.IElectionReportManager;
import com.cdoe.util.UserInfo;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class GenerateExceptionListReport implements IGenerateExceptionListReport {
    private static final Logger LOGGER = Logger.getLogger(GenerateExceptionListReport.class);
    
    private DefaultMonitor monitor = new DefaultMonitor();
    private IExceptionListReportManager exceptionListReportManager;    
    private UserInfo userInfo;   

    /**
     * 
     */
    public GenerateExceptionListReport() {
     monitor.setStatus(TaskStatus.NOT_STARTED);    
     monitor.setStatusDetail("Generate Exception Lists Report -- NOT STARTED");  
     monitor.setTaskIdentifer(this.getTaskIdentifer());        
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public TaskMonitor getMonitor() {
        return this.monitor;
    }

    /**
     * 
     * @return 
     */
    @Override
    public TaskIdentifer getTaskIdentifer() {
        return TaskIdentifer.ExceptionListReport;
    }

    /**
     * 
     * @return 
     */
    @Override
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * 
     * @param userInfo 
     */
    @Override
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * 
     * @return
     * @throws Exception 
     */
    @Override
    public TaskMonitor call() throws Exception {
       try {
            monitor.setStatus(TaskStatus.INPROGRESS);
            monitor.setStatusDetail("State Equal Exception Lists Report Generation -- IN PROGRESS.");
            
            int count = 0;
            int size =  userInfo.getAllDistrictCodes().size();
            
            for (String districtNumber : userInfo.getAllDistrictCodes()) {
                
            String districtName = userInfo.getDistrictMap().get(districtNumber);
            
            /**
             * 
             */
            List<AuditException> atRiskDataCollection = exceptionListReportManager.createAtRiskExceptionList(districtNumber, null);
                        
            JRDataSource atRiskDatasource = exceptionListReportManager.createDatasource(atRiskDataCollection);
                                                
            exceptionListReportManager.generateReport(atRiskDatasource, exceptionListReportManager.createFilenameConstructor(districtNumber,true));
                        
            
            /**
             * 
             */
            List<AuditException> dataCollection = exceptionListReportManager.createPupilCountExceptionList(districtNumber, null);
                        
            JRDataSource datasource = exceptionListReportManager.createDatasource(dataCollection);
                                                
            exceptionListReportManager.generateReport(datasource, exceptionListReportManager.createFilenameConstructor(districtNumber,false));
            
            
            monitor.setProgress(++count/size);            
            }
                        
              
            monitor.setStatus(TaskStatus.SUCCESS);
            monitor.setStatusDetail("State Equal  Exception Lists Report --COMPLETE");
        } catch (Throwable t) {
            monitor.setStatus(TaskStatus.FAILURE);
            monitor.setStatusDetail(t.toString());
            
            LOGGER.error("Exception occurred during State Equal Exception Lists Report Generation.", t);
        }

        return this.monitor;
    }

    /**
     * 
     * @param exceptionListReportManager 
     */
    public void setExceptionListReportManager(IExceptionListReportManager exceptionListReportManager) {
        this.exceptionListReportManager = exceptionListReportManager;
    }
    
}
