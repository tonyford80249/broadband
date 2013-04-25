
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cdoe.services.IReferenceDataManager;
import com.cdoe.services.stateequal.IUploadVariablesManager;
import com.cdoe.ui.form.grid.UploadVariablesGrid;
import com.cdoe.ui.form.stateequal.SaveVariableForm;
import com.cdoe.ui.form.stateequal.UploadVariablesForm;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;

@Controller
@RequestMapping("/secure/UploadVariables")
@SessionAttributes("uploadVariablesForm")
public class UploadVariablesController {

	private static final Logger logger = Logger.getLogger(UploadVariablesController.class);
	
	@Autowired
	private IUploadVariablesManager uploadVariablesManager;
	@Autowired
	private IReferenceDataManager referenceDataManager;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
    	UploadVariablesForm uploadVariablesForm = uploadVariablesManager.setupUploadVariablesForm();
    	SaveVariableForm saveVariableForm = new SaveVariableForm();
    	model.addAttribute("uploadVariablesForm", uploadVariablesForm);
    	model.addAttribute("saveVariableForm", saveVariableForm);
    	initModelDropdowns(model, session);
		return ".UploadVariables-index";
    }
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST, params = "display")
	public String upload(Model model,
			@ModelAttribute UploadVariablesForm uploadVariablesForm, HttpSession session) {
		UploadVariablesGrid uploadGrid = uploadVariablesManager.processFile(uploadVariablesForm.getFile());
		if (uploadGrid != null) {
			uploadVariablesForm.setUploadGrid(uploadGrid);
			session.setAttribute("uploadGrid", uploadGrid);
		} else {
			model.addAttribute("message", "Error uploading file - Invalid file format");
		}
    	SaveVariableForm saveVariableForm = new SaveVariableForm();
    	model.addAttribute("saveVariableForm", saveVariableForm);
    	initModelDropdowns(model, session);
		return ".UploadVariables-index";
	}
    
	@RequestMapping(value = "/upload", method = RequestMethod.POST, params = "confirm")
    public String save(Model model, @ModelAttribute UploadVariablesForm uploadVariablesForm, HttpSession session) {
		//UploadVariablesGrid uploadGrid = (UploadVariablesGrid) session.getAttribute("uploadGrid");
		UploadVariablesGrid uploadGrid = uploadVariablesForm.getUploadGrid();
		try {
			uploadVariablesManager.saveUploadVariablesGrid(uploadGrid, uploadVariablesForm.getFiscalYear());
			model.addAttribute("saved", "upload");
			uploadVariablesForm.setUploadGrid(null);
			session.removeAttribute("uploadGrid");
		} catch (Exception e) {
			logger.error("Error saving grid", e);
			model.addAttribute("message", "Error saving file");
		}
    	SaveVariableForm saveVariableForm = new SaveVariableForm();
    	model.addAttribute("saveVariableForm", saveVariableForm);
    	initModelDropdowns(model, session);
		return ".UploadVariables-index";
    }
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST, params = "cancel")
    public String cancel(Model model, @ModelAttribute UploadVariablesForm uploadVariablesForm, HttpSession session) {
		model.addAttribute("cancel", "upload");
		uploadVariablesForm.setUploadGrid(null);
		session.removeAttribute("uploadGrid");
		
    	SaveVariableForm saveVariableForm = new SaveVariableForm();
    	model.addAttribute("saveVariableForm", saveVariableForm);
    	initModelDropdowns(model, session);
		return ".UploadVariables-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model,
			@ModelAttribute SaveVariableForm saveVariableForm, HttpSession session) {
		uploadVariablesManager.saveSingleVariableForm(saveVariableForm);
		UploadVariablesForm uploadVariablesForm = new UploadVariablesForm();
    	model.addAttribute("uploadVariablesForm", uploadVariablesForm);
    	model.addAttribute("saved", "single");
    	initModelDropdowns(model, session);
		return ".UploadVariables-index";
	}
 
	private void initModelDropdowns(Model model, HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
		model.addAttribute("districtCodeList", userInfo.getAllDistrictCodes());
		model.addAttribute("fiscalYearList", DateUtil.getShortYears(DateUtil.getCurrentFiscalYearShort(), 5));
		model.addAttribute("dataElementList", referenceDataManager.getUploadVariables());
	}
    
}