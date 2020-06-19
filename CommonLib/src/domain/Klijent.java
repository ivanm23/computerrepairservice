/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class Klijent implements GeneralEntity{
    
    private Long klijentID;
    private String klijentIme;
    private String klijentPrezime;
    private String klijentBrTel;
    private List<Konfiguracija> konfiguracije;

    public Klijent() {
        this.konfiguracije=new LinkedList<>();
    }

    public Klijent(Long klijentID, String klijentIme, String klijentPrezime, String klijentBrTel, List<Konfiguracija> konfiguracije) {
        this.klijentID = klijentID;
        this.klijentIme = klijentIme;
        this.klijentPrezime = klijentPrezime;
        this.klijentBrTel = klijentBrTel;
        this.konfiguracije = konfiguracije;
    }


    public Long getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Long klijentID) {
        this.klijentID = klijentID;
    }

    public String getKlijentIme() {
        return klijentIme;
    }

    public void setKlijentIme(String klijentIme) {
        this.klijentIme = klijentIme;
    }

    public String getKlijentPrezime() {
        return klijentPrezime;
    }

    public void setKlijentPrezime(String klijentPrezime) {
        this.klijentPrezime = klijentPrezime;
    }

    public String getKlijentBrTel() {
        return klijentBrTel;
    }

    public void setKlijentBrTel(String klijentBrTel) {
        this.klijentBrTel = klijentBrTel;
    }

    public List<Konfiguracija> getKonfiguracije() {
        return konfiguracije;
    }

    public void setKonfiguracije(List<Konfiguracija> konfiguracije) {
        this.konfiguracije = konfiguracije;
    }

    @Override
    public String getTableName() {
        return "klijent";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();
        
        while (resultSet.next()) {
            Long id = resultSet.getLong("klijentID");
            String ime = resultSet.getString("klijentIme");
            String prezime = resultSet.getString("klijentPrezime");
            String brTel = resultSet.getString("klijentBrTel");
            
            list.add(new Klijent(id, ime, prezime, brTel, new LinkedList<Konfiguracija>()));
        }
        return list;
    }

    @Override
    public String getColumnsForInsert() {
        return "klijentID, klijentIme, klijentPrezime, klijentBrTel";
    }

    @Override
    public String getValuesForInsert() {
        return "'"+klijentID+"', '"+klijentIme+"', '"+klijentPrezime+"', '"+klijentBrTel+"'";
    }

    @Override
    public String getPrimaryKey() {
        return "klijentID= "+klijentID;
    }

    @Override
    public String getValuesForUpdate() {
       return "klijentIme='"+klijentIme+"', klijentPrezime='"+klijentPrezime+"', klijentBrTel='"+klijentBrTel+"'";
    }

    @Override
    public GeneralEntity getObjectFromRs(ResultSet resultSet) {
        try {
            if(resultSet.next()){
                Long klijentID = resultSet.getLong("klijentID");
                String klijentIme = resultSet.getString("klijentIme");
                String klijentPrezime = resultSet.getString("klijentPrezime");
                String klijentBrTel = resultSet.getString("klijentBrTel");
                
                Klijent klijent = new Klijent();
                klijent.setKlijentIme(klijentIme);
                klijent.setKlijentID(klijentID);
                klijent.setKlijentPrezime(klijentPrezime);
                klijent.setKlijentBrTel(klijentBrTel);
                return klijent;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getPrimaryKeyName() {
        return "klijentID";
    }

    @Override
    public Long getLastId(ResultSet resultSet) {
        Long id = null;
        try {
            if (resultSet.next()) {
                id = resultSet.getLong("klijentID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public String toString() {
        return this.klijentIme+" "+this.klijentPrezime;
    }
    
    
    
}
