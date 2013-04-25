package com.cdoe.biz.model.jasper;

import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 */
public class ImportPriorYearAuditDatasource implements JRDataSource{
    public static final String FISCAL_YEAR = "fiscalYear";    
    public static final String DISTRICT_NUMBER = "districtNumber";
    public static final String DISTIRCT_NAME = "districtName";
    public static final String AUDIT_FTE_COUNT = "auditFTECount";
    public static final String AUDIT_CPP_COUNT = "auditCPPCount";
    public static final String AUDIT_ONLINE_COUNT = "auditOnlineCount";
    public static final String FUNDED_PUPIL_COUNT = "fundedPupilCount";
    public static final String TOTAL_PROGRAM_FUNDING = "totalProgramFunding";
    public static final String PER_PUPIL_FUNDING = "perPupilFunding";
    
    
    private ImportPriorYearAuditCollection collection;
    private Iterator<ImportPriorYearAudit> iterator = null;
    private ImportPriorYearAudit currentImportPriorYearAudit = null;

    public ImportPriorYearAuditDatasource(ImportPriorYearAuditCollection collection) {
        this.collection = collection;
    }
    
    
    
    @Override
    public boolean next() throws JRException {
        currentImportPriorYearAudit = null;

        if (this.iterator == null && collection != null) {
            this.iterator = collection.getAudits().iterator();
        }

        if (this.iterator == null) {
            return false;
        }

        return this.iterator.hasNext();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        if (currentImportPriorYearAudit == null) {
            currentImportPriorYearAudit = this.iterator.next();
        }

        if (jrf.getName().equals(FISCAL_YEAR) && currentImportPriorYearAudit != null) {
            return currentImportPriorYearAudit.getFiscalYear();
        } else if (jrf.getName().equals(DISTRICT_NUMBER) && currentImportPriorYearAudit != null) {
            return currentImportPriorYearAudit.getOrganizationCode();
        } else if (jrf.getName().equals(DISTIRCT_NAME) && currentImportPriorYearAudit != null) {
            return currentImportPriorYearAudit.getOrganizationName();
        } else if (jrf.getName().equals(AUDIT_FTE_COUNT) && currentImportPriorYearAudit != null) {
            return currentImportPriorYearAudit.getAuditedFTECount();
        } else if (jrf.getName().equals(AUDIT_CPP_COUNT) && currentImportPriorYearAudit != null) {
            return currentImportPriorYearAudit.getAuditedCPPCount();
        } else if (jrf.getName().equals(AUDIT_ONLINE_COUNT) && currentImportPriorYearAudit != null) {
            return currentImportPriorYearAudit.getAuditedOnlineCount();
        } else if (jrf.getName().equals(FUNDED_PUPIL_COUNT) && currentImportPriorYearAudit != null) {
            return currentImportPriorYearAudit.getNewFundedPupilCount();
        } else if (jrf.getName().equals(TOTAL_PROGRAM_FUNDING) && currentImportPriorYearAudit != null) {
            return currentImportPriorYearAudit.getRevisedTotalProgramFunding();
        } else if (jrf.getName().equals(PER_PUPIL_FUNDING) && currentImportPriorYearAudit != null) {
            return currentImportPriorYearAudit.getRevisedPerPupilFunding();
        } 
        
        
        
        return null;
    }
    
}
