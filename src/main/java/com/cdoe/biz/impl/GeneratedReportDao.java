package com.cdoe.biz.impl;

import com.cdoe.biz.IGeneratedReportDao;
import com.cdoe.biz.IDistrictsDAO;
import com.cdoe.biz.impl.transportation.Cde40TransReimbFormDAO;
import com.cdoe.biz.model.GeneratedReport;
import com.cdoe.biz.model.OrganizationUnitMaster;
import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.db.hibernate.HibernateDAO;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 *
 * @author Tony Ford
 */
public class GeneratedReportDao extends HibernateDAO implements IGeneratedReportDao {

    private static final Logger LOGGER = Logger.getLogger(GeneratedReportDao.class);

    /**
     *
     * @param id
     * @return
     */
    @Override
    public GeneratedReport getReportById(Long id) {
        return super.getHibernateTemplate().get(GeneratedReport.class, id);
    }

    /**
     * 
     * @param absolutePath
     * @return 
     */
    @Override
    public List<GeneratedReport> getReportByLocation(final String absolutePath) {
        return getHibernateTemplate().executeFind(new HibernateCallback<List<GeneratedReport>>() {
            @Override
            public List<GeneratedReport> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session.createQuery("FROM GeneratedReport gr WHERE gr.absolutePath LIKE :absolutePath");
                query.setString("absolutePath", "%" + absolutePath + "%");

                LOGGER.info("absolutePath -->" + absolutePath);

                return (List<GeneratedReport>) query.list();
            }
        });
    }
    
    /**
     * 
     * @param absolutePath
     * @return 
     */
    public GeneratedReport getReportByUniqueLocation(final String absolutePath) {
        List<GeneratedReport> reports = getReportByLocation(absolutePath);  
        
        if (reports != null && !reports.isEmpty()) {
         return reports.iterator().next();   
        }
        
        return null;
    }

    /**
     * 
     * @param name
     * @return 
     */
    @Override
    public List<GeneratedReport> getReportByName(final String name) {
        return getHibernateTemplate().executeFind(new HibernateCallback<List<GeneratedReport>>() {
            @Override
            public List<GeneratedReport> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session.createQuery("FROM GeneratedReport gr WHERE gr.name LIKE :name");
                query.setString("name", "%" + name + "%");

                LOGGER.info("name -->" + name);

                return (List<GeneratedReport>) query.list();
            }
        });
    }
    
    
    /**
     * 
     * @param name
     * @return 
     */
    @Override
    public List<GeneratedReport> getReportByGrouping(final String fiscalYear, final String fiscalMonth, final String group) {
        return getHibernateTemplate().executeFind(new HibernateCallback<List<GeneratedReport>>() {
            @Override
            public List<GeneratedReport> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session.createQuery("FROM GeneratedReport gr WHERE gr.reportType = :reportType AND gr.fiscalYear = :fiscalYear AND gr.fiscalMonth = :fiscalMonth");
                query.setString("reportType",group);
                query.setString("fiscalYear",fiscalYear);
                query.setString("fiscalMonth",fiscalMonth);

                LOGGER.info("reportType -->" + group);
                LOGGER.info("fiscalYear -->" + fiscalYear);
                LOGGER.info("fiscalMonth -->" + fiscalMonth);

                return (List<GeneratedReport>) query.list();
            }
        });
    }
}
