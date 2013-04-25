package com.cdoe.services.impl;

import com.cdoe.biz.IGeneratedReportDao;
import com.cdoe.biz.model.GeneratedReport;
import com.cdoe.services.stateequal.IMonthlyPaymentComparisonReportManager;
import com.cdoe.services.stateequal.IPaymentReportManager;
import com.cdoe.services.stateequal.IViewReportsManager;
import com.cdoe.services.stateequal.IYtdPaymenstAndWithholdingsManager;
import com.cdoe.ui.form.ReportForm;
import com.cdoe.ui.form.SeViewReportsForm;
import com.cdoe.ui.form.elements.SeViewableReport;
import com.cdoe.util.DateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

/**
 *
 * @author Tony Ford
 */
public class ViewReportsManager extends BaseManager implements IViewReportsManager {
    
    private static final Logger LOGGER = Logger.getLogger(ViewReportsManager.class);
    private IGeneratedReportDao generatedReportDao;
    private Resource uploadInputFolder;

    /**
     *
     */
    public ViewReportsManager() {
    }

    /**
     *
     * @return
     */
    @Override
    public SeViewReportsForm setupForm() {
        SeViewReportsForm form = new SeViewReportsForm();
        
        List<String> allMonths = DateUtil.getFullMonthList(false);
        
        List<String> availableYears = DateUtil.getLongFiscalYears(-10);
        
        for (String month : allMonths) {
            form.getAvailableMonths().add(month);
        }
        
        for (String year : availableYears) {
            form.getAvailableYears().put(year, DateUtil.getFiscalYearFormattedShort(year));
        }
        
        form.setReportTypes(ReportForm.getReportTypes());        
        
        return form;
    }

    /**
     *
     * @param fiscalYear
     * @param fiscalMonth
     * @return
     */
    @Override
    public SeViewReportsForm setupForm(String fiscalYear, String fiscalMonth, String reportType) {
        SeViewReportsForm form = setupForm();
        
        form.setReportType(reportType);
        form.setMonth(fiscalMonth);
        form.setYear(fiscalYear);
        
        try {
            
            List<GeneratedReport> viewableReports = generatedReportDao.getReportByGrouping(fiscalYear, fiscalMonth.toUpperCase(), reportType);
            
            int sequence = 0;
            for (GeneratedReport report : viewableReports) {
                
                report.setSequence(sequence++);
                
                if (report.getAbsolutePath() != null && new File(report.getAbsolutePath()).exists()) {
                 form.getGeneratedReports().add(report);  
                }
                
                if (LOGGER.isDebugEnabled() && report.getPublished() != null && report.getPublished()) {
                 LOGGER.debug(report.getName() + " report has been published!!!");                    
                }
            }

//            String targetDirectory = null;
//            String uri = null;
//
//            if (ReportForm.RPT360.equals(reportType)) {
//            } else if (ReportForm.RPTCofrPayments.equals(reportType)) {
//            } else if (ReportForm.RPTCsiPayment.equals(reportType)) {
//            } else if (ReportForm.RPTElections.equals(reportType)) {
//            } else if (ReportForm.RPTFundSummary.equals(reportType)) {
//            } else if (ReportForm.RPTMillLevy.equals(reportType)) {
//            } else if (ReportForm.RPTMonthlyComparison.equals(reportType)) {
//                targetDirectory = monthlyComparisonReportingService.getDirectory(fiscalYear, fiscalMonth);
//                uri = "/dynamic/report/monthlycomparison/" + fiscalYear + "/" + fiscalMonth.toUpperCase() + "/";
//            } else if (ReportForm.RPTMonthlyPayment.equals(reportType)) {
//                targetDirectory = monthlyPaymentService.getDirectory(fiscalYear, fiscalMonth);
//                uri =  "/dynamic/report/monthlypayment/" + fiscalYear + "/" + fiscalMonth.toUpperCase() + "/";
//            } else if (ReportForm.RPTNegativePayments.equals(reportType)) {
//            } else if (ReportForm.RPTTotalEntitlement.equals(reportType)) {
//            } else if (ReportForm.RPTYtdWithholdings.equals(reportType)) {
//                targetDirectory = ytdPaymentWithholdingService.getDirectory(fiscalYear, fiscalMonth);
//                uri = "/dynamic/report/ytdpayments/" + fiscalYear + "/" + fiscalMonth.toUpperCase() + "/";
//            }
//             else if (ReportForm.RPTStateWideReports.equals(reportType)) {
//                targetDirectory = ytdPaymentWithholdingService.getDirectory(fiscalYear, fiscalMonth);
//                uri = "/dynamic/report/statewide/" + fiscalYear + "/" + fiscalMonth.toUpperCase() + "/";
//            }
//             
//            File reportsDirectory = new File(targetDirectory);
//
//            File[] generatedReports = reportsDirectory.listFiles();
//              
//            int sequence = 0;
//            for (File report : generatedReports) {
//
//                GeneratedReport viewableReport = generatedReportDao.getReportByUniqueLocation(report.getAbsolutePath()); //ReportCacheManager.getInstance().getReport(report.getAbsolutePath());
//
//                if (viewableReport != null) {
//                    form.getGeneratedReports().add(viewableReport);
//                } else {
//                    String fullname = report.getName();
//
//                    //String[] yearMonthInfo = extractYearAndMonth(report.getAbsolutePath());
//                    
//                    viewableReport = new GeneratedReport(fullname, uri + fullname, report.getAbsolutePath());
//
//                    viewableReport.setSequence(sequence++);
//                    
//                    Long generatedId = generatedReportDao.save(viewableReport);
//                    
//                    if (generatedId != null) {
//                     viewableReport.setId(generatedId);
//                                        
//                     form.getGeneratedReports().add(viewableReport);
//
//                     //ReportCacheManager.getInstance().getAvailableReports().add(viewableReport);
//                    }
//                    else {
//                     LOGGER.error("saving generated report info to database.");   
//                    }
//                }
//            }

            
        } catch (Exception e) {
            LOGGER.error("error viewing generated reports", e);            
        }
        
        return form;
    }

    /**
     *
     * @param form
     */
    @Override
    public void uploadReports(SeViewReportsForm form) {
        try {
            //This logic allows us to place underneath the WEB-INF
            String extracedAbsolutePath = this.uploadInputFolder.getFile().getAbsolutePath();                        
            
            String targetDirectory = extracedAbsolutePath.substring(0, extracedAbsolutePath.length() - 10);
                        
            final String inbox  = targetDirectory + "inbox/";
            final String outbox = targetDirectory + "outbox/";
            
            File inboxDirectory = new File(inbox);
            
            File outboxDirectory = new File(outbox);
            
            if (!inboxDirectory.exists()) {
             inboxDirectory.mkdir();  
            }
            
            if (!outboxDirectory.exists()) {
             outboxDirectory.mkdir();  
            }
            
            for (Long reportId : form.getReports()) {
                GeneratedReport generatedReport = generatedReportDao.getReportById(reportId);   
                
                File inputFile = new File(generatedReport.getAbsolutePath());
                File outFile = new File(inbox,inputFile.getName());
                
                if (!outFile.exists()) {               
                 FileCopyUtils.copy(new FileInputStream(inputFile), new FileOutputStream(outFile));
                 
                 saveGeneratedReport(generatedReport);
                }
                else {
                 LOGGER.warn("file already present in upload queue : " + outFile.getAbsolutePath());   
                }
            }            
        } catch (Exception e) {
            LOGGER.error("exception occured during file upload", e);            
        }
    }
    
    /**
     * 
     * @param generatedReport 
     */
    @Override
    public void saveGeneratedReport(GeneratedReport generatedReport) {
     generatedReport.setPublished(Boolean.TRUE);
     generatedReport.setPublishedDate(new Date());
     
     generatedReportDao.saveOrUpdate(generatedReport);   
    }

    /**
     *
     * @param absolutePath
     * @return
     */
    public String[] extractYearAndMonth(String absolutePath) {
        String[] results = new String[2];
        
        String[] tokens = absolutePath.split(File.separator);
        
        int size = tokens.length - 1;
        
        for (int x = 1; x >= 0; --x) {
            results[x] = tokens[--size];            
        }
        
        return results;
    }

    /**
     *
     * @param reportGuids
     */
    @Override
    public void delete(List<String> reportGuids) {
        
    }

    /**
     *
     * @param reportGuids
     */
    @Override
    public void print(List<String> reportGuids) {
        
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
     * @param uploadInputFolder
     */
    public void setUploadInputFolder(Resource uploadInputFolder) {
        this.uploadInputFolder = uploadInputFolder;
    }
}
