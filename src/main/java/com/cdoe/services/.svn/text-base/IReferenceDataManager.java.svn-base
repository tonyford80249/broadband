package com.cdoe.services;

import java.util.List;
import java.util.Map;

import com.cdoe.biz.model.StateEqualReference;
import com.cdoe.util.UserInfo;

public interface IReferenceDataManager {

        /**
         * 
         * @param orgCode
         * @return 
         */
	public String getOrganizationName(String orgCode);
	
        /**
         * 
         * @return 
         */
	public Map<String, String> getAllOrganizationsMap();
	
        /**
         * 
         * @param orgType
         * @return 
         */
	public Map<String, String> getOrganizationsMap(String orgType);
	
        /**
         * 
         * @return 
         */
	public List<String> getMonthList();
	
        /**
         * 
         * @return 
         */
	public List<String> getCrosswalkDataType();
	
        /**
         * 
         * @return 
         */
	public List<String> getDistrictEntitlementPeriod();
	
        /**
         * 
         * @return 
         */
	public List<String> getStateShareAdjustments();
	
        /**
         * 
         * @return 
         */
	public String getLastPaymentDate();
	
        /**
         * 
         * @return 
         */
	public List<String> getCrossWalkDataType();
	
        /**
         * 
         * @return 
         */
	public List<String> getAuditRepaymentAdjustmentFrequencies();

        /**
         * 
         * @return 
         */
	public List<String> getCapitalOutlayDistricts();
	
        /**
         * 
         * @return 
         */
	public List<String> getStateEqualAdjustments();
	
        /**
         * 
         * @return 
         */
	public List<String> getUploadVariables();
	
        /**
         * 
         * @return 
         */
	public List<String> getCalculationPeriods();
	
        /**
         * 
         * @return 
         */
	public List<String> getElectionTopics();
	
        /**
         * 
         * @param groupName
         * @return 
         */
	public List<StateEqualReference> findByGroupName(String groupName);
                
        /**
         * 
         * @param userInfo 
         */
     public void populateUserInfo(UserInfo userInfo);
        
        /**
         * 
         * @param userInfo
         * @param orgType 
         */
        public void populateUserInfo(UserInfo userInfo, String orgType);
        
        /**
         * 
         * @param groupName
         * @return 
         */
        public 	List<String> getElementValueList(String groupName);
        
        /**
         * 
         * @return String[]
         */

        public String[] getLastAndNextPaymentsMonthYear();

}
