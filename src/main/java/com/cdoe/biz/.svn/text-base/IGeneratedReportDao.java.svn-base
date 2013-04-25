package com.cdoe.biz;

import com.cdoe.biz.model.GeneratedReport;
import com.cdoe.db.hibernate.IHibernateDAO;
import java.util.List;

/**
 *
 * @author Tony Ford
 */
public interface IGeneratedReportDao extends IHibernateDAO {

    /**
     *
     * @param id
     * @return
     */
    GeneratedReport getReportById(Long id);

    /**
     *
     * @param absolutePath
     * @return
     */
    List<GeneratedReport> getReportByLocation(final String absolutePath);
    
    
    /**
     * 
     * @param absolutePath
     * @return 
     */
    GeneratedReport getReportByUniqueLocation(final String absolutePath);

    /**
     *
     * @param name
     * @return
     */
    List<GeneratedReport> getReportByName(final String name);
    
    
    /**
     * 
     * @param fiscalYear
     * @param fiscalMonth
     * @param group
     * @return 
     */
    List<GeneratedReport> getReportByGrouping(final String fiscalYear, final String fiscalMonth, final String group);
    
}
