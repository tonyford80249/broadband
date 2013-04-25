
package com.cdoe.services.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.services.ICoforsUploadManager;
import com.cdoe.biz.ICoforsUploadDAO;
import com.cdoe.biz.model.*;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.ui.form.transportation.TransportationForm;

public class CoforsUploadManager extends BaseManager implements ICoforsUploadManager {

	private static final Logger logger = Logger.getLogger(CoforsUploadManager.class);
	
	private ICoforsUploadDAO coforsUploadDAO;
	
	public void saveOrUpdate(TransportationForm form) {
		long id = form.getId();
		Transportation obj = findById(Transportation.class, id); 
		if (obj == null) {
			obj = new Transportation();
		}
		obj.setDistrictNumber(form.getDistrictNumber());
		obj.setDateChanged(form.getDateChanged());
		obj.setErrors(form.getErrors());
		obj.setPupilTran(form.getPupilTran());
		obj.setOperTran(form.getOperTran());
		obj.setIndCont(form.getIndCont());
		obj.setCapOutTran(form.getCapOutTran());
		obj.setMigMiles(form.getMigMiles());
		obj.setRegDMiles(form.getRegDMiles());
		obj.setSchoolDays(form.getSchoolDays());
		obj.setRegDays(form.getRegDays());
		obj.setBoardTran(form.getBoardTran());
		obj.setExReim(form.getExReim());
		obj.setDesegReim(form.getDesegReim());
		obj.setReimTran(form.getReimTran());
		obj.setReimTranLy(form.getReimTranLy());
		obj.setAdvPayLy(form.getAdvPayLy());
		obj.setReimAdvPay(form.getReimAdvPay());
		obj.setAdvPay(form.getAdvPay());
		obj.setActMiles(form.getActMiles());
		obj.setTotalMiles(form.getTotalMiles());
		obj.setFiscalYear(form.getFiscalYear());
		obj.setCdeComments(form.getCdeComments());
		obj.setFirstPayment(form.getFirstPayment());
		obj.setSecondPayment(form.getSecondPayment());
		obj.setDistrictDistribution(form.getDistrictDistribution());
		obj.setCofrsBatchNumber(form.getCofrsBatchNumber());
		obj.setCofrsDatePaid(form.getCofrsDatePaid());
		obj.setNamePreparerCde40(form.getNamePreparerCde40());
		obj.setPhonePreparerCde40(form.getPhonePreparerCde40());
		obj.setEmailPreparerCde40(form.getEmailPreparerCde40());
		obj.setFeesCollected(form.getFeesCollected());
		obj.setOtherRevenue(form.getOtherRevenue());
		obj.setNetCurrentOperExpend(form.getNetCurrentOperExpend());
		obj.setTotalReimMileage(form.getTotalReimMileage());
		obj.setMileageEntitlement(form.getMileageEntitlement());
		obj.setExCosts(form.getExCosts());
		obj.setMaxReimEntitlement(form.getMaxReimEntitlement());
		obj.setReimEntitlement(form.getReimEntitlement());
		obj.setTotalReimEntitlement(form.getTotalReimEntitlement());
		obj.setFinalReimEntitlement(form.getFinalReimEntitlement());
		obj.setFinalReimProrated(form.getFinalReimProrated());
		saveOrUpdate(obj);
	}
	
	public TransportationForm setupForm() {
		TransportationForm form = new TransportationForm();
		return form;
	}
	
	public TransportationForm setupForm(long id) {
		Transportation obj = findById(Transportation.class, id); 
		
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
		form.setFinalReimProrated(obj.getFinalReimProrated());
		return form;
	}
	
	public void setCoforsUploadDAO(ICoforsUploadDAO coforsUploadDAO) {
		this.coforsUploadDAO = coforsUploadDAO;
	}
	
}
