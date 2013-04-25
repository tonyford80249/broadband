/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.cdoe.services.stateequal.IElectionsManager;
import com.cdoe.ui.form.stateequal.ElectionForm;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;

@Controller
@RequestMapping("/secure/Elections")
public class ElectionsController {

	private static final Logger logger = Logger.getLogger(ElectionsController.class);
	private static final String FILE_NOT_FOUND = "filenotfound";
	private static final String FILE_FOUND = "filefound";
	private static final String FILE_PROCESSING_ERROR = "fileProcessingError";

	@Autowired
	private IElectionsManager electionsManager;

	@Autowired
	private Validator electionsDetailValidator;

	@Autowired
	MappingJacksonJsonView standardJsonView;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
		String districtCode = null;
		String fiscalYear = DateUtil.getPrevFiscalYear();

		if (userInfo.isAdminUser()) {
			districtCode = userInfo.getAllDistrictCodes().get(0);
		} else {
			districtCode = userInfo.getUsersDistricts().get(0);
		}

		ElectionForm form = electionsManager.setupForm(districtCode, fiscalYear);
		form.setDistrictName(userInfo.lookupDistrict(districtCode));
		initModelDropdowns(model, session);
		logger.debug("1'st Grid bag Id is " +  form.getElectionItemGridList().get(0).getId()  + " last one is " + form.getElectionItemGridList().get(6).getId() );
		model.addAttribute("electionForm", form);
		return ".Elections-index";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(Model model,	@ModelAttribute ElectionForm electionForm,BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("confirmUpload") != null) {
			if (electionForm.getFile().getOriginalFilename() == null || "".equals(electionForm.getFile().getOriginalFilename())) {
				electionForm.setErrorMessage("Ballot to be uploaded cannot be null");
			} else {
				electionsManager.uploadBallot(electionForm.getFile(), electionForm.getDistrictCode(), electionForm.getFiscalYear());
				electionForm.setErrorMessage("Ballot was uploaded successfully");
			}
		
		} else if (request.getParameter("displayFile") != null) {
			String filename = electionForm.getFile().getOriginalFilename();
			if ((electionForm.getDistrictCode() == null) || "NONE".equalsIgnoreCase(electionForm.getDistrictCode()))
				electionForm.setErrorMessage("Please select a District Code");
			else if ((electionForm.getFiscalYear() == null) || "NONE".equalsIgnoreCase(electionForm.getFiscalYear()))
				electionForm.setErrorMessage("Please select a Fiscal Year");
			else  {
			  String displayResponse = displayBallot(response, electionForm.getDistrictCode(), electionForm.getFiscalYear(), filename);
			  if (displayResponse.equalsIgnoreCase(FILE_NOT_FOUND)) {
				  electionForm.setErrorMessage("Ballot file for the district not loaded previously");
			  }
			  else if (displayResponse.equalsIgnoreCase(FILE_PROCESSING_ERROR)) {
				  electionForm.setErrorMessage("Error loading the ballot file");
			  }
			}

		} else {
			
			electionsDetailValidator.validate(electionForm, result);
			if (result.hasErrors()) {
				electionForm.setErrorMessage(result.getFieldError().getDefaultMessage());
				initModelDropdowns(model, request.getSession());
				return ".Elections-index";
			}
			electionsManager.saveOrUpdate(electionForm);
			electionForm.setErrorMessage("Election information was saved");
			model.addAttribute("saved", true);
		}
		initModelDropdowns(model, request.getSession());
		
		return ".Elections-index";
	}

	
	public String displayBallot(HttpServletResponse response,@RequestParam String districtNumber,
									 @RequestParam String fiscalYear, @RequestParam String filename) {
	  String displayResponse = null;
	  if ((filename == null || "".equals(filename)) && (districtNumber != null && fiscalYear != null)) {
		  filename = "Ballot" +  districtNumber + fiscalYear;
	  }
	  try {
		File file = new File(filename);
		if (file.exists()) {
			byte[] content = org.apache.commons.io.FileUtils.readFileToByteArray(file);
			response.setContentType("pdf");
			response.setContentLength((int) file.length());
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ file.getName() + "\"");
			FileCopyUtils.copy(content, response.getOutputStream());
			displayResponse = FILE_FOUND;;
		} else {
			
			displayResponse = FILE_NOT_FOUND;
		}

		
		} catch (Exception e) {
			logger.info("Exception occurred during retrieve" + e.getMessage());
			displayResponse = FILE_PROCESSING_ERROR;
		}
		return displayResponse;
	}

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public ModelAndView retrieve(@RequestParam String districtNumber,@RequestParam String fiscalYear, HttpServletRequest request) {

		try {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");

			String districtName = userInfo.getDistrictMap().get(districtNumber);
			ElectionForm form = electionsManager.setupForm(districtNumber,fiscalYear);
			form.setDistrictName(districtName);
			parameterMap.put("electionForm", form);
			//logger.debug("1'st Grid bag Id is " +  form.getElectionItemGridList().get(0).getId()  + " last one is " + form.getElectionItemGridList().get(6).getId() );
			
			return new ModelAndView(standardJsonView, parameterMap);
		} catch (Throwable t) {
			logger.error("Exception occurred during retrieve.", t);
		} finally {
			logger.info("generating json response ");
		}

		return null;
	}

	private void initModelDropdowns(Model model, HttpSession session) {

		UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
		model.addAttribute("districtCodeList", userInfo.getAllDistrictCodes());

	}

}