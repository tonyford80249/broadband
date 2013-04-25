package com.cdoe.services;

import com.cdoe.services.concurrent.BasicTask;
import com.cdoe.util.UserInfo;

/**
 *
 * @author Tony Ford
 */
public interface IGenerateExceptionListReport extends BasicTask {

    /**
     *
     * @return
     */
    UserInfo getUserInfo();

    /**
     *
     * @param userInfo
     */
    void setUserInfo(UserInfo userInfo);
    
}
