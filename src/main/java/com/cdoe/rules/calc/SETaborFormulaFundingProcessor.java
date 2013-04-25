package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SETaborFormulaFundingProcessor {

	private static final Logger logger = Logger.getLogger(SETaborFormulaFundingProcessor.class);
	
	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/decisonmodels/SE360TaborAndBeyondDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = null;
		
		try  {
			engine = new OpenRulesEngine(fileName);
			logger.debug(" Rules File found on the server itself" + fileName);
		} catch (Exception e) {
			
			logger.debug(" File not found" + fileName + e.getMessage());
			fileName = "file:C:/project/newequal/cdoe/src/main/webapp/WEB-INF/rules/main/decisonmodels/SE360TaborAndBeyondDecisionModel.xls";
			logger.debug("Going for local file");
			engine = new OpenRulesEngine(fileName);
		}
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			decision.put("response",response);
			
			calcData[i].ruleName = "TB1-E";
			decision.execute();
			calcData[i].tbfd.tb1_e = response.getRuleResult();
			logger.debug( "TB1-E" +   calcData[i].tbfd.tb1_e);
			
			
			calcData[i].ruleName = "TB2-E";
			decision.execute();
			calcData[i].tbfd.tb2_e = response.getRuleResult();
			logger.debug( "TB2-E" +   calcData[i].tbfd.tb2_e);
			
			
			calcData[i].ruleName = "TB3-E";
			decision.execute();
			calcData[i].tbfd.tb3_e = response.getRuleResult();
			logger.debug( "TB3-E" +   calcData[i].tbfd.tb3_e);
			
			
			calcData[i].ruleName = "TB4-E";
			decision.execute();
			calcData[i].tbfd.tb4_e = response.getRuleResult();
			logger.debug( "TB4-E" +   calcData[i].tbfd.tb4_e);
			
			
			
			System.out.println("---------DONE----------");
		}
		
	}
	
		 
}
