
package com.cdoe.services.stateequal;

import com.cdoe.rules.calc.SE360CalcData;
import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.stateequal.CalculateEntitlementsForm;


public interface ICalculateEntitlementsManager extends IBaseManager {

	public abstract void saveOrUpdate(SE360CalcData se360CalcData);
	
	public abstract void invoke360CalcForAllDistricts(String fiscalYear, String fiscalMonth) throws Exception;
	
	public abstract void calculateEntitlements(CalculateEntitlementsForm entitlementsForm);
	
	public void processStateAverageFreeLunch(String fiscalYear);
	
	
}
