package com.resqsoft.biz;

/**
 * An abstract class that adds an <code>otherPropertyName</code> attribute to
 * the <code>property</code> attribute that already exists in the parent
 * <code>PropertyBasedExpression</code> class that it inherits from. Having two
 * "property" attributes -- each of wihch is in essence a field name --
 * accommodates <code>Expression</code>s that compare the values in two
 * seperate fields of a business object (see
 * com.resqsoft.biz.NotEqualPropertiesExpression).
 * 
 * @author ocherednichenko
 * @version 1.0
 */
public abstract class PropertyOtherPropertyExpression extends
		PropertyBasedExpression {

	protected String otherPropertyName;

	protected PropertyOtherPropertyExpression(final String property,
			final String otherProperty) {
		super(property);
		this.otherPropertyName = otherProperty;
	}

	public String getOtherPropertyName() {
		return this.otherPropertyName;
	}
}
