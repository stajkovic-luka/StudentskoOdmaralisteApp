package so;

// SK4, SK5, SK6, SK7
import domain.DomainObject;
import domain.Student;
import java.util.List;

public class GetAllStudentsSO extends AbstractSO {

    private List<DomainObject> students;

    public GetAllStudentsSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        students = dbb.getAllJoinTables(new Student());
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public List<DomainObject> getStudents() {
        return students;
    }
}
