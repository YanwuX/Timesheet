package com.mercury.timesheet.services;

import java.util.Properties;
import java.util.Date;

import javax.mail.*;                  // Include Authenticator, Message, PasswordAuthentication, Session, Transport
import javax.mail.internet.*;     // Include InternetAddress, MimeMessage
public class MailService {
    public void sendMail(RegisterServiceRequest request) {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";  
        Properties prop = System.getProperties();
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");   
        prop.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);   
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");   
        prop.setProperty("mail.smtp.port", "465");   
        prop.setProperty("mail.smtp.socketFactory.port", "465");   
        prop.put("mail.smtp.auth", "true");  
        //TODO
        final String user = "wniu.mercury"; 
        //TODO
        final String password = "mercury123";	
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() { 
            	return new PasswordAuthentication(user, password); 		
            } 
        });
        try {
            Message msg = new MimeMessage(session);
            //TODO
            msg.setFrom(new InternetAddress("wniu.mercury@gmail.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(request.getEmail()));
            msg.setSubject("Welcome to MSI Timesheet System"); 
            msg.setSentDate(new Date());
            MimeMultipart mp = new MimeMultipart();
            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setText("Hello " + request.getUsername() + ",");
            mp.addBodyPart(mbp);
            mbp = new MimeBodyPart();
            mbp.setText("\n" + 
            		"Congratulations! You have registered for MSI Timesheet System successfully!");
            mp.addBodyPart(mbp);
            msg.setContent(mp);
            Transport.send(msg);
            //System.out.println("Message sent successfully!");
        } catch (Exception e) { 
        	e.printStackTrace(); 
        }
    }
}

