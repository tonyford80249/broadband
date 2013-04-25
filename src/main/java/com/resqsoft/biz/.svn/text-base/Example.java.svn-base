/*
 * Created on 26.04.2005
 * Created by: ResQSoft Engineer
 *//*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.biz;

import java.io.Serializable;

/**
 * Example is a wrapper for a business object instance whose properties should
 * be used as a part of query using a <code>SearchCriteria<code> object. 
 * Typically, we create a new instance of business object, populate it 
 * partially, then pass it to a <code>SearchCriteria<code> that returns a
 * collection of the business objects having populated values. This class 
 * has additional methods for specifying search behaviour. 
 * <br><br>
 * See the <code>com.resqsoft.biz.SearchCriteria<code> class Javadoc for 
 * examples.
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 */
public interface Example extends Serializable {

	/**
	 * Return the example business object.
	 */
	Object getExampleObject();

	/**
	 * Use the "like" operator for all string-valued properties. Default: FALSE
	 */
	Boolean isEnableLike();

	/**
	 * Don't exclude null or zero-valued properties Default: FALSE
	 */
	Boolean isExcludeNone();

	/**
	 * Exclude zero-valued properties Default: FALSE
	 */
	Boolean isExcludeZeroes();

	/**
	 * Ignore case for all string-valued properties Default: FALSE
	 */
	Boolean isIgnoreCase();

	/**
	 * Use the "like" operator for all string-valued properties
	 * 
	 * @param b
	 */
	void setEnableLike(Boolean b);

	/**
	 * Set example object
	 * 
	 * @param o
	 */
	void setExampleObject(Object o);

	/**
	 * Don't exclude null or zero-valued properties
	 * 
	 * @param b
	 */
	void setExcludeNone(Boolean b);

	/**
	 * Exclude zero-valued properties
	 * 
	 * @param b
	 */
	void setExcludeZeroes(Boolean b);

	/**
	 * Ignore case for all string-valued properties
	 * 
	 * @param b
	 */
	void setIgnoreCase(Boolean b);

	/**
	 * Set LIKE match mode. Default: UNSPECIFIED, set explicitly please.
	 * 
	 * @param i
	 */
	void setLikeMatchMode(MatchMode i);

	/**
	 * Returns the LIKE MatchMode
	 */
	MatchMode getLikeMatchMode();

}
