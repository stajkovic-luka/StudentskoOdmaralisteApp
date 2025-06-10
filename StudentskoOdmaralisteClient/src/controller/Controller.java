package controller;

import java.io.IOException;
import java.net.Socket;
import transfer.Operation;
import transfer.Request;
import transfer.Sender;

public class Controller {
    private Sender sender;
    private Socket socket;
            
    private static Controller instance;

    private Controller() throws IOException {
        socket = new Socket("localhost", 9000);
        sender = new Sender(socket);
    }

    public static Controller getInstance() throws Exception{
        if (instance == null) {
            return new Controller();
        }
        return instance;
    }

    public void test() throws IOException {
        Request request = new Request(Operation.LOGIN, "TEST!");
        sender.send(request);
        
    }
}
