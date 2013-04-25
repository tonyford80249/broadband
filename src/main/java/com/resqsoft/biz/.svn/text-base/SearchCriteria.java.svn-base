package com.resqsoft.biz;

import java.io.Serializable;
import java.util.List;

/**
 * The SearchCriteria interface was inspired by, and designed after, Hibernate's
 * Criteria interface. The idea behind this SearchCriteria interface is to
 * provide a convenient way of setting a business object's search criteria using
 * simple getter methods. This allows us to avoid using an underlying
 * persistence framework's implementation directly, <b>keeping our API
 * independent of any third party libraries</b>, such as Hibernate and it's
 * Criteria interface. The underlying persistence framework's (e.g. Hibernate's)
 * DAO implementation classes are responsible for converting the SearchCriteria
 * into one that the framework can use natively. <br>
 * <br>
 * Here is a typical use scenario for the SearchCritera object, incorporating
 * the "Query By Example" (QBE) approach most widely associated with the
 * Hibernate framework: <br>
 * <br>
 * Create a new Customer business object to be used as the "example" Customer.
 * 
 * <pre>
 * Customer example = new Customer();
 * </pre>
 * 
 * Set those fields on the "example" object the we want to use as "exact match"
 * criteria.
 * 
 * <pre>
 * example.setFirstName(&quot;John&quot;);
 * example.setCustomerType(someCustomerTypeBizObjectInstance);
 * </pre>
 * 
 * Create a new SearchCriteria object, associated with the "example" Customer
 * 
 * <pre>
 * SearchCriteria sc = new SearchCriteriaImpl(example);
 * </pre>
 * 
 * Set results criteria such as the maximum number of records to be returned and
 * the order of those results
 * 
 * <pre>
 * sc.setMaxResults(100);
 * Order ord = new OrderImpl(&quot;age&quot;, true);
 * sc.addOrder(ord);
 * </pre>
 * 
 * Create an Expression object that will do a substring search if the lastName
 * 
 * <pre>
 * Expression ex = new LikeExpression(&quot;lastName&quot;, &quot;Doe&quot;, MatchMode.ANYWHERE);
 * sc.addExpression(ex);
 * </pre>
 * 
 * Get the results
 * 
 * <pre>
 * Collection results = businessFacade.getCustomers(sc);
 * </pre>
 * 
 * This piece of code creates search criteria the will return the first 100
 * customers of the given customer type (referenced via foreign key), whose
 * first name is John, and last name contains "Doe", ordering the results by
 * customer's age in ascending order.
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 * 
 */
public interface SearchCriteria extends Serializable {

	/**
	 * Adds an <code>Order</code> object which imposes a sort order on the
	 * <tt>SearchCriteria</tt> result set
	 * 
	 * @param order
	 */
	public void addOrder(Order order);

	/**
	 * Returns a collection containing all <code>Order</code> objects that
	 * have been added to this SeacrhCriteria
	 */
	public List<Order> getOrders();

	/**
	 * Adds an <code>Expression</code> object to the
	 * <code>SearchCriteria</code>
	 * 
	 * @param expr
	 */
	public void addExpression(Expression expr);

	/**
	 * Returns a collection containing all <code>Expression</code> objects
	 * that have been added to this SeacrhCriteria
	 */
	public List<Expression> getExpressions();

	/**
	 * Sets the <code>Example</code> object to be used by the
	 * <code>SearchCriteria</code> when doing a "Query By Example" search. The
	 * <code>Example</code> object is a business object of the same class at
	 * that of the result set members.
	 * 
	 * @param example
	 */
	public void setExample(Example example);

	/**
	 * Returns the <code>Example</code> object that has been set on this
	 * <code>SeacrhCriteria</code> object.
	 */
	public Example getExample();

	/**
	 * Add a comment to the generated SQL. If you add a comment the underlying
	 * framework, if it allows (e.g. Hibernate does), will display a comment in
	 * the log next to the SQL statement, which helps with tracing SQL
	 * statements in an application.
	 * 
	 * @param comment -
	 *            a human-readable string
	 */
	public void setComment(String comment);

	/**
	 * Returns the comment assigned to this <code>SearchCriteria</code>
	 */
	public String getComment();

	/**
	 * Set the first (or beginning) row in the resultset to retrieve. If not
	 * set, rows will be retrieved beginnning from row 0.
	 * 
	 * @param firstResult -
	 *            the first result, numbered from <tt>0</tt>
	 */
	public void setFirstResult(Integer firstResult);

	/**
	 * Returns the row number of the <code>firstResult</code> in the result
	 * set.
	 */
	public Integer getFirstResult();

	/**
	 * Set an upper limit on the number of objects to be retrieved.
	 * 
	 * @param maxResults -
	 *            the maximum number of results
	 */
	public void setMaxResults(Integer maxResults);

	/**
	 * Get the upper limit on the number of objects to be retrieved.
	 */
	public Integer getMaxResults();

	/**
	 * Set a timeout for the underlying query.
	 * 
	 * @param timeout
	 */
	public void setTimeout(Integer timeout);

	/**
	 * Get a timeout for the underlying query.
	 */
	public Integer getTimeout();

}
