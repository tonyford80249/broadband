
package com.cdoe.services.stateequal;

import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.stateequal.HelpForm;

public interface IHelpManager extends IBaseManager {

	void saveOrUpdate(HelpForm helpInfoForm);
	
	HelpForm setupForm();
	
	HelpForm setupForm(long id);

}
