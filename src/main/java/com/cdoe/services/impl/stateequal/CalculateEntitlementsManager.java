package com.cdoe.services.impl.stateequal;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.exception.DataException;

import com.cdoe.biz.constants.SEConstants;
import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.stateequal.ICSICalculationsDAO;
import com.cdoe.biz.stateequal.IMillLevyDAO;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.rules.calc.EntitlementsProcessor;
import com.cdoe.rules.calc.SE360CalcData;
import com.cdoe.rules.calc.SE360CalcProcessor;
import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.ICalculateEntitlementsManager;
import com.cdoe.ui.form.stateequal.CalculateEntitlementsForm;

public class CalculateEntitlementsManager extends BaseManager implements
		ICalculateEntitlementsManager {

	private static final Logger LOGGER = Logger
			.getLogger(CalculateEntitlementsManager.class);
	private IReferenceDataManager referenceDataManager;
	private SE360CalcProcessor se360CalcProcessor;
	private EntitlementsProcessor entitlementsProcessor;

	private IStateEqualDAO stateEqualDAO;
	private IMillLevyDAO millLevyDAO;
	private ICSICalculationsDAO csiDao;

	/* Injector methods */

	public void setCsiDao(ICSICalculationsDAO csiDao) {
		this.csiDao = csiDao;
	}

	/**
	 * @param stateEqualDAO
	 */
	public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
		this.stateEqualDAO = stateEqualDAO;
	}

	/**
	 * 
	 * @param referenceDataManager
	 */
	public void setMillLevyDAO(IMillLevyDAO millLevyDAO) {
		this.millLevyDAO = millLevyDAO;
	}

	/*
	 * @param referenceDataManager
	 */
	public void setReferenceDataManager(
			IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}

	/**
	 * @param se360CalcProcessor
	 */
	public void setSe360CalcProcessor(SE360CalcProcessor se360CalcProcessor) {
		this.se360CalcProcessor = se360CalcProcessor;
	}
	
	/**
	 * @param se360CalcProcessor
	 */
	public void setEntitlementsProcessor(EntitlementsProcessor entitlementsProcessor) {
		this.entitlementsProcessor = entitlementsProcessor;
	}

	/* End of Injector methods */

	public void saveOrUpdate(SE360CalcData StateEqualCalcData) {
		saveOrUpdate(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cdoe.services.stateequal.ICalculateEntitlementsManager#
	 * calculateEntitlements
	 * (com.cdoe.ui.form.stateequal.CalculateEntitlementsForm)
	 */
	// This program should only be run after the data for the current Fiscal
	// year has been created
	// and Upload variables had been done
	public void calculateEntitlements(CalculateEntitlementsForm entitlementsForm) {
		if ("Monthly: July - November".equals(entitlementsForm
				.getCalculationType())) {
			calculateEntitlementsJulyToNovember(entitlementsForm);

		} else if ("Mid-Year: December".equals(entitlementsForm
				.getCalculationType())) {

		} else if ("January".equals(entitlementsForm.getCalculationType())) {

		} else if ("Monthly: February - May".equals(entitlementsForm
				.getCalculationType())) {

		} else if ("End of Year Closeout - June".equals(entitlementsForm
				.getCalculationType())) {

		}

	}

	private String calculateEntitlementsJulyToNovember(
			CalculateEntitlementsForm entitlementsForm) {
		String response = "CALC_BEGIN";
		entitlementsProcessor.processEntitlement(entitlementsForm.getFiscalMonth(), 
												entitlementsForm.getFiscalYear(),
												SEConstants.DATABASE_DATA_SOURCE);
		return response;
	}

	public void processStateAverageFreeLunch(String fiscalYear) {
		
		entitlementsProcessor.processEntitlement("January", fiscalYear, "Database");
		/*(Map<String, String> districtMap = referenceDataManager.getAllOrganizationsMap();
		Set<String> districtKeys = districtMap.keySet();
		for (String districtCode : districtKeys) {
			StateEqual stateEqual = stateEqualDAO.findLatest(districtCode, fiscalYear);	
			List<Csi> csiList = csiDao.getByDistrictAndYear(districtCode, fiscalYear);
			Csi csi = null;
			if (csiList != null) {
				csi  = csiList.get(0);
			}
			//csi.getCsiMemK12Cnt()
			//put the data
		}*/
		
		
	}

	void invokeSEYY100P(String fiscalYear) {

	}

	public void invoke360CalcForAllDistricts(String fiscalYear,
			String fiscalMonth) throws Exception {
		// Get the list of districts
		// For each district setup the data
		// then invoke the 360 calculations for each
		// persist the result of the calculation
		Set<String> districtCodes = referenceDataManager.getAllOrganizationsMap().keySet();
		Iterator<String> districtCodeIter = districtCodes.iterator();
		while (districtCodeIter.hasNext()) {
			SE360CalcData[] calcData = null;
			String districtCode = districtCodeIter.next();
			try {
				calcData = se360CalcProcessor.invoke360Calculation(
						districtCode, fiscalYear, "Database");
			} catch (DataException de) {
				throw new Exception("Cound not get Data");
			}
			saveUpdateStateEqual(districtCode, fiscalYear, fiscalMonth,
					calcData[0]);
			saveUpdateMillLevy(districtCode, fiscalYear, fiscalMonth,
					calcData[0]);
		}
	}

	/*
	 * Saves or Updates the StateEqual data from the 360 Calculations.
	 */
	public void saveUpdateStateEqual(String districtCode, String fiscalYear,
			String fiscalMonth, SE360CalcData seCalcData) {
		StateEqual stateEqualObj = stateEqualDAO.findLatestByYearMonth(
				districtCode, fiscalYear, fiscalMonth);
		if (stateEqualObj == null) {
			stateEqualObj = new StateEqual();
		}
		stateEqualObj.setCalcCatBuyMillLevy(seCalcData
				.getTotal_program_cat_buyout_of_SE_P0());
		stateEqualObj.setCalcTotalProgramMillLevy(seCalcData
				.getCalc_total_program_ml_of_SE_P0());
		stateEqualObj.setSotNet(seCalcData.getSot_net_of_SE_P0());
		stateEqualObj.setSotGross(seCalcData.getSot_gross_of_SE_P0());
		stateEqualObj.setStateEqual(seCalcData.getState_equal_of_SE_P0());
		stateEqualObj.setTotalAddFund(seCalcData.getTotal_add_fund_of_SE());
		stateEqualObj.setTotalAtRiskFunding(seCalcData
				.getTotal_at_risk_funding_of_SE());
		stateEqualObj.setMinimumFormulaFund(seCalcData
				.getMin_formula_fund_of_SE());
		stateEqualObj.setFormulaTpWoAtRisk(seCalcData
				.getFormula_tp_wo_at_risk_of_SE());
		stateEqualObj.setTotalFundIncludingOnline(seCalcData
				.getTotal_fund_including_online_of_SE());
		stateEqualObj.setTotalMaxFund(seCalcData.getTotal_max_fund_of_SE());
		stateEqualObj.setTotalProgramTabor(seCalcData
				.getTotal_program_tabor_of_SE());
		stateEqualObj.setPersonnelCostFactor(seCalcData
				.getPersonnel_cost_factor_of_SE());
		stateEqualObj.setMonthEntitle(seCalcData.getMonthlyEntitlement_of_SE());
		// stateEqualObj.setMonthPayment(fiscalMonth);
		stateEqualObj.setFiscalYear(fiscalYear);
		stateEqualObj.setDistrictNumber(districtCode);

		stateEqualDAO.saveOrUpdate(stateEqualObj);

	}

	/*
	 * Saves or Updates the Mill Levy data from the 360 Calculations.
	 */
	public void saveUpdateMillLevy(String districtCode, String fiscalYear,
			String fiscalMonth, SE360CalcData seCalcData) {
		MillLevy millLevy = millLevyDAO.findByDistrictAndYear(districtCode,
				fiscalYear);
		if (millLevy == null) {
			millLevy = new MillLevy();
		}
		millLevy.setCalculatedHhMillLevy(seCalcData.getCalculated_hh_of_ML());
		millLevy.setCalculatedOverrideMillLevy(seCalcData
				.getCalculated_override_of_ML());
		millLevy.setVoterApprovedOverride(seCalcData
				.getVoter_approved_override_of_ML());
		millLevy.setCalculatedCatbuyMillLevy(seCalcData
				.getCalculated_catbuy_of_ML());
		millLevyDAO.saveOrUpdate(millLevy);
	}
	
	private void calculateMonthlyEntitlement(int monthNos, SE360CalcData seCalcData) {
		double monthlyEntitlement = 0.0;
		
		switch(monthNos) {
			case 7: monthlyEntitlement = seCalcData.getState_equal_of_SE_P0()/12;
			        break;
			case 12: monthlyEntitlement = seCalcData.getState_equal_of_SE_P0()/2 - seCalcData.getYtdEntitlement_of_SE();
	        		break;
			case 1: monthlyEntitlement = (seCalcData.getState_equal_of_SE_P0() - seCalcData.getYtdEntitlement_of_SE())/6;
    				break;
			case 2: monthlyEntitlement = seCalcData.getState_equal_of_SE_P0()/5;
					break;
			case 3: monthlyEntitlement = seCalcData.getState_equal_of_SE_P0()/4;
					break;
			case 4:	monthlyEntitlement = seCalcData.getState_equal_of_SE_P0()/3;
				   break;
			case 5: monthlyEntitlement = seCalcData.getState_equal_of_SE_P0()/2;
					break;
			case 6: monthlyEntitlement = seCalcData.getState_equal_of_SE_P0() - seCalcData.getYtdEntitlement_of_SE();
    				break;

		}
		if (monthlyEntitlement <= 0 || (seCalcData.getState_equal_of_SE_P0() == 0)) {
			monthlyEntitlement = 0;
		}
		seCalcData.setMonthlyEntitlement_of_SE(monthlyEntitlement);
	}
	
	private double calculateYtdEntitlement(double monthlyEntitlement, SE360CalcData seCalcData) {
		
		 seCalcData.setYtdEntitlement_of_SE(monthlyEntitlement + seCalcData.getYtdEntitlement_of_SE());
		 return seCalcData.getYtdEntitlement_of_SE();
	}
	
	private void updateSEMonthly(long month, StateEqual seCalcData) {
		double monthlyEntitlement = 0.0;
		SeMonthly seMonthly = new SeMonthly();
		if (month == 7) {
			seMonthly.setEntitle(seCalcData.getMonthEntitle());
			seMonthly.setStateEqual(seCalcData.getStateEqual());
			seMonthly.setAssessedVal(seCalcData.getAssessedVal());
			seMonthly.setLunch18(seCalcData.getFreeLunch18());
			seMonthly.setlunchK12(seCalcData.getFreeLunchK12());
			seMonthly.setSpecOwnTax(seCalcData.getSotGross());
			
			double totalCatagories = seCalcData.getCatElpa() + 
									seCalcData.getCatTransportation() + 
									seCalcData.getCatVoced() + 
									seCalcData.getCatSpedDisabilities() + 
									seCalcData.getCatSpedGiftedTalented();
			
			seMonthly.setTotalCats(totalCatagories);
		
		}
		//This needs to be completed
		
	}
	
	public void processCSIDistrict() {
		
	}

}
