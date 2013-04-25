
package com.cdoe.services.stateequal;



import com.cdoe.biz.model.jasper.SeMillLevyCertificationDatasource;
import com.cdoe.ui.form.stateequal.MillLevyForm;
import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.util.FilenameConstructor;
import java.util.Map;

/**
 * 
 * @author Tony Ford
 */
public interface IMillLevyCertManager extends IBaseManager {

        /**
         * 
         * @param vDataForm 
         */
	void saveOrUpdate(MillLevyForm vDataForm);
	
        /**
         * 
         * @return 
         */
	MillLevyForm setupForm();
	
        /**
         * 
         * @param id
         * @return 
         */
	MillLevyForm setupForm(long id);
        
        /**
         * 
         * @param districtNumber
         * @param districtName
         * @param fiscalYear
         * @return 
         */
        MillLevyForm setupForm(String districtNumber, String districtName, String primaryCounty, String fiscalYear);
        
        
        /**
         * 
         * @param districtMap 
         */
         public void saveSpawnData(Map<String,String> districtMap);
         
         /**
          * 
          * @param form 
          */
         public void performCalculations(MillLevyForm form);
         
         /**
          * 
          * @return 
          */
         public FilenameConstructor createFilenameConstructor();
         
         /**
          * 
          * @param form
          * @return 
          */
         public SeMillLevyCertificationDatasource createDataSource(MillLevyForm form);

}
