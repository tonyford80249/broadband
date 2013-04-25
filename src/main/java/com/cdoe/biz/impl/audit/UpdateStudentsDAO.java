
package com.cdoe.biz.impl.audit;

import org.apache.log4j.Logger;

import com.cdoe.biz.audit.IUpdateStudentsDAO;
import com.cdoe.db.hibernate.HibernateDAO;

public class UpdateStudentsDAO extends HibernateDAO  implements IUpdateStudentsDAO {

	private static final Logger logger = Logger.getLogger(UpdateStudentsDAO.class);
	
}
