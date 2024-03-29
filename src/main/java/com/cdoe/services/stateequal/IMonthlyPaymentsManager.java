
package com.cdoe.services.stateequal;

import com.cdoe.biz.model.District;
import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.stateequal.SeMonthlyPaymentProcessingForm;
import com.cdoe.util.UserInfo;
import java.util.Map;


public interface IMonthlyPaymentsManager extends IBaseManager {

	public abstract void saveOrUpdate(SeMonthlyPaymentProcessingForm districtForm);
	
	public abstract SeMonthlyPaymentProcessingForm setupForm( UserInfo userInfo);
	
	public abstract SeMonthlyPaymentProcessingForm setupForm(long id);
        
        public abstract SeMonthlyPaymentProcessingForm setupForm( UserInfo userInfo, String fiscalYear, String fiscalMonth);
        
        public void uploadPayment(Map<String, String> districsToBePaid, String fiscalYear, String fiscalMonth);

}
