package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class TotalPropTaxMillLevyProcessor {

	private static final Logger logger = Logger.getLogger(TotalPropTaxMillLevyProcessor.class);
	
	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/decisonmodels/SE360MillLevyDecisionModel.xls";
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			
			calcData[i].ruleName = "TM1-E";
			decision.execute();
			calcData[i].mld.setTm1_e(response.getRuleResult());
			logger.debug( "TM1-E" +   calcData[i].mld.getTm1_e());
			
			calcData[i].ruleName = "TM2-E";
			decision.execute();
			calcData[i].mld.setTm2_e(response.getRuleResult());
			logger.debug( "TM2-E" +   calcData[i].mld.getTm2_e());
			
			calcData[i].ruleName = "TM3-E";
			decision.execute();
			calcData[i].mld.setTm3_e(response.getRuleResult());
			
			logger.debug( "TM3-E" +   calcData[i].mld.getTm3_e());
			
			if (calcData[i].mld.getTm3_e() < 0 )
				calcData[i].mld.setTm3_e(0);
			
			calcData[i].ruleName = "TM4-E";
			decision.execute();
			calcData[i].mld.setTm4_e(response.getRuleResult());
			logger.debug( "TM4-E" +   calcData[i].mld.getTm4_e());
			
			if (calcData[i].mld.getTm4_e() < 0 )
				calcData[i].mld.setTm4_e(0);
			
			calcData[i].ruleName = "TM5-E";
			decision.execute();
			calcData[i].mld.setTm5_e(response.getRuleResult());
			logger.debug( "TM5-E" +   calcData[i].mld.getTm5_e());
			
			calcData[i].ruleName = "TM6-E";
			decision.execute();
			calcData[i].mld.setTm1_e(response.getRuleResult());
			logger.debug( "TM6-E" +   calcData[i].mld.getTm1_e());
			//response.toString();
			
			System.out.println("---------DONE----------");
		}
		
	}
	
		 
}
