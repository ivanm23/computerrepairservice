/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.Komponenta;
import so.AbstractGenericOperation;

/**
 *
 * @author Ivan
 */
public class GetComponentLastIDSO extends AbstractGenericOperation {

    private Long id;
    public GetComponentLastIDSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Komponenta)) {
            throw new Exception("Invalid object (Komponenta)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        id = dBBroker.getLastId((Komponenta) entity);
    }

    /**
     * @return the id
     */
    public Long getId() {
        if (id==null) {
            return new Long(0);
        }
            return id+1;
    }
    
}
