/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lukas
 */
public class SluzbenikSmena extends DomainObject{
    private Sluzbenik sluzbenik;
    private Smena smena;
    private LocalDate datumSmene;

    public SluzbenikSmena() {
    }

    public SluzbenikSmena(Sluzbenik sluzbenik, Smena smena, LocalDate datumSmene) {
        this.sluzbenik = sluzbenik;
        this.smena = smena;
        this.datumSmene = datumSmene;
    }

    public Sluzbenik getSluzbenik() {
        return sluzbenik;
    }

    public void setSluzbenik(Sluzbenik sluzbenik) {
        this.sluzbenik = sluzbenik;
    }

    public Smena getSmena() {
        return smena;
    }

    public void setSmena(Smena smena) {
        this.smena = smena;
    }

    public LocalDate getDatumSmene() {
        return datumSmene;
    }

    public void setDatumSmene(LocalDate datumSmene) {
        this.datumSmene = datumSmene;
    }

    @Override
    public String tableName() {
        return "sluzbeniksmena";
    }

    @Override
    public String selectColumns() {
        return "idSluzbenik, idSmena, datumSmene";
    }

    @Override
    public List<DomainObject> mapMany(ResultSet rs) throws SQLException {
        List<DomainObject> sluzbeniciSmene = new ArrayList<>();
        while (rs.next()) {
            sluzbeniciSmene.add(mapSluzbenikSmena(rs));
        }
        return sluzbeniciSmene;
    }

    @Override
    public DomainObject mapOne(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return mapSluzbenikSmena(rs);
        }
        return null;
    }

    @Override
    public String selectWhereClause() {
        return "idSluzbenik=? AND idSmena=? AND datumSmene=?";
    }

    @Override
    public void bindSelectParams(PreparedStatement ps) throws SQLException {
        if (sluzbenik == null || smena == null || datumSmene == null) {
            throw new SQLException("Sluzbenik, smena i datum smene moraju biti postavljeni za pretragu.");
        }

        ps.setLong(1, sluzbenik.getIdSluzbenik());
        ps.setLong(2, smena.getIdSmena());
        ps.setDate(3, Date.valueOf(datumSmene));
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

    private SluzbenikSmena mapSluzbenikSmena(ResultSet rs) throws SQLException {
        SluzbenikSmena raspored = new SluzbenikSmena();

        Sluzbenik rasporedSluzbenik = new Sluzbenik();
        rasporedSluzbenik.setIdSluzbenik(rs.getInt("idSluzbenik"));
        raspored.setSluzbenik(rasporedSluzbenik);

        Smena rasporedSmena = new Smena();
        rasporedSmena.setIdSmena(rs.getLong("idSmena"));
        raspored.setSmena(rasporedSmena);

        Date datumSmeneVrednost = rs.getDate("datumSmene");
        if (datumSmeneVrednost != null) {
            raspored.setDatumSmene(datumSmeneVrednost.toLocalDate());
        }

        return raspored;
    }
}
