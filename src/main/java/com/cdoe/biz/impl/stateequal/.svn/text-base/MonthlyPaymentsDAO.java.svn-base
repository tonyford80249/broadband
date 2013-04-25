package com.cdoe.biz.impl.stateequal;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.db.hibernate.HibernateDAO;
import com.cdoe.biz.model.District;
import com.cdoe.biz.model.FiscalMonth;
import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.biz.stateequal.IMonthlyPaymentsDAO;

import java.sql.SQLException;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 *
 * @author Tony Ford
 */
public class MonthlyPaymentsDAO extends HibernateDAO implements IMonthlyPaymentsDAO {

    private static final Logger logger = Logger.getLogger(MonthlyPaymentsDAO.class);

    /**
     *
     */
    public MonthlyPaymentsDAO() {
    }

    /**
     *
     * @param districtNumber
     * @param fiscalYear
     * @return
     */
    public List<SeMonthly> findForDistirctByYear(final String districtNumber, final String fiscalYear) {
        return getHibernateTemplate().executeFind(new HibernateCallback<List<SeMonthly>>() {
            @Override
            public List<SeMonthly> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session.createQuery("from SeMonthly where fiscalYear = :fiscalYear and districtNumber = :districtNumber");
                query.setString("districtNumber", districtNumber);
                query.setString("fiscalYear", fiscalYear);
                logger.info("districtNos -->" + districtNumber);
                logger.info("fiscalYear val -->" + fiscalYear);
                return (List<SeMonthly>) query.list();
            }
        });
    }

    /**
     *
     * @param districtNumber
     * @param fiscalYear
     * @param month
     * @return
     */
    @Override
    public List<SeMonthly> findForDistrictByMonthAndYear(final String districtNumber, final String fiscalYear, final FiscalMonth month) {
        return getHibernateTemplate().executeFind(new HibernateCallback<List<SeMonthly>>() {
            @Override
            public List<SeMonthly> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session.createQuery("from SeMonthly where fiscalYear = :fiscalYear and districtNumber = :districtNumber and month <= :month");
                query.setString("districtNumber", districtNumber);
                query.setString("fiscalYear", fiscalYear);
                query.setString("month", String.valueOf(month.getValue()));
                logger.info("districtNos -->" + districtNumber);
                logger.info("fiscalYear val -->" + fiscalYear);
                logger.info("fiscalMonth val -->" + String.valueOf(month.getValue()));
                return (List<SeMonthly>) query.list();
            }
        });
    }
    
    
    /**
     *
     * @param districtNumber
     * @param fiscalYear
     * @param month
     * @return
     */
    @Override
    public List<SeMonthly> findByMonthAndYear(final String fiscalYear, final FiscalMonth month) {
        return getHibernateTemplate().executeFind(new HibernateCallback<List<SeMonthly>>() {
            @Override
            public List<SeMonthly> doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session.createQuery("from SeMonthly where fiscalYear = :fiscalYear and month = :month");               
                query.setString("fiscalYear", fiscalYear);
                query.setString("month", String.valueOf(month.getValue()));               
                logger.info("fiscalYear val -->" + fiscalYear);
                logger.info("fiscalMonth val -->" + String.valueOf(month.getValue()));
                return (List<SeMonthly>) query.list();
            }
        });
    }

    @Override
    public void saveOrUpdate(Object object) {
        if (object instanceof SeMonthly) {

            SeMonthly seMonthly = (SeMonthly) object;

            if (seMonthly.getId() != null) {
                SeMonthly seMonthlyEntity = super.findByPk(SeMonthly.class, seMonthly.getId());

                if (seMonthlyEntity != object && seMonthlyEntity != null) {
                    seMonthlyEntity.setAdjTotalProgram(seMonthly.getAdjTotalProgram());
                    seMonthlyEntity.setAssessedVal(seMonthly.getAssessedVal());
                    seMonthlyEntity.setAuditAdj(seMonthly.getAuditAdj());
                    seMonthlyEntity.setCatMlLevy(seMonthly.getCatMlLevy());
                    seMonthlyEntity.setChrtAdj(seMonthly.getChrtAdj());
                    seMonthlyEntity.setCsiAdminAdj(seMonthly.getCsiAdminAdj());
                    seMonthlyEntity.setDateChanged(new Date());
                    seMonthlyEntity.setDecActEntitle(seMonthly.getDecActEntitle());
                    seMonthlyEntity.setEntitle(seMonthly.getEntitle());
                    seMonthlyEntity.setFpc(seMonthly.getFpc());
                    seMonthlyEntity.setJunActEntitle(seMonthly.getJunActEntitle());
                    seMonthlyEntity.setLunch18(seMonthly.getLunch18());
                    seMonthlyEntity.setMillLevy(seMonthly.getMillLevy());
                    seMonthlyEntity.setOCdeAdj(seMonthlyEntity.getOCdeAdj());
                    seMonthlyEntity.setOodsAdj(seMonthlyEntity.getOodsAdj());
                    seMonthlyEntity.setOtherAdj(seMonthlyEntity.getOtherAdj());
                    seMonthlyEntity.setPayment(seMonthlyEntity.getPayment());
                    seMonthlyEntity.setPropertyTax(seMonthlyEntity.getPropertyTax());
                    seMonthlyEntity.setSpecOwnTax(seMonthlyEntity.getSpecOwnTax());
                    seMonthlyEntity.setStateAssess(seMonthlyEntity.getStateAssess());
                    seMonthlyEntity.setStateEqual(seMonthlyEntity.getStateEqual());
                    seMonthlyEntity.setSwapAdj(seMonthlyEntity.getSwapAdj());
                    seMonthlyEntity.setTotFundGt3(seMonthlyEntity.getTotFundGt3());
                    seMonthlyEntity.setTotFundTp3(seMonthlyEntity.getTotFundTp3());
                    seMonthlyEntity.setTotalAtRiskPupils(seMonthlyEntity.getTotalAtRiskPupils());
                    seMonthlyEntity.setTotalCats(seMonthlyEntity.getTotalCats());
                    seMonthlyEntity.setVariance1(seMonthlyEntity.getVariance1());
                    seMonthlyEntity.setVariance2(seMonthlyEntity.getVariance2());
                    seMonthlyEntity.setVariance3(seMonthlyEntity.getVariance3());
                    seMonthlyEntity.setlunchK12(seMonthlyEntity.getlunchK12());
                }
                else if (seMonthlyEntity == null) {
                 seMonthlyEntity = (SeMonthly) object;   
                }

                super.saveOrUpdate(seMonthlyEntity);
            } else {
                List<SeMonthly>  seMonthlyEntityList = findForDistrictByMonthAndYear(seMonthly.getDistrictNumber(), seMonthly.getFiscalYear(), FiscalMonth.getInstance(seMonthly.getMonth()));
              
                SeMonthly seMonthlyEntity = seMonthlyEntityList != null && !seMonthlyEntityList.isEmpty() ? seMonthlyEntityList.iterator().next() : null;

                if (seMonthlyEntity != object && seMonthlyEntity != null) {
                    seMonthlyEntity.setAdjTotalProgram(seMonthly.getAdjTotalProgram());
                    seMonthlyEntity.setAssessedVal(seMonthly.getAssessedVal());
                    seMonthlyEntity.setAuditAdj(seMonthly.getAuditAdj());
                    seMonthlyEntity.setCatMlLevy(seMonthly.getCatMlLevy());
                    seMonthlyEntity.setChrtAdj(seMonthly.getChrtAdj());
                    seMonthlyEntity.setCsiAdminAdj(seMonthly.getCsiAdminAdj());
                    seMonthlyEntity.setDateChanged(new Date());
                    seMonthlyEntity.setDecActEntitle(seMonthly.getDecActEntitle());
                    seMonthlyEntity.setEntitle(seMonthly.getEntitle());
                    seMonthlyEntity.setFpc(seMonthly.getFpc());
                    seMonthlyEntity.setJunActEntitle(seMonthly.getJunActEntitle());
                    seMonthlyEntity.setLunch18(seMonthly.getLunch18());
                    seMonthlyEntity.setMillLevy(seMonthly.getMillLevy());
                    seMonthlyEntity.setOCdeAdj(seMonthlyEntity.getOCdeAdj());
                    seMonthlyEntity.setOodsAdj(seMonthlyEntity.getOodsAdj());
                    seMonthlyEntity.setOtherAdj(seMonthlyEntity.getOtherAdj());
                    seMonthlyEntity.setPayment(seMonthlyEntity.getPayment());
                    seMonthlyEntity.setPropertyTax(seMonthlyEntity.getPropertyTax());
                    seMonthlyEntity.setSpecOwnTax(seMonthlyEntity.getSpecOwnTax());
                    seMonthlyEntity.setStateAssess(seMonthlyEntity.getStateAssess());
                    seMonthlyEntity.setStateEqual(seMonthlyEntity.getStateEqual());
                    seMonthlyEntity.setSwapAdj(seMonthlyEntity.getSwapAdj());
                    seMonthlyEntity.setTotFundGt3(seMonthlyEntity.getTotFundGt3());
                    seMonthlyEntity.setTotFundTp3(seMonthlyEntity.getTotFundTp3());
                    seMonthlyEntity.setTotalAtRiskPupils(seMonthlyEntity.getTotalAtRiskPupils());
                    seMonthlyEntity.setTotalCats(seMonthlyEntity.getTotalCats());
                    seMonthlyEntity.setVariance1(seMonthlyEntity.getVariance1());
                    seMonthlyEntity.setVariance2(seMonthlyEntity.getVariance2());
                    seMonthlyEntity.setVariance3(seMonthlyEntity.getVariance3());
                    seMonthlyEntity.setlunchK12(seMonthlyEntity.getlunchK12());
                }
                else if (seMonthlyEntity == null) {
                 seMonthlyEntity = (SeMonthly) object;   
                }
                 

                super.saveOrUpdate(seMonthlyEntity);   
            }
            
            

        }
    }
}
