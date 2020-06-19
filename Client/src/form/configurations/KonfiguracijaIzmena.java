/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.configurations;

import controller.Controller;
import domain.Komponenta;
import domain.Konfiguracija;
import domain.StavkaKonfiguracije;
import domain.TipKomponente;
import form.clients.Klijenti;
import form.components.Komponente;
import java.awt.HeadlessException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Ivan
 */
public class KonfiguracijaIzmena extends javax.swing.JFrame {
    private KonfiguracijaPregled parent;
    private Konfiguracija konfiguracija;
    private LinkedList<StavkaKonfiguracije> stavke;
    private Long brojStavke;

    /**
     * Creates new form KonfiguracijaIzmena
     */
    public KonfiguracijaIzmena() {
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public KonfiguracijaIzmena(Konfiguracija konfiguracija, KonfiguracijaPregled parent) throws HeadlessException {
        try {
            this.konfiguracija = konfiguracija;
            initComponents();
            populateCmb();
            stavke = Controller.getInstance().getConfigurationComponents(konfiguracija);
            brojStavke = (Controller.getInstance().getLastItemNumber(konfiguracija));
            this.parent=parent;
            this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            this.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(KonfiguracijaIzmena.class.getName()).log(Level.SEVERE, null, ex);
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

        pnlBrisanje = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbItem = new javax.swing.JComboBox();
        btnDeleteStavka = new javax.swing.JButton();
        pnlComponent = new javax.swing.JPanel();
        lblType = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        lblComponent = new javax.swing.JLabel();
        cmbComponent = new javax.swing.JComboBox();
        lblType1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        btnAddComponent = new javax.swing.JButton();
        btnCreateComponent = new javax.swing.JButton();
        lblClientNonExistant1 = new javax.swing.JLabel();
        lblComponent1 = new javax.swing.JLabel();
        cmbKolicina = new javax.swing.JComboBox();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Izmena konfiguracije");

        pnlBrisanje.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Brisanje komponenti");

        btnDeleteStavka.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnDeleteStavka.setText("Obriši");
        btnDeleteStavka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStavkaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBrisanjeLayout = new javax.swing.GroupLayout(pnlBrisanje);
        pnlBrisanje.setLayout(pnlBrisanjeLayout);
        pnlBrisanjeLayout.setHorizontalGroup(
            pnlBrisanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBrisanjeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBrisanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBrisanjeLayout.createSequentialGroup()
                        .addComponent(cmbItem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBrisanjeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlBrisanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBrisanjeLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBrisanjeLayout.createSequentialGroup()
                                .addComponent(btnDeleteStavka, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154))))))
        );
        pnlBrisanjeLayout.setVerticalGroup(
            pnlBrisanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBrisanjeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteStavka)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnlComponent.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblType.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblType.setText("Tip:");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Dodavanje komponenti");

        cmbType.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeActionPerformed(evt);
            }
        });

        lblComponent.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblComponent.setText("Komponenta:");

        cmbComponent.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cmbComponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbComponentActionPerformed(evt);
            }
        });

        lblType1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblType1.setText("Opis:");

        txtOpis.setEditable(false);
        txtOpis.setColumns(20);
        txtOpis.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtOpis.setRows(5);
        jScrollPane1.setViewportView(txtOpis);

        btnAddComponent.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnAddComponent.setText("Dodaj");
        btnAddComponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddComponentActionPerformed(evt);
            }
        });

        btnCreateComponent.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnCreateComponent.setText("Kreiraj");
        btnCreateComponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateComponentActionPerformed(evt);
            }
        });

        lblClientNonExistant1.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        lblClientNonExistant1.setText("Komponenta ne postoji na listi? Kreiraj novu:");

        lblComponent1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblComponent1.setText("Količina:");

        cmbKolicina.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cmbKolicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKolicinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlComponentLayout = new javax.swing.GroupLayout(pnlComponent);
        pnlComponent.setLayout(pnlComponentLayout);
        pnlComponentLayout.setHorizontalGroup(
            pnlComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComponentLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(88, 88, 88))
            .addGroup(pnlComponentLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(lblClientNonExistant1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateComponent)
                .addGap(10, 10, 10))
            .addGroup(pnlComponentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblType1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComponentLayout.createSequentialGroup()
                        .addGroup(pnlComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlComponentLayout.createSequentialGroup()
                                .addComponent(cmbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addGroup(pnlComponentLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnlComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlComponentLayout.createSequentialGroup()
                                .addComponent(lblComponent)
                                .addGap(75, 75, 75)
                                .addComponent(lblComponent1)
                                .addGap(32, 32, 32))
                            .addGroup(pnlComponentLayout.createSequentialGroup()
                                .addComponent(cmbComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(pnlComponentLayout.createSequentialGroup()
                        .addGroup(pnlComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAddComponent, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        pnlComponentLayout.setVerticalGroup(
            pnlComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComponentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(lblComponent)
                    .addComponent(lblComponent1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbComponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblType1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddComponent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateComponent)
                    .addComponent(lblClientNonExistant1))
                .addContainerGap())
        );

        btnClose.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnClose.setText("Zatvori");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBrisanje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlComponent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(pnlBrisanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlComponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        try {
            TipKomponente tip = (TipKomponente) cmbType.getSelectedItem();
            LinkedList<Komponenta> listaKomponenti = Controller.getInstance().getComponents(tip.ordinal());
            cmbComponent.removeAllItems();

            for (Komponenta komponenta : listaKomponenti) {
                cmbComponent.addItem(komponenta);
            }

            updateDescription();
            populateAmount();
        } catch (Exception ex) {
            Logger.getLogger(KonfiguracijaUnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbTypeActionPerformed

    private void cmbComponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbComponentActionPerformed
        updateDescription();
    }//GEN-LAST:event_cmbComponentActionPerformed

    private void btnAddComponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddComponentActionPerformed
        try {
            Komponenta komponenta = (Komponenta) cmbComponent.getSelectedItem();
            StavkaKonfiguracije stavka = new StavkaKonfiguracije();
            stavka.setBrojKomponente(++brojStavke);
            stavka.setKomponenta(komponenta);
            stavka.setPojedinacnaCena(komponenta.getCena());
            stavka.setKolicina(Integer.parseInt(cmbKolicina.getSelectedItem().toString()));
            stavka.setUkupnaCena(stavka.getPojedinacnaCena() * stavka.getKolicina());
            stavka.setKonfiguracija(konfiguracija);
            double cena = konfiguracija.getUkupnaCena() + stavka.getUkupnaCena();

            if (!evaluateComponent(komponenta)) {
                JOptionPane.showMessageDialog(this, "Nije dozvoljeno dalje dodavanje komponente ovog tipa!", "Nedozvoljen unos", JOptionPane.ERROR_MESSAGE);
            } else {
                konfiguracija.setUkupnaCena(cena);
                Controller.getInstance().addItem(stavka);
                Controller.getInstance().updateConfigurationPrice(konfiguracija);
                JOptionPane.showMessageDialog(this, "Кomponenta "+stavka.toString()+" je uspešno dodata!", "Uspešno dodavanje", JOptionPane.INFORMATION_MESSAGE);

                stavke = Controller.getInstance().getConfigurationComponents(konfiguracija);
                populateCmb();
            }
        } catch (Exception ex) {
            Logger.getLogger(KonfiguracijaIzmena.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddComponentActionPerformed

    private void btnCreateComponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateComponentActionPerformed
        JFrame unosKomponente = new Komponente();
        unosKomponente.setVisible(true);
    }//GEN-LAST:event_btnCreateComponentActionPerformed

    private void cmbKolicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKolicinaActionPerformed

    }//GEN-LAST:event_cmbKolicinaActionPerformed

    private void btnDeleteStavkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStavkaActionPerformed
        try {
            StavkaKonfiguracije stavka = (StavkaKonfiguracije) cmbItem.getSelectedItem();
            double cena = konfiguracija.getUkupnaCena() - stavka.getUkupnaCena();
            konfiguracija.setUkupnaCena(cena);
            Controller.getInstance().updateConfigurationPrice(konfiguracija);
            Controller.getInstance().deleteItem(stavka);
            JOptionPane.showMessageDialog(this, "Кomponenta "+stavka.toString()+" je uspešno obrisana!", "Uspešno brisanje", JOptionPane.INFORMATION_MESSAGE);
            stavke = Controller.getInstance().getConfigurationComponents(konfiguracija);

            populateCmb();
        } catch (Exception ex) {
            Logger.getLogger(KonfiguracijaIzmena.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteStavkaActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        parent.search();
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(KonfiguracijaIzmena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonfiguracijaIzmena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonfiguracijaIzmena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonfiguracijaIzmena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KonfiguracijaIzmena().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddComponent;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreateComponent;
    private javax.swing.JButton btnDeleteStavka;
    private javax.swing.JComboBox cmbComponent;
    private javax.swing.JComboBox cmbItem;
    private javax.swing.JComboBox cmbKolicina;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClientNonExistant1;
    private javax.swing.JLabel lblComponent;
    private javax.swing.JLabel lblComponent1;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblType1;
    private javax.swing.JPanel pnlBrisanje;
    private javax.swing.JPanel pnlComponent;
    private javax.swing.JTextArea txtOpis;
    // End of variables declaration//GEN-END:variables

    public void populateCmb() {
        cmbItem.removeAllItems();
        try {
            LinkedList<StavkaKonfiguracije> stavkePop = Controller.getInstance().getConfigurationComponents(konfiguracija);

            for (StavkaKonfiguracije stavka : stavkePop) {
                cmbItem.addItem(stavka);
            }

            for (TipKomponente tip : TipKomponente.values()) {
                cmbType.addItem(tip);
            }
        } catch (Exception ex) {
            Logger.getLogger(Klijenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateDescription() {
        txtOpis.setText("");
        if (cmbComponent.getSelectedIndex() != -1) {
            Komponenta komponenta = (Komponenta) cmbComponent.getSelectedItem();
            txtOpis.setText(komponenta.getOpis());
        }

    }

    private void populateAmount() {
        cmbKolicina.removeAllItems();
        switch ((TipKomponente) cmbType.getSelectedItem()) {
            case CPU:
                cmbKolicina.addItem(1);
                break;
            case CASE:
                cmbKolicina.addItem(1);
                break;
            case MOBO:
                cmbKolicina.addItem(1);
                break;
            case PSU:
                cmbKolicina.addItem(1);
                break;
            case ODD:
                cmbKolicina.addItem(1);
                break;
            case RAM:
                cmbKolicina.addItem(1);
                cmbKolicina.addItem(2);
                cmbKolicina.addItem(3);
                cmbKolicina.addItem(4);
                break;
            case GPU:
                cmbKolicina.addItem(1);
                cmbKolicina.addItem(2);
                cmbKolicina.addItem(3);
                cmbKolicina.addItem(4);
                break;
            case HDD:
                cmbKolicina.addItem(1);
                cmbKolicina.addItem(2);
                cmbKolicina.addItem(3);
                cmbKolicina.addItem(4);
                break;
            case SSD:
                cmbKolicina.addItem(1);
                cmbKolicina.addItem(2);
                cmbKolicina.addItem(3);
                cmbKolicina.addItem(4);
                break;
            case FAN:
                cmbKolicina.addItem(1);
                cmbKolicina.addItem(2);
                cmbKolicina.addItem(3);
                cmbKolicina.addItem(4);
                cmbKolicina.addItem(5);
                break;
        }
    }

    private boolean evaluateComponent(Komponenta komponenta) {

        switch (komponenta.getTipKomponente()) {
            case CPU:
                for (StavkaKonfiguracije stavka : stavke) {
                    if (stavka.getKomponenta().getTipKomponente() == TipKomponente.CPU) {
                        return false;
                    }
                }
                break;
            case CASE:
                for (StavkaKonfiguracije stavka : stavke) {
                    if (stavka.getKomponenta().getTipKomponente() == TipKomponente.CASE) {
                        return false;
                    }
                }
                break;
            case PSU:
                for (StavkaKonfiguracije stavka : stavke) {
                    if (stavka.getKomponenta().getTipKomponente() == TipKomponente.PSU) {
                        return false;
                    }
                }
                break;
            case MOBO:
                for (StavkaKonfiguracije stavka : stavke) {
                    if (stavka.getKomponenta().getTipKomponente() == TipKomponente.MOBO) {
                        return false;
                    }
                }
                break;

        }

        return true;
    }
}
