/**
 * 
 *//*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.biz;


/**
 * Unary expressions apply a logical operand (NOT)
 * to an {@link Expression}. You can construct the actual logical expression by instantiating the subclasses
 * of {@link UnaryExpression}.
 * @author ResQSoft Engineer
 *
 */
public abstract class UnaryExpression extends BaseExpression {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    /* (non-Javadoc)
     * @see com.resqsoft.biz.Expression#getPropertyName()
     */
    public String getPropertyName() {

        return null;
    }
    
    private Expression operand;

    
    /**
     * @return the operand
     */
    public Expression getOperand() {
    
        return this.operand;
    }

    
    /**
     * @param operand the operand to set
     */
    public void setOperand(Expression operand) {
    
        this.operand = operand;
    }
    
}
