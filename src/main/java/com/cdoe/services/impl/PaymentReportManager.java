package com.cdoe.services.impl;

import com.cdoe.biz.model.*;
import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.biz.model.jasper.SEMonthlyPayment;
import com.cdoe.biz.model.jasper.SEMonthlyPaymentCollection;
import com.cdoe.biz.model.jasper.SEMonthlyPaymentDatasource;
import com.cdoe.biz.model.jasper.SeMonthlyAdapter;
import com.cdoe.biz.stateequal.IMonthlyPaymentsDAO;
import com.cdoe.services.impl.stateequal.ReportManagerBase;
import com.cdoe.services.stateequal.IPaymentReportManager;
import com.cdoe.util.FilenameConstructor;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.log4j.Logger;


/**
 *
 * @author Tony Ford
 */
public class PaymentReportManager extends ReportManagerBase implements IPaymentReportManager {

   
    public static class PaymentReportFilenameConstructor implements FilenameConstructor {

        private String district;
        private String month;
        private String fiscalYear;        

        /**
         *
         * @param district
         * @param month
         * @param fiscalYear
         */
        public PaymentReportFilenameConstructor(String district, String month, String fiscalYear) {
            this.district = district;
            this.month = month;
            this.fiscalYear = fiscalYear;                        
        }

        /**
         *
         * @return
         */
        public String getDistrict() {
            return district;
        }

        /**
         *
         * @return
         */
        public String getMonth() {
            return month;
        }

        /**
         *
         * @return
         */
        public String getFiscalYear() {
            return fiscalYear;
        }

        /**
         *
         * @param defaultDirectory
         * @param defaultFileName
         * @param defaultExtention
         * @return
         */
        @Override
        public String construct(String defaultDirectory, String defaultFileName, String defaultExtention) {
            String absolutePath = defaultDirectory + defaultFileName + SEPARATOR + district + "." + defaultExtention;

            return absolutePath;
        }

        /**
         *
         * @param defaultPath
         * @return
         */
        @Override
        public File construct(String defaultPath) {
            return new File(defaultPath);
        }
    }
    private static final Logger logger = Logger.getLogger(PaymentReportManager.class);    
    private static long guid = 1;
    
    
    

    /**
     *
     */
    private IMonthlyPaymentsDAO monthlyPaymentDAO;
    
    /**
     *
     */
    //private static final String SEPARATOR = "_";

    /**
     *
     */
    public PaymentReportManager() {
    }

    /**
     *
     * @param districtNumber
     * @param fiscalYear
     * @param month
     * @return
     */
    @Override
    public List<SeMonthly> getMonthlyPaymentInfo(String districtNumber, String fiscalYear, String month) {
        return monthlyPaymentDAO.findForDistrictByMonthAndYear(districtNumber, fiscalYear, FiscalMonth.getInstance(month));
    }

    /**
     *
     * @param districtNumber
     * @param districtName
     * @param fiscalYear
     * @param month
     * @param paymentInfo
     * @return
     */
    public JRDataSource createMonthlyPaymnetDatasource(String districtNumber, String districtName, String fiscalYear, String month, List<SeMonthly> paymentInfo) {
        SEMonthlyPaymentCollection collection = new SEMonthlyPaymentCollection();
        collection.setFiscalYear(fiscalYear);
        collection.setCurrentMonth(month);
        collection.setDistrictNumber(districtNumber);
        collection.setDistrictName(districtName);
        collection.setCurrentDate(new Date());

        //peform calculations
        SortedSet<SeMonthlyAdapter> paymentInfoPlusCalculations = performMonthlyPaymentCalculations(paymentInfo);

        for (SeMonthlyAdapter calculation : paymentInfoPlusCalculations) {


            SEMonthlyPayment monthlyPayment = new SEMonthlyPayment();
            monthlyPayment.setMonth(calculation.getCurrentMonth().getShortText());
            monthlyPayment.setAudit(calculation.getSeMonthly().getAuditAdj());
            monthlyPayment.setCharterDebt(calculation.getSeMonthly().getChrtAdj());
            monthlyPayment.setCsi(calculation.getSeMonthly().getCsiAdminAdj());
            monthlyPayment.setFunding(calculation.getSeMonthly().getEntitle());
            monthlyPayment.setNetPayment(calculation.getSeMonthly().getPayment());
            monthlyPayment.setPriorPayment(calculation.getPriorPayment());
            monthlyPayment.setOther(calculation.getSeMonthly().getOtherAdj());
            monthlyPayment.setSwap(calculation.getSeMonthly().getSwapAdj());
            monthlyPayment.setVariance(calculation.getVariance());
            monthlyPayment.setTotalProjectedShare(calculation.getSeMonthly().getStateEqual());
            monthlyPayment.setTotalPaidShare(calculation.getTotalPaidShare());
            monthlyPayment.setTotalRemainingShare(calculation.getTotalRemainingShare());

            collection.getMonthlyPayment().add(monthlyPayment);
        }

        JRDataSource datasource = new SEMonthlyPaymentDatasource(collection);

        return datasource;
    }

    /**
     *
     * @return
     */
    public SortedSet<SeMonthlyAdapter> performMonthlyPaymentCalculations(List<SeMonthly> paymentInfo) {
        SortedSet<SeMonthlyAdapter> data = new TreeSet<SeMonthlyAdapter>();


        for (SeMonthly payment : paymentInfo) {
            data.add(new SeMonthlyAdapter(payment));
        }

        Double previousPayment = new Double(0);
        double paidYearToDate = 0;
        for (SeMonthlyAdapter paymentAdapter : data) {
            // inlcudes the current month   
            paidYearToDate += paymentAdapter.getSeMonthly().getEntitle();

            paymentAdapter.setTotalPaidShare(paidYearToDate);

            //remaining shares
            double remainingToBePaid = paymentAdapter.getSeMonthly().getStateEqual() - paidYearToDate;

            paymentAdapter.setTotalRemainingShare(remainingToBePaid);

            if (previousPayment != null) {
                paymentAdapter.setPriorPayment(previousPayment);

                Double variance = paymentAdapter.getSeMonthly().getPayment() - previousPayment;

                paymentAdapter.setVariance(variance);
            } else {
                Double variance = paymentAdapter.getSeMonthly().getPayment() - 0;

                paymentAdapter.setVariance(variance);
            }

            //
            previousPayment = paymentAdapter.getSeMonthly().getPayment();
        }


        return data;
    }

    /**
     *
     * @param district
     * @param month
     * @param fiscalYear
     * @return
     */
    public FilenameConstructor createPaymentReportFilenameConstructor(String district, String month, String fiscalYear) {
        return new PaymentReportFilenameConstructor(district, month, fiscalYear);
    }

    /**
     *
     * @param allDistrictCodes
     */
    @SuppressWarnings("empty-statement")
    public void populateTable(List<String> allDistrictCodes) {
        //String[] allFiscalYears = {"20022003", "20032004", "20042005", "20052006", "20062007", "20072008", "20082009", "20092010", "20102011", "20112012", "20122013"};
        String[] allFiscalYears = {"20112012", "20122013"};
        double[] total_allocation = {1000000.00, 5123987.45, 22412987.15, 44567298.90, 87101734.70, 125345123.00, 567789123.10, 1234987567.67, 777888.45};
        double[] allAdjustmnets = {0.00, 500.00, 1200.00, 2345.00, 888.00, 4567.00, 127.12, 5678.00};
        double[][] allDistributions = {
            {0.1, 0.05, 0.15},
            {0.005, 0.05, 0.06, 0.1, 0.2},
            {0.07, 0.06, 0.05, 0.08, 0.09, 0.1, 0.3, 0.2},
            {0.1, 0.1, 0.2, 0.11, 0.12, 0.13, 0.14, 0.05, 0.03, 0.01}
        };
        boolean[] polarity = {true, true, false, true, false};
        double[] fcpData = {300.5, 456.5, 678.0, 1298.5, 2341.0, 4545.0, 7892.0};

        int selectAllocation = 0;
        int selectAdjustment = 0;
        int selectDistribution = 0;
        int selectPolarity = 0;
        int selectAdjustmentType = 0;
        int selectFpc = 0;

        for (String fiscalYear : allFiscalYears) {
            for (String districtNumber : allDistrictCodes) {

                if (districtNumber.startsWith("--")) {
                    continue;
                }

                double allocation = total_allocation[selectAllocation++ % total_allocation.length];
                double[] distributionList = allDistributions[selectDistribution++ % allDistributions.length];

                int selectMonth = 1;
                for (double distribution : distributionList) {
                    SeMonthly payment = new SeMonthly();

                    payment.setId(guid++);
                    payment.setFiscalYear(fiscalYear);
                    payment.setMonth(selectMonth++);
                    payment.setDistrictNumber(districtNumber);
                    payment.setVersion(1L);
                    payment.setStateEqual(allocation);


                    double entitlement = allocation * distribution;
                    payment.setEntitle(entitlement);

                    payment.setTotalAtRiskPupils(fcpData[selectFpc % fcpData.length]);
                    payment.setFpc(fcpData[selectFpc++ % fcpData.length]);
                    payment.setAssessedVal(entitlement * 2.5);
                    payment.setAdjTotalProgram(entitlement * .04);
                    payment.setPropertyTax(entitlement * .035);

                    boolean addToEntitlement = polarity[selectPolarity++ % polarity.length];

                    double adjustment = allAdjustmnets[selectAdjustment++ % allAdjustmnets.length];

                    if (addToEntitlement) {
                        payment.setPayment(adjustment + entitlement);

                        switch (selectAdjustmentType) {
                            case 0:
                                payment.setAuditAdj(adjustment);
                                break;
                            case 1:
                                payment.setChrtAdj(adjustment);
                                break;
                            case 2:
                                payment.setCsiAdminAdj(adjustment);
                                break;
                            case 3:
                                payment.setOtherAdj(adjustment);
                                break;
                            case 4:
                                payment.setSwapAdj(adjustment);
                                break;
                        }
                    } else {
                        adjustment *= -1;

                        payment.setPayment(adjustment + entitlement);

                        switch (selectAdjustmentType) {
                            case 0:
                                payment.setAuditAdj(adjustment);
                                break;
                            case 1:
                                payment.setChrtAdj(adjustment);
                                break;
                            case 2:
                                payment.setCsiAdminAdj(adjustment);
                                break;
                            case 3:
                                payment.setOtherAdj(adjustment);
                                break;
                            case 4:
                                payment.setSwapAdj(adjustment);
                                break;
                        }
                    }

                    /**
                     * SAVE CHANGES
                     */
                    this.create(payment);

                    ++selectAdjustmentType;

                    selectAdjustmentType %= 5;
                }
            }
        }
    }

    /**
     *
     * @param monthlyPaymentDAO
     */
    public void setMonthlyPaymentDAO(IMonthlyPaymentsDAO monthlyPaymentDAO) {
        this.monthlyPaymentDAO = monthlyPaymentDAO;
    }

   
}
