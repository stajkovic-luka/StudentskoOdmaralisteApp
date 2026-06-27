package so.invoice;

// SK1 - Zapamti fakturu odmora 
import config.MailConfig;
import domain.FakturaOdmora;
import domain.StavkaFakture;
import service.mail.InvoiceMailService;
import service.mail.MailSender;
import so.AbstractSO;
import transfer.request.SaveInvoiceData;

public class SaveInvoiceSO extends AbstractSO {
    private MailConfig mailConfig = new MailConfig();
    MailSender sender = new MailSender(mailConfig.getSession());
    
    public SaveInvoiceSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        SaveInvoiceData data = (SaveInvoiceData) object;

        dbb.update(data.getFaktura());

        for (StavkaFakture stavka : data.getFaktura().getStavkeFakture()) {
            stavka.setFakturaOdmora(data.getFaktura());
            dbb.add(stavka);
        }
        
        System.out.println("DA LI SALJE MEJL? "+data.getSendEmail());
        if(data.getSendEmail()){
            InvoiceMailService invoiceMailService = new InvoiceMailService(data.getFaktura(), data.getRecipientEmail(), sender);
        }
        
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof SaveInvoiceData)) {
            throw new Exception("Objekat nije instanca klase SaveInvoiceData. (DTO)");
        }
          SaveInvoiceData dto = (SaveInvoiceData) object;
        if (dto.getFaktura().getStudent() == null) {
            throw new Exception("Nije izabran student.");
        }
        if (dto.getFaktura().getSluzbenik() == null) {
            throw new Exception("Nije izabran sluzbenik.");
        }
        if (dto.getFaktura().getStavkeFakture() == null || dto.getFaktura().getStavkeFakture().isEmpty()) {
            throw new Exception("Nisu unesene stavke fakture.");
        }
    }
}
