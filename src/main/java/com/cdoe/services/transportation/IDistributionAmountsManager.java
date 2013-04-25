
package com.cdoe.services.transportation;

import com.cdoe.ui.form.transportation.ProrateForm;

public interface IDistributionAmountsManager extends IBaseManager {

	void saveOrUpdate(ProrateForm prorateForm);
	
	ProrateForm setupForm();
	
	ProrateForm setupForm(long id);

	ProrateForm setupForm(String fiscalYear);

	void runFirstPayment(ProrateForm prorateForm);

	void runSecondPayment(ProrateForm prorateForm);

	void updateProrateNote(ProrateForm prorateForm);

}
