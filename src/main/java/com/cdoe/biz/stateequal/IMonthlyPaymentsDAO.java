
package com.cdoe.biz.stateequal;

import java.util.List;

import com.cdoe.biz.model.District;
import com.cdoe.biz.model.FiscalMonth;
import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.db.hibernate.IHibernateDAO;

/**
 * 
 * @author Tony Ford
 */
public interface IMonthlyPaymentsDAO extends IHibernateDAO{
  public abstract List<SeMonthly> findForDistirctByYear(final String districtNumber, final String fiscalYear); 
  public abstract List<SeMonthly> findForDistrictByMonthAndYear(final String districtNumber, final String fiscalYear, FiscalMonth month);
  public abstract List<SeMonthly> findByMonthAndYear(final String fiscalYear, final FiscalMonth month);
}
