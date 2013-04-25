package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SEProgFundingForChrtrInstProcessor {

	private static final Logger logger = Logger.getLogger(SEProgFundingForChrtrInstProcessor.class);
	
	public static void process(SE360CalcData[] seData ) {
		String fileName = "file:rules/main/decisonmodels/SE360GTProgramFundingDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < seData.length; i++) {
			decision.put("stateEqualCalcData",seData[i]);
			System.out.println("Calc Data: " + i + "\n" + seData[i].toString());
			RulesResponse response = new RulesResponse();
			decision.put("response",response);
			
			seData[i].ruleName = "GT8-E";
			decision.execute();
			seData[i].gtfd.setGt8_e(response.getRuleResult());
			logger.debug( "GT8-E" +   seData[i].gtfd.getGt8_e());
			
			seData[i].ruleName = "GT9-E";
			decision.execute();
			seData[i].gtfd.setGt9_e(response.getRuleResult());
			logger.debug( "GT9-E" +   seData[i].gtfd.getGt9_e());
			
			seData[i].ruleName = "GT10-E";
			decision.execute();
			seData[i].gtfd.setGt10_e(response.getRuleResult());
			logger.debug( "GT10-E" +   seData[i].gtfd.getGt10_e());
			
			seData[i].ruleName = "GT11-E";
			decision.execute();
			seData[i].gtfd.setGt11_e(response.getRuleResult());
			logger.debug( "GT11-E" +   seData[i].gtfd.getGt11_e());
			
			seData[i].ruleName = "GT11-E";
			decision.execute();
			seData[i].gtfd.setGt11_e(response.getRuleResult());
			logger.debug( "GT11-E" +   seData[i].gtfd.getGt11_e());
			
			seData[i].ruleName = "GT12-E";
			decision.execute();
			seData[i].gtfd.setGt12_e(response.getRuleResult());
			logger.debug( "GT12-E" +   seData[i].gtfd.getGt12_e());
			
			seData[i].ruleName = "GT13-E";
			decision.execute();
			seData[i].gtfd.setGt13_e(response.getRuleResult());
			logger.debug( "GT13-E" +   seData[i].gtfd.getGt13_e());
			
			
			seData[i].ruleName = "GT14-E";
			decision.execute();
			seData[i].gtfd.setGt14_e(response.getRuleResult());
			logger.debug( "GT14-E" +   seData[i].gtfd.getGt14_e());
			

			
			System.out.println("---------DONE----------");
		}
		
	}
	
		 
}
