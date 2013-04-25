
package com.cdoe.services.impl.audit;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.services.audit.IValidateSASIDsManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.biz.audit.IValidateSASIDsDAO;
import com.cdoe.biz.model.*;
import com.cdoe.biz.model.audit.AuditSasidException;
import com.cdoe.ui.form.audit.AuditSasidExceptionForm;

public class ValidateSASIDsManager extends BaseManager implements IValidateSASIDsManager {

	private static final Logger logger = Logger.getLogger(ValidateSASIDsManager.class);
	
	private IValidateSASIDsDAO validateSASIDsDAO;
	
	public void saveOrUpdate(AuditSasidExceptionForm form) {
		long id = form.getId();
		AuditSasidException obj = findById(AuditSasidException.class, id); 
		if (obj == null) {
			obj = new AuditSasidException();
		}
		/*obj.setSupervisor(form.getSupervisor());
		obj.setSecondaryAuditorComments(form.getSecondaryAuditorComments());
		obj.setFinalizedBy(form.getFinalizedBy());
		obj.setReviewedBy(form.getReviewedBy());
		obj.setReclosedAfterAppeal(form.getReclosedAfterAppeal());
		obj.setAuditRefinalized(form.getAuditRefinalized());
		obj.setAuditReopened(form.getAuditReopened());
		obj.setAuditClosed(form.getAuditClosed());
		obj.setReportAppealed(form.getReportAppealed());
		obj.setDraftReportIssued(form.getDraftReportIssued());
		obj.setDraftReportCompleted(form.getDraftReportCompleted());
		obj.setInitialFieldWorkCompleted(form.getInitialFieldWorkCompleted());
		obj.setFieldWorkStarted(form.getFieldWorkStarted());
		obj.setDistrictContacted(form.getDistrictContacted());
		obj.setTotalAuditLiability(form.getTotalAuditLiability());
		obj.setReportFinalized(form.getReportFinalized());
		obj.setPrimaryAuditorComments(form.getPrimaryAuditorComments());
		obj.setSupervisorComments(form.getSupervisorComments());
		obj.setAuditType(form.getAuditType());
		obj.setOpenDate(form.getOpenDate());
		obj.setFiscalYear5(form.getFiscalYear5());
		obj.setFiscalYear4(form.getFiscalYear4());
		obj.setFiscalYear3(form.getFiscalYear3());
		obj.setFiscalYear2(form.getFiscalYear2());
		obj.setFiscalYear1(form.getFiscalYear1());
		obj.setAlert(form.getAlert());
		obj.setAuditFrequency(form.getAuditFrequency());
		obj.setProgress(form.getProgress());
		obj.setSecondaryAuditor(form.getSecondaryAuditor());
		obj.setPrimaryAuditor(form.getPrimaryAuditor());
		obj.setStatusDate(form.getStatusDate());
		obj.setAuditStatus(form.getAuditStatus());
		obj.setOrganizationCode(form.getOrganizationCode());
		obj.setAuditId(form.getAuditId());*/
		saveOrUpdate(obj);
	}
	
	public AuditSasidExceptionForm setupForm() {
		AuditSasidExceptionForm form = new AuditSasidExceptionForm();
		return form;
	}
	
	public AuditSasidExceptionForm setupForm(long id) {
		AuditSasidException obj = findById(AuditSasidException.class, id); 
		
		AuditSasidExceptionForm form = new AuditSasidExceptionForm();
		form.setId(obj.getId());
		/* This is really AuditTrackingForm code
		 * form.setSupervisor(obj.getSupervisor());
		 
		form.setSecondaryAuditorComments(obj.getSecondaryAuditorComments());
		form.setFinalizedBy(obj.getFinalizedBy());
		form.setReviewedBy(obj.getReviewedBy());
		form.setReclosedAfterAppeal(obj.getReclosedAfterAppeal());
		form.setAuditRefinalized(obj.getAuditRefinalized());
		form.setAuditReopened(obj.getAuditReopened());
		form.setAuditClosed(obj.getAuditClosed());
		form.setReportAppealed(obj.getReportAppealed());
		form.setDraftReportIssued(obj.getDraftReportIssued());
		form.setDraftReportCompleted(obj.getDraftReportCompleted());
		form.setInitialFieldWorkCompleted(obj.getInitialFieldWorkCompleted());
		form.setFieldWorkStarted(obj.getFieldWorkStarted());
		form.setDistrictContacted(obj.getDistrictContacted());
		form.setTotalAuditLiability(obj.getTotalAuditLiability());
		form.setReportFinalized(obj.getReportFinalized());
		form.setPrimaryAuditorComments(obj.getPrimaryAuditorComments());
		form.setSupervisorComments(obj.getSupervisorComments());
		form.setAuditType(obj.getAuditType());
		form.setOpenDate(obj.getOpenDate());
		form.setFiscalYear5(obj.getFiscalYear5());
		form.setFiscalYear4(obj.getFiscalYear4());
		form.setFiscalYear3(obj.getFiscalYear3());
		form.setFiscalYear2(obj.getFiscalYear2());
		form.setFiscalYear1(obj.getFiscalYear1());
		form.setAlert(obj.getAlert());
		form.setAuditFrequency(obj.getAuditFrequency());
		form.setProgress(obj.getProgress());
		form.setSecondaryAuditor(obj.getSecondaryAuditor());
		form.setPrimaryAuditor(obj.getPrimaryAuditor());
		form.setStatusDate(obj.getStatusDate());
		form.setAuditStatus(obj.getAuditStatus());
		form.setOrganizationCode(obj.getOrganizationCode());
		form.setAuditId(obj.getAuditId());*/
		return form;
	}
	
	public void setValidateSASIDsDAO(IValidateSASIDsDAO validateSASIDsDAO) {
		this.validateSASIDsDAO = validateSASIDsDAO;
	}
	
}
