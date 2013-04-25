package com.cdoe.services.stateequal;

import com.cdoe.biz.model.jasper.YtdPaymentCollection;
import com.cdoe.util.FilenameConstructor;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tony Ford
 */
public interface IYtdPaymenstAndWithholdingsManager extends IMonthlyPaymentComparisonReportManager {

    /**
     *
     * @param fiscalYear
     * @param fiscalMonth
     * @return
     */
    FilenameConstructor createYtdPaymentFileNameConstructor(String fiscalYear, String fiscalMonth);

    /**
     *
     * @param fiscalYear
     * @param fiscalMonth
     * @param districtNumbers
     * @param districtInfo
     * @return
     */
    YtdPaymentCollection getLastestPaymentInfo(String fiscalYear, String fiscalMonth, List<String> districtNumbers, Map<String, String> districtInfo);
    
}
