package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SEMinmFormulaFundingProcessor {

	private static final Logger logger = Logger.getLogger(SEMinmFormulaFundingProcessor.class);
	
	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/decisonmodels/SE360MinmFormulaDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			decision.put("response",response);
			
			calcData[i].ruleName = "MF1-E";
			decision.execute();
			calcData[i].mfd.setMf1_e(response.getRuleResult());
			logger.debug( "MF1-E" +   calcData[i].mfd.getMf1_e());
			
			calcData[i].ruleName = "MF2-E";
			decision.execute();
			calcData[i].mfd.setMf2_e(response.getRuleResult());
			logger.debug( "MF2-E" +   calcData[i].mfd.getMf2_e());
			
			calcData[i].ruleName = "MF3-E";
			decision.execute();
			calcData[i].mfd.setMf3_e(response.getRuleResult());
			logger.debug( "MF3-E" +   calcData[i].mfd.getMf3_e());
			
			calcData[i].ruleName = "MF4-E";
			decision.execute();
			calcData[i].mfd.setMf4_e(response.getRuleResult());
			logger.debug( "MF4-E" +   calcData[i].mfd.getMf4_e());
			
			calcData[i].ruleName = "MF5-E";
			decision.execute();
			calcData[i].mfd.setMf5_e(response.getRuleResult());
			logger.debug( "MF5-E" +   calcData[i].mfd.getMf5_e());
			
			
			System.out.println("--------- SEMinmFormulaFundingProcessor DONE----------");
		}
		
	}
	
		 
}
