/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.Komponenta;

/**
 *
 * @author Ivan
 */
public class AddComponentSO extends AbstractGenericOperation {

    public AddComponentSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Komponenta)) {
            throw new Exception("Invalid object (Komponenta)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        dBBroker.insert((Komponenta)entity);
        System.out.println((Komponenta)entity);
    }
    
}
