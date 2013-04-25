package com.cdoe.biz.impl.stateequal;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.biz.model.transportation.CapitalOutlay;
import com.cdoe.biz.stateequal.IMillLevyDAO;
import com.cdoe.db.hibernate.HibernateDAO;

public class MillLevyDAO extends HibernateDAO implements IMillLevyDAO {

	private static final Logger logger = Logger.getLogger(MillLevyDAO.class);

	  
    /**
     * 
     * @param districtCode
     * @param fiscalYear
     * @return 
     */
    @SuppressWarnings("rawtypes")
    @Override
    public MillLevy findByDistrict(String districtCode, String fiscalYear) {
	Session session = getCurrentSession();
	Query query = session
			.createQuery("from MillLevy se where se.districtNumber = :districtNumber and se.fiscalYear = :fiscalYear ");
            
	query.setString("districtNumber", districtCode);
	query.setString("fiscalYear", fiscalYear);
	List results = query.list();
	if (results != null && results.size() > 0)
		return (MillLevy) results.get(0);
	else
		return null;
    }
	/**
	 * 
	 * @param districtCode
	 * @param fiscalYear
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public MillLevy findByDistrictAndYear(String districtCode, String fiscalYear) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from MillLevy se where se.districtNumber = :districtNumber and se.fiscalYear = :fiscalYear ");

		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
		List results = query.list();
		if (results != null && results.size() > 0)
			return (MillLevy) results.get(0);
		else
			return null;
	}

	
	/**
	 * 
	 * @param fiscalYear
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<MillLevy> findByFiscalYear(String fiscalYear) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from MillLevy se where se.fiscalYear = :fiscalYear order by se.districtNumber");

		query.setString("fiscalYear", fiscalYear);
		List results = query.list();

		if (results != null && results.size() > 0) {
			return results;
		} else {
			return null;
		}
	}

}
