/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.mail;

import config.MailConfig;
import domain.FakturaOdmora;
import java.time.LocalDate;

/**
 *
 * @author lule
 */
public class InvoiceMailService {
    // Slanje INVOICE mejlova
    
    private FakturaOdmora faktura;
    private String mejlPrimaoca;
    private MailConfig mailConfig = new MailConfig();
    private MailSender sender;
    
    public InvoiceMailService() {
        
    }

    public InvoiceMailService(FakturaOdmora faktura, String mejlPrimaoca, MailSender sender) {
        this.faktura = faktura;
        this.mejlPrimaoca = mejlPrimaoca;
        this.sender=sender;
        
        sendMail();
    }

    private void sendMail() {
           String subject = "Racun #" + faktura.getIdFaktura();
           
           String body =
                   "Uspesno kreiran racun\n\n"+
                   "Sluzbenik: " + faktura.getSluzbenik()+"\n"+
                   "Korisnik: " + faktura.getStudent().getIme() + faktura.getStudent().getPrezime()+"\n"+
                   "Datum izdavanja fakture: " + LocalDate.now().toString()+"\n"+
                   "Popust: " + faktura.getPopust()+"\n"+
                   "Za uplatu: " + faktura.getIznosNakonPopusta()+"\n\n"+
                   "Napomena: "+ faktura.getNapomena();
           
           sender.send(subject, body, mejlPrimaoca);
                   
    }
    
   
    
    
    
    
    
    
    
}
