package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SEOnlineFormulaFundingProcessor {

	private static final Logger logger = Logger.getLogger(SEOnlineFormulaFundingProcessor.class);
	
	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/decisonmodels/SE360OnlineFormulasDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = null;
		
		try  {
			engine = new OpenRulesEngine(fileName);
			logger.debug(" Rules File found on the server itself" + fileName);
		} catch (Exception e) {
			
			logger.debug(" File not found" + fileName + e.getMessage());
			fileName = "file:C:/project/newequal/cdoe/src/main/webapp/WEB-INF/rules/main/decisonmodels/SE360OnlineFormulasDecisionModel.xls";
			logger.debug("Going for local file");
			engine = new OpenRulesEngine(fileName);
		}
		
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			decision.put("response",response);
			
			calcData[i].ruleName = "OL1-E";
			decision.execute();
			calcData[i].offd.setOl1_e(response.getRuleResult());
			logger.debug( "OL1-E" +   calcData[i].offd.getOl1_e());
			
			calcData[i].ruleName = "OL2-E";
			decision.execute();
			calcData[i].offd.setOl2_e(response.getRuleResult());
			logger.debug( "OL2-E" +   calcData[i].offd.getOl2_e());
			
			calcData[i].ruleName = "OL3-E";
			decision.execute();
			calcData[i].offd.setOl3_e(response.getRuleResult());
			logger.debug( "OL3-E" +   calcData[i].offd.getOl3_e());
			
			calcData[i].ruleName = "OL4-E";
			decision.execute();
			calcData[i].offd.setOl4_e(response.getRuleResult());
			logger.debug( "OL4-E" +   calcData[i].offd.getOl4_e());
			
			calcData[i].ruleName = "OL5-E";
			decision.execute();
			calcData[i].offd.setOl5_e(response.getRuleResult());
			logger.debug( "OL5-E" +   calcData[i].offd.getOl5_e());
			
			calcData[i].ruleName = "OL6-E";
			decision.execute();
			calcData[i].offd.setOl6_e(response.getRuleResult());
			logger.debug( "OL6-E" +   calcData[i].offd.getOl6_e());
			//response.toString();
			
			System.out.println("---------DONE----------");
		}
		
	}
	
		 
}
