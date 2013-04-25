
package com.cdoe.services.stateequal;


import org.springframework.web.multipart.MultipartFile;

import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.stateequal.ElectionForm;

public interface IElectionsManager extends IBaseManager {

	void saveOrUpdate(ElectionForm electionsDetailForm);
	
	ElectionForm setupForm();
	
	ElectionForm setupForm(long id);
	
	public ElectionForm setupForm(String districtNos,  String fiscalYear);

	boolean uploadBallot(MultipartFile file, String districtNos,  String fiscalYear);

}
