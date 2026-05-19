package so;

// SK3
import domain.FakturaOdmora;
import domain.StavkaFakture;

public class UpdateInvoiceSO extends AbstractSO {

    public UpdateInvoiceSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        FakturaOdmora faktura = (FakturaOdmora) object;

        dbb.update(faktura);

        for (StavkaFakture stavka : faktura.getStavkeFakture()) {
            dbb.update(stavka);
        }
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof FakturaOdmora)) {
            throw new Exception("Objekat nije instanca klase FakturaOdmora.");
        }
        FakturaOdmora faktura = (FakturaOdmora) object;
        if (faktura.getStudent() == null) {
            throw new Exception("Nije izabran student.");
        }
        if (faktura.getSluzbenik() == null) {
            throw new Exception("Nije izabran sluzbenik.");
        }
        if (faktura.getStavkeFakture() == null || faktura.getStavkeFakture().isEmpty()) {
            throw new Exception("Nisu unesene stavke fakture.");
        }
    }
}
