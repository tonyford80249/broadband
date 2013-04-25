
package com.cdoe.services.stateequal;

import com.cdoe.biz.model.equal.CommentInfo;
import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.ui.form.stateequal.CommentInfoForm;

public interface ICommentsManager extends IBaseManager {

	void saveOrUpdate(CommentInfoForm commentInfoForm);
	
	CommentInfoForm setupForm();
	
	CommentInfoForm setupForm(long id);

}
