package com.cdoe.biz.impl.audit;

import com.cdoe.biz.audit.IAuditSasidExceptionDAO;
import com.cdoe.biz.impl.stateequal.StateEqualDAO;
import com.cdoe.biz.model.audit.AuditSasidException;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.db.hibernate.HibernateDAO;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Tony Ford
 */
public class AuditSasidExceptionDAO extends HibernateDAO implements IAuditSasidExceptionDAO {
 private final Logger LOGGER = Logger.getLogger(AuditSasidExceptionDAO.class);
    
       /**
        * 
        * @param sasId
        * @param districtCode
        * @param fiscalYear
        * @return 
        */
    @Override
      public AuditSasidException findByUniqueKey(String sasId, String districtCode, String fiscalYear) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditSasidException se where se.districtNumber = :districtNumber and se.fiscalYear = :fiscalYear and"
						+ " se.sasid = :sasid ");
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
                query.setString("sasid", sasId);
                
                LOGGER.info("districtNumber : " + districtCode);
                LOGGER.info("fiscalYear : " + fiscalYear);
                LOGGER.info("sasid : " + sasId);
                
		List results = query.list();
		if (results != null && results.size() > 0)
			return (AuditSasidException) results.get(0);
		else
			return null;    
        }   
      
         /**
          * 
          * @param districtCode
          * @param fiscalYear
          * @return 
          */
    @Override
        public List<AuditSasidException> findByDistrictAndFiscalYear(String districtCode, String fiscalYear) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditSasidException se where se.districtNumber = :districtNumber and se.fiscalYear = :fiscalYear ");
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
                
                LOGGER.info("districtNumber : " + districtCode);
                LOGGER.info("fiscalYear : " + fiscalYear);
                
		return query.list();

        }   
        
          /**
          * 
          * @param districtCode
          * @param fiscalYear
          * @return 
          */
    @Override
        public List<AuditSasidException> findByDistrict(String districtCode) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditSasidException se where se.districtNumber = :districtNumber ");
		query.setString("districtNumber", districtCode);
		
                
                LOGGER.info("districtNumber : " + districtCode);
                
                
		return query.list();

        }   
    
    
          
          /**
          * 
          * @param districtCode
          * @param fiscalYear
          * @return 
          */
         @Override
        public List<AuditSasidException> findPupilExceptionsByDistrict(String districtCode) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditSasidException se where se.districtNumber = :districtNumber  and se.pupilException is not null");
		query.setString("districtNumber", districtCode);
		
                
                LOGGER.info("districtNumber : " + districtCode);
                
                
		return query.list();

        }   
         
         /**
          * 
          * @param districtCode
          * @param fiscalYear
          * @return 
          */
         @Override
        public List<AuditSasidException> findAtRiskExceptionsByDistrict(String districtCode) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditSasidException se where se.districtNumber = :districtNumber  and se.atRiskException is not null");
		query.setString("districtNumber", districtCode);
		
                
                LOGGER.info("districtNumber : " + districtCode);
                
                
		return query.list();

        }   
}
