
package com.cdoe.biz.transportation;

import java.util.List;

import com.cdoe.biz.model.transportation.Prorate;

public interface IDistributionAmountsDAO {

	public Prorate getByFiscalYear(String fiscalYear);

	public int updateProrateNote(String fiscalYear, String fundingSources);
	
	public List<Object[]> getCDE40TotalByFiscalYear(final String fiscalYear);

}
