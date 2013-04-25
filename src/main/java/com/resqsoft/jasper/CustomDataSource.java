/*
 * Created on Sep 3, 2003 To change the template for this generated file go to Window - Preferences -
 * Java - Code Generation - Code and Comments
 */
/*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.jasper;

import java.util.Collection;
import java.util.Iterator;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

public class CustomDataSource implements JRDataSource {

    private static final Logger APP_LOG = Logger.getLogger(CustomDataSource.class);

    private Iterator iterator;

    private Object currentValue;

    public CustomDataSource(Collection list) {

        this.iterator = list.iterator();
    }

    public Object getFieldValue(JRField field) throws JRException {

        Object retobj = null;
        try {
            retobj = PropertyUtils.getProperty(currentValue, field.getName());
        }
        catch (Exception ex) {
            APP_LOG.warn("Error when reading object property: "+ex.getMessage());
        }
        return retobj;
    }

    public boolean next() throws JRException {

        currentValue = iterator.hasNext() ? iterator.next() : null;
        return (currentValue != null);
    }

}
