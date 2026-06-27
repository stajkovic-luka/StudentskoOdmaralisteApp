package controller;

import domain.DomainObject;
import domain.Fakultet;
import domain.FakturaOdmora;
import domain.Sluzbenik;
import domain.Smena;
import domain.Student;
import domain.TipSmene;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import transfer.Operation;
import transfer.Receiver;
import transfer.Request;
import transfer.Response;
import transfer.Sender;
import transfer.request.SaveInvoiceData;

public class Controller {

    private Sender sender;
    private Receiver receiver;
    private Socket socket;

    private static Controller instance;

    private Controller() throws IOException {
        socket = new Socket("localhost", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    // SK8
    public Sluzbenik login(String username, String password) throws Exception {
        Sluzbenik sluzbenik = new Sluzbenik(username, password);

        Request request = new Request(Operation.LOGIN, sluzbenik);
        sender.send(request);

        Response response = (Response) receiver.receive();
        
        if(response.getException() != null){
            throw response.getException();
        }
        
        return (Sluzbenik) response.getServerResponse();
    }

    // SK8
    public void logout() {
        try {
            Request request = new Request(Operation.LOGOUT, null);
            sender.send(request);
            
        } catch (IOException ex) {
            System.getLogger(Controller.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    // SK21
    public List<DomainObject> getAllShifts() throws Exception {
        Request request = new Request(Operation.GET_ALL_SHIFT, null);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<DomainObject>) response.getServerResponse();
    }

    // SK21
    public void addShift(String prostorija, String komentar, TipSmene tipSmene) throws Exception {
        Smena smena = new Smena();
        smena.setProstorija(prostorija);
        smena.setKomentar(komentar);
        smena.setTipSmene(tipSmene);

        Request request = new Request(Operation.INSERT_SHIFT, smena);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    // SK4
    public List<DomainObject> getAllFaculties() throws Exception {
        Request request = new Request(Operation.GET_ALL_FACULTIES, null);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<DomainObject>) response.getServerResponse();
    }

    // SK4, SK5, SK6, SK7
    public List<DomainObject> getAllStudents() throws Exception {
        Request request = new Request(Operation.GET_ALL_STUDENTS, null);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<DomainObject>) response.getServerResponse();
    }

    // SK7
    public void deleteStudent(Student student) throws Exception {
        Request request = new Request(Operation.DELETE_STUDENT, student);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    // SK6
    public void updateStudent(Student student) throws Exception {
        Request request = new Request(Operation.UPDATE_STUDENT, student);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    // SK5
    public List<DomainObject> searchStudents(String kriterijum, String vrednost) throws Exception {
        Student student = new Student();
        student.setSearchKriterijum(kriterijum);
        student.setSearchVrednost(vrednost);

        Request request = new Request(Operation.FIND_STUDENT, student);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<DomainObject>) response.getServerResponse();
    }

    // SK5, SK6, SK7
    public Student findStudentById(long idStudent) throws Exception {
        Student student = new Student();
        student.setIdStudent(idStudent);

        Request request = new Request(Operation.FIND_STUDENT_BY_ID, student);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (Student) response.getServerResponse();
    }

    // SK4 - Kreiraj student
    public Student createStudent() throws Exception {
        Request request = new Request(Operation.CREATE_STUDENT, new Student());
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (Student) response.getServerResponse();
    }

    // SK2
    public List<DomainObject> searchInvoices(String sluzbenik, String student, Long nocenjeId) throws Exception {
        FakturaOdmora faktura = new FakturaOdmora();
        faktura.setSearchSluzbenik(sluzbenik);
        faktura.setSearchStudent(student);
        faktura.setSearchNocenjeId(nocenjeId);

        Request request = new Request(Operation.FIND_INVOICE, faktura);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<DomainObject>) response.getServerResponse();
    }

    // SK2
    public List<DomainObject> getAllInvoices() throws Exception {
        Request request = new Request(Operation.GET_ALL_INVOICES, null);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<DomainObject>) response.getServerResponse();
    }

    // SK2
    public FakturaOdmora findInvoiceById(long idFaktura) throws Exception {
        FakturaOdmora faktura = new FakturaOdmora();
        faktura.setIdFaktura(idFaktura);

        Request request = new Request(Operation.FIND_INVOICE_BY_ID, faktura);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (FakturaOdmora) response.getServerResponse();
    }

    // SK1, SK2, SK3
    public List<DomainObject> getAllNocenje() throws Exception {
        Request request = new Request(Operation.GET_ALL_NOCENJE, null);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<DomainObject>) response.getServerResponse();
    }

    // SK1 - Kreiraj fakturu (placeholder INSERT → vraća fakturu sa ID)
    public FakturaOdmora createInvoice(Sluzbenik sluzbenik) throws Exception {
        Request request = new Request(Operation.CREATE_INVOICE, sluzbenik);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (FakturaOdmora) response.getServerResponse();
    }

    // SK1 - Zapamti fakturu (UPDATE placeholder + INSERT stavki)
    public void saveInvoice(FakturaOdmora faktura, Boolean sendEmail, String recipientEmail) throws Exception {
        // Cuvamo fakturu, flag da li se mejl salje i mejl primaoca
        SaveInvoiceData data = new SaveInvoiceData(faktura, sendEmail, recipientEmail);
        
        Request request = new Request(Operation.SAVE_INVOICE, data);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    // SK1 - Odustani od kreiranja
    public void cancelInvoice(FakturaOdmora faktura) throws Exception {
        Request request = new Request(Operation.DELETE_INVOICE, faktura);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    // SK3
    public void updateInvoice(FakturaOdmora faktura) throws Exception {
        Request request = new Request(Operation.UPDATE_INVOICE, faktura);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    // SK1, SK4
    public List<DomainObject> getAllStudentsForCombo() throws Exception {
        Request request = new Request(Operation.GET_ALL_STUDENTS, null);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }

        return (List<DomainObject>) response.getServerResponse();
    }
}
