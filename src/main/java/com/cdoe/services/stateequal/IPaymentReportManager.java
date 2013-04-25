
package com.cdoe.services.stateequal;

import com.cdoe.biz.model.equal.SeMonthly;
import com.cdoe.biz.model.jasper.SeMonthlyAdapter;
import com.cdoe.services.transportation.IBaseManager;
import com.cdoe.util.FilenameConstructor;
import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * 
 * @author Tony Ford
 */
public interface IPaymentReportManager extends IBaseManager {
   public abstract List<SeMonthly> getMonthlyPaymentInfo(String districtNumber, String fiscalYear, String month);
   public abstract JRDataSource createMonthlyPaymnetDatasource(String districtNumber, String districtName, String fiscalYear, String month, List<SeMonthly> paymentInfo);
   public abstract void generateReport(JRDataSource datasource, FilenameConstructor constructor) throws Exception;
   public abstract void generateReport(JRDataSource datasource, FilenameConstructor constructor, String fiscalYear, String fiscalMonth) throws Exception;
   public abstract SortedSet<SeMonthlyAdapter> performMonthlyPaymentCalculations(List<SeMonthly> paymentInfo);
   public abstract void populateTable(List<String> allDistrictCodes);
   public abstract FilenameConstructor createPaymentReportFilenameConstructor(String district, String month, String fiscalYear);
   public String getDirectory(String fiscalYear, String fiscalMonth) throws IOException;
   public String getDirectory() throws IOException;
}
