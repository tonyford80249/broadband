
package com.cdoe.biz.stateequal;

import java.sql.SQLException;
import java.util.List;

import com.cdoe.biz.model.equal.CrosswalkAscent;
import com.cdoe.biz.model.equal.CrosswalkCSI;
import com.cdoe.biz.model.equal.CrosswalkCharter;
import com.cdoe.biz.model.equal.CrosswalkESL;
import com.cdoe.biz.model.equal.CrosswalkFreeLunch;
import com.cdoe.biz.model.equal.CrosswalkFteByGrade;
import com.cdoe.biz.model.equal.CrosswalkOnline;
import com.cdoe.biz.model.equal.CrosswalkSOT;



public interface ICrosswalkCollectionDataDAO {
	public String callCrossWalkProc(String fiscalYear, String crossWalkType);

	List<CrosswalkAscent> getAscentCrossWalkData(String fiscalYear);
	
	List<CrosswalkCharter> getCharterCrossWalkData(String fiscalYear);

	List<CrosswalkFreeLunch> getFreeLunchData(String fiscalYear);

	List<CrosswalkFteByGrade> getFteByGradeData(String fiscalYear);

	List<CrosswalkSOT> getSOTCrossWalkData(String fiscalYear);

	List<CrosswalkOnline> getOnlineCrossWalkData(String fiscalYear);

	List<CrosswalkCSI> getCSICrossWalkData(String fiscalYear);

	void updateAscentTotal(String districtNos, String fiscalYear, double ascent_tot) throws SQLException;

	List<CrosswalkESL> getESLCrossWalkData(String fiscalYear);

	String callCrossWalkDataMigrationProc(String fiscalYear,String crossWalkType);

}
