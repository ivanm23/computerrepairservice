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
public class Konfiguracija implements GeneralEntity {

    private Long konfiguracijaID;
    private double ukupnaCena;
    private Klijent vlasnik;

    public Konfiguracija() {
    }

    public Konfiguracija(Long konfiguracijaID, double ukupnaCena, Klijent vlasnik) {
        this.konfiguracijaID = konfiguracijaID;
        this.ukupnaCena = ukupnaCena;
        this.vlasnik = vlasnik;
    }

    public Long getKonfiguracijaID() {
        return konfiguracijaID;
    }

    public void setKonfiguracijaID(Long konfiguracijaID) {
        this.konfiguracijaID = konfiguracijaID;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Klijent getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Klijent vlasnik) {
        this.vlasnik = vlasnik;
    }

    @Override
    public String getTableName() {
        return "konfiguracija";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();

        while (resultSet.next()) {
            Long id = resultSet.getLong("konfiguracijaID");
            Long klijentId = resultSet.getLong("klijentID");
            Klijent klijent = new Klijent();
            klijent.setKlijentID(klijentId);
            Double cena = resultSet.getDouble("ukupnaCena");
            list.add(new Konfiguracija(id, cena, klijent));
        }
        return list;
    }

    @Override
    public String getColumnsForInsert() {
        return "konfiguracijaID, klijentID, ukupnaCena";
    }

    @Override
    public String getValuesForInsert() {
        return "'" + konfiguracijaID + "', '" + getVlasnik().getKlijentID() + "', '" + getUkupnaCena() + "'";
    }

    @Override
    public String getPrimaryKey() {
        return "konfiguracijaID = " + konfiguracijaID;
    }

    @Override
    public String getValuesForUpdate() {
        return "ukupnaCena='"+ukupnaCena+"'";
    }

    @Override
    public GeneralEntity getObjectFromRs(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                Long konfiguracijaID = resultSet.getLong("konfiguracijaID");
                Long klijentID = resultSet.getLong("klijentID");
                Klijent klijent = new Klijent();
                klijent.setKlijentID(klijentID);
                double ukupnaCena = resultSet.getDouble("ukupnaCena");

                Konfiguracija konfiguracija = new Konfiguracija(konfiguracijaID, ukupnaCena, klijent);
                return konfiguracija;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getPrimaryKeyName() {
        return "konfiguracijaID";
    }

    @Override
    public Long getLastId(ResultSet resultSet) {
        Long id = null;
        try {
            if (resultSet.next()) {
                id = resultSet.getLong("konfiguracijaID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
