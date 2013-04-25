package com.cdoe.biz.impl.stateequal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.stateequal.ICSICalculationsDAO;
import com.cdoe.db.hibernate.HibernateDAO;

@SuppressWarnings("unchecked")
/**
 * 
 */
public class CSICalculationsDAO extends HibernateDAO implements
		ICSICalculationsDAO {

	private static final Logger logger = Logger
			.getLogger(CSICalculationsDAO.class);

	/**
	 * 
	 * @param districtNos
	 * @param fiscalYear
	 * @return
	 */
	public List<Csi> getByDistrictAndYear(final String districtNos,
			final String fiscalYear) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<Csi>>() {

					@Override
					public List<Csi> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("FROM Csi c WHERE c.districtNumber = :districtNos AND c.fiscalYear = :fiscalYear");
						query.setString("districtNos", districtNos);
						query.setString("fiscalYear", fiscalYear);
						logger.info("districtNos -->" + districtNos);
						logger.info("fiscalYear val -->" + fiscalYear);
						return (List<Csi>) query.list();

					}
				});

	}
 
	/**
	 * 
	 * @param fiscalYear
	 * @return
	 */
	public List<Csi> getByFiscalYear(final String fiscalYear) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<Csi>>() {

					@Override
					public List<Csi> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("FROM Csi c WHERE c.fiscalYear = :fiscalYear");

						query.setString("fiscalYear", fiscalYear);
						logger.info("fiscalYear val -->" + fiscalYear);
						return (List<Csi>) query.list();

					}
				});

	}

}
