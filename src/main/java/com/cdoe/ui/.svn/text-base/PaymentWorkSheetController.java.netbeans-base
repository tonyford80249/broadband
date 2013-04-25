
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui;

import com.cdoe.biz.model.PaymentWorkBook;
import com.cdoe.biz.model.PaymentWorkSheet;
import com.cdoe.biz.model.PaymentWorkSheetCalculation;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.biz.model.transportation.Transportation;
import com.cdoe.services.transportation.IPaymentWorkSheetManager;
import com.cdoe.ui.form.transportation.TransportationForm;
import com.cdoe.util.PaymentWorkbookDatasource;
import com.cdoe.util.PaymentWorksheetDatasource;
import com.cdoe.util.UserInfo;
import com.resqsoft.util.RequestUtils;
import java.util.HashMap;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
@RequestMapping("/secure/PaymentWorkSheet")
public class PaymentWorkSheetController {

    private static final Logger logger = Logger.getLogger(PaymentWorkSheetController.class);
    @Autowired
    private IPaymentWorkSheetManager paymentWorkSheetManager;
    @Autowired
    private Validator transportationValidator;
    @Autowired
    MappingJacksonJsonView standardJsonView;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String districtNos = (String) session.getAttribute("districtNos");
        String districtName = (String) session.getAttribute("districtName");
        String fiscalYear = (String) session.getAttribute("fiscalYear");
        UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
        userInfo.getDistrictMap();
   

        Object[] districtCodes = userInfo.getAllDistrictCodes().toArray();

        TransportationForm form = paymentWorkSheetManager.setupForm(districtNos, districtName, fiscalYear);
        model.addAttribute("transportationForm", form);
        model.addAttribute("districtNumbers", districtCodes);
        return ".PaymentWorkSheet-index";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public ModelAndView retrieve(@RequestParam String districtNumber, @RequestParam String fiscalYear, HttpServletRequest request) {
        try {
            Map<String, Object> parameterMap = new HashMap<String, Object>();

            HttpSession session = request.getSession();

            UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");

            String districtName = userInfo.getDistrictMap().get(districtNumber);

            TransportationForm form = paymentWorkSheetManager.setupForm(districtNumber, districtName, fiscalYear);

            parameterMap.put("transportationForm", form);

            return new ModelAndView(standardJsonView, parameterMap);
        } catch (Throwable t) {
            logger.error("Exception occurred during retrieve.", t);
        } finally {
            logger.info("generating json response ");
        }

        return null;
    }

    @RequestMapping(value = "/report/paymentWorksheet.pdf", method = RequestMethod.GET)
    public ModelAndView report2(@RequestParam String districtNumber, @RequestParam String fiscalYear, HttpServletRequest request) {
        final String reportName = "paymentWorksheet";
        final String format = "Pdf";
        final String DEFAULT_INT_FORMAT = "%10d";
        final String DEFAULT_FLOAT_FORMAT = "%10.4f";
        final String DEFAULT_MONEY_FORMAT = "$ %,11.2f";
        final String DEFAULT_MILEAGE_FORMAT = "%11.1f miles";

        try {
            Map<String, Object> parameterMap = new HashMap<String, Object>();

            HttpSession session = request.getSession();

            UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");

            String districtName = userInfo.getDistrictMap().get(districtNumber);

            TransportationForm form = paymentWorkSheetManager.setupForm(districtNumber, districtName, fiscalYear);

            if (form.getValid()) {
                PaymentWorkSheet paymnetWorkSheet = new PaymentWorkSheet();
                paymnetWorkSheet.setDistrictName(districtName);
                paymnetWorkSheet.setDistrictNumber(districtNumber);
                paymnetWorkSheet.setFiscalYear(fiscalYear);
                paymnetWorkSheet.setCounty("<unknown>");
                paymnetWorkSheet.setPupilCount(form.getPupilTran());
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.totalExpenditures", null, Locale.US), form.getOperTran(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.capitalOutlayExclusion", null, Locale.US), form.getCapOutTran(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.netOperatingExpendures", null, Locale.US), form.getNetCurrentOperExpend(), DEFAULT_MONEY_FORMAT));
                //paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.mileageTraveledForMigrants", null, Locale.US), form.getMigMiles(), DEFAULT_MILEAGE_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.regularMileageTraveled", null, Locale.US), form.getRegDMiles(), DEFAULT_MILEAGE_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.daysOfSchool", null, Locale.US), form.getSchoolDays(), DEFAULT_INT_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.regularEducationMileage", null, Locale.US), form.getRegMiles(), DEFAULT_MILEAGE_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.reimbursableMileage", null, Locale.US), form.getTotalReimMileage(), DEFAULT_MILEAGE_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.mileageEntitlement", null, Locale.US), form.getMileageEntitlement(), DEFAULT_MILEAGE_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.excessCosts", null, Locale.US), form.getExCosts(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.excessCostsEntitlement", null, Locale.US), form.getExReim(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.excessCostPlusMileage", null, Locale.US), form.getMileageEntitlement(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.maximumReimbursement", null, Locale.US), form.getMaxReimEntitlement(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.calculatedReimbursement", null, Locale.US), form.getReimTran(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.previousYearsCalculatedReimbursement", null, Locale.US), form.getReimTranLy(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.reimbursementNotIncludingFinancialAid", null, Locale.US), form.getReimEntitlement(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.roomAndBoardFinancialAid", null, Locale.US), form.getBoardTran(), DEFAULT_INT_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.reimbursementEntitlement", null, Locale.US), form.getTotalReimEntitlement(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.advanceReimbursement", null, Locale.US), form.getAdvPayLy(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.finalReimbursement", null, Locale.US), form.getFinalReimEntitlement(), DEFAULT_MONEY_FORMAT));                
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.finalReimbursementProrated", null, Locale.US), form.getFinalReimProrated(), DEFAULT_MONEY_FORMAT));                
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.additionalReimursements", null, Locale.US), form.getDesegReim(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.totalPayment", null, Locale.US), form.getDistrictDistribution(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.actualMilesTraveled", null, Locale.US), form.getActMiles(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.totalActualMilesTraveled", null, Locale.US), form.getTotalMiles(), DEFAULT_MONEY_FORMAT));


                // validate(paymnetWorkSheet);

                PaymentWorksheetDatasource datasource = new PaymentWorksheetDatasource(paymnetWorkSheet);

                parameterMap.put("customJRDatasource", datasource);
            }
            else {
              PaymentWorkSheet paymnetWorkSheet = new PaymentWorkSheet();
                paymnetWorkSheet.setDistrictName(districtName);
                paymnetWorkSheet.setDistrictNumber(districtNumber);
                paymnetWorkSheet.setFiscalYear(fiscalYear);
                paymnetWorkSheet.setCounty("<unknown>");  
                
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation("NO DATA!!!", new Double(0.0), DEFAULT_MONEY_FORMAT));
                
                PaymentWorksheetDatasource datasource = new PaymentWorksheetDatasource(paymnetWorkSheet);

                parameterMap.put("customJRDatasource", datasource);
            }

            String reportId = reportName + "Report" + format + "View";
            return new ModelAndView(reportId, parameterMap);
        } catch (Throwable t) {
            logger.error("Exception occurred during retrieve.", t);
        } finally {
            logger.info("generating json response ");
        }

        return null;

    }

    @RequestMapping(value = "/report/allPaymentWorksheets.pdf", method = RequestMethod.GET)
    public ModelAndView report3(@RequestParam String fiscalYear, HttpServletRequest request) {
        final String reportName = "allpaymentWorksheet";
        final String format = "Pdf";
        final String DEFAULT_INT_FORMAT = "%10d";
        final String DEFAULT_FLOAT_FORMAT = "%10.4f";
        final String DEFAULT_MONEY_FORMAT = "$ %,11.2f";
        final String DEFAULT_MILEAGE_FORMAT = "%11.1f miles";

        try {
            Map<String, Object> parameterMap = new HashMap<String, Object>();

            HttpSession session = request.getSession();

            UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
            
            PaymentWorkBook workbook = new PaymentWorkBook();

            for (String districtNumber : userInfo.getAllDistrictCodes()) {

                //account for the blank in the district number list
                if ("".equals(districtNumber.trim())) {
                 continue;  
                }
                
                String districtName = userInfo.getDistrictMap().get(districtNumber);

                TransportationForm form = paymentWorkSheetManager.setupForm(districtNumber, districtName, fiscalYear);

                if (form.getValid()) {
                    PaymentWorkSheet paymnetWorkSheet = new PaymentWorkSheet();
                    paymnetWorkSheet.setDistrictName(districtName);
                    paymnetWorkSheet.setDistrictNumber(districtNumber);
                    paymnetWorkSheet.setFiscalYear(fiscalYear);
                    paymnetWorkSheet.setCounty("<unknown>");
                    paymnetWorkSheet.setPupilCount(form.getPupilTran());
                    paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.totalExpenditures", null, Locale.US), form.getOperTran(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.capitalOutlayExclusion", null, Locale.US), form.getCapOutTran(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.netOperatingExpendures", null, Locale.US), form.getNetCurrentOperExpend(), DEFAULT_MONEY_FORMAT));
                //paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.mileageTraveledForMigrants", null, Locale.US), form.getMigMiles(), DEFAULT_MILEAGE_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.regularMileageTraveled", null, Locale.US), form.getRegDMiles(), DEFAULT_MILEAGE_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.daysOfSchool", null, Locale.US), form.getSchoolDays(), DEFAULT_INT_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.regularEducationMileage", null, Locale.US), form.getRegMiles(), DEFAULT_MILEAGE_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.reimbursableMileage", null, Locale.US), form.getTotalReimMileage(), DEFAULT_MILEAGE_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.mileageEntitlement", null, Locale.US), form.getMileageEntitlement(), DEFAULT_MILEAGE_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.excessCosts", null, Locale.US), form.getExCosts(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.excessCostsEntitlement", null, Locale.US), form.getExReim(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.excessCostPlusMileage", null, Locale.US), form.getMileageEntitlement(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.maximumReimbursement", null, Locale.US), form.getMaxReimEntitlement(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.calculatedReimbursement", null, Locale.US), form.getReimTran(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.previousYearsCalculatedReimbursement", null, Locale.US), form.getReimTranLy(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.reimbursementNotIncludingFinancialAid", null, Locale.US), form.getReimEntitlement(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.roomAndBoardFinancialAid", null, Locale.US), form.getBoardTran(), DEFAULT_INT_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.reimbursementEntitlement", null, Locale.US), form.getTotalReimEntitlement(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.advanceReimbursement", null, Locale.US), form.getAdvPayLy(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.finalReimbursement", null, Locale.US), form.getFinalReimEntitlement(), DEFAULT_MONEY_FORMAT));                
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.finalReimbursementProrated", null, Locale.US), form.getFinalReimProrated(), DEFAULT_MONEY_FORMAT));                
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.additionalReimursements", null, Locale.US), form.getDesegReim(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.totalPayment", null, Locale.US), form.getDistrictDistribution(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.actualMilesTraveled", null, Locale.US), form.getActMiles(), DEFAULT_MONEY_FORMAT));
                paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation(messageSource.getMessage("Jasper.Report.PaymentWorksheet.totalActualMilesTraveled", null, Locale.US), form.getTotalMiles(), DEFAULT_MONEY_FORMAT));


                    //validate(paymnetWorkSheet);
                    
                    workbook.getSheets().add(paymnetWorkSheet);
                                        
                }
//                else {
//                     PaymentWorkSheet paymnetWorkSheet = new PaymentWorkSheet();
//                     paymnetWorkSheet.setDistrictName(districtName);
//                     paymnetWorkSheet.setDistrictNumber(districtNumber);
//                     paymnetWorkSheet.setFiscalYear(fiscalYear);
//                     paymnetWorkSheet.setCounty("<unknown>");  
//                
//                     paymnetWorkSheet.getCalculations().add(new PaymentWorkSheetCalculation("NO DATA!!!", new Double(0.0), DEFAULT_MONEY_FORMAT));
//                     
//                      validate(paymnetWorkSheet);
//                
//                     workbook.getSheets().add(paymnetWorkSheet);                     
//                }
            }
            
            PaymentWorkbookDatasource datasource = new PaymentWorkbookDatasource(workbook);
            
            parameterMap.put("customJRDatasource", datasource);
                    
            String reportId = reportName + "Report" + format + "View";
            return new ModelAndView(reportId, parameterMap);
        } catch (Throwable t) {
            logger.error("Exception occurred during retrieve.", t);
        } finally {
            logger.info("generating json response ");
        }

        return null;

    }

    /**
     *
     * @param paymentWorkSheet
     */
    private void validate(PaymentWorkSheet paymnetWorkSheet) {
        List<PaymentWorkSheetCalculation> eachCalculation = paymnetWorkSheet.getCalculations();
        for (PaymentWorkSheetCalculation calc : eachCalculation) {
            try {
                System.out.println("validate title : " + calc.getTitle() + " value : " + calc.getValue() + " type : " +  (calc.getValue() != null ? calc.getValue().getClass().getSimpleName() : ""));
                calc.getFormattedValue();
            } catch (Throwable t) {
                t.printStackTrace(System.out);
            }

        }
    }
}