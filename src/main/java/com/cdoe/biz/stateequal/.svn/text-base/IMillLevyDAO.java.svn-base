package com.cdoe.biz.stateequal;

import java.util.List;

import com.cdoe.biz.model.VData;
import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.db.hibernate.IHibernateDAO;

/**
 * 
 * @author Tony Ford
 */
public interface IMillLevyDAO extends IHibernateDAO {
	
	
	public MillLevy findByDistrictAndYear(String districtCode, String fiscalYear);

	public List<MillLevy> findByFiscalYear(String fiscalYear);
	
	public MillLevy findByDistrict(String districtCode, String fiscalYear);
	
}