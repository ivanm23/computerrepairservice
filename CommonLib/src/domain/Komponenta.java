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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class Komponenta implements GeneralEntity {

    private Long komponentaID;
    private String model;
    private String proizvodjac;
    private double cena;
    private String opis;
    private TipKomponente tipKomponente;

    public Komponenta() {
    }

    public Komponenta(Long komponentaID, String model, String proizvodjac, double cena, String opis, TipKomponente tipKomponente) {
        this.komponentaID = komponentaID;
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.cena = cena;
        this.opis = opis;
        this.tipKomponente = tipKomponente;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public TipKomponente getTipKomponente() {
        return tipKomponente;
    }

    public void setTipKomponente(TipKomponente tipKomponente) {
        this.tipKomponente = tipKomponente;
    }

    @Override
    public String getTableName() {
        return "komponenta";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();

        while (resultSet.next()) {
            Long komponentaID = resultSet.getLong("komponentaID");
            String model = resultSet.getString("model");
            String proizvodjac = resultSet.getString("proizvodjac");
            String opis = resultSet.getString("opis");
            Double cena = resultSet.getDouble("cena");
            int tip = resultSet.getInt("tipKomponente");
            TipKomponente tipKomponente = TipKomponente.values()[tip];
            list.add(new Komponenta(komponentaID, model, proizvodjac, cena, opis, tipKomponente));
        }
        return list;
    }

    @Override
    public String getColumnsForInsert() {
        return "komponentaID, model, proizvodjac, cena, opis, tipKomponente";
    }

    @Override
    public String getValuesForInsert() {
        return "'" + komponentaID + "', '" + model + "', '" + proizvodjac + "', '" + cena + "', '" + opis + "', '" + tipKomponente.ordinal() + "'";
    }

    @Override
    public String getPrimaryKey() {
        return "komponentaID="+komponentaID;
    }

    @Override
    public String getValuesForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralEntity getObjectFromRs(ResultSet resultSet) {
        
        try {
            if (resultSet.next()) {
                Long komponentaID = resultSet.getLong("KomponentaID");
                String model = resultSet.getString("model");
                String proizvodjac = resultSet.getString("Proizvodjac");
                Double cena = resultSet.getDouble("cena");
                String opis = resultSet.getString("opis");
                int type = resultSet.getInt("tipKomponente");
                TipKomponente tip = TipKomponente.values()[type];
                
                return new Komponenta(komponentaID, model, proizvodjac, cena, opis, tip);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Komponenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getPrimaryKeyName() {
        return "komponentaID";
    }

    @Override
    public Long getLastId(ResultSet resultSet) {
        Long id = null;
        try {
            if (resultSet.next()) {
                id = resultSet.getLong("komponentaID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     * @return the opis
     */
    public String getOpis() {
        return opis;
    }

    /**
     * @param opis the opis to set
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return proizvodjac + " " + model;
    }

    /**
     * @return the komponentaID
     */
    public Long getKomponentaID() {
        return komponentaID;
    }

    /**
     * @param komponentaID the komponentaID to set
     */
    public void setKomponentaID(Long komponentaID) {
        this.komponentaID = komponentaID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Komponenta other = (Komponenta) obj;
        if (!Objects.equals(this.komponentaID, other.komponentaID)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.proizvodjac, other.proizvodjac)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (this.tipKomponente != other.tipKomponente) {
            return false;
        }
        return true;
    }

}
