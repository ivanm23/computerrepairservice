/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.Serviser;
import so.AbstractGenericOperation;

/**
 *
 * @author Ivan
 */
public class LoginSO extends AbstractGenericOperation {
    
    private Serviser serviser;
    

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Serviser)) {
            throw new Exception("Invalid object (Serviser)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        String condition = keyword;
        serviser = (Serviser) dBBroker.getByCondition((Serviser) entity, null, condition).get(0);
    }

    public Serviser getServiser(){
        return serviser;
    }
}
