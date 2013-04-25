package com.cdoe.biz.audit;

import com.cdoe.biz.model.audit.AuditSasidException;
import java.util.List;

/**
 *
 * @author Tony Ford
 */
public interface IAuditSasidExceptionDAO {

    /**
     *
     * @param districtCode
     * @param fiscalYear
     * @return
     */
    List<AuditSasidException> findByDistrict(String districtCode);

    /**
     *
     * @param districtCode
     * @param fiscalYear
     * @return
     */
    List<AuditSasidException> findByDistrictAndFiscalYear(String districtCode, String fiscalYear);

    /**
     *
     * @param sasId
     * @param districtCode
     * @param fiscalYear
     * @return
     */
    AuditSasidException findByUniqueKey(String sasId, String districtCode, String fiscalYear);
    
    
    /**
     * 
     * @param districtCode
     * @return 
     */
    List<AuditSasidException> findAtRiskExceptionsByDistrict(String districtCode);
    
    /**
     * 
     * @param districtCode
     * @return 
     */
    List<AuditSasidException> findPupilExceptionsByDistrict(String districtCode);
    
}
