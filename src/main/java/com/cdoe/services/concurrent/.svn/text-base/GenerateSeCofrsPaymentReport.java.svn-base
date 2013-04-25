package com.cdoe.services.concurrent;


import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.services.ISeCofrsPaymentReportManager;
import com.cdoe.services.stateequal.IGenerateSeCofrsPaymentReport;
import com.cdoe.util.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class GenerateSeCofrsPaymentReport implements IGenerateSeCofrsPaymentReport {
    private static final Logger LOGGER = Logger.getLogger(GenerateSeCofrsPaymentReport.class);
    
    private DefaultMonitor monitor = new DefaultMonitor();
    private ISeCofrsPaymentReportManager seCofrsPaymentReportManager;    
    private UserInfo userInfo;    
    private String selectedYear;
    private String selectedMonth;
    private Map<String,String> selectedFilter;

    /**
     * 
     */
    public GenerateSeCofrsPaymentReport() {
     monitor.setStatus(TaskStatus.NOT_STARTED);    
     monitor.setStatusDetail("Generate Cofrs Payment Report -- NOT STARTED");  
     monitor.setTaskIdentifer(this.getTaskIdentifer());   
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
     * @param monitor 
     */
  
    public void setMonitor(DefaultMonitor monitor) {
        this.monitor =  monitor;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

   

    /**
     * 
     * @return 
     */
    @Override
    public String getSelectedYear() {
        return selectedYear;
    }

    /**
     * 
     * @param selectedYear 
     */
    @Override
    public void setSelectedYear(String selectedYear) {
        this.selectedYear = selectedYear;
    }

    @Override
    public String getSelectedMonth() {
        return selectedMonth;
    }

    @Override
    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }
    
    @Override
    public void setSelectedFilter(Map<String, String> selectedFilter) {
        this.selectedFilter = selectedFilter;
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
            monitor.setStatusDetail("State Equal Cofrs Payment Report Generation -- IN PROGRESS.");
            
            double count = 0;
            int size = userInfo.getAllDistrictCodes().size() + 1;

            monitor.setProgress(count / size);
            
            List<StateEqual> inputData = seCofrsPaymentReportManager.getCofrsPaymentInfo(selectedYear);//new ArrayList<StateEqual>();
            
            /**
             * Apply filter
             */
            if (selectedFilter != null && !selectedFilter.isEmpty()) {
                Iterator<StateEqual> iter = inputData.iterator();  
                
                while (iter.hasNext()) {
                 StateEqual record = iter.next();   
                 
                 if (selectedFilter.containsKey(record.getDistrictNumber())) {
                  iter.remove();   
                 }
                }
            }
            

//            for (String districtNumber : userInfo.getAllDistrictCodes()) {
//                
//                if (selectedFilter != null && !selectedFilter.isEmpty() && !selectedFilter.containsKey(districtNumber)) {
//                 continue;   
//                }
//                
//                String districtName = userInfo.getDistrictMap().get(districtNumber);                                
//
//                StateEqual stateEqualRecord = seCofrsPaymentReportManager.getCofrsPaymentInfo(districtNumber, selectedYear);
//                        
//                
//                if (stateEqualRecord == null) {
//                 final String message = "missing state equal record!!!" ;
//                 
//                 LOGGER.error("skipping : " + districtNumber + " - " + districtName + " due to " + message);
//                 
//                 monitor.getProgressDescription().add("skipping : " + districtNumber + " - " + districtName + " due to " + message); 
//                 
//                 continue;
//                }
//                
//               inputData.add(stateEqualRecord);
//                        
//                /**
//                 * track progress
//                 */
//                monitor.setProgress(++count / size);
//
//                monitor.getProgressDescription().add("proccessed : " + districtNumber + " - " + districtName);
//
//            }
            
            JRDataSource datasource = seCofrsPaymentReportManager.createMonthlyPaymnetDatasource(userInfo.getDistrictMap(), selectedYear, selectedMonth, inputData);
            
            if (selectedFilter != null && !selectedFilter.isEmpty()) {
             seCofrsPaymentReportManager.generateReport(datasource, seCofrsPaymentReportManager.createCofrsPaymentReportFilenameConstructor(selectedMonth,selectedFilter.keySet()), selectedYear, selectedMonth); 
            }
            else {
             seCofrsPaymentReportManager.generateReport(datasource, seCofrsPaymentReportManager.createCofrsPaymentReportFilenameConstructor(selectedMonth), selectedYear, selectedMonth);
            }
            
            monitor.setProgress(++count / size);
              
            monitor.setStatus(TaskStatus.SUCCESS);
            monitor.setStatusDetail("State Equal Cofrs Payment Report --COMPLETE");
        } catch (Throwable t) {
            monitor.setStatus(TaskStatus.FAILURE);
            monitor.setStatusDetail(t.toString());
            
            LOGGER.error("Exception occurred during State Equal Cofrs Payment Report Generation.", t);
        }

        return this.monitor;
    }

    public void setSeCofrsPaymentReportManager(ISeCofrsPaymentReportManager seCofrsPaymentReportManager) {
        this.seCofrsPaymentReportManager = seCofrsPaymentReportManager;
    }

    
    
    

    @Override
    public TaskIdentifer getTaskIdentifer() {
        return TaskIdentifer.CofrsPaymentReport;
    }

               
}
