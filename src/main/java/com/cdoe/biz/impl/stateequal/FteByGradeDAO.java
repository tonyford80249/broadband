package com.cdoe.biz.impl.stateequal;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cdoe.biz.model.equal.FteByGrade;
import com.cdoe.biz.stateequal.IFteByGradeDAO;
import com.cdoe.db.hibernate.HibernateDAO;
import com.cdoe.util.NullAwareBeanUtilsBean;

@SuppressWarnings("unchecked")
public class FteByGradeDAO extends HibernateDAO implements IFteByGradeDAO {
         private final Logger LOGGER = Logger.getLogger(FteByGradeDAO.class);
         
	@Override
	public FteByGrade findByUniqueKey(String districtNumber, String fiscalYear,
			String gradeLevel) {
		Session session = getCurrentSession();
		Query query = session.createQuery("from FteByGrade where districtNumber = :districtNumber and fiscalYear = :fiscalYear and gradeLevel = :gradeLevel and endEffectiveDate is null");
		query.setString("districtNumber", districtNumber);
		query.setString("fiscalYear", fiscalYear);
		query.setString("gradeLevel", gradeLevel);
		return (FteByGrade)query.uniqueResult();
	}
	
	
	public List<FteByGrade> getByDistrictYear(String districtNumber, String fiscalYear) {
		Session session = getCurrentSession();
		Query query = session.createQuery("from FteByGrade where districtNumber = :districtNumber and fiscalYear = :fiscalYear and endEffectiveDate is null");
		query.setString("districtNumber", districtNumber);
		query.setString("fiscalYear", fiscalYear);
		return (List<FteByGrade>) query.list();
	}
        
        @Override
	public FteByGrade findLastestByUniqueKey(String districtNumber, String fiscalYear,
			String gradeLevel) {
                String queryStr = "from FteByGrade fte where fte.districtNumber = :districtNumber and fte.fiscalYear = :fiscalYear and fte.gradeLevel = :gradeLevel "
                        + " and fte.endEffectiveDate = (select max(sub.endEffectiveDate) from FteByGrade sub where sub.districtNumber = :districtNumber"
			+ " and sub.fiscalYear = :fiscalYear and sub.gradeLevel = :gradeLevel)";
                
		Query query = getCurrentSession()
				.createQuery(queryStr);
		query.setString("fiscalYear", fiscalYear);
		query.setString("districtNumber", districtNumber);
		query.setString("gradeLevel", gradeLevel);
		
		return (FteByGrade)query.uniqueResult();
	}
        
        @Override
        public void activatePreviousInstnace(String districtNumber, String fiscalYear, String gradeLevel) {
          FteByGrade current = findByUniqueKey(districtNumber, fiscalYear, gradeLevel);
          
          if (current != null) {
           super.delete(current);   
          }
           
          FteByGrade previous = findLastestByUniqueKey(districtNumber, fiscalYear, gradeLevel);
          
          if (previous != null) {
           previous.setEndEffectiveDate(null);
          
           super.saveOrUpdate(previous);
          }
        }
        
        
       @Override
	public void saveOrUpdate(Object object) {
		FteByGrade dataEntity = (FteByGrade) object;
		FteByGrade latest = null;

		//if (dataEntity.getId() != null) {
			latest = this.findByUniqueKey(dataEntity.getDistrictNumber(),dataEntity.getFiscalYear(),dataEntity.getGradeLevel()); //this.findByPk(FteByGrade.class, dataEntity.getId());// findLatest(stateEqual.getDistrictNumber());
		//}

		try {
			FteByGrade clone = null;
			// If we didn't find a row, create a new one
			//if (latest == null)			
                        clone = new FteByGrade();
                        //This is a waist because you just end up over writing the clone.
			//else
			//	clone = (FteByGrade) BeanUtils.cloneBean(latest);
                        //        
			
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
			super.save(clone);
		} catch (Exception e) {
			LOGGER.error("Error cloning StateEqual", e);
			throw new RuntimeException("Error cloning StateEqual", e);
		}
	}


}
