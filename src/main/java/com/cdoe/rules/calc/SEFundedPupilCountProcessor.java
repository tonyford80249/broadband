package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SEFundedPupilCountProcessor {

	private static final Logger logger = Logger.getLogger(SEFundedPupilCountProcessor.class);

	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/decisonmodels/SE360FpcDecisionModel.xls";
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
		decision.put("trace", "On");
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			decision.put("response",response);
			decision.put("trace", "Off");
			
			calcData[i].ruleName = "FC1-E";
			decision.execute();
			calcData[i].fpcd.setFc1_e(response.getRuleResult());
			//calcData[i].fpcd.setFc1_e(Util.round(response.getRuleResult(), 1));
			response.toString();
			
			calcData[i].ruleName = "FC2-E";
			decision.execute();
			calcData[i].fpcd.setFc2_e(response.getRuleResult());
			response.toString();
			
			calcData[i].ruleName = "FC3-E";
			decision.execute();
			calcData[i].fpcd.setFc3_e(response.getRuleResult());
			response.toString();
			
			Object[] objects = new Object[] {calcData[i], response};
			calcData[i].fpcd.setFc4_e(((RulesResponse) engine.run("rule_fc4_e", objects)).getRuleResult());
			
			
			
			calcData[i].ruleName = "FC41-E";
			decision.execute();
			calcData[i].fpcd.setFc41_e(response.getRuleResult());
			response.toString();
		
			objects = new Object[] {calcData[i], response};
			calcData[i].fpcd.setFc5_e(((RulesResponse) engine.run("rulefc5_0", objects)).getRuleResult());
			
			
			calcData[i].ruleName = "FC51-E";
			decision.execute();
			calcData[i].fpcd.setFc51_e(Util.round(response.getRuleResult(), 1));
			response.toString();
			
			calcData[i].ruleName = "FC6-E";
			decision.execute();
			calcData[i].fpcd.setFc6_e(response.getRuleResult());
			response.toString();
		
			calcData[i].ruleName = "FC61-E";
			decision.execute();
			calcData[i].fpcd.setFc61_e(response.getRuleResult());
			response.toString();
			
			calcData[i].ruleName = "FC65-E";
			decision.execute();
			calcData[i].fpcd.setFc65_e(response.getRuleResult());
			response.toString();
			
			calcData[i].ruleName = "FC66-E";
			decision.execute();
			calcData[i].fpcd.setFc66_e(Util.round(response.getRuleResult(), 1));
			response.toString();
			

			calcData[i].ruleName = "FC7-E";
			decision.execute();
			calcData[i].fpcd.setFc7_e(Util.round(response.getRuleResult(), 1));
			response.toString();
			
			calcData[i].ruleName = "FC75-E";
			decision.execute();
			calcData[i].fpcd.setFc75_e(response.getRuleResult());
			response.toString();
			
			calcData[i].ruleName = "FC8-E";
			decision.execute();
			calcData[i].fpcd.setFc8_e(response.getRuleResult());
			response.toString();
			
			calcData[i].ruleName = "FC85-E";
			decision.execute();
			calcData[i].fpcd.setFc85_e(response.getRuleResult());
			response.toString();
			
			calcData[i].ruleName = "FC9-E";
			decision.execute();
			calcData[i].fpcd.setFc9_e(Util.round(response.getRuleResult(), 1));
			response.toString();
			
			calcData[i].ruleName = "FC10-E";
			decision.execute();
			calcData[i].fpcd.setFc10_e(Util.round(response.getRuleResult(), 1));
			response.toString();
			
			calcData[i].ruleName = "FC11-E";
			decision.execute();
			calcData[i].fpcd.setFc11_e(Util.round(response.getRuleResult(), 1));
			response.toString();
			
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			
			System.out.println("---------DONE----------");
		}
		
	}
	
	
	
		 
}
