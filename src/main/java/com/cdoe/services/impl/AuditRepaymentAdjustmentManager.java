/**
 * 
 */
package com.cdoe.services.impl;

import com.cdoe.biz.IAuditRepaymentAdjustmentDAO;
import com.cdoe.biz.model.AuditRepaymentAdjustment;
import com.cdoe.services.IAuditRepaymentAdjustmentManager;
import com.cdoe.ui.form.stateequal.AuditRepaymentAdjustmentForm;
import com.cdoe.util.DateUtil;

/**
 * @author dyn-8
 *
 */
public class AuditRepaymentAdjustmentManager extends BaseManager implements IAuditRepaymentAdjustmentManager {
	
	/**
	 * Saves the AuditRepaymentAdjustmentForm.  Transforms it to the dto.  Does
	 * checks to see if the form is new or not
	 * 
	 * @param form
	 */
	public void saveOrUpdate(AuditRepaymentAdjustmentForm form) {
		AuditRepaymentAdjustment dto = null;
		if (form.getId() != null && form.getId().longValue() > 0) {
			// we know this is an edit - so find it
			dto = getHibernateDAO().findByPk(AuditRepaymentAdjustment.class, form.getId());
		} else {
			// this could be new, but the user could inadvertently update
			// an existing row, so check for that
			
			AuditRepaymentAdjustment model = new AuditRepaymentAdjustment();
			model.setBeginFiscalMonth(DateUtil.getMonthNos(form.getBeginFiscalMonth()));
			model.setBeginFiscalYear(form.getBeginFiscalYear());
			model.setEndFiscalMonth(DateUtil.getMonthNos(form.getEndFiscalMonth()));
			model.setEndFiscalYear(form.getEndFiscalYear());
			model.setDistrictNumber(form.getDistrictNumber());

			dto = ((IAuditRepaymentAdjustmentDAO)getHibernateDAO()).findByUniqueKey(model);
			// If we didn't find one, create a new one
			if (dto == null) {
				dto = new AuditRepaymentAdjustment();
				dto.setBeginFiscalMonth(DateUtil.getMonthNos(form.getBeginFiscalMonth()));
				dto.setBeginFiscalYear(form.getBeginFiscalYear());
				dto.setEndFiscalMonth(DateUtil.getMonthNos(form.getEndFiscalMonth()));
				dto.setEndFiscalYear(form.getEndFiscalYear());
				dto.setDistrictNumber(form.getDistrictNumber());
			}
		}
		dto.setFrequency(form.getFrequency());
		dto.setAmount(form.getAmount());
		this.saveOrUpdate(dto);
	}

	/**
	 * Returns the AuditRepaymentAdjustmentForm given the id.  Transforms the dto to the form
	 * @param id
	 * @return
	 */
	public AuditRepaymentAdjustmentForm getAuditRepaymentAdjustmentForm(Long id) {
		AuditRepaymentAdjustment dto = getHibernateDAO().findByPk(AuditRepaymentAdjustment.class, id);
		AuditRepaymentAdjustmentForm form = new AuditRepaymentAdjustmentForm();
		if (dto != null) {
			form.setId(dto.getId());
			form.setAmount(dto.getAmount());
			form.setBeginFiscalMonth(dto.getBeginFiscalMonth());
			form.setBeginFiscalYear(dto.getBeginFiscalYear());
			form.setEndFiscalMonth(dto.getEndFiscalMonth());
			form.setEndFiscalYear(dto.getEndFiscalYear());
			form.setDistrictNumber(dto.getDistrictNumber());
			form.setFrequency(dto.getFrequency());
		}
		return form;
	}

}
