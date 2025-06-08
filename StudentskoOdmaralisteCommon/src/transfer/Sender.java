package transfer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Sender {
    private Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    // Slanje objekta kroz socket
    private void send(Object obj) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(obj);
        oos.flush();
    }
    
    
}
