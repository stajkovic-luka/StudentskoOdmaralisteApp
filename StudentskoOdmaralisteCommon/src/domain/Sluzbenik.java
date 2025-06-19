/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
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
public class Sluzbenik implements Serializable, DomainObject {

    private int idSluzbenik;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public Sluzbenik() {
    }

    public Sluzbenik(int idSluzbenik, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.idSluzbenik = idSluzbenik;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getIdSluzbenik() {
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
    public String getTableName() {
        return "sluzbenik";
    }

    @Override
    public String getColumnsForSelect() {
        return "idSluzbenik, ime, prezime, korisnickoIme, lozinka";
    }

    @Override
    public String getSelectWhereClause() {
        return "username=? AND password=?";
    }

    @Override
    public DomainObject getResultParamsForSelectOne(ResultSet rs) throws SQLException {

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
    public void setParamsForSelect(PreparedStatement ps) throws SQLException {
        ps.setString(1, "korisnickoIme");
        ps.setString(2, "lozinka");

    }

    @Override
    public List<DomainObject> getResultParamsForSelectMultiple(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
