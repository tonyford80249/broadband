
package com.cdoe.services.impl.audit;

import org.apache.log4j.Logger;

import com.cdoe.biz.audit.IDataAdminDAO;
import com.cdoe.biz.model.audit.AuditorRole;
import com.cdoe.services.audit.IDataAdminManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.ui.form.audit.AuditorRoleForm;

/**
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 * @version $Revision: $
 */

public class DataAdminManager extends BaseManager implements IDataAdminManager {

	private static final Logger logger = Logger.getLogger(DataAdminManager.class);
	
	private IDataAdminDAO dataAdminDAO;
	
	public void saveOrUpdate(AuditorRoleForm form) {
		long id = form.getId();
		AuditorRole obj = findById(AuditorRole.class, id); 
		if (obj == null) {
			obj = new AuditorRole();
		}
		obj.setUserId(form.getUserId());
		obj.setUpdateTimestamp(form.getUpdateTimestamp());
		obj.setEmployedDate(form.getEmployedDate());
		obj.setAuditorId(form.getAuditorId());
		obj.setEndDate(form.getEndDate());
		obj.setAuditRole(form.getAuditRole());
		obj.setAuditorName(form.getAuditorName());
		saveOrUpdate(obj);
	}
	
	public AuditorRoleForm setupForm() {
		AuditorRoleForm form = new AuditorRoleForm();
		return form;
	}
	
	public AuditorRoleForm setupForm(long id) {
		AuditorRole obj = findById(AuditorRole.class, id); 
		
		AuditorRoleForm form = new AuditorRoleForm();
		form.setId(obj.getId());
		form.setUserId(obj.getUserId());
		form.setUpdateTimestamp(obj.getUpdateTimestamp());
		form.setEmployedDate(obj.getEmployedDate());
		form.setAuditorId(obj.getAuditorId());
		form.setEndDate(obj.getEndDate());
		form.setAuditRole(obj.getAuditRole());
		form.setAuditorName(obj.getAuditorName());
		return form;
	}
	
	public void setDataAdminDAO(IDataAdminDAO dataAdminDAO) {
		this.dataAdminDAO = dataAdminDAO;
	}
	
}
