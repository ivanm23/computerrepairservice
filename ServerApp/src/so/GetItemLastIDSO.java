package so;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import domain.StavkaKonfiguracije;

/**
 *
 * @author Ivan
 */
public class GetItemLastIDSO extends AbstractGenericOperation {
    private Long id;
    public GetItemLastIDSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof StavkaKonfiguracije)) {
            throw new Exception("Invalid object (StavkaKonfiguracije)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        id=dBBroker.getLastId((StavkaKonfiguracije)entity);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id+1;
    }
    
}
