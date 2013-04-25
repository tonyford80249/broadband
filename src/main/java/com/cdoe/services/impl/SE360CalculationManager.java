package com.cdoe.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.cdoe.biz.IAuditRepaymentAdjustmentDAO;
import com.cdoe.biz.impl.stateequal.CSICalculationsDAO;
import com.cdoe.biz.impl.stateequal.StateEqualDAO;
import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.model.equal.FteByGrade;
import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.stateequal.ICSICalculationsDAO;
import com.cdoe.biz.stateequal.IFteByGradeDAO;
import com.cdoe.biz.stateequal.IMillLevyDAO;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.ISE360CalculationManager;
import com.cdoe.util.DateUtil;

public class SE360CalculationManager extends BaseManager implements
		ISE360CalculationManager {

	private static final Logger logger = Logger.getLogger(SE360CalculationManager.class);
	
	private  IFteByGradeDAO fteByGradeDAO;
	private  ICSICalculationsDAO csiDAO;
	private  IMillLevyDAO millLevyCertDAO;
	private IStateEqualDAO stateEqualDAO; 
	private IReferenceDataManager referenceDataManager;
	
	//private  IAuditRepaymentAdjustmentDAO auditRepaymentAdjustmentDAO;
	
	
	 
	
	public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
		this.stateEqualDAO = stateEqualDAO;
	}


	
	public void setFteByGradeDAO( IFteByGradeDAO fteByGradeDAO) {
		this.fteByGradeDAO = fteByGradeDAO;
	}
	
	public void setCsiDAO( ICSICalculationsDAO csiDAO) {
		this.csiDAO = csiDAO;
	}
	
	public void setMillLevyCertDAO(IMillLevyDAO millLevyCertDAO) {
		this.millLevyCertDAO = millLevyCertDAO;
	}
	
	/*
	 * @param referenceDataManager
	 */
	public void setReferenceDataManager(
			IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}

	
	/*public void setAuditRepaymentAdjustmentDAO (  IAuditRepaymentAdjustmentDAO auditRepaymentAdjustmentDAO) {
		this.auditRepaymentAdjustmentDAO = auditRepaymentAdjustmentDAO;
	}*/
	

	/*
	 * Start from the current fiscal year and read the State Equal records for the
	 * district backwards for the given nos of years.
	 */
	
	public List<StateEqual> getStateEqualByDistrictAndYears(String districtCode,
			String startFiscalYear, int nosOfYears) {

		List<StateEqual> stateEqualList = new ArrayList<StateEqual>();
		//stateEqualList.add(stateEqualDAO.findLatest(districtCode, startFiscalYear));
		String fiscalYear =  DateUtil.getCurrentFiscalYear();
		for (int j = 0; j < nosOfYears; j++) {
			
			StateEqual stateEqual = stateEqualDAO.findLatest(districtCode, fiscalYear);
			if (stateEqual != null)
				stateEqualList.add(stateEqual);
			fiscalYear = DateUtil.getPrevFiscalYear(fiscalYear);
		}
		return stateEqualList;
	}

	
	public List<FteByGrade> getFteByGradeByDistrictAndYears(String districtCode,
			String startFiscalYear, int nosOfYears) {
		List<FteByGrade> fteByGrade = new ArrayList<FteByGrade>();
		String fiscalYear = startFiscalYear;
		for (int j = 0; j < nosOfYears; j++) {
			fiscalYear = DateUtil.getPrevFiscalYear(fiscalYear);
			FteByGrade fteByGradeData = fteByGradeDAO.findLastestByUniqueKey(districtCode, fiscalYear, "TOTALS");
			if (fteByGradeData != null)
				fteByGrade.add(fteByGradeData);
		}
		return fteByGrade;
		
	}
	  
	public MillLevy getMillLevyByDistrictAndYear(String districtCode,	String fiscalYear) {
		MillLevy millLevy = null;
                
		  millLevy = millLevyCertDAO.findByDistrictAndYear(districtCode, fiscalYear);
		
		return millLevy;
		
	}
	
	public Csi getCsiByDistrictAndYear(String districtCode,	String fiscalYear) {
		Csi csi  = null;
		List<Csi> csiList = csiDAO.getByDistrictAndYear(districtCode, fiscalYear);
		if ( csiList != null &&  csiList.size() > 0)
			csi = csiList.get(0);
		return csi;
	}
	
	public Set<String> getDistrictCodes() {
		Set<String> districtCodes = referenceDataManager.getAllOrganizationsMap().keySet();
	    return districtCodes;
	}
	
}
