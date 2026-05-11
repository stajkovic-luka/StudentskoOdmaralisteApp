package so;

// SK4
import domain.DomainObject;
import domain.Fakultet;
import java.util.List;

public class GetAllFacultiesSO extends AbstractSO {

    private List<DomainObject> faculties;

    public GetAllFacultiesSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        faculties = dbb.getAll(new Fakultet());
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public List<DomainObject> getFaculties() {
        return faculties;
    }
}
