/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.GeneralEntity;
import domain.Klijent;
import java.util.LinkedList;
import so.AbstractGenericOperation;

/**
 *
 * @author Ivan
 */
public class GetClientsSO extends AbstractGenericOperation {

    private LinkedList<GeneralEntity> list;
    
    public GetClientsSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Klijent)) {
            throw new Exception("Invalid object (Klijent)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        LinkedList<GeneralEntity> klijenti = (LinkedList<GeneralEntity>) dBBroker.getAll((Klijent) entity, null);
        list = new LinkedList<>();
        
        for (GeneralEntity klijent : klijenti) {
            Klijent k = (Klijent) klijent;
            getList().add(k);
            
        }
    }

    public LinkedList<GeneralEntity> getList() {
        return list;
    }
    
    
}
