
package com.cdoe.services.transportation;

import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.ui.form.transportation.TransportationForm;
import com.cdoe.util.UserInfo;

public interface ICde40SummaryManager extends IBaseManager {

	void saveOrUpdate(TransportationForm transportationForm);
	
	TransportationForm setupForm(String fiscalYear, UserInfo userInfo);
	
	TransportationForm setupForm(long id);

	void rejectDistrictForms(TransportationForm form);

}
