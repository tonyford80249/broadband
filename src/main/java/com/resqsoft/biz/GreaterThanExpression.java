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
 * (i.e. a "field") is greater than the <code>value</code> object's value.
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 */
public class GreaterThanExpression extends PropertyValueExpression {

	private static final long serialVersionUID = 6020077078902487293L;

	public GreaterThanExpression(final String property, final Object value) {
		super(property, value);

	}

}
