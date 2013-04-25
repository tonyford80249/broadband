package com.cdoe.biz.model.jasper;

import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 */
public class ElectionInfoDatasource implements JRDataSource {
    public static final String COUNTY = "county";    
    public static final String FISCAL_YEAR = "fiscalYear";    
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String DISTIRCT_NAME = "districtName";
    public static final String VOTES_FOR = "votesFor";
    public static final String VOTES_AGAINST = "votesAgainst";
    public static final String DOLLAR_AMOUNT = "dollarAmount";
    public static final String BALLOT_LANGAUGE = "ballotLangauge";
    
    
    
    private List<ElectionInfo> collection;
    private Iterator<ElectionInfo> iterator = null;
    private ElectionInfo currentElectionInfo = null;

    public ElectionInfoDatasource(List<ElectionInfo> collection) {
        this.collection = collection;
    }

  
    
    
    @Override
    public boolean next() throws JRException {
        currentElectionInfo = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.iterator();
        }

        if (this.iterator == null) {
            return false;
        }

        return this.iterator.hasNext();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        if (currentElectionInfo == null) {
            currentElectionInfo = this.iterator.next();
        }

        if (jrf.getName().equals(FISCAL_YEAR) && currentElectionInfo != null) {
            return currentElectionInfo.getFiscalYear();
        } else if (jrf.getName().equals(DISTRICT_NUMBER) && currentElectionInfo != null) {
            return currentElectionInfo.getDistrictNumber();
        } else if (jrf.getName().equals(DISTIRCT_NAME) && currentElectionInfo != null) {
            return currentElectionInfo.getDistrictName();
        } else if (jrf.getName().equals(VOTES_FOR) && currentElectionInfo != null) {
            return currentElectionInfo.getVotesFor();
        } else if (jrf.getName().equals(VOTES_AGAINST) && currentElectionInfo != null) {
            return currentElectionInfo.getVotesAgainst();
        } else if (jrf.getName().equals(DOLLAR_AMOUNT) && currentElectionInfo != null) {
            return currentElectionInfo.getDollarAmount();
        }  else if (jrf.getName().equals(BALLOT_LANGAUGE) && currentElectionInfo != null) {
            return currentElectionInfo.getBallotLanguage();
        } else if (jrf.getName().equals(COUNTY) && currentElectionInfo != null) {
            return currentElectionInfo.getCounty();
        } 
        
        
        
        return null;
    }
      
}
