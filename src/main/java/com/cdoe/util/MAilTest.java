/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdoe.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author dyn-9
 */
public class MAilTest {
 public static void main(String[] vargs) {
     try {
           String[] emailAddressArray = {"romeo80249@gmail.com"};
           
            InternetAddress[] addressTo = new InternetAddress[emailAddressArray.length];

            for (int i = 0; i < emailAddressArray.length; i++) {

                addressTo[i] = new InternetAddress(emailAddressArray[i]);

            }

  

            // Send email

            Properties mailProps = System.getProperties();

  

            mailProps.put("mail.smtp.host", "dmz-smtp.cde.state.co.us");

  

            Session mailSession = Session.getDefaultInstance(mailProps);

            mailSession.setDebug(true); 

            Message message = new MimeMessage(mailSession);

            message.setRecipients(Message.RecipientType.TO, addressTo);

            message.setSubject("Did it work?");
          
            message.setContent("this is a test message.", "text/plain");
           
            Transport.send(message);

  

            addressTo = null;
     }
     catch(Exception e) {
        System.out.println("send failed, exception: " + e);  
        
        e.printStackTrace(System.out);
     }
//    Properties props = new Properties();
//    props.put("mail.smtp.host", "dmz-smtp.cde.state.co.us");
//    //props.put("mail.from", "me@example.com");
//    Session session = Session.getInstance(props, null);
//
//    try {
//        MimeMessage msg = new MimeMessage(session);
//        msg.setFrom();
//        msg.setRecipients(Message.RecipientType.TO,
//                          "romeo80249@gmail.com");
//        msg.setSubject("JavaMail hello world example");
//        msg.setSentDate(new Date());
//        msg.setText("Hello, world!\n");
//        Transport.send(msg);
//    } catch (MessagingException mex) {
//        System.out.println("send failed, exception: " + mex);
//    }
   
 }  
}
