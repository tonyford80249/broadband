package com.cdoe.rules.calc;

/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.cdoe.services.impl.ReferenceDataManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SECategoricBOMillLevyProcessor {

	private static final Logger logger = Logger
			.getLogger(SECategoricBOMillLevyProcessor.class);

	public static void process(SE360CalcData[] calcData) {
		String fileName = "file:rules/main/decisonmodels/SE360CBOMillLevyDecisionModel.xls";
		// System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = new OpenRulesEngine(fileName);

		Decision decision = new Decision("DetermineCalculationResults", engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData", calcData[i]);
			System.out.println("Calc Data: " + i + "\n"
					+ calcData[i].toString());
			RulesResponse response = new RulesResponse();

			calcData[i].ruleName = "CB1";
			decision.execute();
			calcData[i].mld.setCb1_e(Util.round(response.getRuleResult(), 6));
			logger.debug("CB1" + calcData[i].mld.getCb1_e());

			calcData[i].ruleName = "CB2";
			decision.execute();
			calcData[i].mld.setCb2_e(Util.round(response.getRuleResult(), 6));
			logger.debug("CB1" + calcData[i].mld.getCb2_e());
			
			Object[] objects = new Object[] { calcData[i], response };
			((RulesResponse) engine.run("ruleCB3_e", objects)).getRuleResult();


			calcData[i].ruleName = "CB4";
			decision.execute();
			calcData[i].mld.setCb1_e(Util.round(response.getRuleResult(), 6));
			logger.debug("CB3" + calcData[i].mld.getCb3_e());

			objects = new Object[] { calcData[i], response };
			((RulesResponse) engine.run("ruleCB5_e", objects)).getRuleResult();

		
		}

	}

}
