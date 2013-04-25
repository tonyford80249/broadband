/**
 * 
 *//*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.biz;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


/**
 * @author ResQSoft Engineer
 *
 */
abstract class BaseExpression implements Expression {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {    
        return EqualsBuilder.reflectionEquals(this, obj);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {    
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
}
