package form;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import controller.Controller;
import domain.Sluzbenik;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lukas
 */
public class LogInForma extends javax.swing.JFrame {

    private System.Logger LOGGER = System.getLogger("LogInForma");

    /**
     * Creates new form LoginForma
     */
    public LogInForma() {
        initComponents();
        dodajStil();

    }

    private void dodajStil() {
        this.setLocationRelativeTo(null);

        // Pozadina
        getContentPane().setBackground(new Color(173, 216, 230));

        // Dugme
        jButtonLogIn.setBackground(new Color(255, 140, 0));
        jButtonLogIn.setForeground(Color.WHITE);
        jButtonLogIn.setFont(jButtonLogIn.getFont().deriveFont(java.awt.Font.BOLD, 16f));
        jButtonLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogIn.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 20, 8, 20));
        jButtonLogIn.setOpaque(true);

        // Labele
        Color bojaLabele = new Color(30, 60, 90);
        jLabelKorisnickoIme.setForeground(bojaLabele);
        jLabelKorisnickoIme.setFont(jLabelKorisnickoIme.getFont().deriveFont(java.awt.Font.BOLD, 18f));
        jLabelSifra.setForeground(bojaLabele);
        jLabelSifra.setFont(jLabelSifra.getFont().deriveFont(java.awt.Font.BOLD, 18f));

        // Naslov forme
        setTitle("Sluzbenik Login");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelKorisnickoIme = new javax.swing.JLabel();
        jLabelSifra = new javax.swing.JLabel();
        jTextFieldKorisnickoIme = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonLogIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelKorisnickoIme.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelKorisnickoIme.setText("Korisnicko ime:");

        jLabelSifra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelSifra.setText("Sifra:");

        jTextFieldKorisnickoIme.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldKorisnickoIme.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButtonLogIn.setText("ULOGUJ SE");
        jButtonLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKorisnickoIme, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(jPasswordField))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jButtonLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogInActionPerformed
        if (jTextFieldKorisnickoIme.getText().isEmpty() || String.valueOf(jPasswordField.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Polja za login ne smeju biti prazna.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String username = jTextFieldKorisnickoIme.getText();
        String password = String.valueOf(jPasswordField.getPassword());

        try {
            Sluzbenik ulogovaniSluzbenik = Controller.getInstance().login(username, password);

            if (ulogovaniSluzbenik instanceof Sluzbenik) {
                JOptionPane.showMessageDialog(this, "Korisnicko ime i sifra su ispravni.", "Operacija uspesna", JOptionPane.INFORMATION_MESSAGE);
                MainForma mf = new MainForma(ulogovaniSluzbenik);
                mf.setVisible(true);

                this.dispose();
            }

        } catch (EOFException eofex) {
            eofex.printStackTrace();
            jTextFieldKorisnickoIme.setText("");
            jPasswordField.setText("");
            JOptionPane.showMessageDialog(this, "Korisnicko ime i sifra nisu ispravni", "Operacija neuspesna", JOptionPane.ERROR_MESSAGE);

        } catch (SocketException sockex) {
            sockex.printStackTrace();
            jTextFieldKorisnickoIme.setText("");
            jPasswordField.setText("");
            JOptionPane.showMessageDialog(this, "Server nije pokrenut", "Operacija neuspesna", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButtonLogInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogIn;
    private javax.swing.JLabel jLabelKorisnickoIme;
    private javax.swing.JLabel jLabelSifra;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldKorisnickoIme;
    // End of variables declaration//GEN-END:variables
}
