package com.cdoe.services.impl;

import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.jasper.SeMonthlyAdapter;
import com.cdoe.biz.model.jasper.SeMonthlyPaymentComparison;
import com.cdoe.biz.model.jasper.SeMonthlyPaymentComparisonCalculation;
import com.cdoe.biz.model.jasper.SeMonthlyPaymentComparisonDatasource;
import com.cdoe.biz.stateequal.IStateEqualDAO;
import com.cdoe.services.stateequal.IMonthlyPaymentComparisonReportManager;
import com.cdoe.util.CalendarMonth;
import com.cdoe.util.FilenameConstructor;
import java.io.File;
import java.util.SortedSet;

/**
 *
 * @author Tony Ford
 */
public class MonthlyPaymentComparisonReportManager extends PaymentReportManager implements IMonthlyPaymentComparisonReportManager{
 public static class MonthlyComparisonFilenameConstructor implements FilenameConstructor {
        private static final String SEPARATOR = "_";
        
        private String districtName;
        private String sourceMonth;
        private String targetMonth;
        private String fiscalYear;

        public MonthlyComparisonFilenameConstructor(String districtName, String sourceMonth, String targetMonth, String fiscalYear) {
            this.districtName = districtName;
            this.sourceMonth = sourceMonth;
            this.targetMonth = targetMonth;
            this.fiscalYear = fiscalYear;
        }

        public String getDistrictName() {
            return districtName;
        }

        public String getSourceMonth() {
            return sourceMonth;
        }

        public String getTargetMonth() {
            return targetMonth;
        }

        public String getFiscalYear() {
            return fiscalYear;
        }
        
        @Override
        public String construct(String defaultDirectory, String defaultFileName, String defaultExtention) {
         return defaultDirectory + defaultFileName + SEPARATOR +  this.districtName + "." + defaultExtention;
        }

        @Override
        public File construct(String defaultPath) {
           return new File(defaultPath);
        }
     
 }   
 
 /**
  * 
  */
 private IStateEqualDAO stateEqualDAO;

    /**
     * 
     */
    public MonthlyPaymentComparisonReportManager() {
    }
    
    /**
     * 
     * @param districtCode
     * @param fiscalYear
     * @return 
     */
    @Override
 public StateEqual findLatest(String districtCode, String fiscalYear) {
  return stateEqualDAO.findLatest(districtCode, fiscalYear);   
 }   
    
      @Override
 public StateEqual getLatest(String districtCode, String fiscalYear) {
  return stateEqualDAO.findLatest(districtCode, fiscalYear);   
 }     
 
 
 /**
  * 
  * @param source
  * @param target
  * @param county
  * @param districtName
  * @param sourceMonth
  * @param targetMonth
  * @param fiscalYear
  * @return 
  */
    @Override
 public SeMonthlyPaymentComparisonDatasource createSeMonthlyPaymentComparisonDatasource(SeMonthlyAdapter source, StateEqual target, String county, String districtName, String sourceMonth, String targetMonth, String sourceFiscalYear, String targetFiscalYear) {
       final String REGULAR_TYPE = "%10d";
      final String FLOATING_TYPE = "%10.4f";
      final String MONEY_TYPE = "$ %,11.2f";
      final String MILEAGE_TYPE = "%11.1f miles";
      final String COUNT_TYPE = "%11.1f";
      
      SeMonthlyPaymentComparison comparison = new SeMonthlyPaymentComparison();
      comparison.setCounty(county);
      comparison.setDistrictName(districtName);
      comparison.setFiscalMonth1(sourceMonth);
      comparison.setFiscalYear1(sourceFiscalYear);
      comparison.setFiscalYear2(targetFiscalYear);
      comparison.setFiscalMonth2(targetMonth);
      
      Double sourceDivideBy = null;
      Double targetDivedBy = null;
      
      switch(CalendarMonth.getInstance(sourceMonth)) {
          case JANUARY :
          case FEBRUARY :
          case MARCH :
          case APRIL :
          case MAY :
          case JUNE : sourceDivideBy = 6.0;
               break;
          case JULY :
          case AUGUST :
          case SEPTEMBER :
          case OCTOBER :
          case NOVEMBER :
          case DECEMBER : sourceDivideBy = 12.0;
              break;
      }
      
      switch(CalendarMonth.getInstance(targetMonth)) {
          case JANUARY :
          case FEBRUARY :
          case MARCH :
          case APRIL :
          case MAY :
          case JUNE : targetDivedBy = 6.0;
               break;
          case JULY :
          case AUGUST :
          case SEPTEMBER :
          case OCTOBER :
          case NOVEMBER :
          case DECEMBER : targetDivedBy = 12.0;
              break;
      }
      
      
      SeMonthlyPaymentComparisonCalculation line1 = new SeMonthlyPaymentComparisonCalculation("Funded Pupil Count", source.getSeMonthly().getFpc(),COUNT_TYPE, target.getFundedPupilCount(),COUNT_TYPE);
      SeMonthlyPaymentComparisonCalculation line2 = new SeMonthlyPaymentComparisonCalculation("Total At-Risk Pupils",source.getSeMonthly().getTotalAtRiskPupils(),COUNT_TYPE, target.getFundedAtRiskCount(),COUNT_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank1 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank1.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      
      SeMonthlyPaymentComparisonCalculation line3 = new SeMonthlyPaymentComparisonCalculation("Total Program Funding",source.getSeMonthly().getAdjTotalProgram(),MONEY_TYPE,target.getAdjDistrictTotalProgram(),MONEY_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank2 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank2.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      
      SeMonthlyPaymentComparisonCalculation line4 = new SeMonthlyPaymentComparisonCalculation("Assessed Valuation",source.getSeMonthly().getAssessedVal(),MONEY_TYPE, target.getAssessedVal(),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line5 = new SeMonthlyPaymentComparisonCalculation("Total Program Mill Levy",source.getSeMonthly().getMillLevy(),MONEY_TYPE, target.getCertCatBuyMillLevy(),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line6 = new SeMonthlyPaymentComparisonCalculation("Property Tax Revenues",source.getSeMonthly().getPropertyTax(),MONEY_TYPE, target.getPropertyTax(),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line7 = new SeMonthlyPaymentComparisonCalculation("Specific Ownership Tax",source.getSeMonthly().getSpecOwnTax(),MONEY_TYPE, target.getSotNet(),MONEY_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank3 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank3.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      
      SeMonthlyPaymentComparisonCalculation line8 = new SeMonthlyPaymentComparisonCalculation("Annual State Share",source.getSeMonthly().getStateEqual(),MONEY_TYPE, target.getStateEqual(),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line9 = new SeMonthlyPaymentComparisonCalculation("Divide By",sourceDivideBy,COUNT_TYPE,targetDivedBy,COUNT_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank4 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank4.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total1 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total1.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      SeMonthlyPaymentComparisonCalculation line10 = null;
      SeMonthlyPaymentComparisonCalculation line11 = null;
      if (targetMonth.toLowerCase().startsWith("dec") || targetMonth.toLowerCase().startsWith("jun")) {
        line10 = new SeMonthlyPaymentComparisonCalculation("Year-to-date State Share to be Paid",source.getTotalRemainingShare(),MONEY_TYPE,target.getYtdEntitle(),MONEY_TYPE);
        line11 = new SeMonthlyPaymentComparisonCalculation("Year-to-date State Share Already Paid",source.getTotalPaidShare(),MONEY_TYPE,target.getYtdPayment(),MONEY_TYPE);   
      }
      else {
        line10 = new SeMonthlyPaymentComparisonCalculation("Year-to-date State Share to be Paid",null,null,null,null);
        line11 = new SeMonthlyPaymentComparisonCalculation("Year-to-date State Share Already Paid",null,null,null,null);
      }
        
      //SeMonthlyPaymentComparisonCalculation blank5 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank5.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total2 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total2.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      SeMonthlyPaymentComparisonCalculation line12 =  new SeMonthlyPaymentComparisonCalculation("Gross State Share Payment",source.getSeMonthly().getEntitle(),MONEY_TYPE, target.getMonthEntitle(),MONEY_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank6 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank6.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      
      SeMonthlyPaymentComparisonCalculation line13 = new SeMonthlyPaymentComparisonCalculation("Per Pupil Operating Revenues (PPOR)",new Double(6540.88),MONEY_TYPE,new Double(6540.88),MONEY_TYPE);
      //SeMonthlyPaymentComparisonCalculation blank7 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank7.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total3 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total3.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
//      SeMonthlyPaymentComparisonCalculation line14 = new SeMonthlyPaymentComparisonCalculation("Annual OODS Withholding",new Double(0.00),MONEY_TYPE,new Double(0.00),MONEY_TYPE);
//      SeMonthlyPaymentComparisonCalculation line15 = new SeMonthlyPaymentComparisonCalculation("Divide By",new Double(0),COUNT_TYPE,new Double(0),COUNT_TYPE);
//      // SeMonthlyPaymentComparisonCalculation blank8 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
//      //blank8.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
//      SeMonthlyPaymentComparisonCalculation total4 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
//      total4.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
//      
//      SeMonthlyPaymentComparisonCalculation line16 = new SeMonthlyPaymentComparisonCalculation("Year-to-date OODS to be Withheld",null,null,null,null);
//      SeMonthlyPaymentComparisonCalculation line17 = new SeMonthlyPaymentComparisonCalculation("Year-to-date Already Withheld",null,null,null,null);
//      // SeMonthlyPaymentComparisonCalculation blank9 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
//      //blank9.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
//      SeMonthlyPaymentComparisonCalculation total5 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
//      total5.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      //SeMonthlyPaymentComparisonCalculation line18 = new SeMonthlyPaymentComparisonCalculation("OODS Monthly Withholding",new Double(0.00),MONEY_TYPE,new Double(0.00),MONEY_TYPE);
      // SeMonthlyPaymentComparisonCalculation blank10 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank10.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      
      SeMonthlyPaymentComparisonCalculation line19 = new SeMonthlyPaymentComparisonCalculation("Other Adjustments",null,null,null,null);
      line19.setFormatCode(SeMonthlyPaymentComparisonCalculation.HEADER_LINE);
   
      
      SeMonthlyPaymentComparisonCalculation line20 = new SeMonthlyPaymentComparisonCalculation("SWAP Withholding",source.getSeMonthly().getSwapAdj(),MONEY_TYPE, target.getAdjSwap(),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line21 = new SeMonthlyPaymentComparisonCalculation("Charter School Debt Withholding",source.getSeMonthly().getChrtAdj(),MONEY_TYPE,target.getCharterDebtMonth(),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line22 = new SeMonthlyPaymentComparisonCalculation("Audit Repayments",source.getSeMonthly().getAuditAdj(),MONEY_TYPE,target.getMonthAuditRepay(),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line23 = new SeMonthlyPaymentComparisonCalculation("Charter School Institute",source.getSeMonthly().getCsiAdminAdj(),MONEY_TYPE,target.getCsiAdminMonth(),MONEY_TYPE);
      SeMonthlyPaymentComparisonCalculation line24 = new SeMonthlyPaymentComparisonCalculation("Other (Rescissions)",source.getSeMonthly().getOtherAdj(),MONEY_TYPE, target.getAdjOther(),MONEY_TYPE);
     //  SeMonthlyPaymentComparisonCalculation blank11 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank11.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total8 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total8.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      Double sourceTotalAdj = computeTotalAdjustment(source);
      Double targetTotalAdj = computeTotalAdjustment(target);
      
      SeMonthlyPaymentComparisonCalculation line25 = new SeMonthlyPaymentComparisonCalculation("Total Adjustments",sourceTotalAdj,MONEY_TYPE, targetTotalAdj,MONEY_TYPE);
      // SeMonthlyPaymentComparisonCalculation blank12 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      //blank12.setFormatCode(SeMonthlyPaymentComparisonCalculation.BLANK_LINE);
      SeMonthlyPaymentComparisonCalculation total9 = new SeMonthlyPaymentComparisonCalculation(null,null,null,null,null);
      total9.setFormatCode(SeMonthlyPaymentComparisonCalculation.TOTAL_LINE);
      
      SeMonthlyPaymentComparisonCalculation line26 = new SeMonthlyPaymentComparisonCalculation("Net State Share (Payment Amount)",source.getSeMonthly().getPayment(),MONEY_TYPE,new Double(target.getMonthEntitle() + targetTotalAdj),MONEY_TYPE);
      line26.setFormatCode(SeMonthlyPaymentComparisonCalculation.UNDER_LINE);
      
      comparison.getCalcuation().add(line1);
      comparison.getCalcuation().add(line2);
      //comparison.getCalcuation().add(blank1);
      comparison.getCalcuation().add(line3);
      //comparison.getCalcuation().add(blank2);
      comparison.getCalcuation().add(line4);
      comparison.getCalcuation().add(line5);
      comparison.getCalcuation().add(line6);
      comparison.getCalcuation().add(line7);
      //comparison.getCalcuation().add(blank3);
      comparison.getCalcuation().add(line8);
      comparison.getCalcuation().add(line9);
      //comparison.getCalcuation().add(blank4);
      comparison.getCalcuation().add(total1);
      comparison.getCalcuation().add(line10);
      comparison.getCalcuation().add(line11);
      //comparison.getCalcuation().add(blank5);
      comparison.getCalcuation().add(total2);
      comparison.getCalcuation().add(line12);
      //comparison.getCalcuation().add(blank6);      
      comparison.getCalcuation().add(line13);
      //comparison.getCalcuation().add(blank7);
      comparison.getCalcuation().add(total3);
      //comparison.getCalcuation().add(line14);
      //comparison.getCalcuation().add(line15);
      //comparison.getCalcuation().add(blank8);
      //comparison.getCalcuation().add(total4);
      //comparison.getCalcuation().add(line16);
      //comparison.getCalcuation().add(line17);
      //comparison.getCalcuation().add(blank9);
      //comparison.getCalcuation().add(total5);
      //comparison.getCalcuation().add(line18);
      //comparison.getCalcuation().add(blank10);      
      comparison.getCalcuation().add(line19);
      comparison.getCalcuation().add(line20);
      comparison.getCalcuation().add(line21);
      comparison.getCalcuation().add(line22);
      comparison.getCalcuation().add(line23);
      comparison.getCalcuation().add(line24);
      //comparison.getCalcuation().add(blank11);
      comparison.getCalcuation().add(total8);
      comparison.getCalcuation().add(line25);
      //comparison.getCalcuation().add(blank12);
      comparison.getCalcuation().add(total9);
      comparison.getCalcuation().add(line26);          

  return new SeMonthlyPaymentComparisonDatasource(comparison);   
 }   
 
 /**
  * 
  * @param source
  * @return 
  */
    @Override
 public Double computeTotalAdjustment(SeMonthlyAdapter source) {
   double total = 0.0;
   if (source.getSeMonthly().getSwapAdj() != null) {
   total += source.getSeMonthly().getSwapAdj();
   }
   if (source.getSeMonthly().getChrtAdj() != null) {
   total +=  source.getSeMonthly().getChrtAdj();
   }
   if (source.getSeMonthly().getCsiAdminAdj() != null) {
   total +=  source.getSeMonthly().getCsiAdminAdj();
   }
   if (source.getSeMonthly().getAuditAdj() != null) {
   total +=  source.getSeMonthly().getAuditAdj();
   }
   if (source.getSeMonthly().getOtherAdj() != null)  {
   total +=  source.getSeMonthly().getOtherAdj();
   }
   
  return new Double(total);   
 }
 
 /**
  * 
  * @param target
  * @return 
  */
    @Override
 public Double computeTotalAdjustment(StateEqual target) {
   double total = 0.0;
   
   if (target.getAdjSwap() != null) {       
    total += target.getAdjSwap();
   }
   if (target.getCharterDebtMonth() != null) {
    total +=  target.getCharterDebtMonth();
   }
   if (target.getCsiAdminMonth() != null) {
    total +=  target.getCsiAdminMonth();
   }
   if (target.getMonthAuditRepay() != null) {
    total +=  target.getMonthAuditRepay();
   }
   if (target.getAdjOther() != null) {
    total +=  target.getAdjOther();
   }
   
  return new Double(total);      
 }

    

    /**
     * 
     * @param sePaymentInfoAndCaluations
     * @return 
     */
    @Override
    public SeMonthlyAdapter getLastPayment(SortedSet<SeMonthlyAdapter> sePaymentInfoAndCaluations) {
     SeMonthlyAdapter lastPayment = null;
     
     for (SeMonthlyAdapter payment : sePaymentInfoAndCaluations) {
      if (lastPayment == null || lastPayment.getCurrentMonth().ordinal() < payment.getCurrentMonth().ordinal()) {
       lastPayment = payment;   
      }
     }  
     
     return lastPayment;   
    }
    
    /**
     * 
     * @param districtName
     * @param sourceMonth
     * @param targetMonth
     * @param fiscalYear
     * @return 
     */
    public FilenameConstructor createPaymentComparisonReportFilenameConstructor(String districtName, String sourceMonth, String targetMonth, String fiscalYear) {
     return new MonthlyComparisonFilenameConstructor(districtName, sourceMonth, targetMonth, fiscalYear);   
    }
    
    /**
     * 
     * @param stateEqualDAO 
     */
    public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
        this.stateEqualDAO = stateEqualDAO;
    }
    
    
}
