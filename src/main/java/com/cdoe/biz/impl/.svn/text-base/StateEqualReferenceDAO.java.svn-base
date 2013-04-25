/**
 * 
 */
package com.cdoe.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.cdoe.biz.model.StateEqualReference;
import com.cdoe.db.hibernate.HibernateDAO;

/**
 * DAO class for STATE_EQUAL_REFERENCE
 * @author dyn-8
 *
 */
public class StateEqualReferenceDAO extends HibernateDAO {

	/**
	 * Default constructor
	 */
	public StateEqualReferenceDAO() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public List<StateEqualReference> findByGroupName(String groupName) {
		return getHibernateTemplate()
				.findByNamedParam(
						"from StateEqualReference where groupName = :groupName and active = 'Y' order by additionalCriteria" ,
						"groupName", groupName);
	}
	
	/**
	 * Convenience method to return the element values as a list 
	 * of strings
	 * 
	 * @param groupName
	 * @return
	 */
	public List<String> getElementValueList(String groupName) {
		ArrayList<String> values = null;
		List<StateEqualReference> masterList = findByGroupName(groupName);
		if (masterList != null) {
			values = new ArrayList<String>();
			for (StateEqualReference master : masterList) {
				values.add(master.getElementValue());
			}
		}
		return values;
	}

}
