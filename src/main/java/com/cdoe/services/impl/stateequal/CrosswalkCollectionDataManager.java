package com.cdoe.services.impl.stateequal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.cdoe.biz.model.equal.CrosswalkAscent;
import com.cdoe.biz.model.equal.CrosswalkCSI;
import com.cdoe.biz.model.equal.CrosswalkCharter;
import com.cdoe.biz.model.equal.CrosswalkESL;
import com.cdoe.biz.model.equal.CrosswalkFreeLunch;
import com.cdoe.biz.model.equal.CrosswalkFteByGrade;
import com.cdoe.biz.model.equal.CrosswalkOnline;
import com.cdoe.biz.model.equal.CrosswalkSOT;
import com.cdoe.biz.stateequal.ICrosswalkCollectionDataDAO;
import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.ICrosswalkCollectionDataManager;
import com.cdoe.ui.form.grid.CrossWalkDataGrid;
import com.cdoe.ui.form.stateequal.CrosswalkCollectionForm;

public class CrosswalkCollectionDataManager extends BaseManager implements
		ICrosswalkCollectionDataManager {

	private static final Logger logger = Logger.getLogger(CrosswalkCollectionDataManager.class);

	private ICrosswalkCollectionDataDAO crosswalkCollectionDataDAO;
	private IReferenceDataManager referenceDataManager;
	
	/**
	 * Sets the referenceDataManager
	 */
	public void setReferenceDataManager(
			IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}

	public void setCrosswalkCollectionDataDAO(
			ICrosswalkCollectionDataDAO crosswalkCollectionDataDAO) {
		this.crosswalkCollectionDataDAO = crosswalkCollectionDataDAO;
	}

	public CrossWalkDataGrid viewCrosswalkData(CrosswalkCollectionForm crosswalkCollectionForm) {
		 String returnedMessage = crosswalkCollectionDataDAO.callCrossWalkProc(crosswalkCollectionForm.getFiscalYear(),crosswalkCollectionForm.getCollectionType());
		 if (returnedMessage.contains("Exception")) {
			 crosswalkCollectionForm.setMessage(returnedMessage);
			 return null;
		 }  
		 CrossWalkDataGrid crosswalkGrid = getCrosswalkData(crosswalkCollectionForm.getFiscalYear(), crosswalkCollectionForm.getCollectionType());
		 return crosswalkGrid;
		 
	}

	public String saveCrosswalkData(CrosswalkCollectionForm crosswalkCollectionForm) {
		 return crosswalkCollectionDataDAO.callCrossWalkDataMigrationProc(crosswalkCollectionForm.getFiscalYear(),crosswalkCollectionForm.getCollectionType());
	}

	//Not being used
	@Override
	public CrossWalkDataGrid viewCrosswalkData(String fiscalYear, String collectionType) {

		CrossWalkDataGrid resultGrid = new CrossWalkDataGrid();
		List<String> columnHeaders = referenceDataManager.getElementValueList(collectionType);
		
		try {
			
				resultGrid =  getCrosswalkData(fiscalYear, collectionType);
				List<Double> rowList = new ArrayList<Double>();

			
		} catch (Exception e) {
			logger.error("Error reading ");
			resultGrid = null;
		}
		return resultGrid;

	}
	
	public CrossWalkDataGrid getCrosswalkData(String fiscalYear, String crossWalkType) {
		CrossWalkDataGrid resultGrid = new CrossWalkDataGrid();
		
		if ("ASCENT".equalsIgnoreCase(crossWalkType)) {
			List<String> columnHeaders = referenceDataManager.getElementValueList("CROSSWALK_ASCENT_HEADER");
			resultGrid.setColumnHeaders(columnHeaders);
			logger.debug(" Ascent selected ");
			
			List<CrosswalkAscent> ascentList = crosswalkCollectionDataDAO.getAscentCrossWalkData(fiscalYear);
			
			if (ascentList != null) {
				for (CrosswalkAscent ascentData : ascentList) {
					List<String> stringList = new ArrayList<String>(); 
					stringList.add(ascentData.getDistrictNumber());
					stringList.add(ascentData.getAscentTotal().toString());
					resultGrid.getRowStringGrid().put(ascentData.getDistrictNumber(), stringList );
					
				}
			}
		} else if ("Charter School Count".equalsIgnoreCase(crossWalkType)) {
			List<String> columnHeaders = referenceDataManager.getElementValueList("CROSSWALK_CHARTER_HEADER");
			resultGrid.setColumnHeaders(columnHeaders);
			
			logger.debug(" Charter School Count selected ");
			List<CrosswalkCharter> charterList = crosswalkCollectionDataDAO.getCharterCrossWalkData(fiscalYear);
			if (charterList != null ) {
				for (CrosswalkCharter charterData : charterList) {
					List<String> stringList = new ArrayList<String>(); 
					stringList.add(charterData.getDistrictNumber());
					stringList.add(charterData.getFundedCount().toString());
					resultGrid.getRowStringGrid().put(charterData.getDistrictNumber(), stringList );
					
				}
			}
		} else if ("Free Lunch".equalsIgnoreCase(crossWalkType)) {
			List<String> columnHeaders = referenceDataManager.getElementValueList("CROSSWALK_FREE_LUNCH_HEADER");
			resultGrid.setColumnHeaders(columnHeaders);
			
			logger.debug(" Free Lunch selected ");
			List<CrosswalkFreeLunch> freeLunchList = crosswalkCollectionDataDAO.getFreeLunchData(fiscalYear);
			
			if (freeLunchList != null) {
				for (CrosswalkFreeLunch freeLunchData : freeLunchList) {
					List<String> stringList = new ArrayList<String>(); 
					stringList.add(freeLunchData.getDistrictNumber());
					stringList.add(freeLunchData.getGradeLevel());
					stringList.add(freeLunchData.getLunchF().toString());
					//stringList.add(freeLunchData.getChangeType() != null ? freeLunchData.getChangeType() :"");
					//stringList.add(freeLunchData.getDateChange() != null ? freeLunchData.getDateChange().toString():"");
					
					resultGrid.getRowStringGrid().put(freeLunchData.getDistrictNumber() + freeLunchData.getGradeLevel(),stringList);
				}
			}
				
		}
		else if ("SOT".equalsIgnoreCase(crossWalkType)) {
			 List<String> columnHeaders = referenceDataManager.getElementValueList("CROSSWALK_SOT_HEADER");
				resultGrid.setColumnHeaders(columnHeaders);
				logger.debug(" SOT Count selected ");
				List<CrosswalkSOT> sotList = crosswalkCollectionDataDAO.getSOTCrossWalkData(fiscalYear);
				
				if (sotList != null) {
					for (CrosswalkSOT sotData : sotList) {
						List<String> stringList = new ArrayList<String>(); 
						stringList.add(sotData.getDistrictNumber());
						stringList.add(sotData.getSotGross().toString());
						resultGrid.getRowStringGrid().put(sotData.getDistrictNumber(), stringList );
						
					}
				}
		 }else if ("ESL".equalsIgnoreCase(crossWalkType)) {
			logger.debug(" ESL selected ");
			List<String> columnHeaders = referenceDataManager.getElementValueList("CROSSWALK_ESL_HEADER");
			resultGrid.setColumnHeaders(columnHeaders);
			List<CrosswalkESL> eslList = crosswalkCollectionDataDAO.getESLCrossWalkData(fiscalYear);
			
			if (eslList != null) {
				for (CrosswalkESL eslData : eslList) {
					List<String> stringList = new ArrayList<String>(); 
					stringList.add(eslData.getDistrictNumber());
					stringList.add(eslData.getEslCsap().toString());
					resultGrid.getRowStringGrid().put(eslData.getDistrictNumber(), stringList );
					
				}
		 }
		} else if ("Online".equalsIgnoreCase(crossWalkType)) {
			List<String> columnHeaders = referenceDataManager.getElementValueList("CROSSWALK_ONLINE_HEADER");
				resultGrid.setColumnHeaders(columnHeaders);
				logger.debug(" Online Count selected ");
				List<CrosswalkOnline> onlineList = crosswalkCollectionDataDAO.getOnlineCrossWalkData(fiscalYear);
				
				if (onlineList != null) {
					for (CrosswalkOnline onlineData : onlineList) {
						List<String> stringList = new ArrayList<String>(); 
						stringList.add(onlineData.getDistrictNumber());
						stringList.add(onlineData.getSingleDistrictOnlineFTE() != null ? onlineData.getSingleDistrictOnlineFTE().toString() : "0.00");
						stringList.add(onlineData.getMultiDistrictOnlineFTE() != null ? onlineData.getMultiDistrictOnlineFTE().toString() : "0.00");
						resultGrid.getRowStringGrid().put(onlineData.getDistrictNumber(), stringList );
						
					}
				}
		} else if ("CSI".equalsIgnoreCase(crossWalkType)) {
			logger.debug(" CSI selected ");
			List<String> columnHeaders = referenceDataManager.getElementValueList("CROSSWALK_CSI_HEADER");
			resultGrid.setColumnHeaders(columnHeaders);
			
			List<CrosswalkCSI> csiList = crosswalkCollectionDataDAO.getCSICrossWalkData(fiscalYear);
			
			if (csiList != null)
				for (CrosswalkCSI csiData : csiList) {
					List<String> stringList = new ArrayList<String>(); 
					stringList.add(csiData.getDistrictNumber());
					stringList.add(csiData.getGradeLevel());
					stringList.add(csiData.getSchoolCode());
					stringList.add(csiData.getAscentTot() != null ? csiData.getAscentTot().toString() : "0.00");
					stringList.add(csiData.getCsiCppCnt() != null ? csiData.getCsiCppCnt().toString() : "0.00");
					stringList.add(csiData.getCsiFl18Cnt() != null ? csiData.getCsiFl18Cnt().toString() : "0.00");
					stringList.add(csiData.getCsiFlK12Cnt()!= null ? csiData.getCsiFlK12Cnt().toString() : "0.00");
					stringList.add(csiData.getCsiKindFteCnt() != null ? csiData.getCsiKindFteCnt().toString() : "0.00");
					stringList.add(csiData.getCsiMem18Cnt() != null ? csiData.getCsiMem18Cnt().toString() : "0.00");
					stringList.add(csiData.getCsiOnlineCnt() != null ? csiData.getCsiOnlineCnt().toString() : "0.00");
					stringList.add(csiData.getCsiSupplementalK()!= null ? csiData.getCsiSupplementalK().toString() : "0.00");
					
					
					resultGrid.getRowStringGrid().put(csiData.getDistrictNumber()  + csiData.getSchoolCode(), stringList );
					
				}
		}  else if ("Student October".equalsIgnoreCase(crossWalkType)){
			logger.debug("Student October ");
			List<String> columnHeaders = referenceDataManager.getElementValueList("CROSSWALK_FTE_BY_GRADE_HEADER");
			resultGrid.setColumnHeaders(columnHeaders);
		
			List<CrosswalkFteByGrade> fteByGradeList = crosswalkCollectionDataDAO.getFteByGradeData(fiscalYear);
			
			if (fteByGradeList != null) {
				for (CrosswalkFteByGrade fteByGrade : fteByGradeList) {
					List<String> stringList = new ArrayList<String>(); 
					stringList.add(fteByGrade.getDistrictNumber());
					stringList.add(fteByGrade.getGradeLevel());
					stringList.add(fteByGrade.getCdeMember().toString());
					stringList.add(fteByGrade.getParttimeH().toString());
					stringList.add(fteByGrade.getParttimeF().toString());
					stringList.add(fteByGrade.getFteNotElig().toString());
					stringList.add(fteByGrade.getFteElig().toString());
					stringList.add(fteByGrade.getFundedCount().toString());
					stringList.add(fteByGrade.getOutOfDist().toString());
					resultGrid.getRowStringGrid().put(fteByGrade.getDistrictNumber() + fteByGrade.getGradeLevel(),stringList);
				}
			}
		}  else {
			logger.debug("Invalid option selected");
			String returnedMessage = "Invalid option selected - No corresponding procedure found for execute";
		}
		return resultGrid;
		
	}
}
