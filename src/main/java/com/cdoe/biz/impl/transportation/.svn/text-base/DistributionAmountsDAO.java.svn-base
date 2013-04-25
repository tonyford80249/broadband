package com.cdoe.biz.impl.transportation;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cdoe.biz.model.transportation.Prorate;
import com.cdoe.biz.transportation.IDistributionAmountsDAO;
import com.cdoe.db.hibernate.HibernateDAO;

@SuppressWarnings("unchecked")
public class DistributionAmountsDAO extends HibernateDAO implements
		IDistributionAmountsDAO {

	private static final Logger logger = Logger
			.getLogger(DistributionAmountsDAO.class);

	public Prorate getByFiscalYear(final String fiscalYear) {
		Session session = getCurrentSession();
		String hql = "FROM Prorate c WHERE c.fiscalYear = :fiscalYear";
		Query query = session.createQuery(hql);
		query.setString("fiscalYear", fiscalYear);
		return (Prorate) query.uniqueResult();
	}
	
	public int updateProrateNote(String fiscalYear, String fundingSources) {
		Session session = getCurrentSession();

		String hql = "UPDATE Prorate set fundingSources = :fundingSources " +
											 "WHERE  fiscalYear = :fiscalYear ";
		Query query = session.createQuery(hql);
		query.setParameter("fiscalYear", fiscalYear);
		query.setParameter("fundingSources", fundingSources);
		int result = query.executeUpdate();
		logger.debug("Rows affected: " + result);
		return result;
		
	}
    
	public List<Object[]> getCDE40TotalByFiscalYear(final String fiscalYear) {
		
		Session session = getCurrentSession();

		String hql = "Select sum(advPay), sum(reimEntitlement) " + 
				"       from Transportation " +
					   "  where fiscalYear = :fiscalYear ";
		Query query = session.createQuery(hql);
		query.setParameter("fiscalYear", fiscalYear);
		List<Object[]> resultList = query.list();
		logger.debug(" resultList " + resultList.get(0));
		// System.out.println("Rows affected: " + result);
		logger.debug(" resultList " + resultList.get(0));
		Object[] res = resultList.get(0);
		logger.debug(" res 0 " + res[0]);
		logger.debug(" res 1 " + res[1]);
		double advPay = ((Double)res[0]).doubleValue();
		logger.debug(" advPay " +  advPay);
		return resultList;
		
	
		
	}

}
