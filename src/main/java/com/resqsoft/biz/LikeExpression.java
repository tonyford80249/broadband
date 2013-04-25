/*
 * Created on 26.04.2005
 * Created by: ResQSoft Engineer
 *//*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.biz;

/**
 * An <code>Expression</code> object that, when assigned to a
 * <code>SearchCriteria</code> object, confines the results of a query to
 * those objects for which the value of the provided <code>property</code>
 * (i.e. a "field") is "like" the <code>value</code> object's value.
 * 
 * @author ocherednichenko
 * @version 1.0
 */
public class LikeExpression extends PropertyBasedExpression {

	private static final long serialVersionUID = 744745959958970676L;

	private String value;

	private MatchMode matchMode;

	public LikeExpression(final String prop, final String value,
			final MatchMode matchMode) {
		super(prop);
		this.value = value;
		this.matchMode = matchMode;
	}

	/**
	 * @return Returns the matchMode.
	 */
	public MatchMode getMatchMode() {
		return this.matchMode;
	}

	/**
	 * @param matchMode
	 *            The matchMode to set.
	 */
	public void setMatchMode(final MatchMode matchMode) {
		this.matchMode = matchMode;
	}

	/**
	 * @return Returns the value.
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * @param value
	 *            The value to set.
	 */
	public void setValue(final String value) {
		this.value = value;
	}
}
