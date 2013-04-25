
package com.cdoe.biz.transportation;

import java.util.List;

import com.cdoe.biz.model.transportation.CapitalOutlay;

public interface ICapitalOutlayDAO {

	List<CapitalOutlay> getByDistrictAndYear(String districtNos,
			String fiscalYear);

}
