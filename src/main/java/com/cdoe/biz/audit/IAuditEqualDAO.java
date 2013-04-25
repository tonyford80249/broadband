package com.cdoe.biz.audit;

import com.cdoe.biz.model.audit.AuditEqual;
import java.util.List;

/**
 *
 * @author Tony Ford
 */
public interface IAuditEqualDAO {

    /**
     * 
     * @param auditId
     * @return 
     */
    AuditEqual findByAuditId(Integer auditId);

    /**
     *
     * @param auditIds
     * @return
     */
    List<AuditEqual> findByAuditsOnly(List<Integer> auditIds);

    /**
     * 
     * @param auditId
     * @param districtCode
     * @param fiscalYear
     * @return 
     */
    AuditEqual findByUniqueKey(Integer auditId, String districtCode, String fiscalYear);
    
}
