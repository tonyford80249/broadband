
package com.cdoe.services.stateequal;

import java.io.IOException;

//import jxl.write.WriteException;

import com.cdoe.biz.model.transportation.Prorate;
import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.transportation.ProrateForm;
import com.cdoe.util.UserInfo;

public interface IDistrictPaymentReportManager extends IBaseManager {

	void saveOrUpdate(ProrateForm prorateForm);
	
	ProrateForm setupForm(String fiscalYear, UserInfo userInfo);
	
	ProrateForm setupForm(long id);

	void createDistrictReport(String fileName, ProrateForm form)
			throws IOException;//, WriteException;

}
