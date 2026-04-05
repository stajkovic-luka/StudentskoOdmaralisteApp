package main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import form.ServerskaForma;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class StartServer {

    public static void main(String[] args) {
        
        // FlatLeaf tema
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            ServerskaForma serverskaForma = new ServerskaForma();
            serverskaForma.setVisible(true);
        });
    }
}
