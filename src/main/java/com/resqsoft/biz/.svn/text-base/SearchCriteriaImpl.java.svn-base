package com.resqsoft.biz;

import java.util.ArrayList;
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
public class SearchCriteriaImpl implements SearchCriteria {

	private static final long serialVersionUID = -3656100853179887958L;

	private List<Expression> expressions = new ArrayList<Expression>();

	private List<Order> orders = new ArrayList<Order>();

	private String comment;

	private Example example;

	private Integer firstResult, maxResults, timeout;

	public SearchCriteriaImpl() {
	}

	/**
	 * Creates a <code>SearchCriteria</code> object with the it's
	 * <code>Example</code> attribute set to the provided <code>Example</code>.
	 * 
	 * @param example
	 */
	public SearchCriteriaImpl(final Example example) {
		this.example = example;
	}

	/**
	 * Creates <code>SearchCriteria</code> along with new <code>Example</code>
	 * object for the provided business object.
	 * 
	 * @param exampleObject
	 */
	public SearchCriteriaImpl(final Object exampleObject) {
		this.example = new ExampleImpl(exampleObject);
	}

	/**
	 * Creates <code>SearchCriteria</code> along with new <code>Example</code>
	 * object for the provided business object and setting the query's case
	 * sensitivity at the same time.
	 * 
	 * @param exampleObject
	 * @param ignoreCase
	 */
	public SearchCriteriaImpl(final Object exampleObject,
			final boolean ignoreCase) {
		this.example = new ExampleImpl(exampleObject, ignoreCase);
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(final String comment) {
		this.comment = comment;
	}

	public Example getExample() {
		return this.example;
	}

	public void setExample(final Example example) {
		this.example = example;
	}

	public List<Expression> getExpressions() {
		return this.expressions;
	}

	public void setExpressions(final List<Expression> expressions) {
		this.expressions = expressions;
	}

	public Integer getFirstResult() {
		return this.firstResult;
	}

	public void setFirstResult(final Integer firstResult) {
		this.firstResult = firstResult;
	}

	public Integer getMaxResults() {
		return this.maxResults;
	}

	public void setMaxResults(final Integer maxResults) {
		this.maxResults = maxResults;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(final List<Order> orders) {
		this.orders = orders;
	}

	public Integer getTimeout() {
		return this.timeout;
	}

	public void setTimeout(final Integer timeout) {
		this.timeout = timeout;
	}

	public void addOrder(final Order order) {
		this.orders.add(order);
	}

	public void addExpression(final Expression expr) {
		this.expressions.add(expr);
	}

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.comment == null) ? 0 : this.comment.hashCode());
        result = prime * result + ((this.example == null) ? 0 : this.example.hashCode());
        result = prime * result + ((this.expressions == null) ? 0 : this.expressions.hashCode());
        result = prime * result + ((this.firstResult == null) ? 0 : this.firstResult.hashCode());
        result = prime * result + ((this.maxResults == null) ? 0 : this.maxResults.hashCode());
        result = prime * result + ((this.orders == null) ? 0 : this.orders.hashCode());
        result = prime * result + ((this.timeout == null) ? 0 : this.timeout.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof SearchCriteriaImpl))
            return false;
        SearchCriteriaImpl other = (SearchCriteriaImpl) obj;
        if (this.comment == null) {
            if (other.comment != null)
                return false;
        }
        else if (!this.comment.equals(other.comment))
            return false;
        if (this.example == null) {
            if (other.example != null)
                return false;
        }
        else if (!this.example.equals(other.example))
            return false;
        if (this.expressions == null) {
            if (other.expressions != null)
                return false;
        }
        else if (!this.expressions.equals(other.expressions))
            return false;
        if (this.firstResult == null) {
            if (other.firstResult != null)
                return false;
        }
        else if (!this.firstResult.equals(other.firstResult))
            return false;
        if (this.maxResults == null) {
            if (other.maxResults != null)
                return false;
        }
        else if (!this.maxResults.equals(other.maxResults))
            return false;
        if (this.orders == null) {
            if (other.orders != null)
                return false;
        }
        else if (!this.orders.equals(other.orders))
            return false;
        if (this.timeout == null) {
            if (other.timeout != null)
                return false;
        }
        else if (!this.timeout.equals(other.timeout))
            return false;
        return true;
    }
	
	
}
