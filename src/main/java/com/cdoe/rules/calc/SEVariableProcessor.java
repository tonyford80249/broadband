package com.cdoe.rules.calc;

/* 
 * Developed by Sandeep Sarkar.
 */

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cdoe.rules.calc.RulesResponse;
import com.cdoe.services.impl.stateequal.DisplayAdjustmentManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;




public class SEVariableProcessor {
	
	private static final Logger logger = Logger.getLogger(DisplayAdjustmentManager.class);
	
	
	public static final String RULE_TYPE_DECISION = "Decision";
	public static final String RULE_TYPE_METHOD = "Method";
	public final int a = 0;
	
	
	public static void process(SE360CalcData[] calcData ) {
		
		String fileName = "file:rules/main/decisonmodels/SE360VariablesDecisionModel.xls";
		
		System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = null;
		
		try  {
			engine = new OpenRulesEngine(fileName);
			logger.debug(" Rules File found on the server itself" + fileName);
		} catch (Exception e) {
			
			logger.debug(" File not found" + fileName + e.getMessage());
			fileName = "file:C:/project/newequal/cdoe/src/main/webapp/WEB-INF/rules/main/decisonmodels/SE360VariablesDecisionModel.xls";
			logger.debug("Going for local file");
			engine = new OpenRulesEngine(fileName);
		}
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		
		decision.put("stateEqualCalcData",calcData[0]);
		logger.debug("______________Calc Data: " + 1 + "\n" + calcData[0].toString());
		RulesResponse response = new RulesResponse();
		decision.put("response",response);
	
		int i=0;
		
		calcData[i].ruleName = "VAR-1-ADJ-FTE-1";
		decision.execute();
		calcData[i].getSvd().var_1_adj_fte_1 = response.getRuleResult();
		
		//Util.round(response.getRuleResult(), 1);
		calcData[i].ruleName = "VAR-11-K-FTE-1";
		decision.execute();
		calcData[i].getSvd().var_11_k_fte_1 = response.getRuleResult();
		
		
		calcData[i].ruleName = "VAR-2-SPECED-1";
		decision.execute();
		calcData[i].getSvd().var_2_speced_pk = response.getRuleResult();
		
		
		
		calcData[i].ruleName = "VAR-3-FTE-1";
		decision.execute();
		calcData[i].getSvd().var_3_fte = response.getRuleResult();
	
		calcData[i].ruleName = "VAR-4-MULTIDIST-ONLINE-FTE";
		decision.execute();
		calcData[i].getSvd().var_4_multidist_online_fte = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-4-1-ASCENT";
		decision.execute();
		calcData[i].getSvd().var_4_1_ascent_1 = response.getRuleResult();
		
		
		calcData[i].ruleName = "VAR-5-FTE-1";
		decision.execute();
		calcData[i].getSvd().var_5_fte_1 = Util.round(response.getRuleResult(), 1);
		
		
		calcData[i].ruleName = "VAR-6-LUNCH-1-8-1";
		decision.execute();
		calcData[i].getSvd().var_6_lunch_1_8_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-7-LUNCH-K-12-1";
		decision.execute();
		calcData[i].getSvd().var_7_lunch_K_12_1 = response.getRuleResult();
		
		
		calcData[i].ruleName = "VAR-8-STAVG-1.1";
		decision.execute();
		calcData[i].getSvd().var_av3507_e = Util.round(response.getRuleResult(), 2);
		
		calcData[i].ruleName = "VAR-8-STAVG-1.2";
		decision.execute();
		calcData[i].getSvd().var_aw199_e = Util.round(response.getRuleResult(),2);
		
		calcData[i].ruleName = "VAR-8-STAVG-1.3";
		decision.execute();
		calcData[i].getSvd().var_aw200_e = response.getRuleResult();
		
		Object[] objects = new Object[] {calcData[i], response};
		calcData[i].getSvd().var_8_stavg_1 = ((RulesResponse) engine.run("rule_var8_stAvgFreeLunch", objects)).getRuleResult();
		
	
		calcData[i].ruleName = "VAR-9-OCT-MEM-1";
		decision.execute();
		calcData[i].getSvd().var_9_oct_mem_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-10-OCT-MEM-1";
		decision.execute();
		calcData[i].getSvd().var_10_oct_mem_1 = response.getRuleResult();
		calcData[i].getSvd().ws_var_10_oct_mem_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-11-CHRT-CNT11-1";
		decision.execute();
		calcData[i].getSvd().var_11_chrtr_countP0_1 = response.getRuleResult();
		
		
		calcData[i].ruleName = "VAR-12-P1-FPC-1";
		decision.execute();
		calcData[i].getSvd().var_12_P1_fpc_1 = response.getRuleResult();
		
		
		calcData[i].ruleName = "VAR-13-FTE-P1";
		decision.execute();
		calcData[i].getSvd().var_13_funded_countP1_1 = response.getRuleResult();
		
		
		calcData[i].ruleName = "VAR-14-FTE-P2";
		decision.execute();
		calcData[i].getSvd().var_14_funded_countP2_1= response.getRuleResult();
			
		calcData[i].ruleName = "VAR-151-FTE-P4";
		decision.execute();
		calcData[i].getSvd().var_151_funded_countP4_1 = response.getRuleResult();
		
		
		calcData[i].ruleName = "VAR-161-ONLINE-FTEP0-2";
		decision.execute();
		calcData[i].getSvd().var_161_online_fteP0_2 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-16-ONLINE-CNT02-1";
		decision.execute();
		calcData[i].getSvd().var_16_online_CNT02_1 = response.getRuleResult();
		
		
		calcData[i].ruleName = "VAR-17-CPP-1";
		decision.execute();
		calcData[i].getSvd().var_17_cpp_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-18-ESL-CSAP-1";
		decision.execute();
		calcData[i].getSvd().var_18_esl_csap_1 = response.getRuleResult();
		

		calcData[i].ruleName = "VAR-19-CSI-FTE-1";
		decision.execute();
		calcData[i].getSvd().var_19_csi_fte_1 = response.getRuleResult();
	

		calcData[i].ruleName = "VAR-191-CSI-K-FTE11-1";
		decision.execute();
		calcData[i].getSvd().var_191_k_csi_fte11_1 = response.getRuleResult();
	

		calcData[i].ruleName = "VAR-20-CSI-ONLINE-1";
		decision.execute();
		calcData[i].getSvd().var_20_csi_online_1 = response.getRuleResult();
	

		calcData[i].ruleName = "VAR-205-CSI-CPKP-1";
		decision.execute();
		calcData[i].getSvd().var_205_csi_cpkp_1 = response.getRuleResult();
	
		//Funding Elements

		calcData[i].ruleName = "VAR-21-BASE-FUND-1";
		decision.execute();
		calcData[i].getSvd().var_21_base_fund_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-22-MIN-FUND-1";
		decision.execute();
		calcData[i].getSvd().var_22_min_fund_1 = response.getRuleResult();
	
		calcData[i].ruleName = "VAR-225-ONLINE-1";
		decision.execute();
		calcData[i].getSvd().var_225_online_1 = response.getRuleResult();
	
		calcData[i].ruleName = "VAR-23-COST-LIVING-1";
		decision.execute();
		calcData[i].getSvd().var_23_cost_living_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-24-BASE-FACT-1";
		decision.execute();
		calcData[i].getSvd().var_24_base_fact_1 = response.getRuleResult();
	
		calcData[i].ruleName = "VAR-25-ATRISK-1";
		decision.execute();
		calcData[i].getSvd().var_25_atrisk_1 = response.getRuleResult();
	
		calcData[i].ruleName = "VAR-26-MIN-ST-AID-1";
		decision.execute();
		calcData[i].getSvd().var_26_min_st_aid_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-30-SPEC-TX-1";
		decision.execute();
		calcData[i].getSvd().var_30_spec_tax_1 = response.getRuleResult();
	
		calcData[i].ruleName = "VAR-31-ASSES-VAL-1";
		decision.execute();
		calcData[i].getSvd().var_31_assessed_val_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-32-LEVY-2010-1";
		decision.execute();
		calcData[i].getSvd().var_32_levy_2010_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-33-PROP-TX10-1";
		decision.execute();
		calcData[i].getSvd().var_33_prop_tx10_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-40-P1-TOT-PRG-1";
		decision.execute();
		calcData[i].getSvd().var_40_P1_tot_prg_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-41-10-TOT-PUP-1";
		decision.execute();
		calcData[i].getSvd().var_41_P1_tot_pup_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-42-10-XXX-XXX-1";
		decision.execute();
		calcData[i].getSvd().var_42_P1_xxx_xxx_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-43-MIN-PER-PUP-1";
		decision.execute();
		calcData[i].getSvd().var_43_min_per_pupil_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-44-97-TOT-PUP-1";
		decision.execute();
		calcData[i].getSvd().var_44_97_tot_pupil_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-50-CAT-TRANS-1";
		decision.execute();
		calcData[i].getSvd().var_50_cat_trans_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-51-CAT-VOCED-1";
		decision.execute();
		calcData[i].getSvd().var_51_cat_voced_1 = response.getRuleResult();
	
		calcData[i].ruleName = "VAR-52-CAT-ELPA-1";
		decision.execute();
		calcData[i].getSvd().var_52_cat_elpa_1 = response.getRuleResult();
	
		calcData[i].ruleName = "VAR-60-INF-P2-1";
		decision.execute();
		calcData[i].getSvd().var_60_inf_p2_1 = response.getRuleResult();
	
		
		calcData[i].ruleName = "VAR-52-CAT-ELPA-1";
		decision.execute();
		calcData[i].getSvd().var_61_inf_p3_1 = response.getRuleResult();
	
		calcData[i].ruleName = "VAR-62-ALLOW-SPEND-1";
		decision.execute();
		calcData[i].getSvd().var_62_allow_spend_1 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-63-ALLOW-SPEND-1";
		decision.execute();
		calcData[i].getSvd().tot_add_fund_63 = response.getRuleResult();
		
		calcData[i].ruleName = "VAR-64-ALLOW-SPEND-1";
		decision.execute();
		calcData[i].getSvd().var_64_1 = response.getRuleResult();
		
		if (calcData[i].getSvd().var_64_1 < 0)
			calcData[i].getSvd().var_64_1 = 0.0;
		
		objects = new Object[] {calcData[i], response};
	    calcData[i].getSvd().var_65_1 = ((RulesResponse) engine.run("rule_var_65_1", objects)).getRuleResult();
		
		
		//Util.round(response.getRuleResult(), 1);
	
		calcData[i].ruleName ="VAR-66-1";
		decision.execute();
		calcData[i].getSvd().var_66_1 = response.getRuleResult();
					
		logger.debug("Calc Data: " + 0 + "\n" + calcData[0].toString());
			
		logger.debug("---------DONE----------");

		
	}
	
	
	
	
		 
}

