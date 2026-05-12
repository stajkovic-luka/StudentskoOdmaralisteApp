package controller;

import domain.DomainObject;
import domain.Fakultet;
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

    // SK4
    public void addStudent(Student student) throws Exception {
        Request request = new Request(Operation.CREATE_STUDENT, student);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
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

    // SK5
    public void deleteStudent(Student student) throws Exception {
        Request request = new Request(Operation.DELETE_STUDENT, student);
        sender.send(request);

        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
    }
}
