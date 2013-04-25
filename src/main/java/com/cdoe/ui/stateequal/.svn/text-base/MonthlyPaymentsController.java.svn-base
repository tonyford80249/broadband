
/*
 * Copyright ResQSoft, Inc. 2011
 */
package com.cdoe.ui.stateequal;

import com.cdoe.biz.model.Payee;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdoe.services.exempt.ITaskExecutionManager;
import com.cdoe.services.concurrent.BasicTask;
import com.cdoe.services.concurrent.PerformSeMonthlyPaymentProcessing;
import com.cdoe.services.concurrent.TaskIdentifer;
import com.cdoe.services.concurrent.TaskMonitor;
import com.cdoe.services.stateequal.IGenerateSeCofrsPaymentReport;
import com.cdoe.services.stateequal.IGenerateSeMonthlyPaymentReport;
import com.cdoe.services.stateequal.IGenerateYtdPaymentWithholdingsReport;
import com.cdoe.services.stateequal.IMonthlyPaymentsManager;
import com.cdoe.services.stateequal.IPerformSeMonthlyPaymentProcessing;
import com.cdoe.ui.form.stateequal.SeMonthlyPaymentProcessingForm;
import com.cdoe.ui.form.transportation.CapitalOutlayForm;
import com.cdoe.util.CalendarMonth;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/secure/MonthlyPayments")
public class MonthlyPaymentsController {

	private static final Logger LOGGER = Logger.getLogger(MonthlyPaymentsController.class);
	
	@Autowired
	private IMonthlyPaymentsManager monthlyPaymentsManager;
        
        @Autowired
        private ITaskExecutionManager taskExecutionManager;
	
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
                
                SeMonthlyPaymentProcessingForm form = monthlyPaymentsManager.setupForm(userInfo);
                
                form.setYear(DateUtil.getCurrentFiscalYear());
                form.setMonth(CalendarMonth.getCurrentMonth().getText());
                
                model.addAttribute("pageInfo", form);
                
		return ".MonthlyPayments-index";
    }
	
     @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute SeMonthlyPaymentProcessingForm inputForm, BindingResult result, HttpServletRequest request) {
                HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
         
                SeMonthlyPaymentProcessingForm form = monthlyPaymentsManager.setupForm(userInfo, inputForm.getYear(), inputForm.getMonth());
                
                form.setYear(inputForm.getYear());
                
                form.setMonth(inputForm.getMonth());
                
                model.addAttribute("pageInfo", form);
                
		return ".MonthlyPayments-index";
    }
     
	private void initModelDropdowns(Model model, HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
                
                
                
		model.addAttribute("districtCodeNameDropdownList", userInfo.getAllDistrictCodes());
		model.addAttribute("fiscalYearDropdownList", DateUtil.getShortYears(DateUtil.getCurrentFiscalYearShort(), 5));
		model.addAttribute("monthDropdownList", DateUtil.getFullMonthList(false));
	}
	
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute CapitalOutlayForm capitalOutlayForm, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			capitalOutlayForm.setMessage(result.getFieldError().getDefaultMessage());
			return ".MonthlyPayments-index";
		}
		monthlyPaymentsManager.saveOrUpdate(capitalOutlayForm);
		model.addAttribute("saved", true);
		capitalOutlayForm.setMessage("Capital Outlay Information saved successfully");
		return ".MonthlyPayments-index";
    }
    
    
    /**
     * 
     * @param year
     * @param month
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String monthlyProcessing(Model model, @ModelAttribute SeMonthlyPaymentProcessingForm inputForm, BindingResult result, HttpServletRequest request) {
                HttpSession session = request.getSession();
                
		UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
                
                if (!taskExecutionManager.isExecuting(TaskIdentifer.MonthlyPaymentProcessing)) {
                    
                 /**
                  * create monthly payment processing task
                  */    
                 IPerformSeMonthlyPaymentProcessing task1 = (IPerformSeMonthlyPaymentProcessing) taskExecutionManager.createTask(TaskIdentifer.MonthlyPaymentProcessing);
                 
                 task1.setSelectedMonth(inputForm.getMonth());
                 
                 task1.setSelectedYear(inputForm.getYear());
                 
                 task1.setDistrictMap(userInfo.getDistrictMap());
                 
                 /**
                  * create monthly payment report generation task
                  */
                 IGenerateSeCofrsPaymentReport task2 = (IGenerateSeCofrsPaymentReport) taskExecutionManager.createTask(TaskIdentifer.CofrsPaymentReport);
                 
                 task2.setSelectedMonth(inputForm.getMonth());
                 
                 task2.setSelectedYear(inputForm.getYear());
                 
                 task2.setUserInfo(userInfo);
                                  
                 
                 /**
                  * submit composite task
                  */
                 BasicTask task = taskExecutionManager.createCompositeTask(new BasicTask[]{task1,task2},true);
                 
                 taskExecutionManager.submitTask(task);
                }
                	
                while(!taskExecutionManager.isComplete(TaskIdentifer.MonthlyPaymentProcessing)) {
                 try {
                  Thread.sleep(2000);    
                 }
                 catch(Exception e) {
                  LOGGER.error("Unable to sleep", e);   
                 }
                }
		
              
                // this simulates a forward as oppossed to a redirect.
                return update(model, inputForm, result, request);
		//return "redirect:/secure/MonthlyPayments/update";
    }
    
    /**
     * 
     * @param model
     * @param request
     * @return 
     */
     @RequestMapping(value = "/status", method = RequestMethod.POST)
    public String statusMonthlyProcessing(Model model, HttpServletRequest request) {
                HttpSession session = request.getSession();
                
		UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
                
                if (taskExecutionManager.isComplete(TaskIdentifer.MonthlyPaymentProcessing)) {
                 model.addAttribute("status", "successful");
                }
                else {
                 TaskMonitor monitor = taskExecutionManager.checkProgress(TaskIdentifer.MonthlyPaymentProcessing);
                 
                 model.addAttribute("status", "inprogress");
                 
                 model.addAttribute("monitor", monitor);
                }
                
		
				
		return ".MonthlyPayments-index";
    }
     
     /**
      * 
      * @param model
      * @param inputForm
      * @param result
      * @param request
      * @return 
      */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadCofrPayment(Model model, @ModelAttribute SeMonthlyPaymentProcessingForm inputForm, BindingResult result, HttpServletRequest request) {
                HttpSession session = request.getSession();
                
		UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
                
               Map<String,String> districtsToBePaid = new HashMap<String,String>();
               
               for (String districtNumber : inputForm.getSelectApprovedPayees()) {
                districtsToBePaid.put(districtNumber, userInfo.getDistrictMap().get(districtNumber));    
               }
                   
                if (!districtsToBePaid.isEmpty()) {
                 monthlyPaymentsManager.uploadPayment(districtsToBePaid, inputForm.getYear(), inputForm.getMonth());
                }
                
                // this simulates a forward as oppossed to a redirect.
                return update(model, inputForm, result, request);
		//return "redirect:/secure/MonthlyPayments/update";
    }
    
    
     /**
      * 
      * @param model
      * @param inputForm
      * @param result
      * @param request
      * @return 
      */
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public String report1(Model model, @ModelAttribute SeMonthlyPaymentProcessingForm inputForm, BindingResult result, HttpServletRequest request) {
                HttpSession session = request.getSession();
                
		UserInfo userInfo = (UserInfo) session.getAttribute(UserInfo.USER_INFO_ATTR);
                
               Map<String,String> districtsToBePaid = new HashMap<String,String>();
               
               for (String districtNumber : inputForm.getSelectApprovedPayees()) {
                districtsToBePaid.put(districtNumber, userInfo.getDistrictMap().get(districtNumber));    
               }
               
               
               if (!taskExecutionManager.isExecuting(TaskIdentifer.MonthlyPaymentProcessing) && !taskExecutionManager.isExecuting(TaskIdentifer.CofrsPaymentReport)) {
                 /**
                  * create monthly payment report generation task
                  */
                 IGenerateSeCofrsPaymentReport task2 = (IGenerateSeCofrsPaymentReport) taskExecutionManager.createTask(TaskIdentifer.CofrsPaymentReport);
                 
                 task2.setSelectedMonth(inputForm.getMonth());
                 
                 task2.setSelectedYear(inputForm.getYear());
                 
                 task2.setUserInfo(userInfo);
                 
                 task2.setSelectedFilter(districtsToBePaid);
                                                                                     
                 taskExecutionManager.submitTask(task2);
               }
                   
                if (!districtsToBePaid.isEmpty()) {
                 monthlyPaymentsManager.uploadPayment(districtsToBePaid, inputForm.getYear(), inputForm.getMonth());
                }
                
                while(!taskExecutionManager.isComplete(TaskIdentifer.CofrsPaymentReport)) {
                 try {
                  Thread.sleep(2000);    
                 }
                 catch(Exception e) {
                  LOGGER.error("Unable to sleep", e);   
                 }
                }
                
                // this simulates a forward as oppossed to a redirect.
                return update(model, inputForm, result, request);
		//return "redirect:/secure/MonthlyPayments/update";
    }
	
}