package com.cdoe.ui.stateequal;

import com.cdoe.biz.model.FiscalMonth;
import org.apache.log4j.Logger;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.resqsoft.util.RequestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cdoe.biz.model.VData;
import com.cdoe.biz.model.equal.Csi;
import com.cdoe.biz.model.equal.CsiPaymentAdapter;
import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.jasper.CsiPaymentDatasource;
import com.cdoe.biz.model.jasper.DistrictInfo;
import com.cdoe.biz.model.jasper.ElectionInfo;
import com.cdoe.biz.model.jasper.Message;
import com.cdoe.biz.model.jasper.MessageDatasource;
import com.cdoe.biz.model.jasper.NegativePayment;
import com.cdoe.biz.model.jasper.SEMonthlyPayment;
import com.cdoe.biz.model.jasper.SEMonthlyPaymentDatasource;
import com.cdoe.biz.model.jasper.SEMonthlyPaymentDatasourceProvider;
import com.cdoe.biz.model.jasper.SeFinallMillLevySummary;
import com.cdoe.biz.model.jasper.SeMonthlyAdapter;
import com.cdoe.biz.model.jasper.SeMonthlyPaymentComparisonDatasource;
import com.cdoe.biz.model.jasper.SeTotalEntitlement;
import com.cdoe.biz.model.jasper.YtdPaymentCollection;
import com.cdoe.biz.model.jasper.YtdPaymentDatasource;
import com.cdoe.services.IGenerateElectionReport;
import com.cdoe.services.IGenerateSeCsiPaymentReportTask;
import com.cdoe.services.IGenerateTotalEntitlementReport;
import com.cdoe.services.IMailClient;
import com.cdoe.services.ISeCofrsPaymentReportManager;
import com.cdoe.services.exempt.ITaskExecutionManager;
import com.cdoe.services.concurrent.BasicTask;
import com.cdoe.services.IGenerateMillLevySummaryReport;
import com.cdoe.services.IGenerateNegativePaymentReport;
import com.cdoe.services.concurrent.TaskIdentifer;
import com.cdoe.services.concurrent.TaskMonitor;
import com.cdoe.services.stateequal.IElectionReportManager;
import com.cdoe.services.stateequal.IGenerateSeCofrsPaymentReport;
import com.cdoe.services.stateequal.IGenerateSeMonthlyComparisonReport;
import com.cdoe.services.stateequal.IGenerateSeMonthlyPaymentReport;
import com.cdoe.services.stateequal.IGenerateYtdPaymentWithholdingsReport;
import com.cdoe.services.stateequal.IMillLevySummaryReportManager;
import com.cdoe.services.stateequal.IMonthlyPaymentComparisonReportManager;
import com.cdoe.services.stateequal.INegativePaymentReportManager;
import com.cdoe.services.stateequal.IPaymentReportManager;
import com.cdoe.services.stateequal.IReportsManager;
import com.cdoe.services.stateequal.IYtdPaymenstAndWithholdingsManager;
import com.cdoe.services.stateequal.ISeCsiPaymentReportManager;
import com.cdoe.services.stateequal.ITotalEntitlementReportManager;
import com.cdoe.ui.form.ProgressMeterForm;
import com.cdoe.ui.form.ReportForm;
import com.cdoe.ui.form.elements.ProgressMeter;
import com.cdoe.util.CalendarMonth;
import com.cdoe.util.DateUtil;
import com.cdoe.util.FilenameConstructor;
import com.cdoe.util.UserInfo;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secure/Reports")
public class ReportsController {

    private static final Logger logger = Logger.getLogger(ReportsController.class);
    @Autowired
    @Qualifier("seYtdPaymentAndWithholdingReportManager")
    private IYtdPaymenstAndWithholdingsManager ytdPaymentAndWithholdingReportManager;
    @Autowired
    @Qualifier("sePaymentComparisonReportManager")
    private IMonthlyPaymentComparisonReportManager monthlyPaymentComparisonReportManager;
    @Autowired
    private IReportsManager reportsManager;
    @Autowired
    @Qualifier("sePaymentReportManager")
    private IPaymentReportManager monthlyPaymentReportManager;
    @Autowired
    private Validator reportGenerationValidator;
    @Autowired
    private ITaskExecutionManager taskExecutionManager;
    private static boolean INITIALIZE_DATABASE = true;
    @Autowired
    private ISeCsiPaymentReportManager csiPaymentReportManager;
    @Autowired
    private ISeCofrsPaymentReportManager seCofrsPaymentReportManager;     
    @Autowired
    private IMillLevySummaryReportManager seMillLevySummaryReportManager;    
    @Autowired
    private ITotalEntitlementReportManager totalEntitlementReportManager;
    @Autowired
    @Qualifier("negativePaymentReport")
    private INegativePaymentReportManager negativePaymentReportManager;
    @Autowired
    private IElectionReportManager electionReportManager;
    @Autowired
    private IMailClient mailClient;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        //HttpSession session = request.getSession();
        //UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");

        //Object[] districtCodes = null;
        //Need to account for adminUser also
        //if (userInfo.isAdminUser()) {
            // For right now, we'll default to the first district
            // This needs to change to a drop-down for the admin user where they select
            // the district to work on
        //    districtCodes = userInfo.getAllNameNCodes().toArray();
       // }

        //if (districtCodes != null) {
        //    model.addAttribute("districtNumbers", districtCodes);
        //}
        
        
        //remove
        //Map<String,String> orderDistirctMap  = new TreeMap<String,String>(userInfo.getDistrictMap());        
        //csiPaymentReportManager.saveGenerateData(orderDistirctMap);
        //

        //ReportForm form = reportsManager.setupForm();

        //model.addAttribute("pageInfo", form);
        //return ".Reports-index";
        
        return status(model, request);
    }
    
    /**
     * 
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String status(Model model, HttpServletRequest request) {
      ProgressMeterForm form = new ProgressMeterForm();
      form.setTitle("Report Generation Progress");
      
            
      
      /**
       * 
       */
      if (taskExecutionManager.isExecuting(TaskIdentifer.CsiPaymentReport)) {  
       TaskMonitor progress = taskExecutionManager.checkProgress(TaskIdentifer.CsiPaymentReport);
       
       if (progress != null) {
        //String status, String statusDetail, Integer progress, String task   
        ProgressMeter meter = new ProgressMeter(progress.getStatus().name(), progress.getStatusDetail(), (int)(progress.getProgress() * 100), TaskIdentifer.CsiPaymentReport.name());   
        
        form.getProgressInfo().add(meter);        
       }
      }
      
      /**
       * 
       */
      if (taskExecutionManager.isExecuting(TaskIdentifer.CofrsPaymentReport)) {  
       TaskMonitor progress = taskExecutionManager.checkProgress(TaskIdentifer.CofrsPaymentReport);
       
       if (progress != null) {
        //String status, String statusDetail, Integer progress, String task   
        ProgressMeter meter = new ProgressMeter(progress.getStatus().name(), progress.getStatusDetail(), (int)(progress.getProgress() * 100), TaskIdentifer.CofrsPaymentReport.name());   
        
        form.getProgressInfo().add(meter);        
       }
      }
      
      /**
       * 
       */
      if (taskExecutionManager.isExecuting(TaskIdentifer.MonthlyComparisonReport)) {  
       TaskMonitor progress = taskExecutionManager.checkProgress(TaskIdentifer.MonthlyComparisonReport);
       
       if (progress != null) {
        //String status, String statusDetail, Integer progress, String task   
        ProgressMeter meter = new ProgressMeter(progress.getStatus().name(), progress.getStatusDetail(), (int)(progress.getProgress() * 100), TaskIdentifer.MonthlyComparisonReport.name());   
        
        form.getProgressInfo().add(meter);        
       }
      }
      
     
      
      /**
       * 
       */
      if (taskExecutionManager.isExecuting(TaskIdentifer.MonthlyPaymentReport)) {  
       TaskMonitor progress = taskExecutionManager.checkProgress(TaskIdentifer.MonthlyPaymentReport);
       
       if (progress != null) {
        //String status, String statusDetail, Integer progress, String task   
        ProgressMeter meter = new ProgressMeter(progress.getStatus().name(), progress.getStatusDetail(), (int)(progress.getProgress() * 100), TaskIdentifer.MonthlyPaymentReport.name());   
        
        form.getProgressInfo().add(meter);        
       }
      }
      
      /**
       * 
       */
      if (taskExecutionManager.isExecuting(TaskIdentifer.YtdPaymentWithholdingReport)) {  
       TaskMonitor progress = taskExecutionManager.checkProgress(TaskIdentifer.YtdPaymentWithholdingReport);
       
       if (progress != null) {
        //String status, String statusDetail, Integer progress, String task   
        ProgressMeter meter = new ProgressMeter(progress.getStatus().name(), progress.getStatusDetail(), (int)(progress.getProgress() * 100), TaskIdentifer.YtdPaymentWithholdingReport.name());   
        
        form.getProgressInfo().add(meter);        
       }
      }
      
      
      if (taskExecutionManager.isExecuting(TaskIdentifer.MillLevySummaryReport)) {  
       TaskMonitor progress = taskExecutionManager.checkProgress(TaskIdentifer.MillLevySummaryReport);
       
       if (progress != null) {
        //String status, String statusDetail, Integer progress, String task   
        ProgressMeter meter = new ProgressMeter(progress.getStatus().name(), progress.getStatusDetail(), (int)(progress.getProgress() * 100), TaskIdentifer.MillLevySummaryReport.name());   
        
        form.getProgressInfo().add(meter);        
       }
      }
      
      if (taskExecutionManager.isExecuting(TaskIdentifer.NegativePaymentReport)) {  
       TaskMonitor progress = taskExecutionManager.checkProgress(TaskIdentifer.NegativePaymentReport);
       
       if (progress != null) {
        //String status, String statusDetail, Integer progress, String task   
        ProgressMeter meter = new ProgressMeter(progress.getStatus().name(), progress.getStatusDetail(), (int)(progress.getProgress() * 100), TaskIdentifer.NegativePaymentReport.name());   
        
        form.getProgressInfo().add(meter);        
       }
      }
      
      if (taskExecutionManager.isExecuting(TaskIdentifer.TotalEntitlementReport)) {  
       TaskMonitor progress = taskExecutionManager.checkProgress(TaskIdentifer.TotalEntitlementReport);
       
       if (progress != null) {
        //String status, String statusDetail, Integer progress, String task   
        ProgressMeter meter = new ProgressMeter(progress.getStatus().name(), progress.getStatusDetail(), (int)(progress.getProgress() * 100), TaskIdentifer.TotalEntitlementReport.name());   
        
        form.getProgressInfo().add(meter);        
       }
      }
      
      if (taskExecutionManager.isExecuting(TaskIdentifer.ElectionReport)) {  
       TaskMonitor progress = taskExecutionManager.checkProgress(TaskIdentifer.ElectionReport);
       
       if (progress != null) {
        //String status, String statusDetail, Integer progress, String task   
        ProgressMeter meter = new ProgressMeter(progress.getStatus().name(), progress.getStatusDetail(), (int)(progress.getProgress() * 100), TaskIdentifer.ElectionReport.name());   
        
        form.getProgressInfo().add(meter);        
       }
      }
      
     if (form.getProgressInfo().isEmpty()) {
       mailClient.send("testMessage", "Report generation complete!!!");  
       
       HttpSession session = request.getSession();
       UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");

       Object[] districtCodes = null;
        //Need to account for adminUser also
        if (userInfo.isAdminUser()) {
            // For right now, we'll default to the first district
            // This needs to change to a drop-down for the admin user where they select
            // the district to work on
            districtCodes = userInfo.getAllNameNCodes().toArray();
        }

        if (districtCodes != null) {
            model.addAttribute("districtNumbers", districtCodes);
        }
        
               
        ReportForm otherForm = reportsManager.setupForm();  
        
        model.addAttribute("pageInfo", otherForm);                
         
        return ".Reports-index";
     }   
     
     model.addAttribute("statusPage", "/secure/Reports/status");
     
     model.addAttribute("pageInfo", form);
     
     return ".Reports-status";   
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView report1(@RequestParam String reportId, @RequestParam String districtNumber, @RequestParam String month, @RequestParam String year, HttpServletRequest request) {
        final String reportName = "stateEqualPayment";
        final String format = "Pdf";

        //reportId=" + reportId + "&districtNumber=" + varDistrictNumber+ "&month=" +varMonth +"&year=" + varYear});    
        try {
            Map<String, Object> parameterMap = new HashMap<String, Object>();

            /**
             * @TODO connect this to an actual datasource
             */
            JRDataSource datasource = new SEMonthlyPaymentDatasource(SEMonthlyPaymentDatasourceProvider.createSEMonthlyPaymentCollection());

            parameterMap.put("customJRDatasource", datasource);

            String selectedReportId = reportName + "Report" + format + "View";

            return new ModelAndView(selectedReportId, parameterMap);
        } catch (Exception e) {
        }

        return null;
    }

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public String generateReports(Model model, @ModelAttribute ReportForm reportForm, BindingResult result, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");

        System.out.println("Rpt360DistrictNumber : " + reportForm.getRpt360DistrictNumber());
        System.out.println("RptFundSummaryDistrictNumber : " + reportForm.getRptFundSummaryDistrictNumber());
        System.out.println("RptMonthlyPaymentsDistrictNumber : " + reportForm.getRptMonthlyPaymentsDistrictNumber());
        System.out.println("Month : " + reportForm.getMonth());
        System.out.println("Year : " + reportForm.getYear());
        System.out.println("Reports : " + reportForm.getReports());

        reportGenerationValidator.validate(reportForm, result);

        if (!result.hasErrors()) {
            for (String report : reportForm.getReports()) {
                try {
                    if (ReportForm.RPT360.equals(report)) {
                    } else if (ReportForm.RPTFundSummary.equals(report)) {
                    } else if (ReportForm.RPTMonthlyPayment.equals(report)) {

                        String selectedMonth = reportForm.getMonth();

                        String selectedYear = reportForm.getYear();

                        /**
                         * create monthly payment report generation task
                         */
                        IGenerateSeMonthlyPaymentReport taskGenMonthlyPaymentReport = (IGenerateSeMonthlyPaymentReport) taskExecutionManager.createTask(TaskIdentifer.MonthlyPaymentReport);

                        taskGenMonthlyPaymentReport.setSelectedMonth(selectedMonth);

                        taskGenMonthlyPaymentReport.setSelectedYear(selectedYear);

                        taskGenMonthlyPaymentReport.setDistrictMap(userInfo.getDistrictMap());


                        taskExecutionManager.submitTask(taskGenMonthlyPaymentReport);


                        //model.addAttribute("errorMessage", "Payment report generation successful.");
                    } else if (ReportForm.RPTCsiPayment.equals(report)) {
                       String selectedYear = reportForm.getYear();
                       
                        /**
                         * create monthly payment report generation task
                         */
                        IGenerateSeCsiPaymentReportTask taskGenCsiPaymentReport = (IGenerateSeCsiPaymentReportTask) taskExecutionManager.createTask(TaskIdentifer.CsiPaymentReport);
                        
                        taskGenCsiPaymentReport.setSelectedYear(selectedYear);

                        taskGenCsiPaymentReport.setDistrictMap(userInfo.getDistrictMap());

                        taskExecutionManager.submitTask(taskGenCsiPaymentReport);
                        
                    } else if (ReportForm.RPTMonthlyComparison.equals(report)) {

                        // Initialize GregorianCalendar                       

                        CalendarMonth currentMonth = CalendarMonth.getCurrentMonth();
                        CalendarMonth previousMonth = currentMonth.prev();

                        String selectedMonth = previousMonth.name();
                        String selectedYear = null;

                        if (previousMonth == CalendarMonth.JUNE) {
                            selectedYear = DateUtil.getPrevFiscalYear();
                        } else {
                            selectedYear = DateUtil.getCurrentFiscalYear();
                        }

                        /**
                         * create monthly payment report generation task
                         */
                        IGenerateSeMonthlyComparisonReport taskGenMonthlyComparisonReport = (IGenerateSeMonthlyComparisonReport) taskExecutionManager.createTask(TaskIdentifer.MonthlyComparisonReport);

                        taskGenMonthlyComparisonReport.setSelectedMonth(selectedMonth);

                        taskGenMonthlyComparisonReport.setSelectedYear(selectedYear);

                        taskGenMonthlyComparisonReport.setDistrictMap(userInfo.getDistrictMap());

                        taskExecutionManager.submitTask(taskGenMonthlyComparisonReport);


                    } else if (ReportForm.RPTYtdWithholdings.equals(report)) {
                        String selectedYear = DateUtil.getCurrentFiscalYear();

                        String selectedMonth = CalendarMonth.getCurrentMonth().name();

                        /**
                         * create monthly payment report generation task
                         */
                        IGenerateYtdPaymentWithholdingsReport task2 = (IGenerateYtdPaymentWithholdingsReport) taskExecutionManager.createTask(TaskIdentifer.YtdPaymentWithholdingReport);

                        task2.setSelectedMonth(selectedMonth);

                        task2.setSelectedYear(selectedYear);

                        task2.setUserInfo(userInfo);

                        taskExecutionManager.submitTask(task2);


                    } else if (ReportForm.RPTCofrPayments.equals(report)) {

                        String selectedYear = DateUtil.getCurrentFiscalYear();

                        String selectedMonth = CalendarMonth.getCurrentMonth().name();

                        /**
                         * create monthly payment report generation task
                         */
                        IGenerateSeCofrsPaymentReport task2 = (IGenerateSeCofrsPaymentReport) taskExecutionManager.createTask(TaskIdentifer.CofrsPaymentReport);

                        task2.setSelectedMonth(selectedMonth);

                        task2.setSelectedYear(selectedYear);

                        task2.setUserInfo(userInfo);

                        taskExecutionManager.submitTask(task2);

                    } else if (ReportForm.RPTMillLevy.equals(report)) {
                        String selectedYear = DateUtil.getCurrentFiscalYear();
                        
                        /**
                         * create monthly payment report generation task
                         */
                        IGenerateMillLevySummaryReport task2 = (IGenerateMillLevySummaryReport) taskExecutionManager.createTask(TaskIdentifer.MillLevySummaryReport);

                        task2.setFiscalYear(selectedYear);                        

                        task2.setUserInfo(userInfo);

                        taskExecutionManager.submitTask(task2);
                    } else if (ReportForm.RPTElections.equals(report)) {
                         //String selectedYear = DateUtil.getCurrentFiscalYear();
                         
                         String selectedYear = reportForm.getYear();
                        
                        /**
                         * create monthly payment report generation task
                         */
                        IGenerateElectionReport task2 = (IGenerateElectionReport) taskExecutionManager.createTask(TaskIdentifer.ElectionReport);

                        task2.setFiscalYear(selectedYear);                        

                        task2.setUserInfo(userInfo);

                        taskExecutionManager.submitTask(task2);
                    } else if (ReportForm.RPTTotalEntitlement.equals(report)) {
                         String selectedYear = DateUtil.getCurrentFiscalYear();
                        
                        /**
                         * create monthly payment report generation task
                         */
                        IGenerateTotalEntitlementReport task2 = (IGenerateTotalEntitlementReport) taskExecutionManager.createTask(TaskIdentifer.TotalEntitlementReport);

                        task2.setFiscalYear(selectedYear);                        

                        task2.setUserInfo(userInfo);

                        taskExecutionManager.submitTask(task2);
                    } else if (ReportForm.RPTNegativePayments.equals(report)) {
                        String selectedYear = DateUtil.getCurrentFiscalYear();
                        
                        /**
                         * create monthly payment report generation task
                         */
                        IGenerateNegativePaymentReport task2 = (IGenerateNegativePaymentReport) taskExecutionManager.createTask(TaskIdentifer.NegativePaymentReport);

                        task2.setFiscalYear(selectedYear);                        

                        task2.setUserInfo(userInfo);

                        taskExecutionManager.submitTask(task2);
                    }
                } catch (Throwable t) {
                    logger.error("Error while generating report " + report, t);

                    result.reject("report : " + report + " encountered exception durong report generation - " + t.toString());
                }
            }
        }


  
        return status(model, request);
    }

    @RequestMapping(value = "/print", method = RequestMethod.POST)
    public ModelAndView viewReport(Model model, @ModelAttribute ReportForm reportForm, BindingResult result, HttpServletRequest request) {
         HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");

        System.out.println("Rpt360DistrictNumber : " + reportForm.getRpt360DistrictNumber());
        System.out.println("RptFundSummaryDistrictNumber : " + reportForm.getRptFundSummaryDistrictNumber());
        System.out.println("RptMonthlyPaymentsDistrictNumber : " + reportForm.getRptMonthlyPaymentsDistrictNumber());
        System.out.println("Month : " + reportForm.getMonth());
        System.out.println("Year : " + reportForm.getYear());
        System.out.println("Reports : " + reportForm.getReports());

        reportGenerationValidator.validate(reportForm, result);



        if (!result.hasErrors()) {
            for (String report : reportForm.getReports()) {
                try {
                    if (ReportForm.RPT360.equals(report)) {
                    } else if (ReportForm.RPTFundSummary.equals(report)) {
                    } else if (ReportForm.RPTMonthlyPayment.equals(report)) {
                        final String reportName = "stateEqualPayment";
                        final String format = "Pdf";

                        String districtNumberAndName = reportForm.getRptMonthlyPaymentsDistrictNumber();
                        String[] districtDetails = districtNumberAndName.split(" - ");

                        String districtNumber = districtDetails[0];
                        String districtName = districtDetails[1];

                        String selectedMonth = reportForm.getMonth();

                        String selectedYear = reportForm.getYear();

                        String fiscalYear = selectedYear; //DateUtil.getFiscalYear(selectedYear, CalendarMonth.getInstance(selectedMonth).getCalendarValue());

                        String format1FiscalYear = DateUtil.getFiscalYearFormattedShort(fiscalYear);

                        String format2FiscalYear = "Fy_" + fiscalYear.substring(4);

                        //getMonthlyPaymentInfo(String districtNumber, String fiscalYear, String month);
                        List<SeMonthly> paymentInfo = monthlyPaymentReportManager.getMonthlyPaymentInfo(districtDetails[0], fiscalYear, selectedMonth);

                        if (paymentInfo == null || paymentInfo.isEmpty()) {
                            throw new java.lang.IllegalStateException("Missing payment info!!!");
                        }

                        //createMonthlyPaymnetDatasource(String districtNumber, String districtName, String fiscalYear, String month, List<SeMonthly> paymentInfo);
                        JRDataSource datasource = monthlyPaymentReportManager.createMonthlyPaymnetDatasource(districtDetails[0], districtDetails[1], format1FiscalYear, selectedMonth, paymentInfo);

                        Map<String, Object> parameterMap = new HashMap<String, Object>();

                        parameterMap.put("customJRDatasource", datasource);

                        String selectedReportId = reportName + "Report" + format + "View";

                        return new ModelAndView(selectedReportId, parameterMap);

                    } else if (ReportForm.RPTCsiPayment.equals(report)) {
                        final String reportName = "cisMonthlyPayment";
                        final String format = "Pdf";
                        
                        Map modifiedDistrictMap = new TreeMap(userInfo.getDistrictMap());
                        
                        final FiscalMonth selectedMonth = FiscalMonth.getCurrentMonth();
                        
                        modifiedDistrictMap.putAll(csiPaymentReportManager.getCSIListing());
        
                        CsiPaymentAdapter.setDistrictMap(modifiedDistrictMap);
                                                
                        String selectedYear = reportForm.getYear();                                                 
                                                       
                        List<Csi> csiInfo = csiPaymentReportManager.getCsiPaymentInfo(selectedYear);
        
                        List<CsiPaymentAdapter> csiPaymentCalculations = csiPaymentReportManager.computeCsiPaymentInfo(csiInfo);
        
                        CsiPaymentDatasource datasource = csiPaymentReportManager.createCsiPaymentDatasource(csiPaymentCalculations, selectedMonth, selectedYear);
        
                        Map<String, Object> parameterMap = new HashMap<String, Object>();

                        parameterMap.put("customJRDatasource", datasource);

                        String selectedReportId = reportName + "Report" + format + "View";

                        return new ModelAndView(selectedReportId, parameterMap);
                   
                    } else if (ReportForm.RPTMonthlyComparison.equals(report)) {
                        final String reportName = "monthlyPaymentComparison";
                        final String format = "Pdf";

                        String districtNumberAndName = reportForm.getRptMonthlyComparisonDistrictNumber();
                        String[] districtDetails = districtNumberAndName.split(" - ");

                        if (districtDetails.length < 2) {
                            continue;
                        }

                        String districtNumber = districtDetails[0];
                        String districtName = districtDetails[1];

                        // Initialize GregorianCalendar
                        GregorianCalendar cal = new GregorianCalendar();
                        //int currYear = cal.get(GregorianCalendar.YEAR);
                        //int currDOM = cal.get(GregorianCalendar.DAY_OF_MONTH);
                        int currMnth = cal.get(GregorianCalendar.MONTH) + 1;

                        CalendarMonth currentMonth = CalendarMonth.getInstance(currMnth);
                        CalendarMonth previousMonth = currentMonth.prev();
                        String otherMonth = currentMonth.name();
                        String selectedMonth = previousMonth.name();
                        String selectedYear = null;
                        String otherYear = null;

                        if (previousMonth == CalendarMonth.JUNE) {
                            selectedYear = DateUtil.getPrevFiscalYear();
                            otherYear = DateUtil.getCurrentFiscalYear();
                        } else {
                            selectedYear = DateUtil.getCurrentFiscalYear();
                            otherYear = selectedYear;
                        }

                        String currentYear = DateUtil.getCurrentFiscalYear();

                        List<SeMonthly> sePaymentInfo = monthlyPaymentComparisonReportManager.getMonthlyPaymentInfo(districtNumber, selectedYear, selectedMonth);

                        if (sePaymentInfo == null || sePaymentInfo.isEmpty()) {
                            //replace this with a pdf report that contains an error message  
                            return displayErrorMessage(new Message("monthlyPaymentComparison", districtName, districtNumber, currentYear, otherMonth, "Missing payment record."));
                        }

                        SortedSet<SeMonthlyAdapter> sePaymentInfoAndCaluationsList = monthlyPaymentComparisonReportManager.performMonthlyPaymentCalculations(sePaymentInfo);

                        SeMonthlyAdapter sePaymentInfoAndCaluations = monthlyPaymentComparisonReportManager.getLastPayment(sePaymentInfoAndCaluationsList);

                        StateEqual seStateEqualInfo = monthlyPaymentComparisonReportManager.findLatest(districtNumber, currentYear);

                        if (seStateEqualInfo == null) {
                            //replace this with a pdf report that contains an error message  
                            return displayErrorMessage(new Message("monthlyPaymentComparison", districtName, districtNumber, currentYear, otherMonth, "Missing StateEqual record."));
                        }

                        //(SeMonthlyAdapter source, StateEqual target, String county, String districtName, String sourceMonth, String targetMonth, String sourceFiscalYear, String targetFiscalYear);
                        SeMonthlyPaymentComparisonDatasource datasource = monthlyPaymentComparisonReportManager.createSeMonthlyPaymentComparisonDatasource(sePaymentInfoAndCaluations, seStateEqualInfo, "unknown", districtName, selectedMonth, otherMonth, DateUtil.getCalendarYear(previousMonth, selectedYear), DateUtil.getCalendarYear(currentMonth, otherYear));

                        Map<String, Object> parameterMap = new HashMap<String, Object>();

                        parameterMap.put("customJRDatasource", datasource);

                        String selectedReportId = reportName + "Report" + format + "View";


                        return new ModelAndView(selectedReportId, parameterMap);
                    } else if (ReportForm.RPTYtdWithholdings.equals(report)) {
                        final String reportName = "ytdPaymentWithholding";
                        final String format = "Pdf";                       

                        String selectedYear = DateUtil.getCurrentFiscalYear();

                        String selectedMonth = CalendarMonth.getCurrentMonth().name();

                        YtdPaymentCollection paymentCollection = ytdPaymentAndWithholdingReportManager.getLastestPaymentInfo(selectedYear, selectedMonth, userInfo.getAllDistrictCodes(), userInfo.getDistrictMap());

                        paymentCollection.setFiscalYear(DateUtil.getFiscalYearFormattedShort(selectedYear));

                        paymentCollection.setCurrentMonth(selectedMonth);

                        YtdPaymentDatasource ytdPaymenstAndWithholdingsDatasource = new YtdPaymentDatasource(paymentCollection);

                        Map<String, Object> parameterMap = new HashMap<String, Object>();

                        parameterMap.put("customJRDatasource", ytdPaymenstAndWithholdingsDatasource);

                        String selectedReportId = reportName + "Report" + format + "View";

                        return new ModelAndView(selectedReportId, parameterMap);
                    } else if (ReportForm.RPTCofrPayments.equals(report)) {
                        final String reportName = "cofrsPayment";
                        final String format = "Pdf";
                                                
                        String selectedYear = reportForm.getYear();
                        
                        String selectedMonth = reportForm.getMonth();
                        
                        List<StateEqual> inputData = seCofrsPaymentReportManager.getCofrsPaymentInfo(selectedYear); //new ArrayList<StateEqual>();

//                        for (String districtNumber : userInfo.getAllDistrictCodes()) {
//                            String districtName = userInfo.getDistrictMap().get(districtNumber);
//
//                            StateEqual stateEqualRecord = seCofrsPaymentReportManager.getCofrsPaymentInfo(districtNumber, selectedYear);
//                        
//                
//                            if (stateEqualRecord == null) {
//                                 final String message = "missing state equal record!!!" ;
//                 
//                                 logger.error("skipping : " + districtNumber + " - " + districtName + " due to " + message);
//                                                                
//                                continue;
//                            }
//                
//                            inputData.add(stateEqualRecord);
//                                        
//                        }
            
                        JRDataSource datasource = seCofrsPaymentReportManager.createMonthlyPaymnetDatasource(userInfo.getDistrictMap(), selectedYear, selectedMonth, inputData);
                        
                        Map<String, Object> parameterMap = new HashMap<String, Object>();

                        parameterMap.put("customJRDatasource", datasource);

                        String selectedReportId = reportName + "Report" + format + "View";

                        return new ModelAndView(selectedReportId, parameterMap);
            
                    } else if (ReportForm.RPTMillLevy.equals(report)) {
                      final String reportName = "seMillLevySummary";
                      final String format = "Pdf";
                        
                      String selectedYear = DateUtil.getCurrentFiscalYear();
            
                      List<SeFinallMillLevySummary> dataCollection = seMillLevySummaryReportManager.createCollection(selectedYear, userInfo.getDistrictMap(), userInfo.getDistrictPrimaryCountyMap());
                        
                      JRDataSource datasource = seMillLevySummaryReportManager.createMillLevySummaryDatasource(dataCollection);
                     
                      Map<String, Object> parameterMap = new HashMap<String, Object>();

                      parameterMap.put("customJRDatasource", datasource);

                      String selectedReportId = reportName + "Report" + format + "View";

                      return new ModelAndView(selectedReportId, parameterMap);           
            
                    } else if (ReportForm.RPTElections.equals(report)) {
                      final String reportName = "election";
                      final String format = "Pdf";
                        
                      //String selectedYear = DateUtil.getCurrentFiscalYear();
                      
                       String selectedYear = reportForm.getYear();
            
                      List<ElectionInfo> dataCollection = electionReportManager.createCollection(selectedYear, userInfo.getDistrictMap(), userInfo.getDistrictPrimaryCountyMap());
                        
                      JRDataSource datasource = electionReportManager.createElectionInfoDatasource(dataCollection);
                     
                      Map<String, Object> parameterMap = new HashMap<String, Object>();

                      parameterMap.put("customJRDatasource", datasource);

                      String selectedReportId = reportName + "Report" + format + "View";

                      return new ModelAndView(selectedReportId, parameterMap);           
                                                                              
                    } else if (ReportForm.RPTTotalEntitlement.equals(report)) {
                      final String reportName = "seTotalEntitlement";
                      final String format = "Pdf";
                        
                      String selectedYear = DateUtil.getCurrentFiscalYear();
            
                      List<SeTotalEntitlement> dataCollection = totalEntitlementReportManager.createTotalEntitlementCollection(selectedYear, userInfo);
                        
                      JRDataSource datasource = totalEntitlementReportManager.createSeTotalEntitlementDatasource(dataCollection);
                     
                      Map<String, Object> parameterMap = new HashMap<String, Object>();

                      parameterMap.put("customJRDatasource", datasource);

                      String selectedReportId = reportName + "Report" + format + "View";

                      return new ModelAndView(selectedReportId, parameterMap);       
                    } else if (ReportForm.RPTNegativePayments.equals(report)) {
                      final String reportName = "seNegativePayment";
                      final String format = "Pdf";
                        
                      String selectedYear = DateUtil.getCurrentFiscalYear();
            
                      Map<Integer, List<NegativePayment>> dataCollections = negativePaymentReportManager.createNegativePaymentCollection(selectedYear, userInfo);

                      if (dataCollections != null) {
                        
                      JRDataSource datasource = negativePaymentReportManager.createNegativePaymentDatasource(dataCollections.get(2));
                     
                      Map<String, Object> parameterMap = new HashMap<String, Object>();

                      parameterMap.put("customJRDatasource", datasource);

                      String selectedReportId = reportName + "Report" + format + "View";

                      return new ModelAndView(selectedReportId, parameterMap);       
                      }
                      
                      result.rejectValue("reports", "integer", "report : " + report + " No change in entitlements detected - No payment report will be generated");
                    }
                } catch (Throwable t) {
                    logger.error("Error while generating report " + report, t);

                    result.rejectValue("reports", "integer", "report : " + report + " encountered exception durong report generation - " + t.toString());
                }
            }
        }
       

        Object[] districtCodes = null;
        //Need to account for adminUser also
        if (userInfo.isAdminUser()) {
            // For right now, we'll default to the first district
            // This needs to change to a drop-down for the admin user where they select
            // the district to work on
            districtCodes = userInfo.getAllNameNCodes().toArray();
        }

        if (districtCodes != null) {
            model.addAttribute("districtNumbers", districtCodes);
        }

        ReportForm form = reportsManager.setupForm();

        model.addAttribute("pageInfo", form);

        if (result.hasErrors()) {
            model.addAttribute("errors", result);
        }

        return new ModelAndView(".Reports-index", model.asMap());
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");

        if (INITIALIZE_DATABASE) {
            try {
                monthlyPaymentReportManager.populateTable(userInfo.getAllDistrictCodes());
            } catch (Throwable t) {
                logger.error("Attempt to load data failed!!!", t);
            }

            INITIALIZE_DATABASE = false;
        }

        return ".Reports-index";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public ModelAndView calculateAndViewReport(Model model, @RequestParam String fiscalYear, @RequestParam String fiscalMonth, @RequestParam String districtNumberAndName, @RequestParam String reportId, HttpServletRequest request) {

        System.out.println("reportId : " + reportId);
        System.out.println("Month : " + fiscalMonth);
        System.out.println("Year : " + fiscalYear);
        System.out.println("districtNumber : " + districtNumberAndName);




        String report = reportId;

        //reportGenerationValidator.validate(reportForm, result);

        //if (!result.hasErrors()) {            
        //for (String report : reportForm.getReports()) {
        try {


            if (ReportForm.RPT360.equals(report)) {
            } else if (ReportForm.RPTFundSummary.equals(report)) {
            } else if (ReportForm.RPTMonthlyPayment.equals(report)) {
                final String reportName = "stateEqualPayment";
                final String format = "Pdf";

                //String districtNumberAndName = reportForm.getRptMonthlyPaymentsDistrictNumber();
                String[] districtDetails = districtNumberAndName.split(" - ");

                String format1FiscalYear = DateUtil.getFiscalYearFormattedShort(fiscalYear);

                String format2FiscalYear = "Fy_" + fiscalYear.substring(4);

                //getMonthlyPaymentInfo(String districtNumber, String fiscalYear, String month);
                List<SeMonthly> paymentInfo = monthlyPaymentReportManager.getMonthlyPaymentInfo(districtDetails[0].trim(), fiscalYear.trim(), fiscalMonth.trim());

                //createMonthlyPaymnetDatasource(String districtNumber, String districtName, String fiscalYear, String month, List<SeMonthly> paymentInfo);
                JRDataSource datasource = monthlyPaymentReportManager.createMonthlyPaymnetDatasource(districtDetails[0].trim(), districtDetails[1].trim(), format1FiscalYear.trim(), fiscalMonth.trim(), paymentInfo);

                Map<String, Object> parameterMap = new HashMap<String, Object>();

                parameterMap.put("customJRDatasource", datasource);

                String selectedReportId = reportName + "Report" + format + "View";

                return new ModelAndView(selectedReportId, parameterMap);

            } else if (ReportForm.RPTCsiPayment.equals(report)) {
            } else if (ReportForm.RPTMonthlyComparison.equals(report)) {
                final String reportName = "monthlyPaymentComparison";
                final String format = "Pdf";

                //String districtNumberAndName = reportForm.getRptMonthlyComparisonDistrictNumber();                                                
                String[] districtDetails = districtNumberAndName.split(" - ");



                String districtNumber = districtDetails[0];
                String districtName = districtDetails[1];

                // Initialize GregorianCalendar
                GregorianCalendar cal = new GregorianCalendar();
                //int currYear = cal.get(GregorianCalendar.YEAR);
                //int currDOM = cal.get(GregorianCalendar.DAY_OF_MONTH);
                int currMnth = cal.get(GregorianCalendar.MONTH) + 1;

                CalendarMonth currentMonth = CalendarMonth.getInstance(currMnth);
                CalendarMonth previousMonth = currentMonth.prev();
                String otherMonth = currentMonth.name();
                String selectedMonth = previousMonth.name();
                String selectedYear = null;
                String otherYear = null;

                if (previousMonth == CalendarMonth.JUNE) {
                    selectedYear = DateUtil.getPrevFiscalYear();
                    otherYear = DateUtil.getCurrentFiscalYear();
                } else {
                    selectedYear = DateUtil.getCurrentFiscalYear();
                    otherYear = selectedYear;
                }

                String currentYear = DateUtil.getCurrentFiscalYear();

                List<SeMonthly> sePaymentInfo = monthlyPaymentComparisonReportManager.getMonthlyPaymentInfo(districtNumber, selectedYear, selectedMonth);

                if (sePaymentInfo == null || sePaymentInfo.isEmpty()) {
                    //replace this with a pdf report that contains an error message  
                    return displayErrorMessage(new Message("monthlyPaymentComparison", districtName, districtNumber, currentYear, otherMonth, "Missing payment record."));
                }

                SortedSet<SeMonthlyAdapter> sePaymentInfoAndCaluationsList = monthlyPaymentComparisonReportManager.performMonthlyPaymentCalculations(sePaymentInfo);

                SeMonthlyAdapter sePaymentInfoAndCaluations = monthlyPaymentComparisonReportManager.getLastPayment(sePaymentInfoAndCaluationsList);

                StateEqual seStateEqualInfo = monthlyPaymentComparisonReportManager.findLatest(districtNumber, currentYear);

                if (seStateEqualInfo == null) {

                    //String reportName, String districtName, String districtNumber, String fiscalYear, String fiscalMonth, String generalInfo
                    return displayErrorMessage(new Message("monthlyPaymentComparison", districtName, districtNumber, currentYear, otherMonth, "Missing StateEqual record."));
                }

                //(SeMonthlyAdapter source, StateEqual target, String county, String districtName, String sourceMonth, String targetMonth, String sourceFiscalYear, String targetFiscalYear);
                SeMonthlyPaymentComparisonDatasource datasource = monthlyPaymentComparisonReportManager.createSeMonthlyPaymentComparisonDatasource(sePaymentInfoAndCaluations, seStateEqualInfo, "unknown", districtName, selectedMonth, otherMonth, DateUtil.getCalendarYear(previousMonth, selectedYear), DateUtil.getCalendarYear(currentMonth, otherYear));

                Map<String, Object> parameterMap = new HashMap<String, Object>();

                parameterMap.put("customJRDatasource", datasource);

                String selectedReportId = reportName + "Report" + format + "View";

                return new ModelAndView(selectedReportId, parameterMap);
            } else if (ReportForm.RPTYtdWithholdings.equals(report)) {
                final String reportName = "ytdPaymentWithholding";
                final String format = "Pdf";

                HttpSession session = request.getSession();
                UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");

                String selectedYear = DateUtil.getCurrentFiscalYear();

                String selectedMonth = CalendarMonth.getCurrentMonth().name();

                YtdPaymentCollection paymentCollection = ytdPaymentAndWithholdingReportManager.getLastestPaymentInfo(selectedYear, selectedMonth, userInfo.getAllDistrictCodes(), userInfo.getDistrictMap());

                paymentCollection.setFiscalYear(DateUtil.getFiscalYearFormattedShort(selectedYear));

                paymentCollection.setCurrentMonth(selectedMonth);

                YtdPaymentDatasource ytdPaymenstAndWithholdingsDatasource = new YtdPaymentDatasource(paymentCollection);

                Map<String, Object> parameterMap = new HashMap<String, Object>();

                parameterMap.put("customJRDatasource", ytdPaymenstAndWithholdingsDatasource);

                String selectedReportId = reportName + "Report" + format + "View";

                return new ModelAndView(selectedReportId, parameterMap);
            } else if (ReportForm.RPTCofrPayments.equals(report)) {
            } else if (ReportForm.RPTMillLevy.equals(report)) {
            } else if (ReportForm.RPTElections.equals(report)) {
            } else if (ReportForm.RPTTotalEntitlement.equals(report)) {
            } else if (ReportForm.RPTNegativePayments.equals(report)) {
            }
        } catch (Throwable t) {
            logger.error("Error while generating report " + report, t);

            // result.reject("report : " + report + " encountered exception durong report generation - " + t.toString());
        }
        //}
        //}

        return null;
    }

    /**
     *
     * @param errorMessage
     * @return
     */
    private ModelAndView displayErrorMessage(Message errorMessage) {
        final String reportName = "error";
        final String format = "Pdf";

        Map<String, Object> parameterMap = new HashMap<String, Object>();

        parameterMap.put("customJRDatasource", new MessageDatasource(errorMessage));

        String selectedReportId = reportName + "Report" + format + "View";

        return new ModelAndView(selectedReportId, parameterMap);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id, HttpServletRequest request) {


        return "redirect:" + RequestUtils.getContextPath(request) + "/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<VData> vDatas = reportsManager.findAll(VData.class);
        model.addAttribute("vDatas", vDatas);
        return ".Reports-list";
    }
}