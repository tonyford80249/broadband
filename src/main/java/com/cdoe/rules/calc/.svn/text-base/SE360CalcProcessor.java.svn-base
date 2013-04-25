package com.cdoe.rules.calc;

/* 
 * Developed by Sandeep Sarkar.
 */

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.DataException;

import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.model.equal.FteByGrade;
import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.services.ISE360CalculationManager;

public class SE360CalcProcessor {

	public static final String RULE_TYPE_DECISION = "Decision";
	public static final String RULE_TYPE_METHOD = "Method";
	public static final String CALC_DATA_SOURCE_HARDCODED = "HardCoded";
	public static final String CALC_DATA_SOURCE_DATABASE = "Database";
	public static final String CALC_DATA_SOURCE_FILE = "File";

	private ISE360CalculationManager se360CalcManager; 
	
	/*
	 * Injector method
	 * @param se360CalcManager
	 */
	public void setSe360CalcManager(ISE360CalculationManager se360CalcManager) {
		this.se360CalcManager = se360CalcManager;
	}

	public  SE360CalcData[] invoke360Calculation(String districtCode, String fiscalYear,	String dataSourceType) throws DataException {

		SE360CalcData[] calcData = (SE360CalcData[]) setUpData(districtCode, fiscalYear, "HardCoded");

		//Calculate the variable values
		SEVariableProcessor.process(calcData);
		//Calculate the Funded Pupil Count values - Rule names with FCs
		SEFundedPupilCountProcessor.process(calcData);
		//Calculate the Size Factor
		SESizeFactorProcessor.process(calcData);
		//Calculate the Personal Cost Factor
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
		SEBeyondTaborFundingProcessor.process(calcData);
		SETotaProgramFundingProcessor.process(calcData);
		SEMillLevyProcessor.process(calcData);
		SECategoricBOMillLevyProcessor.process(calcData);
		SEGrandTotaProgramFundingProcessor.process(calcData);
		SEProgFundingForChrtrInstProcessor.process(calcData);
		TotalPropTaxMillLevyProcessor.process(calcData);
		return calcData;

	}

	
	/*
	 * Invokes the 360 Calculations for a single district
	 */
	public static void main(String[] args) {
		String districtCode = "0100";
		String fiscalYear = "20112012";
		SE360CalcProcessor scp = new SE360CalcProcessor();
		scp.invoke360Calculation(districtCode, fiscalYear,CALC_DATA_SOURCE_HARDCODED);

	}

	private Object[] setUpData(String districtCode, String fiscalYear, String dataSource) throws DataException {
		SE360CalcData[] calcData = new SE360CalcData[1];

		for (int i = 0; i < calcData.length; i++) {
			calcData[i] = new SE360CalcData();
			calcData[i].calcYear = new Integer(fiscalYear).intValue();
			if (CALC_DATA_SOURCE_HARDCODED.equals(dataSource)) {
				calcData[i].fte_of_SE_P0 = 39925.5;
				calcData[i].multiDist_online_fte_of_SE_P0 = 167.;
				calcData[i].ascent_of_FTE = 117.0;
				calcData[i].csi_online_count = 0;
				calcData[i].funded_count_k_of_FTE = 73.0;
				calcData[i].free_lunch_1_8_of_SE_P0 = 11.0;
				calcData[i].csi_fl_1_8_count = 676;

				calcData[i].fte_of_SE_P0 = 1873.0;
				calcData[i].multiDist_online_fte_of_SE_P1 = 4831.5;
				calcData[i].cpp_of_SE_P1 = 274.0;
				calcData[i].out_of_district_of_SE_P1 = 0;

				calcData[i].fte_of_SE_P2 = 39925.5;
				calcData[i].multiDist_online_fte_of_SE_P2 = 4814.5;
				calcData[i].cpp_of_SE_P2 = 274.5;
				calcData[i].out_of_dist_of_FTE_P2 = 0;

				calcData[i].fte_of_SE_P3 = 39786.5;
				calcData[i].multiDist_online_fte_of_SE_P3 = 4671.0;
				calcData[i].cpp_of_SE_P3 = 271.0;

				calcData[i].fte_of_SE_P4 = 38663.0;
				calcData[i].multiDist_online_fte_of_SE_P4 = 4208.0;
				calcData[i].cpp_of_SE_P4 = 268.5;
				calcData[i].out_of_dist_of_FTE_P4 = 0;

				calcData[i].csi_kind_fte_count = 73.0;
				calcData[i].distNum_of_SE_P0 = 0020;
				
				calcData[i].sfd = new SizeFactorData();

				//calcData[i].aard = new AltAtRiskData();
				//calcData[i].ffd = new FundingFormulaData();
				//calcData[i].svd = new SE360VariablesData();

			} else if (CALC_DATA_SOURCE_DATABASE.equals(dataSource)) {
				List<StateEqual> stateEqualList = se360CalcManager
						.getStateEqualByDistrictAndYears(districtCode,
								fiscalYear, 4);
				long currentFiscalYear = new Integer(fiscalYear.substring(4)).longValue();

				if (stateEqualList != null && stateEqualList.size() >  0)
					mapStateEqualData(stateEqualList, calcData[i],currentFiscalYear);
				else {
					throw new DataException("No data found", new SQLException());
				}
				
				List<FteByGrade> fteByGradeList = se360CalcManager
						.getFteByGradeByDistrictAndYears(districtCode,
								fiscalYear, 4);
				mapFTEData(fteByGradeList, calcData[i], currentFiscalYear);

				MillLevy millLevy = se360CalcManager
						.getMillLevyByDistrictAndYear(districtCode, fiscalYear);
				mapMainYearMLData(millLevy, calcData[i]);

				Csi csi = se360CalcManager.getCsiByDistrictAndYear(
						districtCode, fiscalYear);
				mapMainYearCSIData(csi, calcData[i]);

			}
		}
		return calcData;

	}

	private static void mapOlderYearsSEData(StateEqual seData,
			SE360CalcData calcData, long stateEqualYear, long currentFiscalYear) {
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

	private static void mapPreviousYearSEData(StateEqual seData,
			SE360CalcData calcData) {
		calcData.setFte_of_SE_P1(seData.getFte());
		calcData.setCat_trans_of_SE_P1(seData.getCatTransportation());
		calcData.setCat_voced_of_SE_P1(seData.getCatVoced());
		calcData.setCat_elpa_of_SE_P1(seData.getCatElpa());
		calcData.setCat_sped_dis_of_SE_P1(seData.getCatSpedDisabilities());
		calcData.setCat_sped_gt_of_SE_P1(seData.getCatSpedGiftedTalented());
		calcData.setSmall_center_payments_of_SE_P1(seData.getSmallCenterPayments());
		calcData.setMultiDist_online_fte_of_SE_P1(seData.getMultiDistrictOnlineFte());
		calcData.setFpc_of_SE_P1(seData.getFundedPupilCount());
		calcData.setCpp_of_SE_P1(seData.getCpp());
		calcData.setMill_levy_adj_of_SE_P1(seData.getMillLevyAdj());
		calcData.setMill_levy_adj_of_SE_P1(seData.getCatLevyAdj());
		calcData.setMill_levy_calc_of_SE_P1(seData.getCalcTotalProgramMillLevy());
		calcData.setCat_levy_calc_of_SE_P1(seData.getCalcCatBuyMillLevy());
		

	}

	private static void mapStateEqualData(List<StateEqual> stateEqualList,	SE360CalcData calcData, long currentFiscalYear) {
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
		calcData.setFte_of_SE_P0(seData.getFte());
		calcData.setEsl_cap_of_SE_P0(seData.getEslCsap());
		calcData.setFree_lunch_1_8_of_SE_P0(seData.getFreeLunch18());
		calcData.setFree_lunch_k_12_of_SE_P0(seData.getFreeLunchK12());
		calcData.setMultiDist_online_fte_of_SE_P0(seData
				.getMultiDistrictOnlineFte());
		calcData.setMember_k_12_of_SE_P0(seData.getMemberK12());
		calcData.setCharter_school_fpc_of_SE_P0(seData.getCharterSchoolFpc());
		calcData.setCpp_of_SE_P0(seData.getCpp());
		calcData.setSpeced_pk_of_SE_P0(seData.getSpecedPk());
		calcData.setDist_chrtr_fte_count_of_SE_P0(seData
				.getDistrictCharterFteCount());
		calcData.setMember_1_8_of_SE_P0(seData.getMember18());
		calcData.setCol_factor_of_SE_P0(seData.getCostOfLivingFactor());
		calcData.setSot_net_of_SE_P0(seData.getSotNet());
		calcData.setAllow_spend_of_SE_P0(seData.getAllowSpend());
		calcData.setDist_cert_total_add_fund_of_SE_P0(seData
				.getDistrictCertTotalAddFund());
		calcData.setCat_trans_of_SE_P0(seData.getCatTransportation());
		calcData.setCat_voced_of_SE_P0(seData.getCatVoced());
		calcData.setCat_elpa_of_SE_P0(seData.getCatElpa());
		calcData.setCat_sped_dis_of_SE_P0(seData.getCatSpedDisabilities());
		calcData.setCat_sped_gt_of_SE_P0(seData.getCatSpedGiftedTalented());
		calcData.setSmall_center_payments_of_SE_P0(seData
				.getSmallCenterPayments());
		calcData.setNeg_factor_of_SE_P0(seData.getNegFactor());
		calcData.setTotal_program_cat_buyout_of_SE_P0(seData
				.getTotalProgramCatBuyout());
		calcData.setCsi_total_program_fund_of_SE_P0(seData
				.getCsiTotalProgramFund());
		calcData.setAssessed_val_of_SE_P0(seData.getAssessedVal());

	}

	private static void mapMainYearMLData(MillLevy mlData,
			SE360CalcData calcData) {
		calcData.setVoter_approved_override_of_ML(mlData.getVoterApprovedOverride());
		calcData.setCalculated_tp_of_ML(mlData.getCalculatedTpMillLevy());
	}

	private static void mapMainYearCSIData(Csi csiData, SE360CalcData calcData) {
		calcData.setCsi_fl_1_8_count(csiData.getCsiFl18Cnt());
		calcData.setCsi_fl_k_12_count(csiData.getCsiFlK12Cnt());
		calcData.setCsi_k_12_fte_count(csiData.getCsiK12FteCnt());
		calcData.setCsi_kind_fte_count(csiData.getCsiKindFteCnt());
		calcData.setCsi_mem_1_8_count(csiData.getCsiMem18Cnt());
		calcData.setCsi_mem_k_12_count(csiData.getCsiMemK12Cnt());

	}

	private static void mapFTEData(List<FteByGrade> fteDataList,
			SE360CalcData calcData, long fiscalYear) {
		for (FteByGrade fteData : fteDataList) {
			long fteFiscalYear = new Integer(fteData.getFiscalYear().substring(
					4)).longValue();
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
