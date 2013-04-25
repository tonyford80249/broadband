package com.cdoe.services.stateequal;

import com.cdoe.biz.model.GeneratedReport;
import com.cdoe.ui.form.SeViewReportsForm;

import java.util.List;

/**
 *
 * @author Tony Ford
 */
public interface IViewReportsManager {

    /**
     *
     * @param reportGuids
     */
    void delete(List<String> reportGuids);

    /**
     *
     * @param reportGuids
     */
    void print(List<String> reportGuids);

    /**
     *
     * @return
     */
    SeViewReportsForm setupForm();

    /**
     *
     * @param fiscalYear
     * @param fiscalMonth
     * @return
     */
    SeViewReportsForm setupForm(String fiscalYear, String fiscalMonth, String reportType);

    
    /**
     * 
     * @param form 
     */
    void uploadReports(SeViewReportsForm form);
    
    /**
     * 
     * @param generatedReport 
     */
    void saveGeneratedReport(GeneratedReport generatedReport);
    
}
