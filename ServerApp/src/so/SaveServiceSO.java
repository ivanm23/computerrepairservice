/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.Servis;
import so.AbstractGenericOperation;

/**
 *
 * @author Ivan
 */
public class SaveServiceSO extends AbstractGenericOperation {

    public SaveServiceSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Servis)) {
            throw new Exception("Invalid object (Servis)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        Servis servis = (Servis) entity;
        dBBroker.insert(servis);
    }
    
}
