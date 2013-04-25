package com.cdoe.services.concurrent;

import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.jasper.SeMonthlyAdapter;
import com.cdoe.biz.model.jasper.SeMonthlyPaymentComparisonDatasource;
import com.cdoe.services.stateequal.IGenerateSeMonthlyComparisonReport;
import com.cdoe.services.stateequal.IMonthlyPaymentComparisonReportManager;
import com.cdoe.util.CalendarMonth;
import com.cdoe.util.DateUtil;
import com.cdoe.util.FilenameConstructor;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import org.apache.log4j.Logger;

/**
 *  <p>
 *    <b> description </b>  enter description.
 * </p>
 * 
 * @author Tony Foird
 */
public class GenerateSeMonthlyComparisonReport implements IGenerateSeMonthlyComparisonReport {
    private static final Logger LOGGER = Logger.getLogger(GenerateSeMonthlyComparisonReport.class);
    private DefaultMonitor monitor = new DefaultMonitor();
    private IMonthlyPaymentComparisonReportManager monthlyPaymentComparisonReportManager;
    private Map<String, String> districtMap;
    private String selectedMonth;
    private String selectedYear;

    /**
     * 
     */
    public GenerateSeMonthlyComparisonReport() {
     monitor.setStatus(TaskStatus.NOT_STARTED);    
     monitor.setStatusDetail("Generate Monthly Comparison Report -- NOT STARTED");  
     monitor.setTaskIdentifer(this.getTaskIdentifer());
    }

    @Override
    public DefaultMonitor getMonitor() {
        return monitor;
    }

    public void setMonthlyPaymentComparisonReportManager(IMonthlyPaymentComparisonReportManager monthlyPaymentComparisonReportManager) {
        this.monthlyPaymentComparisonReportManager = monthlyPaymentComparisonReportManager;
    }

    @Override
    public void setDistrictMap(Map<String, String> districtMap) {
        this.districtMap = districtMap;
    }

    @Override
    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    @Override
    public void setSelectedYear(String selectedYear) {
        this.selectedYear = selectedYear;
    }
    
    @Override
    public TaskMonitor call() throws Exception {
         try {
            monitor.setStatus(TaskStatus.INPROGRESS);
            monitor.setStatusDetail("Generate Monthly Comparison Report -- IN PROGRESS.");
            
            double count = 0;
            int size = districtMap.size();

            monitor.setProgress(count / size);

            for (String districtNumber : districtMap.keySet()) {
                String districtName = districtMap.get(districtNumber);                                             
                                                        
                CalendarMonth currentMonth = CalendarMonth.getCurrentMonth();
                
                CalendarMonth previousMonth = currentMonth.prev();
                
                String otherMonth = currentMonth.name();
                
                String selectedMonth = previousMonth.name();
                                
                String selectedYear = null;
                
                String otherYear = null;
                      
                if (previousMonth == CalendarMonth.JUNE) {                         
                       selectedYear = DateUtil.getPrevFiscalYear();
                       otherYear = DateUtil.getCurrentFiscalYear(); 
                 }
                  else {
                       selectedYear = DateUtil.getCurrentFiscalYear();   
                       otherYear = selectedYear;
                  }                                                                  
                      
                String currentYear =  DateUtil.getCurrentFiscalYear();   
                
                
                StateEqual seStateEqualInfo = monthlyPaymentComparisonReportManager.findLatest(districtNumber, currentYear);
                //StateEqual seStateEqualInfo = monthlyPaymentComparisonReportManager.getLatest(districtNumber, currentYear);
                      
                if (seStateEqualInfo == null) {
                    final String message = "Missing state equal record ";
                    
                    LOGGER.error(message + districtNumber + " - " + districtName); 
                    
                    monitor.getProgressDescription().add("skipping : " + districtNumber + " - " + districtName + " due to " + message);
                    
                    continue;                                            
                }
                      
                List<SeMonthly> sePaymentInfo = monthlyPaymentComparisonReportManager.getMonthlyPaymentInfo(districtNumber, selectedYear, selectedMonth);
                      
                if (sePaymentInfo == null || sePaymentInfo.isEmpty()) {
                     final String message = "Missing payment record for prior month";
                     
                    LOGGER.error(message + districtNumber + " - " + districtName); 
                    
                    monitor.getProgressDescription().add("skipping : " + districtNumber + " - " + districtName + " due to " + message);
                    continue;
                }
                                
                
                SortedSet<SeMonthlyAdapter> sePaymentInfoAndCaluationsList = monthlyPaymentComparisonReportManager.performMonthlyPaymentCalculations(sePaymentInfo);
                      
                SeMonthlyAdapter sePaymentInfoAndCaluations = monthlyPaymentComparisonReportManager.getLastPayment(sePaymentInfoAndCaluationsList);
                       
                
                      
                //(SeMonthlyAdapter source, StateEqual target, String county, String districtName, String sourceMonth, String targetMonth, String sourceFiscalYear, String targetFiscalYear);
                SeMonthlyPaymentComparisonDatasource monthlyPaymentComparisonDataSource = monthlyPaymentComparisonReportManager.createSeMonthlyPaymentComparisonDatasource(sePaymentInfoAndCaluations, seStateEqualInfo, "unknown", districtName, selectedMonth, otherMonth, DateUtil.getCalendarYear(previousMonth,selectedYear),  DateUtil.getCalendarYear(currentMonth,otherYear));
                      
                //String districtName, String sourceMonth, String targetMonth, String fiscalYear
                FilenameConstructor  filenameConstructor = monthlyPaymentComparisonReportManager.createPaymentComparisonReportFilenameConstructor(districtName, selectedMonth, otherMonth, otherYear);
                      
                monthlyPaymentComparisonReportManager.generateReport(monthlyPaymentComparisonDataSource, filenameConstructor);                      

                monitor.setProgress(++count / size);

                monitor.getProgressDescription().add("proccessed : " + districtNumber + " - " + districtName);

            }
            
            monitor.setStatus(TaskStatus.SUCCESS);
            monitor.setStatusDetail("Generate Monthly Comparison Report -- COMPLETE");
        } catch (Throwable t) {
            monitor.setStatus(TaskStatus.FAILURE);
            monitor.setStatusDetail(t.toString());
            LOGGER.error("Exception occurred during monthly comparison report generation.", t);
        }

        return this.monitor;
    }

    @Override
    public TaskIdentifer getTaskIdentifer() {
       return TaskIdentifer.MonthlyComparisonReport;
    }
    
}
