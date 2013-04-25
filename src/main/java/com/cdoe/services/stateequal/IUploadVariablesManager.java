
package com.cdoe.services.stateequal;

import org.springframework.web.multipart.MultipartFile;

import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.grid.UploadVariablesGrid;
import com.cdoe.ui.form.stateequal.SaveVariableForm;
import com.cdoe.ui.form.stateequal.UploadVariablesForm;

public interface IUploadVariablesManager extends IBaseManager {

	public UploadVariablesForm setupUploadVariablesForm();
	
	public UploadVariablesGrid processFile(MultipartFile file);
	
	public void saveUploadVariablesGrid(UploadVariablesGrid grid, String fiscalYear);
	
	public void saveSingleVariableForm(SaveVariableForm form);

}
