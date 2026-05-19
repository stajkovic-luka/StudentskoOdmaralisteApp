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

public class NovaFakturaForm extends javax.swing.JDialog {

    private List<Student> studenti = new ArrayList<>();
    private List<Nocenje> nocenja = new ArrayList<>();
    private List<StavkaFakture> stavke = new ArrayList<>();
    private Sluzbenik ulogovaniSluzbenik;
    private int rbCounter = 1;

    public NovaFakturaForm(java.awt.Dialog parent, boolean modal, Sluzbenik sluzbenik) {
        super(parent, modal);
        this.ulogovaniSluzbenik = sluzbenik;
        initComponents();
        jTableStavke.setModel(new TableModelStavke());
        setLocationRelativeTo(parent);
        dodajStil();
        ucitajStudente();
        ucitajNocenja();
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
        jButtonDodaj = new javax.swing.JButton();
        jButtonUkloni = new javax.swing.JButton();
        jScrollPaneStavke = new javax.swing.JScrollPane();
        jTableStavke = new javax.swing.JTable();
        jLabelUkupno = new javax.swing.JLabel();
        jTextFieldUkupno = new javax.swing.JTextField();
        jLabelNakonPopusta = new javax.swing.JLabel();
        jTextFieldNakonPopusta = new javax.swing.JTextField();
        jButtonKreiraj = new javax.swing.JButton();
        jButtonOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova faktura odmora");
        setResizable(false);

        jLabelNaslov.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabelNaslov.setText("Nova faktura odmora");

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

        jButtonDodaj.setText("Dodaj");
        jButtonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajActionPerformed(evt);
            }
        });

        jButtonUkloni.setText("Ukloni");
        jButtonUkloni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUkloniActionPerformed(evt);
            }
        });

        jTableStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rb", "Nocenje", "Datum od", "Datum do", "Dorucak", "Cena", "Br. dana", "Dod. troskovi", "Iznos"
            }
        ));
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
                            .addComponent(jButtonDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUkloni, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(jButtonDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerOd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerDo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUkloni, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jButtonKreiraj.setText("Kreiraj fakturu");
        jButtonKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKreirajActionPerformed(evt);
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
                        .addComponent(jButtonKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jButtonKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
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

        LocalDate danas = LocalDate.now();
        if (datumOd.isBefore(danas)) {
            JOptionPane.showMessageDialog(this, "Datum od ne moze biti u proslosti.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (datumDo.isBefore(danas)) {
            JOptionPane.showMessageDialog(this, "Datum do ne moze biti u proslosti.", "Greska", JOptionPane.ERROR_MESSAGE);
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

        StavkaFakture stavka = new StavkaFakture();
        stavka.setRb(rbCounter++);
        stavka.setNocenje(nocenje);
        stavka.setDorucakUkljucen(dorucak);
        stavka.setDatumOd(datumOd);
        stavka.setDatumDo(datumDo);
        stavka.setBrojDana(brojDana);
        stavka.setCena(cena);
        stavka.setDodatniTroskovi(dodatniTroskovi);
        stavka.setIznos(iznos);

        stavke.add(stavka);
        osveziTabeluStavki();
        preracunajUkupno();
        resetujStavkaPanel();
    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonUkloniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUkloniActionPerformed
        int row = jTableStavke.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite stavku koju zelite da uklonite.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        stavke.remove(row);
        rbCounter = 1;
        for (StavkaFakture s : stavke) {
            s.setRb(rbCounter++);
        }
        osveziTabeluStavki();
        preracunajUkupno();
    }//GEN-LAST:event_jButtonUkloniActionPerformed

    private void jButtonKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKreirajActionPerformed
        if (jComboStudent.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite studenta.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (stavke.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Dodajte bar jednu stavku.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = (Student) jComboStudent.getSelectedItem();
        double popust = student.isBudzet() ? 0.3 : 0;
        double ukupanIznos = stavke.stream().mapToDouble(StavkaFakture::getIznos).sum();
        double iznosNakonPopusta = ukupanIznos * (1 - popust);

        FakturaOdmora faktura = new FakturaOdmora();
        faktura.setStudent(student);
        faktura.setSluzbenik(ulogovaniSluzbenik);
        faktura.setNapomena(jTextAreaNapomena.getText().trim());
        faktura.setPopust(popust);
        faktura.setUkupanIznos(ukupanIznos);
        faktura.setIznosNakonPopusta(iznosNakonPopusta);
        faktura.setStavkeFakture(stavke);

        try {
            Controller.getInstance().createInvoice(faktura);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio fakturu odmora.", "Faktura", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti fakturu odmora.\n" + e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonKreirajActionPerformed

    private void jButtonOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonOtkaziActionPerformed

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
            jComboStudent.setSelectedIndex(-1);
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

        stilizujDugme(jButtonDodaj, new Color(0xE07B00));
        stilizujDugme(jButtonUkloni, new Color(0xC0392B));
        stilizujDugme(jButtonKreiraj, new Color(0xE07B00));
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
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonKreiraj;
    private javax.swing.JButton jButtonOtkazi;
    private javax.swing.JButton jButtonUkloni;
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
