/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.Konfiguracija;

/**
 *
 * @author Ivan
 */
public class SaveConfigurationSO extends AbstractGenericOperation {

    public SaveConfigurationSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Konfiguracija)) {
            throw new Exception("Invalid object (Konfiguracija)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        Konfiguracija konfiguracija = (Konfiguracija)entity;
        dBBroker.insert(konfiguracija);
    }
    
}
