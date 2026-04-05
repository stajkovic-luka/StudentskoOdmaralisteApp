package threads;

import controller.Controller;
import domain.Sluzbenik;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import transfer.Receiver;
import transfer.Request;
import transfer.Response;
import transfer.Sender;
import transfer.Operation;
import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientThread extends Thread {

    private final Sender sender;
    private final Receiver receiver;
    private final Controller controller;
    private final ServerThread server;
    private boolean isOn = true; // flag
    private Sluzbenik sluzbenik; // Svaki klijent ulogovan pod nekim sluzbenikom
    Socket klijentskiSocket;
    private Boolean vecUlogovan = false;

    // Postavljanje klijentskog soketa (za svakog klijenta koji se konektuje) i serverske niti
    public ClientThread(Socket klijentskiSocket, ServerThread server) {
        this.server = server;
        this.klijentskiSocket = klijentskiSocket;
        sender = new Sender(klijentskiSocket); // Klijenta salje zahtev serveru
        receiver = new Receiver(klijentskiSocket); // Klijent prima odgovor servera

        controller = new Controller();
    }

    // NIT
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
                        default -> {
                            throw new Exception("Nepoznata operacija!");
                        }

                    }
                    // Slanje exception-a klijentu u slucaju greske
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                
                // Salji odgovor
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

    // Zatvori soket
    public void terminateThread() throws IOException {
        isOn = false;
        klijentskiSocket.close();

        server.izbaciIzUlogovanih(this);
        server.osveziFormu();

    }
}
