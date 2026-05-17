package so;

import domain.DomainObject;
import domain.FakturaOdmora;
import java.util.List;

public class SearchInvoiceSO extends AbstractSO {

    private List<DomainObject> fakture;

    public SearchInvoiceSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        fakture = dbb.getAllJoinTablesWhere((FakturaOdmora) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof FakturaOdmora)) {
            throw new Exception("Objekat nije instanca klase FakturaOdmora.");
        }
    }

    public List<DomainObject> getFakture() {
        return fakture;
    }
}
