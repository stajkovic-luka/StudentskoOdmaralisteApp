/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

// Importi za mejl servis
import jakarta.mail.Authenticator;
import jakarta.mail.Session;
import jakarta.mail.PasswordAuthentication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author lule
 */
public class MailConfig {

    private Properties prop;
    private Session session;
    
    public MailConfig() {
        loadProperties();
        createSession();
    }
    
    // Citanje mail.properties
    private void loadProperties() {
        try (
            InputStream input = new FileInputStream("config/mail.properties");
            ) {
            
            prop = new Properties();
            prop.load(input);
            
            
        } catch (IOException e) {
            System.out.println("MAIL_ERR: Greska prilikom ucitavanja mail.properties");
            e.printStackTrace();
        }
    }

    // Kreiranje sesije
    private void createSession() {
        session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(
                        prop.getProperty("mail.username"),
                        prop.getProperty("mail.password")
                );
            }
        });
    }

    public Session getSession() {
        return session;
    }
    
    
    
}
