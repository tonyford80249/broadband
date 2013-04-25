package com.cdoe.biz.model.jasper;

import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 */
public class AuditExceptionDatasource implements JRDataSource {
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String DISTIRCT_NAME = "districtName"; 
    public static final String FISCAL_YEAR = "fiscalYear";    
    public static final String SCHOOL = "school";    
    public static final String GRADE = "grade";
    public static final String LAST_NAME = "lastName";
    public static final String FIRST_NAME = "firstName";
    public static final String MIDDLE_NAME = "middleName";
    public static final String EXCEPTION = "exception";
    public static final String FTE_ADJUST = "fteAdjust";
    
    
    
    private List<AuditException> collection;
    private Iterator<AuditException> iterator = null;
    private AuditException currentException = null;

    public AuditExceptionDatasource(List<AuditException> collection) {
        this.collection = collection;
    }
    
    @Override
    public boolean next() throws JRException {
         currentException = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.iterator();
        }

        if (this.iterator == null) {
            return false;
        }

        return this.iterator.hasNext();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
         if (currentException == null) {
            currentException = this.iterator.next();
        }

        if (jrf.getName().equals(FISCAL_YEAR) && currentException != null) {
            return currentException.getFiscalYear();
        } else if (jrf.getName().equals(DISTRICT_NUMBER) && currentException != null) {
            return currentException.getDistrctNumber();
        }else if (jrf.getName().equals(DISTIRCT_NAME) && currentException != null) {
            return currentException.getDistrictName();
        }else if (jrf.getName().equals(SCHOOL) && currentException != null) {
            return currentException.getSchool();
        } else if (jrf.getName().equals(GRADE) && currentException != null) {
            return currentException.getGrade();
        } else if (jrf.getName().equals(LAST_NAME) && currentException != null) {
            return currentException.getLastName();
        } else if (jrf.getName().equals(FIRST_NAME) && currentException != null) {
            return currentException.getFirstName();
        } else if (jrf.getName().equals(MIDDLE_NAME) && currentException != null) {
            return currentException.getMiddleName();
        }  else if (jrf.getName().equals(EXCEPTION) && currentException != null) {
            return currentException.getException();
        } else if (jrf.getName().equals(FTE_ADJUST) && currentException != null) {
            return currentException.getFteAdjust();
        } 
        
        
        
        return null;
    }
    
}
