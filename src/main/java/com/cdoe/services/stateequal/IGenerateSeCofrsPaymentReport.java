package com.cdoe.services.stateequal;


import com.cdoe.services.concurrent.BasicTask;
import com.cdoe.util.UserInfo;
import java.util.Map;


/**
 *
 * @author Tony Ford
 */
public interface IGenerateSeCofrsPaymentReport extends  BasicTask{

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

    

    String getSelectedMonth();

    /**
     *
     * @return
     */
    String getSelectedYear();

      
    /**
     * 
     * @param selectedMonth 
     */
    void setSelectedMonth(String selectedMonth);

    /**
     *
     * @param selectedYear
     */
    void setSelectedYear(String selectedYear);
    
    /**
     * 
     * @param selectedFilter 
     */
    void setSelectedFilter(Map<String, String> selectedFilter);
    
}
