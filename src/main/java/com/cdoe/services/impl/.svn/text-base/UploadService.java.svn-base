package com.cdoe.services.impl;

import com.cdoe.services.IUploadService;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author Tony Ford
 */
public class UploadService extends RouteBuilder  {
    private static final Logger LOGGER = Logger.getLogger(UploadService.class); 
    private Resource uploadFolder;
    private String inbox;
    private String destination;
    private Integer delay = new Integer(30000);

    public UploadService() {
    }

    public Resource getUploadFolder() {
        return uploadFolder;
    }

    public void setUploadFolder(Resource uploadFolder) {
        this.uploadFolder = uploadFolder;               
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


   
    public String getInbox() {
     try {   
        String extracedAbsolutePath = this.uploadFolder.getFile().getAbsolutePath();
        
        String targetDirectory = extracedAbsolutePath.substring(0, extracedAbsolutePath.length() - 10);
        
        return targetDirectory + "inbox";
     }
     catch(Throwable t) {
      LOGGER.error("Error retrieving inbox location", t);   
     }
     
     return null;
    }

    public void setInbox(String inbox) {
        this.inbox = inbox;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public void init() {
     System.setProperty("myInbox", getInbox());  
    }

    @Override
    public void configure() throws Exception {
     //"ftp://tford80249:madden2004@ftp.drivehq.com/My Documents/drop/"   
      from("file:" +  getInbox() + "?delay=" + delay).to(this.destination);
    }
    
}
