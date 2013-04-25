
package com.cdoe.services.impl.transportation;

import java.io.IOException;
import java.util.List;

//import jxl.write.WriteException;

import org.apache.log4j.Logger;

import com.cdoe.biz.IDistrictPaymentReportDAO;
import com.cdoe.biz.model.transportation.Prorate;
import com.cdoe.biz.model.transportation.Transportation;
//import com.cdoe.excel.DistrictPaymentExcel;
import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.IDistrictPaymentReportManager;
import com.cdoe.ui.form.grid.ProrateTransportationGrid;
import com.cdoe.ui.form.transportation.ProrateForm;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;

public class DistrictPaymentReportManager extends BaseManager implements IDistrictPaymentReportManager {

	private static final Logger logger = Logger.getLogger(DistrictPaymentReportManager.class);
	
	private IDistrictPaymentReportDAO districtPaymentReportDAO;
	private IReferenceDataManager referenceDataManager;
	
	public void saveOrUpdate(ProrateForm form) {
		long id = form.getId();
		Prorate obj = findById(Prorate.class, id); 
		if (obj == null) {
			obj = new Prorate();
		}
		obj.setFiscalYear(form.getFiscalYear());
		obj.setProrateFactor1stPayment(form.getProrateFactor1stPayment());
		obj.setProrateFactor2ndPayment(form.getProrateFactor2ndPayment());
		obj.setFundingSources(form.getFundingSources());
		obj.setTotalFirstPayment(form.getTotalFirstPayment());
		obj.setTotalSecondPayment(form.getTotalSecondPayment());
		obj.setTotalDistribution(form.getTotalDistribution());
		saveOrUpdate(obj);
	}
	
	public ProrateForm setupForm(String fiscalYear, UserInfo userInfo) {
		ProrateForm form = new ProrateForm();
		//String fiscalYear = DateUtil.getFiscalYear(); //"20112012";
		List<Prorate> prorateList = districtPaymentReportDAO.getDistrictPaymentReport(fiscalYear);
		
		if (prorateList != null && prorateList.size() > 0) {
			logger.info("Prorate data received");
			form = setProrateFormData(form, prorateList.get(0));

		} else {
			logger.info("Prorate data not found");
		}
		List<Transportation> transportationList = districtPaymentReportDAO.getTransportationByFiscalYear(fiscalYear);
		if (transportationList != null && transportationList.size() > 0) {
			logger.info("Transportation data received");
			form = setTransportationData(form, transportationList, userInfo);

		} else {
			logger.info("Transportation data not found");
		}
		return form;
	}
	
	public ProrateForm setProrateFormData(ProrateForm form, Prorate obj) {
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
	/*
	 * Set the transportation list for the grid
	 */
	public ProrateForm setTransportationData(ProrateForm form, List<Transportation> transportationList,UserInfo userInfo) {
		List<ProrateTransportationGrid> ltg = form.getProrateTransportationGridList();
		for (Transportation a : transportationList) {
			ProrateTransportationGrid transGrid = new ProrateTransportationGrid();
			transGrid.setDistrictNumber(a.getDistrictNumber());
		    transGrid.setOrganizationName(userInfo.getDistrictMap().get(a.getDistrictNumber()));
			transGrid.setFirstPayment(a.getFirstPayment());
			transGrid.setSecondPayment(a.getSecondPayment());
			transGrid.setDistrictDistribution(a.getDistrictDistribution());
			ltg.add(transGrid);
		}
		
		return form;
	}
	
	/*
	 * Not being used
	 * (non-Javadoc)
	 * @see com.cdoe.services.IDistrictPaymentReportManager#setupForm(long)
	 */
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
	
//	public void setDistrictPaymentExcel(DistrictPaymentExcel districtPaymentExcel) {
//		this.districtPaymentExcel = districtPaymentExcel;
//	}
	public void setDistrictPaymentReportDAO(IDistrictPaymentReportDAO districtPaymentReportDAO) {
		this.districtPaymentReportDAO = districtPaymentReportDAO;
	}
	
	public void setReferenceDataManager(IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}

	public void createDistrictReport(String fileName, ProrateForm form ) throws IOException{ //, WriteException {
	//	DistrictPaymentExcel disPayExcel = new DistrictPaymentExcel();
	//	disPayExcel.setOutputFile("c://cdoe//PaymentReport.xls");
	//	disPayExcel.setOutputFile(fileName);
	//	disPayExcel.write(form);
		
		
	}
	
}
