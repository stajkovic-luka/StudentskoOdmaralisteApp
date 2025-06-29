package controller;

import domain.Sluzbenik;
import java.io.IOException;
import java.net.Socket;
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
            return new Controller();
        }
        return instance;
    }

    public Sluzbenik login(String username, String password) throws IOException {
        Sluzbenik sluzbenik = new Sluzbenik(username, password);

        Request request = new Request(Operation.LOGIN, sluzbenik);
        sender.send(request);

        Response response = (Response) receiver.receive();

        return (Sluzbenik) response.getServerResponse();

    }
}
