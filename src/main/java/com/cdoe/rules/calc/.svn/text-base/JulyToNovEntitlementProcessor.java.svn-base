package com.cdoe.rules.calc;

/* 
 * Developed by Sandeep Sarkar.
 */

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.exception.DataException;

import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.model.equal.FteByGrade;
import com.cdoe.biz.model.equal.MillLevy;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.rules.calc.entitlement.StAvgFreeLunchProcessor;
import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.ISE360CalculationManager;
import com.cdoe.services.impl.ReferenceDataManager;
import com.cdoe.services.impl.SE360CalculationManager;

public class JulyToNovEntitlementProcessor extends EntitlementsProcessor{

	private static final Logger logger = Logger.getLogger(JulyToNovEntitlementProcessor.class);
	
	public static final String RULE_TYPE_DECISION = "Decision";
	public static final String RULE_TYPE_METHOD = "Method";
	public static final String CALC_DATA_SOURCE_HARDCODED = "HardCoded";
	public static final String CALC_DATA_SOURCE_DATABASE = "Database";
	public static final String CALC_DATA_SOURCE_FILE = "File";

	
	
	/*
	 * This will contain the steps involved in July-November processing
	 */
	public  SE360CalcData[] processEntitlement(String fiscalMonth, String fiscalYear, String dataSource) {
		SE360CalcData[] calcData = 	setUpAllDistrictsData( fiscalMonth, fiscalYear,dataSource);
		processStateAverageFreeLunch(calcData);
		processDistricts(calcData);
		processCSITotals(calcData);
		return calcData;
	}
	
	

}
