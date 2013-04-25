
package com.cdoe.services.audit;


import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.audit.AuditTrackingForm;

public interface IAuditTrackingManager extends IBaseManager {

	void saveOrUpdate(AuditTrackingForm auditTrackingForm);
	
	AuditTrackingForm setupForm();
	
	AuditTrackingForm setupForm(long id);

}
