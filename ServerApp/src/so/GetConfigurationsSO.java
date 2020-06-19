/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.GeneralEntity;
import domain.Konfiguracija;
import java.util.LinkedList;
import so.AbstractGenericOperation;

/**
 *
 * @author Ivan
 */
public class GetConfigurationsSO extends AbstractGenericOperation {

    private LinkedList<GeneralEntity> list;
    public GetConfigurationsSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Konfiguracija)) {
            throw new Exception("Invalid object (Konfiguracija)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        String condition = "klijentIme LIKE '%"+keyword+"%' OR klijentPrezime LIKE '%"+keyword+"%' OR klijentBrTel LIKE '%"+keyword+"%'";
        String join = " left JOIN klijent ON klijent.klijentID=konfiguracija.klijentID ";
        list = (LinkedList<GeneralEntity>)dBBroker.getByCondition(new Konfiguracija(),join, condition);
    }
    
    public LinkedList<GeneralEntity> getList() {
        return list;
    }
}
