package form.student;

import controller.Controller;
import domain.DomainObject;
import domain.Student;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import table.model.TableModelStudent;
import table.model.TableUtils;

public class StudentForm extends javax.swing.JDialog {

    private List<Student> students = new ArrayList<>();

    public StudentForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTableStudenti.setModel(new table.model.TableModelStudent());
        setLocationRelativeTo(parent);
        dodajStil();
        popuniTabeluStudenti();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNaslov = new javax.swing.JLabel();
        jPanelSearch = new javax.swing.JPanel();
        jLabelPretraga = new javax.swing.JLabel();
        jComboKriterijum = new javax.swing.JComboBox();
        jTextFieldPretraga = new javax.swing.JTextField();
        jButtonPretrazi = new javax.swing.JButton();
        jButtonPrikaziSve = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudenti = new javax.swing.JTable();
        jButtonNoviStudent = new javax.swing.JButton();
        jButtonIzmeniStudenta = new javax.swing.JButton();
        jButtonObrisiStudenta = new javax.swing.JButton();
        jButtonNazad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Studenti");
        setResizable(false);

        jLabelNaslov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelNaslov.setText("Pregled studenata");

        jPanelSearch.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 4));

        jLabelPretraga.setText("Pretraga:");
        jPanelSearch.add(jLabelPretraga);

        jComboKriterijum.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ime", "Prezime", "Broj telefona", "Fakultet" }));
        jComboKriterijum.setPreferredSize(new java.awt.Dimension(130, 28));
        jPanelSearch.add(jComboKriterijum);

        jTextFieldPretraga.setPreferredSize(new java.awt.Dimension(180, 28));
        jPanelSearch.add(jTextFieldPretraga);

        jButtonPretrazi.setIcon(new javax.swing.ImageIcon(
                new javax.swing.ImageIcon(getClass().getResource("/image/lupa.png"))
                        .getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)));
        jButtonPretrazi.setPreferredSize(new java.awt.Dimension(50, 30));
        jButtonPretrazi.setToolTipText("Pretrazi");
        jButtonPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPretraziActionPerformed(evt);
            }
        });
        jPanelSearch.add(jButtonPretrazi);

        jButtonPrikaziSve.setIcon(new javax.swing.ImageIcon(
                new javax.swing.ImageIcon(getClass().getResource("/image/strelica.png"))
                        .getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH)));
        jButtonPrikaziSve.setPreferredSize(new java.awt.Dimension(50, 30));
        jButtonPrikaziSve.setToolTipText("Prikazi sve");
        jButtonPrikaziSve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrikaziSveActionPerformed(evt);
            }
        });
        jPanelSearch.add(jButtonPrikaziSve);

        jTableStudenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Ime", "Prezime", "Fakultet"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableStudenti);

        jButtonNoviStudent.setText("Dodaj studenta");
        jButtonNoviStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNoviStudentActionPerformed(evt);
            }
        });

        jButtonIzmeniStudenta.setText("Izmeni studenta");
        jButtonIzmeniStudenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniStudentaActionPerformed(evt);
            }
        });

        jButtonObrisiStudenta.setText("Obrisi studenta");
        jButtonObrisiStudenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisiStudentaActionPerformed(evt);
            }
        });

        jButtonNazad.setText("Nazad");
        jButtonNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNazadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonObrisiStudenta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonIzmeniStudenta, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jButtonNoviStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabelNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNazad)
                    .addComponent(jPanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelNaslov)
                .addGap(10, 10, 10)
                .addComponent(jPanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNoviStudent)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonIzmeniStudenta)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonObrisiStudenta))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonNazad)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNoviStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNoviStudentActionPerformed
        try {
            domain.Student placeholderStudent = Controller.getInstance().createStudent();
            JOptionPane.showMessageDialog(this, "Sistem je kreirao studenta.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            NoviStudentForm forma = new NoviStudentForm((Frame) getParent(), true, placeholderStudent);
            forma.setVisible(true);
            popuniTabeluStudenti();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira studenta", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonNoviStudentActionPerformed

    private void jButtonNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNazadActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonNazadActionPerformed

    private void jButtonIzmeniStudentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniStudentaActionPerformed
        int selektovaniRed = jTableStudenti.getSelectedRow();
        if (selektovaniRed == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite studenta kojeg zelite da izmenite.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Student selektovani = students.get(selektovaniRed);
            Student nadjeni = Controller.getInstance().findStudentById(selektovani.getIdStudent());
            if (nadjeni == null) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje studenta", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Sistem je nasao studenta", "Pretraga", JOptionPane.INFORMATION_MESSAGE);
            IzmeniStudent forma = new IzmeniStudent((java.awt.Frame) getParent(), true, nadjeni);
            forma.setLocationRelativeTo(this);
            forma.setVisible(true);
            popuniTabeluStudenti();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje studenta", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIzmeniStudentaActionPerformed

    private void jButtonObrisiStudentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiStudentaActionPerformed
        int selektovaniRed = jTableStudenti.getSelectedRow();
        if (selektovaniRed == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite studenta kojeg zelite da obrisete.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Student selektovani = students.get(selektovaniRed);
            Student nadjeni = Controller.getInstance().findStudentById(selektovani.getIdStudent());
            if (nadjeni == null) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje studenta", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Sistem je nasao studenta", "Pretraga", JOptionPane.INFORMATION_MESSAGE);

            int potvrda = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da obrisete studenta?", "Potvrda brisanja", JOptionPane.YES_NO_OPTION);
            if (potvrda == JOptionPane.YES_OPTION) {
                Controller.getInstance().deleteStudent(nadjeni);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao studenta.", "Brisanje studenta", JOptionPane.INFORMATION_MESSAGE);
                popuniTabeluStudenti();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obrisati studenta\n" + e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonObrisiStudentaActionPerformed

    private void jButtonPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPretraziActionPerformed
        String kriterijum = (String) jComboKriterijum.getSelectedItem();
        String vrednost = jTextFieldPretraga.getText().trim();

        if (vrednost.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Unesite vrednost za pretragu.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            List<DomainObject> list = Controller.getInstance().searchStudents(kriterijum, vrednost);
            students = new ArrayList<>();
            for (DomainObject d : list) {
                students.add((Student) d);
            }

            TableModelStudent model = (TableModelStudent) jTableStudenti.getModel();
            model.setStudents(students);
            TableUtils.autoResizeTable(jTableStudenti);

            if (students.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje studente po zadatim kriterijumima", "Pretraga", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Sistem je nasao studente po zadatim kriterijumima", "Pretraga", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje studente po zadatim kriterijumima\n" + e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPretraziActionPerformed

    private void jButtonPrikaziSveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrikaziSveActionPerformed
        jTextFieldPretraga.setText("");
        popuniTabeluStudenti();
    }//GEN-LAST:event_jButtonPrikaziSveActionPerformed

    private void popuniTabeluStudenti() {
        try {
            List<DomainObject> list = Controller.getInstance().getAllStudents();
            students = new ArrayList<>();
            for (DomainObject d : list) {
                students.add((Student) d);
            }

            TableModelStudent model = (TableModelStudent) jTableStudenti.getModel();
            model.setStudents(students);
            TableUtils.autoResizeTable(jTableStudenti);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita studente.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dodajStil() {
        getContentPane().setBackground(new Color(0x1C2B3A));

        jPanelSearch.setBackground(new Color(0x1C2B3A));

        jLabelPretraga.setForeground(new Color(0xE07B00));
        jLabelPretraga.setFont(jLabelPretraga.getFont().deriveFont(java.awt.Font.BOLD, 13f));

        jComboKriterijum.setFont(jComboKriterijum.getFont().deriveFont(13f));
        jTextFieldPretraga.setFont(jTextFieldPretraga.getFont().deriveFont(13f));

        jLabelNaslov.setForeground(new Color(0xE07B00));
        jLabelNaslov.setFont(jLabelNaslov.getFont().deriveFont(java.awt.Font.BOLD, 18f));

        JTableHeader header = jTableStudenti.getTableHeader();
        header.setBackground(new Color(0x2C3E50));
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(java.awt.Font.BOLD, 13f));

        jTableStudenti.setRowHeight(24);
        jTableStudenti.setSelectionBackground(new Color(0xE07B00));
        jTableStudenti.setSelectionForeground(Color.WHITE);
        jTableStudenti.setBackground(new Color(0xF5F0E8));
        jScrollPane1.getViewport().setBackground(new Color(0xF5F0E8));

        stilizujDugme(jButtonPretrazi, new Color(0xE07B00));
        stilizujDugme(jButtonPrikaziSve, new Color(0x34495E));
        stilizujDugme(jButtonNoviStudent, new Color(0xE07B00));
        stilizujDugme(jButtonIzmeniStudenta, new Color(0xE07B00));
        stilizujDugme(jButtonObrisiStudenta, new Color(0xC0392B));
        stilizujDugme(jButtonNazad, new Color(0x34495E));
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
    private javax.swing.JButton jButtonIzmeniStudenta;
    private javax.swing.JButton jButtonNazad;
    private javax.swing.JButton jButtonNoviStudent;
    private javax.swing.JButton jButtonObrisiStudenta;
    private javax.swing.JButton jButtonPretrazi;
    private javax.swing.JButton jButtonPrikaziSve;
    private javax.swing.JComboBox jComboKriterijum;
    private javax.swing.JLabel jLabelNaslov;
    private javax.swing.JLabel jLabelPretraga;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStudenti;
    private javax.swing.JTextField jTextFieldPretraga;
    // End of variables declaration//GEN-END:variables
}
