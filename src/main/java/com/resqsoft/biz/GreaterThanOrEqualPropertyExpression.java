package com.resqsoft.biz;

/**
 * An <code>Expression</code> object that, when assigned to a
 * <code>SearchCriteria</code> object, confines the results of a query to
 * those objects for which the value of the provided <code>property</code>
 * (i.e. a "field") is greater than or equal to the value of the
 * <code>otherProperty</code> (i.e., another field).
 * 
 * @author ocherednichenko
 * @version 1.0
 */
public class GreaterThanOrEqualPropertyExpression extends
		PropertyOtherPropertyExpression {

	private static final long serialVersionUID = -7343136317797228492L;

	public GreaterThanOrEqualPropertyExpression(final String property,
			final String otherProperty) {
		super(property, otherProperty);
	}
}
