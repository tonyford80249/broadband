package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SETotalFormulaFundingProcessor {

	private static final Logger logger = Logger.getLogger(ReferenceDataManager.class);
	
	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/decisonmodels/SE360TotalFormulaFundingDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			
			calcData[i].ruleName = "TF1-E";
			decision.execute();
			calcData[i].tffd.setTf1_e(response.getRuleResult());
			logger.debug( "TF1-E" +   calcData[i].tffd.getTf1_e());
			
			calcData[i].ruleName = "TF2-E";
			decision.execute();
			calcData[i].tffd.setTf2_e(response.getRuleResult());
			logger.debug( "TF2-E" +   calcData[i].tffd.getTf2_e());
			
			calcData[i].ruleName = "TF3-E";
			decision.execute();
			calcData[i].tffd.setTf3_e(response.getRuleResult());
			logger.debug( "TF3-E" +   calcData[i].tffd.getTf3_e());
			
			calcData[i].ruleName = "TF4-E";
			decision.execute();
			calcData[i].tffd.setTf4_e(response.getRuleResult());;
			logger.debug( "TF4-E" +   calcData[i].tffd.getTf4_e());
			
			calcData[i].ruleName = "TF5-E";
			decision.execute();
			calcData[i].tffd.setTf5_e(response.getRuleResult());;
			logger.debug( "TF5-E" +   calcData[i].tffd.getTf5_e());
			
			calcData[i].ruleName = "TF6-E";
			decision.execute();
			calcData[i].tffd.setTf6_e(response.getRuleResult());;
			logger.debug( "TF6-E" +   calcData[i].tffd.getTf6_e());
			
			Object[] objects = new Object[] {calcData[i], response};
			calcData[i].tffd.setTf7_e(((RulesResponse) engine.run("ruleTf7_0", objects)).getRuleResult());
		
			/*calcData[i].ruleName = "TF7-E";
			decision.execute();
			calcData[i].tffd.setT1_e(response.getRuleResult());
			logger.debug( "TF7-E" +   calcData[i].tffd.getTf7_e());*/
			
			objects = new Object[] {calcData[i], response};
			calcData[i].tffd.setTf8_e(((RulesResponse) engine.run("ruleTf8_0", objects)).getRuleResult());
		
			
			/*calcData[i].ruleName = "TF8-E";
			decision.execute();
			calcData[i].tffd.setTf2_e(response.getRuleResult());
			logger.debug( "TF8-E" +   calcData[i].tffd.getTf8_e());*/
			
			calcData[i].ruleName = "TF9-E";
			decision.execute();
			calcData[i].tffd.setTf9_e(response.getRuleResult());
			logger.debug( "TF9-E" +   calcData[i].tffd.getTf9_e());
			
			calcData[i].ruleName = "TF10-E";
			decision.execute();
			calcData[i].tffd.setTf10_e(response.getRuleResult());;
			logger.debug( "TF10-E" +   calcData[i].tffd.getTf10_e());
			
			
			objects = new Object[] {calcData[i], response};
			calcData[i].tffd.setTf11_e(((RulesResponse) engine.run("ruleTf11_0", objects)).getRuleResult());
		
			
			/*calcData[i].ruleName = "TF11-E";
			decision.execute();
			calcData[i].tffd.setTf11_e(response.getRuleResult());;
			logger.debug( "TF11-E" +   calcData[i].tffd.getTf11_e());
			*/
			
			calcData[i].ruleName = "TF12-E";
			decision.execute();
			calcData[i].tffd.setTf12_e(response.getRuleResult());;
			logger.debug( "TF12-E" +   calcData[i].tffd.getTf12_e());
			//response.toString();
			
			System.out.println("---------DONE----------");
		}
		
	}
	
		 
}
