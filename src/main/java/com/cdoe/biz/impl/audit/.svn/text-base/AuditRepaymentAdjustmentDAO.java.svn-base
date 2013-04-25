/**
 * 
 */
package com.cdoe.biz.impl.audit;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cdoe.biz.IAuditRepaymentAdjustmentDAO;
import com.cdoe.biz.model.AuditRepaymentAdjustment;
import com.cdoe.db.hibernate.HibernateDAO;

/**
 * @author dyn-8
 *
 */
public class AuditRepaymentAdjustmentDAO extends HibernateDAO implements
		IAuditRepaymentAdjustmentDAO {

	@Override 
	public AuditRepaymentAdjustment findByUniqueKey(
			AuditRepaymentAdjustment model) {
		Session session = getCurrentSession();
		Query query = session.createQuery("from AuditRepaymentAdjustment where districtNumber = :districtNumber " +
				"and beginFiscalMonth = :beginFiscalMonth and endFiscalMonth = :endFiscalMonth and beginFiscalYear = :beginFiscalYear " +
				"and endFiscalYear = :endFiscalYear");
		query.setString("districtNumber", model.getDistrictNumber());
		query.setString("beginFiscalMonth", model.getBeginFiscalMonth());
		query.setString("endFiscalMonth", model.getEndFiscalMonth());
		query.setString("beginFiscalYear", model.getBeginFiscalYear());
		query.setString("endFiscalYear", model.getEndFiscalYear());
		
		return (AuditRepaymentAdjustment) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuditRepaymentAdjustment> findByDistrictAndFiscalYear(
			String districtNum, String fiscalMonth, String fiscalYear) {
		Session session = getCurrentSession();
		Query query = session.createQuery("from AuditRepaymentAdjustment where districtNumber = :districtNumber " +
				"and (beginFiscalMonth = :beginFiscalMonth or endFiscalMonth = :endFiscalMonth) and (beginFiscalYear = :beginFiscalYear " +
				"or endFiscalYear = :endFiscalYear)");
		query.setString("districtNumber", districtNum);
		query.setString("beginFiscalMonth", fiscalMonth);
		query.setString("endFiscalMonth", fiscalMonth);
		query.setString("beginFiscalYear", fiscalYear);
		query.setString("endFiscalYear", fiscalYear);
		return query.list();
	}
	
	@Override 
	public double AuditAdjustmentForMonth(String districtNum, String fiscalMonth, String fiscalYear ) {
		double adjustmentAmount = 0.0;
		Session session = getCurrentSession();
		Query query = session.createQuery("Select amount from AuditRepaymentAdjustment a " + 
		                                         " where districtNumber = :districtNumber " +
				                                
		                                         " and ((beginFiscalYear <= :beginFiscalYear " +
				                                 "       and endFiscalYear >= :endFiscalYear))" +
		                                         " or  (beginFiscalYear == :beginFiscalYear" +
		                                         "      and beginFiscalMonth <= :beginFiscalYear)" );
		query.setString("districtNumber", districtNum);
		query.setString("beginFiscalMonth", fiscalMonth);
		query.setString("endFiscalMonth", fiscalMonth);
		query.setString("beginFiscalYear", fiscalYear);
		query.setString("endFiscalYear", fiscalYear);
		query.list();
		List<AuditRepaymentAdjustment> adjustmentList = query.list();

		if (adjustmentList != null && adjustmentList.size() > 0) {
			adjustmentAmount = adjustmentList.get(0).getAmount();

		}
		return adjustmentAmount;
	}

} 
