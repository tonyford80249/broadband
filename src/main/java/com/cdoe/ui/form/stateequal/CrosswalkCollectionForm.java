package com.cdoe.ui.form.stateequal;

import com.cdoe.ui.form.grid.CrossWalkDataGrid;


public class CrosswalkCollectionForm {
	
	private String fiscalYear;
	private String collectionType;
	private String message;
	private CrossWalkDataGrid crossWalkDataGrid;
   
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}
	
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	
	
	
	public String getCollectionType() {
		return collectionType;
	}
	
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}
	

	public CrossWalkDataGrid getCrossWalkDataGrid() {
		return crossWalkDataGrid;
	}

	public void setCrossWalkDataGrid(CrossWalkDataGrid crossWalkDataGrid) {
		this.crossWalkDataGrid = crossWalkDataGrid;
	}

}
