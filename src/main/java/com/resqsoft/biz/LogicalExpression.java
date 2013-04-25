/**
 *
 *//*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.biz;


/**
 * Logical expressions combine two other expressions and apply logical operand (AND, OR)
 * to them. You can construct the actual logical expression by instantiating the subclasses
 * of {@link LogicalExpression}.
 * @author ResQSoft Engineer
 *
 */
public abstract class LogicalExpression extends BaseExpression {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Expression leftHandSide;
    private Expression rightHandSide;


    /**
     *
     */
    public LogicalExpression(Expression lhs, Expression rhs) {
        this.leftHandSide = lhs;
        this.rightHandSide = rhs;
    }



    public Expression getLeftHandSide() {

        return this.leftHandSide;
    }



    public void setLeftHandSide(Expression leftHandSide) {

        this.leftHandSide = leftHandSide;
    }



    public Expression getRightHandSide() {

        return this.rightHandSide;
    }



    public void setRightHandSide(Expression rightHandSide) {

        this.rightHandSide = rightHandSide;
    }


    /* (non-Javadoc)
     * @see com.resqsoft.biz.Expression#getPropertyName()
     */
    public String getPropertyName() {
        return null;
    }

}
