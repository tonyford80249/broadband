package com.resqsoft.biz;

/**
 * Default implementation of the <code>Order</code> interface, which
 * represents a field (a business object's property) to be used in an
 * ORDER BY clause. This class also allows us to specify whether ordering
 * should be ascending or descending. One disadvantage of this class is that
 * a property name must be specified as a String.
 *
 * @author ResQSoft Engineer
 * @version 1.0
 *
 */
public class OrderImpl implements Order {

	/**
	 *
	 */
	private static final long serialVersionUID = 3287813113630252754L;

	private String propertyName;

	private Boolean ascending = Boolean.TRUE;

	public OrderImpl(final String prop) {
		this.propertyName = prop;
	}

	public OrderImpl(final String propertyName, final boolean ascending) {
		this.propertyName = propertyName;
		this.ascending = Boolean.valueOf(ascending);
	}

	/**
	 * @return Returns the ascending.
	 */
	public Boolean isAscending() {
		return this.ascending;
	}

	/**
	 * @param ascending
	 *            The ascending to set.
	 */
	public void setAscending(final Boolean ascending) {
		this.ascending = ascending;
	}

	/**
	 * @return Returns the propertyName.
	 */
	public String getPropertyName() {
		return this.propertyName;
	}

	/**
	 * @param propertyName
	 *            The propertyName to set.
	 */
	public void setPropertyName(final String propertyName) {
		this.propertyName = propertyName;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.ascending == null) ? 0 : this.ascending.hashCode());
        result = prime * result + ((this.propertyName == null) ? 0 : this.propertyName.hashCode());
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
        if (!(obj instanceof OrderImpl))
            return false;
        OrderImpl other = (OrderImpl) obj;
        if (this.ascending == null) {
            if (other.ascending != null)
                return false;
        }
        else if (!this.ascending.equals(other.ascending))
            return false;
        if (this.propertyName == null) {
            if (other.propertyName != null)
                return false;
        }
        else if (!this.propertyName.equals(other.propertyName))
            return false;
        return true;
    }
}
