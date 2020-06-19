/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import controller.Controller;
import domain.GeneralEntity;
import domain.Klijent;
import domain.Komponenta;
import domain.Konfiguracija;
import domain.Servis;
import domain.Serviser;
import domain.StavkaKonfiguracije;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Request;
import transfer.Response;
import util.Operations;
import util.ResponseStatus;

/**
 *
 * @author Ivan
 */
public class ClientThread extends Thread {

    Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {

            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Object obj = ois.readObject();
                if (obj instanceof Request) {
                    Request request = (Request) obj;
                    Response response = handleRequest(request);
                    sendResponse(socket, response);

                }
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Response handleRequest(Request request) {
        int operation = request.getOperation();
        Response response = new Response();
        switch (operation) {
            //implementacija operacija
            case Operations.OPERATION_LOGIN:
                try {
                    Serviser serviserRequest = (Serviser) request.getData();
                    GeneralEntity serviser = Controller.getInstance().login(serviserRequest.getKorisnickoIme(), serviserRequest.getLozinka());
                    response.setStatus(ResponseStatus.OK);
                    response.setData(serviser);
                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);

                }
                break;
            case Operations.OPERATION_GET_SERVICES:
                try {
                    LinkedList<Servis> servisi = (LinkedList<Servis>) Controller.getInstance().getServices();
                    response.setStatus(ResponseStatus.OK);
                    response.setData(servisi);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_GET_CLIENTS:
                try {
                    LinkedList<Klijent> klijenti = (LinkedList<Klijent>) Controller.getInstance().getClients();
                    response.setStatus(ResponseStatus.OK);
                    response.setData(klijenti);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_GET_LAST_CLIENT_ID:
                try {
                    Long id = Controller.getInstance().getClientLastID();
                    response.setStatus(ResponseStatus.OK);
                    response.setData(id);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_ADD_CLIENT:
                try {
                    Klijent klijent = (Klijent) request.getData();
                    Controller.getInstance().addClient(klijent);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_UPDATE_CLIENT:
                try {
                    Klijent klijent = (Klijent) request.getData();
                    Controller.getInstance().updateClient(klijent);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_DELETE_CLIENT:
                try {
                    Klijent klijent = (Klijent) request.getData();
                    Controller.getInstance().deleteClient(klijent);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_ADD_COMPONENT:
                try {
                    Komponenta komponenta = (Komponenta) request.getData();
                    Controller.getInstance().addComponent(komponenta);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_GET_COMPONENTS:
                try {
                    int tip = (int) request.getData();
                    LinkedList<Komponenta> komponente = (LinkedList<Komponenta>) Controller.getInstance().getComponents(tip);
                    response.setStatus(ResponseStatus.OK);
                    response.setData(komponente);
                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_SAVE_CONFIGURATION:
                try {
                    Konfiguracija konfiguracija = (Konfiguracija) request.getData();
                    Controller.getInstance().saveConfiguration(konfiguracija);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_GET_LAST_CONFIGURATION_ID:
                try {
                    Long id = Controller.getInstance().getConfigurationLastID();
                    response.setStatus(ResponseStatus.OK);
                    response.setData(id);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_GET_LAST_COMPONENT_ID:
                try {
                    Long id = Controller.getInstance().getComponentLastID();
                    response.setStatus(ResponseStatus.OK);
                    response.setData(id);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_SAVE_CONFIGURATION_ITEM:
                try {
                    StavkaKonfiguracije stavka = (StavkaKonfiguracije) request.getData();
                    Controller.getInstance().saveConfigurationItem(stavka);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_GET_CONFIGURATIONS:
                try {
                    String keyword = (String) request.getData();
                    LinkedList<Konfiguracija> konfiguracije = (LinkedList<Konfiguracija>) Controller.getInstance().getConfigurations(keyword);
                    response.setStatus(ResponseStatus.OK);
                    response.setData(konfiguracije);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_GET_CLIENT_BY_ID:
                try {
                    Klijent dummy = (Klijent) request.getData();
                    Klijent klijent = (Klijent) Controller.getInstance().getClientByID(dummy);
                    response.setStatus(ResponseStatus.OK);
                    response.setData(klijent);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_GET_CONFIGURATION_COMPONENTS:
                try {
                    Konfiguracija konfiguracija = (Konfiguracija) request.getData();
                    LinkedList<StavkaKonfiguracije> komponente = (LinkedList<StavkaKonfiguracije>) Controller.getInstance().getConfigurationComponents(konfiguracija);
                    response.setStatus(ResponseStatus.OK);
                    response.setData(komponente);
                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_SAVE_SERVICE:
                try {
                    Servis servis = (Servis) request.getData();
                    Controller.getInstance().saveService(servis);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_GET_LAST_SERVICE_ID:
                try {
                    Long id = Controller.getInstance().getServiceLastID();
                    response.setStatus(ResponseStatus.OK);
                    response.setData(id);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_DELETE_ITEM:
                try {
                    StavkaKonfiguracije stavka = (StavkaKonfiguracije) request.getData();
                    Controller.getInstance().deleteItem(stavka);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_GET_LAST_ITEM_ID:
                try {
                    Konfiguracija konfiguracija = (Konfiguracija) request.getData();
                    Long id = Controller.getInstance().getItemLastID(konfiguracija);
                    response.setStatus(ResponseStatus.OK);
                    response.setData(id);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operations.OPERATION_ADD_ITEM:
                try {
                    StavkaKonfiguracije stavka = (StavkaKonfiguracije) request.getData();
                    Controller.getInstance().addItem(stavka);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                case Operations.OPERATION_UPDATE_CONFIGURATION_PRICE:
                try {
                    Konfiguracija konfiguracija = (Konfiguracija) request.getData();
                    Controller.getInstance().updateConfigurationPrice(konfiguracija);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
        }
        return response; //vrati response posle implementacije
    }

    public void sendResponse(Socket socket, Response response) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(response);

    }

    public void stoppedByServer() {
        try {
            socket.close();
            interrupt();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
