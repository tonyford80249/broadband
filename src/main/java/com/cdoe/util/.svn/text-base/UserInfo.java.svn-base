package com.cdoe.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import us.co.cde.state.security.OamAuthentication;
import us.co.cde.state.security.OamUser;
import us.co.cde.state.security.Roles;
import us.co.cde.state.security.exception.CdeApplicationSecurityException;
import us.co.cde.state.security.exception.CdeSecurityException;

/**
 * UserInfo provides access to security information
 * obtained from the container security.
 */
public class UserInfo implements Serializable {
	
	public static final String USER_INFO_ATTR = "USER_INFO";

    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(UserInfo.class);
    
    private static final String TRANSPORTATION_USER_ROLE = "1";
    private static final String STATE_EQUAL_USER_ROLE = "2";
    private static final String AUDIT_SUPERVISOR_ROLE = "3";
    private static final String AUDITOR_DISTRICT_ROLE = "4";
    
    private static final String ADMIN_USER_DISTRICT = "9999";
    
    OamAuthentication authenticator = null;
    OamUser oamUser = null;
    
    private Map<String, String> districtMap;
    private Map<String,String> districtPrimaryCountyMap;
    private Map<String,List<String>> districtCountyMap;
    
    /**
     * Constructor
     * @throws CdeApplicationSecurityException 
     * @throws CdeSecurityException 
     */
    public UserInfo(HttpServletRequest request) 
    		throws CdeSecurityException, CdeApplicationSecurityException  {
    	authenticator = OamAuthentication.getInstance(request);
    	oamUser = authenticator.getOamUser();
    }
    
    /**
     * Returns false if the user has Audit and Transporation or Audit and State Equal
     * @return
     */
    public boolean isValid() {
    	if ((isAuditDistrictUser() || isAuditSupervisorUser())
    			&& (isTransportationUser() || isStateEqualUser()))
    			return false;
    	else
    		return true;
    }
    
    /**
     * Returns the userId
     * @return
     */
    public String getUserId() {
    	log.debug("getUserId returning user: " + oamUser.getUserId());
    	return oamUser.getUserId();
    }
    
    /**
     * Returns the full name of the user - firstname + " " + lastname
     * 
     * Returns [first] if firstname is null, and [last] if lastname is null
     * @return
     */
    public String getUserName() {
        if (oamUser.getFirstName() == null)
            oamUser.setFirstName("[first]");
        if (oamUser.getLastName() == null)
            oamUser.setLastName("[last]");
    	log.debug("getUserName returning username: " + oamUser.getFirstName() + " " + oamUser.getLastName());
    	return oamUser.getFirstName() + " " + oamUser.getLastName();
    }
    
    /**
     * Returns a collection of all the roles a user has
     * 
     * @return
     */
    public Collection<Roles> getUserRoles() {
    	log.debug("getUserRoles returning user: " + oamUser.getOamGroups());
    	return oamUser.getOamGroups().values();
    }
    
    public boolean logout(HttpServletRequest request) throws Exception {
      OamAuthentication auth = OamAuthentication.getInstance(request);
      return auth.logout();
    }
    
    /**
     * Returns a collection of the roles a user has for a single district
     * @param district
     * @return
     */
    @SuppressWarnings("unchecked")
	public Collection<Roles> getUserRoles(String district) {
    	return oamUser.getOamGroups().get(district);
    }
    
    /**
     * Returns true if the user has a Transporation role
     * @return
     */
	public boolean isTransportationUser() {
		return containsRole(TRANSPORTATION_USER_ROLE);
	}
	
	/**
	 * Returns true if the user has a State Equal role
	 * @return
	 */
	public boolean isStateEqualUser() {
		return containsRole(STATE_EQUAL_USER_ROLE);
	}

	/**
	 * Returns true if the user has an Auditor role
	 * @return
	 */
	public boolean isAuditDistrictUser() {
		return containsRole(AUDITOR_DISTRICT_ROLE);
	}
		
	/**
	 * Returns true if the user has an Audit supervisor role
	 * @return
	 */
	public boolean isAuditSupervisorUser() {
		return containsRole(AUDIT_SUPERVISOR_ROLE);
	}

	/**
	 * Returns true if the user is an Admin user
	 * @return
	 */
	public boolean isAdminUser() {
		return getUsersDistricts().contains(ADMIN_USER_DISTRICT) && !isAuditDistrictUser();
	}
	
	/**
	 * Returns a list of the districts the user has roles for
	 * @return
	 */
	public List<String> getUsersDistricts() {
		return new ArrayList<String>(oamUser.getOamGroups().keySet());
	}
	
	/**
	 * Returns the name of the district given the code
	 * 
	 * @param code
	 * @return
	 */
	public String lookupDistrict(String code) {
		return districtMap.get(code);
	}
	
	/**
	 * Returns the district map - the key is the
	 * district code, the value is the district name
	 * @return
	 */
	public Map<String, String> getDistrictMap() {
		return districtMap;
	}
	
	/**
	 * Sets the district map
	 * 
	 * @param districtMap
	 */
	public void setDistrictMap(Map<String, String> districtMap) {
		this.districtMap = districtMap;
	}

	/**
	 * Returns all the district codes in a list
	 * @return
	 */
	public List<String> getAllDistrictCodes() {
		List<String> districtCodes = new ArrayList<String>(districtMap.keySet());
		Collections.sort(districtCodes);
		//districtCodes.add(0, "-- Select --");
		return districtCodes;
	}
        
	/**
	 * Returns all the district codes in a list
	 * 
	 * @return
	 */
	public List<String> getAllNameNCodes() {
		List<String> districtCodes = new ArrayList<String>();

		for (Entry<String, String> entry : districtMap.entrySet()) {
			districtCodes.add(entry.getKey() + " - " + entry.getValue());
		}

		Collections.sort(districtCodes);
		//districtCodes.add(0, "-- Select --");
		return districtCodes;
	}
	
	/**
	 * Returns the district names in a list
	 * @return
	 */
	public List<String> getAllDistrictNames() {
		return new ArrayList<String>(districtMap.values());
	}

    
        
        
	
	/**
	 * Returns true if the user has the given role for any district
	 * 
	 * @param role
	 * @return
	 */
	private boolean containsRole(String role) {
		
		for (String district : oamUser.getOamGroups().keySet()) {
			if (containsRole(role, district))
				return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the user has the given role for the given district
	 * @param role
	 * @param district
	 * @return
	 */
	private boolean containsRole(String role, String district) {	
		return oamUser.getOamGroups().get(district).rolesContain(role);
	}

    public Map<String, String> getDistrictPrimaryCountyMap() {
        return districtPrimaryCountyMap;
    }

    public void setDistrictPrimaryCountyMap(Map<String, String> districtPrimaryCountyMap) {
        this.districtPrimaryCountyMap = districtPrimaryCountyMap;
    }

    public Map<String, List<String>> getDistrictCountyMap() {
        return districtCountyMap;
    }

    public void setDistrictCountyMap(Map<String, List<String>> districtCountyMap) {
        this.districtCountyMap = districtCountyMap;
    }
        
        
}