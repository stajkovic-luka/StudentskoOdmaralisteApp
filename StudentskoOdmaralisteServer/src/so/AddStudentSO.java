package so;

// SK4
import domain.Student;

public class AddStudentSO extends AbstractSO {

    public AddStudentSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        dbb.add((Student) object);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Student)) {
            throw new Exception("Objekat nije instanca klase Student.");
        }
    }
}
