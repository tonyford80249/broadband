package com.cdoe.services.concurrent;

import com.cdoe.services.stateequal.IPerformSeMonthlyPaymentProcessing;
import com.cdoe.biz.model.FiscalMonth;
import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.stateequal.IMonthlyPaymentsDAO;
import com.cdoe.biz.stateequal.IStateEqualDAO;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import static com.cdoe.util.Math.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  <p>
 *    <b> description </b>  enter description.
 * </p>
 * @author Tony Ford
 */
public class PerformSeMonthlyPaymentProcessing implements IPerformSeMonthlyPaymentProcessing {
    private static final Logger LOGGER = Logger.getLogger(PerformSeMonthlyPaymentProcessing.class);
    
    private DefaultMonitor monitor = new DefaultMonitor();
    private IStateEqualDAO stateEqualDAO;
    private IMonthlyPaymentsDAO seMonthlyPaymentDAO;
    private Map<String, String> districtMap;
    private String selectedMonth;
    private String selectedYear;

    /**
     * 
     */
    public PerformSeMonthlyPaymentProcessing() {
      monitor.setStatus(TaskStatus.NOT_STARTED);
      monitor.setStatusDetail("State Equal Monthly Payment Processing -- NOT_STARTED.");  
      monitor.setTaskIdentifer(this.getTaskIdentifer());
    }

    public void setStateEqualDAO(IStateEqualDAO stateEqualDAO) {
        this.stateEqualDAO = stateEqualDAO;
    }

    public void setSeMonthlyPaymentDAO(IMonthlyPaymentsDAO seMonthlyPaymentDAO) {
        this.seMonthlyPaymentDAO = seMonthlyPaymentDAO;
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
        return this.monitor;
    }

    /**
     * 
     * @return
     * @throws Exception 
     */
    @Override
    public TaskMonitor call() throws Exception {
         try {
            long start_clock = System.currentTimeMillis();
             
            monitor.setStatus(TaskStatus.INPROGRESS);
            monitor.setStatusDetail("State Equal Monthly Payment Processing -- IN PROGRESS.");
            
            double count = 0;
            int size = districtMap.size();

            monitor.setProgress(count / size);

            List<StateEqual> allRecords = stateEqualDAO.findByFiscalYear(selectedYear);
            
            if (allRecords == null || allRecords.isEmpty()) {
                 final String message = "!!!No Records To Process!!!" ;
                 
                 LOGGER.fatal(message);
                 
                 monitor.getProgressDescription().add(message);                                   
             }
            
            for (StateEqual stateEqualRecord  : allRecords) {
                String districtNumber = stateEqualRecord.getDistrictNumber();
                String districtName = districtMap.get(districtNumber);

                //StateEqual stateEqualRecord = stateEqualDAO.findLatest(districtNumber, selectedYear);                                
                
                if (stateEqualRecord == null) {
                 final String message = "missing state equal record!!!" ;
                 
                 LOGGER.error("skipping : " + districtNumber + " - " + districtName + " due to " + message);
                 
                 monitor.getProgressDescription().add("skipping : " + districtNumber + " - " + districtName + " due to " + message); 
                 
                 continue;
                }
                
                if (stateEqualRecord.getStateEqual() == null || stateEqualRecord.getStateEqual() < 1) {
                 final String message = "entitlement for the year not specified!!!" ;   
                 
                 LOGGER.error("skipping : " + districtNumber + " - " + districtName + " due to " + message);
                 
                 monitor.getProgressDescription().add("skipping : " + districtNumber + " - " + districtName + " due to " + message);   
                 
                 continue;
                }
                
                /**
                 * force insert
                 */
                //stateEqualRecord = stateEqualRecord.makeCopy();
                
                List<SeMonthly> payments = null;
                
                FiscalMonth fiscalMonth = FiscalMonth.getInstance(selectedMonth);
                
                switch(fiscalMonth) {
                    case JANUARY :
                    case FEBRUARY :
                    case MARCH :
                    case APRIL :
                    case MAY :      payments = seMonthlyPaymentDAO.findForDistrictByMonthAndYear(districtNumber, selectedYear, FiscalMonth.DECEMBER);
                                    
                                    stateEqualRecord.setMonthEntitle(roundTwoDecimalPlaces(stateEqualRecord.computeMonthEntitlementJanThruMay(stateEqualRecord.computeYtdPayment(payments))));
                    
                                    stateEqualRecord.setMonthPayment(roundTwoDecimalPlaces(stateEqualRecord.computePayment()));
                               break;
                    case JUNE :    payments = seMonthlyPaymentDAO.findForDistrictByMonthAndYear(districtNumber, selectedYear, fiscalMonth.prev());
                                    
                                    stateEqualRecord.setMonthEntitle(roundTwoDecimalPlaces(stateEqualRecord.computeMonthEntitlementJuneOnly(stateEqualRecord.computeYtdPayment(payments))));
                    
                                    stateEqualRecord.setMonthPayment(roundTwoDecimalPlaces(stateEqualRecord.computePayment()));
                                break;
                    case DECEMBER : payments = seMonthlyPaymentDAO.findForDistrictByMonthAndYear(districtNumber, selectedYear, fiscalMonth.prev());
                                    
                                    stateEqualRecord.setMonthEntitle(roundTwoDecimalPlaces(stateEqualRecord.computeMonthEntitlementDecOnly(stateEqualRecord.computeYtdPayment(payments))));
                    
                                    stateEqualRecord.setMonthPayment(roundTwoDecimalPlaces(stateEqualRecord.computePayment()));
                               break;
                    case JULY :
                    case AUGUST :
                    case SEPTEMBER :
                    case OCTOBER :
                    case NOVEMBER :                       
                                      stateEqualRecord.setMonthEntitle(roundTwoDecimalPlaces(stateEqualRecord.computeMonthEntitlementJulThruNov()));
                    
                                      stateEqualRecord.setMonthPayment(roundTwoDecimalPlaces(stateEqualRecord.computePayment()));
                               break;
                    
                }
                
              
                 //stateEqualRecord.setUserId("tnyf");
                 
                                 
                /**
                 * update state equal record
                 */
                stateEqualDAO.saveOrUpdate(stateEqualRecord);
                
                
                /**
                 * insert payment record
                 */
                SeMonthly newPayment = stateEqualRecord.toSeMonthly();
                newPayment.setDistrictNumber(districtNumber);
                newPayment.setFiscalYear(selectedYear);
                newPayment.setMonth(fiscalMonth.getValue());
                
                seMonthlyPaymentDAO.saveOrUpdate(newPayment);
                        
                /**
                 * track progress
                 */
                monitor.setProgress(++count / size);

                monitor.getProgressDescription().add("proccessed : " + districtNumber + " - " + districtName);

            }
            
            monitor.setStatus(TaskStatus.SUCCESS);
            monitor.setStatusDetail("State Equal Monthly Payment Processing --COMPLETE");
            
             long end_clock = System.currentTimeMillis();
            
            SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss zzz");

            LOGGER.debug("**** Time of execution : " + formater.format(new Date(end_clock - start_clock)) + " (end_clock - start_clock) = " + ((end_clock - start_clock)/1000));
        } catch (Throwable t) {
            monitor.setStatus(TaskStatus.FAILURE);
            monitor.setStatusDetail(t.toString());
            
            LOGGER.error("Exception occurred during State Equal Monthly Payment Processing.", t);
        }

        return this.monitor;
    }

    @Override
    public TaskIdentifer getTaskIdentifer() {
        return TaskIdentifer.MonthlyPaymentProcessing;
    }
    
}
