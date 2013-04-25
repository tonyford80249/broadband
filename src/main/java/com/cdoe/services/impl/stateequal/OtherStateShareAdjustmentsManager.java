/**
 * 
 */
package com.cdoe.services.impl.stateequal;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.IOtherStateShareAdjustmentsManager;
import com.cdoe.ui.form.stateequal.OtherStateShareAdjustmentsForm;
import com.cdoe.util.DateUtil;

/**
 * @author dyn-8
 *
 */
public class OtherStateShareAdjustmentsManager extends BaseManager implements
		IOtherStateShareAdjustmentsManager {
	
	private final Logger logger = Logger.getLogger(OtherStateShareAdjustmentsManager.class);
	
	private IStateEqualDAO stateEqualDAO;
	
	/**
	 * Injector method
	 * @param stateEqualDAO
	 */
	public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
		this.stateEqualDAO = stateEqualDAO;
	}

	/* (non-Javadoc)
	 * @see com.cdoe.services.IOtherStateShareAdjustmentsManager#saveOrUpdate(com.cdoe.ui.form.OtherStateShareAdjustmentsForm)
	 */
	@Override
	public void saveOrUpdate(OtherStateShareAdjustmentsForm form) {
		StateEqual dto = stateEqualDAO.findLatest(form.getDistrictNumber(), DateUtil.getFullFiscalYearFromShort(form.getFiscalYear()));
		if (form.getAdjustmentType().contentEquals("MONTH_AUDIT_REPAY")) {
			dto.setMonthAuditRepay(form.getAmount());
		} else if (form.getAdjustmentType().contentEquals("CHARTER_DEBT_MONTH")) {
			dto.setCharterDebtMonth(form.getAmount());
		} else if (form.getAdjustmentType().contentEquals("ADJ_OTHER")) {
			dto.setAdjOther(form.getAmount());
		} else if (form.getAdjustmentType().contentEquals("ADJ_SWAP")) {
			dto.setAdjSwap(form.getAmount());
		} else if (form.getAdjustmentType().contentEquals("CSI_ADMIN_MONTH")) {
			dto.setCsiAdminMonth(form.getAmount());
		} else if (form.getAdjustmentType().contentEquals("STATE_EQUAL_ADJUST")) {
			dto.setStateEqualOwnerAdjust(form.getAmount());
		}
		stateEqualDAO.saveOrUpdate(dto);
	}

	/* (non-Javadoc)
	 * @see com.cdoe.services.IOtherStateShareAdjustmentsManager#getOtherStateShareAdjustmentsForm(java.lang.Long)
	 */
	@Override
	public OtherStateShareAdjustmentsForm getOtherStateShareAdjustmentsForm(
			Long id, String adjustmentType) {
		StateEqual dto = stateEqualDAO.findByPk(StateEqual.class, id);
		OtherStateShareAdjustmentsForm form = new OtherStateShareAdjustmentsForm();
		if (dto != null) {
			form.setId(dto.getId());
			form.setDistrictNumber(dto.getDistrictNumber());
			form.setFiscalYear(dto.getFiscalYear());
			form.setAdjustmentType(adjustmentType);
		}
		Double amount = null;
		if (form.getAdjustmentType().contentEquals("MONTH_AUDIT_REPAY")) {
			amount = dto.getMonthAuditRepay();
		} else if (form.getAdjustmentType().contentEquals("CHARTER_DEBT_MONTH")) {
			amount = dto.getCharterDebtMonth();
		} else if (form.getAdjustmentType().contentEquals("ADJ_OTHER")) {
			amount = dto.getAdjOther();
		} else if (form.getAdjustmentType().contentEquals("ADJ_SWAP")) {
			amount = dto.getAdjSwap();
		} else if (form.getAdjustmentType().contentEquals("CSI_ADMIN_MONTH")) {
			amount = dto.getCsiAdminMonth();
		} else if (form.getAdjustmentType().contentEquals("STATE_EQUAL_ADJUST")) {
			amount = dto.getStateEqualOwnerAdjust();
		}
		if (amount == null) amount = new Double (0.00);
		form.setAmount(amount);
		return form;
	}

}
