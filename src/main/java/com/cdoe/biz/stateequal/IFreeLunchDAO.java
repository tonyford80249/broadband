package com.cdoe.biz.stateequal;

import com.cdoe.biz.model.equal.FreeLunch;
import com.cdoe.db.hibernate.IHibernateDAO;
import java.util.List;

public interface IFreeLunchDAO extends IHibernateDAO {
	
	public FreeLunch findByUniqueKey(String districtNumber, String fiscalYear, String gradeLevel);
	
	public List<FreeLunch> getByDistrictYear(String districtNumber, String fiscalYear);
        
        public FreeLunch findLastestByUniqueKey(String districtNumber, String fiscalYear, String gradeLevel);
        
        public void activatePreviousInstnace(String districtNumber, String fiscalYear, String gradeLevel);

}
