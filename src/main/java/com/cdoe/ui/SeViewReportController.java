package com.cdoe.ui;

import com.cdoe.services.impl.ViewReportsManager;
import com.cdoe.services.stateequal.IViewReportsManager;
import com.cdoe.ui.form.ReportForm;
import com.cdoe.ui.form.SeViewReportsForm;
import com.cdoe.ui.form.stateequal.AuditRepaymentAdjustmentForm;
import com.cdoe.ui.form.stateequal.OtherStateShareAdjustmentsForm;
import com.cdoe.ui.form.stateequal.SeMonthlyPaymentProcessingForm;

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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tony Ford
 */
@Controller
@RequestMapping("/secure/ViewReports")
public class SeViewReportController {
  private static final Logger LOGGER = Logger.getLogger(SeViewReportController.class);
  
  /**
   * 
   */
  @Autowired
  private IViewReportsManager viewReportsManager;

   /**
    * 
    */
    public SeViewReportController() {
    }
  
    /**
     * 
     * @param model
     * @param session
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
		
        model.addAttribute("pageInfo", viewReportsManager.setupForm());
        
	return ".ViewReports-index";
    }
    
    /**
     * 
     * @param year
     * @param month
     * @param reportType
     * @param model
     * @param session
     * @return 
     */
    @RequestMapping(value = "/viewer", method = RequestMethod.POST)
    public String view1(@RequestParam String year, @RequestParam String month, @RequestParam String reportType, Model model, HttpSession session) {		
        
        model.addAttribute("pageInfo", viewReportsManager.setupForm(year, month, reportType));
        
	return ".ViewReports-index";
    }
    
    /**
     * 
     * @param model
     * @param inputForm
     * @param result
     * @param request
     * @return 
     */
    @RequestMapping(value = "/monthlyPayment", method = RequestMethod.POST)
    public String view2(Model model, @ModelAttribute SeMonthlyPaymentProcessingForm inputForm, BindingResult result, HttpServletRequest request) {		
        
        model.addAttribute("pageInfo", viewReportsManager.setupForm(inputForm.getYear(), inputForm.getMonth(), ReportForm.RPTStateWideReports));
        
	return ".ViewReports-index";
    }
    
     /**
      * 
      * @param model
      * @param session
      * @return 
      */
    @RequestMapping(value = "/viewany", method = RequestMethod.POST)
    public String view3(Model model, HttpSession session) {		
        
        model.addAttribute("pageInfo", viewReportsManager.setupForm());
        
	return ".ViewReports-index";
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String view4(Model model, @ModelAttribute SeViewReportsForm inputForm, BindingResult result, HttpServletRequest request) {		

        viewReportsManager.uploadReports(inputForm);
        
        model.addAttribute("pageInfo", viewReportsManager.setupForm(inputForm.getYear(), inputForm.getMonth(),inputForm.getReportType()));
        
	return ".ViewReports-index";
    }
  
   
}
