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

    private Nocenje mapNocenje(ResultSet rs) throws SQLException {
        Nocenje nocenje = new Nocenje();
        nocenje.setIdNocenje(rs.getLong("idNocenje"));
        nocenje.setCena(rs.getDouble("cena"));
        nocenje.setOpis(rs.getString("opis"));
        return nocenje;
    }
}
