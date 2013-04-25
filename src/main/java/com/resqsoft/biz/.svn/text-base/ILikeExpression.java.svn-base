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
 * Represents case-insensitive LIKE expression
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 * 
 */
public class ILikeExpression extends PropertyBasedExpression {

	private static final long serialVersionUID = -6263597604815158869L;

	private String value;

	private MatchMode matchMode;

	public ILikeExpression(final String prop, final String value,
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
