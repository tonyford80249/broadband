
package com.cdoe.biz.impl.transportation;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cdoe.biz.model.transportation.CapitalOutlay;
import com.cdoe.biz.transportation.ICapitalOutlayDAO;
import com.cdoe.db.hibernate.HibernateDAO;

@SuppressWarnings("unchecked")
public class CapitalOutlayDAO extends HibernateDAO  implements ICapitalOutlayDAO {

	private static final Logger logger = Logger.getLogger(CapitalOutlayDAO.class);
	
	
	public List<CapitalOutlay> getByDistrictAndYear(final String districtNos, final String fiscalYear) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<CapitalOutlay>>() {

			@Override
			public List<CapitalOutlay> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("FROM CapitalOutlay c WHERE c.districtNumber = :districtNos AND c.fiscalYear = :fiscalYear");
				query.setString("districtNos", districtNos);
				query.setString("fiscalYear", fiscalYear);
				logger.info("districtNos -->" + districtNos);
				logger.info("fiscalYear val -->" + fiscalYear);
				//query.exec
				return (List<CapitalOutlay>) query.list();
				
			}
		});
		
	}
	
}
