
package com.cdoe.biz.impl.transportation;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cdoe.db.hibernate.HibernateDAO;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.biz.transportation.IPaymentWorkSheetDAO;

@SuppressWarnings("unchecked")
public class PaymentWorkSheetDAO extends HibernateDAO  implements IPaymentWorkSheetDAO {

	private static final Logger logger = Logger.getLogger(PaymentWorkSheetDAO.class);
	
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
	 
	
}
