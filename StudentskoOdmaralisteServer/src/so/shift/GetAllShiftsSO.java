package so.shift;

// SK21
import domain.DomainObject;
import domain.Smena;
import java.util.List;
import so.AbstractSO;

public class GetAllShiftsSO extends AbstractSO {

    private List<DomainObject> shifts;

    public GetAllShiftsSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        shifts = dbb.getAll(new Smena());
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public List<DomainObject> getShifts() {
        return shifts;
    }
}
