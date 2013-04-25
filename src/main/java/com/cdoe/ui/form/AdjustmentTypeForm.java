
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AdjustmentTypeForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private Long adjustmentId;
	
	public Long getAdjustmentId () {
        return this.adjustmentId;
    }

    public void setAdjustmentId (Long adjustmentId) {
        this.adjustmentId = adjustmentId;
    }
	private String adjustmentType;
	
	public String getAdjustmentType () {
        return this.adjustmentType;
    }

    public void setAdjustmentType (String adjustmentType) {
        this.adjustmentType = adjustmentType;
    }
}