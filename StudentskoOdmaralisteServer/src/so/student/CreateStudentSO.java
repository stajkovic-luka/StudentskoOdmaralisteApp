package so.student;

// SK4 - Kreiraj student
import domain.Fakultet;
import domain.Student;
import so.AbstractSO;

public class CreateStudentSO extends AbstractSO {

    private Student student;

    public CreateStudentSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        student = new Student();
        student.setIme("placeholder");
        student.setPrezime("placeholder");
        student.setBrTelefona(0);
        student.setBudzet(false);

        Fakultet dummyFakultet = new Fakultet();
        dummyFakultet.setIdFakultet(1);
        student.setFakultet(dummyFakultet);

        dbb.add(student);
    }

    @Override
    protected void validate(Object object) throws Exception {
    }

    public Student getStudent() {
        return student;
    }
}
