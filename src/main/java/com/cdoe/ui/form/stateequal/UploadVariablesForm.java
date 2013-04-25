/**
 * 
 */
package com.cdoe.ui.form.stateequal;

import org.springframework.web.multipart.MultipartFile;

import com.cdoe.ui.form.grid.UploadVariablesGrid;

/**
 * Form for uploading variables excel files for state equal
 * 
 * @author dyn-8
 *
 */
public class UploadVariablesForm {
	
	private String fiscalYear;
	private MultipartFile file;
	private UploadVariablesGrid uploadGrid;

	/**
	 * Default Constructor
	 */
	public UploadVariablesForm() {
		super();
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public UploadVariablesGrid getUploadGrid() {
		return uploadGrid;
	}

	public void setUploadGrid(UploadVariablesGrid uploadGrid) {
		this.uploadGrid = uploadGrid;
	}
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
