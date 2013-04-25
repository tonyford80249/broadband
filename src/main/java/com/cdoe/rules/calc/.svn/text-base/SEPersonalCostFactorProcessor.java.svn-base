package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SEPersonalCostFactorProcessor {

	private static final Logger logger = Logger.getLogger(SEPersonalCostFactorProcessor.class);

	public static void process(SE360CalcData[] calcData ) {
		//This does not have a separate decision model. 
		String fileName = "file:rules/main/decisonmodels/SE360PupilRulesDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = null;
		
		try  {
			engine = new OpenRulesEngine(fileName);
			logger.debug(" Rules File found on the server itself" + fileName);
		} catch (Exception e) {
			
			logger.debug(" File not found" + fileName + e.getMessage());
			fileName = "file:C:/project/newequal/cdoe/src/main/webapp/WEB-INF/rules/main/decisonmodels/SE360PupilRulesDecisionModel.xls";
			logger.debug("Going for local file");
		}
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			
			Object[] objects = new Object[] {calcData[i], response};
			
			calcData[i].personnel_cost_factor_of_SE = ((RulesResponse) engine.run("rule_per_person_factor", objects)).getRuleResult();
			calcData[i].pfd.setI199_e(calcData[i].personnel_cost_factor_of_SE); 
			System.out.println("Calc Data: personnel_cost_factor_of_SE\n" + calcData[i].personnel_cost_factor_of_SE);
			System.out.println("---------DONE----------");
		}
		
	}
	
	 
}
