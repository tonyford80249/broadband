package com.cdoe.biz.impl.transportation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cdoe.biz.model.StateEqualReference;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.biz.transportation.ITransportationDAO;
import com.cdoe.db.hibernate.HibernateDAO;

@SuppressWarnings("unchecked")
public class TransportationDAO extends HibernateDAO implements ITransportationDAO {

	private static final Logger logger = Logger
			.getLogger(TransportationDAO.class);

	public List<Transportation> getByDistrictAndYear(final String districtNos, final String fiscalYear) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<Transportation>>() {

					@Override
					public List<Transportation> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("FROM Transportation c WHERE c.districtNumber = :districtNos AND c.fiscalYear = :fiscalYear");
						query.setString("districtNos", districtNos);
						query.setString("fiscalYear", fiscalYear);
						logger.info("districtNos -->" + districtNos);
						logger.info("fiscalYear val -->" + fiscalYear);
						return (List<Transportation>) query.list();
					}
				});
	}

	public List<Transportation> getByYear(final String fiscalYear) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<Transportation>>() {
					@Override
					public List<Transportation> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("FROM Transportation c WHERE  c.fiscalYear = :fiscalYear");
						query.setString("fiscalYear", fiscalYear);
						logger.info("fiscalYear val -->" + fiscalYear);

						session.setFlushMode(FlushMode.AUTO);
						return (List<Transportation>) query.list();
					}
				});
	}

	
	
	
	public int updateErrorStatus(final String districtNos,final String fiscalYear, String errorStatus) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();

		String hql = "UPDATE Transportation set errors = :errorStatus "
				+ "WHERE districtNumber = :districtNumber "
				+ "  AND fiscalYear = :fiscalYear ";
		Query query = session.createQuery(hql);
		query.setParameter("districtNumber", districtNos);
		query.setParameter("fiscalYear", fiscalYear);
		query.setParameter("errorStatus", errorStatus);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		return result;
	}

	/*public double selectCapOutTran(final String districtNos,
			final String fiscalYear) {
		double capitalOutlayTotal = 0.0;
		Session session = getCurrentSession();

		String hql = "Select capOutTran from Transportation "
				+ "WHERE districtNumber = :districtNumber "
				+ "  AND fiscalYear = :fiscalYear ";
		Query query = session.createQuery(hql);
		query.setParameter("districtNumber", districtNos);
		query.setParameter("fiscalYear", fiscalYear);
		List<Transportation> transportationList = query.list();

		if (transportationList != null && transportationList.size() > 0) {
			capitalOutlayTotal = transportationList.get(0).getCapOutTran();

		}
		return capitalOutlayTotal;

	}*/

	public List<String> getCapitalOutlayDistricts(String fiscalYear) {
		List<Transportation> transportationList = getHibernateTemplate()
				.findByNamedParam("from Transportation "
								+ "WHERE  fiscalYear = :fiscalYear  AND capOutTran > 0 ","fiscalYear", fiscalYear  
								);
		ArrayList<String> values = null;
		if (transportationList != null) {
			values = new ArrayList<String>();
			for (Transportation transportation : transportationList) {
				values.add(transportation.getDistrictNumber());
			}
		}
		return values;

	}

}
