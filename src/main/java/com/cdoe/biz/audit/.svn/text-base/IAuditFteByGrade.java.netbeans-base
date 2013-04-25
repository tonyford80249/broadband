package com.cdoe.biz.audit;

import java.util.List;

import com.cdoe.biz.model.audit.AuditFteByGrade;
import com.cdoe.db.hibernate.IHibernateDAO;

public interface IAuditFteByGrade extends IHibernateDAO {
	
	public List<AuditFteByGrade> findByAuditId(Integer auditID);
        
        public AuditFteByGrade findByUniqueKey(Integer auditId, String districtCode, String fiscalYear, String gradeLevel);
        
        public List<AuditFteByGrade> findByAuditsOnly(List<Integer> auditIds);

}
