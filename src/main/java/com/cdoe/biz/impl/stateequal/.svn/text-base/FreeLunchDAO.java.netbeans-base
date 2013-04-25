package com.cdoe.biz.impl.stateequal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cdoe.biz.model.equal.FreeLunch;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.stateequal.IFreeLunchDAO;
import com.cdoe.db.hibernate.HibernateDAO;
import com.cdoe.util.NullAwareBeanUtilsBean;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.log4j.Logger;

public class FreeLunchDAO extends HibernateDAO implements IFreeLunchDAO {
        private final Logger LOGGER = Logger.getLogger(FreeLunchDAO.class);
        
	@SuppressWarnings("unchecked")
	public List<FreeLunch> getByDistrictYear(String districtNumber, String fiscalYear) {
                        
			Session session = getCurrentSession();
			Query query = session.createQuery("from FteByGrade where districtNumber = :districtNumber and fiscalYear = :fiscalYear and endEffectiveDate is null");
			query.setString("districtNumber", districtNumber);
			query.setString("fiscalYear", fiscalYear);
			return (List<FreeLunch>) query.list();                                                                     

	}

	@Override
	public FreeLunch findByUniqueKey(String districtNumber, String fiscalYear,
			String gradeLevel) {
		Query query = getCurrentSession()
				.createQuery(
						"from FreeLunch where districtNumber = :districtNumber and fiscalYear = :fiscalYear and gradeLevel = :gradeLevel and endEffectiveDate is null");
		query.setString("fiscalYear", fiscalYear);
		query.setString("districtNumber", districtNumber);
		query.setString("gradeLevel", gradeLevel);
		
		return (FreeLunch)query.uniqueResult();
	}
        
        @Override
	public FreeLunch findLastestByUniqueKey(String districtNumber, String fiscalYear,
			String gradeLevel) {
                String queryStr = "from FreeLunch fl where fl.districtNumber = :districtNumber and fl.fiscalYear = :fiscalYear and fl.gradeLevel = :gradeLevel "
                        + " and fl.endEffectiveDate = (select max(sub.endEffectiveDate) from FreeLunch sub where sub.districtNumber = :districtNumber"
			+ " and sub.fiscalYear = :fiscalYear and sub.gradeLevel = :gradeLevel)";
                
		Query query = getCurrentSession()
				.createQuery(queryStr);
		query.setString("fiscalYear", fiscalYear);
		query.setString("districtNumber", districtNumber);
		query.setString("gradeLevel", gradeLevel);
		
		return (FreeLunch)query.uniqueResult();
	}
        
        @Override
        public void activatePreviousInstnace(String districtNumber, String fiscalYear, String gradeLevel) {
          FreeLunch current = findByUniqueKey(districtNumber, fiscalYear, gradeLevel);
          
          if (current != null) {
           super.delete(current);   
          }
           
          FreeLunch previous = findLastestByUniqueKey(districtNumber, fiscalYear, gradeLevel);
          
          if (previous != null) {
           previous.setEndEffectiveDate(null);
          
           super.saveOrUpdate(previous);
          }
        }
        
        
        
        @Override
	public void saveOrUpdate(Object object) {
		FreeLunch dataEntity = (FreeLunch) object;
		FreeLunch latest = null;

		//if (dataEntity.getId() != null) {
			latest =  this.findByUniqueKey(dataEntity.getDistrictNumber(),dataEntity.getFiscalYear(), dataEntity.getGradeLevel());//this.findByPk(FreeLunch.class, dataEntity.getId());// findLatest(stateEqual.getDistrictNumber());
		//}

		try {
			FreeLunch clone = null;
			// If we didn't find a row, create a new one
			//if (latest == null) {			
                        clone = new FreeLunch();
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
			super.save(clone);
		} catch (Exception e) {
			LOGGER.error("Error cloning StateEqual", e);
			throw new RuntimeException("Error cloning StateEqual", e);
		}
	}

}
