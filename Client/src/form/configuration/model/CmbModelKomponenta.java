/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.configuration.model;

import domain.Komponenta;
import java.util.LinkedList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Ivan
 */
public class CmbModelKomponenta implements ComboBoxModel{
 
    private Komponenta selectedItem;
    private LinkedList<Komponenta> komponente;

    public CmbModelKomponenta(LinkedList<Komponenta> komponente) {
        this.komponente = komponente;
    }
    
    
    @Override
    public void setSelectedItem(Object anItem) {
        for (Komponenta komponenta : komponente) {
            if (komponenta.equals(anItem)) {
                selectedItem=komponenta;
                break;
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return komponente.size();
    }

    @Override
    public Komponenta getElementAt(int index) {
        return komponente.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
