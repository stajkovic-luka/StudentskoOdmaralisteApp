package transfer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// Handlr za primanje
public class Receiver {
    private Socket socket;
    
    public Receiver(Socket socket) {
        this.socket=socket;
    }
    
    // Prihvatanje objekta preko soketa
    public Object receive() throws IOException{
        
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return ois.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
