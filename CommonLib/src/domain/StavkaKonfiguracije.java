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
public class StavkaKonfiguracije implements GeneralEntity{

    private Konfiguracija konfiguracija;
    private Long brojKomponente;
    private int kolicina;
    private double pojedinacnaCena;
    private double ukupnaCena;
    private Komponenta komponenta;

    public StavkaKonfiguracije() {
    }

    public StavkaKonfiguracije(Konfiguracija konfiguracija, Long brojKomponente, int kolicina, double pojedinacnaCena, double ukupnaCena, Komponenta komponenta) {
        this.konfiguracija = konfiguracija;
        this.brojKomponente = brojKomponente;
        this.kolicina = kolicina;
        this.pojedinacnaCena = pojedinacnaCena;
        this.ukupnaCena = ukupnaCena;
        this.komponenta = komponenta;
    }
    
    
    @Override
    public String getTableName() {
        return "stavkaKonfiguracije";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();
        
        while (resultSet.next()) {
            Long id = resultSet.getLong("brojKomponente");
            
            Long konfiguracijaID = resultSet.getLong("konfiguracijaID");
            Konfiguracija konfiguracija = new Konfiguracija();
            konfiguracija.setKonfiguracijaID(konfiguracijaID);
            
            int kolicina = resultSet.getInt("kolicina");
            double pojedinacnaCena = resultSet.getDouble("pojedinacnaCena");
            double ukupnaCena = resultSet.getDouble("ukupnaCena");
            
            Long komponentaID = resultSet.getLong("komponentaID");
            Komponenta komponenta = new Komponenta();
            komponenta.setKomponentaID(komponentaID);
            
            list.add(new StavkaKonfiguracije(konfiguracija, id, kolicina, pojedinacnaCena, ukupnaCena, komponenta));
        }
        return list;
    }

    @Override
    public String getColumnsForInsert() {
        return "konfiguracijaID, brojKomponente, kolicina, pojedinacnaCena, ukupnaCena, komponentaID";
    }

    @Override
    public String getValuesForInsert() {
       return "'" + konfiguracija.getKonfiguracijaID()+ "', '"  + brojKomponente + "', '" +kolicina + "', '" +pojedinacnaCena + "', '" +ukupnaCena + "', '" +komponenta.getKomponentaID() +"'";
    }

    @Override
    public String getPrimaryKey() {
        return "konfiguracijaID=" + konfiguracija.getKonfiguracijaID() + " AND brojKomponente=" + brojKomponente;
    }

    @Override
    public String getValuesForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralEntity getObjectFromRs(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrimaryKeyName() {
        return "konfiguracijaID, brojKomponente";
    }

    @Override
    public Long getLastId(ResultSet resultSet) {
        Long id = null;
        try {
            if (resultSet.next()) {
                id = resultSet.getLong("brojKomponente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
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
     * @return the brojKomponente
     */
    public Long getBrojKomponente() {
        return brojKomponente;
    }

    /**
     * @param brojKomponente the brojKomponente to set
     */
    public void setBrojKomponente(Long brojKomponente) {
        this.brojKomponente = brojKomponente;
    }

    /**
     * @return the kolicina
     */
    public int getKolicina() {
        return kolicina;
    }

    /**
     * @param kolicina the kolicina to set
     */
    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    /**
     * @return the pojedinacnaCena
     */
    public double getPojedinacnaCena() {
        return pojedinacnaCena;
    }

    /**
     * @param pojedinacnaCena the pojedinacnaCena to set
     */
    public void setPojedinacnaCena(double pojedinacnaCena) {
        this.pojedinacnaCena = pojedinacnaCena;
    }

    /**
     * @return the ukupnaCena
     */
    public double getUkupnaCena() {
        return ukupnaCena;
    }

    /**
     * @param ukupnaCena the ukupnaCena to set
     */
    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    /**
     * @return the komponenta
     */
    public Komponenta getKomponenta() {
        return komponenta;
    }

    /**
     * @param komponenta the komponenta to set
     */
    public void setKomponenta(Komponenta komponenta) {
        this.komponenta = komponenta;
    }

    @Override
    public String toString() {
        return this.getKomponenta() + " x"+this.getKolicina();
    }
    
}
