/*
 *  Copyright ResQSoft, Inc. 2011
 *
 *  ref: Engineer Static Repository File
 */

package com.resqsoft.jasper;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.SystemUtils;

/**
 * @author ResQSoft Engineer
 * Basic "Facade" class to Jasper Report engine to make report generations
 * simpler.
 */
public final class JasperFacade {
    
    /**
     * Compiles XML definition of report.
     */
    static JasperReport compileReport(String pathToJasperReportJar, InputStream reportXml)
            throws JRException {

        System.setProperty("jasper.reports.compile.class.path", System
                .getProperty("java.class.path")
                + ";" + pathToJasperReportJar);
        JasperReport jr = JasperCompileManager.compileReport(reportXml);
        return jr;
    }
    
    /**
     * Generates PDF version of the Jasper report.
     * @param reportXml XML definition of the report.
     * @param reportParams Map containing report params if applicable, empty map otherwise.
     * @param dbCon Database connection to use
     * @param pathToJasperReportJar Absolute path to jasperreport.jar file.
     * @return OutputStream containing generated PDF.
     */
    @Deprecated
    static public InputStream generatePdf(InputStream reportXml, Map reportParams,
            java.sql.Connection dbCon, String pathToJasperReportJar) throws JRException {

        JasperReport jr = compileReport(pathToJasperReportJar, reportXml);
        byte[] reportData = JasperRunManager.runReportToPdf(jr, reportParams, dbCon);
        
        return new ByteArrayInputStream(reportData);
    }
    
    /**
     * Generates PDF version of the Jasper report.
     * @param reportXml XML definition of the report.
     * @param reportParams Map containing report params if applicable, empty map
     * otherwise.
     * @param ds custom data source to use. Used for passing DTO's to report to
     * hande complex situations
     * @param pathToJasperReportJar Absolute path to jasperreport.jar file.
     * @return OutputStream containing generated PDF.
     */
    @Deprecated
    static public InputStream generatePdf(InputStream reportXml, Map reportParams,
            CustomDataSource ds, String pathToJasperReportJar) throws JRException {

        JasperReport jr = compileReport(pathToJasperReportJar, reportXml);
        byte[] reportData = JasperRunManager.runReportToPdf(jr, reportParams, ds);
        
        return new ByteArrayInputStream(reportData);
    }
    
    /**
     * Generates PDF version of the Jasper report.
     * @param compiledReport .jasper-file of compiled report.
     * @param reportParams Map containing report params if applicable, empty map otherwise.
     * @param dbCon Database connection to use
     * @param pathToJasperReportJar Absolute path to jasperreport.jar file.
     * @return OutputStream containing generated PDF.
     */
    @Deprecated
    static public InputStream generatePdfFromCompiled(InputStream compiledReport, Map reportParams,
            java.sql.Connection dbCon) throws JRException {

        byte[] reportData = JasperRunManager.runReportToPdf(compiledReport, reportParams, dbCon);
        
        return new ByteArrayInputStream(reportData);
    }
    
    /**
     * Generates PDF version of the Jasper report.
     * @param compiledReport compiled report.
     * @param reportParams Map containing report params if applicable, empty map
     * otherwise.
     * @param ds custom data source to use. Used for passing DTO's to report to
     * hande complex situations
     * @param pathToJasperReportJar Absolute path to jasperreport.jar file.
     * @return OutputStream containing generated PDF.
     */
    @Deprecated
    static public InputStream generatePdfFromCompiled(InputStream compiledReport, Map reportParams,
            CustomDataSource ds) throws JRException {

        byte[] reportData = JasperRunManager.runReportToPdf(compiledReport, reportParams, ds);
        
        return new ByteArrayInputStream(reportData);
    }
    
    /**
     * Loads compiled Jasper Report, fills it with data from the given {@link CustomDataSource}, then
     * writes it to {@link HttpServletResponse} setting the appropriate content type. The response is flushed
     * and closed.
     * @param compiledReport
     * @param format
     * @param reportParams
     * @param ds
     * @param response
     * @throws IOException 
     * @throws JRException 
     */
    public static void generateReport(InputStream compiledReport, ReportOutputFormat format,
            Map reportParams, CustomDataSource ds, HttpServletResponse response)
            throws IOException, JRException {

        response.setContentType(format.getContentType());
        OutputStream os = response.getOutputStream();
        //generateReport(compiledReport, format, reportParams, ds, os);
    }

    /**
     * @param compiledReport
     * @param format
     * @param reportParams
     * @param ds
     * @param os
     * @throws JRException
     * @throws FileNotFoundException
     * @throws IOException
     */
//    public static void generateReport(InputStream compiledReport, ReportOutputFormat format,
//            Map params, CustomDataSource ds, OutputStream os) throws JRException,
//            FileNotFoundException, IOException {
//
//        InputStream is = null;
//        File tempFile = null;
//        Map reportParams = new HashMap(params);
//        reportParams.put("outputFormat", format.getName());
//        try {
//            JasperReport jr = JasperManager.loadReport(compiledReport);
//            if (format.equals(ReportOutputFormat.HTML) || format.equals(ReportOutputFormat.CSV)) {
//                reportParams.put("IS_IGNORE_PAGINATION", Boolean.TRUE);
//            }
//            JasperPrint jp = JasperFillManager.fillReport(jr, reportParams, ds);
//            
//            if (format.equals(ReportOutputFormat.PDF)) {
//                JasperExportManager.exportReportToPdfStream(jp, os);
//            }
//            else if (format.equals(ReportOutputFormat.HTML)) {
//                JRHtmlExporter htmlEx = new JRHtmlExporter();
//                htmlEx.setParameter(JRExporterParameter.JASPER_PRINT, jp);
//                htmlEx.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//                htmlEx.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);                
//                htmlEx.exportReport();
//                
//            }
//            else if (format.equals(ReportOutputFormat.RTF)) {
//                JRRtfExporter rtfEx = new JRRtfExporter();
//                rtfEx.setParameter(JRExporterParameter.JASPER_PRINT, jp);
//                rtfEx.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//                rtfEx.exportReport();
//            } else if (format.equals(ReportOutputFormat.CSV)) {
//                JRCsvExporter csvEx = new JRCsvExporter();
//                csvEx.setParameter(JRExporterParameter.JASPER_PRINT, jp);
//                csvEx.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//                csvEx.exportReport();
//            }
//            os.flush();
//        }
//        finally {
//            IOUtils.closeQuietly(os);
//            IOUtils.closeQuietly(is);
//            IOUtils.closeQuietly(compiledReport);
//            if (tempFile != null) {
//                tempFile.delete();
//            }
//        }
//    }
    
}
