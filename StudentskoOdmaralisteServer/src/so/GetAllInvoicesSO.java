package so;

import domain.DomainObject;
import domain.FakturaOdmora;
import java.util.List;

public class GetAllInvoicesSO extends AbstractSO {

    private List<DomainObject> fakture;

    public GetAllInvoicesSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        fakture = dbb.getAllJoinTables(new FakturaOdmora());
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public List<DomainObject> getFakture() {
        return fakture;
    }
}
