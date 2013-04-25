
package com.cdoe.biz.stateequal;

import java.util.List;

import com.cdoe.biz.model.VData;

public interface IMillLevyOverrideWorksheetDAO {

	List<Object[]>  getMillLevyOverrideByDistrictYear(String districtCode,
			String fiscalYear);

}
