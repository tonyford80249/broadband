package com.cdoe.biz.impl.transportation;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.biz.transportation.ICde40SummaryDAO;
import com.cdoe.db.hibernate.HibernateDAO;

@SuppressWarnings("unchecked")
public class Cde40SummaryDAO extends HibernateDAO implements ICde40SummaryDAO {

	private static final Logger logger = Logger
			.getLogger(Cde40SummaryDAO.class);
	private static SessionFactory factory;

	public List<Transportation> getTransportationByFiscalYear(
			final String fiscalYear) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<Transportation>>() {

					@Override
					public List<Transportation> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("FROM Transportation c WHERE c.fiscalYear = :fiscalYear");
						query.setString("fiscalYear", fiscalYear);
						logger.info("fiscalYear val -->" + fiscalYear);
						return (List<Transportation>) query.list();
					}
				});
	}

	@Override
	public int updateTransSumInfo(Transportation obj) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();

		String hql = "UPDATE Transportation set actMiles = :actMiles " +
												", totalMiles = :totalMiles "    +
												", regDMiles = :regDMiles "    +
												", migMiles = :migMiles "    +
												", advPay = :advPay "    +
												", schoolDays =:schoolDays " +
											 "WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("actMiles", obj.getActMiles());
		query.setParameter("totalMiles", obj.getTotalMiles());
		query.setParameter("regDMiles", obj.getRegDMiles());
		query.setParameter("migMiles", obj.getMigMiles());
		query.setParameter("advPay", obj.getAdvPay());
		query.setParameter("schoolDays",obj.getSchoolDays()); 
		query.setParameter("id", obj.getId());
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		return result;

	}
}
