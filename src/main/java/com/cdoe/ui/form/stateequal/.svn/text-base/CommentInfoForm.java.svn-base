
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.stateequal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cdoe.ui.form.grid.CommentInfoGrid;

/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class CommentInfoForm {
	
	private List<CommentInfoGrid> commentInfoGrid = new ArrayList<CommentInfoGrid>();

	private long id;
	private String districtCode;
	private String districtName;
	private String fiscalYear;
	private String fiscalMonth;
	
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	
	public String getFiscalMonth() {
		return fiscalMonth;
	}
	public void setFiscalMonth(String fiscalMonth) {
		this.fiscalMonth = fiscalMonth;
	}
	
	
	private Date enteredDate;
	
	public Date getEnteredDate () {
        return this.enteredDate;
    }

    public void setEnteredDate (Date enteredDate) {
        this.enteredDate = enteredDate;
    }
	private String enteredBy;
	
	public String getEnteredBy () {
        return this.enteredBy;
    }

    public void setEnteredBy (String enteredBy) {
        this.enteredBy = enteredBy;
    }
	private String active;
	
	public String getActive () {
        return this.active;
    }

    public void setActive (String active) {
        this.active = active;
    }
	private String note;
	
	public String getNote () {
        return this.note;
    }

    public void setNote (String note) {
        this.note = note;
    }
    
    public List<CommentInfoGrid> getCommentInfoGrid() {
		return commentInfoGrid;
	}

	public void setCommentInfoGrid(List<CommentInfoGrid> commentInfoGrid) {
		this.commentInfoGrid = commentInfoGrid;
	}
	
	private List<String> districtCodeList = new ArrayList<String>();

	public List<String> getDistrictCodeList() {
		return this.districtCodeList;
	}
	
	
	private List<String> fiscalYearList = new ArrayList<String>();

	public List<String> getFiscalYearList() {
		return this.fiscalYearList;
	}
	
	private List<String> fiscalMonthList = new ArrayList<String>();

	public List<String> getFiscalMonthList() {
		return this.fiscalMonthList;
	}
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}