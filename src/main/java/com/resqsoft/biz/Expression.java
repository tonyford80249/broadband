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
 * The <code>Expression</code> interface was inspired by, and designed after, 
 * Hibernate's Expression interface. It works in conjunction with our
 * <code>SearchCriteria</code> interface and represents a restriction placed
 * on a <code>SearchCriteria</code> object. For example, an <code>Expression</code> 
 * restricting a search among <code>Person</code> objects to those having a "LastName" 
 * <code>propertyName</code> (which might also be called an attribute or field name)
 * containing the "Doe" substring would be constructed as follows:
 * <br>
 * <br>
 * <code>Expression expr = new LikeExpression("LastName", "%Doe%");</code>
 * <br>
 * <br>
 * An Expression is set on a SearchCriteria object's which in its turn maps to a
 * database table column.  
 * <br>
 * <br>
 * Finally, all <code>Expression</code>s except logical ones have a <code>propertyName</code> attribute. 
 * As mentioned above, this is the name of the field on a business object that should
 * be evaluated.  There are two basic types of evaluations that are accomplished by the 
 * concrete implementations of this class: 1) a search that compares a provided value
 * to the value of each <code>propertyName</code> field (see com.resqsoft.biz.PropertyValueExpression), 
 * and 2) a search that compares the value of one provided <code>propertyName</code> 
 * field with the valus of another <code>otherPropertyName</code> field of the target 
 * business object (see com.resqsoft.biz.PropertyOtherPropertyExpression).
 * 
 * @author ResQSoft Engineer
 * @version 1.0
 * 
 */
public interface Expression extends Serializable {

	/**
	 * @return
	 */
	public String getPropertyName();

}
