
package com.cdoe.biz.impl.transportation;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cdoe.biz.model.OrganizationUnitMaster;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.biz.transportation.ICde40TransReimbFormDAO;
import com.cdoe.db.hibernate.HibernateDAO;

@SuppressWarnings("unchecked")
public class Cde40TransReimbFormDAO extends HibernateDAO  implements ICde40TransReimbFormDAO {

	private static final Logger logger = Logger.getLogger(Cde40TransReimbFormDAO.class);
	
	public List<Transportation> getByDistrictAndYear(final String districtNos, final String fiscalYear) {
		 return getHibernateTemplate().executeFind(new HibernateCallback<List<Transportation>>() {

			@Override
			public List<Transportation> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("FROM Transportation c WHERE c.districtNumber = :districtNos AND c.fiscalYear = :fiscalYear");
				query.setString("districtNos", districtNos);
				query.setString("fiscalYear", fiscalYear);
				logger.info("districtNos -->" + districtNos);
				logger.info("fiscalYear val -->" + fiscalYear);
				return (List<Transportation>) query.list();
			}
		});
	}
	
	public List<OrganizationUnitMaster> getAllDistricts() {
		 return getHibernateTemplate().executeFind(new HibernateCallback<List<OrganizationUnitMaster>>() {

				@Override
				public List<OrganizationUnitMaster> doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery("FROM OrganizationUnitMaster o ");
					return (List<OrganizationUnitMaster>) query.list();
				}
			});
		
	}
}
