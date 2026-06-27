package so.invoice;

// SK3
import domain.DomainObject;
import domain.FakturaOdmora;
import domain.StavkaFakture;
import java.util.List;
import so.AbstractSO;

public class UpdateInvoiceSO extends AbstractSO {

    public UpdateInvoiceSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        FakturaOdmora faktura = (FakturaOdmora) object;

        dbb.update(faktura);

        StavkaFakture search = new StavkaFakture();
        search.setFakturaOdmora(faktura);
        search.setSearchByFakturaOnly(true);

        List<DomainObject> existingStavke = dbb.getAllJoinTablesWhere(search);
        for (DomainObject existing : existingStavke) {
            dbb.delete(existing);
        }

        for (StavkaFakture stavka : faktura.getStavkeFakture()) {
            stavka.setFakturaOdmora(faktura);
            dbb.add(stavka);
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
