/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.GeneralEntity;
import domain.Komponenta;
import domain.StavkaKonfiguracije;
import java.util.LinkedList;

/**
 *
 * @author Ivan
 */
public class GetConfigurationComponentsSO extends AbstractGenericOperation {
    private LinkedList<GeneralEntity> list;
    public GetConfigurationComponentsSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof StavkaKonfiguracije)) {
            throw new Exception("Invalid object (StavkaKonfiguracije)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        String join = " JOIN komponenta ON stavkakonfiguracije.komponentaID=komponenta.komponentaID ";
        list = (LinkedList<GeneralEntity>) dBBroker.getByCondition(new StavkaKonfiguracije(), join, keyword);
        
        for (GeneralEntity stavka : list) {
            ((StavkaKonfiguracije)stavka).setKomponenta((Komponenta)dBBroker.getById(((StavkaKonfiguracije)stavka).getKomponenta(), null));
        }
    }

    /**
     * @return the list
     */
    public LinkedList<GeneralEntity> getList() {
        return list;
    }
    
}
