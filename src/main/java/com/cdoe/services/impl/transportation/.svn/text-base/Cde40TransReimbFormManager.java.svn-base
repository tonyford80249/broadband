package com.cdoe.services.impl.transportation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.biz.transportation.ICde40TransReimbFormDAO;
import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.impl.TransportationDataManager;
import com.cdoe.services.transportation.ICde40TransReimbFormManager;
import com.cdoe.ui.form.transportation.TransportationForm;
import com.cdoe.util.DateUtil;

public class Cde40TransReimbFormManager extends TransportationDataManager  implements
		ICde40TransReimbFormManager {

	private static final Logger logger = Logger.getLogger(Cde40TransReimbFormManager.class);

	private IReferenceDataManager referenceDataManager;

	/**
	 * Sets the referenceDataManager
	 * 
	 * @param referenceDataManager
	 */
	public void setReferenceDataManager(
			IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}

	private ICde40TransReimbFormDAO cde40TransReimbFormDAO;

	
	public void setCde40TransReimbFormDAO(
			ICde40TransReimbFormDAO cde40TransReimbFormDAO) {
		this.cde40TransReimbFormDAO = cde40TransReimbFormDAO;
	}

	

	public void saveOrUpdate(TransportationForm form) {
		long id = form.getId();
		Transportation obj = findById(Transportation.class, id);
		if (obj == null) {
			obj = new Transportation();
		}
		if (form.getFiscalYear() == null || "".equals(form.getFiscalYear()))
			form.setFiscalYear(DateUtil.getPrevFiscalYear());
		calculateFinalReimEntitlement(form);
		// Save or update values
		obj.setDistrictNumber(form.getDistrictNumber());
		obj.setFiscalYear(form.getFiscalYear());
		obj.setDateChanged(Calendar.getInstance().getTime());

		obj.setNamePreparerCde40(form.getNamePreparerCde40());
		obj.setPhonePreparerCde40(form.getPhonePreparerCde40());
		obj.setEmailPreparerCde40(form.getEmailPreparerCde40());

		obj.setPupilTran(form.getPupilTran());
		obj.setOperTran(form.getOperTran());
		obj.setOtherRevenue(form.getOtherRevenue());

		if (form.getNetCurrentOperExpend() == null)
			obj.setNetCurrentOperExpend(form.getOperTran());

		obj.setMigMiles(form.getMigMiles());
		obj.setRegDMiles(form.getRegDMiles());
		obj.setSchoolDays(form.getSchoolDays());
		obj.setBoardTran(form.getBoardTran());
		obj.setTotalMiles(form.getTotalMiles());
		obj.setTotalReimMileage(form.getTotalReimMileage());

		obj.setActMiles(form.getActMiles());
		obj.setDesegReim(form.getDesegReim());
		obj.setReimTran(form.getReimTran());
		obj.setReimTranLy(form.getReimTranLy());
		obj.setAdvPayLy(form.getAdvPayLy());
		obj.setReimAdvPay(form.getReimAdvPay());
		obj.setAdvPay(form.getAdvPay());
		obj.setFirstPayment(form.getFirstPayment());
		obj.setSecondPayment(form.getSecondPayment());
		obj.setCofrsBatchNumber(form.getCofrsBatchNumber());
		obj.setMileageEntitlement(form.getMileageEntitlement());
		obj.setExCosts(form.getExCosts());
		obj.setExReim(form.getExReim());
		obj.setMaxReimEntitlement(form.getMaxReimEntitlement());
		obj.setReimEntitlement(form.getReimEntitlement());
		obj.setTotalReimEntitlement(form.getTotalReimEntitlement());
		obj.setFinalReimEntitlement(form.getFinalReimEntitlement());
		obj.setErrors("None");
		saveOrUpdate(obj);
	}

	// not being used
	public TransportationForm setupForm() {
		TransportationForm form = new TransportationForm();
		return form;
	}

	public TransportationForm setupForm(String districtNos) {
		TransportationForm form = new TransportationForm();

		String fiscalYear = DateUtil.getPrevFiscalYear();

		List<Transportation> transportationList = cde40TransReimbFormDAO.getByDistrictAndYear(districtNos, fiscalYear);
		if (transportationList != null && transportationList.size() > 0) {
			logger.info("Transportation data received");
			form = setFormData(transportationList.get(0));
			form.setFiscalYear(fiscalYear);
			
			form.setValid(true);

		} else {
			logger.info("Transportation data not found for this district. Create new data");
			// zero out the fields for display
			form = initFormData();
			form.setValid(false);

		}
		form.setIsCapitalOutLay(isCapitalOutlayDistrict(districtNos));
		return form;
	}

	private boolean isCapitalOutlayDistrict(String districtNos) {
		boolean isCapitalOutlayDistrict = false;
		List<String> coDistricts = referenceDataManager.getCapitalOutlayDistricts();
		for (String districtCode : coDistricts) {
			if (districtNos.equalsIgnoreCase(districtCode)) {
				isCapitalOutlayDistrict = true;
				break;
			}

		}
		return isCapitalOutlayDistrict;

	}

	// Place holder - not used
	public TransportationForm setupForm(long id) {
		Transportation obj = findById(Transportation.class, id);

		TransportationForm form = new TransportationForm();

		return form;
	}

	/*private TransportationForm setFormData(Transportation obj) {
		TransportationForm form = new TransportationForm();
		form.setId(obj.getId());
		form.setDistrictNumber(obj.getDistrictNumber());
		form.setDateChanged(obj.getDateChanged());
		form.setErrors(obj.getErrors());
		form.setPupilTran(obj.getPupilTran());
		form.setOperTran(obj.getOperTran());
		form.setIndCont(obj.getIndCont());
		form.setCapOutTran(obj.getCapOutTran());
		form.setMigMiles(obj.getMigMiles());
		form.setRegDMiles(obj.getRegDMiles());
		form.setSchoolDays(obj.getSchoolDays());
		form.setRegDays(obj.getRegDays());
		form.setBoardTran(obj.getBoardTran());
		form.setExReim(obj.getExReim());
		form.setDesegReim(obj.getDesegReim());
		form.setReimTran(obj.getReimTran());
		form.setReimTranLy(obj.getReimTranLy());
		form.setAdvPayLy(obj.getAdvPayLy());
		form.setReimAdvPay(obj.getReimAdvPay());
		form.setAdvPay(obj.getAdvPay());
		form.setActMiles(obj.getActMiles());
		form.setTotalMiles(obj.getTotalMiles());
		form.setFiscalYear(obj.getFiscalYear());
		form.setCdeComments(obj.getCdeComments());
		form.setFirstPayment(obj.getFirstPayment());
		form.setSecondPayment(obj.getSecondPayment());
		form.setDistrictDistribution(obj.getDistrictDistribution());
		form.setCofrsBatchNumber(obj.getCofrsBatchNumber());
		form.setCofrsDatePaid(obj.getCofrsDatePaid());
		if (obj.getNamePreparerCde40() == null)
			form.setNamePreparerCde40("");
		else
			form.setNamePreparerCde40(obj.getNamePreparerCde40());
		form.setPhonePreparerCde40(obj.getPhonePreparerCde40());
		if (obj.getEmailPreparerCde40() == null)
			form.setEmailPreparerCde40("");
		else
			form.setEmailPreparerCde40(obj.getEmailPreparerCde40());
		form.setFeesCollected(obj.getFeesCollected());
		form.setOtherRevenue(obj.getOtherRevenue());
		form.setNetCurrentOperExpend(obj.getNetCurrentOperExpend());
		form.setTotalReimMileage(obj.getTotalReimMileage());
		form.setMileageEntitlement(obj.getMileageEntitlement());
		form.setExCosts(obj.getExCosts());
		form.setMaxReimEntitlement(obj.getMaxReimEntitlement());
		form.setReimEntitlement(obj.getReimEntitlement());
		form.setTotalReimEntitlement(obj.getTotalReimEntitlement());
		form.setFinalReimEntitlement(obj.getFinalReimEntitlement());
		form.setFinalReimProrated(obj.getFinalReimProrated());
		form.setErrors(obj.getErrors());
		return form;
	}*/

	private TransportationForm initFormData() {
		TransportationForm form = new TransportationForm();
		form.setPupilTran(0l);
		form.setOperTran(0.00);

		form.setMigMiles(0.0);
		form.setRegDMiles(0.0);
		form.setSchoolDays(0l);
		form.setRegDays(0l);
		form.setBoardTran(0l);
		form.setAdvPay(0.00);
		form.setActMiles(0.0);
		form.setTotalMiles(0.00);
		form.setFeesCollected(0.00);
		form.setOtherRevenue(0.00);
		form.setNetCurrentOperExpend(0.00);
		form.setTotalReimMileage(0.0);
		form.setMileageEntitlement(0.0);
		form.setErrors(null); 
		return form;

	}

	/*
	 * @ This method calculates the Transportation related reimbursement fields depending upon the user input for the district
	 * @param - TransportationForm form - Contains data for transportation
	 * @return - void 
	 */
	/*public void calculateFinalReimEntitlement(TransportationForm form) {
		
		double reimburseTransLastYear = 0;
		double advancePaymentLastYear = 0;

		List<Transportation> transportationList = cde40TransReimbFormDAO.getByDistrictAndYear
															(form.getDistrictNumber(),
															  DateUtil.getPrevFiscalYear(form.getFiscalYear()));
		if (transportationList != null && transportationList.size() > 0) {
			logger.info("Transportation data received");
			Transportation prevYearTransportationData = transportationList.get(0);
			if (prevYearTransportationData != null
					&& prevYearTransportationData.getReimTran() != null) {
				Double reimTran = prevYearTransportationData.getReimTran();
				reimburseTransLastYear = reimTran.doubleValue();

			}
			if (prevYearTransportationData != null
					&& prevYearTransportationData.getAdvPay() != null) {
				Double advPay = prevYearTransportationData.getAdvPay();
				advancePaymentLastYear = advPay.doubleValue();

			}

		} else {
			logger.info("Transportation data not found for the last year for this district. Default to 0");
		}
		double totalCurrentOperExpense = (form.getOperTran() == null) ? 0 :form.getOperTran().doubleValue();
		double capitalOutlayCost =  (form.getCapOutTran() == null) ? 0 :form.getCapOutTran().doubleValue();
		double netCurrentOperExpend = totalCurrentOperExpense - capitalOutlayCost;
		double regdMiles = (form.getRegDMiles() == null) ? 0 :form.getRegDMiles().doubleValue();
		double migMiles = (form.getMigMiles() == null) ? 0 :form.getMigMiles().doubleValue();
		double schoolDays = (form.getSchoolDays()  == null) ? 0 :form.getSchoolDays().doubleValue();
		

		double totalRegularMileage = regdMiles * schoolDays;
		//form.setTotalMiles(totalRegularMileage);

		double totalReimburseMileage = migMiles + totalRegularMileage;
		form.setTotalReimMileage(totalReimburseMileage);

		double mileageEntitlement = totalReimburseMileage * 0.3787;
		form.setMileageEntitlement(mileageEntitlement);

		double excessCosts = netCurrentOperExpend - mileageEntitlement;
		form.setExCosts(excessCosts);

		double excessCostEntitlement = excessCosts * 0.3387;
		form.setExReim(excessCostEntitlement);
		
		double mileEntitleExcessCostEntitle = mileageEntitlement
				+ excessCostEntitlement;
		
		double maxReimbursement = netCurrentOperExpend * 0.90;
		form.setMaxReimEntitlement(maxReimbursement);

		double calcReimburseEntitleCY = maxReimbursement;

		if (mileEntitleExcessCostEntitle < maxReimbursement)
			calcReimburseEntitleCY = mileEntitleExcessCostEntitle;

		form.setReimTran(calcReimburseEntitleCY);
		//double calcReimburseEntitleLY = reimburseTransLastYear;
		double reimburseEntitleCY = (calcReimburseEntitleCY > reimburseTransLastYear) ? calcReimburseEntitleCY
				: reimburseTransLastYear;
		form.setReimEntitlement(reimburseEntitleCY);
		double boardTran = form.getBoardTran().doubleValue();
		double totalReimburseEntitleCY = reimburseEntitleCY + boardTran;
        form.setTotalReimEntitlement(totalReimburseEntitleCY);
		double finalReimburseEntCY = totalReimburseEntitleCY - advancePaymentLastYear;
		form.setFinalReimEntitlement(finalReimburseEntCY);
		double advanceReimburseEntitle = totalReimburseEntitleCY * 0.2;
		form.setAdvPay(advanceReimburseEntitle);
		form.setAdvPayLy(advancePaymentLastYear);
		form.setReimTranLy(reimburseTransLastYear);
	}*/ 

}
