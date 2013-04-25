/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdoe.services.impl.stateequal;

import com.cdoe.biz.IGeneratedReportDao;
import com.cdoe.biz.model.GeneratedReport;
import com.cdoe.services.impl.BaseManager;
import com.cdoe.util.CalendarMonth;
import com.cdoe.util.DateUtil;
import com.cdoe.util.FilenameConstructor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

/**
 *
 * @author Tony Ford
 */
public class ReportManagerBase extends BaseManager {
     /**
     *
     */
    private Resource StagingDirectoryForUpload;
    /**
     * Provide path for your JRXML template.
     */
    private Resource reportDefinitionFile;
    /**
     *
     */
    private String reportName;
    /**
     *
     */
    private String exportType;
    
    /**
     * 
     */
    private String baseURI;
    
    /**
     * 
     */
    private String reportGrouping;
    
    /**
     * 
     */
    private IGeneratedReportDao generatedReportDao;
    
     /**
     *
     */
    protected static final String SEPARATOR = "_";
    
    /**
     * 
     */
    //@Autowired
    //ServletContext servletContext;
    
    /**
     * 
     */
    public ReportManagerBase() {
    }

    
     /**
     * 
     * @return 
     */
    public String getDirectory(String fiscalYear, String fiscalMonth) throws IOException {
        //This logic allows us to place underneath the WEB-INF
        String extracedAbsolutePath = this.StagingDirectoryForUpload.getFile().getAbsolutePath();
        
        String targetDirectory = extracedAbsolutePath.substring(0, extracedAbsolutePath.length() - 10);
        
                
        String fullpath = targetDirectory + fiscalYear +  File.separator + fiscalMonth.toUpperCase() +  File.separator;
       
        File d1 = new File(fullpath);
        
        if (!d1.exists()) {
         d1.mkdirs();   
        }
        
        return fullpath;
    }
    
    /**
     * 
     * @return 
     */
    public String getDirectory() throws IOException {
        //This logic allows us to place underneath the WEB-INF
        String extracedAbsolutePath = this.StagingDirectoryForUpload.getFile().getAbsolutePath();
        
        String targetDirectory = extracedAbsolutePath.substring(0, extracedAbsolutePath.length() - 10);
        
        String fiscalYear = DateUtil.getCurrentFiscalYear();
        
        String fiscalMonth = CalendarMonth.getCurrentMonth().name();
        
        String fullpath = targetDirectory + fiscalYear +  File.separator + fiscalMonth.toUpperCase() +  File.separator;
       
        File d1 = new File(fullpath);
        
        if (!d1.exists()) {
         d1.mkdirs();   
        }
        
        return fullpath;
    }
    
        
    /**
     * 
     * @param datasource
     * @param constructor
     * @throws Exception 
     */
    public void generateReport(JRDataSource datasource, FilenameConstructor constructor) throws Exception {
        JasperReport jasperReport = null;
        JasperPrint jasperPrint = null;
        
        //This logic allows us to place underneath the WEB-INF
        //String extracedAbsolutePath = this.StagingDirectoryForUpload.getFile().getAbsolutePath();
        
        //String targetDirectory = extracedAbsolutePath.substring(0, extracedAbsolutePath.length() - 10);
        
        String targetDirectory = getDirectory();
        
        //Provide path for your final pdf file.
        //String destinationFile = StagingDirectoryForUpload + reportName + SEPARATOR + district + SEPARATOR + month + SEPARATOR + fiscalYear + "." + exportType;        
        String destinationFile = constructor.construct(targetDirectory, reportName, exportType);                           

        System.out.println("====>");
        System.out.println("====>");
        System.out.println("====>");
        System.out.println("====>");
        System.out.println("====>" + destinationFile);
        System.out.println("====>");
        System.out.println("====>");
        System.out.println("====>");
        System.out.println("====>");
        
        //Compiling the template.
        jasperReport = JasperCompileManager.compileReport(this.reportDefinitionFile.getInputStream());
        //Sending a parameter with the logged in user name as value
        HashMap parameters = new HashMap();
        parameters.put("DataFile", "SEMonthlyPaymentDatasource.java");
        // Filling the report template with data
        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
        //Sending a Complete print of the report.
        //JasperPrintManager.printReport(jasperPrint, true);
        if ("pdf".equalsIgnoreCase(exportType)) {
            //Exporting it to an PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, destinationFile);
        } else {
            //Exporting it to an XLS
            FileOutputStream output = new FileOutputStream(destinationFile);
            ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
            JRXlsExporter exporterXLS = new JRXlsExporter();
            exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputBuffer);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporterXLS.exportReport();
            output.write(outputBuffer.toByteArray());
            output.flush();
            output.close();
        }
       
        String fiscalYear = DateUtil.getCurrentFiscalYear();
        
        String fiscalMonth = CalendarMonth.getCurrentMonth().name();
        
        final String reportName = new File(destinationFile).getName();
        
        publishGeneratedReport(reportName, this.baseURI  + fiscalYear + "/" + fiscalMonth.toUpperCase() + "/" + reportName, destinationFile, fiscalYear, fiscalMonth, reportGrouping); 
    }
    
    
    
    /**
     * 
     * @param datasource
     * @param constructor
     * @throws Exception 
     */
    public void generateReport(JRDataSource datasource, FilenameConstructor constructor, String fiscalYear, String fiscalMonth) throws Exception {
        JasperReport jasperReport = null;
        JasperPrint jasperPrint = null;
        
        //This logic allows us to place underneath the WEB-INF
        //String extracedAbsolutePath = this.StagingDirectoryForUpload.getFile().getAbsolutePath();
        
        //String targetDirectory = extracedAbsolutePath.substring(0, extracedAbsolutePath.length() - 10);
        
        String targetDirectory = getDirectory(fiscalYear, fiscalMonth);
        
        //Provide path for your final pdf file.
        //String destinationFile = StagingDirectoryForUpload + reportName + SEPARATOR + district + SEPARATOR + month + SEPARATOR + fiscalYear + "." + exportType;        
        String destinationFile = constructor.construct(targetDirectory, reportName, exportType);                           

        System.out.println("====>");
        System.out.println("====>");
        System.out.println("====>");
        System.out.println("====>");
        System.out.println("====>" + destinationFile);
        System.out.println("====>");
        System.out.println("====>");
        System.out.println("====>");
        System.out.println("====>");
        
        //Compiling the template.
        jasperReport = JasperCompileManager.compileReport(this.reportDefinitionFile.getInputStream());
        //Sending a parameter with the logged in user name as value
        HashMap parameters = new HashMap();
        parameters.put("DataFile", "SEMonthlyPaymentDatasource.java");
        // Filling the report template with data
        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
        //Sending a Complete print of the report.
        //JasperPrintManager.printReport(jasperPrint, true);
        if ("pdf".equalsIgnoreCase(exportType)) {
            //Exporting it to an PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, destinationFile);
        } else {
            //Exporting it to an XLS
            FileOutputStream output = new FileOutputStream(destinationFile);
            ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
            JRXlsExporter exporterXLS = new JRXlsExporter();
            exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputBuffer);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporterXLS.exportReport();
            output.write(outputBuffer.toByteArray());
            output.flush();
            output.close();
        }
        
        final String reportName = new File(destinationFile).getName();
        
        publishGeneratedReport(reportName, this.baseURI  + fiscalYear + "/" + fiscalMonth.toUpperCase() + "/" + reportName, destinationFile, fiscalYear, fiscalMonth, reportGrouping);
    }
    
    /**
     * 
     * @param name
     * @param url
     * @param absolutePath
     * @param fiscalYear
     * @param fiscalMonth
     * @param reportType 
     */
    private void publishGeneratedReport(String name, String url, String absolutePath, String fiscalYear, String fiscalMonth, String reportType) {
               
       GeneratedReport generatedReport = generatedReportDao.getReportByUniqueLocation(absolutePath); 
       
       if (generatedReport == null) {
         generatedReport = new GeneratedReport(name, url, absolutePath, fiscalYear, fiscalMonth.toUpperCase(), reportType); 
         
         generatedReport.setDateCreated(new Date());
         
         generatedReportDao.save(generatedReport);
       }
       else {
        generatedReport.setName(name);   
        generatedReport.setUrl(url);
        generatedReport.setFiscalYear(fiscalYear);
        generatedReport.setFiscalMonth(fiscalMonth.toUpperCase());
        generatedReport.setPublished(false);
        generatedReport.setPublishedDate(null);
        generatedReport.setReportType(reportType);
        generatedReport.setDateCreated(new Date());
        
       
        generatedReportDao.saveOrUpdate(generatedReport);
       }
    }
    
     /**
     *
     * @param reportDefinitionFile
     */
    public void setReportDefinitionFile(Resource reportDefinitionFile) {
        this.reportDefinitionFile = reportDefinitionFile;
    }

    /**
     * 
     * @param StagingDirectoryForUpload 
     */
    public void setStagingDirectoryForUpload(Resource StagingDirectoryForUpload) {
        this.StagingDirectoryForUpload = StagingDirectoryForUpload;
    }

    
    /**
     *
     * @param reportName
     */
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    /**
     *
     * @param exportType
     */
    public void setExportType(String exportType) {
        this.exportType = exportType;
    }

    /**
     * 
     * @param generatedReportDao 
     */
    public void setGeneratedReportDao(IGeneratedReportDao generatedReportDao) {
        this.generatedReportDao = generatedReportDao;
    }

    /**
     * 
     * @param baseURI 
     */
    public void setBaseURI(String baseURI) {
        this.baseURI = baseURI;
    }

    /**
     * 
     * @param reportGrouping 
     */
    public void setReportGrouping(String reportGrouping) {
        this.reportGrouping = reportGrouping;
    }

    
    
    
    
}
