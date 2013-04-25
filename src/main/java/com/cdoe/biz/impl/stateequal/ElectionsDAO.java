

package com.cdoe.biz.impl.stateequal;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cdoe.biz.model.equal.Election;
import com.cdoe.biz.stateequal.IElectionsDAO;
import com.cdoe.db.hibernate.HibernateDAO;


public class ElectionsDAO extends HibernateDAO  implements IElectionsDAO {

	private static final Logger logger = Logger.getLogger(ElectionsDAO.class);
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getElectionByDistrictYear(final String districtNos, String fiscalYear) {
		
		Session session = getCurrentSession();

		String sql =  "select e.id, seref.elementValue,  e.noElection, e.voteFor, e.voteAgainst "
					+ "from StateEqualReference seref "
					+ "LEFT JOIN  Election  e ON  "
					+ "with  seref.elementName = e.category "
                    + "and e.districtNumber =:districtNos "
                    + "and fiscalYear = :fiscalYear "
                    + "where seref.groupName = 'ELECTION_CATEGORY'";

   		Query query = session.createSQLQuery(sql);
		query.setParameter("fiscalYear", fiscalYear);
		query.setParameter("districtNos", districtNos);
		List<Object[]> resultList = query.list();
		return resultList;
		
	
		
	}
	
	@SuppressWarnings("unchecked")
	public Election getElectionByDistrictYearCategory(final String districtNos, String fiscalYear, String category) {
		
		Session session = getCurrentSession();

		String hql = /* "select e.id, e.noElection, e.voteFor, e.voteAgainst, e.ballotLanguage, e.electionHeldStatus "*/
				    // "select * "
					 "from Election  e "
					+ " where e.districtNumber =:districtNos "
                    + "and e.fiscalYear = :fiscalYear "
                    + "and e.category = :category";

   		Query query = session.createQuery(hql);
		query.setParameter("fiscalYear", fiscalYear);
		query.setParameter("districtNos", districtNos);
		query.setParameter("category", category);
		List<Election> resultList = query.list();
		if (resultList != null && resultList.size() > 0)
			return resultList.get(0);
		else
			return null;
	
	}
	
	public int updateBallotUploaded(final String districtNos, final String fiscalYear, String ballotUploaded) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();

		String hql = "UPDATE Election  e " +
				     "set ballotUploaded = :ballotUploaded " 
				    + "WHERE districtNumber = :districtNumber "
				    + "  AND fiscalYear = :fiscalYear ";
		Query query = session.createQuery(hql);
		query.setParameter("districtNumber", districtNos);
		query.setParameter("fiscalYear", fiscalYear);
		query.setParameter("ballotUploaded", ballotUploaded);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		return result;
	}
        
        
	public List<Election> getElectionByFiscalYear(String fiscalYear) {
		
		Session session = getCurrentSession();

		String hql = "from Election  e "
					+ " where e.fiscalYear = :fiscalYear ";
                    
   		Query query = session.createQuery(hql);
                
		query.setParameter("fiscalYear", fiscalYear);
		
		return  query.list();		                	
	}
	
}
