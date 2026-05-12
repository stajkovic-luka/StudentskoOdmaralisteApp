package so;

// SK5
import domain.DomainObject;
import domain.Student;
import java.util.List;

public class SearchStudentsSO extends AbstractSO {

    private List<DomainObject> students;

    public SearchStudentsSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        students = dbb.getAllJoinTablesWhere((Student) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Student)) {
            throw new Exception("Objekat nije instanca klase Student.");
        }
    }

    public List<DomainObject> getStudents() {
        return students;
    }
}
