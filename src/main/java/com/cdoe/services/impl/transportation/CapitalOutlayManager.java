package com.cdoe.services.impl.transportation;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.biz.model.transportation.CapitalOutlay;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.biz.transportation.ICapitalOutlayDAO;
import com.cdoe.services.impl.TransportationDataManager;
import com.cdoe.services.transportation.ICapitalOutlayManager;
import com.cdoe.ui.form.grid.CapitalOutlayGrid;
import com.cdoe.ui.form.transportation.CapitalOutlayForm;
import com.cdoe.ui.form.transportation.TransportationForm;
import com.cdoe.util.DateUtil;

public class CapitalOutlayManager extends TransportationDataManager implements
		ICapitalOutlayManager {

	private static final Logger logger = Logger
			.getLogger(CapitalOutlayManager.class);

	private ICapitalOutlayDAO capitalOutlayDAO;

	
	public void saveOrUpdate(CapitalOutlayForm form) {
		List<CapitalOutlayGrid> capitalOutlayGridList = form
				.getCapitalOutlayGridList();
		for (CapitalOutlayGrid cog : capitalOutlayGridList) {
			long id = cog.getId();
			logger.debug(cog.getTotalPurchasePrice());

			CapitalOutlay obj = findById(CapitalOutlay.class, id);
			if (obj == null) {
				obj = new CapitalOutlay();
			}
			

			obj.setDistrictNumber(form.getDistrictNumber());
			obj.setFiscalYear(form.getFiscalYear());
			if (form.getFiscalYear() != null)
				obj.setBaseYear(new Long(form.getFiscalYear()).longValue());

			obj.setRelatedYear(cog.getRelatedYear());
			obj.setTotalPurchasePrice(cog.getTotalPurchasePrice());
			obj.setDepreciationCycle(cog.getDepreciationCycle());
			obj.setPrevDepreciatedAmt(cog.getPrevDepreciatedAmt());
			obj.setRemainingAmt(cog.getRemainingAmt());
			obj.setDepreciationPy(cog.getDepreciationPy());
			obj.setContractorMiles(cog.getContractorMiles());
			obj.setOutlayExclusion(cog.getOutlayExclusion());
			obj.setCapitalOutlayTotalFunding(form
					.getCapitalOutlayTotalFunding());
			saveOrUpdate(obj);

		}
		
		Transportation transportation = getTransportationByDistrictCodeYear(form.getDistrictNumber(), form.getFiscalYear());
		if (transportation != null) {
			TransportationForm transform = setFormData(transportation);
			transform.setCapOutTran(form.getCapitalOutlayTotalFunding());
			calculateFinalReimEntitlement(transform);
			saveOrUpdate(transform);
		}
		/*if (transPortation != null ) {
			transportationDAO.updateCapOutTran(form.getDistrictNumber(),
				form.getFiscalYear(), form.getCapitalOutlayTotalFunding());
		}*/
	}

	public CapitalOutlayForm setupForm() {
		CapitalOutlayForm form = new CapitalOutlayForm();
		return form;
	}

	@SuppressWarnings("unused")
	public CapitalOutlayForm setupForm(String districtNos) {
		CapitalOutlayForm form = new CapitalOutlayForm();

		List<CapitalOutlayGrid> capitalOutlayGridList = form.getCapitalOutlayGridList();

		String fiscalYear = DateUtil.getPrevFiscalYear();
		List<CapitalOutlay> capitalOutlayList = capitalOutlayDAO
				.getByDistrictAndYear(districtNos, fiscalYear);
		form.setFiscalYear(fiscalYear);
		form.setDistrictNumber(districtNos);
		form.setBaseYear(new Long(fiscalYear).longValue());
		long lfiscalYear = Long.parseLong(fiscalYear.substring(4));
		long startFiscalYear = lfiscalYear - 9;

		double outlayExclusion = 0.0;
		if (capitalOutlayList != null && capitalOutlayList.size() > 0) {
			logger.debug("Nos of records retrieved " + capitalOutlayList.size());

			
			for (int i = 0; i < capitalOutlayList.size(); i++) {

				CapitalOutlay acapOutlay = capitalOutlayList.get(i);
				form.setId(acapOutlay.getId());

				if (acapOutlay != null) {
					logger.debug(acapOutlay.getFiscalYear());

					CapitalOutlayGrid capitalOutlayGrid = new CapitalOutlayGrid();

					capitalOutlayGrid.setId(acapOutlay.getId());

					if (acapOutlay.getRelatedYear() != null)
						capitalOutlayGrid.setRelatedYear(acapOutlay
								.getRelatedYear());
					capitalOutlayGrid.setTotalPurchasePrice(acapOutlay
							.getTotalPurchasePrice());
					capitalOutlayGrid.setDepreciationCycle(acapOutlay
							.getDepreciationCycle());
					capitalOutlayGrid.setPrevDepreciatedAmt(acapOutlay
							.getPrevDepreciatedAmt());
					capitalOutlayGrid.setRemainingAmt(acapOutlay
							.getRemainingAmt());
					capitalOutlayGrid.setDepreciationPy(acapOutlay
							.getDepreciationPy());
					capitalOutlayGrid.setOutlayExclusion(acapOutlay
							.getOutlayExclusion());
					capitalOutlayGrid.setContractorMiles(acapOutlay
							.getContractorMiles());

					capitalOutlayGridList.add(capitalOutlayGrid);
					outlayExclusion += acapOutlay.getOutlayExclusion();
					startFiscalYear++;
				} else {
					logger.debug("Capital list is null");
				}
				
			}
			form.setCapitalOutlayTotalFunding(outlayExclusion);
		
		}
		
		
		logger.debug("The capital outlist list is null or 0 length");
		for (int i = capitalOutlayList.size(); i < 10; i++) {
			CapitalOutlayGrid capitalOutlayGrid = new CapitalOutlayGrid();
			capitalOutlayGrid.setRelatedYear(startFiscalYear);
			startFiscalYear++;
			initCapitalOutlayData(capitalOutlayGrid);
			capitalOutlayGridList.add(capitalOutlayGrid);

		}
		return form;
	}

	private void initCapitalOutlayData(CapitalOutlayGrid capitalOutlayGrid) {
		capitalOutlayGrid.setTotalPurchasePrice(0.0);
		capitalOutlayGrid.setDepreciationCycle(0.0);
		capitalOutlayGrid.setPrevDepreciatedAmt(0.0);
		capitalOutlayGrid.setRemainingAmt(0.0);
		capitalOutlayGrid.setDepreciationPy(0.0);
		capitalOutlayGrid.setOutlayExclusion(0.0);
		capitalOutlayGrid.setContractorMiles(0.0);

	}

	
	
	
	public void setCapitalOutlayDAO(ICapitalOutlayDAO capitalOutlayDAO) {
		this.capitalOutlayDAO = capitalOutlayDAO;
	}
	
	
}
