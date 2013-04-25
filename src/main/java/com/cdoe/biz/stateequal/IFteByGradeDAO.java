package com.cdoe.biz.stateequal;

import java.util.List;

import com.cdoe.biz.model.equal.FteByGrade;
import com.cdoe.db.hibernate.IHibernateDAO;

public interface IFteByGradeDAO extends IHibernateDAO {
	
	public FteByGrade findByUniqueKey(String districtNumber, String fiscalYear, String gradeLevel);
	
	public List<FteByGrade> getByDistrictYear(String districtNumber, String fiscalYear);

        public FteByGrade findLastestByUniqueKey(String districtNumber, String fiscalYear, String gradeLevel);
        
        public void activatePreviousInstnace(String districtNumber, String fiscalYear, String gradeLevel);
}
