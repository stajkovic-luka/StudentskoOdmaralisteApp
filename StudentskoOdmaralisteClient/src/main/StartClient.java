package main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import form.LogInForma;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class StartClient {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogInForma loginForma = new LogInForma();
            loginForma.setVisible(true);
        });
    }
}
