/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.StavkaKonfiguracije;
import so.AbstractGenericOperation;

/**
 *
 * @author Ivan
 */
public class SaveConfigurationItemSO extends AbstractGenericOperation {

    public SaveConfigurationItemSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof StavkaKonfiguracije)) {
            throw new Exception("Invalid object (StavkaKonfiguracije)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        dBBroker.insert((StavkaKonfiguracije) entity);
    }

}
