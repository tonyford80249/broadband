/*
 * Created on 26.04.2005
 * Created by: ResQSoft Engineer
 *//*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.biz;

import java.util.Collection;

/**
 * An <code>Expression</code> object that, when assigned to a
 * <code>SearchCriteria</code> object, confines the results of a query to
 * those objects for which the value of the provided <code>property</code>
 * (i.e. a "field") is among the <code>values</code> in the provided 
 * collection.
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 */
public class InExpression extends PropertyBasedExpression {

	private static final long serialVersionUID = -5675802938818466262L;

	private Collection values;

	public InExpression(final String prop, final Collection values) {
		super(prop);
		this.values = values;
	}

	/**
	 * @return Returns the value.
	 */
	public Collection getValue() {
		return this.values;
	}

	/**
	 * @param value
	 *            The value to set.
	 */
	public void setValue(final Collection values) {
		this.values = values;
	}
}
