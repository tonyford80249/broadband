package com.cdoe.biz.stateequal;

import java.util.List;

import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.equal.UpdateType;
import com.cdoe.db.hibernate.IHibernateDAO;

public interface IStateEqualDAO extends IHibernateDAO {
	
	public StateEqual findLatest(String districtCode, String fiscalYear);

	public StateEqual findLatest(String districtCode);
	
	public StateEqual findLatestByYearMonth(String districtCode, String fiscalYear,String fiscalMonth);
        
        public List<StateEqual> findTop100ByUniqueKey(String districtCode, String fiscalYear, int maxSize);
        
        public List<StateEqual> findTop100ByUniqueKey(String districtCode, String fiscalYear, int maxSize, UpdateType updateType);
        
        public List<StateEqual> findByFiscalYear(String fiscalYear);
        
        public StateEqual findByUniqueKey(String districtCode, String fiscalYear);
        
        public StateEqual findByByYearMonth(String districtCode, String fiscalYear, String fiscalMonth);
        

	int updateStateAverage(String fiscalYear, Double stateAverageAtRiskPercent);

}
