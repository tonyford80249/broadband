package com.resqsoft.biz;

/**
 * An abstract class that adds a <code>value</code> object attribute to the
 * <code>property</code> attribute that already exists in the parent
 * <code>PropertyBasedExpression</code> class that it inherits from. This provides
 * the concrete implementation of an actual search query with the two parameters
 * needed to do a value search: 1) the name of the field to search (<code>property</code>)
 * (see com.resqsoft.bix.PropertyValueExpression) and, 2) the value to look for 
 * (<code>value</code>)
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 */
public abstract class PropertyValueExpression extends PropertyBasedExpression {

	protected Object value;

	protected PropertyValueExpression(final String prop, final Object value) {
		super(prop);
		this.value = value;
	}

	/**
	 * @return Returns the value.
	 */
	public Object getValue() {
		return this.value;
	}
}
