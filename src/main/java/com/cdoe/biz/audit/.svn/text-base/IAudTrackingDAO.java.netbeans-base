
package com.cdoe.biz.audit;

import java.util.List;

import com.cdoe.biz.model.audit.AuditTracking;
import com.cdoe.db.hibernate.IHibernateDAO;


public interface IAudTrackingDAO extends IHibernateDAO {
	
	public List<AuditTracking> findAllCompletedAudits();
	
	public AuditTracking findByUniqueKey(Integer auditID, String organizationCode);
	
	public AuditTracking getOrgCodeForAuditId(Integer auditID);

}
