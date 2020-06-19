/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.GeneralEntity;
import domain.Komponenta;
import java.util.LinkedList;
import so.AbstractGenericOperation;

/**
 *
 * @author Ivan
 */
public class GetComponentsSO extends AbstractGenericOperation {
    
    private LinkedList<GeneralEntity> list;
    
    public GetComponentsSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Komponenta)) {
            throw new Exception("Invalid object (Komponenta)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        String condition=keyword;
        list=(LinkedList<GeneralEntity>) dBBroker.getByCondition(new Komponenta(), null, condition);
    }
    public LinkedList<GeneralEntity> getList() {
        return list;
    }
    
}
