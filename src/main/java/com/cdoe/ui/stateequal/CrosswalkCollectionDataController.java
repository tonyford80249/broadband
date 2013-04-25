

/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.stateequal.ICrosswalkCollectionDataManager;
import com.cdoe.ui.form.grid.CrossWalkDataGrid;
import com.cdoe.ui.form.stateequal.CrosswalkCollectionForm;
import com.cdoe.util.DateUtil;

@Controller
@RequestMapping("/secure/CrosswalkCollectionData")
public class CrosswalkCollectionDataController {

	private static final Logger logger = Logger.getLogger(CrosswalkCollectionDataController.class);
	
	@Autowired
	private ICrosswalkCollectionDataManager crosswalkCollectionDataManager;
	
	@Autowired
	private IReferenceDataManager referenceDataManager;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
		CrosswalkCollectionForm form = new CrosswalkCollectionForm();
    	initModelDropdowns(model, session );
    	model.addAttribute("crosswalkCollectionForm", form);
		return ".CrosswalkCollectionData-index";
    }
    
	@RequestMapping(value = "/upload", method = RequestMethod.POST,  params = "save")
    public String save(Model model, @ModelAttribute CrosswalkCollectionForm crosswalkCollectionForm, BindingResult result, HttpServletRequest request) {
    	String response  = crosswalkCollectionDataManager.saveCrosswalkData(crosswalkCollectionForm);
    	crosswalkCollectionForm.setMessage(response);
		model.addAttribute("saved", true);
		initModelDropdowns(model, request.getSession() );
    	model.addAttribute("crosswalkCollectionForm", crosswalkCollectionForm);
		return ".CrosswalkCollectionData-index";
    }
    
	@RequestMapping(value = "/upload", method = RequestMethod.POST, params = "view")
	public String upload(Model model,  @ModelAttribute CrosswalkCollectionForm crosswalkCollectionForm, BindingResult result, HttpServletRequest request) {
		CrossWalkDataGrid crosswalkGrid = crosswalkCollectionDataManager.viewCrosswalkData(crosswalkCollectionForm);  
		if (crosswalkGrid != null) {
		
			crosswalkCollectionForm.setMessage("Please view the data to be uploaded  and if satisfied save the data");
			crosswalkCollectionForm.setCrossWalkDataGrid(crosswalkGrid);
		} else {
			if (crosswalkCollectionForm != null) {
				crosswalkCollectionForm.setMessage("No crosswalk data imported " + crosswalkCollectionForm.getMessage());
				logger.debug(crosswalkCollectionForm.getMessage());
			}
			
		}
		initModelDropdowns(model, request.getSession() );
    	model.addAttribute("crosswalkCollectionForm", crosswalkCollectionForm);
		return  ".CrosswalkCollectionData-index";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST,  params = "cancel")
    public String cancel(Model model, @ModelAttribute CrosswalkCollectionForm crosswalkCollectionForm, BindingResult result, HttpServletRequest request) {
    	model.addAttribute("cancel", true);
		initModelDropdowns(model, request.getSession() );
    	model.addAttribute("crosswalkCollectionForm", crosswalkCollectionForm);
		return ".CrosswalkCollectionData-index";
    }
	
	private void initModelDropdowns(Model model, HttpSession session) {
		model.addAttribute("fiscalYearList", DateUtil.getShortYears(DateUtil.getCurrentFiscalYear(), 2));
		model.addAttribute("collectionTypeList", referenceDataManager.getCrossWalkDataType());
	}
}