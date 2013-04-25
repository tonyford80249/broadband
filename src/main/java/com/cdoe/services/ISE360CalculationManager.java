
package com.cdoe.services;

import java.util.List;
import java.util.Set;

import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.model.equal.FteByGrade;
import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.services.transportation.IBaseManager;

public interface ISE360CalculationManager extends IBaseManager {

	public List<StateEqual> getStateEqualByDistrictAndYears(String districtCode, String startFiscalYear, int nosOfYears); 
	
	public List<FteByGrade> getFteByGradeByDistrictAndYears(String districtCode, String startFiscalYear, int nosOfYears);
	
	public MillLevy getMillLevyByDistrictAndYear(String districtCode,	String fiscalYear);
	
	public Csi getCsiByDistrictAndYear(String districtCode,	String fiscalYear);

	Set<String> getDistrictCodes();

}
