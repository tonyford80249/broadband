
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Java bean object serves as a data container to hold values for the DataGrid.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class CommentInfoGrid {
	
	private Date enteredDate;
	private String enteredBy;
	private String active;
	private String note;
	private long noteId;
	private String districtCode;
	private String districtName;
	private String fiscalYear;
	private String fiscalMonth;
	
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

	public long getNoteId() {
		return noteId;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public Date getEnteredDate () {
        return this.enteredDate;
    }

    public void setEnteredDate (Date enteredDate) {
        this.enteredDate = enteredDate;
    }
	
	
	public String getEnteredBy () {
        return this.enteredBy;
    }

    public void setEnteredBy (String enteredBy) {
        this.enteredBy = enteredBy;
    }
	
	
	public String getActive () {
        return this.active;
    }

    public void setActive (String active) {
        this.active = active;
    }
	
	
	public String getNote () {
        return this.note;
    }

    public void setNote (String note) {
        this.note = note;
    }
}