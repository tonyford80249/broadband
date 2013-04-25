
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.form.stateequal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cdoe.ui.form.grid.ElectionItemGrid;

/**
 * Java bean object representing a business entity which will be used by Spring Form
 * to pass data to and from the view, controller, and service layer.
 * 
 * @author ResQSoft, Inc. (ResQSoft Engineer)
 */
public class ElectionForm {

	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	private String districtCode;
	private String districtName;
	

	private String fiscalYear;
	private String electionHeld;
	private MultipartFile file;
	private String typeOfOtherElection;
	private int size;
	private String ballotUploaded;
	
	

	public String getBallotUploaded() {
		return ballotUploaded;
	}

	public void setBallotUploaded(String ballotUploaded) {
		this.ballotUploaded = ballotUploaded;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getElectionHeld() {
		return electionHeld;
	}

	public void setElectionHeld(String electionHeld) {
		this.electionHeld = electionHeld;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}


	private List<ElectionItemGrid> electionItemGridList;
	

	public List<ElectionItemGrid> getElectionItemGridList() {
		
		return electionItemGridList;
	}

	public void setElectionItemGridList(List<ElectionItemGrid> electionItemGridList) {
		this.electionItemGridList = electionItemGridList;
	}

	
	public String getDistrictCode () {
        return this.districtCode;
    }

    public void setDistrictCode (String districtCode) {
        this.districtCode = districtCode;
    }
    
    public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	
    private List<String> districtCodeList = new ArrayList<String>();

	public List<String> getDistrictCodeList() {
		return this.districtCodeList;
	}
	
	public void setDistrictCodeList(List<String> districtCodeList) {
		this.districtCodeList = districtCodeList;
	}

	public String getTypeOfOtherElection() {
		return typeOfOtherElection;
	}

	public void setTypeOfOtherElection(String typeOfOtherElection) {
		this.typeOfOtherElection = typeOfOtherElection;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
}