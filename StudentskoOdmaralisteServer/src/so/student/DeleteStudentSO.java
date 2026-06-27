package so.student;

// SK7
import domain.Student;
import so.AbstractSO;

public class DeleteStudentSO extends AbstractSO {

    public DeleteStudentSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        dbb.delete((Student) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Student)) {
            throw new Exception("Objekat nije instanca klase Student.");
        }
    }
}
