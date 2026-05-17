package main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import form.ServerskaForm;
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
            
            ServerskaForm serverskaForma = new ServerskaForm();
            serverskaForma.setVisible(true);
        });
    }
}
