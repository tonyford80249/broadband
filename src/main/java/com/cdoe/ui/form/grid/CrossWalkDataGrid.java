package com.cdoe.ui.form.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrossWalkDataGrid {
	
	private List<String> columnHeaders;
	private Map<String, List<Double>> rowDoubleGrid = new  HashMap<String, List<Double>>();
	private Map<String, List<String>> rowStringGrid = new  HashMap<String, List<String>>();
	
	

	public CrossWalkDataGrid() {
		super();
	}
	
	public List<String> getColumnHeaders() {
		return columnHeaders;
	}
	
	public void setColumnHeaders(List<String> columnHeaders) {
		this.columnHeaders = columnHeaders;
	}
	
	public Map<String, List<Double>> getRowDoubleGrid() {
		return rowDoubleGrid;
	}
	
	
	public Map<String, List<String>> getRowStringGrid() {
		return rowStringGrid;
	}

	
	
}
