package com.cdoe.services.concurrent;

import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.biz.model.jasper.YtdPaymentCollection;
import com.cdoe.biz.model.jasper.YtdPaymentDatasource;
import com.cdoe.services.stateequal.IGenerateYtdPaymentWithholdingsReport;
import com.cdoe.services.stateequal.IPaymentReportManager;
import com.cdoe.services.stateequal.IYtdPaymenstAndWithholdingsManager;
import com.cdoe.util.CalendarMonth;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *  <p>
 *    <b> description </b>  enter description.
 * </p>
 * 
 * @author Tony Ford
 */
public class GenerateYtdPaymentWithholdingsReport implements IGenerateYtdPaymentWithholdingsReport {
     private static final Logger LOGGER = Logger.getLogger(GenerateYtdPaymentWithholdingsReport.class);
    
    private DefaultMonitor monitor = new DefaultMonitor();
    private IYtdPaymenstAndWithholdingsManager ytdPaymentAndWithholdingReportManager;  
    private  UserInfo userInfo;
    private String selectedMonth;
    private String selectedYear;

    public GenerateYtdPaymentWithholdingsReport() {
     monitor.setStatus(TaskStatus.NOT_STARTED);
      monitor.setStatusDetail("State Equal Ytd Payment Withholdings Report -- NOT_STARTED.");  
      monitor.setTaskIdentifer(this.getTaskIdentifer());
    }

    public void setYtdPaymentAndWithholdingReportManager(IYtdPaymenstAndWithholdingsManager ytdPaymentAndWithholdingReportManager) {
        this.ytdPaymentAndWithholdingReportManager = ytdPaymentAndWithholdingReportManager;
    }

    @Override
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    @Override
    public void setSelectedYear(String selectedYear) {
        this.selectedYear = selectedYear;
    }
    
    
    /**
     * 
     * @return 
     */
    @Override
    public TaskMonitor getMonitor() {
        return monitor;
    }
    
    @Override
    public TaskMonitor call() throws Exception {
       try {
            LOGGER.debug("Task Start");
            monitor.setStatus(TaskStatus.INPROGRESS);
            monitor.setStatusDetail("Generate State Equal Ytd Payment Withholdings Report -- IN PROGRESS.");
                       
            //String selectedYear = DateUtil.getCurrentFiscalYear();
                        
            // String selectedMonth = CalendarMonth.getCurrentMonth().name();
                                                
            YtdPaymentCollection paymentCollection =  ytdPaymentAndWithholdingReportManager.getLastestPaymentInfo(selectedYear, selectedMonth, userInfo.getAllDistrictCodes(),  userInfo.getDistrictMap());
                                         
            paymentCollection.setFiscalYear(DateUtil.getFiscalYearFormattedShort(selectedYear));
                        
            paymentCollection.setCurrentMonth(selectedMonth);
                        
            YtdPaymentDatasource ytdPaymenstAndWithholdingsDatasource = new YtdPaymentDatasource(paymentCollection); 
                                              
            ytdPaymentAndWithholdingReportManager.generateReport(ytdPaymenstAndWithholdingsDatasource, ytdPaymentAndWithholdingReportManager.createYtdPaymentFileNameConstructor(selectedYear, selectedMonth),selectedYear, selectedMonth); 
            
            monitor.setProgress(1);
            monitor.setStatus(TaskStatus.SUCCESS);
            monitor.setStatusDetail("Generate State Equal Ytd Payment Withholdings Report --COMPLETE");
            LOGGER.debug("Task Complete");
        } catch (Throwable t) {
            monitor.setStatus(TaskStatus.FAILURE);
            monitor.setStatusDetail(t.toString());
            
            LOGGER.error("Exception occurred during generation of monthly payment reports.", t);
        }

        return this.monitor;
    }

    @Override
    public TaskIdentifer getTaskIdentifer() {
        return TaskIdentifer.YtdPaymentWithholdingReport;
    }
    
}
