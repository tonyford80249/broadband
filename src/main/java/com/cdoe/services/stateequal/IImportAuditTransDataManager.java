
package com.cdoe.services.stateequal;

import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.transportation.TransportationForm;

public interface IImportAuditTransDataManager extends IBaseManager {

	void saveOrUpdate(TransportationForm transportationForm);
	
	TransportationForm setupForm();
	
	TransportationForm setupForm(long id);

}
