package com.cdoe.services;

import com.cdoe.services.concurrent.BasicTask;
import com.cdoe.services.concurrent.TaskIdentifer;
import com.cdoe.services.concurrent.TaskMonitor;
import com.cdoe.util.UserInfo;

/**
 *
 * @author Tony Ford
 */
public interface IGenerateElectionReport extends BasicTask {

    String getFiscalYear();

    @Override
    TaskMonitor getMonitor();

    @Override
    TaskIdentifer getTaskIdentifer();

    UserInfo getUserInfo();

    void setFiscalYear(String fiscalYear);

    void setUserInfo(UserInfo userInfo);
    
}
