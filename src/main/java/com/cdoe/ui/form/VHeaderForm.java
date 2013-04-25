
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
public class VHeaderForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private String vDate;
	
	public String getVDate () {
        return this.vDate;
    }

    public void setVDate (String vDate) {
        this.vDate = vDate;
    }
	private String vUsername;
	
	public String getVUsername () {
        return this.vUsername;
    }

    public void setVUsername (String vUsername) {
        this.vUsername = vUsername;
    }
    
    private String password;
	
	public String getPassword () {
        return this.password;
    }

    public void setPassword (String password) {
        this.password = password;
    }
}