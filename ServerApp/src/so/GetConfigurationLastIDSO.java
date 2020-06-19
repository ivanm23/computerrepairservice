/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.Konfiguracija;
import so.AbstractGenericOperation;

/**
 *
 * @author Ivan
 */
public class GetConfigurationLastIDSO extends AbstractGenericOperation {

    private Long id;
    public GetConfigurationLastIDSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Konfiguracija)) {
            throw new Exception("Invalid object (Konfiguracija)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
       id=  dBBroker.getLastId((Konfiguracija)entity);
        
    }

    public Long getId() {
        if (id==null) {
            return new Long(0);
        }
        return id+1;
    }

}
