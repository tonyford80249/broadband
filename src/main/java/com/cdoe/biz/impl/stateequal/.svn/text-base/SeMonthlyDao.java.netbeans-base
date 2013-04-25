package com.cdoe.biz.impl.stateequal;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.stateequal.ISeMonthlyDAO;
import com.cdoe.db.hibernate.HibernateDAO;

public class SeMonthlyDao  extends HibernateDAO implements ISeMonthlyDAO {

	private final Logger logger = Logger.getLogger(StateEqualDAO.class);

	@SuppressWarnings("unchecked")
	@Override
	
	
	public Object[] findLatestPaymentMonth() {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("select max(month), max(fiscalYear)  from SeMonthly where fiscalYear = (select max(fiscalYear)  from SeMonthly)");
		List<Object[]> resultList = query.list();
		logger.debug(" resultList " + resultList.get(0));
		
		if (resultList != null && resultList.size() > 0){
			 Object[] res = (Object[]) resultList.get(0);
			 return res;
		}
		else
			return null;
	}


}
