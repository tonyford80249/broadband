package com.cdoe.ui.view;

import com.cdoe.ui.DynamicExcelDownload;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import java.io.InputStream;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author Tony Ford
 */
public class GenericlPdfView extends AbstractView {
    private static final Logger LOGGER = Logger.getLogger(GenericlPdfView.class);
    private String url;
    private String reportName;
    private Integer bufferSize = 2;

    public GenericlPdfView() {              
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
        
        initApplicationContext();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(Integer bufferSize) {
        this.bufferSize = bufferSize;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       ServletOutputStream outputStream = null;
       hsr1.setContentType("text/html;charset=UTF-8");
         
       try {        
        Resource resource  = getApplicationContext().getResource(url + "."  + "pdf");               
        byte[] buffer = new byte[1024 * bufferSize];
        
        hsr1.setContentType("application/pdf");
        hsr1.setHeader("Content-Disposition", "attachment;filename=report.pdf");
        outputStream = hsr1.getOutputStream();
        
        InputStream inputStream = resource.getInputStream();
        while (inputStream.available() > 0) {
         int size = inputStream.read(buffer);
         
         if (size == -1) {
          break;   
         }
         
         outputStream.write(buffer, 0, size);
        }
        
            
       }
       catch(Throwable t) {
        LOGGER.error("error occurred while rendering report " +  this.reportName, t);           
       }
       finally
        {
           try
            {
                outputStream.flush();
                outputStream.close();
            }
            catch(Exception ex)
            {   
             LOGGER.error("error closing stream", ex);                
            }

        }
                   
    }


    
    
    
    
}
