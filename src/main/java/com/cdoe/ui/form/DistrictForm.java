
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class DistrictForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String code;
	
	public String getCode () {
        return this.code;
    }

    public void setCode (String code) {
        this.code = code;
    }
	private String name;
	
	public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }
	private String year;
	
	public String getYear () {
        return this.year;
    }

    public void setYear (String year) {
        this.year = year;
    }
	private List<String> codeList = new ArrayList<String>();
	
	public List<String> getCodeList() {
        return this.codeList;
    }
}