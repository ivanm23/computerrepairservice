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
public class GetServiceLastIDSO extends AbstractGenericOperation {
    private Long id;
    public GetServiceLastIDSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Servis)) {
            throw new Exception("Invalid object (Servis)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        id=dBBroker.getLastId((Servis)entity);
    }

    /**
     * @return the id
     */
    public Long getId() {
        if (id==null) {
            return new Long(1);
        }
        return id+1;
    }
    
}
