package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SEGrandTotaProgramFundingProcessor {

	private static final Logger logger = Logger.getLogger(SEGrandTotaProgramFundingProcessor.class);
	
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
			
			seData[i].ruleName = "GT1-E";
			decision.execute();
			seData[i].gtfd.setGt1_e(response.getRuleResult());
			logger.debug( "GT1-E" +   seData[i].gtfd.getGt1_e());
			
			seData[i].ruleName = "GT2-E";
			decision.execute();
			seData[i].gtfd.setGt1_e(response.getRuleResult());
			logger.debug( "GT2-E" +   seData[i].gtfd.getGt2_e());
			
			seData[i].ruleName = "GT3-E";
			decision.execute();
			seData[i].gtfd.setGt1_e(response.getRuleResult());
			logger.debug( "GT3-E" +   seData[i].gtfd.getGt3_e());
			
			seData[i].ruleName = "GT4-E";
			decision.execute();
			seData[i].gtfd.setGt4_e(response.getRuleResult());
			logger.debug( "GT4-E" +   seData[i].gtfd.getGt4_e());
			
			seData[i].ruleName = "GT5-E";
			decision.execute();
			seData[i].gtfd.setGt5_e(response.getRuleResult());
			logger.debug( "GT5-E" +   seData[i].gtfd.getGt5_e());
			
			seData[i].ruleName = "GT6-E";
			decision.execute();
			seData[i].gtfd.setGt6_e(response.getRuleResult());
			logger.debug( "GT6-E" +   seData[i].gtfd.getGt6_e());
			
			
			
			seData[i].ruleName = "GT7-E";
			decision.execute();
			seData[i].gtfd.setGt6_e(response.getRuleResult());
			logger.debug( "GT6-E" +   seData[i].gtfd.getGt6_e());
			
			seData[i].ruleName = "GT71-E";
			decision.execute();
			seData[i].gtfd.setGt71_e(response.getRuleResult());
			logger.debug( "GT71-E" +   seData[i].gtfd.getGt71_e());
			
			
			seData[i].ruleName = "GT72-E";
			decision.execute();
			seData[i].gtfd.setGt71_e(response.getRuleResult());
			logger.debug( "GT72-E" +   seData[i].gtfd.getGt72_e());
			
			seData[i].ruleName = "GT73-E";
			decision.execute();
			seData[i].gtfd.setGt73_e(response.getRuleResult());
			logger.debug( "GT73-E" +   seData[i].gtfd.getGt73_e());
			
			seData[i].ruleName = "GT74-E";
			decision.execute();
			seData[i].gtfd.setGt74_e(response.getRuleResult());
			logger.debug( "GT74-E" +   seData[i].gtfd.getGt74_e());
			
			seData[i].ruleName = "GT75-E";
			decision.execute();
			seData[i].gtfd.setGt71_e(response.getRuleResult());
			logger.debug( "GT75-E" +   seData[i].gtfd.getGt75_e());
			
			seData[i].ruleName = "GT76-E";
			decision.execute();
			seData[i].gtfd.setGt76_e(response.getRuleResult());
			logger.debug( "GT76-E" +   seData[i].gtfd.getGt76_e());
			
						
			
			System.out.println("---------DONE----------");
		}
		
	}
	
		 
}
