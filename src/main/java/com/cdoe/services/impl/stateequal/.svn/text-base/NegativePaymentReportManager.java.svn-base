package com.cdoe.services.impl.stateequal;

import com.cdoe.services.stateequal.INegativePaymentReportManager;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.jasper.NegativePayment;
import com.cdoe.biz.model.jasper.NegativePaymentDatasource;
import com.cdoe.biz.model.jasper.SeTotalEntitlement;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.util.FilenameConstructor;
import com.cdoe.util.UserInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tony Ford
 */
public class NegativePaymentReportManager extends ReportManagerBase implements INegativePaymentReportManager {

    public static class NegativePaymentReportFilenameConstructor implements FilenameConstructor {

        /**
         *
         */
        public NegativePaymentReportFilenameConstructor() {
        }

        /**
         *
         * @param defaultDirectory
         * @param defaultFileName
         * @param defaultExtention
         * @return
         */
        @Override
        public String construct(String defaultDirectory, String defaultFileName, String defaultExtention) {
            Date now = new Date();

            String formattedDate = now.toString().replace(" ", SEPARATOR).replace(":", "-");

            String absolutePath = defaultDirectory + defaultFileName + SEPARATOR + formattedDate + "." + defaultExtention;

            return absolutePath;
        }

        /**
         *
         * @param defaultPath
         * @return
         */
        @Override
        public File construct(String defaultPath) {
            return new File(defaultPath);
        }
    }
    private IStateEqualDAO stateEqualDAO;

    /**
     *
     * @param fiscalYear
     * @param userInfo
     * @return
     */
    @Override
    public Map<Integer, List<NegativePayment>> createNegativePaymentCollection(String fiscalYear, UserInfo userInfo) {
        Map<Integer, List<NegativePayment>> results = new HashMap<Integer, List<NegativePayment>>();

        List<NegativePayment> positivePayments = new ArrayList<NegativePayment>();

        results.put(1, positivePayments);

        List<NegativePayment> negativePayments = new ArrayList<NegativePayment>();

        results.put(2, negativePayments);


        Map<String, String> countyMap = userInfo.getDistrictPrimaryCountyMap();

        Map<String, String> districtMap = userInfo.getDistrictMap();

        boolean deltaFound = false;

        for (String districtNumber : userInfo.getAllDistrictCodes()) {
            List<StateEqual> currentAndPrevious = stateEqualDAO.findTop100ByUniqueKey(districtNumber, fiscalYear, 2);

            StateEqual currentRecord = null;
            StateEqual previousRecord = null;

            if (currentAndPrevious != null && !currentAndPrevious.isEmpty()) {
                Iterator<StateEqual> iter = currentAndPrevious.iterator();
                for (int index = 0; iter.hasNext(); ++index) {
                    switch (index) {
                        case 0:
                            currentRecord = iter.next();
                            break;
                        case 1:
                            previousRecord = iter.next();
                            break;
                    }
                }
            }

            double currentYtdEntitlement = currentRecord != null && currentRecord.getYtdEntitle() != null ? currentRecord.getYtdEntitle() : 0.0;

            double previousYtdEntitlement = previousRecord != null && previousRecord.getYtdEntitle() != null ? previousRecord.getYtdEntitle() : 0.0;

            double monthEntitlement = currentYtdEntitlement - previousYtdEntitlement;

            if (monthEntitlement <= 0) {
                negativePayments.add(new NegativePayment(countyMap.get(districtNumber), fiscalYear, districtNumber, districtMap.get(districtNumber), monthEntitlement, currentYtdEntitlement, previousYtdEntitlement));
            } else {
                positivePayments.add(new NegativePayment(countyMap.get(districtNumber), fiscalYear, districtNumber, districtMap.get(districtNumber), monthEntitlement, null, null));
            }

            if (currentYtdEntitlement != previousYtdEntitlement) {
                deltaFound = true;
            }
        }

        if (deltaFound) {
            Collections.sort(negativePayments, NegativePayment.getOrderByDistrictComparator());
            Collections.sort(positivePayments, NegativePayment.getOrderByCountyComparator());

            return results;
        }

        return null;
    }

    /**
     *
     * @param collection
     * @return
     */
    @Override
    public NegativePaymentDatasource createNegativePaymentDatasource(List<NegativePayment> collection) {
        return new NegativePaymentDatasource(collection);
    }

    /**
     *
     * @return
     */
    @Override
    public NegativePaymentReportFilenameConstructor createNegativePaymentReportFilenameConstructor() {
        return new NegativePaymentReportFilenameConstructor();
    }

    public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
        this.stateEqualDAO = stateEqualDAO;
    }
}
