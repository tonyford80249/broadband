package com.cdoe.ui.view;

import com.cdoe.biz.model.equal.StateEqual;

import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.FormulaEvaluator;
//import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 *
 * @author Ton Ford
 */
public class AltAtRiskCalcView extends AbstractExcelView {
    private static final Logger LOGGER = Logger.getLogger(AltAtRiskCalcView.class);
    
    
    public AltAtRiskCalcView() {
     setUrl("/WEB-INF/excel/adj_at_risk_funding");             
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hssfw, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
        hsr1.setHeader("Content-Disposition", "attachment; filename=\"altatriskfunding.xls\"");  
        
        StateEqual stateEqualInfo = (StateEqual) map.get("stateEqualData");
        
        String districtName = (String) map.get("districtName");
        
        //FormulaEvaluator 
                                        
                //hssfw.get.getCreationHelper().createFormulaEvaluator();
        HSSFSheet sheet = hssfw.getSheetAt(0);

        System.out.println("sheet name : " + hssfw.getSheetName(0));

        Iterator<Row> iter2 = sheet.iterator();
        while (iter2.hasNext()) {
            
            Row row = iter2.next();
            if (row == null) {
                break;
            }

            
            Iterator<Cell> iter = row.cellIterator();
            
            while (iter.hasNext()) {
                Cell cell  =  iter.next();
                
                try {
                if (cell == null) {
                    break;
                }

                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());

                int type = cell.getCellType();

                int x = row.getRowNum();
                int y = cell.getColumnIndex();

                String cellLocation =  stich(cellRef.formatAsString().split("[$]"));//cellRef.formatAsString().substring(1, 2) + cellRef.formatAsString().substring(3, 4);

                System.out.print(cellLocation + " ");

                /**
                 * update xcel spread sheet.
                 */
                if ("B2".equals(cellLocation) && stateEqualInfo.getDistrictNumber() != null) {
                    cell.setCellValue(stateEqualInfo.getDistrictNumber());
                } else if ("B3".equals(cellLocation) && districtName != null) {
                    cell.setCellValue(districtName);
                } else if ("B6".equals(cellLocation) && stateEqualInfo.getFundedPupilCount() != null) {
                    cell.setCellValue(stateEqualInfo.getFundedPupilCount());
                } else if ("B10".equals(cellLocation) && stateEqualInfo.getFormulaPupilFund() != null) {
                    cell.setCellValue(stateEqualInfo.getFormulaPupilFund());
                } else if ("B12".equals(cellLocation) && stateEqualInfo.getFundedAtRiskCount() != null) {
                    cell.setCellValue(stateEqualInfo.getFundedAtRiskCount());
                } else if ("B14".equals(cellLocation) && stateEqualInfo.getTotalAtRiskFunding() != null) {
                    cell.setCellValue(stateEqualInfo.getTotalAtRiskFunding());
                } else if ("B17".equals(cellLocation) && stateEqualInfo.getMemberK12() != null) {
                    cell.setCellValue(stateEqualInfo.getMemberK12());
                } else if ("B21".equals(cellLocation) && stateEqualInfo.getGrandTotalProgram() != null) {
                    cell.setCellValue(stateEqualInfo.getGrandTotalProgram());
                } else if ("B22".equals(cellLocation) && stateEqualInfo.getNegFactor() != null) {
                    cell.setCellValue(stateEqualInfo.getNegFactor());
                } else if ("B23".equals(cellLocation) && stateEqualInfo.getAdjDistrictTotalProgram() != null) {
                    cell.setCellValue(stateEqualInfo.getAdjDistrictTotalProgram());
                }

                //evaluator.evaluateFormulaCell(cell);

                //System.out.print("comment->" + cell.getCellComment() + " ");

                /**
                 * Display cell contents
                 */
                switch (type) {
                    case HSSFCell.CELL_TYPE_STRING:
                        System.out.println("row(" + x + ") " + "col(" + y + ")" + "type : STRING " + " value : " + cell.getStringCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN:
                        System.out.println("row(" + x + ") " + "col(" + y + ")" + "type : BOOLEAN " + " value : " + cell.getBooleanCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA:
                        System.out.println("row(" + x + ") " + "col(" + y + ")" + "type : FORMULA " + " value : " + " formula : " + cell.getCellFormula());
                        break;
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        System.out.println("row(" + x + ") " + "col(" + y + ")" + "type : NUMERIC " + " value : " + cell.getNumericCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_ERROR:
                        System.out.println("row(" + x + ") " + "col(" + y + ")" + "type : ERROR " + " value : " + cell.getErrorCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_BLANK:
                        System.out.println("row(" + x + ") " + "col(" + y + ")" + "type : BLANK ");
                }
                }
                catch(Throwable t) {
                  LOGGER.error("Error in XLS calculation...", t);  
                }

            }//end-while
        }//end-while
        
        HSSFFormulaEvaluator.evaluateAllFormulaCells(hssfw);
    }
    
    /**
     * 
     * @param tokens
     * @return 
     */
    private String stich(String[] tokens) { 
     String result = "";
     
     if(tokens == null || tokens.length == 0) {
      return result;   
     }   
     
     for (String token : tokens) {
      result += token;   
     }
     
     return result;
    }
    
}
