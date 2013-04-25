
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui;

import org.apache.log4j.Logger;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.resqsoft.util.RequestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.stateequal.ICommentsManager;
import com.cdoe.biz.model.equal.CommentInfo;
import com.cdoe.ui.form.stateequal.CommentInfoForm;

@Controller
@RequestMapping("/secure/AudReports")
public class AudReportsController {

	private static final Logger logger = Logger.getLogger(AudReportsController.class);
	
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
    	
		return ".AudReports-index";
    }
    
	
	
}