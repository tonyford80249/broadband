package com.resqsoft.biz;

/**
 * An <code>Expression</code> object that, when assigned to a
 * <code>SearchCriteria</code> object, confines the results of a query to
 * those objects for which the value of the provided <code>property</code>
 * (i.e. a "field") is equal to the <code>value</code> object's value.
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 */
public class EqualExpression extends PropertyValueExpression {

	private static final long serialVersionUID = -9011564216014601864L;

	public EqualExpression(final String property, final Object value) {
		super(property, value);
	}

}
