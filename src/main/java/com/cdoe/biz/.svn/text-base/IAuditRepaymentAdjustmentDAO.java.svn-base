package com.cdoe.biz;

import java.util.List;

import com.cdoe.biz.model.AuditRepaymentAdjustment;

public interface IAuditRepaymentAdjustmentDAO {
	public AuditRepaymentAdjustment findByUniqueKey(AuditRepaymentAdjustment model);
	public List<AuditRepaymentAdjustment> findByDistrictAndFiscalYear(String districtNum, String fiscalMonth, String fiscalYear);
	double AuditAdjustmentForMonth(String districtNum, String fiscalMonth,String fiscalYear);
}
