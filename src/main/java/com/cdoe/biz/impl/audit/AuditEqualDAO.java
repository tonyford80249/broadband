package com.cdoe.biz.impl.audit;

import com.cdoe.biz.audit.IAuditEqualDAO;
import com.cdoe.biz.model.audit.AuditEqual;
import com.cdoe.biz.model.audit.AuditFteByGrade;
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
public class AuditEqualDAO extends HibernateDAO implements IAuditEqualDAO {
    private static final Logger LOGGER = Logger.getLogger(AuditEqualDAO.class);
 
    @Override
    public AuditEqual findByAuditId(Integer auditId) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditEqual ae where ae.auditId = :auditId");
		
                query.setInteger("auditId", auditId);
                
                
                LOGGER.info("auditId : " + auditId.toString());
                
		List results = query.list();
		if (results != null && results.size() > 0)
			return (AuditEqual) results.get(0);
		else
			return null;    
        }  
    
    @Override
   public AuditEqual findByUniqueKey(Integer auditId, String districtCode, String fiscalYear) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditEqual ae where ae.districtNumber = :districtNumber and ae.fiscalYear = :fiscalYear and"
						+ " ae.auditId = :auditId");
		query.setString("districtNumber", districtCode);
		query.setString("fiscalYear", fiscalYear);
                query.setInteger("auditId", auditId);
                
                LOGGER.info("districtNumber : " + districtCode);
                LOGGER.info("fiscalYear : " + fiscalYear);
                LOGGER.info("auditId : " + auditId.toString());
                
		List results = query.list();
		if (results != null && results.size() > 0)
			return (AuditEqual) results.get(0);
		else
			return null;    
        }  
   
   public List<AuditEqual> findByAuditAndFiscalYear(Integer auditId, String fiscalYear) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditEqual ae where ae.fiscalYear = :fiscalYear and"
						+ " ae.auditId = :auditId ");
		
		query.setString("fiscalYear", fiscalYear);
                query.setInteger("auditId", auditId);
                
                
                LOGGER.info("fiscalYear : " + fiscalYear);
                LOGGER.info("auditId : " + auditId.toString());
                
		return query.list();
		
        }  
   
   
    public List<AuditEqual> findByFiscalYear(String fiscalYear) {
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditEqual ae where ae.fiscalYear = :fiscalYear");
		
		query.setString("fiscalYear", fiscalYear);
                                                
                LOGGER.info("fiscalYear : " + fiscalYear);
                                
		return query.list();
		
        }  
    
    /**
         * 
         * @param auditIds
         * @return 
         */
    @Override
        public List<AuditEqual> findByAuditsOnly(List<Integer> auditIds) {
            
         Session session = getCurrentSession();
		Query query = session
				.createQuery("from AuditEqual ae where " + buildSetExpress(auditIds));
		

                setParameters(query, auditIds);
                                                                                
		return query.list();
		 
        }
         
         
        /**
         * 
         * @param ids
         * @return 
         */ 
        private String buildSetExpress(List<Integer> ids) {
         StringBuilder str = new StringBuilder("ae.auditId in (");
         
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
