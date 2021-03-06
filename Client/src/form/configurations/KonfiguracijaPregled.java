/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.configurations;

import controller.Controller;
import domain.Klijent;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import domain.Konfiguracija;
import domain.Servis;
import domain.StavkaKonfiguracije;
import form.configuration.model.TableModelKonfiguracija;
import form.main.Main;
import form.servis.ServisUnos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class KonfiguracijaPregled extends javax.swing.JFrame {
    private Main parent;
    private LinkedList<Konfiguracija> konfiguracije;
    private Konfiguracija konfiguracija;
    TableModelKonfiguracija tbk;

    /**
     * Creates new form Konfiguracija
     */
    public KonfiguracijaPregled() {
        this.konfiguracije = new LinkedList<>();
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        try {
            populateTable();
        } catch (Exception ex) {
            Logger.getLogger(KonfiguracijaPregled.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public KonfiguracijaPregled(Main parent) {
        this.konfiguracije = new LinkedList<>();
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.parent=parent;
        try {
            populateTable();
        } catch (Exception ex) {
            Logger.getLogger(KonfiguracijaPregled.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        txtSerach = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblOdabir = new javax.swing.JLabel();
        cmbServis = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnAddService = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        lblDatum = new javax.swing.JLabel();
        lblOpis = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        lblDatum1 = new javax.swing.JLabel();
        txtServiser = new javax.swing.JTextField();
        lblDatum2 = new javax.swing.JLabel();
        txtBrTel = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKonfiguracije = new javax.swing.JTable();
        lblKomponente = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComponents = new javax.swing.JTextArea();
        btnChoose = new javax.swing.JButton();
        lblVlasnik = new javax.swing.JLabel();
        lblImeVlasnika = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pregled konfiguracija");

        txtSerach.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        lblSearch.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblSearch.setText("Ključni pojam:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblOdabir.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblOdabir.setText("Odabir servisa:");

        cmbServis.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cmbServis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServisActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel3.setText("Pregled servisa");

        btnAddService.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnAddService.setText("Evidentiraj servis");
        btnAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceActionPerformed(evt);
            }
        });

        txtOpis.setEditable(false);
        txtOpis.setColumns(20);
        txtOpis.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtOpis.setRows(5);
        jScrollPane2.setViewportView(txtOpis);

        lblDatum.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblDatum.setText("Datum servisa:");

        lblOpis.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblOpis.setText("Opis servisa:");

        txtDatum.setEditable(false);
        txtDatum.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumActionPerformed(evt);
            }
        });

        lblDatum1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblDatum1.setText("Serviser:");

        txtServiser.setEditable(false);
        txtServiser.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtServiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServiserActionPerformed(evt);
            }
        });

        lblDatum2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblDatum2.setText("Broj telefona:");

        txtBrTel.setEditable(false);
        txtBrTel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtBrTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrTelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblOdabir)
                            .addComponent(lblDatum)
                            .addComponent(lblOpis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(cmbServis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatum)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(lblDatum1))
                            .addComponent(lblDatum2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtServiser)
                            .addComponent(txtBrTel))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOdabir)
                    .addComponent(cmbServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServiser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatum1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrTel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatum2))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOpis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddService)
                .addContainerGap())
        );

        btnAdd.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnAdd.setText("Dodaj");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnSearch.setText("Pretraži");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnUpdate.setText("Izmeni");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tblKonfiguracije.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Vlasnik", "Cena"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblKonfiguracije);

        lblKomponente.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblKomponente.setText("Komponente:");

        txtComponents.setEditable(false);
        txtComponents.setColumns(20);
        txtComponents.setRows(5);
        jScrollPane3.setViewportView(txtComponents);

        btnChoose.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnChoose.setText("Odaberi");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        lblVlasnik.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblVlasnik.setText("Vlasnik:");

        lblImeVlasnika.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        btnBack.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnBack.setText("Nazad");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSerach, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnChoose, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblVlasnik)
                                    .addComponent(lblKomponente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblImeVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChoose)
                    .addComponent(lblVlasnik)
                    .addComponent(lblImeVlasnika))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKomponente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnBack))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JFrame konfiguracije = new KonfiguracijaUnos();
        konfiguracije.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        search();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        txtDatum.setText(null);
        txtOpis.setText(null);
        try {
            Long configurationID = (Long) tblKonfiguracije.getValueAt(tblKonfiguracije.getSelectedRow(), 0);
            Klijent vlasnik = (Klijent) tblKonfiguracije.getValueAt(tblKonfiguracije.getSelectedRow(), 1);
            double cena = (double) tblKonfiguracije.getValueAt(tblKonfiguracije.getSelectedRow(), 2);
            lblImeVlasnika.setText(vlasnik.toString());
            konfiguracija = new Konfiguracija();
            konfiguracija.setKonfiguracijaID(configurationID);
            konfiguracija.setVlasnik(vlasnik);
            konfiguracija.setUkupnaCena(cena);

            populateComponents(Controller.getInstance().getConfigurationComponents(konfiguracija));
            populateCmb();
        } catch (Exception ex) {
            Logger.getLogger(KonfiguracijaPregled.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChooseActionPerformed

    private void txtDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumActionPerformed
        JFrame f = new KonfiguracijaUnos();
        f.setVisible(true);
    }//GEN-LAST:event_txtDatumActionPerformed

    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        konfiguracija.setKonfiguracijaID(konfiguracija.getKonfiguracijaID());
        JFrame servisiUnos = new ServisUnos(this, konfiguracija);
        servisiUnos.setVisible(true);
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void cmbServisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServisActionPerformed

        try {
            Servis servis = (Servis) cmbServis.getSelectedItem();
            txtDatum.setText(servis.getDatumServisa().toString());
            txtOpis.setText(servis.getOpis());
            txtServiser.setText(servis.getServiser().toString());
            txtBrTel.setText(servis.getServiser().getServiserBrTel());
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbServisActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (konfiguracija == null) {
            JOptionPane.showMessageDialog(this, "Nije selektovana nijedna konfiguracija!", "Izmena nemoguća", JOptionPane.ERROR_MESSAGE);

        } else {
            JFrame konfiguracijaIzmena = new KonfiguracijaIzmena(konfiguracija, this);
            konfiguracijaIzmena.setVisible(true);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtServiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServiserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServiserActionPerformed

    private void txtBrTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrTelActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        parent.populate();
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KonfiguracijaPregled.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonfiguracijaPregled.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonfiguracijaPregled.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonfiguracijaPregled.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KonfiguracijaPregled().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddService;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbServis;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblDatum1;
    private javax.swing.JLabel lblDatum2;
    private javax.swing.JLabel lblImeVlasnika;
    private javax.swing.JLabel lblKomponente;
    private javax.swing.JLabel lblOdabir;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblVlasnik;
    private javax.swing.JTable tblKonfiguracije;
    private javax.swing.JTextField txtBrTel;
    private javax.swing.JTextArea txtComponents;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextArea txtOpis;
    private javax.swing.JTextField txtSerach;
    private javax.swing.JTextField txtServiser;
    // End of variables declaration//GEN-END:variables

    private void populateComponents(LinkedList<StavkaKonfiguracije> stavke) {
        txtComponents.setText(null);
        for (StavkaKonfiguracije stavka : stavke) {
            txtComponents.append(stavka.toString() + "\n");
        }
    }

    public void populateCmb() throws Exception {

        LinkedList<Servis> servisi = Controller.getInstance().getServices();
        cmbServis.removeAllItems();
        for (Servis servis : servisi) {
            if (servis.getKonfiguracija().getKonfiguracijaID().equals(this.konfiguracija.getKonfiguracijaID())) {
                cmbServis.addItem(servis);
            }
        }
    }

    private void populateTable() throws Exception {
        konfiguracije = Controller.getInstance().getConfigurations("");
        tbk = new TableModelKonfiguracija(konfiguracije);
        tblKonfiguracije.setModel(tbk);
    }

    public void search() {
        try {
            String keyword = txtSerach.getText();
            konfiguracije = Controller.getInstance().getConfigurations(keyword);
            konfiguracija = null;
            txtComponents.setText(null);
            cmbServis.removeAllItems();
            txtDatum.setText(null);
            txtOpis.setText(null);
        } catch (Exception ex) {
            Logger.getLogger(KonfiguracijaPregled.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbk = new TableModelKonfiguracija(konfiguracije);
        tblKonfiguracije.setModel(tbk);
    }
}
