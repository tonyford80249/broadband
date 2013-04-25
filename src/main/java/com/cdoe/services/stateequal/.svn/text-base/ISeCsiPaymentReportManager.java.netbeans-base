package com.cdoe.services.stateequal;

import com.cdoe.biz.model.FiscalMonth;
import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.model.equal.CsiPaymentAdapter;
import com.cdoe.biz.model.jasper.CsiPaymentDatasource;
import com.cdoe.util.FilenameConstructor;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Tony Ford
 */
public interface ISeCsiPaymentReportManager {
    
    /**
     * 
     * @param month
     * @return 
     */
    public FilenameConstructor createCsiPaymentReporFilenameConstructor(String month);

    /**
     *
     * @param csiInfo
     * @return
     */
    List<CsiPaymentAdapter> computeCsiPaymentInfo(List<Csi> csiInfo);

    /**
     *
     * @param csiPayments
     * @param fiscalMonth
     * @param fiscalYear
     * @return
     */
    CsiPaymentDatasource createCsiPaymentDatasource(List<CsiPaymentAdapter> csiPayments, FiscalMonth fiscalMonth, String fiscalYear);

    /**
     *
     * @return
     */
    Map<String, String> getCSIListing();

    /**
     *
     * @param fiscalYear
     * @return
     */
    List<Csi> getCsiPaymentInfo(final String fiscalYear);

    /**
     *
     * @param districts
     */
    void saveGenerateData(Map<String, String> districts);
    
    /**
     * 
     * @param datasource
     * @param constructor
     * @param fiscalYear
     * @param fiscalMonth
     * @throws Exception 
     */
    public void generateReport(JRDataSource datasource, FilenameConstructor constructor, String fiscalYear, String fiscalMonth) throws Exception;
    
    /**
     * 
     * @param datasource
     * @param constructor
     * @throws Exception 
     */
    public void generateReport(JRDataSource datasource, FilenameConstructor constructor) throws Exception;
    
}
