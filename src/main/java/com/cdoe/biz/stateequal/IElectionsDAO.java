
package com.cdoe.biz.stateequal;

import java.util.List;

import com.cdoe.biz.model.equal.Election;



public interface IElectionsDAO {
	
	public List<Object[]> getElectionByDistrictYear(final String districtNos, String fiscalYear);

	public Election getElectionByDistrictYearCategory(String districtNos,String fiscalYear, String category);

	int updateBallotUploaded(String districtNos, String fiscalYear,
			String ballotUploaded);
        
        public List<Election> getElectionByFiscalYear(String fiscalYear);

}
