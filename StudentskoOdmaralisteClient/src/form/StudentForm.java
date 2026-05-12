package form;

import controller.Controller;
import domain.DomainObject;
import domain.Student;
import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNazad))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonIzmeniStudenta, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(jButtonNoviStudent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonObrisiStudenta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelNaslov)
                .addGap(18, 18, 18)
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
        NoviStudentForm forma = new NoviStudentForm((java.awt.Frame) getParent(), true);
        forma.setVisible(true);
        popuniTabeluStudenti();
    }//GEN-LAST:event_jButtonNoviStudentActionPerformed

    private void jButtonNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNazadActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonNazadActionPerformed

    private void jButtonIzmeniStudentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniStudentaActionPerformed
        int selektovaniRed = jTableStudenti.getSelectedRow();
        if (selektovaniRed == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Izaberite studenta kojeg zelite da izmenite.",
                    "Greska",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Student selektovani = students.get(selektovaniRed);
        IzmeniStudent forma = new IzmeniStudent((java.awt.Frame) getParent(), true, selektovani);
        forma.setLocationRelativeTo(this);
        forma.setVisible(true);
        popuniTabeluStudenti();
    }//GEN-LAST:event_jButtonIzmeniStudentaActionPerformed

    private void jButtonObrisiStudentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiStudentaActionPerformed
        int selektovaniRed = jTableStudenti.getSelectedRow();
        if (selektovaniRed == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Izaberite studenta kojeg zelite da obrisete.",
                    "Greska",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        int potvrda = JOptionPane.showConfirmDialog(
                this,
                "Da li ste sigurni da zelite da obrisete studenta?",
                "Potvrda brisanja",
                JOptionPane.YES_NO_OPTION
        );

        if (potvrda == JOptionPane.YES_OPTION) {
            try {
                Student selektovani = students.get(selektovaniRed);
                Controller.getInstance().deleteStudent(selektovani);
                JOptionPane.showMessageDialog(
                        this,
                        "Sistem je obrisao studenta.",
                        "Brisanje studenta",
                        JOptionPane.INFORMATION_MESSAGE
                );
                popuniTabeluStudenti();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        this,
                        "Sistem ne moze da obrise studenta.\n" + e.getMessage(),
                        "Greska",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_jButtonObrisiStudentaActionPerformed

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

        jLabelNaslov.setForeground(new Color(0xE07B00));
        jLabelNaslov.setFont(jLabelNaslov.getFont().deriveFont(java.awt.Font.BOLD, 18f));

        JTableHeader header = jTableStudenti.getTableHeader();
        header.setBackground(new Color(0x2C3E50));
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(java.awt.Font.BOLD, 13f));

        jTableStudenti.setRowHeight(24);
        jTableStudenti.setSelectionBackground(new Color(0xE07B00));
        jTableStudenti.setSelectionForeground(Color.WHITE);
        jScrollPane1.getViewport().setBackground(Color.WHITE);

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
    private javax.swing.JLabel jLabelNaslov;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStudenti;
    // End of variables declaration//GEN-END:variables
}
