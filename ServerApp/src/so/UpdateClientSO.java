/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.Klijent;
import so.AbstractGenericOperation;

/**
 *
 * @author Ivan
 */
public class UpdateClientSO extends AbstractGenericOperation {

    public UpdateClientSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Klijent)) {
            throw new Exception("Invalid object (Klijent)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        dBBroker.update((Klijent)entity);
    }
    
}
