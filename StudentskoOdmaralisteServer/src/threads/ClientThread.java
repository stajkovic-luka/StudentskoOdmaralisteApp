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
                        // TODO: Proveri da li je korisnik vec ulogovan, ako jeste, baci gresku sa klijentske strane
                        // Ne treba na Serverskoj tabeli da se dva puta prikaze isti sluzbenik da je ulogovan
                        case LOGIN -> {

                            sluzbenik = (Sluzbenik) request.getArgument();
                            
                            Sluzbenik sluzbenikIzBaze = controller.login(sluzbenik);

                            response.setServerResponse(sluzbenikIzBaze);

                            // Podesavanje ulogovanog sluzbenika i refresh serverske tabele
                            sluzbenik = sluzbenikIzBaze;
                            server.osveziFormu();
                        }
                        default -> {
                            throw new Exception("Nepoznata operacija!");
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                    break;
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

    // Zatvori soket
    public void terminateThread() throws IOException {
        isOn = false;
        klijentskiSocket.close();

        server.izbaciIzUlogovanih(this);
        server.osveziFormu();

    }
}
