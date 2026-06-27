package so.invoice;

// SK1 - Kreiraj fakturu odmora
import domain.FakturaOdmora;
import domain.Sluzbenik;
import domain.Student;
import so.AbstractSO;

public class CreateInvoiceSO extends AbstractSO {

    private FakturaOdmora faktura;

    public CreateInvoiceSO() throws Exception {
        super();
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        Sluzbenik sluzbenik = (Sluzbenik) object;

        faktura = new FakturaOdmora();
        faktura.setPopust(0);
        faktura.setIznosNakonPopusta(0);
        faktura.setUkupanIznos(0);
        faktura.setNapomena("");
        faktura.setSluzbenik(sluzbenik);

        Student dummyStudent = new Student();
        dummyStudent.setIdStudent(1);
        faktura.setStudent(dummyStudent);

        dbb.add(faktura);
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Sluzbenik)) {
            throw new Exception("Objekat nije instanca klase Sluzbenik.");
        }
    }

    public FakturaOdmora getFaktura() {
        return faktura;
    }
}
