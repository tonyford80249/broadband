package com.resqsoft.biz;

/**
 * An <code>Expression</code> object that, when assigned to a
 * <code>SearchCriteria</code> object, confines the results of a query to
 * those objects for which the value of the provided <code>property</code>
 * (i.e. a "field") is greater than or equal to the <code>value</code>
 * object's value.
 * 
 * @author ocherednichenko
 * @version 1.0
 */
public class GreaterThanOrEqualExpression extends PropertyValueExpression {

	private static final long serialVersionUID = 8397335416935945306L;

	public GreaterThanOrEqualExpression(final String property,
			final Object value) {
		super(property, value);
	}
}
