package so;

// SK4
import domain.Student;

public class CreateStudentSO extends AbstractSO {

    private Student student;

    public CreateStudentSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        student = new Student();
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public Student getStudent() {
        return student;
    }
}
