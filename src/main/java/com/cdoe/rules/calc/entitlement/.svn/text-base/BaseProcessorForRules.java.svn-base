package com.cdoe.rules.calc.entitlement;

import org.apache.log4j.Logger;

import com.cdoe.rules.calc.SE360CalcData;
import com.cdoe.services.impl.stateequal.DisplayAdjustmentManager;
import com.openrules.ruleengine.OpenRulesEngine;

public class BaseProcessorForRules {

	private static final Logger logger = Logger.getLogger(DisplayAdjustmentManager.class);
	
	public OpenRulesEngine setupRulesEngine(String decisionModel) {

		String fileName = "file:rules/main/decisonmodels/" + decisionModel + ".xls";
		setRulesModeProperty("Execute");
		
		System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		
		OpenRulesEngine engine = null;

		try {
			engine = new OpenRulesEngine(fileName);
			logger.debug(" Rules File found on the server itself" + fileName);
		} catch (Exception e) {

			logger.debug(" File not found" + fileName + e.getMessage());
			fileName = "file:C:/project/newequal/cdoe/src/main/webapp/WEB-INF/rules/main/decisonmodels/" + decisionModel + ".xls";
			logger.debug("Going for local file");
			engine = new OpenRulesEngine(fileName);
		}
		return engine;
	}

	//C:\project\newequal\cdoe\src\main\webapp\WEB-INF\rules\rulesInfo\rules
	//C:\project\newequal\cdoe\src\main\webapp\WEB-INF\rules\rulesInfo\rules
	public static void process(SE360CalcData calcData) {


	}
	
	public void setRulesModeProperty(String propName) {
		System.setProperty("OPENRULES_MODE", propName);
		
	}
}
