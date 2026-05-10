package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Nocenje extends DomainObject{
    private long idNocenje;
    private double cena;
    private String opis;

    public Nocenje() {
    }

    public Nocenje(long idNocenje, double cena, String opis) {
        this.idNocenje = idNocenje;
        this.cena = cena;
        this.opis = opis;
    }

    public long getIdNocenje() {
        return idNocenje;
    }

    public void setIdNocenje(long idNocenje) {
        this.idNocenje = idNocenje;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String tableName() {
        return "nocenje";
    }

    @Override
    public String selectColumns() {
        return "idNocenje, cena, opis";
    }

    @Override
    public List<DomainObject> mapMany(ResultSet rs) throws SQLException {
        List<DomainObject> nocenja = new ArrayList<>();
        while (rs.next()) {
            nocenja.add(mapNocenje(rs));
        }
        return nocenja;
    }

    @Override
    public DomainObject mapOne(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return mapNocenje(rs);
        }
        return null;
    }

    @Override
    public String selectWhereClause() {
        return "idNocenje=?";
    }

    @Override
    public void bindSelectParams(PreparedStatement ps) throws SQLException {
        ps.setLong(1, idNocenje);
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

    private Nocenje mapNocenje(ResultSet rs) throws SQLException {
        Nocenje nocenje = new Nocenje();
        nocenje.setIdNocenje(rs.getLong("idNocenje"));
        nocenje.setCena(rs.getDouble("cena"));
        nocenje.setOpis(rs.getString("opis"));
        return nocenje;
    }
}
