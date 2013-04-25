package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SEBeyondTaborFundingProcessor {

	private static final Logger logger = Logger.getLogger(SEBeyondTaborFundingProcessor.class);
	
	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/decisonmodels/SE360TaborAndBeyondDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			
			calcData[i].ruleName = "OL1-E";
			decision.execute();
			calcData[i].offd.setOl1_e(response.getRuleResult());
			logger.debug( "OL1-E" +   calcData[i].offd.getOl1_e());
			
			calcData[i].ruleName = "OL2-E";
			decision.execute();
			calcData[i].offd.setOl2_e( response.getRuleResult());
			logger.debug( "OL2-E" +   calcData[i].offd.getOl2_e());
			
			calcData[i].ruleName = "OL3-E";
			decision.execute();
			calcData[i].offd.setOl3_e( response.getRuleResult());
			logger.debug( "OL3-E" +   calcData[i].offd.getOl3_e());
			
			calcData[i].ruleName = "OL4-E";
			decision.execute();
			calcData[i].offd.setOl4_e( response.getRuleResult());
			logger.debug( "OL4-E" +   calcData[i].offd.getOl4_e());
			
			calcData[i].ruleName = "OL5-E";
			decision.execute();
			calcData[i].offd.setOl5_e( response.getRuleResult());
			logger.debug( "OL5-E" +   calcData[i].offd.getOl5_e());
			
			calcData[i].ruleName = "OL6-E";
			decision.execute();
			calcData[i].offd.setOl6_e( response.getRuleResult());
			logger.debug( "OL6-E" +   calcData[i].offd.getOl6_e());
			//response.toString();
			
			System.out.println("---------DONE----------");
		}
		
	}
	
		 
}
