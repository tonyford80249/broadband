package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SEPupilFundingProcessor {

	private static final Logger logger = Logger.getLogger(SEPupilFundingProcessor.class);
	
	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/decisonmodels/SE360PupilRulesDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			decision.put("response",response);
			
				
			calcData[i].pfd.setPp1_e(calcData[i].ws_var_21_base_fund_1);
			calcData[i].pfd.setPp2_e(calcData[i].pfd.getI199_e());
			calcData[i].pfd.setPp3_e(calcData[i].getCol_factor_of_SE_P0());
			calcData[i].pfd.setPp4_e(calcData[i].pfd.getPp1_e());
			calcData[i].pfd.setPp5_e(1 - calcData[i].pfd.getI199_e());
			calcData[i].pfd.setPp6_e(calcData[i].getGe201_e());
			
			calcData[i].ruleName = "PP7-1A-E";
			decision.execute();
			calcData[i].pfd.setPp7_1_e(response.getRuleResult());
			
			calcData[i].ruleName = "PP7-1B-E";
			decision.execute();
			calcData[i].pfd.setPp7_1_e(Util.round(response.getRuleResult(), 2));
			
			calcData[i].ruleName = "PP7-1C-E";
			decision.execute();
			calcData[i].pfd.setPp7_e(Util.round(response.getRuleResult(), 2));
			calcData[i].setFm_pump_fund_pp7(calcData[i].pfd.getPp7_e());
			
			logger.debug("DIS-PP8-1" + calcData[i].pfd.getPp7_e());
			
				calcData[i].ruleName = "PP9-E";
			decision.execute();
			calcData[i].pfd.setPp9_e(Util.round(response.getRuleResult(), 2));
			
			
			logger.debug("---------DONE----------");
		}
		
	}
	
	
		 
}
