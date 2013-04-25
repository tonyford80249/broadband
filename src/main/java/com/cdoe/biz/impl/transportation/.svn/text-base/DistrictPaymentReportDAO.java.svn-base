
package com.cdoe.biz.impl.transportation;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cdoe.biz.IDistrictPaymentReportDAO;
import com.cdoe.biz.model.transportation.Prorate;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.db.hibernate.HibernateDAO;

@SuppressWarnings("unchecked")
public class DistrictPaymentReportDAO extends HibernateDAO  implements IDistrictPaymentReportDAO {

	private static final Logger logger = Logger.getLogger(DistrictPaymentReportDAO.class);
	
	public List<Transportation> getTransportationByFiscalYear(final String fiscalYear) {
		 return getHibernateTemplate().executeFind(new HibernateCallback<List<Transportation>>() {

			@Override
			public List<Transportation> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("FROM Transportation c WHERE c.fiscalYear = :fiscalYear");
				query.setString("fiscalYear", fiscalYear);
				logger.info("fiscalYear val -->" + fiscalYear);
				return (List<Transportation>) query.list();
			}
		});
	}
	
	public List<Prorate> getDistrictPaymentReport(final String fiscalYear) {
		return getHibernateTemplate().executeFind(new HibernateCallback< List<Prorate>>() {
			@Override
			public List<Prorate> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("FROM Prorate c WHERE c.fiscalYear = :fiscalYear");
				query.setString("fiscalYear", fiscalYear);
				return (List<Prorate>)  query.list();
			}
		});
	}
	
}
