package com.cdoe.services.concurrent;

import com.cdoe.services.IGenerateSeCsiPaymentReportTask;
import com.cdoe.biz.model.FiscalMonth;
import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.model.equal.CsiPaymentAdapter;
import com.cdoe.biz.model.jasper.CsiPaymentDatasource;
import com.cdoe.services.stateequal.ISeCsiPaymentReportManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class GenerateSeCsiPaymentReportTask implements IGenerateSeCsiPaymentReportTask {
    private static final Logger LOGGER = Logger.getLogger(GenerateSeCsiPaymentReportTask.class);
    
    private DefaultMonitor monitor = new DefaultMonitor();
    private ISeCsiPaymentReportManager csiPaymentReportManager;
    private Map<String, String> districtMap;
    private String selectedYear;

    /**
     * 
     */
    public GenerateSeCsiPaymentReportTask() {
     monitor.setStatus(TaskStatus.NOT_STARTED);    
     monitor.setStatusDetail("Generate CSI Payment Report -- NOT STARTED");
     monitor.setTaskIdentifer(this.getTaskIdentifer());   
    }

    /**
     * 
     * @param csiPaymentReportManager 
     */
    public void setCsiPaymentReportManager(ISeCsiPaymentReportManager csiPaymentReportManager) {
        this.csiPaymentReportManager = csiPaymentReportManager;
    }

    /**
     * 
     * @param districtMap 
     */
    @Override
    public void setDistrictMap(Map<String, String> districtMap) {
        this.districtMap = districtMap;
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

    /**
     * 
     * @return 
     */
    @Override
    public TaskIdentifer getTaskIdentifer() {
        return TaskIdentifer.CsiPaymentReport;
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
        monitor.setStatusDetail("Generate Csi Payment Report -- IN PROGRESS.");   
        
        final FiscalMonth selectedMonth = FiscalMonth.getCurrentMonth();
        
         Map<String, String> modifiedDistrictMap = new HashMap<String,String>(districtMap);
        
        modifiedDistrictMap.putAll(csiPaymentReportManager.getCSIListing());
        
        CsiPaymentAdapter.setDistrictMap(modifiedDistrictMap);
        
        List<Csi> csiInfo = csiPaymentReportManager.getCsiPaymentInfo(selectedYear);
        
        List<CsiPaymentAdapter> csiPaymentCalculations = csiPaymentReportManager.computeCsiPaymentInfo(csiInfo);
        
        CsiPaymentDatasource datasource = csiPaymentReportManager.createCsiPaymentDatasource(csiPaymentCalculations, selectedMonth, selectedYear);
        
        csiPaymentReportManager.generateReport(datasource, csiPaymentReportManager.createCsiPaymentReporFilenameConstructor(selectedMonth.getText()));
        
        monitor.setStatus(TaskStatus.SUCCESS);
        monitor.setStatusDetail("Generate Csi Payment Report -- COMPLETE");          
      }
      catch(Throwable t) {
        monitor.setStatus(TaskStatus.FAILURE);
        monitor.setStatusDetail(t.toString());
            
        LOGGER.error("Exception occurred during generation of monthly csi payment report.", t);   
      }
      
      return this.monitor;
    }
    
}
