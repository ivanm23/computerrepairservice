/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import storage.database.DBBroker;
import storage.database.IDBBroker;
import storage.database.connection.DatabaseConnection;

/**
 *
 * @author Ivan
 */
public abstract class AbstractGenericOperation {
    
    protected IDBBroker dBBroker;

    public AbstractGenericOperation() {
        this.dBBroker = new DBBroker();
    }
    
    public final void templateExecute(Object entity, String keyword) throws Exception{
    
            try {
            validate(entity);
            startTransaction();
            execute(entity, keyword);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        }
            
        
    }

    protected abstract void validate(Object entity) throws Exception;
    
    protected abstract void execute(Object entity, String keyword)throws Exception;    
    
    private void startTransaction() throws Exception{
        DatabaseConnection.getInstance().getConnection().setAutoCommit(false);
    }

    private void commitTransaction() throws Exception{
        DatabaseConnection.getInstance().commit();
    }

    private void rollbackTransaction() throws Exception{
        DatabaseConnection.getInstance().rollback();
    }
    

}
