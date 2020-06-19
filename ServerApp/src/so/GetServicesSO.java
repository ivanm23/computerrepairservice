/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.GeneralEntity;
import domain.Klijent;
import domain.Konfiguracija;
import domain.Servis;
import domain.Serviser;
import java.util.LinkedList;

/**
 *
 * @author Ivan
 */
public class GetServicesSO extends AbstractGenericOperation {

    private LinkedList<GeneralEntity> list;
    
    public GetServicesSO() {
    }

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Servis)) {
            throw new Exception("Invalid object (Servis)");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        LinkedList<GeneralEntity> servisi = (LinkedList<GeneralEntity>) dBBroker.getAll((Servis)entity, null);
        list = new LinkedList<>();
        
        for (GeneralEntity servis : servisi) {
            Servis s = (Servis) servis;
            
            Serviser serviser = (Serviser) dBBroker.getById(s.getServiser(), null);
            Konfiguracija konfiguracija = (Konfiguracija) dBBroker.getById(s.getKonfiguracija(), null);
            
            Klijent klijent = konfiguracija.getVlasnik();
            klijent = (Klijent) dBBroker.getById(klijent, keyword);
            konfiguracija.setVlasnik(klijent);
            s.setServiser(serviser);
            s.setKonfiguracija(konfiguracija);
            System.out.println(s);
            getList().add(s);
            
        }
    }

    /**
     * @return the list
     */
    public LinkedList<GeneralEntity> getList() {
        return list;
    }
    
}
