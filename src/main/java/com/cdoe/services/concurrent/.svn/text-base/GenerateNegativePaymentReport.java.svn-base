package com.cdoe.services.concurrent;

import com.cdoe.services.IGenerateNegativePaymentReport;
import com.cdoe.biz.model.jasper.NegativePayment;
import com.cdoe.biz.model.jasper.SeTotalEntitlement;
import com.cdoe.services.impl.stateequal.TotalEntitlementReportManager;
import com.cdoe.services.stateequal.INegativePaymentReportManager;
import com.cdoe.util.UserInfo;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class GenerateNegativePaymentReport implements IGenerateNegativePaymentReport {
     private static final Logger LOGGER = Logger.getLogger(GenerateNegativePaymentReport.class);
    
    private DefaultMonitor monitor = new DefaultMonitor();
    private INegativePaymentReportManager negativePaymentReportManager;
    private INegativePaymentReportManager positivePaymentReportManager;
    private UserInfo userInfo;    
    private String fiscalYear;

    public GenerateNegativePaymentReport() {
     monitor.setStatus(TaskStatus.NOT_STARTED);    
     monitor.setStatusDetail("Generate Negative Payment Report -- NOT STARTED");  
     monitor.setTaskIdentifer(this.getTaskIdentifer());         
    }
    
    
    @Override
    public TaskMonitor getMonitor() {
       return this.monitor;
    }

    @Override
    public TaskIdentifer getTaskIdentifer() {
        return TaskIdentifer.NegativePaymentReport;
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
        final int POSITIVE_PAYMENT = 1;
        final int NEGATIVE_PAYMENT = 2;
       
                
        try {
            monitor.setStatus(TaskStatus.INPROGRESS);
            monitor.setStatusDetail("State Equal Negative Payment Report Generation -- IN PROGRESS.");
            
           

            monitor.setProgress(.10);
            
            Map<Integer, List<NegativePayment>> collections = negativePaymentReportManager.createNegativePaymentCollection(fiscalYear, userInfo);
            
            monitor.setProgress(.50);                   
            
            if (collections != null) {

            
             JRDataSource datasourceOne = negativePaymentReportManager.createNegativePaymentDatasource(collections.get(NEGATIVE_PAYMENT));
            
             JRDataSource datasourceTwo = positivePaymentReportManager.createNegativePaymentDatasource(collections.get(POSITIVE_PAYMENT));

             monitor.setProgress(.75);
            
             negativePaymentReportManager.generateReport(datasourceOne, negativePaymentReportManager.createNegativePaymentReportFilenameConstructor());
            
             monitor.setProgress(.90);
            
             positivePaymentReportManager.generateReport(datasourceTwo, positivePaymentReportManager.createNegativePaymentReportFilenameConstructor());
            
              monitor.setProgress(1);
              
              monitor.setStatus(TaskStatus.SUCCESS);
              monitor.setStatusDetail("State Equal Negative Payment Report --COMPLETE");
            }
            else {
              monitor.setStatus(TaskStatus.FAILURE);
              monitor.setStatusDetail("No change in entitlement detetected therefore State Equal Negative Payment Report -- CANCELED");  
              
               Thread.sleep(30000);
            }
                        
              
            
        } catch (Throwable t) {
            monitor.setStatus(TaskStatus.FAILURE);
            monitor.setStatusDetail(t.toString());
            
            LOGGER.error("Exception occurred during State Equal Negative Payment Report Generation.", t);
        }

        return this.monitor;
    }

    public void setNegativePaymentReportManager(INegativePaymentReportManager negativePaymentReportManager) {
        this.negativePaymentReportManager = negativePaymentReportManager;
    }

    public void setPositivePaymentReportManager(INegativePaymentReportManager positivePaymentReportManager) {
        this.positivePaymentReportManager = positivePaymentReportManager;
    }
    
    
    
}
