package so;

// SK6
import domain.Student;

public class UpdateStudentSO extends AbstractSO {

    public UpdateStudentSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        dbb.update((Student) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Student)) {
            throw new Exception("Objekat nije instanca klase Student.");
        }
    }
}
