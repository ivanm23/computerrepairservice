/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class Serviser implements GeneralEntity{
    
    private int serviserID;
    private String serviserIme;
    private String serviserPrezime;
    private String korisnickoIme;
    private String lozinka;
    private String serviserBrTel;
    private String poljeStrucnosti;

    public Serviser() {
    }

    public Serviser(int serviserID, String serviserIme, String serviserPrezime, String korisnickoIme, String lozinka, String serviserBrTel, String poljeStrucnosti) {
        this.serviserID = serviserID;
        this.serviserIme = serviserIme;
        this.serviserPrezime = serviserPrezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.serviserBrTel = serviserBrTel;
        this.poljeStrucnosti = poljeStrucnosti;
    }


    public int getServiserID() {
        return serviserID;
    }

    public void setServiserID(int serviserID) {
        this.serviserID = serviserID;
    }

    public String getServiserIme() {
        return serviserIme;
    }

    public void setServiserIme(String serviserIme) {
        this.serviserIme = serviserIme;
    }

    public String getServiserPrezime() {
        return serviserPrezime;
    }

    public void setServiserPrezime(String serviserPrezime) {
        this.serviserPrezime = serviserPrezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getServiserBrTel() {
        return serviserBrTel;
    }

    public void setServiserBrTel(String serviserBrTel) {
        this.serviserBrTel = serviserBrTel;
    }

    public String getPoljeStrucnosti() {
        return poljeStrucnosti;
    }

    public void setPoljeStrucnosti(String poljeStrucnosti) {
        this.poljeStrucnosti = poljeStrucnosti;
    }


    @Override
    public String getTableName() {
        return "serviser";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();
        while (resultSet.next()){
            int serviserID = resultSet.getInt("serviserID");
            String serviserIme = resultSet.getString("serviserIme");
            String serviserPrezime = resultSet.getString("serviserPrezime");
            String korisnickoIme = resultSet.getString("korisnickoIme");
            String lozinka = resultSet.getString("lozinka");
            String serviserBrTel = resultSet.getString("serviserBrTel");
            String poljeStrucnosti = resultSet.getString("poljeStrucnosti");
            Serviser serviser = new Serviser(serviserID, serviserIme, serviserPrezime, korisnickoIme, lozinka, serviserBrTel, poljeStrucnosti);
            list.add(serviser);
        }
        return list;
    }

    @Override
    public String getColumnsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValuesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrimaryKey() {
        return "serviserID= "+serviserID;
    }

    @Override
    public String getValuesForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralEntity getObjectFromRs(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                int serviserID = resultSet.getInt("serviserID");
                String serviserIme = resultSet.getString("serviserIme");
                String serviserPrezime = resultSet.getString("serviserPrezime");
                String korisnickoIme = resultSet.getString("korisnickoIme");
                String lozinka = resultSet.getString("lozinka");
                String serviserBrTel = resultSet.getString("serviserBrTel");
                String poljeStrucnosti = resultSet.getString("poljeStrucnosti");
                Serviser serviser = new Serviser(serviserID, serviserIme, serviserPrezime, korisnickoIme, lozinka, serviserBrTel, poljeStrucnosti);
                return serviser;
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public String getPrimaryKeyName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getLastId(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return serviserIme+" "+serviserPrezime;
    }

    
}
