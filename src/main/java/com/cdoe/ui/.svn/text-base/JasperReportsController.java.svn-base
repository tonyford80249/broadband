package com.cdoe.ui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
//import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JRParameter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdoe.ui.form.AdjustmentForm;
import com.cdoe.ui.form.transportation.ProrateForm;
import com.cdoe.ui.form.transportation.TransportationForm;
import com.cdoe.util.DateUtil;
import com.cdoe.util.UserInfo;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Controller
public class JasperReportsController {

    private static final Logger LOGGER = Logger.getLogger(JasperReportsController.class);
            
    private static final String ERROR_MESSAGE_TEMPLATE = "Error occurred duuring report creation of report ${report}.";
                 
       
    /**
     * data source used to create model information for the report or used to pass to the report so
     * that it can query the database directly
     */
    @Autowired
    private DataSource datasource;
    
    /**
     * injected view
     */
    @Autowired
    JasperReportsPdfView samplePdfView;

    /**
     * 
     */
    public JasperReportsController() {       
    }
	            
    /**
     * this method uses a JasperReports view that has been injected into the controller. This is a brute force approach.
     * 
     * @param title
     * @param reportId
     * @param model
     * @return 
     */
    //@RequestMapping(value="/dynamic/report/sample.pdf", method = RequestMethod.GET)
    public ModelAndView report1(@RequestParam String title, @RequestParam String  reportId, Model model) {
		    
		    try
		    {                                                   
                     List<String> myData = new ArrayList<String>();
                     
                     myData.add("NameIs");
                     
                     model.addAttribute("dataSource", new JRBeanCollectionDataSource(myData));
                     
		     return new ModelAndView(samplePdfView, model.asMap());
		    }		    
		    catch (Throwable t) {
		    	LOGGER.error(ERROR_MESSAGE_TEMPLATE.replace("${report}", reportId), t);
	            }
                    finally {
                     LOGGER.info("generating report " + reportId);   
                    }
		    
		    return null;                                        
    }
    
    /**
     * this method relies on a view resolver to locate the JasperReport view. This approach is highly configurable.
     * 
     * @param title
     * @param reportId
     * @param model
     * @return 
     */
//    @RequestMapping(value="/dynamic/report/paymentWorksheet.pdf", method = RequestMethod.GET)
//    public ModelAndView report2(@RequestParam String districtNumber, @RequestParam String fiscalYear, HttpServletRequest request) {
//		    
//		    try {
//            Map<String, Object> parameterMap = new HashMap<String, Object>();
//            
//            HttpSession session = request.getSession();
//        
//            UserInfo userInfo = (UserInfo) session.getAttribute("USER_INFO");
//          
//            String districtName = userInfo.getDistrictMap().get(districtNumber);
//
//            TransportationForm form = paymentWorkSheetManager.setupForm(districtNumber, districtName, fiscalYear);
//
//            parameterMap.put("transportationForm", form);
//
//            return new ModelAndView(standardJsonView, parameterMap);
//        } catch (Throwable t) {
//            logger.error("Exception occurred during retrieve.", t);
//        } finally {
//            logger.info("generating json response ");
//        }
//
//        return null;
//                                        
//    }
    
    /**
     * A more generic and dynamic form of report2 that requires less code to implement a report.
     * 
     * @param title
     * @param reportId
     * @param model
     * @return 
     */
    @RequestMapping(value="/dynamic/report/{reportName}.{reportFormat}", method = RequestMethod.GET)
    public ModelAndView report3(@PathVariable("reportName") String reportName, @PathVariable("reportFormat") String  reportFormat, @RequestParam String fiscalYear, Model model) {
		    
		    try
		    {                                         
                     reportFormat = reportFormat.toLowerCase();
                     
                     String format = reportFormat.substring(0,1).toUpperCase() +reportFormat.substring(1);
                     
                     String reportId = reportName + "Report" + format + "View";
                     
                     LOGGER.info("recieved request for report " + reportId);
                     
                     List<String> myData = new ArrayList<String>();
                     
                     myData.add("NameIs");
                     
                     //model.addAttribute("tableRowData", new JRBeanCollectionDataSource(myData));
                     
                     Map<String,Object> parameterMap = new HashMap<String,Object>();
                     parameterMap.put(JRParameter.REPORT_CONNECTION, datasource.getConnection());
                     parameterMap.put("fiscalYear", fiscalYear);//"20102011");
                     
                     if (reportName.startsWith("test") || reportName.startsWith("sample")) {
                      parameterMap.put("tableRowData", new JRBeanCollectionDataSource(myData));
                     }
                                          
                     
		     return new ModelAndView(reportId, parameterMap);
		    }		    
		    catch (Throwable t) {
		    	LOGGER.error(ERROR_MESSAGE_TEMPLATE.replace("${report}", reportName + "." +reportFormat), t);                      
	            }
                    finally {
                     LOGGER.info("generating report " + reportName + "." +reportFormat);   
                    }
		    
		    return null;
                                        
    }
    
     /**
     * A more generic and dynamic form of report2 that requires less code to implement a report.
     * 
     * @param title
     * @param reportId
     * @param model
     * @return 
     */
    @RequestMapping(value="/dynamic/report/{reportName}.{reportFormat}", method = RequestMethod.POST)
    public ModelAndView report4(@PathVariable("reportName") String reportName, @PathVariable("reportFormat") String  reportFormat, Model model, HttpServletRequest request) {                    
                     HttpSession session = request.getSession();
                     
                     String fiscalYear = (String) session.getAttribute("fiscalYear");
                                                            
		    try
		    {                                         
                     reportFormat = reportFormat.toLowerCase();
                     
                     String format = reportFormat.substring(0,1).toUpperCase() +reportFormat.substring(1);
                     
                     String reportId = reportName + "Report" + format + "View";
                     
                     LOGGER.info("recieved request for report " + reportId);
                     
                     List<String> myData = new ArrayList<String>();
                     
                     myData.add("NameIs");
                     
                     //model.addAttribute("tableRowData", new JRBeanCollectionDataSource(myData));
                     
                     Map<String,Object> parameterMap = new HashMap<String,Object>();
                     parameterMap.put(JRParameter.REPORT_CONNECTION, datasource.getConnection());
                     parameterMap.put("fiscalYear", fiscalYear);//"20102011");
                     
                     if (reportName.startsWith("test") || reportName.startsWith("sample")) {
                      parameterMap.put("tableRowData", new JRBeanCollectionDataSource(myData));
                     }
                                          
                     
		     return new ModelAndView(reportId, parameterMap);
		    }		    
		    catch (Throwable t) {
		    	LOGGER.error(ERROR_MESSAGE_TEMPLATE.replace("${report}", reportName + "." +reportFormat), t);                      
	            }
                    finally {                                          
                     LOGGER.info("generating report " + reportName + "." +reportFormat);   
                    }
		    
		    return null;
                                        
    }
	
	
}
