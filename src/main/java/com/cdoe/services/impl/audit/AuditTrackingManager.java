
package com.cdoe.services.impl.audit;

import org.apache.log4j.Logger;

import com.cdoe.biz.IAudSumUpdateDAO;
import com.cdoe.biz.model.audit.AuditEqual;
import com.cdoe.services.audit.IAuditTrackingManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.ui.form.audit.AuditTrackingForm;

public class AuditTrackingManager extends BaseManager implements IAuditTrackingManager {

	private static final Logger logger = Logger.getLogger(AuditTrackingManager.class);
	
	private IAudSumUpdateDAO audSumUpdateDAO;
	
	public void saveOrUpdate(AuditTrackingForm form) {
		long id = form.getId();
		AuditEqual obj = findById(AuditEqual.class, id); 
		if (obj == null) {
			obj = new AuditEqual();
		}
		//obj.setDistrictNumber(form.getDistrictNumber());
		//obj.setDateChanged(form.getDateChanged());
		//obj.setChangeType(form.getChangeType());
		//obj.setAdjFpc(form.getAdjFpc());
		//obj.setPreschool(form.getPreschool());
		//obj.setSpecedEnroll(form.getSpecedEnroll());
		//obj.setFpc(form.getFpc());
		//obj.setAssessedVal(form.getAssessedVal());
		//obj.setCatTrans(form.getCatTrans());
		//obj.setCatVoced(form.getCatVoced());
		//obj.setCatElpa(form.getCatElpa());
		//obj.setCatSpedDis(form.getCatSpedDis());
		//obj.setCatSpedGt(form.getCatSpedGt());
		//obj.setSizeAdjust(form.getSizeAdjust());
		//obj.setColAdjust(form.getColAdjust());
		//obj.setPersCostFactor(form.getPersCostFactor());
		//obj.setTotProg(form.getTotProg());
		//obj.setFreeLunch18(form.getFreeLunch18());
		//obj.setFreeLunchK12(form.getFreeLunchK12());
		//obj.setMember18(form.getMember18());
		//obj.setTotProgAtRisk(form.getTotProgAtRisk());
		//obj.setGrandTotProg(form.getGrandTotProg());
		//obj.setSpecOwnTax(form.getSpecOwnTax());
		//obj.setMillLevyCalc(form.getMillLevyCalc());
		//obj.setPropertyTax(form.getPropertyTax());
		//obj.setStateEqual(form.getStateEqual());
		//obj.setMillLevyCert(form.getMillLevyCert());
		//obj.setMillLevyAdj(form.getMillLevyAdj());
		//obj.setMonthEntitle(form.getMonthEntitle());
		//obj.setYtdEntitle(form.getYtdEntitle());
		//obj.setMonthPayment(form.getMonthPayment());
		//obj.setYtdPayment(form.getYtdPayment());
		//obj.setPropTxCfY0(form.getPropTxCfY0());
		//obj.setAdjY0Oods(form.getAdjY0Oods());
		//obj.setYtdY0Oods(form.getYtdY0Oods());
		//obj.setAdjY0Other(form.getAdjY0Other());
		//obj.setYtdY0Other(form.getYtdY0Other());
		//obj.setAdjY0Swap(form.getAdjY0Swap());
		//obj.setYtdY0Swap(form.getYtdY0Swap());
		//obj.setAllowSpend(form.getAllowSpend());
		//obj.setOverLevyCalc(form.getOverLevyCalc());
		//obj.setHhLevyCalc(form.getHhLevyCalc());
		//obj.setCatLevyAdj(form.getCatLevyAdj());
		//obj.setCatLevyCert(form.getCatLevyCert());
		//obj.setCatLevyCalc(form.getCatLevyCalc());
		//obj.setPropTaxCfCap(form.getPropTaxCfCap());
		//obj.setTotProgTabor(form.getTotProgTabor());
		//obj.setTotForm2(form.getTotForm2());
		//obj.setTotMax6(form.getTotMax6());
		//obj.setTotAddFund(form.getTotAddFund());
		//obj.setOctY1Mem(form.getOctY1Mem());
		//obj.setTotAtRiskAr6(form.getTotAtRiskAr6());
		//obj.setFmPupFundPp7(form.getFmPupFundPp7());
		//obj.setFmAtRiskAr20(form.getFmAtRiskAr20());
		//obj.setVoteLevyCalc(form.getVoteLevyCalc());
		//obj.setOthCdeAdj(form.getOthCdeAdj());
		//obj.setVoterOverride(form.getVoterOverride());
		//obj.setFundedCntY1(form.getFundedCntY1());
		//obj.setFundedCntY2(form.getFundedCntY2());
		//obj.setFundedCntY3(form.getFundedCntY3());
		//obj.setMinFormulaFund(form.getMinFormulaFund());
		//obj.setTotAddFundV63(form.getTotAddFundV63());
		//obj.setAdjTotFundGt3(form.getAdjTotFundGt3());
		//obj.setAdjStateAssess(form.getAdjStateAssess());
		//obj.setFundedCntY0(form.getFundedCntY0());
		//obj.setChrtrSchlCnt(form.getChrtrSchlCnt());
		//obj.setSmlCntrPymnts(form.getSmlCntrPymnts());
		//obj.setMinSizeAdjust(form.getMinSizeAdjust());
		//obj.setEslCsap(form.getEslCsap());
		//obj.setOnLineCntY0(form.getOnLineCntY0());
		//obj.setOnLineCntY1(form.getOnLineCntY1());
		//obj.setPreschool5(form.getPreschool5());
		//obj.setAdjY0ChrtrDbt(form.getAdjY0ChrtrDbt());
		//obj.setYtdY0ChrtrDbt(form.getYtdY0ChrtrDbt());
		//obj.setCsiY0Share(form.getCsiY0Share());
		//obj.setYtdY0CdeAdj(form.getYtdY0CdeAdj());
		//obj.setPropertyTaxY1(form.getPropertyTaxY1());
		//obj.setMillLevyY1(form.getMillLevyY1());
		//obj.setFundedCntY4(form.getFundedCntY4());
		//obj.setSbsf(form.getSbsf());
		//obj.setSbsfCatBuyout(form.getSbsfCatBuyout());
		//obj.setDistChrtrCntY1(form.getDistChrtrCntY1());
		//obj.setDistChrtrCntY2(form.getDistChrtrCntY2());
		//obj.setDistChrtrCntY3(form.getDistChrtrCntY3());
		//obj.setDistChrtrCntY4(form.getDistChrtrCntY4());
		//obj.setAdjY0Audit(form.getAdjY0Audit());
		//obj.setYtdY0Audit(form.getYtdY0Audit());
		//obj.setFiscalYear(form.getFiscalYear());
		saveOrUpdate(obj);
	}
	
	public AuditTrackingForm setupForm() {
		AuditTrackingForm form = new AuditTrackingForm();
		return form;
	}
	
	public AuditTrackingForm setupForm(long id) {
		AuditEqual obj = findById(AuditEqual.class, id); 
		
		AuditTrackingForm form = new AuditTrackingForm();
		form.setId(obj.getId());
		
		return form;
	}
	
	public void setAudSumUpdateDAO(IAudSumUpdateDAO audSumUpdateDAO) {
		this.audSumUpdateDAO = audSumUpdateDAO;
	}
	
}
