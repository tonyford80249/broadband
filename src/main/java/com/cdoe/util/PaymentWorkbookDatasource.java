package com.cdoe.util;

import com.cdoe.biz.model.PaymentWorkBook;
import com.cdoe.biz.model.PaymentWorkSheet;
import com.cdoe.biz.model.PaymentWorkSheetCalculation;
import java.util.Iterator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Tony Ford
 */
public class PaymentWorkbookDatasource extends PaymentWorksheetDatasource {
    public static final String WORKSHEET_COUNT = "sheetCount";
    public static final String WORKSHEET_TOTAL = "totalSheetCount";
    private PaymentWorkBook paymentWorkBook;
    private int currentCount;
   
    
    private Iterator<PaymentWorkSheet> paymentWorksheetIterator = null;
    
    /**
     * 
     * @param paymnetWorkSheet 
     */
    public PaymentWorkbookDatasource(PaymentWorkSheet paymnetWorkSheet) {
        super(paymnetWorkSheet);
    }

    /**
     * 
     * @param paymentWorkBook 
     */
    public PaymentWorkbookDatasource(PaymentWorkBook paymentWorkBook) {
        super(null);
        this.paymentWorkBook = paymentWorkBook;
        
        paymentWorksheetIterator = paymentWorkBook.getSheets().iterator();
    }

    /**
     * 
     * @return 
     */
    protected PaymentWorkBook getPaymentWorkBook() {
        return paymentWorkBook;
    }

    /**
     * 
     * @param paymentWorkBook 
     */
    protected void setPaymentWorkBook(PaymentWorkBook paymentWorkBook) {
        this.paymentWorkBook = paymentWorkBook;
    }

    /**
     * 
     * @return
     * @throws JRException 
     */
    @Override
    public boolean next() throws JRException {
        if (super.next()) {
         return true;   
        }
        if  (!paymentWorksheetIterator.hasNext()) {
         return false;   
        }
        
        ++currentCount;
        
        PaymentWorkSheet paymentWorksheet = paymentWorksheetIterator.next();
        
        super.setPaymnetWorkSheet(paymentWorksheet);
        
        return super.next();
    }

    /**
     * 
     * @param jrf
     * @return
     * @throws JRException 
     */
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        if (jrf.getName().equals(WORKSHEET_TOTAL)) {
         return new Integer(paymentWorkBook.getSheets().size());  
        }
        else if (jrf.getName().equals(WORKSHEET_COUNT)) {
         return new Integer(this.currentCount);  
        }
        
         
        return super.getFieldValue(jrf);
    }
    
     
    
}
