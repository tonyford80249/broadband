package com.resqsoft.biz;

/**
 * The Expression interface was inspired by, and designed after, Hibernate's
 * Expression interface. It works in conjunction with our
 * <code>SearchCriteria</code> interface and represents a restriction placed
 * on SearchCriteria. For example, an Expression restricting someone's last name
 * to only those containing the "Doe" substring would be constructed as follows:
 * <pre>
 * Expression expr = new LikeExpression("LastName", "%Doe%");
 * </pre>
 * then,
 * <pre>
 * SearchCriteria sc = new SearchCriteriaImpl(example);
 * sc.addExpression(expr);
 * </pre>
 * An Expression is set on a SearchCriteria object's which in its turn maps to a
 * database table column.
 * <br><br>
 * The PropertyBasedExpression class is a super class that makes the
 * <code>getPropertyName</code> method available in all child classes.
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 */
public abstract class PropertyBasedExpression extends BaseExpression {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    protected String propertyName;

	/**
	 * @param propertyName
	 */
	protected PropertyBasedExpression(final String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @return Returns the propertyName.
	 */
	public String getPropertyName() {
		return this.propertyName;
	}
}
