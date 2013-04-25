
package com.cdoe.services.impl.audit;

import com.cdoe.biz.audit.IAuditElpaDAO;
import com.cdoe.biz.model.audit.AuditElpa;
import com.cdoe.services.audit.IELPAUpdateManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.ui.form.audit.AuditElpaForm;

/**
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 * @version $Revision: $
 */

public class ELPAUpdateManager extends BaseManager implements IELPAUpdateManager {

	//private static final Logger logger = Logger.getLogger(AuditElpaManager.class);
	
	private IAuditElpaDAO elpaUpdateDAO;
	
	public void saveOrUpdate(AuditElpaForm form) {
		long id = form.getId();
		AuditElpa obj = findById(AuditElpa.class, id); 
		if (obj == null) {
			obj = new AuditElpa();
		}
		obj.setUserId(form.getUserId());
		obj.setUpdateTimestamp(form.getUpdateTimestamp());
		obj.setOrganizationCode(form.getOrganizationCode());
		obj.setTotalAllocationDifference(form.getTotalAllocationDifference());
		obj.setAuditTotalAllocation(form.getAuditTotalAllocation());
		obj.setAuditCTotal(form.getAuditCTotal());
		obj.setAuditAbTotal(form.getAuditAbTotal());
		obj.setOrgTotalAllocation(form.getOrgTotalAllocation());
		obj.setOrgCTotal(form.getOrgCTotal());
		obj.setOrgAbTotal(form.getOrgAbTotal());
		obj.setCRate(form.getCRate());
		obj.setAbRate(form.getAbRate());
		obj.setAuditId(form.getAuditId());
		obj.setFiscalYear(form.getFiscalYear());
		saveOrUpdate(obj);
	}
	
	public AuditElpaForm setupForm() {
		AuditElpaForm form = new AuditElpaForm();
		return form;
	}
	 
	public AuditElpaForm setupForm(long id) {
		AuditElpa obj = findById(AuditElpa.class, id); 
		
		AuditElpaForm form = new AuditElpaForm();
		form.setId(obj.getId());
		form.setUserId(obj.getUserId());
		form.setUpdateTimestamp(obj.getUpdateTimestamp());
		form.setOrganizationCode(obj.getOrganizationCode());
		form.setTotalAllocationDifference(obj.getTotalAllocationDifference());
		form.setAuditTotalAllocation(obj.getAuditTotalAllocation());
		form.setAuditCTotal(obj.getAuditCTotal());
		form.setAuditAbTotal(obj.getAuditAbTotal());
		form.setOrgTotalAllocation(obj.getOrgTotalAllocation());
		form.setOrgCTotal(obj.getOrgCTotal());
		form.setOrgAbTotal(obj.getOrgAbTotal());
		form.setCRate(obj.getCRate());
		form.setAbRate(obj.getAbRate());
		form.setAuditId(obj.getAuditId());
		form.setFiscalYear(obj.getFiscalYear());
		return form;
	}
	
	public void setChangeELPADAO(IAuditElpaDAO elpaUpdateDAO) {
		this.elpaUpdateDAO = elpaUpdateDAO;
	}
	
}
