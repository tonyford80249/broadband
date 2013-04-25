package com.cdoe.services.impl.stateequal;

import com.cdoe.services.stateequal.IElectionReportManager;
import com.cdoe.biz.model.equal.Election;
import com.cdoe.biz.model.jasper.ElectionInfo;
import com.cdoe.biz.model.jasper.ElectionInfoDatasource;
import com.cdoe.biz.stateequal.IElectionsDAO;
import com.cdoe.util.FilenameConstructor;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tony Ford
 */
public class ElectionReportManager extends ReportManagerBase implements IElectionReportManager {

    public static class ElectionReportFilenameConstructor implements FilenameConstructor {

        public ElectionReportFilenameConstructor() {
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
    private IElectionsDAO electionsDAO;

    /**
     *
     * @param fiscalYear
     * @param districtMap
     * @param countyMap
     * @return
     */
    @Override
    public List<ElectionInfo> createCollection(String fiscalYear, Map<String, String> districtMap, Map<String, String> countyMap) {
        List<Election> electionData = electionsDAO.getElectionByFiscalYear(fiscalYear);

        List<ElectionInfo> collection = new ArrayList<ElectionInfo>();

        for (Election election : electionData) {
            collection.add(new ElectionInfo(fiscalYear, election.getDistrictNumber(), districtMap.get(election.getDistrictNumber()), countyMap.get(election.getDistrictNumber()), election.getVoteFor() != null ? election.getVoteFor().intValue() : null, election.getVoteAgainst() != null ? election.getVoteAgainst().intValue() : null, election.getCategoryAmount(), election.getBallotLanguage()));
        }

        return collection;
    }

    /**
     *
     * @param collection
     * @return
     */
    @Override
    public ElectionInfoDatasource createElectionInfoDatasource(List<ElectionInfo> collection) {
        return new ElectionInfoDatasource(collection);
    }

    /**
     *
     * @return
     */
    @Override
    public ElectionReportFilenameConstructor createFilenameConstructor() {
        return new ElectionReportFilenameConstructor();
    }

    public void setElectionsDAO(IElectionsDAO electionsDAO) {
        this.electionsDAO = electionsDAO;
    }
}
