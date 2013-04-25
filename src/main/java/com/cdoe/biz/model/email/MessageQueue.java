package com.cdoe.biz.model.email;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.springframework.beans.factory.BeanNameAware;

/**
 *
 * @author Tony Ford
 */
public class MessageQueue implements BeanNameAware {
 private String id;
 private ConcurrentHashMap<String,ConcurrentSkipListSet<String>> messages = new ConcurrentHashMap<String,ConcurrentSkipListSet<String>>();
 private String subject;

 /**
  * 
  */
 public MessageQueue() {
 }
 
 /**
  * 
  * @return 
  */
 public String getMessage(String body) {
      String[] parts = body.split("=");
      
      if (parts.length == 2  && !messages.isEmpty() && messages.containsKey(parts[1])) {
       return messages.get(parts[1]).pollFirst();      
      }
      
  return null;   
 }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
 
 /**
  * 
  * @param msg 
  */
 public void addMessage(String msgId, String msg) {
   if (!messages.containsKey(msgId)) {
     messages.put(msgId, new ConcurrentSkipListSet<String>());
   } 
   
   messages.get(msgId).add(msg);   
 }

    @Override
    public void setBeanName(String string) {
       this.id = string;
    }
}
