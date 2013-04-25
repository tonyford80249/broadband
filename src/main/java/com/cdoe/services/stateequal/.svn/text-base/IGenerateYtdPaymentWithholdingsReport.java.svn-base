package com.cdoe.services.stateequal;

import com.cdoe.services.concurrent.BasicTask;
import com.cdoe.services.concurrent.TaskIdentifer;
import com.cdoe.services.concurrent.TaskMonitor;
import com.cdoe.util.UserInfo;

/**
 *
 * @author Tony Ford
 */
public interface IGenerateYtdPaymentWithholdingsReport extends BasicTask {

    TaskMonitor call() throws Exception;

    /**
     *
     * @return
     */
    TaskMonitor getMonitor();

    TaskIdentifer getTaskIdentifer();

    void setSelectedMonth(String selectedMonth);

    void setSelectedYear(String selectedYear);

    void setUserInfo(UserInfo userInfo);
    
}
