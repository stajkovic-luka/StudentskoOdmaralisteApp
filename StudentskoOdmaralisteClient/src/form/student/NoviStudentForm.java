package form.student;

import controller.Controller;
import domain.Fakultet;
import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class NoviStudentForm extends javax.swing.JDialog {

    private List<Fakultet> fakulteti = new ArrayList<>();
    private domain.Student student;
    private boolean saved = false;

    public NoviStudentForm(java.awt.Frame parent, boolean modal, domain.Student student) {
        super(parent, modal);
        this.student = student;
        initComponents();
        setLocationRelativeTo(parent);
        initFakulteti();
        dodajStil();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (!saved) {
                    try {
                        Controller.getInstance().deleteStudent(student);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNaslov = new javax.swing.JLabel();
        jLabelIme = new javax.swing.JLabel();
        jLabelPrezime = new javax.swing.JLabel();
        jLabelTelefon = new javax.swing.JLabel();
        jLabelFakultet = new javax.swing.JLabel();
        jTextFieldIme = new javax.swing.JTextField();
        jTextFieldPrezime = new javax.swing.JTextField();
        jTextFieldTelefon = new javax.swing.JTextField();
        jComboBoxFakultet = new javax.swing.JComboBox();
        jCheckBoxBudzet = new javax.swing.JCheckBox();
        jButtonSacuvaj = new javax.swing.JButton();
        jButtonOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novi student");

        jLabelNaslov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelNaslov.setText("Kreiraj studenta");

        jLabelIme.setText("Ime:");

        jLabelPrezime.setText("Prezime:");

        jLabelTelefon.setText("Broj telefona:");

        jLabelFakultet.setText("Fakultet:");

        jComboBoxFakultet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFakultetActionPerformed(evt);
            }
        });

        jCheckBoxBudzet.setText("Budzet");

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
                            .addComponent(jLabelIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelFakultet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIme)
                            .addComponent(jTextFieldPrezime)
                            .addComponent(jTextFieldTelefon)
                            .addComponent(jComboBoxFakultet, 0, 260, Short.MAX_VALUE)
                            .addComponent(jCheckBoxBudzet)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelNaslov)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIme)
                    .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrezime)
                    .addComponent(jTextFieldPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefon)
                    .addComponent(jTextFieldTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFakultet)
                    .addComponent(jComboBoxFakultet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxBudzet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSacuvaj)
                    .addComponent(jButtonOdustani))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFakultetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFakultetActionPerformed
    }//GEN-LAST:event_jComboBoxFakultetActionPerformed

    private void jButtonSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacuvajActionPerformed
        String ime = jTextFieldIme.getText().trim();
        String prezime = jTextFieldPrezime.getText().trim();
        String telefon = jTextFieldTelefon.getText().trim();

        if (ime.isEmpty() || prezime.isEmpty() || telefon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!ime.matches("[\\p{L} ]+") || !prezime.matches("[\\p{L} ]+")) {
            JOptionPane.showMessageDialog(this, "Ime i prezime mogu da sadrze samo slova.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!telefon.matches("\\d{6,15}")) {
            JOptionPane.showMessageDialog(this, "Broj telefona mora da sadrzi samo cifre (6-15).", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int selected = jComboBoxFakultet.getSelectedIndex();
        if (selected < 0 || selected >= fakulteti.size()) {
            JOptionPane.showMessageDialog(this, "Izaberite fakultet.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            student.setIme(ime);
            student.setPrezime(prezime);
            student.setBrTelefona(Long.parseLong(telefon));
            student.setBudzet(jCheckBoxBudzet.isSelected());
            student.setFakultet(fakulteti.get(selected));

            Controller.getInstance().updateStudent(student);
            saved = true;
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio studenta.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti studenta\n" + e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSacuvajActionPerformed

    private void jButtonOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdustaniActionPerformed
        try {
            Controller.getInstance().deleteStudent(student);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Greska pri brisanju placeholder studenta.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_jButtonOdustaniActionPerformed

    private void initFakulteti() {
        try {
            List<domain.DomainObject> list = Controller.getInstance().getAllFaculties();
            jComboBoxFakultet.removeAllItems();
            fakulteti.clear();
            for (domain.DomainObject d : list) {
                Fakultet f = (Fakultet) d;
                fakulteti.add(f);
                jComboBoxFakultet.addItem(f.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita fakultete.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dodajStil() {
        getContentPane().setBackground(new Color(0x1C2B3A));

        jLabelNaslov.setForeground(new Color(0xE07B00));
        jLabelNaslov.setFont(jLabelNaslov.getFont().deriveFont(java.awt.Font.BOLD, 18f));

        jLabelIme.setForeground(Color.WHITE);
        jLabelPrezime.setForeground(Color.WHITE);
        jLabelTelefon.setForeground(Color.WHITE);
        jLabelFakultet.setForeground(Color.WHITE);
        jCheckBoxBudzet.setForeground(Color.WHITE);
        jCheckBoxBudzet.setOpaque(false);

        stilizujDugme(jButtonSacuvaj, new Color(0xE07B00));
        stilizujDugme(jButtonOdustani, new Color(0xC0392B));

        setTitle("Kreiraj studenta");
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
    private javax.swing.JCheckBox jCheckBoxBudzet;
    private javax.swing.JComboBox jComboBoxFakultet;
    private javax.swing.JLabel jLabelFakultet;
    private javax.swing.JLabel jLabelIme;
    private javax.swing.JLabel jLabelNaslov;
    private javax.swing.JLabel jLabelPrezime;
    private javax.swing.JLabel jLabelTelefon;
    private javax.swing.JTextField jTextFieldIme;
    private javax.swing.JTextField jTextFieldPrezime;
    private javax.swing.JTextField jTextFieldTelefon;
    // End of variables declaration//GEN-END:variables
}
