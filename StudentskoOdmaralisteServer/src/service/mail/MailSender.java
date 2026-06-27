/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.mail;

import config.MailConfig;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/**
 *
 * @author lule
 */
public class MailSender {

    // Infra generalno za slanje mejlova
    private final Session session;

    public MailSender(Session session) {
        this.session = session;
    }

    void send(String subject, String body, String mejlPrimaoca) {
        try {
            Message msg = new MimeMessage(session);
            
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mejlPrimaoca));
            msg.setSubject(subject);
            msg.setText(body);
            
            Transport.send(msg);
            
        } catch (MessagingException ex) {
            System.getLogger(MailSender.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    
    }

}

