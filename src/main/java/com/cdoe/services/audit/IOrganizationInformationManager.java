
package com.cdoe.services.audit;

import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.audit.OrganizationForm;

/**
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 * @version $Revision: $
 */

public interface IOrganizationInformationManager extends IBaseManager {

	void saveOrUpdate(OrganizationForm organizationForm);
	
	OrganizationForm setupForm();
	
	OrganizationForm setupForm(long id);

}
