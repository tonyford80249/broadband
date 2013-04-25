
package com.cdoe.services.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.biz.model.VData;
import com.cdoe.biz.model.jasper.MillLevyOverrideCalcCollection;
import com.cdoe.biz.model.jasper.MillLevyOverrideCalcDatasource;
import com.cdoe.biz.model.jasper.MillLevyOverrideCalculation;
import com.cdoe.biz.model.jasper.SeMillLevyOverride;
import com.cdoe.biz.model.jasper.SeMillLevyOverrideDatasource;
import com.cdoe.biz.stateequal.IMillLevyOverrideWorksheetDAO;
import com.cdoe.services.stateequal.IMillLevyOverrideWorksheetManager;
import com.cdoe.ui.form.stateequal.MillLevyForm;
import com.cdoe.ui.form.stateequal.MillLevyOverrideForm;

public class MillLevyOverrideWorksheetManager extends BaseManager implements IMillLevyOverrideWorksheetManager {

	private static final Logger logger = Logger.getLogger(MillLevyOverrideWorksheetManager.class);
	
	private IMillLevyOverrideWorksheetDAO millLevyOverrideWorksheetDAO;
	
	public void saveOrUpdate(MillLevyOverrideForm form) {
		long id = form.getId();
		VData obj = findById(VData.class, id); 
		if (obj == null) {
			obj = new VData();
		}
		
		saveOrUpdate(obj);
	}
	
	public MillLevyOverrideForm setupForm() {
		MillLevyOverrideForm form = new MillLevyOverrideForm();
		//form.setGrandTotalProg(4000.00);
		//form.setCostOfLiving(1000.00);
		return form;
	}
	
	public MillLevyOverrideForm setupForm(String districtCode, String fiscalYear) {
		MillLevyOverrideForm form = new MillLevyOverrideForm();
		logger.debug(" districtCode " +  districtCode + " fiscalYear " + fiscalYear);
		//fiscalYear = "20122013";
		List<Object[]> resultList  = millLevyOverrideWorksheetDAO.getMillLevyOverrideByDistrictYear(districtCode, fiscalYear);
		if (resultList != null && resultList.size() > 0) {
			Object[] res = resultList.get(0);
			double grandTotalProg = ((Double)res[0]).doubleValue();
			double costOfLiving = ((Double)res[1]).doubleValue();
			double holdHarmless = ((Double)res[2]).doubleValue();
			double excessHoldHarmless = ((Double)res[3]).doubleValue();
			double voterApprovedOverride = ((Double)res[3]).doubleValue();
			logger.debug(" grandTotalProg " + grandTotalProg);
			logger.debug(" costOfLiving " +  costOfLiving);
			form.setGrandTotalProg(grandTotalProg);
			form.setCostOfLiving(costOfLiving);
			form.setHoldHarmless(holdHarmless);
			double propertyTaxRevenue = grandTotalProg + costOfLiving + holdHarmless;
			form.setExcessHoldHarmless(excessHoldHarmless);
			form.setVoterApprovedOverride(voterApprovedOverride);
			form.setPropertyTaxRevenue(propertyTaxRevenue);
			form.setMinOverrideAllowed(200000.0);
		} else {
			form.setErrorMessage("No data found");
			form.setMinOverrideAllowed(200000.0);
		}
		return form;
	}
	
	 public SeMillLevyOverrideDatasource createDataSource(MillLevyOverrideForm form) {
	     	     
             //String districtNumber, String districtName, String taxYear, Double grandTotalProg, Double costOfLiving, Double minOverrideAllowed, Double quarterOfTotalProg, Double totalOverrideAllowed, Double allowableOverride, Double propertyTaxRevenue, Double remainingBalance        
	     SeMillLevyOverride collection = new SeMillLevyOverride(form.getDistrictCode(),form.getDistrictName(),form.getPropertyTaxYear(),form.getGrandTotalProg(),form.getCostOfLiving(),form.getMinOverrideAllowed(),form.getQuarterOfTotalProg(),form.getTotalOverrideAllowed(),form.getAllowableOverride(),form.getPropertyTaxRevenue(),form.getRemainingBalance());
	   
	     return new SeMillLevyOverrideDatasource(collection);
	 }
	
	public MillLevyOverrideForm setupForm(long id) {
		VData obj = findById(VData.class, id); 
		
		MillLevyOverrideForm form = new MillLevyOverrideForm();
		form.setId(obj.getId());
		form.setGrandTotalProg(4000.00);
		form.setCostOfLiving(1000.00);
		return form;
	}
	
	public void setMillLevyOverrideWorksheetDAO(IMillLevyOverrideWorksheetDAO millLevyOverrideWorksheetDAO) {
		this.millLevyOverrideWorksheetDAO = millLevyOverrideWorksheetDAO;
	}
	
}
