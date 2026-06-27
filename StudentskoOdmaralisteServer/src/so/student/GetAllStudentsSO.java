package so.student;

// SK4, SK5, SK6, SK7 - svi koji koriste listu studenata
import domain.DomainObject;
import domain.Student;
import java.util.List;
import so.AbstractSO;

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
