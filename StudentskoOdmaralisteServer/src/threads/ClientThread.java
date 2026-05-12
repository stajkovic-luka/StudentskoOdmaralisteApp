package threads;

import controller.Controller;
import domain.DomainObject;
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
                            response.setServerResponse("Sistem je kreirao novu smenu.");
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
                            response.setServerResponse("Sistem je kreirao novog studenta.");
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
                        
                        // TODO: SK1 - Kreiraj fakturu odmora
                        case CREATE_INVOICE -> {
                            throw new Exception("Operacija nije implementirana.");
                        }
                        
                        // TODO: SK2 - Pretraži fakturu odmora
                        case FIND_INVOICE -> {
                            throw new Exception("Operacija nije implementirana.");
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
