package so.student;

// SK5, SK6, SK7
import domain.DomainObject;
import domain.Student;
import so.AbstractSO;

public class FindStudentByIdSO extends AbstractSO {

    private DomainObject student;

    public FindStudentByIdSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        student = dbb.getSingleInstance((Student) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Student)) {
            throw new Exception("Objekat nije instanca klase Student.");
        }
    }

    public DomainObject getStudent() {
        return student;
    }
}
