
package com.cdoe.services.audit;

import com.cdoe.biz.model.audit.AuditEqual;
import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.audit.AuditEqualForm;

public interface IAuditSummaryManager extends IBaseManager {

	void saveOrUpdate(AuditEqualForm auditEqualForm);
	
	AuditEqualForm setupForm();
	
	AuditEqualForm setupForm(long id);

}
