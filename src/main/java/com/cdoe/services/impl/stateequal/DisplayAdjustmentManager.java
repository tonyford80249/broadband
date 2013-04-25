
package com.cdoe.services.impl.stateequal;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.biz.IAuditRepaymentAdjustmentDAO;
import com.cdoe.biz.model.AuditRepaymentAdjustment;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.IDisplayAdjustmentManager;
import com.cdoe.ui.form.grid.DisplayAdjustmentGrid;
import com.cdoe.ui.form.stateequal.DisplayAdjustmentForm;
import com.cdoe.util.DateUtil;

public class DisplayAdjustmentManager extends BaseManager implements IDisplayAdjustmentManager {

	private static final Logger logger = Logger.getLogger(DisplayAdjustmentManager.class);
	
	private IStateEqualDAO stateEqualDAO;
	
	private IAuditRepaymentAdjustmentDAO auditRepaymentAdjustmentDAO;
	
	private IReferenceDataManager referenceDataManager;
	
	private static final String[] adjustmentTypes = { "MONTH_AUDIT_REPAY",
		"CHARTER_DEBT_MONTH",
		"ADJ_OTHER",
		"ADJ_SWAP",
		"CSI_ADMIN_MONTH",
		"STATE_EQUAL_ADJUST"
	};

	/**
	 * Sets up the form for initial display
	 */
	@Override
	public DisplayAdjustmentForm setupForm() {
		return new DisplayAdjustmentForm();
	}

	/**
	 * Returns the form with the adjustment data based on the search
	 * criteria
	 */
	@Override
	public DisplayAdjustmentForm getAdjustments(DisplayAdjustmentForm form) {
		StateEqual stateEqualDto = stateEqualDAO.findLatest(
				form.getDistrictCode(),
				DateUtil.getFullFiscalYearFromShort(form.getFiscalYear()));
		if (stateEqualDto != null) {
			if (form.getAdjustmentType().contentEquals("ALL")) {
				for (String adjustmentType : adjustmentTypes) {
					DisplayAdjustmentGrid grid = getAdjustmentGrid(
							adjustmentType, stateEqualDto);
					grid.setDistrictCode(form.getDistrictCode());
					grid.setDistrictName(referenceDataManager
							.getOrganizationName(form.getDistrictCode()));
					grid.setId(stateEqualDto.getId());
					form.getDisplayAdjustmentGridList().add(grid);
				
					
				}
				List<DisplayAdjustmentGrid> auditGrid = getAuditGrid(form);
				form.getDisplayAdjustmentGridList().addAll(auditGrid);
			} else if (form.getAdjustmentType().contentEquals("AUDIT")) {
				List<DisplayAdjustmentGrid> grid = getAuditGrid(form);
				form.setDisplayAdjustmentGridList(grid);
			} else {
				DisplayAdjustmentGrid grid = getAdjustmentGrid(
						form.getAdjustmentType(), stateEqualDto);
				grid.setDistrictCode(form.getDistrictCode());
				grid.setDistrictName(referenceDataManager
						.getOrganizationName(form.getDistrictCode()));
				form.getDisplayAdjustmentGridList().add(grid);
			}
		}
		return form;
	}
	
	/**
	 * Performs the translation for the audit information, which is in a different table
	 * @param form
	 * @return
	 */
	private List<DisplayAdjustmentGrid> getAuditGrid(DisplayAdjustmentForm form) {
		List<AuditRepaymentAdjustment> adjustments = auditRepaymentAdjustmentDAO
				.findByDistrictAndFiscalYear(form.getDistrictCode(),
						DateUtil.getMonthNos(form.getFiscalMonth()), form.getFiscalYear());
		List<DisplayAdjustmentGrid> grid = null;
		if (adjustments != null) {
			grid = new ArrayList<DisplayAdjustmentGrid>();
			for (AuditRepaymentAdjustment adjustment : adjustments) {
				DisplayAdjustmentGrid line = new DisplayAdjustmentGrid();
				line.setDistrictCode(form.getDistrictCode());
				line.setDistrictName(referenceDataManager.getOrganizationName(form.getDistrictCode()));
				line.setAdjustmentType("AUDIT");
				line.setFrequency(adjustment.getFrequency());
				line.setBeginFiscalYearMonth(adjustment.getBeginFiscalMonth() + " " + adjustment.getBeginFiscalYear());
				line.setEndFiscalYearMonth(adjustment.getEndFiscalMonth() + " " + adjustment.getEndFiscalYear());
				line.setAmount(adjustment.getAmount());
				line.setId(adjustment.getId());
				grid.add(line);
			}
		}
		return grid;
	}
	
	/**
	 * Translates the data from the stateEqualDto to the adjustment grid
	 * 
	 * @param adjustmentType
	 * @param stateEqualDto
	 * @return
	 */
	private DisplayAdjustmentGrid getAdjustmentGrid(String adjustmentType, StateEqual stateEqualDto) {
		DisplayAdjustmentGrid grid = new DisplayAdjustmentGrid();
		grid.setId(stateEqualDto.getId());
		if (adjustmentType.contentEquals("MONTH_AUDIT_REPAY")) {
			grid.setAmount(stateEqualDto.getMonthAuditRepay());
		} else if (adjustmentType.contentEquals("CHARTER_DEBT_MONTH")) {
			grid.setAmount(stateEqualDto.getCharterDebtMonth());
		} else if (adjustmentType.contentEquals("ADJ_OTHER")) {
			grid.setAmount(stateEqualDto.getAdjOther());
		} else if (adjustmentType.contentEquals("ADJ_SWAP")) {
			grid.setAmount(stateEqualDto.getAdjSwap());
		} else if (adjustmentType.contentEquals("CSI_ADMIN_MONTH")) {
			grid.setAmount(stateEqualDto.getCsiAdminMonth());
		} else if (adjustmentType.contentEquals("STATE_EQUAL_ADJUST")) {
			grid.setAmount(stateEqualDto.getStateEqualOwnerAdjust());
		}
		grid.setAdjustmentType(adjustmentType);
		return grid;
	}

	/**
	 * Injector method
	 * 
	 * @param stateEqualDAO
	 */
	public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
		this.stateEqualDAO = stateEqualDAO;
	}

	/**
	 * Injector method
	 * 
	 * @param auditRepaymentAdjustmentDAO
	 */
	public void setAuditRepaymentAdjustmentDAO(
			IAuditRepaymentAdjustmentDAO auditRepaymentAdjustmentDAO) {
		this.auditRepaymentAdjustmentDAO = auditRepaymentAdjustmentDAO;
	}

	/**
	 * Injector method
	 * 
	 * @param referenceDataManager
	 */
	public void setReferenceDataManager(IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}
	
}
