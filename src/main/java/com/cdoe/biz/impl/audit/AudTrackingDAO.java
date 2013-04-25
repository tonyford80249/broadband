
package com.cdoe.biz.impl.audit;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.cdoe.biz.audit.IAudTrackingDAO;
import com.cdoe.biz.model.audit.AuditTracking;
import com.cdoe.db.hibernate.HibernateDAO;

public class AudTrackingDAO extends HibernateDAO  implements IAudTrackingDAO {

	private static final Logger logger = Logger.getLogger(AudTrackingDAO.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<AuditTracking> findAllCompletedAudits() {
		Query query = getCurrentSession()
				.createQuery(
						"from AuditTracking at where at.auditCompleted is not null and at.dataMigrated is null");
		return query.list();
	}

	@Override
	public AuditTracking findByUniqueKey(Integer auditID,
			String organizationCode) {
		Query query = getCurrentSession()
				.createQuery(
						"from AuditTracking at where at.auditID = :auditID and at.organizationCode = :organizationCode");
		query.setInteger("auditID", auditID);
		query.setString("organizationCode", organizationCode);
		return (AuditTracking)query.uniqueResult();
	}

	@Override
	public AuditTracking getOrgCodeForAuditId(Integer auditID) {
		Query query = getCurrentSession()
				.createQuery(
						"from AuditTracking at where at.auditID = :auditID");
		query.setInteger("auditID", auditID);
		return (AuditTracking)query.uniqueResult();
	}
	
}
