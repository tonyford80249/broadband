
package com.cdoe.services.transportation;

import com.cdoe.ui.form.transportation.TransportationForm;

public interface IPaymentWorkSheetManager extends IBaseManager {

	void saveOrUpdate(TransportationForm transportationForm);
	
	TransportationForm setupForm(String districtNos, String distrinctName, String fiscalYear);
	
	TransportationForm setupForm(long id);

}
