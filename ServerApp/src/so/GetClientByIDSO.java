/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.GeneralEntity;
import domain.Klijent;
import so.AbstractGenericOperation;

/**
 *
 * @author Ivan
 */
public class GetClientByIDSO extends AbstractGenericOperation {
    private GeneralEntity client;
    public GetClientByIDSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Klijent)) {
            throw new Exception("Invalid object (Klijent)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        client = (Klijent)dBBroker.getById((Klijent) entity, null);
    }

    /**
     * @return the klijent
     */
    public GeneralEntity getClient() {
        return client;
    }
    
}
