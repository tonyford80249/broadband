
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.cdoe.ui.form.grid.*;

/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class VariableForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private String name;
	
	public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }
	private String value;
	
	public String getValue () {
        return this.value;
    }

    public void setValue (String value) {
        this.value = value;
    }
	private String active;
	
	public String getActive () {
        return this.active;
    }

    public void setActive (String active) {
        this.active = active;
    }
	private String year;
	
	public String getYear () {
        return this.year;
    }

    public void setYear (String year) {
        this.year = year;
    }
}