package com.cdoe.services.impl;

import com.cdoe.services.stateequal.IYtdPaymenstAndWithholdingsManager;
import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.biz.model.jasper.DistrictInfo;
import com.cdoe.biz.model.jasper.SEMonthlyPayment;
import com.cdoe.biz.model.jasper.SeMonthlyAdapter;
import com.cdoe.biz.model.jasper.YtdPaymentCollection;
import com.cdoe.util.FilenameConstructor;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/**
 *
 * @author Tony Ford
 */
public class YtdPaymenstAndWithholdingsManager extends MonthlyPaymentComparisonReportManager implements IYtdPaymenstAndWithholdingsManager {

    public static class YtdPaymentNWithholdingsReportNameConstructor implements FilenameConstructor {

        private String fiscalYear;
        private String fiscalMonth;

        public YtdPaymentNWithholdingsReportNameConstructor(String fiscalYear, String fiscalMonth) {
            this.fiscalYear = fiscalYear;
            this.fiscalMonth = fiscalMonth;
        }

        @Override
        public String construct(String defaultDirectory, String defaultFileName, String defaultExtention) {
            return defaultDirectory + defaultFileName + "." + defaultExtention;
        }

        @Override
        public File construct(String defaultPath) {
            return new File(defaultPath);
        }
    }

    /**
     * 
     * @param fiscalYear
     * @param fiscalMonth
     * @param districtNumbers
     * @param districtInfo
     * @return 
     */
    @Override
    public YtdPaymentCollection getLastestPaymentInfo(String fiscalYear, String fiscalMonth, List<String> districtNumbers, Map<String, String> districtInfo) {

        YtdPaymentCollection paymentCollection = new YtdPaymentCollection();


        for (String districtNumber : districtNumbers) {
            String distictName = districtInfo.get(districtNumber);

            List<SeMonthly> sePaymentInfo = this.getMonthlyPaymentInfo(districtNumber, fiscalYear, fiscalMonth);

            if (sePaymentInfo == null || sePaymentInfo.isEmpty()) {
                continue;
            }

            SortedSet<SeMonthlyAdapter> sePaymentInfoAndCaluationsList = this.performMonthlyPaymentCalculations(sePaymentInfo);

            SeMonthlyAdapter sePaymentInfoAndCaluations = this.getLastPayment(sePaymentInfoAndCaluationsList);

            DistrictInfo key = new DistrictInfo(distictName, districtNumber);
            SEMonthlyPayment value = new SEMonthlyPayment(sePaymentInfoAndCaluations);

            paymentCollection.getMonthlyPayment().put(key, value);
        }
        
        
        return paymentCollection;
    }
    
    /**
     * 
     * @param fiscalYear
     * @param fiscalMonth
     * @return 
     */
    @Override
    public FilenameConstructor createYtdPaymentFileNameConstructor(String fiscalYear, String fiscalMonth) {
     return new YtdPaymentNWithholdingsReportNameConstructor(fiscalYear, fiscalMonth);   
    }
}
