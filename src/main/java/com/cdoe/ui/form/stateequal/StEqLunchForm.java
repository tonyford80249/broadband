
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.stateequal;

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
public class StEqLunchForm {

	private long id;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private String districtNumber;
	
	public String getDistrictNumber () {
        return this.districtNumber;
    }

    public void setDistrictNumber (String districtNumber) {
        this.districtNumber = districtNumber;
    }
	private String dateChange;
	
	public String getDateChange () {
        return this.dateChange;
    }

    public void setDateChange (String dateChange) {
        this.dateChange = dateChange;
    }
	private String changeType;
	
	public String getChangeType () {
        return this.changeType;
    }

    public void setChangeType (String changeType) {
        this.changeType = changeType;
    }
	private Long preFLunch;
	
	public Long getPreFLunch () {
        return this.preFLunch;
    }

    public void setPreFLunch (Long preFLunch) {
        this.preFLunch = preFLunch;
    }
	private Long kindFLunch;
	
	public Long getKindFLunch () {
        return this.kindFLunch;
    }

    public void setKindFLunch (Long kindFLunch) {
        this.kindFLunch = kindFLunch;
    }
	private Long fullKFLunch;
	
	public Long getFullKFLunch () {
        return this.fullKFLunch;
    }

    public void setFullKFLunch (Long fullKFLunch) {
        this.fullKFLunch = fullKFLunch;
    }
	private Long fstFLunch;
	
	public Long getFstFLunch () {
        return this.fstFLunch;
    }

    public void setFstFLunch (Long fstFLunch) {
        this.fstFLunch = fstFLunch;
    }
	private Long secFLunch;
	
	public Long getSecFLunch () {
        return this.secFLunch;
    }

    public void setSecFLunch (Long secFLunch) {
        this.secFLunch = secFLunch;
    }
	private Long thdFLunch;
	
	public Long getThdFLunch () {
        return this.thdFLunch;
    }

    public void setThdFLunch (Long thdFLunch) {
        this.thdFLunch = thdFLunch;
    }
	private Long frthFLunch;
	
	public Long getFrthFLunch () {
        return this.frthFLunch;
    }

    public void setFrthFLunch (Long frthFLunch) {
        this.frthFLunch = frthFLunch;
    }
	private Long ffthFLunch;
	
	public Long getFfthFLunch () {
        return this.ffthFLunch;
    }

    public void setFfthFLunch (Long ffthFLunch) {
        this.ffthFLunch = ffthFLunch;
    }
	private Long sixFLunch;
	
	public Long getSixFLunch () {
        return this.sixFLunch;
    }

    public void setSixFLunch (Long sixFLunch) {
        this.sixFLunch = sixFLunch;
    }
	private Long svnFLunch;
	
	public Long getSvnFLunch () {
        return this.svnFLunch;
    }

    public void setSvnFLunch (Long svnFLunch) {
        this.svnFLunch = svnFLunch;
    }
	private Long eghtFLunch;
	
	public Long getEghtFLunch () {
        return this.eghtFLunch;
    }

    public void setEghtFLunch (Long eghtFLunch) {
        this.eghtFLunch = eghtFLunch;
    }
	private Long nthFLunch;
	
	public Long getNthFLunch () {
        return this.nthFLunch;
    }

    public void setNthFLunch (Long nthFLunch) {
        this.nthFLunch = nthFLunch;
    }
	private Long tenFLunch;
	
	public Long getTenFLunch () {
        return this.tenFLunch;
    }

    public void setTenFLunch (Long tenFLunch) {
        this.tenFLunch = tenFLunch;
    }
	private Long elvnFLunch;
	
	public Long getElvnFLunch () {
        return this.elvnFLunch;
    }

    public void setElvnFLunch (Long elvnFLunch) {
        this.elvnFLunch = elvnFLunch;
    }
	private Long twthFLunch;
	
	public Long getTwthFLunch () {
        return this.twthFLunch;
    }

    public void setTwthFLunch (Long twthFLunch) {
        this.twthFLunch = twthFLunch;
    }
	private Long sp712FLunch;
	
	public Long getSp712FLunch () {
        return this.sp712FLunch;
    }

    public void setSp712FLunch (Long sp712FLunch) {
        this.sp712FLunch = sp712FLunch;
    }
	private Long unFLunch;
	
	public Long getUnFLunch () {
        return this.unFLunch;
    }

    public void setUnFLunch (Long unFLunch) {
        this.unFLunch = unFLunch;
    }
	private Long totFLunch;
	
	public Long getTotFLunch () {
        return this.totFLunch;
    }

    public void setTotFLunch (Long totFLunch) {
        this.totFLunch = totFLunch;
    }
	private Long spK6FLunch;
	
	public Long getSpK6FLunch () {
        return this.spK6FLunch;
    }

    public void setSpK6FLunch (Long spK6FLunch) {
        this.spK6FLunch = spK6FLunch;
    }
	private String fiscalYear;
	
	public String getFiscalYear () {
        return this.fiscalYear;
    }

    public void setFiscalYear (String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
}