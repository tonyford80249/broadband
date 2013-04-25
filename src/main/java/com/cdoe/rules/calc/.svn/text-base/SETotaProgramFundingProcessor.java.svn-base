package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SETotaProgramFundingProcessor {

	private static final Logger logger = Logger.getLogger(SETotaProgramFundingProcessor.class);
	
	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/decisonmodels/SE360TotalProgramFundingDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = null;
		
		try  {
			engine = new OpenRulesEngine(fileName);
			logger.debug(" Rules File found on the server itself" + fileName);
		} catch (Exception e) {
			
			logger.debug(" File not found" + fileName + e.getMessage());
			fileName = "file:C:/project/newequal/cdoe/src/main/webapp/WEB-INF/rules/main/decisonmodels/SE360TotalProgramFundingDecisionModel.xls";
			logger.debug("Going for local file");
		}
		
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			decision.put("response",response);
			
			calcData[i].ruleName = "TP1-E";
			decision.execute();
			calcData[i].tpfd.setTp1_e(response.getRuleResult());
			logger.debug( "TP1-E" +   calcData[i].tpfd.getTp1_e());
			
			calcData[i].ruleName = "TP2-E";
			decision.execute();
			calcData[i].tpfd.setTp2_e(response.getRuleResult());
			logger.debug( "TP2-E" +   calcData[i].tpfd.getTp2_e());
			
			calcData[i].ruleName = "TP3-E";
			decision.execute();
			calcData[i].tpfd.setTp2_e(response.getRuleResult());
			logger.debug( "TP3-E" +  calcData[i].tpfd.getTp3_e());
			
		
			System.out.println("---------DONE----------");
		}
		
	}
	
		 
}
