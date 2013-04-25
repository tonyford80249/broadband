
package com.cdoe.services;

import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.transportation.TransportationForm;

public interface ICoforsUploadManager extends IBaseManager {

	void saveOrUpdate(TransportationForm transportationForm);
	
	TransportationForm setupForm();
	
	TransportationForm setupForm(long id);

}
