/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.components;

import controller.Controller;
import domain.Komponenta;
import domain.Konfiguracija;
import domain.TipKomponente;
import form.clients.KlijentiUnos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Ivan
 */
public class Komponente extends javax.swing.JFrame {

    /**
     * Creates new form Komponente
     */
    public Komponente() {
        initComponents();
        setLocationRelativeTo(null);
        populateCmb();
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        lblProizvodjac = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblOpis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        txtProizvodjac = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        lblCena = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dodavanje komponenti");

        btnAdd.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnAdd.setText("Dodaj");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnClose.setText("Izađi");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Tip komponente: ");

        cmbType.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblProizvodjac.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblProizvodjac.setText("Proizvodjač:");

        lblModel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblModel.setText("Model:");

        lblOpis.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblOpis.setText("Opis:");

        txtOpis.setColumns(20);
        txtOpis.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtOpis.setRows(5);
        jScrollPane1.setViewportView(txtOpis);

        txtProizvodjac.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        txtModel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        lblCena.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblCena.setText("Cena:");

        txtCena.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lblCena)
                        .addGap(23, 23, 23)
                        .addComponent(txtCena))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblProizvodjac)
                                    .addComponent(jLabel1)
                                    .addComponent(lblModel)
                                    .addComponent(lblOpis))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtProizvodjac)
                                    .addComponent(txtModel)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProizvodjac)
                    .addComponent(txtProizvodjac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModel)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCena)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOpis)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnAdd))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String model = txtModel.getText().trim();
        String proizvodjac = txtProizvodjac.getText().trim();
        String opis = txtOpis.getText().trim();
        String cena = txtCena.getText().trim();

        if (model.isEmpty() || proizvodjac.isEmpty() || opis.isEmpty() || cena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Popunite sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
        }

        Komponenta komponenta = getPopulatedComponent();
        if (komponenta != null) {

            try {
                Controller.getInstance().addComponent(komponenta);
                JOptionPane.showMessageDialog(this, "Komponenta je uspešno dodata!", "Dodavanje komponente", JOptionPane.INFORMATION_MESSAGE);

                    int result = JOptionPane.showConfirmDialog(this, "Dodajte još komponenti?", "Upit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (result == 0) {
                        txtModel.setText(null);
                        txtProizvodjac.setText(null);
                        txtCena.setText(null);
                        txtOpis.setText(null);
                    }else 
                        dispose();

            } catch (Exception ex) {
                Logger.getLogger(Komponente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(Komponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Komponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Komponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Komponente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Komponente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JLabel lblProizvodjac;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextArea txtOpis;
    private javax.swing.JTextField txtProizvodjac;
    // End of variables declaration//GEN-END:variables

    private void populateCmb() {
        cmbType.removeAllItems();

        for (TipKomponente tip : TipKomponente.values()) {
            cmbType.addItem(tip);
        }
    }

    private Komponenta getPopulatedComponent() {
        Konfiguracija konfiguracija = new Konfiguracija();
        konfiguracija.setKonfiguracijaID(new Long(0));
        try {
            TipKomponente tipKomponente = (TipKomponente) cmbType.getSelectedItem();
            String model = txtModel.getText().trim();
            String proizvodjac = txtProizvodjac.getText().trim();
            String opis = txtOpis.getText().trim();
            Double cena = Double.parseDouble(txtCena.getText().trim());

            if (model.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Polje za model ne sme biti prazno!", "Greska", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (proizvodjac.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Polje za proizvođača ne sme biti prazno!", "Greska", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (opis.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Polje za opis ne sme biti prazno!", "Greska", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (txtCena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Polje za cenu ne sme biti prazno!", "Greska", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (cena.isNaN() || cena < 0.0) {
                JOptionPane.showMessageDialog(this, "Cena ne sme biti manja od nule!", "Greska", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            Komponenta komponenta = new Komponenta(Controller.getInstance().getComponentLastID(), model, proizvodjac, cena, opis, tipKomponente);
            return komponenta;
        } catch (Exception ex) {
            Logger.getLogger(KlijentiUnos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
