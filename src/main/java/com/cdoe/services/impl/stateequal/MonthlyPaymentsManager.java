
package com.cdoe.services.impl.stateequal;

import com.cdoe.biz.IGeneratedReportDao;
import java.util.List;

import org.apache.log4j.Logger;

import com.cdoe.services.impl.BaseManager;
import com.cdoe.services.stateequal.IMonthlyPaymentsManager;
import com.cdoe.biz.model.*;
import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.biz.stateequal.IMonthlyPaymentsDAO;
import com.cdoe.ui.form.stateequal.SeMonthlyPaymentProcessingForm;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;
import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.core.io.Resource;

public class MonthlyPaymentsManager extends BaseManager implements IMonthlyPaymentsManager {

        private static final Logger LOGGER = Logger.getLogger(MonthlyPaymentsManager.class);
	
	private IMonthlyPaymentsDAO monthlyPaymentsDAO;
        
        private IGeneratedReportDao generatedReportDao;
        
        private Resource uploadInputFolder;
        
        private static final String REPORT_TYPE = "actualCofrsPaymentUpload";
        
        	
	public void saveOrUpdate(SeMonthlyPaymentProcessingForm form) {
                /*
		long id = form.getId();
		District obj = findById(District.class, id); 
		if (obj == null) {
			obj = new District();
		}
		obj.setCode(form.getCode());
		obj.setName(form.getName());
		obj.setYear(form.getYear());
                * */
		saveOrUpdate(null);
	}
	
        @Override
	public SeMonthlyPaymentProcessingForm setupForm( UserInfo userInfo) {
		SeMonthlyPaymentProcessingForm form = new SeMonthlyPaymentProcessingForm();
                
                Set<Entry<String, String>> districtList =  userInfo.getDistrictMap().entrySet();                                    
                 
                
                List<SeMonthly> seMonthlyPayments = monthlyPaymentsDAO.findByMonthAndYear(DateUtil.getCurrentFiscalYear(), FiscalMonth.getCurrentMonth());
                
                Map<String,SeMonthly> monthlyPaymentProcessingMap = new HashMap<String,SeMonthly>();
                for (SeMonthly seMonthly : seMonthlyPayments) {
                 monthlyPaymentProcessingMap.put(seMonthly.getDistrictNumber(), seMonthly);   
                }
                
                  /**
                 * Gather information in order to determine if cofr payment has been sent.
                 */
                Map<String,SeMonthly> paymentHistorygMap = new HashMap<String,SeMonthly>();
                 
                List<GeneratedReport> actualCofrPayments = generatedReportDao.getReportByGrouping(DateUtil.getCurrentFiscalYear(), FiscalMonth.getCurrentMonth().getText(), REPORT_TYPE);
                
                if (actualCofrPayments != null && !actualCofrPayments.isEmpty()) {
                 for (GeneratedReport actualCofrPaymentReport : actualCofrPayments) {
                  // the url should contain the district number (uri) universal resource idenitifer   
                  paymentHistorygMap.put(actualCofrPaymentReport.getUrl(),monthlyPaymentProcessingMap.get(actualCofrPaymentReport.getUrl()));  
                 }
                }
                
                /**
                 * 
                 */
                for (String districtCode:  userInfo.getAllDistrictCodes()) {               
                                    
                  if (paymentHistorygMap.containsKey(districtCode)) {
                   //cofr payment has been sent.   
                   String districtName =  userInfo.getDistrictMap().get(districtCode);   
                   Payee payee = new Payee(districtName, districtCode);
                   
                   form.getApprovedPayees().add(payee);   
                  }                 
                  else if (monthlyPaymentProcessingMap.containsKey(districtCode)) {
                   String districtName =  userInfo.getDistrictMap().get(districtCode);   
                   Payee payee = new Payee(districtName, districtCode);
                                    
                   form.getCandidatePayees().add(payee);
                  }
                  else {
                   String districtName =  userInfo.getDistrictMap().get(districtCode);   
                   Payee payee = new Payee(districtName, districtCode);
                                    
                   form.getMissingPayees().add(payee);   
                  }
                }
                
                 List<String> allMonths = DateUtil.getFullMonthList(false);                                  
                 
                 List<String> availableYears = DateUtil.getLongFiscalYears(-10);
                 
                 Collections.sort(availableYears);
                
                 for (String month : allMonths) {
                  form.getAvailableMonths().add(month);
                 }

                 for (String year : availableYears) {
                   form.getAvailableYears().put(year, DateUtil.getFiscalYearFormattedShort(year));
                 }
        
		return form;
	}
	
        @Override
	public SeMonthlyPaymentProcessingForm setupForm( UserInfo userInfo, String fiscalYear, String fiscalMonth) {
		SeMonthlyPaymentProcessingForm form = new SeMonthlyPaymentProcessingForm();
                
                Set<Entry<String, String>> districtList =  userInfo.getDistrictMap().entrySet();                                    
                 
                
                List<SeMonthly> seMonthlyPayments = monthlyPaymentsDAO.findByMonthAndYear(fiscalYear, FiscalMonth.getInstance(fiscalMonth));
                
                Map<String,SeMonthly> monthlyPaymentProcessingMap = new HashMap<String,SeMonthly>();
                for (SeMonthly seMonthly : seMonthlyPayments) {
                 monthlyPaymentProcessingMap.put(seMonthly.getDistrictNumber(), seMonthly);   
                }
                
                
                /**
                 * Gather information in order to determine if cofr payment has been sent.
                 */
                Map<String,SeMonthly> paymentHistorygMap = new HashMap<String,SeMonthly>();
                 
                List<GeneratedReport> actualCofrPayments = generatedReportDao.getReportByGrouping(fiscalYear, fiscalMonth, REPORT_TYPE);
                
                if (actualCofrPayments != null && !actualCofrPayments.isEmpty()) {
                 for (GeneratedReport actualCofrPaymentReport : actualCofrPayments) {
                  // the url should contain the district number (uri) universal resource idenitifer   
                  paymentHistorygMap.put(actualCofrPaymentReport.getUrl(),monthlyPaymentProcessingMap.get(actualCofrPaymentReport.getUrl()));  
                 }
                }
                
                
                /**
                 * 
                 */
                for (String districtCode:  userInfo.getAllDistrictCodes()) {               
                  if (paymentHistorygMap.containsKey(districtCode)) {
                   //cofr payment has been sent.   
                   String districtName =  userInfo.getDistrictMap().get(districtCode);   
                   Payee payee = new Payee(districtName, districtCode);
                   
                   form.getApprovedPayees().add(payee);   
                  }                 
                  else if (monthlyPaymentProcessingMap.containsKey(districtCode)) {
                   //payment processing has been run.   
                   String districtName =  userInfo.getDistrictMap().get(districtCode);   
                   Payee payee = new Payee(districtName, districtCode);
                                    
                   form.getCandidatePayees().add(payee);
                  }  else {
                   String districtName =  userInfo.getDistrictMap().get(districtCode);   
                   Payee payee = new Payee(districtName, districtCode);
                                    
                   form.getMissingPayees().add(payee);   
                  }                
                }
                
                 List<String> allMonths = DateUtil.getFullMonthList(false);                                  
                 
                 List<String> availableYears = DateUtil.getLongFiscalYears(-10);
                 
                 Collections.sort(availableYears);
                
                 for (String month : allMonths) {
                  form.getAvailableMonths().add(month);
                 }

                 for (String year : availableYears) {
                   form.getAvailableYears().put(year, DateUtil.getFiscalYearFormattedShort(year));
                 }
        
		return form;
	}
        
        /**
         * 
         * @param districsToBePaid
         * @param fiscalYear
         * @param fiscalMonth 
         */
        public void uploadPayment(Map<String, String> districsToBePaid, String fiscalYear, String fiscalMonth) {
          try {  
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
            
            for (String districtNumber : districsToBePaid.keySet()) {
              String document = createPaymentDocument(districtNumber, fiscalYear, fiscalMonth);
            
              String uploadFilename = createUploadFilename(fiscalMonth, districtNumber);
                      
              File outFile = new File(inbox, uploadFilename);//fiscalMonth + "PaymentFor" + districtNumber + ".cofr");
                
              if (document != null && !outFile.exists()) {                                
                 
                 PrintWriter documentBuilder = new PrintWriter(outFile);   
                 
                 documentBuilder.println(document);
                 
                 documentBuilder.flush();
                 
                 documentBuilder.close();
                 
                 GeneratedReport generatedReport = new GeneratedReport(uploadFilename,districtNumber, outFile.getAbsolutePath(), fiscalYear, fiscalMonth, REPORT_TYPE);
                 
                 saveGeneratedReport(generatedReport);                 
              }
            }
            
          }
          catch(Exception e) {
           LOGGER.error("Exception encountered during cofr payment upload.", e);
          }
               
        }
        
        
    /**
     * 
     * @param generatedReport 
     */
   
    public void saveGeneratedReport(GeneratedReport generatedReport) {
     generatedReport.setDateCreated(new Date());   
     generatedReport.setPublished(Boolean.TRUE);
     generatedReport.setPublishedDate(new Date());
     
     generatedReportDao.saveOrUpdate(generatedReport);   
    }
        
        /**
         * 
         * @param fiscalMonth
         * @param districtNumber
         * @return 
         */
        public String createUploadFilename( String fiscalMonth, String districtNumber) {
          return  fiscalMonth + "PaymentFor" + districtNumber + ".cofr";   
        }
        
        /**
         * 
         * @param districtNumber
         * @param fiscalYear
         * @param fiscalMonth
         * @return 
         */
        public String createPaymentDocument(String districtNumber, String fiscalYear, String fiscalMonth) {
         List<SeMonthly> seMonthlyPayments = monthlyPaymentsDAO.findForDistrictByMonthAndYear(districtNumber, fiscalYear, FiscalMonth.getInstance(fiscalMonth));   
         
         if (seMonthlyPayments != null && seMonthlyPayments.size() > 1) {
          LOGGER.warn("morethan one payment record found...");             
         }
         
         if (seMonthlyPayments != null && seMonthlyPayments.iterator().hasNext()) {
          SeMonthly payment = seMonthlyPayments.iterator().next();
         
          return "Pay to the order of ${district} the sum of ${amount}".replace("${district}", payment.getDistrictNumber()).replace("${amount}", payment.getPayment().toString());
         }
         
         return null;
        }
        
    @Override
	public SeMonthlyPaymentProcessingForm setupForm(long id) {
		District obj = findById(District.class, id); 
		
		SeMonthlyPaymentProcessingForm form = new SeMonthlyPaymentProcessingForm();
		//form.setId(obj.getId());
		//orm.setCode(obj.getCode());
		//form.setName(obj.getName());
		//form.setYear(obj.getYear());
                
		return form;
	}
	
	public void setMonthlyPaymentsDAO(IMonthlyPaymentsDAO monthlyPaymentsDAO) {
		this.monthlyPaymentsDAO = monthlyPaymentsDAO;
	}

    public void setGeneratedReportDao(IGeneratedReportDao generatedReportDao) {
        this.generatedReportDao = generatedReportDao;
    }

    public void setUploadInputFolder(Resource uploadInputFolder) {
        this.uploadInputFolder = uploadInputFolder;
    }
	
}
