package com.resqsoft.biz;

import java.io.Serializable;

/**
 * Order represents a field (a business object's property) to be used in an
 * ORDER BY clause. This class also allows us to specify whether ordering 
 * should be ascending or descending. One disadvantage of this class is that 
 * a property name must be specified as a String.
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 */
public interface Order extends Serializable {

	String getPropertyName();

	/**
	 * @param s
	 */
	void setPropertyName(String s);

	/**
	 * Default: TRUE
	 * 
	 * @return
	 */
	Boolean isAscending();

	/**
	 * @param b
	 */
	void setAscending(Boolean b);

}
