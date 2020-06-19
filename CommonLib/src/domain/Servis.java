/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class Servis implements GeneralEntity {

    private Long servisID;
    private Date datumServisa;
    private Serviser serviser;
    private String opis;
    private Konfiguracija konfiguracija;

    public Servis() {
    }

    public Servis(Long servisID, Date datumServisa, Serviser serviser, String opis, Konfiguracija konfiguracija) {
        this.servisID = servisID;
        this.datumServisa = datumServisa;
        this.serviser = serviser;
        this.opis = opis;
        this.konfiguracija = konfiguracija;
    }

    @Override
    public String getTableName() {
        return "servis";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong("servisID");
            Date date = resultSet.getDate("datumServisa");
            String opis = resultSet.getString("opis");

            //Fetch serviser info
            int serviserID = resultSet.getInt("serviserID");
            Serviser serviser = new Serviser();
            serviser.setServiserID(serviserID);

            //Fetch konfiguracija info
            Long konfiguracijaID = resultSet.getLong("konfiguracijaID");
            Konfiguracija konfiguracija = new Konfiguracija();
            konfiguracija.setKonfiguracijaID(konfiguracijaID);

            list.add(new Servis(id, date, serviser, opis, konfiguracija));
        }
        return list;
    }

    @Override
    public String getColumnsForInsert() {
        return "servisID, datumServisa, opis, konfiguracijaID, serviserID";
    }

    @Override
    public String getValuesForInsert() {
        java.sql.Date sqlDate = new java.sql.Date(datumServisa.getTime());
        return "'" + servisID + "', '" + sqlDate + "', '" + opis + "', '" + konfiguracija.getKonfiguracijaID() + "', '" + serviser.getServiserID() + "'";
    }

    @Override
    public String getPrimaryKey() {
        return "servisID= " + servisID;
    }

    @Override
    public String getValuesForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralEntity getObjectFromRs(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                Long id = resultSet.getLong("servisID");
                Date date = resultSet.getDate("datumServisa");
                String opis = resultSet.getString("opis");

                //Fetch serviser info
                int serviserID = resultSet.getInt("serviserID");
                Serviser serviser = new Serviser();
                serviser.setServiserID(serviserID);

                //Fetch konfiguracija info
                Long konfiguracijaID = resultSet.getLong("konfiguracijaID");
                Konfiguracija konfiguracija = new Konfiguracija();
                konfiguracija.setKonfiguracijaID(konfiguracijaID);

                Servis servis = new Servis();
                servis.setDatumServisa(date);
                servis.setServisID(id);
                servis.setOpis(opis);
                servis.setKonfiguracija(konfiguracija);
                servis.setServiser(serviser);
                return servis;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Servis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getPrimaryKeyName() {
        return "servisID";
    }

    @Override
    public Long getLastId(ResultSet resultSet) {
        Long id = null;
        try {
            if (resultSet.next()) {
                id = resultSet.getLong("servisID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     * @return the datumServisa
     */
    public Date getDatumServisa() {
        return datumServisa;
    }

    /**
     * @param datumServisa the datumServisa to set
     */
    public void setDatumServisa(Date datumServisa) {
        this.datumServisa = datumServisa;
    }

    /**
     * @return the serviser
     */
    public Serviser getServiser() {
        return serviser;
    }

    /**
     * @param serviser the serviser to set
     */
    public void setServiser(Serviser serviser) {
        this.serviser = serviser;
    }

    /**
     * @return the konfiguracija
     */
    public Konfiguracija getKonfiguracija() {
        return konfiguracija;
    }

    /**
     * @param konfiguracija the konfiguracija to set
     */
    public void setKonfiguracija(Konfiguracija konfiguracija) {
        this.konfiguracija = konfiguracija;
    }

    /**
     * @return the servisID
     */
    public Long getServisID() {
        return servisID;
    }

    /**
     * @param servisID the servisID to set
     */
    public void setServisID(Long servisID) {
        this.servisID = servisID;
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
        if (this.opis.length()>10) {
            return this.datumServisa.toString() + " - " + this.opis.substring(0, 9)+'.';
        }
        return this.datumServisa.toString() + " - " + this.opis;
    }

}
