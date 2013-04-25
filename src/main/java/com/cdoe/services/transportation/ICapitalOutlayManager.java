
package com.cdoe.services.transportation;

import com.cdoe.ui.form.transportation.CapitalOutlayForm;

public interface ICapitalOutlayManager extends IBaseManager {

	void saveOrUpdate(CapitalOutlayForm capitalOutlayForm);
	
	CapitalOutlayForm setupForm();
	
	//CapitalOutlayForm setupForm(long id);
	
	CapitalOutlayForm setupForm(String districtNos);
	
	
}
