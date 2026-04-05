package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Fakultet extends DomainObject{
    private int idFakultet;
    private String naziv;
    private String mesto;
    private boolean akreditovan;

    public Fakultet() {
    }

    public Fakultet(int idFakultet, String naziv, String mesto, boolean akreditovan) {
        this.idFakultet = idFakultet;
        this.naziv = naziv;
        this.mesto = mesto;
        this.akreditovan = akreditovan;
    }

    public int getIdFakultet() {
        return idFakultet;
    }

    public void setIdFakultet(int idFakultet) {
        this.idFakultet = idFakultet;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public boolean isAkreditovan() {
        return akreditovan;
    }

    public void setAkreditovan(boolean akreditovan) {
        this.akreditovan = akreditovan;
    }

    @Override
    public String tableName() {
        return "fakultet";
    }

    @Override
    public String selectColumns() {
        return "idFakultet, naziv, mesto, akreditovan";
    }

    @Override
    public List<DomainObject> mapMany(ResultSet rs) throws SQLException {
        List<DomainObject> fakulteti = new ArrayList<>();
        while (rs.next()) {
            fakulteti.add(mapFakultet(rs));
        }
        return fakulteti;
    }

    @Override
    public DomainObject mapOne(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return mapFakultet(rs);
        }
        return null;
    }

    @Override
    public String selectWhereClause() {
        return "idFakultet=?";
    }

    @Override
    public void bindSelectParams(PreparedStatement ps) throws SQLException {
        ps.setInt(1, idFakultet);
    }

    private Fakultet mapFakultet(ResultSet rs) throws SQLException {
        Fakultet fakultet = new Fakultet();
        fakultet.setIdFakultet(rs.getInt("idFakultet"));
        fakultet.setNaziv(rs.getString("naziv"));
        fakultet.setMesto(rs.getString("mesto"));
        fakultet.setAkreditovan(rs.getBoolean("akreditovan"));
        return fakultet;
    }
}
