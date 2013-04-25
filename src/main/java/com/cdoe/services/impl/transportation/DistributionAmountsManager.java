
package com.cdoe.services.impl.transportation;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.biz.model.transportation.Prorate;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.biz.transportation.IDistributionAmountsDAO;
import com.cdoe.biz.transportation.ITransportationDAO;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.transportation.IDistributionAmountsManager;
import com.cdoe.ui.form.transportation.ProrateForm;
import com.cdoe.util.DateUtil;

public class DistributionAmountsManager extends BaseManager implements IDistributionAmountsManager {

	private static final Logger logger = Logger.getLogger(DistributionAmountsManager.class);
	
	private IDistributionAmountsDAO distributionAmountsDAO;
	private ITransportationDAO transportationDAO;
	
	public void setDistributionAmountsDAO(IDistributionAmountsDAO distributionAmountsDAO) {
		this.distributionAmountsDAO = distributionAmountsDAO;
	}
	
	public void setTransportationDAO(ITransportationDAO transportationDAO) {
		this.transportationDAO = transportationDAO;
	}
	
	public static final int FIRST_PAYMENT = 1;
	public static final int SECOND_PAYMENT = 2;
		
	
	public void saveOrUpdate(ProrateForm form) {
		Prorate obj = null;
		// Calculate the total payment if the one coming in isn't equal to the first and second payments
		// This handles the case where the save button pressed - bypasses the runPayments methods
		form = updateTotalDistribution(form);
		if (form.getId() == 0) {
			obj = distributionAmountsDAO.getByFiscalYear(form.getFiscalYear());
		} else {
			long id = form.getId();
			obj = findById(Prorate.class, id);
		}
		if (obj == null) {
			obj = new Prorate();
		}
		obj.setFiscalYear(form.getFiscalYear() != null ? form.getFiscalYear() : DateUtil.getFiscalYear());
		obj.setProrateFactor1stPayment(form.getProrateFactor1stPayment());
		obj.setProrateFactor2ndPayment(form.getProrateFactor2ndPayment());
		obj.setFundingSources(form.getFundingSources());
		obj.setTotalFirstPayment(form.getTotalFirstPayment());
		obj.setTotalSecondPayment(form.getTotalSecondPayment());
		obj.setTotalDistribution(form.getTotalDistribution());
		saveOrUpdate(obj);
	}
	
	public ProrateForm setupForm() {
		ProrateForm form = new ProrateForm();
		return form;
	}
	
	//Not Used
	public ProrateForm setupForm(long id) {
		Prorate obj = findById(Prorate.class, id); 
		
		ProrateForm form = new ProrateForm();
		form.setId(obj.getId());
		form.setFiscalYear(obj.getFiscalYear());
		form.setProrateFactor1stPayment(obj.getProrateFactor1stPayment());
		form.setProrateFactor2ndPayment(obj.getProrateFactor2ndPayment());
		form.setFundingSources(obj.getFundingSources());
		form.setTotalFirstPayment(obj.getTotalFirstPayment());
		form.setTotalSecondPayment(obj.getTotalSecondPayment());
		form.setTotalDistribution(obj.getTotalDistribution());
		return form;
	}
	
	
	
	public ProrateForm setupForm(String fiscalYear) {
		ProrateForm form = new ProrateForm();
		
		Prorate dto = distributionAmountsDAO.getByFiscalYear(fiscalYear);
		if (dto != null) {
			logger.info("Prorate Transportation data received");
			form = setFormData(form, dto);

		} else {
			form.setFiscalYear(DateUtil.getPrevFiscalYear());
			logger.info("Prorate Transportation data not found");
		}
		return form;
	}
	
	public ProrateForm setFormData(ProrateForm form, Prorate obj) {
		form.setId(obj.getId());
		form.setFiscalYear(obj.getFiscalYear());
		form.setProrateFactor1stPayment(obj.getProrateFactor1stPayment());
		form.setProrateFactor2ndPayment(obj.getProrateFactor2ndPayment());
		form.setFundingSources(obj.getFundingSources());
		form.setTotalFirstPayment(obj.getTotalFirstPayment());
		form.setTotalSecondPayment(obj.getTotalSecondPayment());
		form.setTotalDistribution(obj.getTotalDistribution());
		return form;
	}

	@Override
	public void runFirstPayment(ProrateForm prorateForm) {
		runPayment(prorateForm, FIRST_PAYMENT);
		
	}

	@Override
	public void runSecondPayment(ProrateForm prorateForm) {
		runPayment(prorateForm, SECOND_PAYMENT);
		
	}
	
	public void runPayment(ProrateForm prorateForm, int paymentNos) {
		prorateForm = updateTotalDistribution(prorateForm);
		String fiscalYear = prorateForm.getFiscalYear();
		if (fiscalYear == null || "".equals(fiscalYear))
			fiscalYear = DateUtil.getFiscalYear();
		
		List<Object[]> resultList = distributionAmountsDAO.getCDE40TotalByFiscalYear(fiscalYear);
		Object[] res = resultList.get(0);
		
		double advPay = 0.0;
		double reimEntitlement = 0.0;
		
		try {
			 advPay = (res[0] != null) ? ((Double)res[0]).doubleValue() : 0.00;
			 logger.debug(" advPay 0 " + advPay);
			 reimEntitlement = ( res[1] != null) ? ((Double)res[1]).doubleValue(): 0.00;
			
			logger.debug(" reimEntitlement 1 " + reimEntitlement);
		} catch (Exception e) {
			logger.debug("Could not get reimEntitlement" + reimEntitlement + "or advPay " + advPay);
		}
		
		double prorateFactor =  ((prorateForm.getTotalDistribution() != null ? prorateForm.getTotalDistribution().doubleValue() : 0 ) - advPay )/ reimEntitlement;
	
		List<Transportation> transportationList = transportationDAO.getByYear(fiscalYear);
		
		for (Transportation transportation : transportationList) {
			logger.debug("prorateFactor " + prorateFactor);
			double finalReimEntitlementProrated = prorateFactor * (transportation.getFinalReimEntitlement() != null ? transportation.getFinalReimEntitlement().doubleValue() : 0);
			double totalPayment = finalReimEntitlementProrated +  (transportation.getAdvPay() != null ? transportation.getAdvPay().doubleValue() : 0);
			double totalMileage =  (transportation.getTotalReimMileage() != null ? transportation.getTotalReimMileage().doubleValue() : 0) * (transportation.getMigMiles() != null ? transportation.getMigMiles().doubleValue() : 0);
			double migrantEducation = 0;
			if (totalMileage != 0)
			  migrantEducation = (totalPayment /totalMileage);
			//transportation.setTotalReimEntitlement(totalPayment);
			transportation.setFinalReimProrated(finalReimEntitlementProrated);
			double netPayment = totalPayment - migrantEducation;
			double districtDistribution = netPayment;
			if (paymentNos == FIRST_PAYMENT ) {
				transportation.setFirstPayment(netPayment);
				prorateForm.setProrateFactor1stPayment(prorateFactor);
			}
			else {
				double secondPayment = netPayment - (transportation.getFirstPayment() != null ? transportation.getFirstPayment().doubleValue() : 0);
				transportation.setSecondPayment(secondPayment);
				prorateForm.setProrateFactor2ndPayment(prorateFactor);
			}
			transportation.setDistrictDistribution(districtDistribution);
			
			//commit;
			saveOrUpdate(transportation);
			
		}
		saveOrUpdate(prorateForm);
	}
	
	public void updateProrateNote(ProrateForm prorateForm) {
		distributionAmountsDAO.updateProrateNote(prorateForm.getFiscalYear(), prorateForm.getFundingSources());
		
	}
	
	private ProrateForm updateTotalDistribution(ProrateForm form) {
		double firstPayment = (form.getTotalFirstPayment() == null) ? 0.0 : form.getTotalFirstPayment().doubleValue();
		double secondPayment = (form.getTotalSecondPayment() == null) ? 0.0 : form.getTotalSecondPayment().doubleValue();
		double totalDistribution = firstPayment + secondPayment;
		if (form.getTotalDistribution() != null && form.getTotalDistribution().doubleValue() != totalDistribution) {
			form.setTotalDistribution(new Double(totalDistribution));
		}
		return form;
	}
}
