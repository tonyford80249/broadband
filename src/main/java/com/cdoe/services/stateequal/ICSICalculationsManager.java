
package com.cdoe.services.stateequal;

import com.cdoe.biz.model.District;
import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.DistrictForm;

public interface ICSICalculationsManager extends IBaseManager {

	void saveOrUpdate(DistrictForm districtForm);
	
	DistrictForm setupForm();
	
	DistrictForm setupForm(long id);

}
