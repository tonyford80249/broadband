package com.cdoe.rules.calc.entitlement;

import org.apache.log4j.Logger;

import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.rules.calc.RulesResponse;
import com.cdoe.rules.calc.SE360CalcData;
import com.cdoe.rules.calc.Util;
import com.cdoe.services.ISE360CalculationManager;
import com.cdoe.services.impl.stateequal.DisplayAdjustmentManager;
import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;

public class StAvgFreeLunchProcessor extends BaseProcessorForRules {

	private static final Logger logger = Logger.getLogger(StAvgFreeLunchProcessor.class);
	
	private IStateEqualDAO stateEqualDAO;
	public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
		this.stateEqualDAO = stateEqualDAO;
	}


	/*
	 * Injector method
	 * 
	 * @param se360CalcManager
	 */
	
	public void process(SE360CalcData[] calcData) {

		String fileName = "file:C:/project/newequal/cdoe/src/main/webapp/WEB-INF/rules/main/decisonmodels/StateAvgDecisionModel.xls";
		
		System.setProperty("OPENRULES_MODE", "Validate");
		System.setProperty("OPENRULES_MODE", "Execute");
		OpenRulesEngine engine = null;
		
		try  {
			engine = new OpenRulesEngine(fileName);
			logger.debug(" Rules File found on the server itself" + fileName);
		} catch (Exception e) {
			
			logger.debug(" File not found" + fileName + e.getMessage());
			fileName = "file:C:/project/newequal/cdoe/src/main/webapp/WEB-INF/rules/main/decisonmodels/StateAvgDecisionModel.xls";
			logger.debug("Going for local file");
			engine = new OpenRulesEngine(fileName);
		}
		
		Decision decision = new Decision("DetermineCalculationResults",engine);
		int nosOfDistricts = 0;
		
		decision.put("stateEqualCalcData",calcData[0]);
		logger.debug("______________Calc Data: " + 1 + "\n" + calcData[0].toString());
		RulesResponse response = new RulesResponse();
		decision.put("response",response);
	
		for (int j=0; j < calcData.length ; j++) {
			calcData[j].setRuleName("VAR-8-STAVG-1.1");
			decision.execute();
			Double var_av3507_e = Util.round(response.getRuleResult(), 2);
			calcData[j].setAv3507_e(var_av3507_e);
			
			calcData[j].setRuleName("VAR-8-STAVG-1.2"); 
			decision.execute();
			Double var_aw199_e = Util.round(response.getRuleResult(),2);
			calcData[j].setAw199_e(var_aw199_e);
			
			calcData[j].setRuleName("VAR-8-STAVG-1.3");
			decision.execute();
			Double var_aw200_e = response.getRuleResult();
			calcData[j].setAw200_e(var_aw200_e);
			
			Object[] objects = new Object[] {calcData[j], response};
			Double  varAg201_e = ((RulesResponse) engine.run("rule_var8_stAvgFreeLunch" +
					"", objects)).getRuleResult();
			calcData[j].setAg201_e(varAg201_e);
			
			calcData[j].setRuleName("VAR-8-STAVG-1.4");
			decision.execute();
			Double ag371_sum_e = response.getRuleResult();
			calcData[j].setAg371_sum_e(ag371_sum_e);
			
			calcData[j].setRuleName("VAR-8-STAVG-1.5");
			decision.execute();
			Double adj_sum_e = response.getRuleResult();
			calcData[j].setAdj_sum_e(adj_sum_e);
			logger.debug("var_av3507_e " +  var_av3507_e + "   var_aw199_e " + var_aw199_e + "   var_aw200_e " + var_aw200_e);
			nosOfDistricts++;
		}
		logger.debug("The nos of districts processed" + nosOfDistricts);
		calcData[0].setRuleName("VAR-8-STAVG-1.5");
		decision.execute();
		Double adj_sum_e = response.getRuleResult();
		calcData[0].setAdj_sum_e(adj_sum_e);
		//Should the State Equal record for all the districts be updated?
		//stateEqualDAO.updateStateAverage("20122013", adj_sum_e );
		logger.debug("Processing State Average Free Lunch ended");
		
	}
	
	
	public static void main(String[] args) {
		StAvgFreeLunchProcessor salp = new StAvgFreeLunchProcessor();
		salp.process(new SE360CalcData[1] );
	}
}
