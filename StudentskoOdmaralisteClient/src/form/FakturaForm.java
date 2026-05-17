package form;

import controller.Controller;
import domain.DomainObject;
import domain.FakturaOdmora;
import domain.Nocenje;
import domain.StavkaFakture;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import table.model.TableModelFaktura;
import table.model.TableModelStavke;
import table.model.TableUtils;

public class FakturaForm extends javax.swing.JDialog {

    private List<FakturaOdmora> fakture = new ArrayList<>();
    private List<Nocenje> nocenja = new ArrayList<>();

    public FakturaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTableFakture.setModel(new TableModelFaktura());
        jTableStavke.setModel(new TableModelStavke());
        setLocationRelativeTo(parent);
        dodajStil();
        ucitajNocenja();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNaslov = new javax.swing.JLabel();
        jPanelSearch = new javax.swing.JPanel();
        jCheckSluzbenik = new javax.swing.JCheckBox();
        jTextFieldSluzbenik = new javax.swing.JTextField();
        jCheckStudent = new javax.swing.JCheckBox();
        jTextFieldStudent = new javax.swing.JTextField();
        jCheckNocenje = new javax.swing.JCheckBox();
        jComboNocenje = new javax.swing.JComboBox<>();
        jButtonPretrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFakture = new javax.swing.JTable();
        jButtonNovi = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonPrikaziSve = new javax.swing.JButton();
        jLabelStavke = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableStavke = new javax.swing.JTable();
        jButtonNazad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fakture odmora");
        setResizable(false);

        jLabelNaslov.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabelNaslov.setText("Pregled faktura odmora");

        jPanelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraga"));
        jPanelSearch.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 4));

        jCheckSluzbenik.setText("Sluzbenik");
        jCheckSluzbenik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckSluzbenikActionPerformed(evt);
            }
        });
        jPanelSearch.add(jCheckSluzbenik);

        jTextFieldSluzbenik.setEditable(false);
        jTextFieldSluzbenik.setEnabled(false);
        jTextFieldSluzbenik.setPreferredSize(new java.awt.Dimension(150, 28));
        jPanelSearch.add(jTextFieldSluzbenik);

        jCheckStudent.setText("Student");
        jCheckStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckStudentActionPerformed(evt);
            }
        });
        jPanelSearch.add(jCheckStudent);

        jTextFieldStudent.setEditable(false);
        jTextFieldStudent.setEnabled(false);
        jTextFieldStudent.setPreferredSize(new java.awt.Dimension(150, 28));
        jPanelSearch.add(jTextFieldStudent);

        jCheckNocenje.setText("Nocenje");
        jCheckNocenje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckNocenjeActionPerformed(evt);
            }
        });
        jPanelSearch.add(jCheckNocenje);

        jComboNocenje.setEnabled(false);
        jComboNocenje.setPreferredSize(new java.awt.Dimension(150, 28));
        jPanelSearch.add(jComboNocenje);

        jButtonPretrazi.setIcon(new javax.swing.ImageIcon(
                new javax.swing.ImageIcon(getClass().getResource("/image/lupa.png"))
                        .getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)));
        jButtonPretrazi.setToolTipText("Pretrazi");
        jButtonPretrazi.setPreferredSize(new java.awt.Dimension(50, 30));
        jButtonPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPretraziActionPerformed(evt);
            }
        });
        jPanelSearch.add(jButtonPretrazi);

        jTableFakture.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableFakture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFaktureMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFakture);

        jButtonNovi.setText("Nova faktura");
        jButtonNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNoviActionPerformed(evt);
            }
        });

        jButtonIzmeni.setText("Izmeni fakturu");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        jButtonPrikaziSve.setText("Prikazi sve");
        jButtonPrikaziSve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrikaziSveActionPerformed(evt);
            }
        });

        jLabelStavke.setFont(new java.awt.Font("Segoe UI", 2, 13));
        jLabelStavke.setText("Stavke fakture");

        jTableStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableStavke.setEnabled(false);
        jScrollPane2.setViewportView(jTableStavke);

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
                    .addComponent(jLabelNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonNovi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPrikaziSve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabelStavke, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNazad))
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
                        .addComponent(jButtonNovi)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonIzmeni)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPrikaziSve))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabelStavke)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jButtonNazad)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckSluzbenikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckSluzbenikActionPerformed
        jTextFieldSluzbenik.setEnabled(jCheckSluzbenik.isSelected());
        jTextFieldSluzbenik.setEditable(jCheckSluzbenik.isSelected());
        if (!jCheckSluzbenik.isSelected()) jTextFieldSluzbenik.setText("");
    }//GEN-LAST:event_jCheckSluzbenikActionPerformed

    private void jCheckStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckStudentActionPerformed
        jTextFieldStudent.setEnabled(jCheckStudent.isSelected());
        jTextFieldStudent.setEditable(jCheckStudent.isSelected());
        if (!jCheckStudent.isSelected()) jTextFieldStudent.setText("");
    }//GEN-LAST:event_jCheckStudentActionPerformed

    private void jCheckNocenjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckNocenjeActionPerformed
        jComboNocenje.setEnabled(jCheckNocenje.isSelected());
        if (!jCheckNocenje.isSelected()) jComboNocenje.setSelectedIndex(-1);
    }//GEN-LAST:event_jCheckNocenjeActionPerformed

    private void jButtonPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPretraziActionPerformed
        String sluzbenik = jCheckSluzbenik.isSelected() ? jTextFieldSluzbenik.getText().trim() : null;
        String student = jCheckStudent.isSelected() ? jTextFieldStudent.getText().trim() : null;
        Long nocenjeId = null;
        if (jCheckNocenje.isSelected() && jComboNocenje.getSelectedItem() != null) {
            Nocenje n = (Nocenje) jComboNocenje.getSelectedItem();
            nocenjeId = n.getIdNocenje();
        }

        if ((sluzbenik == null || sluzbenik.isBlank()) && (student == null || student.isBlank()) && nocenjeId == null) {
            JOptionPane.showMessageDialog(this, "Izaberite bar jedan kriterijum za pretragu.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            List<DomainObject> list = Controller.getInstance().searchInvoices(sluzbenik, student, nocenjeId);
            fakture = new ArrayList<>();
            for (DomainObject d : list) {
                fakture.add((FakturaOdmora) d);
            }

            TableModelFaktura model = (TableModelFaktura) jTableFakture.getModel();
            model.setFakture(fakture);
            TableUtils.autoResizeTable(jTableFakture);

            ocistiStavke();

            if (fakture.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje fakture odmora po zadatim kriterijumima", "Pretraga", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Sistem je nasao fakture odmora po zadatim kriterijumima", "Pretraga", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje fakture odmora po zadatim kriterijumima\n" + e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPretraziActionPerformed

    private void jTableFaktureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFaktureMouseClicked
        int row = jTableFakture.getSelectedRow();
        if (row == -1) return;
        try {
            FakturaOdmora selected = fakture.get(row);
            FakturaOdmora loaded = Controller.getInstance().findInvoiceById(selected.getIdFaktura());
            prikaziStavke(loaded);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita stavke fakture.\n" + e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTableFaktureMouseClicked

    private void jButtonPrikaziSveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrikaziSveActionPerformed
        resetujPretragu();
        try {
            List<DomainObject> list = Controller.getInstance().getAllInvoices();
            fakture = new ArrayList<>();
            for (DomainObject d : list) {
                fakture.add((FakturaOdmora) d);
            }
            TableModelFaktura model = (TableModelFaktura) jTableFakture.getModel();
            model.setFakture(fakture);
            TableUtils.autoResizeTable(jTableFakture);
            ocistiStavke();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita fakture.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPrikaziSveActionPerformed

    private void jButtonNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNoviActionPerformed
        JOptionPane.showMessageDialog(this, "TODO: SK1 - Kreiraj fakturu odmora", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonNoviActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        int row = jTableFakture.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite fakturu koju zelite da izmenite.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "TODO: SK3 - Promeni fakturu odmora", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNazadActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonNazadActionPerformed

    private void ucitajNocenja() {
        try {
            List<DomainObject> list = Controller.getInstance().getAllNocenje();
            nocenja = new ArrayList<>();
            for (DomainObject d : list) {
                nocenja.add((Nocenje) d);
            }
            jComboNocenje.removeAllItems();
            for (Nocenje n : nocenja) {
                jComboNocenje.addItem(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prikaziStavke(FakturaOdmora faktura) {
        jTableStavke.setEnabled(true);
        TableModelStavke model = (TableModelStavke) jTableStavke.getModel();
        model.setStavke(faktura.getStavkeFakture());
        TableUtils.autoResizeTable(jTableStavke);
    }

    private void ocistiStavke() {
        jTableStavke.setEnabled(false);
        TableModelStavke model = (TableModelStavke) jTableStavke.getModel();
        model.setStavke(new ArrayList<>());
    }

    private void resetujPretragu() {
        jCheckSluzbenik.setSelected(false);
        jTextFieldSluzbenik.setText("");
        jTextFieldSluzbenik.setEnabled(false);
        jTextFieldSluzbenik.setEditable(false);
        jCheckStudent.setSelected(false);
        jTextFieldStudent.setText("");
        jTextFieldStudent.setEnabled(false);
        jTextFieldStudent.setEditable(false);
        jCheckNocenje.setSelected(false);
        jComboNocenje.setSelectedIndex(-1);
        jComboNocenje.setEnabled(false);
    }

    private void dodajStil() {
        getContentPane().setBackground(new Color(0x1C2B3A));
        jPanelSearch.setBackground(new Color(0x1C2B3A));
        jPanelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "Pretraga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION, null, Color.WHITE));

        jLabelNaslov.setForeground(new Color(0xE07B00));
        jLabelNaslov.setFont(jLabelNaslov.getFont().deriveFont(java.awt.Font.BOLD, 18f));

        jLabelStavke.setForeground(new Color(0xE07B00));

        jCheckSluzbenik.setForeground(Color.WHITE);
        jCheckSluzbenik.setBackground(new Color(0x1C2B3A));
        jCheckStudent.setForeground(Color.WHITE);
        jCheckStudent.setBackground(new Color(0x1C2B3A));
        jCheckNocenje.setForeground(Color.WHITE);
        jCheckNocenje.setBackground(new Color(0x1C2B3A));

        jTextFieldSluzbenik.setFont(jTextFieldSluzbenik.getFont().deriveFont(13f));
        jTextFieldStudent.setFont(jTextFieldStudent.getFont().deriveFont(13f));
        jComboNocenje.setFont(jComboNocenje.getFont().deriveFont(13f));

        JTableHeader h1 = jTableFakture.getTableHeader();
        h1.setBackground(new Color(0x2C3E50));
        h1.setForeground(Color.WHITE);
        h1.setFont(h1.getFont().deriveFont(java.awt.Font.BOLD, 13f));
        jTableFakture.setRowHeight(24);
        jTableFakture.setSelectionBackground(new Color(0xE07B00));
        jTableFakture.setSelectionForeground(Color.WHITE);
        jTableFakture.setBackground(new Color(0xF5F0E8));
        jScrollPane1.getViewport().setBackground(new Color(0xF5F0E8));

        JTableHeader h2 = jTableStavke.getTableHeader();
        h2.setBackground(new Color(0x2C3E50));
        h2.setForeground(Color.WHITE);
        h2.setFont(h2.getFont().deriveFont(java.awt.Font.BOLD, 13f));
        jTableStavke.setRowHeight(24);
        jTableStavke.setBackground(new Color(0xF5F0E8));
        jScrollPane2.getViewport().setBackground(new Color(0xF5F0E8));

        stilizujDugme(jButtonPretrazi, new Color(0xE07B00));
        stilizujDugme(jButtonNovi, new Color(0xE07B00));
        stilizujDugme(jButtonIzmeni, new Color(0xE07B00));
        stilizujDugme(jButtonPrikaziSve, new Color(0x34495E));
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
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonNazad;
    private javax.swing.JButton jButtonNovi;
    private javax.swing.JButton jButtonPretrazi;
    private javax.swing.JButton jButtonPrikaziSve;
    private javax.swing.JCheckBox jCheckNocenje;
    private javax.swing.JCheckBox jCheckSluzbenik;
    private javax.swing.JCheckBox jCheckStudent;
    private javax.swing.JComboBox<Nocenje> jComboNocenje;
    private javax.swing.JLabel jLabelNaslov;
    private javax.swing.JLabel jLabelStavke;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFakture;
    private javax.swing.JTable jTableStavke;
    private javax.swing.JTextField jTextFieldSluzbenik;
    private javax.swing.JTextField jTextFieldStudent;
    // End of variables declaration//GEN-END:variables
}
