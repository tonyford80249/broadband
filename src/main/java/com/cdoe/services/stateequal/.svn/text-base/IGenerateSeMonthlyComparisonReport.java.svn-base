package com.cdoe.services.stateequal;

import com.cdoe.services.concurrent.BasicTask;
import com.cdoe.services.concurrent.DefaultMonitor;
import com.cdoe.services.concurrent.TaskIdentifer;
import com.cdoe.services.concurrent.TaskMonitor;
import java.util.Map;

/**
 *
 * @author Tony Ford
 */
public interface IGenerateSeMonthlyComparisonReport extends BasicTask {

    TaskMonitor call() throws Exception;

    DefaultMonitor getMonitor();

    TaskIdentifer getTaskIdentifer();

    void setDistrictMap(Map<String, String> districtMap);

    void setSelectedMonth(String selectedMonth);

    void setSelectedYear(String selectedYear);
    
}
