
package com.cdoe.biz.impl.stateequal;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cdoe.biz.stateequal.IMillLevyOverrideWorksheetDAO;
import com.cdoe.db.hibernate.HibernateDAO;


public class MillLevyOverrideWorksheetDAO extends HibernateDAO  implements IMillLevyOverrideWorksheetDAO {

	private static final Logger logger = Logger.getLogger(MillLevyOverrideWorksheetDAO.class);
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getMillLevyOverrideByDistrictYear(final String districtNos, String fiscalYear) {
		
		Session session = getCurrentSession();

		String hql = "Select se.grandTotalProgram, ml.costOfLiving, ml.holdHarmless, ml.excessHoldHarmless,  ml.voterApprovedOverride " + 
		               "  from StateEqual se, MillLevy ml " +
					   "  where se.districtNumber = ml.districtNumber " +
		               "    and se.fiscalYear = ml.fiscalYear" +
					   "    and se.fiscalYear = :fiscalYear" +
		               "    and se.districtNumber = :districtNos";
		Query query = session.createQuery(hql);
		query.setParameter("fiscalYear", fiscalYear);
		query.setParameter("districtNos", districtNos);
		List<Object[]> resultList = query.list();
		return resultList;
		
	
		
	}
	
}
