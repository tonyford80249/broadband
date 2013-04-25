
package com.cdoe.services.stateequal;


import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.grid.CrossWalkDataGrid;
import com.cdoe.ui.form.stateequal.CrosswalkCollectionForm;

public interface ICrosswalkCollectionDataManager extends IBaseManager {
	
	CrossWalkDataGrid viewCrosswalkData(CrosswalkCollectionForm crosswalkCollectionForm);
	
	String saveCrosswalkData(CrosswalkCollectionForm crosswalkCollectionForm);

	
	CrossWalkDataGrid viewCrosswalkData(String fiscalYear, String collectionType);
	
}
