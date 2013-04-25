package com.cdoe.services.stateequal;

import com.cdoe.biz.model.equal.StateEqual;
import com.cdoe.biz.model.jasper.SeMonthlyAdapter;
import com.cdoe.biz.model.jasper.SeMonthlyPaymentComparisonDatasource;
import com.cdoe.util.FilenameConstructor;
import java.util.SortedSet;

/**
 *
 * @author Tony Ford
 */
public interface IMonthlyPaymentComparisonReportManager extends IPaymentReportManager {

    /**
     *
     * @param source
     * @return
     */
    public abstract Double computeTotalAdjustment(SeMonthlyAdapter source);

    /**
     *
     * @param target
     * @return
     */
    public abstract Double computeTotalAdjustment(StateEqual target);

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
    public abstract SeMonthlyPaymentComparisonDatasource createSeMonthlyPaymentComparisonDatasource(SeMonthlyAdapter source, StateEqual target, String county, String districtName, String sourceMonth, String targetMonth, String sourceFiscalYear, String targetFiscalYear);
    

    /**
     * 
     * @param districtName
     * @param sourceMonth
     * @param targetMonth
     * @param fiscalYear
     * @return 
     */
    public FilenameConstructor createPaymentComparisonReportFilenameConstructor(String districtName, String sourceMonth, String targetMonth, String fiscalYear);
    
    /**
     * 
     * @param sePaymentInfoAndCaluations
     * @return 
     */
    public SeMonthlyAdapter getLastPayment(SortedSet<SeMonthlyAdapter> sePaymentInfoAndCaluations);
    
    
    /**
     * 
     * @param districtCode
     * @param fiscalYear
     * @return 
     */ 
    public abstract StateEqual findLatest(String districtCode, String fiscalYear);
    
    /**
     * 
     * @param districtCode
     * @param fiscalYear
     * @return 
     */
    public abstract StateEqual getLatest(String districtCode, String fiscalYear);      
    
}
