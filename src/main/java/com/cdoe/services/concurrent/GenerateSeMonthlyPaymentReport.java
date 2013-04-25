package com.cdoe.services.concurrent;

import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.services.stateequal.IGenerateSeMonthlyPaymentReport;
import com.cdoe.services.stateequal.IPaymentReportManager;
import com.cdoe.util.DateUtil;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;

/**
 *  <p>
 *    <b> description </b>  enter description.
 * </p>
 *
 * @author Tony Ford
 */
public class GenerateSeMonthlyPaymentReport implements IGenerateSeMonthlyPaymentReport {
    private static final Logger LOGGER = Logger.getLogger(GenerateSeMonthlyPaymentReport.class);
    
    private DefaultMonitor monitor = new DefaultMonitor();
    private IPaymentReportManager monthlyPaymentReportManager;
    private Map<String, String> districtMap;
    private String selectedMonth;
    private String selectedYear;

    /**
     * 
     */
    public GenerateSeMonthlyPaymentReport() {
     monitor.setStatus(TaskStatus.NOT_STARTED);    
     monitor.setStatusDetail("Generate State Equal Monthly Payment Report -- NOT STARTED");
     monitor.setTaskIdentifer(this.getTaskIdentifer());
    }

    public void setMonthlyPaymentReportManager(IPaymentReportManager monthlyPaymentReportManager) {
        this.monthlyPaymentReportManager = monthlyPaymentReportManager;
    }

    @Override
    public void setDistrictMap(Map<String, String> districtMap) {
        this.districtMap = districtMap;
    }

    @Override
    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    @Override
    public void setSelectedYear(String selectedYear) {
        this.selectedYear = selectedYear;
    }

    /**
     * 
     * @return 
     */
    @Override
    public TaskMonitor getMonitor() {
        return monitor;
    }

    /**
     * 
     * @return
     * @throws Exception 
     */
    @Override
    public TaskMonitor call() throws Exception {
        try {
            monitor.setStatus(TaskStatus.INPROGRESS);
            monitor.setStatusDetail("Generate State Equal Monthly Payment Report -- IN PROGRESS.");
            
            double count = 0;
            int size = districtMap.size();

            monitor.setProgress(count / size);

            for (String districtNumber : districtMap.keySet()) {
                String districtName = districtMap.get(districtNumber);

                String fiscalYear = selectedYear;

                String format1FiscalYear = DateUtil.getFiscalYearFormattedShort(fiscalYear);

                String format2FiscalYear = "Fy_" + fiscalYear.substring(4);

                //getMonthlyPaymentInfo(String districtNumber, String fiscalYear, String month);
                List<SeMonthly> paymentInfo = monthlyPaymentReportManager.getMonthlyPaymentInfo(districtNumber, fiscalYear, selectedMonth);

                //createMonthlyPaymnetDatasource(String districtNumber, String districtName, String fiscalYear, String month, List<SeMonthly> paymentInfo);
                JRDataSource datasource = monthlyPaymentReportManager.createMonthlyPaymnetDatasource(districtNumber, districtName, format1FiscalYear, selectedMonth, paymentInfo);

                //generatePaymentReport(JRDataSource datasource, String district, String fiscalYear, String  month)
                monthlyPaymentReportManager.generateReport(datasource, monthlyPaymentReportManager.createPaymentReportFilenameConstructor(districtNumber, format2FiscalYear, selectedMonth), fiscalYear, selectedMonth);

                monitor.setProgress(++count / size);

                monitor.getProgressDescription().add("proccessed : " + districtNumber + " - " + districtName);

            }
            
            monitor.setStatus(TaskStatus.SUCCESS);
            monitor.setStatusDetail("Generate State Equal Monthly Payment Report --COMPLETE");
        } catch (Throwable t) {
            monitor.setStatus(TaskStatus.FAILURE);
            monitor.setStatusDetail(t.toString());
            
            LOGGER.error("Exception occurred during generation of monthly payment reports.", t);
        }

        return this.monitor;
    }

    @Override
    public TaskIdentifer getTaskIdentifer() {
        return TaskIdentifer.MonthlyPaymentReport;
    }
}
