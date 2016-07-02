/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author User
 */
public class EmailManagementSystem {
    
    
    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;
    
    
    public void GenerateMail(String recepient,String subject,String message) throws MessagingException{
        
        // Part 1
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		
        //pArt 2
                
                getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("pereira.ke@husky.neu.edu"));
		generateMailMessage.setSubject(subject);
		generateMailMessage.setContent(message, "text/html");
                
        //part 3
                
                Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "shma7887@gmail.com", "shmAdmin25789");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();


 
        
    }
 
    
}
