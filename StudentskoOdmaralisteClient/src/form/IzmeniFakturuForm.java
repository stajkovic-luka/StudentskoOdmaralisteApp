package form;

import controller.Controller;
import domain.DomainObject;
import domain.FakturaOdmora;
import domain.Nocenje;
import domain.Sluzbenik;
import domain.StavkaFakture;
import domain.Student;
import java.awt.Color;
import java.awt.Cursor;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import com.github.lgooddatepicker.components.DatePicker;
import table.model.TableModelStavke;
import table.model.TableUtils;

public class IzmeniFakturuForm extends javax.swing.JDialog {

    private FakturaOdmora faktura;
    private List<Student> studenti = new ArrayList<>();
    private List<Nocenje> nocenja = new ArrayList<>();
    private List<StavkaFakture> stavke = new ArrayList<>();
    private int selectedStavkaIndex = -1;

    public IzmeniFakturuForm(java.awt.Dialog parent, boolean modal, FakturaOdmora faktura, Sluzbenik sluzbenik) {
        super(parent, modal);
        this.faktura = faktura;
        initComponents();
        jTableStavke.setModel(new TableModelStavke());
        setLocationRelativeTo(parent);
        dodajStil();
        ucitajStudente();
        ucitajNocenja();
        popuniFormu();
        jComboStudent.addActionListener(e -> preracunajUkupno());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNaslov = new javax.swing.JLabel();
        jLabelStudent = new javax.swing.JLabel();
        jComboStudent = new javax.swing.JComboBox<>();
        jLabelNapomena = new javax.swing.JLabel();
        jScrollPaneNapomena = new javax.swing.JScrollPane();
        jTextAreaNapomena = new javax.swing.JTextArea();
        jPanelStavke = new javax.swing.JPanel();
        jLabelNocenje = new javax.swing.JLabel();
        jComboNocenje = new javax.swing.JComboBox<>();
        jCheckDorucak = new javax.swing.JCheckBox();
        jLabelDatumOd = new javax.swing.JLabel();
        datePickerOd = new DatePicker();
        jLabelDatumDo = new javax.swing.JLabel();
        datePickerDo = new DatePicker();
        jLabelDodatni = new javax.swing.JLabel();
        jTextFieldDodatni = new javax.swing.JTextField();
        jButtonIzmeniStavku = new javax.swing.JButton();
        jScrollPaneStavke = new javax.swing.JScrollPane();
        jTableStavke = new javax.swing.JTable();
        jLabelUkupno = new javax.swing.JLabel();
        jTextFieldUkupno = new javax.swing.JTextField();
        jLabelNakonPopusta = new javax.swing.JLabel();
        jTextFieldNakonPopusta = new javax.swing.JTextField();
        jButtonZapamti = new javax.swing.JButton();
        jButtonOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Izmena fakture odmora");
        setResizable(false);

        jLabelNaslov.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabelNaslov.setText("Izmena fakture odmora");

        jLabelStudent.setText("Student:");

        jLabelNapomena.setText("Napomena:");

        jTextAreaNapomena.setColumns(30);
        jTextAreaNapomena.setRows(3);
        jTextAreaNapomena.setLineWrap(true);
        jTextAreaNapomena.setWrapStyleWord(true);
        jScrollPaneNapomena.setViewportView(jTextAreaNapomena);

        jPanelStavke.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavke fakture"));

        jLabelNocenje.setText("Nocenje:");

        jCheckDorucak.setText("Dorucak");

        jLabelDatumOd.setText("Datum od:");

        jLabelDatumDo.setText("Datum do:");

        jLabelDodatni.setText("Dodatni troskovi:");

        jTextFieldDodatni.setText("0");

        jButtonIzmeniStavku.setText("Izmeni");
        jButtonIzmeniStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniStavkuActionPerformed(evt);
            }
        });

        jTableStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rb", "Nocenje", "Datum od", "Datum do", "Dorucak", "Cena", "Br. dana", "Dod. troskovi", "Iznos"
            }
        ));
        jTableStavke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableStavkeMouseClicked(evt);
            }
        });
        jScrollPaneStavke.setViewportView(jTableStavke);

        javax.swing.GroupLayout jPanelStavkeLayout = new javax.swing.GroupLayout(jPanelStavke);
        jPanelStavke.setLayout(jPanelStavkeLayout);
        jPanelStavkeLayout.setHorizontalGroup(
            jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStavkeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneStavke, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelStavkeLayout.createSequentialGroup()
                        .addGroup(jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNocenje, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDodatni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboNocenje, 0, 200, Short.MAX_VALUE)
                            .addComponent(datePickerOd, 0, 200, Short.MAX_VALUE)
                            .addComponent(jTextFieldDodatni, 0, 200, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckDorucak, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabelDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(datePickerDo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonIzmeniStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelStavkeLayout.setVerticalGroup(
            jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStavkeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNocenje, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboNocenje, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckDorucak, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIzmeniStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerOd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerDo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDodatni, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDodatni, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneStavke, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabelUkupno.setText("Ukupan iznos:");

        jTextFieldUkupno.setEditable(false);
        jTextFieldUkupno.setText("0.00");

        jLabelNakonPopusta.setText("Nakon popusta:");

        jTextFieldNakonPopusta.setEditable(false);
        jTextFieldNakonPopusta.setText("0.00");

        jButtonZapamti.setText("Zapamti izmene");
        jButtonZapamti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZapamtiActionPerformed(evt);
            }
        });

        jButtonOtkazi.setText("Otkazi");
        jButtonOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtkaziActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNapomena, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPaneNapomena, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(jComboStudent, 0, 340, Short.MAX_VALUE)))
                    .addComponent(jPanelStavke, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNakonPopusta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNakonPopusta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonZapamti, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelNaslov)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNapomena, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneNapomena, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanelStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNakonPopusta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNakonPopusta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonZapamti, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableStavkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableStavkeMouseClicked
        int row = jTableStavke.getSelectedRow();
        if (row == -1) return;
        selectedStavkaIndex = row;
        StavkaFakture stavka = stavke.get(row);

        for (int i = 0; i < jComboNocenje.getItemCount(); i++) {
            Nocenje n = jComboNocenje.getItemAt(i);
            if (n.getIdNocenje() == stavka.getNocenje().getIdNocenje()) {
                jComboNocenje.setSelectedIndex(i);
                break;
            }
        }
        jCheckDorucak.setSelected(stavka.isDorucakUkljucen());
        datePickerOd.setDate(stavka.getDatumOd());
        datePickerDo.setDate(stavka.getDatumDo());
        jTextFieldDodatni.setText(String.valueOf(stavka.getDodatniTroskovi()));
    }//GEN-LAST:event_jTableStavkeMouseClicked

    private void jButtonIzmeniStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniStavkuActionPerformed
        if (selectedStavkaIndex == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite stavku iz tabele koju zelite da izmenite.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jComboNocenje.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite nocenje.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate datumOd = datePickerOd.getDate();
        LocalDate datumDo = datePickerDo.getDate();
        if (datumOd == null || datumDo == null) {
            JOptionPane.showMessageDialog(this, "Izaberite datum od i datum do.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!datumDo.isAfter(datumOd)) {
            JOptionPane.showMessageDialog(this, "Datum do mora biti posle datuma od.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double dodatniTroskovi = 0;
        try {
            String dodText = jTextFieldDodatni.getText().trim();
            if (!dodText.isEmpty()) {
                dodatniTroskovi = Double.parseDouble(dodText);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dodatni troskovi moraju biti broj.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Nocenje nocenje = (Nocenje) jComboNocenje.getSelectedItem();
        boolean dorucak = jCheckDorucak.isSelected();
        int brojDana = (int) ChronoUnit.DAYS.between(datumOd, datumDo);
        double cena = nocenje.getCena() + (dorucak ? 200 : 0);
        double iznos = brojDana * cena + dodatniTroskovi;

        StavkaFakture stavka = stavke.get(selectedStavkaIndex);
        stavka.setNocenje(nocenje);
        stavka.setDorucakUkljucen(dorucak);
        stavka.setDatumOd(datumOd);
        stavka.setDatumDo(datumDo);
        stavka.setBrojDana(brojDana);
        stavka.setCena(cena);
        stavka.setDodatniTroskovi(dodatniTroskovi);
        stavka.setIznos(iznos);

        osveziTabeluStavki();
        preracunajUkupno();
        selectedStavkaIndex = -1;
        resetujStavkaPanel();
    }//GEN-LAST:event_jButtonIzmeniStavkuActionPerformed

    private void jButtonZapamtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZapamtiActionPerformed
        if (jComboStudent.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite studenta.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (stavke.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mora postojati bar jedna stavka.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = (Student) jComboStudent.getSelectedItem();
        double popust = student.isBudzet() ? 0.3 : 0;
        double ukupanIznos = stavke.stream().mapToDouble(StavkaFakture::getIznos).sum();
        double iznosNakonPopusta = ukupanIznos * (1 - popust);

        faktura.setStudent(student);
        faktura.setNapomena(jTextAreaNapomena.getText().trim());
        faktura.setPopust(popust);
        faktura.setUkupanIznos(ukupanIznos);
        faktura.setIznosNakonPopusta(iznosNakonPopusta);
        faktura.setStavkeFakture(stavke);

        try {
            Controller.getInstance().updateInvoice(faktura);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio fakturu odmora.", "Faktura", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti fakturu odmora.\n" + e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonZapamtiActionPerformed

    private void jButtonOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonOtkaziActionPerformed

    private void popuniFormu() {
        if (faktura.getNapomena() != null) {
            jTextAreaNapomena.setText(faktura.getNapomena());
        }

        for (int i = 0; i < jComboStudent.getItemCount(); i++) {
            Student s = jComboStudent.getItemAt(i);
            if (s.getIdStudent() == faktura.getStudent().getIdStudent()) {
                jComboStudent.setSelectedIndex(i);
                break;
            }
        }

        stavke = new ArrayList<>();
        for (StavkaFakture original : faktura.getStavkeFakture()) {
            StavkaFakture copy = new StavkaFakture();
            copy.setRb(original.getRb());
            copy.setDorucakUkljucen(original.isDorucakUkljucen());
            copy.setDatumOd(original.getDatumOd());
            copy.setDatumDo(original.getDatumDo());
            copy.setBrojDana(original.getBrojDana());
            copy.setCena(original.getCena());
            copy.setIznos(original.getIznos());
            copy.setDodatniTroskovi(original.getDodatniTroskovi());
            copy.setNocenje(original.getNocenje());
            copy.setFakturaOdmora(faktura);
            stavke.add(copy);
        }

        osveziTabeluStavki();
        preracunajUkupno();
    }

    private void osveziTabeluStavki() {
        TableModelStavke model = (TableModelStavke) jTableStavke.getModel();
        model.setStavke(stavke);
        TableUtils.autoResizeTable(jTableStavke);
    }

    private void preracunajUkupno() {
        double ukupanIznos = stavke.stream().mapToDouble(StavkaFakture::getIznos).sum();
        jTextFieldUkupno.setText(String.format("%.2f", ukupanIznos));

        Student student = (Student) jComboStudent.getSelectedItem();
        double popust = (student != null && student.isBudzet()) ? 0.3 : 0;
        double iznosNakonPopusta = ukupanIznos * (1 - popust);
        jTextFieldNakonPopusta.setText(String.format("%.2f", iznosNakonPopusta));
    }

    private void resetujStavkaPanel() {
        jComboNocenje.setSelectedIndex(-1);
        jCheckDorucak.setSelected(false);
        datePickerOd.clear();
        datePickerDo.clear();
        jTextFieldDodatni.setText("0");
    }

    private void ucitajStudente() {
        try {
            List<DomainObject> list = Controller.getInstance().getAllStudentsForCombo();
            studenti = new ArrayList<>();
            for (DomainObject d : list) {
                studenti.add((Student) d);
            }
            jComboStudent.removeAllItems();
            for (Student s : studenti) {
                jComboStudent.addItem(s);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Greska pri ucitavanju studenata.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

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
            jComboNocenje.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Greska pri ucitavanju nocenja.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dodajStil() {
        getContentPane().setBackground(new Color(0x1C2B3A));
        jPanelStavke.setBackground(new Color(0x1C2B3A));
        jPanelStavke.setBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "Stavke fakture", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION, null, Color.WHITE));

        jLabelNaslov.setForeground(new Color(0xE07B00));
        jLabelNaslov.setFont(jLabelNaslov.getFont().deriveFont(java.awt.Font.BOLD, 18f));

        jLabelStudent.setForeground(Color.WHITE);
        jLabelNapomena.setForeground(Color.WHITE);
        jLabelUkupno.setForeground(Color.WHITE);
        jLabelUkupno.setFont(jLabelUkupno.getFont().deriveFont(java.awt.Font.BOLD, 13f));
        jLabelNakonPopusta.setForeground(Color.WHITE);
        jLabelNakonPopusta.setFont(jLabelNakonPopusta.getFont().deriveFont(java.awt.Font.BOLD, 13f));

        jTextFieldUkupno.setFont(jTextFieldUkupno.getFont().deriveFont(java.awt.Font.BOLD, 14f));
        jTextFieldNakonPopusta.setFont(jTextFieldNakonPopusta.getFont().deriveFont(java.awt.Font.BOLD, 14f));

        jCheckDorucak.setForeground(Color.WHITE);
        jCheckDorucak.setBackground(new Color(0x1C2B3A));

        jLabelNocenje.setForeground(Color.WHITE);
        jLabelDatumOd.setForeground(Color.WHITE);
        jLabelDatumDo.setForeground(Color.WHITE);
        jLabelDodatni.setForeground(Color.WHITE);

        jComboNocenje.setFont(jComboNocenje.getFont().deriveFont(13f));

        JTableHeader h = jTableStavke.getTableHeader();
        h.setBackground(new Color(0x2C3E50));
        h.setForeground(Color.WHITE);
        h.setFont(h.getFont().deriveFont(java.awt.Font.BOLD, 13f));
        jTableStavke.setRowHeight(24);
        jTableStavke.setSelectionBackground(new Color(0xE07B00));
        jTableStavke.setSelectionForeground(Color.WHITE);
        jTableStavke.setBackground(new Color(0xF5F0E8));
        jScrollPaneStavke.getViewport().setBackground(new Color(0xF5F0E8));

        jTextAreaNapomena.setBackground(new Color(0xF5F0E8));
        jTextAreaNapomena.setFont(jTextAreaNapomena.getFont().deriveFont(13f));

        stilizujDugme(jButtonIzmeniStavku, new Color(0xE07B00));
        stilizujDugme(jButtonZapamti, new Color(0xE07B00));
        stilizujDugme(jButtonOtkazi, new Color(0x34495E));
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
    private javax.swing.JButton jButtonIzmeniStavku;
    private javax.swing.JButton jButtonOtkazi;
    private javax.swing.JButton jButtonZapamti;
    private javax.swing.JCheckBox jCheckDorucak;
    private javax.swing.JComboBox<Nocenje> jComboNocenje;
    private javax.swing.JComboBox<Student> jComboStudent;
    private javax.swing.JLabel jLabelDatumDo;
    private javax.swing.JLabel jLabelDatumOd;
    private javax.swing.JLabel jLabelDodatni;
    private javax.swing.JLabel jLabelNakonPopusta;
    private javax.swing.JLabel jLabelNaslov;
    private javax.swing.JLabel jLabelNocenje;
    private javax.swing.JLabel jLabelNapomena;
    private javax.swing.JLabel jLabelStudent;
    private javax.swing.JLabel jLabelUkupno;
    private javax.swing.JPanel jPanelStavke;
    private javax.swing.JScrollPane jScrollPaneNapomena;
    private javax.swing.JScrollPane jScrollPaneStavke;
    private javax.swing.JTable jTableStavke;
    private javax.swing.JTextArea jTextAreaNapomena;
    private com.github.lgooddatepicker.components.DatePicker datePickerDo;
    private com.github.lgooddatepicker.components.DatePicker datePickerOd;
    private javax.swing.JTextField jTextFieldDodatni;
    private javax.swing.JTextField jTextFieldNakonPopusta;
    private javax.swing.JTextField jTextFieldUkupno;
    // End of variables declaration//GEN-END:variables
}
