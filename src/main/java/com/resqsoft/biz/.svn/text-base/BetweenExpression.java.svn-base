package com.resqsoft.biz;

/**
 * An <code>Expression</code> object that, when assigned to a
 * <code>SearchCriteria</code> object, confines the results of a query to
 * those objects for which the value of the provided <code>property</code>
 * (i.e. a "field") is greater than the <code>low</code> object's value and
 * less than the <code>hi</code> object's value.
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 * 
 */
public class BetweenExpression extends PropertyBasedExpression {

	private static final long serialVersionUID = -5011742704798225714L;

	private Object low, hi;

	public BetweenExpression(final String property, final Object low,
			final Object hi) {
		super(property);
		this.low = low;
		this.hi = hi;
	}

	/**
	 * @return Returns the hi.
	 */
	public Object getHi() {
		return this.hi;
	}

	/**
	 * @param hi
	 *            The hi to set.
	 */
	public void setHi(final Object hi) {
		this.hi = hi;
	}

	/**
	 * @return Returns the low.
	 */
	public Object getLow() {
		return this.low;
	}

	/**
	 * @param low
	 *            The low to set.
	 */
	public void setLow(final Object low) {
		this.low = low;
	}
}
