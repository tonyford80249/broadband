
package com.cdoe.services.audit;

import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.audit.AuditSasidExceptionForm;

public interface IUpdateStudentsManager extends IBaseManager {

	void saveOrUpdate(AuditSasidExceptionForm auditTrackingForm);
	
	AuditSasidExceptionForm setupForm();
	
	AuditSasidExceptionForm setupForm(long id);

}
