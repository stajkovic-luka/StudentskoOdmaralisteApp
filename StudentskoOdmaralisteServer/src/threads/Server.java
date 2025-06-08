package threads;

import controller.Controller;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;


public class Server extends Thread{
    private List<Client> listaKlijenata;
    private final ServerSocket serverSocket;
    private final Controller controller;
    private boolean isOn = false;

    public Server() throws IOException {
        serverSocket = new ServerSocket(9000);
        listaKlijenata= new ArrayList<>();
        
        controller = new Controller();
    }
    
    
}
