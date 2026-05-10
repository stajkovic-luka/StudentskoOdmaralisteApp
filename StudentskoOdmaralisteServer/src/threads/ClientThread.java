package threads;

import controller.Controller;
import domain.DomainObject;
import domain.Sluzbenik;
import domain.Smena;
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
                        case LOGOUT -> {
                            if (Operation.LOGOUT.equals(request.getOperation())) {
                                terminateThread();
                                return;
                            }
                        }
                        case GET_ALL_SHIFT -> {
                            List<DomainObject> shifts = controller.getAllShifts();
                            response.setServerResponse(shifts);
                        }
                        case INSERT_SHIFT -> {
                            Smena smena = (Smena) request.getArgument();
                            controller.addShift(smena);
                            response.setServerResponse("Sistem je kreirao novu smenu.");
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
