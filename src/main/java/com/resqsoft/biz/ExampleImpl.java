/*
 * Created on 26.04.2005
 * Created by: ResQSoft Engineer
 *//*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.biz;

/**
 * Default implementation of the <code>com.resqsoft.biz.Example</code>.
 * interface which is a wrapper for a business object instance whose
 * properties should be used as a part of query using a
 * <code>SearchCriteria<code> object.  Typically, we create a new
 * instance of business object, populate it partially, then pass it to a
 * <code>SearchCriteria<code> that returns a collection of the business
 * objects that have the populated values. This class has additional methods
 * for specifying search behaviour.
 * <br><br>
 * See the <code>com.resqsoft.biz.SearchCriteria<code> class Javadoc for
 * examples.
 *
 * @author ResQSoft Engineer
 * @version 1.0
 *
 */
public class ExampleImpl implements Example {

	/**
	 *
	 */
	private static final long serialVersionUID = -6358184961564419090L;

	private Object exampleObject;

	private Boolean enableLike = Boolean.FALSE;

	private Boolean excludeNone = Boolean.FALSE;

	private Boolean excludeZeroes = Boolean.FALSE;

	private Boolean isIgnoreCase = Boolean.FALSE;

	private MatchMode likeMatchMode;

	public ExampleImpl(final Object o) {
		this.exampleObject = o;
	}

	public ExampleImpl(final Object o, final boolean ignoreCase) {
		this.exampleObject = o;
		this.isIgnoreCase = Boolean.valueOf(ignoreCase);
	}

	/**
	 * @return Returns the enableLike.
	 */
	public Boolean isEnableLike() {
		return this.enableLike;
	}

	/**
	 * @param enableLike
	 *            The enableLike to set.
	 */
	public void setEnableLike(final Boolean enableLike) {
		this.enableLike = enableLike;
	}

	/**
	 * @return Returns the exampleObject.
	 */
	public Object getExampleObject() {
		return this.exampleObject;
	}

	/**
	 * @param exampleObject
	 *            The exampleObject to set.
	 */
	public void setExampleObject(final Object exampleObject) {
		this.exampleObject = exampleObject;
	}

	/**
	 * @return Returns the excludeNone.
	 */
	public Boolean isExcludeNone() {
		return this.excludeNone;
	}

	/**
	 * @param excludeNone
	 *            The excludeNone to set.
	 */
	public void setExcludeNone(final Boolean excludeNone) {
		this.excludeNone = excludeNone;
	}

	/**
	 * @return Returns the excludeZeroes.
	 */
	public Boolean isExcludeZeroes() {
		return this.excludeZeroes;
	}

	/**
	 * @param excludeZeroes
	 *            The excludeZeroes to set.
	 */
	public void setExcludeZeroes(final Boolean excludeZeroes) {
		this.excludeZeroes = excludeZeroes;
	}

	/**
	 * @return Returns the isIgnoreCase.
	 */
	public Boolean isIgnoreCase() {
		return this.isIgnoreCase;
	}

	/**
	 * @param isIgnoreCase
	 *            The isIgnoreCase to set.
	 */
	public void setIgnoreCase(final Boolean isIgnoreCase) {
		this.isIgnoreCase = isIgnoreCase;
	}

	/**
	 * @return Returns the likeMatchMode.
	 */
	public MatchMode getLikeMatchMode() {
		return this.likeMatchMode;
	}

	/**
	 * @param likeMatchMode
	 *            The likeMatchMode to set.
	 */
	public void setLikeMatchMode(final MatchMode likeMatchMode) {
		this.likeMatchMode = likeMatchMode;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.enableLike == null) ? 0 : this.enableLike.hashCode());
        result = prime * result
                + ((this.exampleObject == null) ? 0 : this.exampleObject.hashCode());
        result = prime * result + ((this.excludeNone == null) ? 0 : this.excludeNone.hashCode());
        result = prime * result
                + ((this.excludeZeroes == null) ? 0 : this.excludeZeroes.hashCode());
        result = prime * result + ((this.isIgnoreCase == null) ? 0 : this.isIgnoreCase.hashCode());
        result = prime * result
                + ((this.likeMatchMode == null) ? 0 : this.likeMatchMode.hashCode());
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
        if (!(obj instanceof ExampleImpl))
            return false;
        ExampleImpl other = (ExampleImpl) obj;
        if (this.enableLike == null) {
            if (other.enableLike != null)
                return false;
        }
        else if (!this.enableLike.equals(other.enableLike))
            return false;
        if (this.exampleObject == null) {
            if (other.exampleObject != null)
                return false;
        }
        else if (!this.exampleObject.equals(other.exampleObject))
            return false;
        if (this.excludeNone == null) {
            if (other.excludeNone != null)
                return false;
        }
        else if (!this.excludeNone.equals(other.excludeNone))
            return false;
        if (this.excludeZeroes == null) {
            if (other.excludeZeroes != null)
                return false;
        }
        else if (!this.excludeZeroes.equals(other.excludeZeroes))
            return false;
        if (this.isIgnoreCase == null) {
            if (other.isIgnoreCase != null)
                return false;
        }
        else if (!this.isIgnoreCase.equals(other.isIgnoreCase))
            return false;
        if (this.likeMatchMode == null) {
            if (other.likeMatchMode != null)
                return false;
        }
        else if (!this.likeMatchMode.equals(other.likeMatchMode))
            return false;
        return true;
    }
}
