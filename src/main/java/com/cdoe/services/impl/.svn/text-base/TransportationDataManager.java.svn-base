package com.cdoe.services.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.biz.transportation.ITransportationDAO;
import com.cdoe.rules.calc.Util;
import com.cdoe.ui.form.transportation.TransportationForm;
import com.cdoe.util.DateUtil;

public class TransportationDataManager extends BaseManager {

	private static final Logger logger = Logger
			.getLogger(TransportationDataManager.class);

	private ITransportationDAO transportationDAO;

	public void setTransportationDAO(ITransportationDAO transportationDAO) {
		this.transportationDAO = transportationDAO;
	}

	public void saveOrUpdate(TransportationForm form) {
		long id = form.getId();
		if (form.getFiscalYear() == null || "".equals(form.getFiscalYear()))
			form.setFiscalYear(DateUtil.getPrevFiscalYear());
		Transportation obj = getTransportationByDistrictCodeYear(form.getDistrictNumber(),form.getFiscalYear());
		if (obj == null) {
			obj = new Transportation();
		}
		
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

		obj.setNetCurrentOperExpend(form.getOperTran() - form.getCapOutTran());
        obj.setCapOutTran(form.getCapOutTran());
		obj.setMigMiles(form.getMigMiles());
		obj.setRegDMiles(form.getRegDMiles());
		obj.setSchoolDays(form.getSchoolDays());
		obj.setBoardTran(form.getBoardTran());
		obj.setTotalMiles(form.getTotalMiles());

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
		//obj.s
		obj.setExCosts(form.getExCosts());
		obj.setMaxReimEntitlement(form.getMaxReimEntitlement());
		obj.setReimEntitlement(form.getReimEntitlement());
		obj.setTotalReimEntitlement(form.getTotalReimEntitlement());
		obj.setFinalReimEntitlement(form.getFinalReimEntitlement());
		obj.setErrors("None");
		saveOrUpdate(obj);
	}

	public TransportationForm setupForm(long id) {
		Transportation obj = findById(Transportation.class, id);

		TransportationForm form = new TransportationForm();
		/*form.setId(obj.getId());
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
		form.setNamePreparerCde40(obj.getNamePreparerCde40());
		form.setPhonePreparerCde40(obj.getPhonePreparerCde40());
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
		form.setFinalReimProrated(obj.getFinalReimProrated());*/
		return form;
	}

	protected TransportationForm setFormData(Transportation obj) {
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
		form.setTotalRegMiles(obj.getRegDMiles() * obj.getSchoolDays());
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
		
		if (obj.getCapOutTran() == null)
			form.setNetCurrentOperExpend(obj.getOperTran());
		else
			form.setNetCurrentOperExpend(obj.getOperTran() - obj.getCapOutTran());
		
		if (obj.getTotalReimMileage() == null || obj.getTotalReimMileage() <= 0) 
			form.setTotalReimMileage(obj.getRegDMiles());
		else 	
			form.setTotalReimMileage(obj.getTotalReimMileage());
		form.setMileagePlusCostEntitlement(((obj.getMileageEntitlement() == null) ? 0: obj.getMileageEntitlement()) + ((obj.getExReim() == null)? 0 :obj.getExReim()));
		form.setMileageEntitlement(obj.getMileageEntitlement());
		form.setExCosts(obj.getExCosts());
		form.setMaxReimEntitlement(obj.getMaxReimEntitlement());
		form.setReimEntitlement(obj.getReimEntitlement());
		form.setTotalReimEntitlement(obj.getTotalReimEntitlement());
		form.setDistrictDistribution(obj.getDistrictDistribution());
		form.setFinalReimEntitlement(obj.getFinalReimEntitlement());
		form.setFinalReimProrated(obj.getFinalReimProrated());
		return form;
	}

	public void calculateFinalReimEntitlement(TransportationForm form) {

		double reimburseTransLastYear = 0;
		double advancePaymentLastYear = 0;

		List<Transportation> transportationList = transportationDAO.getByDistrictAndYear(form.getDistrictNumber(),
						DateUtil.getPrevFiscalYear(form.getFiscalYear()));
		if (transportationList != null && transportationList.size() > 0) {
			logger.info("Transportation data received");
			Transportation prevYearTransportationData = transportationList
					.get(0);
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
		
		double totalCurrentOperExpense = (form.getOperTran() == null) ? 0: form.getOperTran().doubleValue();
		double capitalOutlayCost =  (form.getCapOutTran() == null) ? 0 :form.getCapOutTran().doubleValue();
		form.setCapOutTran(capitalOutlayCost);
		double netCurrentOperExpend = totalCurrentOperExpense - capitalOutlayCost;
		form.setNetCurrentOperExpend(netCurrentOperExpend);
		double regdMiles = (form.getRegDMiles() == null) ? 0 : form.getRegDMiles().doubleValue();
		double schoolDays = (form.getSchoolDays() == null) ? 0 : form.getSchoolDays().doubleValue();

		double totalRegularMileage = regdMiles * schoolDays;
		form.setTotalRegMiles(totalRegularMileage);

		double totalReimburseMileage = totalRegularMileage;
		form.setTotalReimMileage(totalReimburseMileage);

		double mileageEntitlement = totalReimburseMileage * 0.3787;
		form.setMileageEntitlement(mileageEntitlement);

		double excessCosts = netCurrentOperExpend - mileageEntitlement;
		form.setExCosts(excessCosts);

		double excessCostEntitlement = excessCosts * 0.3387;
		form.setExReim(excessCostEntitlement);
		
		double mileagePlusCostEntitlement = mileageEntitlement + excessCostEntitlement;
		form.setMileagePlusCostEntitlement(mileagePlusCostEntitlement);
		
		double maxReimbursement = netCurrentOperExpend * 0.90;
		form.setMaxReimEntitlement(maxReimbursement);

		double calcReimburseEntitleCY = maxReimbursement;

		if (mileagePlusCostEntitlement < maxReimbursement)
			calcReimburseEntitleCY = mileagePlusCostEntitlement;

		form.setReimTran(calcReimburseEntitleCY);
		//double calcReimburseEntitleLY = reimburseTransLastYear;
		double reimburseEntitleCY = (calcReimburseEntitleCY > reimburseTransLastYear) ? calcReimburseEntitleCY : reimburseTransLastYear;
		form.setReimEntitlement(reimburseEntitleCY);
		double boardTran = form.getBoardTran().doubleValue();
		double actualReimburseEntitleCY = reimburseEntitleCY + boardTran;
		form.setTotalReimEntitlement(actualReimburseEntitleCY);
		double finalReimburseEntCY = actualReimburseEntitleCY - advancePaymentLastYear;
		form.setFinalReimEntitlement(finalReimburseEntCY);
		double advanceReimburseEntitle = actualReimburseEntitleCY * 0.2;
		form.setAdvPay(advanceReimburseEntitle);
		
		form.setAdvPayLy(advancePaymentLastYear);
		form.setReimTranLy(reimburseTransLastYear);
	}

	public int updateErrorStatus(final String districtNos,final String fiscalYear, String errorStatus) {
		return transportationDAO.updateErrorStatus(districtNos, fiscalYear,
				errorStatus);
	}

	protected Transportation getTransportationByDistrictCodeYear(String districtNos, String fiscalYear) {
		List<Transportation> transportationList = transportationDAO.getByDistrictAndYear(districtNos, fiscalYear);

		if (transportationList != null && transportationList.size() > 0) {
			logger.info("Transportation data received");
			Transportation transportationData = transportationList.get(0);
			return transportationData;
		}
		return null;
	}
	
	/*public void calculateSaveEntitlementForCOD(Transportation transportation, double capitalOutlayCost) {
		double reimburseTransLastYear = 0;
		double advancePaymentLastYear = 0;

		transportation.setCapOutTran(capitalOutlayCost);
		List<Transportation> transportationList = transportationDAO
				.getByDistrictAndYear(transportation.getDistrictNumber(),
						DateUtil.getPrevFiscalYear(transportation.getFiscalYear()));
		if (transportationList != null && transportationList.size() > 0) {
			logger.info("Transportation data received");
			Transportation prevYearTransportationData = transportationList.get(0);
			if (prevYearTransportationData != null
					&& prevYearTransportationData.getReimTran() != null) {
				Double reimTran = prevYearTransportationData.getReimTran();
				reimburseTransLastYear = reimTran.doubleValue();

			}
			if (prevYearTransportationData != null
					&& prevYearTransportationData.getAdvPayLy() != null) {
				Double advPay = prevYearTransportationData.getAdvPay();
				advancePaymentLastYear = advPay.doubleValue();

			}

		} else {
			logger.info("Transportation data not found for the last year for this district. Default to 0");
		}
		double netCurrentOperExpend = transportation.getOperTran() - capitalOutlayCost;
		
		double mileageEntitlement = transportation.getTotalReimMileage() * 0.3787;
	
		double excessCosts = netCurrentOperExpend - mileageEntitlement;
		transportation.setExCosts(Util.round(excessCosts,2));
	
		double excessCostEntitlement = excessCosts * 0.3387;
		transportation.setExReim(excessCostEntitlement);
		
		double mileEntitleExcessCostEntitle = mileageEntitlement
				+ excessCostEntitlement;
		
		double maxReimbursement = netCurrentOperExpend * 0.90;
		transportation.setMaxReimEntitlement(Util.round(maxReimbursement,2));
	
		double calcReimburseEntitleCY = maxReimbursement;
	
		if (mileEntitleExcessCostEntitle < maxReimbursement)
			calcReimburseEntitleCY = mileEntitleExcessCostEntitle;
	
		transportation.setReimTran(calcReimburseEntitleCY);
		double calcReimburseEntitleLY = reimburseTransLastYear;
		double reimburseEntitleCY = (calcReimburseEntitleCY > calcReimburseEntitleLY) ? calcReimburseEntitleCY
				: calcReimburseEntitleLY;
		transportation.setReimEntitlement(reimburseEntitleCY);
		double boardTran = transportation.getBoardTran().doubleValue();
		double actualReimburseEntitleCY = reimburseEntitleCY + boardTran;
	
		double advReimburseEntCY = advancePaymentLastYear;
		// form.setA
		double finalReimburseEntCY = actualReimburseEntitleCY
				- advReimburseEntCY;
		transportation.setFinalReimEntitlement(finalReimburseEntCY);
		double advanceReimburseEntitleNY = actualReimburseEntitleCY * 0.2;
		transportation.setAdvPay(advanceReimburseEntitleNY);
		saveOrUpdate(transportation);
	}*/
	
	


}
