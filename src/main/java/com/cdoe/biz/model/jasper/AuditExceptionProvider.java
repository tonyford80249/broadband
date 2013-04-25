package com.cdoe.biz.model.jasper;

import com.cdoe.biz.model.jasper.AuditException;
import com.cdoe.util.JrDatasourceBasicField;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRDataSourceProvider;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Tony Ford
 */
public class AuditExceptionProvider implements  JRDataSourceProvider{

    @Override
    public boolean supportsGetFieldsOperation() {
       return true;
    }

    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
       JRField[] fieldsAre = new JRField[9];
                
        fieldsAre[0] = JrDatasourceBasicField.newInstance(AuditExceptionDatasource.FISCAL_YEAR, "The audit id of the imported audit.", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(AuditExceptionDatasource.EXCEPTION, "the organization number of the organization that is under audit.", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(AuditExceptionDatasource.FIRST_NAME, "The name of the organzation under audit.", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(AuditExceptionDatasource.FTE_ADJUST, "The date the audit was available for import.", Double.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(AuditExceptionDatasource.GRADE, "The date the audit was imported", String.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(AuditExceptionDatasource.LAST_NAME, "The audit id of the imported audit.", String.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(AuditExceptionDatasource.MIDDLE_NAME, "The audit id of the imported audit.", String.class);
        fieldsAre[6] = JrDatasourceBasicField.newInstance(AuditExceptionDatasource.SCHOOL, "The audit id of the imported audit.", String.class);
        fieldsAre[7] = JrDatasourceBasicField.newInstance(AuditExceptionDatasource.DISTRICT_NUMBER, "The audit id of the imported audit.", String.class);
        fieldsAre[8] = JrDatasourceBasicField.newInstance(AuditExceptionDatasource.DISTIRCT_NAME, "The audit id of the imported audit.", String.class);
                                        
        return fieldsAre;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
        return new AuditExceptionDatasource(createCollection());
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
        
    }
    
    public static final List<AuditException> createCollection() {
     List<AuditException> result = new ArrayList<AuditException>();   
     
     result.add(new AuditException("0010","Mappleton RE-1","2009", "Middle School", "080", "Doe", "Jane", "Marie", "Student did not meet attendance requirements.", 1.0));
     result.add(new AuditException("0010","Mappleton RE-1","2009", "Middle School", "080", "Dower", "Michael", "David", "Student did not meet attendance requirements.", 1.0));
     result.add(new AuditException("0010","Mappleton RE-1","2009", "Middle School", "080", "Smith", "Billy", "Bob", "Student did not meet attendance requirements.", 1.0));
     result.add(new AuditException("0010","Mappleton RE-1","2009", "High School", "100", "Gore", "Sally", "Jane", "Student did not meet attendance requirements.", 1.0));
     result.add(new AuditException("0010","Mappleton RE-1","2009", "High School", "110", "Martin", "Loise", "Renee", "Student did not meet general scheduling requirements.", 1.0));
     result.add(new AuditException("0010","Mappleton RE-1","2009", "High School", "120", "Johnson", "Tyler", "John", "Student did not meet concurrent enrollment/ASCENT/EC/DR requirements.", 0.5));
     result.add(new AuditException("0010","Mappleton RE-1","2009", "High School", "120", "May", "Suzie", "Sally", "Student did not meet general scheduling requirement.", 1.0));
     
     result.add(new AuditException("0010","Mappleton RE-1","2010", "High School", "090", "Billy", "Thorton", "Bob", "Student did not meet attendance requirements.", 1.0));
     result.add(new AuditException("0010","Mappleton RE-1","2010", "High School", "120", "Mary", "Bliage", "Jay", "Student did not meet concurrent enrollment/ASCENT/EC/DR requirements.", 1.0));     
     result.add(new AuditException("0010","Mappleton RE-1","2010", "High School", "120", "Smith", "Billy", "Bob", "Student did not meet attendance requirements.", 1.0));
     
     result.add(new AuditException("0010","Mappleton RE-1","2011", "Elementary School", "007", "James", "Bond", "Bob", "Other", 0.5));
     result.add(new AuditException("0010","Mappleton RE-1","2011", "High School", "110", "Jimmy", "Dean", "Bob", "Student did not meet general scheduling requirement.", 1.0));
     result.add(new AuditException("0010","Mappleton RE-1","2011", "High School", "120", "Ready", "World", "For", "Student did not meet general scheduling requirement.", 0.5));
     result.add(new AuditException("0010","Mappleton RE-1","2011", "High School", "120", "Oscar", "Powers", "Bob", "Student did not meet general scheduling requirement.", 1.0));
     result.add(new AuditException("0010","Mappleton RE-1","2011", "High School", "120", "Martin", "Larwarence", "Bob", "Student did not meet general scheduling requirement.", 0.5));
     result.add(new AuditException("0010","Mappleton RE-1","2011", "High School", "120", "Jason", "White", "Bob", "Student did not meet general scheduling requirement.", 0.5));
     result.add(new AuditException("0010","Mappleton RE-1","2011", "High School", "120", "Holy", "Robinson", "Bob", "Student did not meet general scheduling requirement.", 0.5));
     result.add(new AuditException("0010","Mappleton RE-1","2011", "High School", "120", "Kelly", "Smith", "Bob", "Student did not meet general scheduling requirement.", 0.5));
     result.add(new AuditException("0010","Mappleton RE-1","2011", "High School", "120", "Fredd", "Dean", "Bob", "Student did not meet general scheduling requirement.", 1.0));
     result.add(new AuditException("0010","Mappleton RE-1","2011", "High School", "120", "Dean", "Snow", "Bob", "Student did not meet general scheduling requirement.", 0.5));
     
     result.add(new AuditException("0010","Mappleton RE-1","2012", "High School", "090", "Roger", "Federal", "Bob", "Student did not meet attendance requirement.", 1.0));
     result.add(new AuditException("0010","Mappleton RE-1","2012", "High School", "120", "Shelly", "Jones", "Bob", "Student did not meet general scheduling requirement.", 0.5));
     result.add(new AuditException("0010","Mappleton RE-1","2012", "High School", "120", "Sonya", "Red", "Bob", "Student did not meet attendance requirement.", 1.0));
                         
     
     return result;
    }
    
}
