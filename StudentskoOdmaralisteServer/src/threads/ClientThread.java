package threads;

import controller.Controller;
import domain.DomainObject;
import domain.FakturaOdmora;
import domain.Nocenje;
import domain.Sluzbenik;
import domain.Smena;
import domain.Student;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import transfer.Receiver;
import transfer.Request;
import transfer.Response;
import transfer.Sender;
import transfer.Operation;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientThread extends Thread {

    private final Sender sender;
    private final Receiver receiver;
    private final Controller controller;
    private final ServerThread server;
    private boolean isOn = true;
    private Sluzbenik sluzbenik;
    Socket klijentskiSocket;
    private Boolean vecUlogovan = false;

    public ClientThread(Socket klijentskiSocket, ServerThread server) {
        this.server = server;
        this.klijentskiSocket = klijentskiSocket;
        sender = new Sender(klijentskiSocket);
        receiver = new Receiver(klijentskiSocket);

        controller = new Controller();
    }

    @Override
    public void run() {
        try {
            while (!klijentskiSocket.isClosed()) {

                Request request = (Request) receiver.receive();
                Response response = new Response();

                try {
                    switch (request.getOperation()) {

                        // SK8
                        case LOGIN -> {
                            Sluzbenik tempSluzbenik = (Sluzbenik) request.getArgument();
                            vecUlogovan = server.getListaKlijenata().stream().anyMatch(thread -> {
                                Sluzbenik s = thread.getUlogovaniSluzbenik();
                                return s != null && s.getKorisnickoIme().equals(tempSluzbenik.getKorisnickoIme());
                            });

                            if (vecUlogovan) {
                                throw new Exception("Korisnik je vec ulogovan!");
                            }

                            Sluzbenik sluzbenikIzBaze = controller.login(tempSluzbenik);

                            response.setServerResponse(sluzbenikIzBaze);

                            sluzbenik = sluzbenikIzBaze;
                            server.osveziFormu();
                        }

                        // SK8
                        case LOGOUT -> {
                            if (Operation.LOGOUT.equals(request.getOperation())) {
                                terminateThread();
                                return;
                            }
                        }

                        // SK21
                        case GET_ALL_SHIFT -> {
                            List<DomainObject> shifts = controller.getAllShifts();
                            response.setServerResponse(shifts);
                        }

                        // SK21
                        case INSERT_SHIFT -> {
                            Smena smena = (Smena) request.getArgument();
                            controller.addShift(smena);
                            response.setServerResponse("Sistem je zapamtio smenu.");
                        }

                        // SK4
                        case GET_ALL_FACULTIES -> {
                            List<DomainObject> faculties = controller.getAllFaculties();
                            response.setServerResponse(faculties);
                        }

                        // SK4
                        case CREATE_STUDENT -> {
                            Student student = (Student) request.getArgument();
                            controller.addStudent(student);
                            response.setServerResponse("Sistem je kreirao studenta.");
                        }

                        // SK4, SK5, SK6, SK7
                        case GET_ALL_STUDENTS -> {
                            List<DomainObject> students = controller.getAllStudents();
                            response.setServerResponse(students);
                        }

                        // SK7
                        case DELETE_STUDENT -> {
                            Student student = (Student) request.getArgument();
                            controller.deleteStudent(student);
                            response.setServerResponse("Sistem je obrisao studenta.");
                        }

                        // SK6
                        case UPDATE_STUDENT -> {
                            Student student = (Student) request.getArgument();
                            controller.updateStudent(student);
                            response.setServerResponse("Sistem je zapamtio studenta.");
                        }

                        // SK5 - Pretraži student
                        case FIND_STUDENT -> {
                            Student searchStudent = (Student) request.getArgument();
                            List<DomainObject> searchResults = controller.searchStudents(searchStudent);
                            response.setServerResponse(searchResults);
                        }

                        // SK5, SK6, SK7 - Nadji studenta po ID-u
                        case FIND_STUDENT_BY_ID -> {
                            Student studentById = (Student) request.getArgument();
                            DomainObject found = controller.findStudentById(studentById);
                            if (found == null) {
                                throw new Exception("Sistem ne moze da nadje studenta");
                            }
                            response.setServerResponse(found);
                        }

                        // SK4 - Kreiraj prazan student objekat
                        case CREATE_STUDENT_OBJECT -> {
                            Student created = controller.createStudent();
                            response.setServerResponse(created);
                        }

                        // SK1 - Kreiraj prazan objekat fakture odmora
                        case CREATE_INVOICE_OBJECT -> {
                            FakturaOdmora created = controller.createInvoiceObject();
                            response.setServerResponse(created);
                        }

                        // SK1 - Zapamti fakturu odmora
                        case CREATE_INVOICE -> {
                            FakturaOdmora novaFaktura = (FakturaOdmora) request.getArgument();
                            controller.createInvoice(novaFaktura);
                            response.setServerResponse("Sistem je kreirao fakturu odmora.");
                        }

                        // SK2 - Pretraži fakturu odmora
                        case FIND_INVOICE -> {
                            FakturaOdmora searchFaktura = (FakturaOdmora) request.getArgument();
                            List<DomainObject> searchResults = controller.searchInvoices(searchFaktura);
                            response.setServerResponse(searchResults);
                        }

                        // SK2 - Nadji fakturu po ID-u (sa stavkama)
                        case FIND_INVOICE_BY_ID -> {
                            FakturaOdmora fakturaById = (FakturaOdmora) request.getArgument();
                            FakturaOdmora found = controller.findInvoiceById(fakturaById);
                            if (found == null) {
                                throw new Exception("Sistem ne moze da nadje fakturu odmora.");
                            }
                            response.setServerResponse(found);
                        }

                        // SK2 - Učitaj sve fakture
                        case GET_ALL_INVOICES -> {
                            List<DomainObject> invoices = controller.getAllInvoices();
                            response.setServerResponse(invoices);
                        }

                        // SK3 - Promeni fakturu odmora
                        case UPDATE_INVOICE -> {
                            FakturaOdmora faktura = (FakturaOdmora) request.getArgument();
                            controller.updateInvoice(faktura);
                            response.setServerResponse("Sistem je zapamtio fakturu odmora.");
                        }

                        // SK1, SK2, SK3 - Učitaj sva noćenja
                        case GET_ALL_NOCENJE -> {
                            List<DomainObject> nocenja = controller.getAllNocenje();
                            response.setServerResponse(nocenja);
                        }

                        default -> {
                            throw new Exception("Nepoznata operacija!");
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }

                sender.send(response);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                terminateThread();
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Sluzbenik getUlogovaniSluzbenik() {
        return sluzbenik;
    }

    public void terminateThread() throws IOException {
        isOn = false;
        klijentskiSocket.close();

        server.izbaciIzUlogovanih(this);
        server.osveziFormu();

    }
}
