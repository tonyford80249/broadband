package com.cdoe.biz.model.jasper;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * <p> 
 *    <b>description</b> This a model object used in jasper report framework.
 *                        This model supports the district monthly payment report and contains values for the month.
 * </p>
 *
 * @author Tony Ford
 */
public class MessageDatasource implements JRDataSource {
    public static final String REPORT_NAME = "reportName";
    public static final String DISTRICT_NAME = "districtName";
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String FISCAL_YEAR = "fiscalYear";
    public static final String FISCAL_MONTH = "fiscalMonth";
    public static final String GENERAL_INFO = "generalInfo";
    
    private Message message;
    private boolean used;

    public MessageDatasource(Message message) {
        this.message = message;
    }
    
    
    /**
     * 
     * @return
     * @throws JRException 
     */
    @Override
    public boolean next() throws JRException {
      
     if (!used)   {
      used = true;
      
      return true;
     }
      
     return false;
    }

    /**
     * 
     * @param jrf
     * @return
     * @throws JRException 
     */
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
       if (jrf.getName().equals(REPORT_NAME)) {
            return message.getReportName();
        } 
        else if (jrf.getName().equals(DISTRICT_NAME)) {
            return message.getDistrictName();
        }
        else if (jrf.getName().equals(DISTRICT_NUMBER)) {
            return message.getDistrictNumber();
        }
        else if (jrf.getName().equals(FISCAL_YEAR)) {
            return message.getFiscalYear();
        }
        else if (jrf.getName().equals(FISCAL_MONTH)) {            
            return message.getFiscalMonth();
        }
        else if (jrf.getName().equals(GENERAL_INFO)) {
            return message.getGeneralInfo();
        }
       
       return null;
    }
    
}
