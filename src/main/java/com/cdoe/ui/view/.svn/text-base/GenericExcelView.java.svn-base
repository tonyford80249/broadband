package com.cdoe.ui.view;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 *
 * @author Tony Ford
 */
public class GenericExcelView extends AbstractExcelView{
    private String reportName;
    
    
    public GenericExcelView() {
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hssfw, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
         hsr1.setHeader("Content-Disposition", "attachment; filename=\"" + reportName +".xls\"");  
       //HSSFFormulaEvaluator.evaluateAllFormulaCells(hssfw);
    }
    
}
