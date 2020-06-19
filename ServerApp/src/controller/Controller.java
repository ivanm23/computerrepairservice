/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import so.UpdateConfigurationPriceSO;
import so.AddItemSO;
import so.GetItemLastIDSO;
import so.DeleteItemSO;
import so.GetServiceLastIDSO;
import so.SaveServiceSO;
import so.GetConfigurationComponentsSO;
import domain.GeneralEntity;
import so.GetClientByIDSO;
import so.GetConfigurationsSO;
import so.SaveConfigurationItemSO;
import so.GetConfigurationLastIDSO;
import so.GetComponentLastIDSO;
import so.GetComponentsSO;
import so.DeleteClientSO;
import so.AddComponentSO;
import so.AddClientSO;
import so.GetClientLastIDSO;
import so.UpdateClientSO;
import so.GetClientsSO;
import domain.Klijent;
import domain.Komponenta;
import domain.Konfiguracija;
import so.GetServicesSO;
import so.LoginSO;
import domain.Servis;
import domain.Serviser;
import domain.StavkaKonfiguracije;
import java.util.List;
import so.AbstractGenericOperation;
import so.SaveConfigurationSO;

/**
 *
 * @author Ivan
 */
public class Controller {

    private static Controller instance;

    public Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Serviser login(String korisnickoIme, String lozinka) throws Exception {
        AbstractGenericOperation so = new LoginSO();
        Serviser serviser = new Serviser();
        serviser.setKorisnickoIme(korisnickoIme);
        serviser.setLozinka(lozinka);
        String condition = "korisnickoIme='" + korisnickoIme + "' AND lozinka='" + lozinka + "'";
        so.templateExecute(serviser, condition);
        return ((LoginSO) so).getServiser();

    }

    public List getServices() throws Exception {
        AbstractGenericOperation so = new GetServicesSO();
        so.templateExecute(new Servis(), null);
        return ((GetServicesSO) so).getList();
    }

    public List getClients() throws Exception {
        AbstractGenericOperation so = new GetClientsSO();
        so.templateExecute(new Klijent(), null);
        return ((GetClientsSO) so).getList();
    }

    public Long getClientLastID() throws Exception {
        AbstractGenericOperation so = new GetClientLastIDSO();
        so.templateExecute(new Klijent(), null);
        return ((GetClientLastIDSO) so).getId();
    }

    public void addClient(Klijent klijent) throws Exception {
        AbstractGenericOperation so = new AddClientSO();
        so.templateExecute(klijent, null);
    }

    public void updateClient(Klijent klijent) throws Exception {
        AbstractGenericOperation so = new UpdateClientSO();
        so.templateExecute(klijent, null);
    }

    public void deleteClient(Klijent klijent) throws Exception {
        AbstractGenericOperation so = new DeleteClientSO();
        so.templateExecute(klijent, null);
    }

    public void addComponent(Komponenta komponenta) throws Exception {
        AbstractGenericOperation so = new AddComponentSO();
        so.templateExecute(komponenta, null);
    }

    public List getComponents(int tip) throws Exception {
        AbstractGenericOperation so = new GetComponentsSO();
        String condition = "tipKomponente=" + tip;
        so.templateExecute(new Komponenta(), condition);
        return ((GetComponentsSO) so).getList();

    }

    public void saveConfiguration(Konfiguracija konfiguracija) throws Exception {
        AbstractGenericOperation so = new SaveConfigurationSO();
        so.templateExecute(konfiguracija, null);
    }

    public Long getConfigurationLastID() throws Exception {
        AbstractGenericOperation so = new GetConfigurationLastIDSO();
        so.templateExecute(new Konfiguracija(), null);
        return ((GetConfigurationLastIDSO) so).getId();

    }

    public Long getComponentLastID() throws Exception {
        AbstractGenericOperation so = new GetComponentLastIDSO();
        so.templateExecute(new Komponenta(), null);
        return ((GetComponentLastIDSO) so).getId();
    }

    public void saveConfigurationItem(StavkaKonfiguracije stavka) throws Exception {
        AbstractGenericOperation so = new SaveConfigurationItemSO();
        so.templateExecute(stavka, null);
    }

    public List getConfigurations(String keyword) throws Exception {
        AbstractGenericOperation so = new GetConfigurationsSO();
        so.templateExecute(new Konfiguracija(), keyword);
        return ((GetConfigurationsSO) so).getList();
    }

    public GeneralEntity getClientByID(Klijent klijent) throws Exception {
        AbstractGenericOperation so = new GetClientByIDSO();
        so.templateExecute(klijent, null);

        return ((GetClientByIDSO) so).getClient();
    }

    public List getConfigurationComponents(Konfiguracija konfiguracija) throws Exception {
        String keyword= " konfiguracijaID= "+konfiguracija.getKonfiguracijaID();
        AbstractGenericOperation so = new GetConfigurationComponentsSO();
        so.templateExecute(new StavkaKonfiguracije(), keyword);
        return ((GetConfigurationComponentsSO) so).getList();
    }

    public void saveService(Servis servis) throws Exception {
        AbstractGenericOperation so = new SaveServiceSO();
        so.templateExecute(servis, null);
    }

    public Long getServiceLastID() throws Exception {
        AbstractGenericOperation so = new GetServiceLastIDSO();
        so.templateExecute(new Servis(), null);
        return ((GetServiceLastIDSO) so).getId();
    }

    public void deleteItem(StavkaKonfiguracije stavka) throws Exception {
        AbstractGenericOperation so = new DeleteItemSO();
        so.templateExecute(stavka, null);
        
    }

    public Long getItemLastID(Konfiguracija konfiguracija) throws Exception {
        AbstractGenericOperation so = new GetItemLastIDSO();
        StavkaKonfiguracije stavka = new StavkaKonfiguracije();
        stavka.setKonfiguracija(konfiguracija);
        so.templateExecute(stavka, null);
        return ((GetItemLastIDSO) so).getId();
    }

    public void addItem(StavkaKonfiguracije stavka) throws Exception {
        AbstractGenericOperation so = new AddItemSO();
        so.templateExecute(stavka, null);
    }

    public void updateConfigurationPrice(Konfiguracija konfiguracija) throws Exception {
        AbstractGenericOperation so = new UpdateConfigurationPriceSO();
        so.templateExecute(konfiguracija, null);
    }
}
