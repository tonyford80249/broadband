
package com.cdoe.services.impl.audit;

import org.apache.log4j.Logger;

import com.cdoe.biz.IAudCDE40TransReimbFormDAO;
import com.cdoe.biz.model.audit.AuditTran;
import com.cdoe.services.audit.IAudCDE40TransReimbFormManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.ui.form.audit.AuditTranForm;

public class AudCDE40TransReimbFormManager extends BaseManager implements IAudCDE40TransReimbFormManager {

	private static final Logger logger = Logger.getLogger(AudCDE40TransReimbFormManager.class);
	
	private IAudCDE40TransReimbFormDAO audCDE40TransReimbFormDAO;
	
	public void saveOrUpdate(AuditTranForm form) {
		long id = form.getId();
		AuditTran obj = findById(AuditTran.class, id); 
		if (obj == null) {
			obj = new AuditTran();
		}
		obj.setAuditId(form.getAuditId());
		obj.setFiscalYear(form.getFiscalYear());
		obj.setTotalMiles(form.getTotalMiles());
		obj.setActMiles(form.getActMiles());
		obj.setAdvPay(form.getAdvPay());
		obj.setReimAdvPay(form.getReimAdvPay());
		obj.setAdvPayLy(form.getAdvPayLy());
		obj.setReimTranLy(form.getReimTranLy());
		obj.setReimTran(form.getReimTran());
		obj.setDesegReim(form.getDesegReim());
		obj.setExReim(form.getExReim());
		obj.setBoardTran(form.getBoardTran());
		obj.setRegMiles(form.getRegMiles());
		obj.setSchoolDays(form.getSchoolDays());
		obj.setPupilTran(form.getPupilTran());
		obj.setOperTran(form.getOperTran());
		obj.setIndCont(form.getIndCont());
		obj.setCapOutTran(form.getCapOutTran());
		obj.setMigMiles(form.getMigMiles());
		obj.setRegDMiles(form.getRegDMiles());
		obj.setChangeType(form.getChangeType());
		obj.setDateChanged(form.getDateChanged());
		obj.setDistrictNumber(form.getDistrictNumber());
		saveOrUpdate(obj);
	}
	
	public AuditTranForm setupForm() {
		AuditTranForm form = new AuditTranForm();
		return form;
	}
	
	public AuditTranForm setupForm(long id) {
		AuditTran obj = findById(AuditTran.class, id); 
		
		AuditTranForm form = new AuditTranForm();
		form.setId(obj.getId());
		form.setAuditId(obj.getAuditId());
		form.setFiscalYear(obj.getFiscalYear());
		form.setTotalMiles(obj.getTotalMiles());
		form.setActMiles(obj.getActMiles());
		form.setAdvPay(obj.getAdvPay());
		form.setReimAdvPay(obj.getReimAdvPay());
		form.setAdvPayLy(obj.getAdvPayLy());
		form.setReimTranLy(obj.getReimTranLy());
		form.setReimTran(obj.getReimTran());
		form.setDesegReim(obj.getDesegReim());
		form.setExReim(obj.getExReim());
		form.setBoardTran(obj.getBoardTran());
		form.setRegMiles(obj.getRegMiles());
		form.setSchoolDays(obj.getSchoolDays());
		form.setPupilTran(obj.getPupilTran());
		form.setOperTran(obj.getOperTran());
		form.setIndCont(obj.getIndCont());
		form.setCapOutTran(obj.getCapOutTran());
		form.setMigMiles(obj.getMigMiles());
		form.setRegDMiles(obj.getRegDMiles());
		form.setChangeType(obj.getChangeType());
		form.setDateChanged(obj.getDateChanged());
		form.setDistrictNumber(obj.getDistrictNumber());
		return form;
	}
	
	public void setAudCDE40TransReimbFormDAO(IAudCDE40TransReimbFormDAO audCDE40TransReimbFormDAO) {
		this.audCDE40TransReimbFormDAO = audCDE40TransReimbFormDAO;
	}
	
}
