
package com.cdoe.biz.impl.audit;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.db.hibernate.HibernateDAO;
import com.cdoe.biz.audit.IAuditBillingDAO;
import com.cdoe.biz.model.audit.AuditEqual;

public class AuditBillingDAO extends HibernateDAO  implements IAuditBillingDAO {

	private static final Logger logger = Logger.getLogger(AuditBillingDAO.class);
	
}
