/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.servis.model;

import domain.Servis;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivan
 */
public class TableModelServis extends AbstractTableModel{

    private String[] header = {"ID", "Datum","Opis", "Klijent"};
    private LinkedList<Servis> servisi = new LinkedList<>();

    public TableModelServis(LinkedList<Servis> servisi) {
        this.servisi=servisi;
    }
    
    @Override
    public int getRowCount() {
        return servisi.size();
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
        Servis servis = servisi.get(rowIndex);
        switch(columnIndex) {
                case 0:
                    return servis.getServisID();
                case 1:
                    return servis.getDatumServisa();
                case 2:
                    return servis.getOpis();
                case 3:
                    return servis.getKonfiguracija().getVlasnik();
                default:
                    return "N/A";
    }
    }
}
