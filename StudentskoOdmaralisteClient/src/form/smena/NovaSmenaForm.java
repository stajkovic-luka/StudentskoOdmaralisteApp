package form.smena;

import controller.Controller;
import domain.TipSmene;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;

public class NovaSmenaForm extends javax.swing.JDialog {

    public NovaSmenaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        initTipSmene();
        dodajStil();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNaslov = new javax.swing.JLabel();
        jLabelProstorija = new javax.swing.JLabel();
        jLabelKomentar = new javax.swing.JLabel();
        jLabelTipSmene = new javax.swing.JLabel();
        jTextFieldProstorija = new javax.swing.JTextField();
        jTextFieldKomentar = new javax.swing.JTextField();
        jComboBoxTipSmene = new javax.swing.JComboBox();
        jButtonSacuvaj = new javax.swing.JButton();
        jButtonOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova smena");

        jLabelNaslov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelNaslov.setText("Kreiraj smenu");

        jLabelProstorija.setText("Prostorija:");

        jLabelKomentar.setText("Komentar:");

        jLabelTipSmene.setText("Tip smene:");

        jButtonSacuvaj.setText("Sacuvaj");
        jButtonSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacuvajActionPerformed(evt);
            }
        });

        jButtonOdustani.setText("Odustani");
        jButtonOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelProstorija, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelKomentar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTipSmene, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldProstorija)
                            .addComponent(jTextFieldKomentar)
                            .addComponent(jComboBoxTipSmene, 0, 260, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelNaslov)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProstorija)
                    .addComponent(jTextFieldProstorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKomentar)
                    .addComponent(jTextFieldKomentar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipSmene)
                    .addComponent(jComboBoxTipSmene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSacuvaj)
                    .addComponent(jButtonOdustani))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacuvajActionPerformed
        String prostorija = jTextFieldProstorija.getText().trim();
        String komentar = jTextFieldKomentar.getText().trim();
        String tipStr = (String) jComboBoxTipSmene.getSelectedItem();

        if (prostorija.isEmpty() || komentar.isEmpty() || tipStr == null) {
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            TipSmene tipSmene = TipSmene.valueOf(tipStr);
            Controller.getInstance().addShift(prostorija, komentar, tipSmene);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio smenu.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti smenu.\n" + e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSacuvajActionPerformed

    private void jButtonOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonOdustaniActionPerformed

    private void initTipSmene() {
        jComboBoxTipSmene.removeAllItems();
        for (TipSmene tip : TipSmene.values()) {
            jComboBoxTipSmene.addItem(tip.name());
        }
    }

    private void dodajStil() {
        getContentPane().setBackground(new Color(0x1C2B3A));

        jLabelNaslov.setForeground(new Color(0xE07B00));
        jLabelNaslov.setFont(jLabelNaslov.getFont().deriveFont(java.awt.Font.BOLD, 18f));

        jLabelProstorija.setForeground(Color.WHITE);
        jLabelKomentar.setForeground(Color.WHITE);
        jLabelTipSmene.setForeground(Color.WHITE);

        stilizujDugme(jButtonSacuvaj, new Color(0xE07B00));
        stilizujDugme(jButtonOdustani, new Color(0xC0392B));

        setTitle("Kreiraj smenu");
    }

    private void stilizujDugme(javax.swing.JButton button, Color background) {
        button.setBackground(background);
        button.setForeground(Color.WHITE);
        button.setFont(button.getFont().deriveFont(java.awt.Font.BOLD, 14f));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.putClientProperty("JButton.buttonType", "roundRect");
        button.setOpaque(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOdustani;
    private javax.swing.JButton jButtonSacuvaj;
    private javax.swing.JComboBox jComboBoxTipSmene;
    private javax.swing.JLabel jLabelKomentar;
    private javax.swing.JLabel jLabelNaslov;
    private javax.swing.JLabel jLabelProstorija;
    private javax.swing.JLabel jLabelTipSmene;
    private javax.swing.JTextField jTextFieldKomentar;
    private javax.swing.JTextField jTextFieldProstorija;
    // End of variables declaration//GEN-END:variables
}
