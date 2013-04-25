/*
 * Created on 26.04.2005
 * Created by: ResQSoft Engineer
 *//*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.biz;

import java.io.Serializable;

/**
 * Match mode for LIKE operator.  Possible values are:
 * <pre>
 * MatchMode.START ("Criteria%")
 * MatchMode.ANYWHERE  ("%Criteria%")
 * MatchMode.END  ("%Criteria")
 * MatchMode.EXACT  ("Criteria")
 * </pre>
 * The <code>MatchMode</code>s indicates where it is within a string
 * that the "like" operation should apply.
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 */
public final class MatchMode implements Serializable {

	private static final long serialVersionUID = 3916149014689000801L;

	public static final MatchMode ANYWHERE = new MatchMode("ANYWHERE");

	public static final MatchMode START = new MatchMode("START");

	public static final MatchMode END = new MatchMode("END");

	public static final MatchMode EXACT = new MatchMode("EXACT");

	private String name;

	private MatchMode(final String name) {
		this.name = name;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	public boolean equals(final Object obj) {
		return (obj instanceof MatchMode)
				&& obj.toString().equals(this.toString());
	}

	
	public String toString() {
		return "MatchMode: " + this.name;
	}

}
