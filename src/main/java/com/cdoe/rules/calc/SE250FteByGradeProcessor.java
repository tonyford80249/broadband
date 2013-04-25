package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.hibernate.exception.DataException;

import com.cdoe.rules.calc.data.SE250FteByGradeData;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SE250FteByGradeProcessor {


	public static void process(SE250FteByGradeData[] calcData ) {
		
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		String fileName = "file:./webapp/rules/main/decisonmodels/SE250FteByGradeDecisionModel.xls";
		OpenRulesEngine engine = null;
		try  {
			engine = new OpenRulesEngine(fileName);
			System.out.println(" Model File found " + fileName);
		} catch (Exception e) {
			System.out.println(" Model File not found " + fileName + e.getMessage());
		}
		
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			
			
			Object[] objects = new Object[] {calcData[i], response};
			//calcData[i].size_factor_of_SE = ((RulesResponse) engine.run("rule_sizeFactor", objects)).getRuleResult();
			
			//System.out.println("Calc Data: fc4_e \n" + calcData[i].sfd.fpc_csc);
			
			System.out.println("---------DONE----------");
		}
		
		
		
	}
	
	public static void invoke(String districtCode, String fiscalYear ) {
		
		 districtCode = "0100";
		 fiscalYear = "20112012";
		SE360CalcData[] calcData = (SE360CalcData[]) setUpData(districtCode, fiscalYear, "HardCoded");
			
		SE360CalcProcessor scp = new SE360CalcProcessor();
	
	}

	private static Object[] setUpData(String districtCode, String fiscalYear, String dataSource) throws DataException {
		return null;
	}
		
}
