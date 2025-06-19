package threads;

import controller.Controller;
import domain.Sluzbenik;
import form.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread {

    private ServerskaForma serverForm;
    private List<ClientThread> listaKlijenata;

    //ON pri kreiranju
    private boolean isOn = true;

    private final ServerSocket serverSocket;
    private final Controller controller;

    public ServerThread() throws IOException {
        serverSocket = new ServerSocket(9000);
        listaKlijenata = new ArrayList<>();

        controller = new Controller();
    }

    // NIT
    @Override
    public void run() {

        while (isOn) {
            try {
                // Prihvata se konekcija i dodeljuje se u thread
                System.out.println("----------------");

                System.out.println("Ceka se konekcija...");
                Socket klijentskiSocket = serverSocket.accept();
                System.out.println("Klijent se konektovao.");

                //Dodavanje klijentske niti u listu svih ulogovanih klijenata
                ClientThread klijentskaNit = new ClientThread(klijentskiSocket, this);
                listaKlijenata.add(klijentskaNit);
                klijentskaNit.start();
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void stopServer() throws IOException, InterruptedException {
        isOn = false;

        // Zatvaramo serverski soket
        if (!serverSocket.isClosed() && serverSocket != null) {
            serverSocket.close();

        }

        // Gasimo sve klijentske niti, ako nisu ugasene
        for (ClientThread klijent : listaKlijenata) {
            if (!klijent.klijentskiSocket.isClosed()) {
                klijent.terminateThread();
            }
        }

        System.out.println("----------------");
        System.out.println("Server ugasen!");

    }

    public List<ClientThread> getListaKlijenata() {
        return listaKlijenata;
    }

    public void setForma(ServerskaForma serverForm) {
        this.serverForm = serverForm;
    }

    void osveziFormu() {
        if (serverForm != null) {
            List<Sluzbenik> trenutnoUlogovani = new ArrayList<>();

            for (ClientThread klijent : listaKlijenata) {
                trenutnoUlogovani.add(klijent.getUlogovaniSluzbenik());
            }
            serverForm.osveziTabelu(trenutnoUlogovani);
        }

    }

    void izbaciIzUlogovanih(ClientThread klijent) {
        listaKlijenata.remove(klijent);
    }

}
