package com.cdoe.ui;

import com.cdoe.util.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

	private static final Logger logger = Logger
			.getLogger(SecurityController.class);

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		//UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
		//userInfo.logout(request);
		session.setAttribute(UserInfo.USER_INFO_ATTR, null);
		session.invalidate();
		return "redirect:../equal/logoutPage.jsp";
	}

}