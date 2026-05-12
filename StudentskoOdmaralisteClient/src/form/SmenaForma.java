package form;

import controller.Controller;
import domain.DomainObject;
import domain.Smena;
import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import table.model.TableModelSmena;
import table.model.TableUtils;

public class SmenaForma extends javax.swing.JDialog {

    private List<Smena> smene = new ArrayList<>();

    public SmenaForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTableSmene.setModel(new TableModelSmena());
        setLocationRelativeTo(parent);
        dodajStil();
        popuniTabeluSmene();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNaslov = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSmene = new javax.swing.JTable();
        jButtonDodajSmenu = new javax.swing.JButton();
        jButtonNazad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Smene");
        setResizable(false);

        jLabelNaslov.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelNaslov.setText("Pregled smena");

        jTableSmene.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Prostorija", "Komentar", "Tip smene"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableSmene);

        jButtonDodajSmenu.setText("Dodaj smenu");
        jButtonDodajSmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajSmenuActionPerformed(evt);
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
                    .addComponent(jLabelNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDodajSmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonNazad)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelNaslov)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDodajSmenu))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonNazad)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDodajSmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajSmenuActionPerformed
        NovaSmenaForma forma = new NovaSmenaForma((java.awt.Frame) getParent(), true);
        forma.setVisible(true);
        popuniTabeluSmene();
    }//GEN-LAST:event_jButtonDodajSmenuActionPerformed

    private void jButtonNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNazadActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonNazadActionPerformed

    private void popuniTabeluSmene() {
        try {
            List<DomainObject> list = Controller.getInstance().getAllShifts();
            smene = new ArrayList<>();
            for (DomainObject d : list) {
                smene.add((Smena) d);
            }

            TableModelSmena model = (TableModelSmena) jTableSmene.getModel();
            model.setSmene(smene);
            TableUtils.autoResizeTable(jTableSmene);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita smene.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dodajStil() {
        getContentPane().setBackground(new Color(0x1C2B3A));

        jLabelNaslov.setForeground(new Color(0xE07B00));
        jLabelNaslov.setFont(jLabelNaslov.getFont().deriveFont(java.awt.Font.BOLD, 18f));

        JTableHeader header = jTableSmene.getTableHeader();
        header.setBackground(new Color(0x2C3E50));
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(java.awt.Font.BOLD, 13f));

        jTableSmene.setRowHeight(24);
        jTableSmene.setSelectionBackground(new Color(0xE07B00));
        jTableSmene.setSelectionForeground(Color.WHITE);
        jScrollPane1.getViewport().setBackground(Color.WHITE);

        stilizujDugme(jButtonDodajSmenu, new Color(0xE07B00));
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
    private javax.swing.JButton jButtonDodajSmenu;
    private javax.swing.JButton jButtonNazad;
    private javax.swing.JLabel jLabelNaslov;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSmene;
    // End of variables declaration//GEN-END:variables
}
