package com.cdoe.excel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

//import jxl.CellView;
//import jxl.Workbook;
//import jxl.WorkbookSettings;
//import jxl.format.UnderlineStyle;
//import jxl.write.Formula;
//import jxl.write.Label;
//import jxl.write.Number;
//import jxl.write.WritableCellFormat;
//import jxl.write.WritableFont;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import jxl.write.biff.RowsExceededException;

import com.cdoe.ui.form.grid.ProrateTransportationGrid;
import com.cdoe.ui.form.transportation.ProrateForm;


public class DistrictPaymentExcel {

//  private WritableCellFormat timesBoldUnderline;
//  private WritableCellFormat times;
//  private String inputFile;
  
public void setOutputFile(String inputFile) {
  //this.inputFile = inputFile;
  }

//  public void write(ProrateForm form ) throws IOException, WriteException {
//    File file = new File(inputFile);
//    WorkbookSettings wbSettings = new WorkbookSettings();
//
//    wbSettings.setLocale(new Locale("en", "EN"));
//
//    WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
//    workbook.createSheet("Report", 0);
//    WritableSheet excelSheet = workbook.getSheet(0);
//    createLabel(excelSheet);
//    createContent(excelSheet, form);
//
//    workbook.write();
//    workbook.close();
//  }
//
//  private void createLabel(WritableSheet sheet)
//      throws WriteException {
//    // Lets create a times font
//    WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
//    // Define the cell format
//    times = new WritableCellFormat(times10pt);
//    // Lets automatically wrap the cells
//    times.setWrap(true);
//
//    // Create  a bold font with underlines
//    WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
//        UnderlineStyle.SINGLE);
//    timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
//    // Lets automatically wrap the cells
//    timesBoldUnderline.setWrap(true);
//
//    CellView cv = new CellView();
//    cv.setFormat(times);
//    cv.setFormat(timesBoldUnderline);
//    //cv.setsetAutosize(true);
//
//    // Write a few headers
//    addCaption(sheet, 0, 0, "DistrictPaymentReport");
//    addCaption(sheet, 1, 0, "For the Fiscal Year 2011-2012");
//    addCaption(sheet, 0, 1, "District Number");
//    addCaption(sheet, 1, 1, "District Name");
//    addCaption(sheet, 2, 1, "First Payment");
//    addCaption(sheet, 3, 1, "Second Payment");
//    addCaption(sheet, 4, 1, "Total Distribution");
//    
//
//  }
//
//  private void createContent(WritableSheet sheet, ProrateForm form ) throws WriteException,
//      RowsExceededException {
//	  
//	  List<ProrateTransportationGrid>  infoGridList = form.getProrateTransportationGridList();
//    // Write a few number
//    for (int i = 2; i < infoGridList.size(); i++) {
//    	ProrateTransportationGrid prorateTransGrid =  infoGridList.get(i - 1);
//    	prorateTransGrid.getDistrictNumber();
//      // First column
//      addLabel(sheet, 0, i, prorateTransGrid.getDistrictNumber());
//      // Second column
//      addLabel(sheet, 1, i,prorateTransGrid.getOrganizationName());
//      addNumber(sheet, 2, i,prorateTransGrid.getFirstPayment().intValue());
//      addNumber(sheet, 3, i,prorateTransGrid.getSecondPayment().intValue());
//      int disSum = prorateTransGrid.getFirstPayment().intValue() + prorateTransGrid.getSecondPayment().intValue();
//      addNumber(sheet, 4,i, disSum);
//    }
//    // Lets calculate the sum of it
//    StringBuffer buf = new StringBuffer();
//    buf.append("SUM(A2:A10)");
//    Formula f = new Formula(0, 10, buf.toString());
//    sheet.addCell(f);
//    buf = new StringBuffer();
//    buf.append("SUM(B2:B10)");
//    f = new Formula(1, 10, buf.toString());
//    sheet.addCell(f);
//    
//  }
//
//  private void addCaption(WritableSheet sheet, int column, int row, String s)
//      throws RowsExceededException, WriteException {
//    Label label;
//    label = new Label(column, row, s, timesBoldUnderline);
//    sheet.addCell(label);
//  }
//
//  private void addNumber(WritableSheet sheet, int column, int row,
//      Integer integer) throws WriteException, RowsExceededException {
//    Number number;
//    number = new Number(column, row, integer, times);
//    sheet.addCell(number);
//  }
//  
// 
//  private void addLabel(WritableSheet sheet, int column, int row, String s)
//      throws WriteException, RowsExceededException {
//    Label label;
//    label = new Label(column, row, s, times);
//    sheet.addCell(label);
//  }
//
//  public static void main(String[] args) throws WriteException, IOException {
//	ProrateForm form = new ProrateForm();
//	List<ProrateTransportationGrid>  infoGridList = form.getProrateTransportationGridList();
//	
//	for (int j=0; j < 10; j++) {
//		ProrateTransportationGrid prorateData = new ProrateTransportationGrid();
//		prorateData.setDistrictNumber("1000" + (j + 1));
//		prorateData.setOrganizationName("Jefferson County");
//		prorateData.setFirstPayment((1000d + j));
//		prorateData.setSecondPayment((2000d + j));
//		prorateData.setDistrictDistribution(prorateData.getFirstPayment() +  prorateData.getSecondPayment());
//		infoGridList.add(prorateData);
//	}
//	
//    DistrictPaymentExcel test = new DistrictPaymentExcel();
//    test.setOutputFile("c:/temp/districtPayment.xls");
//    test.write(form);
//    System.out
//        .println("Please check the result file under c:/temp/lars.xls ");
//  }
} 
