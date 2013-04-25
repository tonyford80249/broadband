
package com.cdoe.biz.impl.stateequal;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.db.hibernate.HibernateDAO;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.biz.stateequal.IDisplayAdjustmentDAO;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class DisplayAdjustmentDAO extends HibernateDAO  implements IDisplayAdjustmentDAO {

	private static final Logger logger = Logger.getLogger(DisplayAdjustmentDAO.class);
	
                       
        public List<StateEqual> getStateEqualByDistrictAndYear(final String districtNos,
			final String fiscalYear) {            
                  
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<StateEqual>>() {

					@Override
					public List<StateEqual> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("FROM StateEqual c WHERE c.districtNumber = :districtNos AND c.fiscalYear = :fiscalYear");
						query.setString("districtNos", districtNos);
						query.setString("fiscalYear", fiscalYear);
						logger.info("districtNos -->" + districtNos);
						logger.info("fiscalYear val -->" + fiscalYear);
						return (List<StateEqual>) query.list();
					}
				});
	}        
}
