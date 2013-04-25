
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.biz.model.equal.CommentInfo;
import com.cdoe.services.stateequal.ICommentsManager;
import com.cdoe.ui.form.stateequal.CommentInfoForm;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;
import com.resqsoft.util.RequestUtils;

@Controller
@RequestMapping("/secure/Comments")
public class CommentsController {

	private static final Logger logger = Logger.getLogger(CommentsController.class);
	
	@Autowired
	private ICommentsManager commentsManager;
	
	@Autowired
	private Validator commentInfoValidator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
    	CommentInfoForm form = commentsManager.setupForm();
    	initModelDropdowns(model, session);
    	model.addAttribute("commentInfoForm", form);
		return ".Comments-index";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute CommentInfoForm commentInfoForm, BindingResult result, HttpServletRequest request) {
    	commentInfoValidator.validate(commentInfoForm, result);
		if (result.hasErrors()) {
			commentInfoForm = commentsManager.setupForm();
			commentInfoForm.setErrorMessage(result.getFieldError().getDefaultMessage());
			initModelDropdowns(model, request.getSession());
			model.addAttribute("commentInfoForm", commentInfoForm);
			return ".Comments-index";
		}
		String enteredBy  =  ((UserInfo) request.getSession().getAttribute("USER_INFO")).getUserId();//getUserName();
		
		commentInfoForm.setEnteredBy(enteredBy);
		commentInfoForm.setActive("Y");
		commentInfoForm.setEnteredDate(Calendar.getInstance().getTime());
		//commentInfoForm.setFiscalYear(fiscalYear)
		logger.debug(commentInfoForm.getNote());
		logger.debug(enteredBy);
		commentsManager.saveOrUpdate(commentInfoForm);
		model.addAttribute("saved", true);
		commentInfoForm = commentsManager.setupForm();
		initModelDropdowns(model, request.getSession());
		model.addAttribute("commentInfoForm", commentInfoForm);
		return ".Comments-index";
    }
    
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {
    	CommentInfoForm form = commentsManager.setupForm(id);
    	model.addAttribute("commentInfoForm", form);
		return ".Comments-index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, HttpServletRequest request) {
    	commentsManager.delete(CommentInfo.class, id);
		return "redirect:" + RequestUtils.getContextPath(request) + "/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	List<CommentInfo> commentInfos = commentsManager.findAll(CommentInfo.class);
    	model.addAttribute("commentInfos", commentInfos);
		return ".Comments-list";
    }
	
    private void initModelDropdowns(Model model, HttpSession session) {
		//UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
    	UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
		model.addAttribute("districtCodeList", userInfo.getAllDistrictCodes());
		model.addAttribute("fiscalYearList", DateUtil.getShortYears(DateUtil.getCurrentFiscalYearShort(), 5));
		model.addAttribute("fiscalMonthList", DateUtil.getFullMonthList(false));
    }
}