package com.cdoe.rules.calc;


/* 
 * Developed by Sandeep Sarkar.
 */

import org.apache.log4j.Logger;

import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class SESizeFactorProcessor {

	private static final Logger logger = Logger.getLogger(SESizeFactorProcessor.class);

	public static void process(SE360CalcData[] calcData ) {
		
		//System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		String fileName = "file:rules/main/decisonmodels/SE360SizeFactorDecisionModel.xls";
		OpenRulesEngine engine = null;
		try  {
			engine = new OpenRulesEngine(fileName);
			System.out.println(" File found 1");
		} catch (Exception e) {
			
			System.out.println(" File not found 1" + e.getMessage());
			fileName = "file:C:/project/newequal/cdoe/src/main/webapp/WEB-INF/rules/main/decisonmodels/SE360SizeFactorDecisionModel.xls";
			logger.debug("Going for local file");
		}
		
		
		//fileName = "file:../webapp/rules/main/decisonmodels/SE360SizeFactorDecisionModel.xls";
		
		/*try  {
			engine = new OpenRulesEngine(fileName);
			System.out.println(" File found 2");
		} catch (Exception e) {
			System.out.println(" File not found 2" + e.getMessage());
		}*/
		
		
		
		/*try  {
			engine = new OpenRulesEngine(fileName);
			System.out.println(" File found 3");
		} catch (Exception e) {
			System.out.println(" File not found 3" + e.getMessage());
		}*/
		
       //fileName = "file:./webapp/WEB-INF/rules/main/decisonmodels/SE360SizeFactorDecisionModel.xls";
		
		/*try  {
			engine = new OpenRulesEngine(fileName);
			System.out.println(" File found 4");
		} catch (Exception e) {
			System.out.println(" File not found 4" + e.getMessage());
		}*/
		
       //fileName = "file:/webapp/rules/main/decisonmodels/SE360SizeFactorDecisionModel.xls";
		
		/*try  {
			engine = new OpenRulesEngine(fileName);
			System.out.println(" File found 5");
		} catch (Exception e) {
			System.out.println(" File not found 5" + e.getMessage());
		}
		
		 //fileName = "file:/webapp/WEB-INF/rules/main/decisonmodels/SE360SizeFactorDecisionModel.xls";
	     try  {
				engine = new OpenRulesEngine(fileName);
				System.out.println(" File found 6");
			} catch (Exception e) {
				System.out.println(" File not found 6" + e.getMessage());
			}
	     //fileName = "file:C:/project/newequal/cdoe/rules/main/decisonmodels/SE360SizeFactorDecisionModel.xls";
	     try  {
				engine = new OpenRulesEngine(fileName);
				System.out.println(" File found 6");
			} catch (Exception e) {
				System.out.println(" File not found 6" + e.getMessage());
			}
		*/
		Decision decision = new Decision("DetermineCalculationResults",engine);
		for (int i = 0; i < calcData.length; i++) {
			decision.put("stateEqualCalcData",calcData[i]);
			System.out.println("Calc Data: " + i + "\n" + calcData[i].toString());
			RulesResponse response = new RulesResponse();
			
			
			Object[] objects = new Object[] {calcData[i], response};
			calcData[i].size_factor_of_SE = ((RulesResponse) engine.run("rule_sizeFactor", objects)).getRuleResult();
			
			System.out.println("Calc Data: fc4_e \n" + calcData[i].sfd.fpc_csc);
			
			System.out.println("---------DONE----------");
		}
		
	}
	
	/*private void perPersonCost(SE360CalcData se360CalcData) {
		se360CalcData.pp1_e = se360CalcData.getVar_21_base_fund_1();
		se360CalcData.pp2_e = se360CalcData.person_cost_factor_SE_P0;
		se360CalcData.pp3_e = se360CalcData.colAdjust_SE_P0;
		se360CalcData.pp4_e = se360CalcData.pp1_e;
		se360CalcData.pp5_e = 1 - se360CalcData.pp2_e;
		
	}
	*/
	
	
		 
}
