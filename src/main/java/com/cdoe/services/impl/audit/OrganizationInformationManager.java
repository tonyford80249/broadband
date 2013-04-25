
package com.cdoe.services.impl.audit;

import org.apache.log4j.Logger;

import com.cdoe.biz.audit.IOrganizationInformationDAO;
import com.cdoe.biz.model.audit.Organization;
import com.cdoe.services.audit.IOrganizationInformationManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.ui.form.audit.OrganizationForm;

/**
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 * @version $Revision: $
 */

public class OrganizationInformationManager extends BaseManager implements IOrganizationInformationManager {

	private static final Logger logger = Logger.getLogger(OrganizationInformationManager.class);
	
	private IOrganizationInformationDAO organizationInformationDAO;
	
	public void saveOrUpdate(OrganizationForm form) {
		long id = form.getId();
		Organization obj = findById(Organization.class, id); 
		if (obj == null) {
			obj = new Organization();
		}
		obj.setUserId(form.getUserId());
		obj.setUpdateTimestamp(form.getUpdateTimestamp());
		obj.setDateClosed(form.getDateClosed());
		obj.setDateOpened(form.getDateOpened());
		obj.setAuditorComment(form.getAuditorComment());
		obj.setAuditFrequency(form.getAuditFrequency());
		obj.setOrganizationSize(form.getOrganizationSize());
		obj.setRegion(form.getRegion());
		obj.setCountyName(form.getCountyName());
		obj.setCountyCode(form.getCountyCode());
		obj.setOrganizationCode(form.getOrganizationCode());
		saveOrUpdate(obj);
	}
	
	public OrganizationForm setupForm() {
		OrganizationForm form = new OrganizationForm();
		return form;
	}
	
	public OrganizationForm setupForm(long id) {
		Organization obj = findById(Organization.class, id); 
		
		OrganizationForm form = new OrganizationForm();
		form.setId(obj.getId());
		form.setUserId(obj.getUserId());
		form.setUpdateTimestamp(obj.getUpdateTimestamp());
		form.setDateClosed(obj.getDateClosed());
		form.setDateOpened(obj.getDateOpened());
		form.setAuditorComment(obj.getAuditorComment());
		form.setAuditFrequency(obj.getAuditFrequency());
		form.setOrganizationSize(obj.getOrganizationSize());
		form.setRegion(obj.getRegion());
		form.setCountyName(obj.getCountyName());
		form.setCountyCode(obj.getCountyCode());
		form.setOrganizationCode(obj.getOrganizationCode());
		return form;
	}
	
	public void setOrganizationInformationDAO(IOrganizationInformationDAO organizationInformationDAO) {
		this.organizationInformationDAO = organizationInformationDAO;
	}
	
}
