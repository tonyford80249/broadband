package com.cdoe.services.impl;

import com.cdoe.services.IMailClient;
import com.cdoe.biz.model.email.MessageQueue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony Ford
 */
public class MailClient implements IMailClient {

    private static final Logger LOGGER = Logger.getLogger(MailClient.class);    
    private CamelContext camelContext;    
    private Map<String,String> messageIdentifiers;
    private MessageQueue destination;
    private Map<String, List<String>> recipientLists;
    private String mailServerUrl;
    private String username;
    private String password;
    
    /**
     *
     */
    public MailClient() {
     this.mailServerUrl = "smtps://smtp.gmail.com";        
    }
    
    public void init() {
        final boolean usernameSupplied = username != null;
        final boolean passwordSupplied = password != null;
        
        for (final String msgId : messageIdentifiers.keySet()) {      
            final String subject = messageIdentifiers.get(msgId);
            final List<String> recipients = recipientLists.get(msgId);
            try {                
                camelContext.addRoutes(new RouteBuilder() {
                    @Override
                    public void configure() {
                        
                        //from("direct:start-" + msgId).to("bean:"+ msgId +"?method=getMessage").to("smtps://smtp.gmail.com?username=" + MailClient.this.username + "&password=" + MailClient.this.password + "&subject=" + queue.getSubject() + "&to=" + concatList(recipients));
                        if (usernameSupplied && passwordSupplied) {
                         from("timer://" + msgId +"?fixedRate=true&period=30s").setBody(body().append("msgId="+msgId)).to("bean:"+ destination.getId() +"?method=getMessage").filter(body().isNotNull()).to(MailClient.this.mailServerUrl  + "?username=" + MailClient.this.username + "&password=" + MailClient.this.password + "&subject=" + subject + "&to=" + concatList(recipients));
                        }
                        else if (usernameSupplied) {
                         from("timer://" + msgId +"?fixedRate=true&period=30s").setBody(body().append("msgId="+msgId)).to("bean:"+ destination.getId() +"?method=getMessage").filter(body().isNotNull()).to(MailClient.this.mailServerUrl  + "?username=" + MailClient.this.username + "&subject=" + subject + "&to=" + concatList(recipients));   
                        }
                        else {
                         from("timer://" + msgId +"?fixedRate=true&period=30s").setBody(body().append("msgId="+msgId)).to("bean:"+ destination.getId() +"?method=getMessage").filter(body().isNotNull()).to(MailClient.this.mailServerUrl  + "?subject=" + subject + "&to=" + concatList(recipients));   
                        }
                    }
                });
            } catch (Throwable t) {
                LOGGER.error("error creating route for message : " + msgId, t);                
            }
                        
        }
    }
    
    /**
     * 
     * @param recipients
     * @return 
     */
    public String concatList(List<String> recipients) {
     StringBuilder list = new StringBuilder("");   
     
     boolean firstTimeThru = true;
     for (String recipient : recipients) {
      if (!firstTimeThru)    {      
       list.append(",");
      }
      else {
       firstTimeThru = false;       
      }
      
      list.append(recipient);
     }
     
     return list.toString();
    }

    /**
     *
     * @param msgId
     * @param message
     */
    @Override
    public void send(String msgId, String message) {
        if (messageIdentifiers.containsKey(msgId)) {
            destination.addMessage(msgId,message);            
        } else {
            throw new java.lang.IllegalStateException("email destination unknow : " + msgId);            
        }
    }

    /**
     * 
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @param mailServerUrl 
     */
    public void setMailServerUrl(String mailServerUrl) {
        this.mailServerUrl = mailServerUrl;
    }

    /**
     * 
     * @param destination 
     */
    public void setDestination(MessageQueue destination) {
        this.destination = destination;
    }

    /**
     * 
     * @param messageIdentifiers 
     */
    public void setMessageIdentifiers(Map<String, String> messageIdentifiers) {
        this.messageIdentifiers = messageIdentifiers;
    }

   
    /**
     *
     * @param recipientLists
     */
    public void setRecipientLists(Map<String, List<String>> recipientLists) {
        this.recipientLists = recipientLists;
    }

    /**
     *
     * @param camelContext
     */
    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }
}
