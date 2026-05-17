package so;

import domain.DomainObject;
import domain.FakturaOdmora;
import domain.StavkaFakture;
import java.util.List;

public class FindInvoiceByIdSO extends AbstractSO {

    private FakturaOdmora faktura;

    public FindInvoiceByIdSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        FakturaOdmora searchFaktura = (FakturaOdmora) object;

        DomainObject result = dbb.getSingleInstance(searchFaktura);
        if (result == null) {
            throw new Exception("Sistem ne moze da nadje fakturu odmora.");
        }
        faktura = (FakturaOdmora) result;

        StavkaFakture stavkaSearch = new StavkaFakture();
        stavkaSearch.setFakturaOdmora(faktura);
        stavkaSearch.setSearchByFakturaOnly(true);

        List<DomainObject> stavke = dbb.getAllJoinTablesWhere(stavkaSearch);
        faktura.setStavkeFakture(stavke.stream()
                .map(d -> (StavkaFakture) d)
                .toList());
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof FakturaOdmora)) {
            throw new Exception("Objekat nije instanca klase FakturaOdmora.");
        }
    }

    public FakturaOdmora getFaktura() {
        return faktura;
    }
}
