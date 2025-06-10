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
                    // SK implementacije operacija
                    System.out.println(this.getId());
                    System.out.println(request.getArgument());
                    System.out.println("TEST...TODO");
                    this.terminateThread();
                    // -----
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                    break;
                } 
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public Sluzbenik getUlogovaniSluzbenik() {
        return sluzbenik;
    }
    
    // Zatvori soket
    public void terminateThread() throws IOException {
        isOn = false;
        klijentskiSocket.close();
    }
}
