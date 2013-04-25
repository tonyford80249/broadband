package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SEMillLevyProcessor {
	
	private static final Logger logger = Logger.getLogger(SEMillLevyProcessor.class);
	


	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/decisonmodels/SE360MillLevyDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			decision.put("response",response);
			
			
			Object[] objects = new Object[] {calcData[i], response};
			((RulesResponse) engine.run("ruleMillCat_0", objects)).getRuleResult();
			
			calcData[i].ruleName = "ML1";
			decision.execute();
			calcData[i].mld.setMl1_e(Util.round(response.getRuleResult(), 6));
			logger.debug("ML1" + calcData[i].mld.getMl1_e());
			
			calcData[i].ruleName = "ML2";
			decision.execute();
			calcData[i].mld.setMl2_e(Util.round(response.getRuleResult(), 6));
			logger.debug("ML1" + calcData[i].mld.getMl2_e());
			
			calcData[i].ruleName = "ML3";
			decision.execute();
			calcData[i].mld.setMl1_e(Util.round(response.getRuleResult(), 6));
			logger.debug("ML3" + calcData[i].mld.getMl3_e());
			
			objects = new Object[] {calcData[i], response};
			((RulesResponse) engine.run("ruleMl4_e", objects)).getRuleResult();
		
			
			calcData[i].ruleName = "ML5";
			decision.execute();
			calcData[i].mld.setMl5_e(Util.round(response.getRuleResult(), 6));
			logger.debug("ML5" + calcData[i].mld.getMl5_e());
			
			objects = new Object[] {calcData[i], response};
			((RulesResponse) engine.run("ruleMl6_e", objects)).getRuleResult();
			
		
			
			System.out.println("---------DONE----------");
		}
		
	}
	
	
	
		 
}
