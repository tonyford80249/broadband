/**
 * 
 */
package com.cdoe.biz.impl.stateequal;

import com.cdoe.biz.model.equal.FreeLunch;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.equal.UpdateType;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.db.hibernate.HibernateDAO;
import com.cdoe.util.NullAwareBeanUtilsBean;
import java.sql.Timestamp;
import javax.sql.DataSource;

/**
 * @author dyn-8
 * 
 */
public class StateEqualDAO extends HibernateDAO implements IStateEqualDAO {

	private final Logger logger = Logger.getLogger(StateEqualDAO.class);
        private DataSource datasource;

        
        /**
         * 
         * @param districtCode
         * @param fiscalYear
         * @param maxSize
         * @return 
         */
        public List<StateEqual> findTop100ByUniqueKey(String districtCode, String fiscalYear, int maxSize) {
         return findTop100ByUniqueKey(districtCode, fiscalYear, maxSize, null);    
        }
        
        /**
         * 
         * @param districtCode
         * @param fiscalYear
         * @param maxSize
         * @param updateType
         * @return 
         */
        public List<StateEqual> findTop100ByUniqueKey(String districtCode, String fiscalYear, int maxSize, UpdateType updateType) {
         Session session = getCurrentSession();
         
              if (updateType == null) {
		Query query = session
				.createQuery("from StateEqual se where se.districtNumber = :districtNumber and se.fiscalYear = :fiscalYear "
						+ "order by se.startEffectiveDate desc");
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
                query.setMaxResults(maxSize);
                
                logger.info("districtNumber : " + districtCode);
                logger.info("fiscalYear : " + fiscalYear);
                
		return query.list();	
              }
              else {
               Query query = session
				.createQuery("from StateEqual se where se.districtNumber = :districtNumber and se.fiscalYear = :fiscalYear and"
					   + "se.changeTypeIndicator = :changeTypeIndicator order by se.startEffectiveDate desc");
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
                query.setString("changeTypeIndicator", updateType.name());
                
                logger.info("districtNumber : " + districtCode);
                logger.info("fiscalYear : " + fiscalYear);
                logger.info("changeTypeIndicator : " + updateType.name());
                
                query.setMaxResults(maxSize);
                
		return query.list();	                   
              }
        }
        
        /**
         * 
         * @param districtCode
         * @param fiscalYear
         * @return 
         */
        public List<StateEqual> findByFiscalYear(String fiscalYear) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from StateEqual se where se.fiscalYear = :fiscalYear and"
						+ " se.endEffectiveDate is null order by se.districtNumber");
		
		query.setString("fiscalYear", fiscalYear);
                                
                logger.info("fiscalYear : " + fiscalYear);
                
		return query.list();		
        }
        
        /**
         * 
         * @param districtCode
         * @param fiscalYear
         * @return 
         */
        public StateEqual findByUniqueKey(String districtCode, String fiscalYear) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from StateEqual se where se.districtNumber = :districtNumber and se.fiscalYear = :fiscalYear and"
						+ " se.endEffectiveDate is null ");
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
                
                logger.info("districtNumber : " + districtCode);
                logger.info("fiscalYear : " + fiscalYear);
                
		List results = query.list();
		if (results != null && results.size() > 0)
			return (StateEqual) results.get(0);
		else
			return null;    
        }
        
        /**
         * 
         * @param districtCode
         * @param fiscalYear
         * @param fiscalMonth
         * @return 
         */
        public StateEqual findByByYearMonth(String districtCode, String fiscalYear, String fiscalMonth) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from StateEqual se where se.districtNumber = :districtNumber and"
						+ " se.month = :month and"
						+ " se.fisaclYear = :fiscalYear and "
                                                + " se.startEffectiveDate = (select max(se2.startEffectiveDate) from StateEqual se2 where se2.districtNumber = :districtNumber and "
                                                + " s2e.month = :month and se2.fisaclYear = :fiscalYear");
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
		query.setString("fiscalMonth", fiscalMonth);

                logger.info("districtNumber : " + districtCode);
                logger.info("fiscalYear : " + fiscalYear);
                logger.info("fiscalMonth : " + fiscalMonth);
                
		List results = query.list();
		if (results != null && results.size() > 0)
			return (StateEqual) results.get(0);
		else
			return null;   
        }
        
        /**
         * 
         * @param districtCode
         * @return 
         */
        public List<StateEqual> findByDistrict(String districtCode) {
         Session session = getCurrentSession();
		Query query = session.createQuery("from StateEqual se where se.districtNumber = :districtNumber and"
						+ " se.endEffectiveDate is null");
		query.setString("districtNumber", districtCode);
		
                logger.info("districtNumber : " + districtCode);                
                
                return query.list();

        }
        
	@SuppressWarnings("rawtypes")
	@Override
	public StateEqual findLatest(String districtCode, String fiscalYear) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from StateEqual se where se.districtNumber = :districtNumber and se.fiscalYear = :fiscalYear and"
						+ " se.dateCreated = (select max(se2.dateCreated) from StateEqual se2 where se2.districtNumber = :districtNumber"
						+ " and se2.fiscalYear = :fiscalYear)");
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
                
                logger.info("districtNumber : " + districtCode);
                logger.info("fiscalYear : " + fiscalYear);
                
		List results = query.list();
		if (results != null && results.size() > 0)
			return (StateEqual) results.get(0);
		else
			return null;
 	}

	@SuppressWarnings("rawtypes")
	@Override
	public StateEqual findLatest(String districtCode) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from StateEqual se where se.districtNumber = :districtNumber and"
						+ " se.dateCreated = (select max(se2.dateCreated) from StateEqual se2 where se2.districtNumber = :districtNumber)");
		query.setString("districtNumber", districtCode);
                
                logger.info("districtNumber : " + districtCode);
                
		List results = query.list();
		if (results != null && results.size() > 0)
			return (StateEqual) results.get(0);
		else
			return null;
	}

	@SuppressWarnings("rawtypes")
	public StateEqual findLatestByYearMonth(String districtCode,
			String fiscalYear, String fiscalMonth) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("from StateEqual se where se.districtNumber = :districtNumber and"
						+ " se.month = :month and"
						+ " se.fisaclYear = :fiscalYear");
		query.setString("districtNumber", districtCode);
                logger.info("districtNumber : " + districtCode);
		query.setString("fiscalYear", fiscalYear);
                logger.info("fiscalYear : " + fiscalYear);
		query.setString("fiscalMonth", fiscalMonth);
                logger.info("fiscalMonth : " + fiscalMonth);

		List results = query.list();
		if (results != null && results.size() > 0)
			return (StateEqual) results.get(0);
		else
			return null;
	}

        
         @Override
	public void saveOrUpdate(Object object) {
		StateEqual dataEntity = (StateEqual) object;
		StateEqual latest = null;

		//if (dataEntity.getId() != null) {
			latest =  this.findByUniqueKey(dataEntity.getDistrictNumber(),dataEntity.getFiscalYear());
		//}

		try {
			StateEqual clone = null;
			// If we didn't find a row, create a new one
			//if (latest == null) {			
                        clone = new StateEqual();
                        //This is a waist of time as you will just over write the properties of the clone.
                        //}
                        //else {
			//	clone = (FreeLunch) BeanUtils.cloneBean(latest);
                        //}
			
			BeanUtilsBean notNullCloner = new NullAwareBeanUtilsBean();                                                
                      
                        notNullCloner.copyProperties(clone, dataEntity);
                        
			//Session session = getCurrentSession();

			if (latest != null) {
			  
                          latest.setEndEffectiveDate(new Timestamp(new Date().getTime()));  
                          
                          super.saveOrUpdate(latest);
                                                   
                          //session.evict(latest);
			}

		
			clone.setId(null);
			clone.setVersion(null);
			clone.setStartEffectiveDate(new Timestamp(new Date().getTime()));
                        clone.setDateCreated(new Date());
			super.save(clone);
		} catch (Exception e) {
			logger.error("Error cloning StateEqual", e);
			throw new RuntimeException("Error cloning StateEqual", e);
		}
	}
         
        
//	@Override
//	public void saveOrUpdate(Object object) {
//		StateEqual stateEqual = (StateEqual) object;
//		StateEqual latest = null;
//
//		if (stateEqual.getId() != null) {
//			latest = this.findByPk(StateEqual.class, stateEqual.getId());// findLatest(stateEqual.getDistrictNumber());
//		}
//
//		try {
//			StateEqual clone = null;
//			// If we didn't find a row, create a new one
//			if (latest == null)
//				clone = new StateEqual();
//			else
//				clone = (StateEqual) BeanUtils.cloneBean(latest);
//			
//			BeanUtilsBean notNullCloner = new NullAwareBeanUtilsBean();
//			Session session = getCurrentSession();
//
//			if (latest != null) {
//				session.evict(latest);
//			}
//
//			notNullCloner.copyProperties(clone, stateEqual);
//			clone.setId(null);
//			clone.setVersion(null);
//			clone.setDateCreated(new Date());
//			super.save(clone);
//		} catch (Exception e) {
//			logger.error("Error cloning StateEqual", e);
//			throw new RuntimeException("Error cloning StateEqual", e);
//		}
//	}
	
	public int updateStateAverage(String fiscalYear, Double stateAverageAtRiskPercent) {
		Session session = getCurrentSession();

		String hql = "UPDATE StateEqual se set stateAverageAtRiskPercent = :stateAverageAtRiskPercent " +
											 " WHERE  se.districtNumber = :districtNumber and"
				                           + " se.fiscalYear = :fiscalYear"
										   + " se.dateCreated = (select max(se2.dateCreated) " +
											 " from StateEqual se2 where se2.districtNumber = :districtNumber)";
		Query query = session.createQuery(hql);
		query.setParameter("fiscalYear", fiscalYear);
		query.setParameter("stateAverageAtRiskPercent", stateAverageAtRiskPercent);
		//query.setParameter(" districtNumber", districtNumber);
		int result = query.executeUpdate();
		logger.debug("Rows affected: " + result);
		return result;
		
	}
    
	

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }


}
