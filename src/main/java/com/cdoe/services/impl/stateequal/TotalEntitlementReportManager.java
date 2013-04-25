package com.cdoe.services.impl.stateequal;

import com.cdoe.services.stateequal.ITotalEntitlementReportManager;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.jasper.SeTotalEntitlement;
import com.cdoe.biz.model.jasper.SeTotalEntitlementDatasource;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.util.FilenameConstructor;
import com.cdoe.util.UserInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tony Ford
 */
public class TotalEntitlementReportManager extends ReportManagerBase implements ITotalEntitlementReportManager {

    public static class TotalEntitlementReportFilenameConstructor implements FilenameConstructor {

        /**
         *
         */
        public TotalEntitlementReportFilenameConstructor() {
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
    public List<SeTotalEntitlement> createTotalEntitlementCollection(String fiscalYear, UserInfo userInfo) {
        List<SeTotalEntitlement> results = new ArrayList<SeTotalEntitlement>();

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


            double currentStateEqual = currentRecord != null && currentRecord.getStateEqual() != null ? currentRecord.getStateEqual() : 0.0;

            double previousStatEqual = previousRecord != null && previousRecord.getStateEqual() != null ? previousRecord.getStateEqual() : 0.0;

            if (currentStateEqual != previousStatEqual) {
                deltaFound = true;
            }

            results.add(new SeTotalEntitlement(fiscalYear, districtNumber, districtMap.get(districtNumber), previousStatEqual, currentStateEqual));
        }

        if (deltaFound) {
            return results;
        }

        return null;
    }

    /**
     *
     * @param totalEntitlementCollection
     * @return
     */
    @Override
    public SeTotalEntitlementDatasource createSeTotalEntitlementDatasource(List<SeTotalEntitlement> totalEntitlementCollection) {
        return new SeTotalEntitlementDatasource(totalEntitlementCollection);
    }

    /**
     *
     * @return
     */
    @Override
    public TotalEntitlementReportFilenameConstructor createTotalEntitlementReportFilenameConstructor() {
        return new TotalEntitlementReportFilenameConstructor();
    }

    public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
        this.stateEqualDAO = stateEqualDAO;
    }
}
