/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import communication.Communication;
import domain.Klijent;
import domain.Komponenta;
import domain.Konfiguracija;
import domain.Servis;
import domain.Serviser;
import domain.StavkaKonfiguracije;
import java.util.LinkedList;
import javax.swing.ComboBoxModel;
import transfer.Request;
import transfer.Response;
import util.Operations;
import util.ResponseStatus;

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

    public Serviser login(String username, String password) throws Exception {
        Request request = new Request();
        Serviser serviser = new Serviser();
        serviser.setKorisnickoIme(username);
        serviser.setLozinka(password);

        request.setData(serviser);
        request.setOperation(Operations.OPERATION_LOGIN);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (Serviser) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public LinkedList<Servis> getServices() throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_GET_SERVICES);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (LinkedList<Servis>) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }

    }

    public LinkedList<Klijent> getKlijenti() throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_GET_CLIENTS);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (LinkedList<Klijent>) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public void addClient(Klijent klijent) throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_ADD_CLIENT);
        request.setData(klijent);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public Long getClientLastID() throws Exception {

        Request request = new Request();
        request.setOperation(Operations.OPERATION_GET_LAST_CLIENT_ID);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (Long) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public void updateClient(Klijent klijent) throws Exception {

        Request request = new Request();
        request.setData(klijent);
        request.setOperation(Operations.OPERATION_UPDATE_CLIENT);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public void deleteClient(Klijent klijent) throws Exception {
        Request request = new Request();
        request.setData(klijent);
        request.setOperation(Operations.OPERATION_DELETE_CLIENT);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public void addComponent(Komponenta komponenta) throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_ADD_COMPONENT);
        request.setData(komponenta);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }

    }

    public LinkedList<Komponenta> getComponents(int tip) throws Exception {
        Request request = new Request();
        request.setData(tip);
        request.setOperation(Operations.OPERATION_GET_COMPONENTS);

        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (LinkedList<Komponenta>) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }

    }

    public void saveConfiguration(Konfiguracija konfiguracija) throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_SAVE_CONFIGURATION);
        request.setData(konfiguracija);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public Long getConfigurationLastID() throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_GET_LAST_CONFIGURATION_ID);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (Long) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public Long getComponentLastID() throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_GET_LAST_COMPONENT_ID);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (Long) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }

    }

    public void saveConfigurationItem(StavkaKonfiguracije stavka) throws Exception {

        Request request = new Request();
        request.setOperation(Operations.OPERATION_SAVE_CONFIGURATION_ITEM);
        request.setData(stavka);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public LinkedList<Konfiguracija> getConfigurations(String keyword) throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_GET_CONFIGURATIONS);
        request.setData(keyword);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (LinkedList<Konfiguracija>) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public Object getClientById(Klijent klijent) throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_GET_CLIENT_BY_ID);
        request.setData(klijent);
        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (Klijent) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public LinkedList<StavkaKonfiguracije> getConfigurationComponents(Konfiguracija konfiguracija) throws Exception {

        Request request = new Request();
        request.setData(konfiguracija);
        request.setOperation(Operations.OPERATION_GET_CONFIGURATION_COMPONENTS);

        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (LinkedList<StavkaKonfiguracije>) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public void saveService(Servis servis) throws Exception {

        Request request = new Request();
        request.setOperation(Operations.OPERATION_SAVE_SERVICE);
        request.setData(servis);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public Long getServiceLastID() throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_GET_LAST_SERVICE_ID);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (Long) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public void deleteItem(StavkaKonfiguracije stavka) throws Exception {

        Request request = new Request();
        request.setData(stavka);
        request.setOperation(Operations.OPERATION_DELETE_ITEM);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }

    }

    public Long getLastItemNumber(Konfiguracija konfiguracija) throws Exception {
        Request request = new Request();
        request.setOperation(Operations.OPERATION_GET_LAST_ITEM_ID);
        request.setData(konfiguracija);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
            return (Long) response.getData();
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public void addItem(StavkaKonfiguracije stavka) throws Exception {
        Request request = new Request();
        request.setData(stavka);
        request.setOperation(Operations.OPERATION_ADD_ITEM);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

    public void updateConfigurationPrice(Konfiguracija konfiguracija) throws Exception {
        Request request = new Request();
        request.setData(konfiguracija);
        request.setOperation(Operations.OPERATION_UPDATE_CONFIGURATION_PRICE);

        Communication.getInstance().sendRequest(request);

        Response response = Communication.getInstance().readResponse();

        if (response.getStatus() == ResponseStatus.OK) {
        } else {
            System.out.println(response.getError().toString());
            throw (Exception) response.getError();
        }
    }

}
