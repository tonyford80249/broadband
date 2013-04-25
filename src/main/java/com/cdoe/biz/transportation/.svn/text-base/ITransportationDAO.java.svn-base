
package com.cdoe.biz.transportation;

import java.util.List;

import com.cdoe.biz.model.OrganizationUnitMaster;
import com.cdoe.biz.model.transportation.Transportation;

public interface ITransportationDAO {

	List<Transportation> getByDistrictAndYear(String districtNos,
			String fiscalYear);

	public List<Transportation> getByYear(final String fiscalYear);
	
	//public int updateCapOutTran(final String districtNos, final String fiscalYear, double capitalOutlayTotal);
	
	public List<String> getCapitalOutlayDistricts(String fiscalYear);

	int updateErrorStatus(String districtNos, String fiscalYear, String errorStatus);
}
