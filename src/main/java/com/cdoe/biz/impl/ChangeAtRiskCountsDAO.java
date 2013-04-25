
package com.cdoe.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.biz.IChangeAtRiskCountsDAO;
import com.cdoe.db.hibernate.HibernateDAO;
import com.cdoe.biz.model.audit.AuditEqual;

public class ChangeAtRiskCountsDAO extends HibernateDAO  implements IChangeAtRiskCountsDAO {

	private static final Logger logger = Logger.getLogger(ChangeAtRiskCountsDAO.class);
	
}
