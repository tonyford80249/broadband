
package com.cdoe.services.impl.stateequal;

import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.biz.model.equal.CommentInfo;
import com.cdoe.biz.stateequal.ICommentsDAO;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.ICommentsManager;
import com.cdoe.ui.form.grid.CommentInfoGrid;
import com.cdoe.ui.form.stateequal.CommentInfoForm;

public class CommentsManager extends BaseManager implements ICommentsManager {

	private static final Logger logger = Logger.getLogger(CommentsManager.class);
	
	private ICommentsDAO commentsDAO;
	
	public void saveOrUpdate(CommentInfoForm form) {
		long id = form.getId();
		CommentInfo obj = findById(CommentInfo.class, id); 
		if (obj == null) {
			obj = new CommentInfo();
		}
		//Notes data 
		obj.setEnteredDate(form.getEnteredDate());
		obj.setEnteredBy(form.getEnteredBy());
		obj.setActive(form.getActive());
		obj.setNote(form.getNote());
		obj.setDistrictNumber(form.getDistrictCode());
		obj.setFiscalYear(form.getFiscalYear());
		obj.setFiscalMonth(form.getFiscalMonth ());
		saveOrUpdate(obj);
	}
	
	public CommentInfoForm setupForm() {
		CommentInfoForm form = new CommentInfoForm();
		List<CommentInfo> commentInfoList = findAll(CommentInfo.class);
		List<CommentInfoGrid> commentInfoGridList  = form.getCommentInfoGrid();
		for(CommentInfo commentInfo:commentInfoList) {
			CommentInfoGrid commentInfoGrid = new CommentInfoGrid();
			commentInfoGrid.setNoteId(commentInfo.getId());
			commentInfoGrid.setEnteredDate(commentInfo.getEnteredDate());
			commentInfoGrid.setEnteredBy(commentInfo.getEnteredBy());
			commentInfoGrid.setNote(commentInfo.getNote());
			commentInfoGrid.setDistrictCode(commentInfo.getDistrictNumber());
			commentInfoGrid.setFiscalYear(commentInfo.getFiscalYear());
			commentInfoGrid.setFiscalMonth(commentInfo.getFiscalMonth());
			commentInfoGridList.add(commentInfoGrid);
		}
		return form;
	}
	
	public CommentInfoForm setupForm(long id) {
		CommentInfo obj = findById(CommentInfo.class, id); 
		
		CommentInfoForm form = new CommentInfoForm();
		form.setId(obj.getId());
		form.setEnteredDate(obj.getEnteredDate());
		form.setEnteredBy(obj.getEnteredBy());
		form.setActive(obj.getActive());
		form.setNote(obj.getNote());
		return form; 
	}
	
	public void setCommentsDAO(ICommentsDAO commentsDAO) {
		this.commentsDAO = commentsDAO;
	}
	
}
