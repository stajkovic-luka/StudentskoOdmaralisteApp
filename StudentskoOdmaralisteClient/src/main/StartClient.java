package main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import form.auth.LogInForm;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class StartClient {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {

                //Custom tema za UI
                UIManager.setLookAndFeel(new FlatIntelliJLaf());

                // JOptionPane dialog tema
                UIManager.put("OptionPane.background", new java.awt.Color(28, 43, 58));
                UIManager.put("Panel.background", new java.awt.Color(28, 43, 58));
                UIManager.put("OptionPane.messageForeground", new java.awt.Color(255, 255, 255));
                UIManager.put("Button.background", new java.awt.Color(224, 123, 0));
                UIManager.put("Button.foreground", new java.awt.Color(255, 255, 255));
                UIManager.put("Button.focusedBackground", new java.awt.Color(255, 165, 0));

            } catch (Exception e) {
                e.printStackTrace();
            }

            LogInForm loginForma = new LogInForm();
            loginForma.setVisible(true);
        });
    }
}
