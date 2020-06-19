/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.ServerSocket;
import config.Configuration;
import java.io.IOException;
import java.net.Socket;
import threads.ClientThread;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import threads.ClientThread;

/**
 *
 * @author Ivan
 */
public class Server extends Thread{
    LinkedList<ClientThread> clients = new LinkedList<>();
    ServerSocket serverSocket;

    @Override
    public void run() {
        try {
            int port = Integer.parseInt(Configuration.getInstance().getProperty("port"));
            serverSocket = new ServerSocket(port);
            while(!isInterrupted()){
                System.out.println("Server is alive and well");
                System.out.println("Waiting for clients...");
                Socket client = serverSocket.accept();
                ClientThread clientThread = new ClientThread(client);
                System.out.println("New client connected");
                clients.add(clientThread);
                clientThread.start();
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopServer(){
        for (ClientThread client : clients) {
            client.stoppedByServer();
        }
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
