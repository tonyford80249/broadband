
package com.cdoe.services.impl.stateequal;

import org.apache.log4j.Logger;

import com.cdoe.biz.model.equal.HelpInfo;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.IHelpManager;
import com.cdoe.ui.form.stateequal.HelpForm;

public class HelpManager extends BaseManager implements IHelpManager {

	private static final Logger logger = Logger.getLogger(HelpManager.class);
	
	public void saveOrUpdate(HelpForm form) {
		long id = form.getId();
		HelpInfo obj = findById(HelpInfo.class, id); 
		if (obj == null) {
			obj = new HelpInfo();
		}
		//Notes data 
		obj.setEnteredDate(form.getEnteredDate());
		obj.setEnteredBy(form.getEnteredBy());
		obj.setActive(form.getActive());
		obj.setNote(form.getNote());
		saveOrUpdate(obj);
	}
	
	public HelpForm setupForm() {
		HelpForm form = new HelpForm();
		
		return form;
	}
	
	public HelpForm setupForm(long id) {
		//HelpInfo obj = findById(HelpInfo.class, id); 
		
		HelpForm form = new HelpForm();
		/*form.setId(obj.getId());
		form.setEnteredDate(obj.getEnteredDate());
		form.setEnteredBy(obj.getEnteredBy());
		form.setActive(obj.getActive());
		form.setNote(obj.getNote());*/
		return form; 
	}
	
	
}
