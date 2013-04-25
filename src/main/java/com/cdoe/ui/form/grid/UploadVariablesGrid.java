package com.cdoe.ui.form.grid;

import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.NumberFormat;

public class UploadVariablesGrid {
	
	private List<String> columnHeaders;
	@NumberFormat(pattern="###,###,###.00")
	private Map<String, List<Double>> rowGrid;
	
	public UploadVariablesGrid() {
		super();
	}
	
	public List<String> getColumnHeaders() {
		return columnHeaders;
	}
	
	public void setColumnHeaders(List<String> columnHeaders) {
		this.columnHeaders = columnHeaders;
	}
	
	public Map<String, List<Double>> getRowGrid() {
		return rowGrid;
	}
	
	public void setRowGrid(Map<String, List<Double>> rowGrid) {
		this.rowGrid = rowGrid;
	}
	
}
