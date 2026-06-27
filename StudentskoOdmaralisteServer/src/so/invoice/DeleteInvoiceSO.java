package so.invoice;

// SK1 - Odustani od kreiranja fakture
import domain.DomainObject;
import domain.FakturaOdmora;
import domain.StavkaFakture;
import java.util.List;
import so.AbstractSO;

public class DeleteInvoiceSO extends AbstractSO {

    public DeleteInvoiceSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        FakturaOdmora faktura = (FakturaOdmora) object;

        StavkaFakture stavkaSearch = new StavkaFakture();
        stavkaSearch.setFakturaOdmora(faktura);
        stavkaSearch.setSearchByFakturaOnly(true);

        List<DomainObject> existingStavke = dbb.getAllJoinTablesWhere(stavkaSearch);
        for (DomainObject d : existingStavke) {
            dbb.delete(d);
        }

        dbb.delete(faktura);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof FakturaOdmora)) {
            throw new Exception("Objekat nije instanca klase FakturaOdmora.");
        }
    }
}
