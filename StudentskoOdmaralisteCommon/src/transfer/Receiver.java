package transfer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


public class Receiver {
    private Socket socket;
    
    public Receiver(Socket socket) {
        this.socket=socket;
    }
    
    // Prihvatanje objekta preko soketa
    public Object receive() throws IOException{
        
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return ois.read();
    }
}
