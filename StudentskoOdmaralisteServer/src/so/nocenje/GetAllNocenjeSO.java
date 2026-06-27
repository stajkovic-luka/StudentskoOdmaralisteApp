package so.nocenje;

import domain.DomainObject;
import domain.Nocenje;
import java.util.List;
import so.AbstractSO;

public class GetAllNocenjeSO extends AbstractSO {

    private List<DomainObject> nocenja;

    public GetAllNocenjeSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        nocenja = dbb.getAll(new Nocenje());
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public List<DomainObject> getNocenja() {
        return nocenja;
    }
}
