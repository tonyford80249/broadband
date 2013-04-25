package com.cdoe.biz.model.jasper;

import com.cdoe.util.JrDatasourceBasicField;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRDataSourceProvider;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Tony Ford
 */
public class MessageDatasourceProvider implements  JRDataSourceProvider {

    @Override
    public boolean supportsGetFieldsOperation() {
        return true;
    }

    @Override
    public JRField[] getFields(JasperReport jr) throws JRException, UnsupportedOperationException {
        JRField[] fieldsAre = new JRField[6];                
        
        fieldsAre[0] = JrDatasourceBasicField.newInstance(MessageDatasource.GENERAL_INFO, "descrptive message", String.class);
        fieldsAre[1] = JrDatasourceBasicField.newInstance(MessageDatasource.REPORT_NAME, "The report name", String.class);
        fieldsAre[2] = JrDatasourceBasicField.newInstance(MessageDatasource.DISTRICT_NAME, "The name of the school district.", String.class);
        fieldsAre[3] = JrDatasourceBasicField.newInstance(MessageDatasource.DISTRICT_NUMBER, "The number of the school district.", String.class);
        fieldsAre[4] = JrDatasourceBasicField.newInstance(MessageDatasource.FISCAL_YEAR, "The fiscal year in which the payment was made.", String.class);
        fieldsAre[5] = JrDatasourceBasicField.newInstance(MessageDatasource.FISCAL_MONTH, "The month that the payment was maid.", String.class);
        
        
        
        return fieldsAre;
    }

    @Override
    public JRDataSource create(JasperReport jr) throws JRException {
        return new MessageDatasource( new Message("CSI school payment report","MAPLETON","0010","20122013","August","Unable to generate report due to missing information"));        
    }

    @Override
    public void dispose(JRDataSource jrds) throws JRException {
      
    }
    
}
