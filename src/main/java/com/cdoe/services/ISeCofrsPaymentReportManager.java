package com.cdoe.services;

import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.util.FilenameConstructor;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Tony Ford
 */
public interface ISeCofrsPaymentReportManager {

    /**
     *
     * @param month
     * @return
     */
    FilenameConstructor createCofrsPaymentReportFilenameConstructor(String month);
    
    /**
     * 
     * @param month
     * @param districts
     * @return 
     */
    FilenameConstructor createCofrsPaymentReportFilenameConstructor(String month, Collection<String> districts);

    /**
     *
     * @param districtMap
     * @param fiscalYear
     * @param month
     * @param cofrsPaymentInfo
     * @return
     */
    JRDataSource createMonthlyPaymnetDatasource(Map<String, String> districtMap, String fiscalYear, String month, List<StateEqual> cofrsPaymentInfo);

    /**
     * 
     * @param fiscalYear
     * @return 
     */
    public List<StateEqual> getCofrsPaymentInfo(String fiscalYear);
    
    
    /**
     * 
     * @param datasource
     * @param constructor
     * @param fiscalYear
     * @param fiscalMonth
     * @throws Exception 
     */
    void generateReport(JRDataSource datasource, FilenameConstructor constructor, String fiscalYear, String fiscalMonth) throws Exception;
    
}
