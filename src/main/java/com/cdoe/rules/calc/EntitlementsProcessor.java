package com.cdoe.rules.calc;

/* 
 * Developed by Sandeep Sarkar.
 */

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.exception.DataException;

import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.model.equal.FteByGrade;
import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.rules.calc.entitlement.StAvgFreeLunchProcessor;
import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.ISE360CalculationManager;
import com.cdoe.services.impl.ReferenceDataManager;
import com.cdoe.services.impl.SE360CalculationManager;

public class EntitlementsProcessor {

	private static final Logger logger = Logger.getLogger(EntitlementsProcessor.class);
	
	
	public static final String CALC_DATA_SOURCE_DATABASE = "Database";
	public static final String CALC_DATA_SOURCE_FILE = "File";

	private ISE360CalculationManager se360CalcManager;
	private StAvgFreeLunchProcessor stAvgFreeLunchProcessor;

	public void setStAvgFreeLunchProcessor(
			StAvgFreeLunchProcessor stAvgFreeLunchProcessor) {
		this.stAvgFreeLunchProcessor = stAvgFreeLunchProcessor;
	}



	/*
	 * Injector method
	 * 
	 * @param se360CalcManager
	 */
	public void setSe360CalcManager(ISE360CalculationManager se360CalcManager) {
		this.se360CalcManager = se360CalcManager;
	}
	
	

	public SE360CalcData[] processEntitlement(String fiscalMonth, String fiscalYear, String dataSourceType) throws DataException {

		SE360CalcData[] calcData =  setUpAllDistrictsData( fiscalMonth, fiscalYear, dataSourceType);
		stAvgFreeLunchProcessor.process(calcData);
		processDistricts(calcData);
		return calcData;

	}
	
	protected void  processStateAverageFreeLunch(SE360CalcData[] calcData) {
		stAvgFreeLunchProcessor.process(calcData);
	}
	
	protected void  processDistricts(SE360CalcData[] calcData) {
		SEFundedPupilCountProcessor.process(calcData);
		SESizeFactorProcessor.process(calcData);
		SEPersonalCostFactorProcessor.process(calcData);
		System.out.println("   PersonalCostFactor done");
		//Calculate the Pupil Funding Processor
		SEPupilFundingProcessor.process(calcData);
		SEAltAtRiskCalcProcessor.process(calcData);
		SEOnlineFormulaFundingProcessor.process(calcData);
		SESizeFactorSmoothingProcessor.process(calcData);
	    SETaborFormulaFundingProcessor.process(calcData);
		SEMinmFormulaFundingProcessor.process(calcData);
		SETotalFormulaFundingProcessor.process(calcData);
		//Where is Additional Formula funding processor
		//SEBeyondTaborFundingProcessor.process(calcData);
		SETotaProgramFundingProcessor.process(calcData);
		SEMillLevyProcessor.process(calcData);
		SECategoricBOMillLevyProcessor.process(calcData);
		SEGrandTotaProgramFundingProcessor.process(calcData);
		//Where is this accounted
		SEProgFundingForChrtrInstProcessor.process(calcData);
		TotalPropTaxMillLevyProcessor.process(calcData);
	}

	protected void  processCSITotals(SE360CalcData[] calcData) {
		
	}
	 

	protected SE360CalcData[] setUpAllDistrictsData(String fiscalMonth, String fiscalYear, String dataSource) throws DataException {
		
		int currentFiscalYear = (fiscalYear.length() > 4) ? new Integer(fiscalYear.substring(4)).intValue() :  new Integer(fiscalYear).intValue();
		Set<String> districtCodes = se360CalcManager.getDistrictCodes();
		
		SE360CalcData[] calcDataList = new SE360CalcData[districtCodes.size()];

		 if (CALC_DATA_SOURCE_DATABASE.equals(dataSource)) {
				int j= 0;
		
				for (String districtCode:districtCodes ) {
					SE360CalcData calcData = new SE360CalcData();
					calcData.setCalcYear(currentFiscalYear);
					
 					List<StateEqual> stateEqualList = se360CalcManager.getStateEqualByDistrictAndYears(districtCode, fiscalYear,5);
				
					if (stateEqualList != null && stateEqualList.size() > 0)
						mapStateEqualData(stateEqualList, calcData, currentFiscalYear);
					else {
						logger.error("Could not find State Equal data for district code " + districtCode);
					}
					
					MillLevy millLevy = se360CalcManager.getMillLevyByDistrictAndYear(districtCode, fiscalYear);
					if (millLevy == null) {
						logger.error("Could not find millLevy data for districtCode " +  districtCode + " and" + fiscalYear);
					} else {
						mapMainYearMLData(millLevy, calcData);
					}
				
					Csi csi = se360CalcManager.getCsiByDistrictAndYear(districtCode,fiscalYear);
					if (csi == null) {
						logger.error("Could not find CSI data for districtCode " +  districtCode + " and" + fiscalYear);
					} else
						mapMainYearCSIData(csi, calcData);
					
					List<FteByGrade> fteByGradeList = se360CalcManager.getFteByGradeByDistrictAndYears(districtCode,fiscalYear, 5);
					if (fteByGradeList == null) {
						logger.error("Could not find fteByGradeList data for districtCode " +  districtCode + " and" + fiscalYear);
					} else {
						mapFTEData(fteByGradeList, calcData, currentFiscalYear);
					}

					
					
					calcDataList[j++] = calcData;
					
					
				}
		}
		return calcDataList;
	}
	

	
	private static void mapStateEqualData(List<StateEqual> stateEqualList,
			SE360CalcData calcData, long currentFiscalYear) {
		for (StateEqual seData : stateEqualList) {
			long stateEqualYear = new Integer(seData.getFiscalYear().substring(4)).longValue();
			if (stateEqualYear == currentFiscalYear) {
				mapCurrentYearSEData(seData, calcData);
			} else if (currentFiscalYear == (stateEqualYear - 1)) {
				mapPreviousYearSEData(seData, calcData);

			} else {
				mapOlderYearsSEData(seData, calcData, stateEqualYear,currentFiscalYear);
			}
		}
	}

	private static void mapCurrentYearSEData(StateEqual seData,
			SE360CalcData calcData) {
		calcData.setDistNum_of_SE_P0(new Integer(seData.getDistrictNumber()).intValue());
		calcData.setMember_1_8_of_SE_P0(seData.getMember18());
		calcData.setEsl_cap_of_SE_P0(seData.getEslCsap());
		calcData.setFree_lunch_1_8_of_SE_P0(seData.getFreeLunch18());
		calcData.setFree_lunch_k_12_of_SE_P0(seData.getFreeLunchK12());
		calcData.setMember_k_12_of_SE_P0(seData.getMemberK12());
		calcData.setFte_of_SE_P0(seData.getFte());
		calcData.setMultiDist_online_fte_of_SE_P0(seData.getMultiDistrictOnlineFte());
		
		calcData.setCharter_school_fpc_of_SE_P0(seData.getCharterSchoolFpc());
		calcData.setCpp_of_SE_P0(seData.getCpp());
		calcData.setSpeced_pk_of_SE_P0(seData.getSpecedPk());
		calcData.setDist_chrtr_fte_count_of_SE_P0(seData.getDistrictCharterFteCount());
		calcData.setMember_1_8_of_SE_P0(seData.getMember18());
		calcData.setCol_factor_of_SE_P0(seData.getCostOfLivingFactor());
		calcData.setSot_net_of_SE_P0(seData.getSotNet());
		calcData.setAllow_spend_of_SE_P0(seData.getAllowSpend());
		calcData.setDist_cert_total_add_fund_of_SE_P0(seData.getDistrictCertTotalAddFund());
		calcData.setCat_trans_of_SE_P0(seData.getCatTransportation());
		calcData.setCat_voced_of_SE_P0(seData.getCatVoced());
		calcData.setCat_elpa_of_SE_P0(seData.getCatElpa());
		calcData.setCat_sped_dis_of_SE_P0(seData.getCatSpedDisabilities());
		calcData.setCat_sped_gt_of_SE_P0(seData.getCatSpedGiftedTalented());
		calcData.setSmall_center_payments_of_SE_P0(seData.getSmallCenterPayments());
		calcData.setNeg_factor_of_SE_P0(seData.getNegFactor());
		calcData.setTotal_program_cat_buyout_of_SE_P0(seData.getTotalProgramCatBuyout());
		calcData.setCsi_total_program_fund_of_SE_P0(seData.getCsiTotalProgramFund());
		calcData.setAssessed_val_of_SE_P0(seData.getAssessedVal());

	}

	private static void mapOlderYearsSEData(StateEqual seData, SE360CalcData calcData, long stateEqualYear, long currentFiscalYear) {
		int yearsDiff = (int) (currentFiscalYear - stateEqualYear);
		switch (yearsDiff) {
		case 2:
			calcData.setFte_of_SE_P2(seData.getFte());
			calcData.setMultiDist_online_fte_of_SE_P2(seData
					.getMultiDistrictOnlineFte());
			calcData.setCpp_of_SE_P2(seData.getCpp());
		case 3:
			calcData.setFte_of_SE_P3(seData.getFte());
			calcData.setMultiDist_online_fte_of_SE_P2(seData
					.getMultiDistrictOnlineFte());
			calcData.setCpp_of_SE_P2(seData.getCpp());
		case 4:
			calcData.setFte_of_SE_P4(seData.getFte());
			calcData.setMultiDist_online_fte_of_SE_P4(seData
					.getMultiDistrictOnlineFte());
			calcData.setCpp_of_SE_P4(seData.getCpp());
		default:
			;
		}
	}

	private static void mapPreviousYearSEData(StateEqual seData, SE360CalcData calcData) {
		calcData.setFte_of_SE_P1(seData.getFte());
		calcData.setCat_trans_of_SE_P1(seData.getCatTransportation());
		calcData.setCat_voced_of_SE_P1(seData.getCatVoced());
		calcData.setCat_elpa_of_SE_P1(seData.getCatElpa());
		calcData.setCat_sped_dis_of_SE_P1(seData.getCatSpedDisabilities());
		calcData.setCat_sped_gt_of_SE_P1(seData.getCatSpedGiftedTalented());
		calcData.setSmall_center_payments_of_SE_P1(seData
				.getSmallCenterPayments());
		calcData.setMultiDist_online_fte_of_SE_P1(seData
				.getMultiDistrictOnlineFte());
		calcData.setFpc_of_SE_P1(seData.getFundedPupilCount());
		calcData.setCpp_of_SE_P1(seData.getCpp());
		calcData.setMill_levy_adj_of_SE_P1(seData.getMillLevyAdj());
		calcData.setMill_levy_adj_of_SE_P1(seData.getCatLevyAdj());
		calcData.setMill_levy_calc_of_SE_P1(seData
				.getCalcTotalProgramMillLevy());
		calcData.setCat_levy_calc_of_SE_P1(seData.getCalcCatBuyMillLevy());

	}

	

	private static void mapMainYearCSIData(Csi csiData, SE360CalcData calcData) {
		
			
		calcData.setCsi_fl_1_8_count(csiData.getCsiFl18Cnt());
		try {
			calcData.setCsi_fl_k_12_count(csiData.getCsiFlK12Cnt());
			calcData.setCsi_k_12_fte_count(csiData.getCsiK12FteCnt());
			calcData.setCsi_kind_fte_count(csiData.getCsiKindFteCnt());
			calcData.setCsi_mem_1_8_count(csiData.getCsiMem18Cnt());
			calcData.setCsi_mem_k_12_count(csiData.getCsiMemK12Cnt());
		} catch (Exception e) {
			logger.error("Data not found for ditrict " + calcData.getDistNum() );
		}

	}

	
	private static void mapMainYearMLData(MillLevy mlData,
			SE360CalcData calcData) {
		calcData.setVoter_approved_override_of_ML(mlData.getVoterApprovedOverride());
		calcData.setCalculated_tp_of_ML(mlData.getCalculatedTpMillLevy());
	}

	private static void mapFTEData(List<FteByGrade> fteDataList,
			SE360CalcData calcData, long fiscalYear) {
		for (FteByGrade fteData : fteDataList) {
			long fteFiscalYear = new Integer(fteData.getFiscalYear().substring(4)).longValue();
			if (fteFiscalYear == fiscalYear) {
				calcData.setFte_of_SE_P0(fteData.getFteElig());
				calcData.setAscent_of_FTE(fteData.getFundedCount());
			} else if (fteFiscalYear == fiscalYear - 1) {
				calcData.setOut_of_dist_of_FTE_P1(fteData.getOutOfDist());
			} else if (fteFiscalYear == fiscalYear - 2) {
				calcData.setOut_of_dist_of_FTE_P2(fteData.getOutOfDist());
			} else if (fteFiscalYear == fiscalYear - 3) {
				calcData.setOut_of_dist_of_FTE_P3(fteData.getOutOfDist());
			}

		}
	}
	

}
