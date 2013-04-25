package com.cdoe.biz.impl.audit;

import java.util.List;

import org.hibernate.Query;

import com.cdoe.biz.audit.IAuditFreeLunchDAO;
import com.cdoe.biz.model.audit.AuditFreeLunch;
import com.cdoe.db.hibernate.HibernateDAO;

public class AuditFreeLunchDAO extends HibernateDAO implements
		IAuditFreeLunchDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<AuditFreeLunch> findByAuditId(Integer auditID) {
		Query query = getCurrentSession().createQuery("from AuditFreeLunch fl where fl.auditID = :auditID");
		query.setInteger("auditID", auditID);
		return query.list();
	}

}
