/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import domain.Serviser;

/**
 *
 * @author Ivan
 */
public class Session {
    
    private Serviser serviser;
    private static Session instance;

    public Session() {
    }
    
    public Serviser getServiser(){
    return serviser;
    }
    
    public void setServiser(Serviser serviser){
    this.serviser=serviser;
    }

    public static Session getInstance() {
        if (instance==null) {
            instance = new Session();
        }
        return instance;
    }
    
    
}
