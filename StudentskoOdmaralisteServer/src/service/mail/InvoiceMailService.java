/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.mail;

import config.MailConfig;
import domain.FakturaOdmora;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
        this.sender = sender;

        sendMail();
    }

    private void sendMail() {
        String subject = "Racun #" + faktura.getIdFaktura();

        String body
                = "Uspesno kreiran racun pod brojem " + faktura.getIdFaktura() + "\n\n"
                + "Sluzbenik: " + faktura.getSluzbenik().getIme() + " " + faktura.getSluzbenik().getPrezime() + "\n"
                + "Korisnik: " + faktura.getStudent().getIme() + " " + faktura.getStudent().getPrezime() + "\n"
                + "Datum izdavanja fakture: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")) + "\n"
                + "Popust: " + String.format("%.0f%%", faktura.getPopust() * 100) + "\n"
                + "Za uplatu: " + String.format("%.2f", faktura.getIznosNakonPopusta()) + " RSD\n\n"
                + "Napomena: " + faktura.getNapomena();

        sender.send(subject, body, mejlPrimaoca);

    }

}
