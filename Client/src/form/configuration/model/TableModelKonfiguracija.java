/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.configuration.model;

import controller.Controller;
import domain.Konfiguracija;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivan
 */
public class TableModelKonfiguracija extends AbstractTableModel{

    private String[] header = {"ID", "Klijent", "Cena"};
    private LinkedList<Konfiguracija> konfiguracije = new LinkedList<>();

    public TableModelKonfiguracija(LinkedList<Konfiguracija> konfiguracije) {
        this.konfiguracije = konfiguracije;
    }

    @Override
    public int getRowCount() {
        return konfiguracije.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Konfiguracija konfiguracija = konfiguracije.get(rowIndex);
            
            switch (columnIndex) {
                case 0:
                    return konfiguracija.getKonfiguracijaID();
                case 1: {
                        return Controller.getInstance().getClientById(konfiguracija.getVlasnik());
                }
                case 2:
                    return konfiguracija.getUkupnaCena();
                default:
                    return "N/A";
            }
        } catch (Exception ex) {
            Logger.getLogger(TableModelKonfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
   
}
