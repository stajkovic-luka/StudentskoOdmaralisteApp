package so;

// SK1
import domain.FakturaOdmora;

public class CreateInvoiceObjectSO extends AbstractSO {

    private FakturaOdmora faktura;

    public CreateInvoiceObjectSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        faktura = new FakturaOdmora();
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public FakturaOdmora getFaktura() {
        return faktura;
    }
}
