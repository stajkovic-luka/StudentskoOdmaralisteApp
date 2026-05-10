/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lukas
 */
public class Sluzbenik extends DomainObject {

    private long idSluzbenik;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public Sluzbenik() {
    }
    
    public Sluzbenik(String korisnickoIme, String lozinka){
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }
    
    public Sluzbenik(String ime, String prezime, String korisnickoIme){
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
    }
    
    public Sluzbenik(int idSluzbenik, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.idSluzbenik = idSluzbenik;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public long getIdSluzbenik() {
        return idSluzbenik;
    }

    public void setIdSluzbenik(int idSluzbenik) {
        this.idSluzbenik = idSluzbenik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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

    @Override
    public String toString() {
        return "Sluzbenik{" + "idSluzbenik=" + idSluzbenik + ", ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sluzbenik other = (Sluzbenik) obj;
        if (this.idSluzbenik != other.idSluzbenik) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }

    @Override
    public String tableName() {
        return "sluzbenik";
    }

    @Override
    public String selectColumns() {
        return "idSluzbenik, ime, prezime, korisnickoIme, lozinka";
    }

    @Override
    public String selectWhereClause() {
        return "korisnickoIme=? AND lozinka=?";
    }

    @Override
    public DomainObject mapOne(ResultSet rs) throws SQLException {

        Sluzbenik sluzbenik = new Sluzbenik();

        if (rs.next()) {
            sluzbenik = new Sluzbenik();
            sluzbenik.setIdSluzbenik(rs.getInt("idSluzbenik"));
            sluzbenik.setIme(rs.getString("ime"));
            sluzbenik.setPrezime(rs.getString("prezime"));
            sluzbenik.setKorisnickoIme(rs.getString("korisnickoIme"));
            sluzbenik.setLozinka(rs.getString("lozinka"));

            return sluzbenik;

        } else {
            return null;
        }

    }

    @Override
    public void bindSelectParams(PreparedStatement ps) throws SQLException {
        ps.setString(1, this.getKorisnickoIme());
        ps.setString(2, this.getLozinka());

    }

    @Override
    public List<DomainObject> mapMany(ResultSet rs) throws SQLException {
        List<DomainObject> sluzbenici = new ArrayList<>();

        while (rs.next()) {
            Sluzbenik sluzbenikIzBaze = new Sluzbenik();
            sluzbenikIzBaze.setIdSluzbenik(rs.getInt("idSluzbenik"));
            sluzbenikIzBaze.setIme(rs.getString("ime"));
            sluzbenikIzBaze.setPrezime(rs.getString("prezime"));
            sluzbenikIzBaze.setKorisnickoIme(rs.getString("korisnickoIme"));
            sluzbenikIzBaze.setLozinka(rs.getString("lozinka"));
            sluzbenici.add(sluzbenikIzBaze);
        }

        return sluzbenici;
    }

    @Override
    public String insertColumns() {
        return "";
    }

    @Override
    public String insertValuesClause() {
        return "";
    }

    @Override
    public void bindInsertParams(PreparedStatement ps) throws SQLException {
    }

    @Override
    public String updateSetClause() {
        return "";
    }

    @Override
    public String updateWhereClause() {
        return "";
    }

    @Override
    public void bindUpdateParams(PreparedStatement ps) throws SQLException {
    }

    @Override
    public String deleteWhereClause() {
        return selectWhereClause();
    }

    @Override
    public void bindDeleteParams(PreparedStatement ps) throws SQLException {
        bindSelectParams(ps);
    }

    @Override
    public String searchWhereClause() {
        return selectWhereClause();
    }

    @Override
    public void bindSearchParams(PreparedStatement ps) throws SQLException {
        bindSelectParams(ps);
    }

    @Override
    public String joinFromClause() {
        return tableName();
    }

    @Override
    public String joinWhereClause() {
        return searchWhereClause();
    }

    @Override
    public void bindJoinParams(PreparedStatement ps) throws SQLException {
        bindSearchParams(ps);
    }

    @Override
    public List<DomainObject> mapJoined(ResultSet rs) throws SQLException {
        return mapMany(rs);
    }

}
