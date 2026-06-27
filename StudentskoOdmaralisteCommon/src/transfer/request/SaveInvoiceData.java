/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer.request;

import domain.FakturaOdmora;
import java.io.Serializable;

/**
 *
 * @author lule
 */
public class SaveInvoiceData implements Serializable {
    private FakturaOdmora faktura;
    private Boolean sendEmail;
    private String recipientEmail;

    public SaveInvoiceData() {
    }

    public SaveInvoiceData(FakturaOdmora faktura, Boolean sendEmail, String recipientEmail) {
        this.faktura = faktura;
        this.sendEmail = sendEmail;
        this.recipientEmail = recipientEmail;
    }

    public FakturaOdmora getFaktura() {
        return faktura;
    }

    public void setFaktura(FakturaOdmora faktura) {
        this.faktura = faktura;
    }

    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }
    
    
}
