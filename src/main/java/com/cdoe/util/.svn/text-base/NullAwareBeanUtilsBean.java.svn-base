/**
 * 
 */
package com.cdoe.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;

/**
 * Utility class to copy non-null properties of a bean
 * 
 * @author dyn-8
 *
 */
public class NullAwareBeanUtilsBean extends BeanUtilsBean {

	@Override
	public void copyProperty(Object dest, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {
		if (value != null)
			super.copyProperty(dest, name, value);
	}
	
	

}
