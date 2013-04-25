package com.cdoe.services.stateequal;

import com.cdoe.biz.model.jasper.NegativePayment;
import com.cdoe.biz.model.jasper.NegativePaymentDatasource;
import com.cdoe.services.impl.stateequal.NegativePaymentReportManager.NegativePaymentReportFilenameConstructor;
import com.cdoe.util.FilenameConstructor;
import com.cdoe.util.UserInfo;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Tony Ford
 */
public interface INegativePaymentReportManager {

    /**
     *
     * @param fiscalYear
     * @param userInfo
     * @return
     */
    Map<Integer, List<NegativePayment>> createNegativePaymentCollection(String fiscalYear, UserInfo userInfo);

    /**
     *
     * @param collection
     * @return
     */
    NegativePaymentDatasource createNegativePaymentDatasource(List<NegativePayment> collection);

    /**
     *
     * @return
     */
    NegativePaymentReportFilenameConstructor createNegativePaymentReportFilenameConstructor();
    
    /**
     * 
     * @param datasource
     * @param constructor
     * @throws Exception 
     */
    public void generateReport(JRDataSource datasource, FilenameConstructor constructor) throws Exception;
    
}
