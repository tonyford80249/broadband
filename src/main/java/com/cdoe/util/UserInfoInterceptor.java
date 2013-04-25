/**
 * 
 */
package com.cdoe.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import us.co.cde.state.security.exception.CdeApplicationSecurityException;

import com.cdoe.services.IReferenceDataManager;

/**
 * This intercepter will populate the UserInfo class in the session
 * so that controllers can have access to the authorization information.
 * 
 * It also checks the rule that a user cannot have both Audit and State
 * Equal or Audit and Transportation privileges
 * 
 * It also checks to make sure the user has privileges to the page they are
 * trying to access 
 * 
 * @author dyn-8
 *
 */
public class UserInfoInterceptor extends HandlerInterceptorAdapter {
	
    private final Logger LOGGER = Logger.getLogger(UserInfoInterceptor.class);
	
	private IReferenceDataManager referenceDataManager;
	
	/**
	 * Sets the referenceDataManager
	 * @param referenceDataManager
	 */
	public void setReferenceDataManager(IReferenceDataManager referenceDataManager) {
		this.referenceDataManager = referenceDataManager;
	}

	/**
	 * This is the method that will check the request to see if if is
	 * new and if so, will put the UserInfo data into the session.
	 * 
	 * It also checks to make sure the user is authorized for the page
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		boolean retValue = true;
		HttpSession session = request.getSession(false);
		if (session != null && session.isNew()
				&& session.getAttribute("USER_INFO") == null) {
			UserInfo userInfo = new UserInfo(request);
			//Map<String, String> districtMap = null;
			if (userInfo.isValid()) {
				// State Equal users only need districts
				if (userInfo.isStateEqualUser()) {
                                        LOGGER.info("state-equal user found...");
                                        referenceDataManager.populateUserInfo(userInfo, "DISTRICT");
					//districtMap = referenceDataManager.getOrganizationsMap("DISTRICT");
				} else {                                        
                                         LOGGER.info("IS NOT state-equal user.");
                                         referenceDataManager.populateUserInfo(userInfo);
					//districtMap = referenceDataManager.getAllOrganizationsMap();
				}
				//userInfo.setDistrictMap(districtMap);
                                
                                
				request.getSession().setAttribute(UserInfo.USER_INFO_ATTR, userInfo);
				// For now, assume that a district user is only assigned to one
				// district
				String currentDistrict = userInfo.getUsersDistricts().get(0);
				request.getSession().setAttribute("districtNos",
						currentDistrict);
				request.getSession().setAttribute("districtName",
						userInfo.getDistrictMap().get(currentDistrict));
				if (userInfo.isTransportationUser()) {
                                        LOGGER.info("transportation user found...");
					request.getSession().setAttribute("fiscalYear",
							DateUtil.getPrevFiscalYear());
				} else {
                                        LOGGER.info("IS NOT transportation user.");
					request.getSession().setAttribute("fiscalYear",
							DateUtil.getFiscalYear());
				}
				// Set the userId into the interceptor for Hibernate
				UserIdInterceptor.setUser(userInfo.getUserId());

				retValue = true;
			} else {
				request.getSession().invalidate();
				throw new CdeApplicationSecurityException("User not authorized");
			}
		} else if (session != null && session.getAttribute("USER_INFO") == null && !session.isNew()) {
			session.invalidate();
			response.sendRedirect("/equal/index.jsp");
			retValue = false;
		} else if (session != null && session.getAttribute("USER_INFO") != null && !session.isNew()) {
			// Make sure we have authorization for the page
			String requestPath = request.getServletPath();
			if (requestPath.contains("/secure/")) {
				// Only check requests that contain the /secure/ path
				// This filters out all the headers, scripts, images, etc. that come through
				UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
				retValue = authorize(userInfo, requestPath);
				UserIdInterceptor.setUser(userInfo.getUserId());
			}
			if (!retValue) {
				throw new CdeApplicationSecurityException("User not authorized");
			}
		}
		return retValue;
	}
	
	/**
	 * Validates that the user authenticated in the userInfo object has rights
	 * to the page
	 * 
	 * @param userInfo
	 * @param page
	 * @return
	 */
	private boolean authorize(UserInfo userInfo, String page) {
		boolean authorized = false;
		if (page.contains("LandingMenu")) {
			authorized = true;
		} else {
			if (userInfo.isTransportationUser() && !userInfo.isAdminUser()) {
				authorized = page.contains("Cde40TransReimbForm") || page.contains("CapitalOutlay");
			} else if (userInfo.isTransportationUser()
					&& !userInfo.isAdminUser()) {
				authorized = page.contains("Cde40TransReimbForm")
						|| page.contains("DistributionAmounts")
						|| page.contains("DistrictPaymentReport")
						|| page.contains("CoforsUpload")
						|| page.contains("Cde40Summary")
						|| page.contains("PaymentWorksheet")
						|| page.contains("CapitalOutlay")
						|| page.contains("TransportationHomePage");
			} else {
				// TODO Update for State Equal and Audit
				authorized = true;
			}
		}
		return authorized;
	}

}
