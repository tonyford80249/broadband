package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SEAltAtRiskCalcProcessor {

	private static final Logger logger = Logger.getLogger(SEAltAtRiskCalcProcessor.class);
	/*
	 * Processes the Alternate At Risk calculation
	 * @param 360 Calculation data
	 */

	public static void process(SE360CalcData[] calcData ) {
		String fileName = "file:rules/main/AltAtRiskDecisionModel.xls";
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			decision.put("response",response);
			decision.put("trace", "Off");
			
			calcData[i].ruleName = "AR1";
			decision.execute();
			calcData[i].aard.ar1_e = Util.round(response.getRuleResult(), 6);
			logger.debug("FRM-AR1-1" + calcData[i].aard.ar1_e);
			
			
			calcData[i].ruleName = "AR2";
			decision.execute();
			calcData[i].aard.ar2_e = response.getRuleResult();
			logger.debug("FRM-AR1-2" + calcData[i].aard.ar2_e);
			
			calcData[i].ruleName = "AR3";
			decision.execute();
			calcData[i].aard.av357_e = Util.round(response.getRuleResult(), 4);
			logger.debug("FRM-AR1-3" + calcData[i].aard.av357_e);
				
			calcData[i].ruleName = "AR4";
			decision.execute();
			calcData[i].aard.aw199_e = Util.round(response.getRuleResult(), 1);
			logger.debug("FRM-AR1-4" + calcData[i].aard.aw199_e);
			
			calcData[i].ruleName = "AR5";
			decision.execute();
			calcData[i].aard.ag199_a_e = Util.round(response.getRuleResult(), 1);
			logger.debug("FRM-AR1-2" + calcData[i].aard.ag199_a_e);
			
			Object[] objects = new Object[] {calcData[i], response};
			calcData[i].aard.tot_at_risk_ar6_of_SE_P0 = ((RulesResponse) engine.run("rule_ar6_e", objects)).getRuleResult();
			logger.debug("FRM-AR1-2" + calcData[i].aard.ar6_e);
		
		
			calcData[i].ruleName = "AR7";
			decision.execute();
			calcData[i].aard.ag199_a_e = Util.round(response.getRuleResult(), 4);
			logger.debug("FRM-AR1-7" + calcData[i].aard.ar7_e);
			
			
			calcData[i].ruleName = "AR8";
			decision.execute();
			calcData[i].aard.ar8_e = response.getRuleResult();
			logger.debug("FRM-AR1-8" + calcData[i].aard.ar8_e);
			

			objects = new Object[] {calcData[i], response};
			calcData[i].aard.tot_at_risk_ar6_of_SE_P0 = ((RulesResponse) engine.run("rule_ar9_e", objects)).getRuleResult();
			logger.debug("FRM-AR1-9" + calcData[i].aard.ar9_e);
		
		

			objects = new Object[] {calcData[i], response};
			calcData[i].aard.ar10_e = ((RulesResponse) engine.run("rule_ar10_e", objects)).getRuleResult();
			logger.debug("FRM-AR1-2" + calcData[i].aard.ar10_e);
		
		

			objects = new Object[] {calcData[i], response};
			calcData[i].aard.ar11_e = ((RulesResponse) engine.run("rule_ar11_e", objects)).getRuleResult();
			logger.debug("FRM-AR1-11" + calcData[i].aard.ar11_e);
	
			objects = new Object[] {calcData[i], response};
			calcData[i].aard.ar12_e = ((RulesResponse) engine.run("rule_ar12_e", objects)).getRuleResult();
			calcData[i].aard.ar12_e = Util.round(calcData[i].aard.ar12_e, 2);
			logger.debug("FRM-AR1-12" + Util.round(calcData[i].aard.ar12_e, 2));

			objects = new Object[] {calcData[i], response};
			calcData[i].aard.ar13_e = ((RulesResponse) engine.run("rule_ar131415_e", objects)).getRuleResult();
			calcData[i].aard.ar13_e = Util.round(calcData[i].aard.ar13_e, 2);
			logger.debug("FRM-AR1-13" + Util.round(calcData[i].aard.frm_ar13_1, 2));
		
			calcData[i].aard.ar14_e = Util.round(calcData[i].aard.ar14_e, 2);
			logger.debug("FRM-AR1-14" + Util.round(calcData[i].aard.frm_ar14_1, 2));
		
			calcData[i].aard.ar15_e = Util.round(calcData[i].aard.ar15_e, 2);
			logger.debug("FRM-AR1-15" + Util.round(calcData[i].aard.frm_ar15_1, 2));
		
			calcData[i].ruleName = "AR16";
			decision.execute();
			calcData[i].aard.ar16_e = response.getRuleResult();
			calcData[i].aard.ar16_e = Util.round(calcData[i].aard.ar16_e, 2);
			logger.debug("FRM-AR1-8" + calcData[i].aard.ar16_e);
			

			calcData[i].ruleName = "AR17";
			decision.execute();
			calcData[i].aard.ar17_e = response.getRuleResult();
			calcData[i].aard.ar17_e = Util.round(calcData[i].aard.ar16_e, 2);
			calcData[i].aard.ar17_1_e = response.getRuleResult();
			calcData[i].aard.ar17_1_e = Util.round(calcData[i].aard.ar16_e, 2);
			logger.debug("FRM-AR1-17" + calcData[i].aard.ar17_e);
			

			calcData[i].ruleName = "AR18";
			decision.execute();
			calcData[i].aard.ar18_e = response.getRuleResult();
			calcData[i].aard.ar18_e = Util.round(calcData[i].aard.ar18_e, 2);
			logger.debug("FRM-AR1-18" + calcData[i].aard.ar18_e);
			
			
			
			objects = new Object[] {calcData[i], response};
			calcData[i].aard.ar19_e = ((RulesResponse) engine.run("rule_ar19_e", objects)).getRuleResult();
			logger.debug("FRM-AR1-18" + calcData[i].aard.ar19_e);
			
			
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			
			System.out.println("---------Alternate At Risk calculation DONE----------");
		}
		
	}
	
	
	
		 
}
