package com.cdoe.biz.impl.audit;

import java.util.List;

import org.hibernate.Query;

import com.cdoe.biz.audit.IAuditFteByGrade;
import com.cdoe.biz.impl.stateequal.StateEqualDAO;
import com.cdoe.biz.model.audit.AuditFteByGrade;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.db.hibernate.HibernateDAO;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class AuditFteByGradeDAO extends HibernateDAO implements	IAuditFteByGrade {
        private static final Logger LOGGER = Logger.getLogger(AuditFteByGradeDAO.class);
        
        
	@SuppressWarnings("unchecked")
	@Override
	public List<AuditFteByGrade> findByAuditId(Integer auditID) {
		Query query = getCurrentSession().createQuery("from AuditFteByGrade fte where fte.auditID = :auditID");
		query.setInteger("auditID", auditID);
		return query.list();
	}
        
        
        /**
         * 
         * @param districtCode
         * @param fiscalYear
         * @param gradeLevel
         * @return 
         */
        public AuditFteByGrade findByUniqueKey(Integer auditId, String districtCode, String fiscalYear, String gradeLevel) {
            
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditFteByGrade abg where abg.districtNumber = :districtNumber and abg.fiscalYear = :fiscalYear and"
						+ " abg.gradeLevel = :gradeLevel and abg.auditId = :auditId ");
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
                query.setString("gradeLevel", gradeLevel);
                query.setString("auditId", auditId.toString());
                
                LOGGER.info("districtNumber : " + districtCode);
                LOGGER.info("fiscalYear : " + fiscalYear);
                LOGGER.info("gradeLevel : " + gradeLevel);
                LOGGER.info("auditId : " + auditId.toString());
                
		List results = query.list();
		if (results != null && results.size() > 0)
			return (AuditFteByGrade) results.get(0);
		else
			return null;    
        }
        
         /**
          * 
          * @param districtCode
          * @param fiscalYear
          * @return 
          */
         public List<AuditFteByGrade> findByAuditDistrictAndFiscalYear(Integer auditId, String districtCode, String fiscalYear) {
            
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditFteByGrade abg where abg.districtNumber = :districtNumber and abg.fiscalYear = :fiscalYear and"
						+ " abg.auditId = :auditId  ");
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
                query.setString("auditId", auditId.toString());
                
                
                LOGGER.info("districtNumber : " + districtCode);
                LOGGER.info("fiscalYear : " + fiscalYear);   
                LOGGER.info("auditId : " + auditId.toString());
                
		return query.list();
		 
        }
         
         /**
          * 
          * @param auditIds
          * @param districtCode
          * @param fiscalYear
          * @return 
          */
         public List<AuditFteByGrade> findByDistrictAndFiscalYear(List<Integer> auditIds, String districtCode, String fiscalYear) {
            
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditFteByGrade abg where abg.districtNumber = :districtNumber and abg.fiscalYear = :fiscalYear and "
						+ " " + buildSetExpress(auditIds));
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
                setParameters(query, auditIds);
                
                
                LOGGER.info("districtNumber : " + districtCode);
                LOGGER.info("fiscalYear : " + fiscalYear);   
                
                
		return query.list();
		 
        }
         
        public List<AuditFteByGrade> findByDistrict(List<Integer> auditIds, String districtCode) {
            
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditFteByGrade abg where abg.districtNumber = :districtNumber and "
						+ " " + buildSetExpress(auditIds));
		query.setString("districtNumber", districtCode);

                setParameters(query, auditIds);
                
                
                LOGGER.info("districtNumber : " + districtCode);

                
                
		return query.list();
		 
        }
        
        
        /**
         * 
         * @param auditIds
         * @return 
         */
        public List<AuditFteByGrade> findByAuditsOnly(List<Integer> auditIds) {
            
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditFteByGrade abg where " + buildSetExpress(auditIds));
		

                setParameters(query, auditIds);
                                                                                
		return query.list();
		 
        }
         
         
        /**
         * 
         * @param ids
         * @return 
         */ 
        private String buildSetExpress(List<Integer> ids) {
         StringBuilder str = new StringBuilder("abg.auditID in (");
         
         boolean firstOne = true;
         int count = 1;
         for (Integer id : ids) {
          if (firstOne) {
           firstOne = false;   
           
           str.append(":auditId" + count++);   
          } 
          else {
           str.append(",").append(":auditId" + count++);
          }
         }
         
         str.append(")");
            
         return str.toString();   
        }
        
        
        /**
         * 
         * @param query
         * @param ids 
         */
        private void setParameters(Query query, List<Integer> ids) {
                           
         int count = 1;
         for (Integer id : ids) {
          LOGGER.info("auditId" + count + " : " + id);   
          query.setInteger("auditId" + count++, id);                    
         }
                  
        }

}
