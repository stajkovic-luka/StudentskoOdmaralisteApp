package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lukas
 */
public class Smena extends DomainObject {

    private long idSmena;
    private String prostorija;
    private String komentar;
    private TipSmene tipSmene;

    public Smena() {
    }

    public Smena(long idSmena, String prostorija, String komentar, TipSmene tipSmene) {
        this.idSmena = idSmena;
        this.prostorija = prostorija;
        this.komentar = komentar;
        this.tipSmene = tipSmene;
    }

    public long getIdSmena() {
        return idSmena;
    }

    public void setIdSmena(long idSmena) {
        this.idSmena = idSmena;
    }

    public String getProstorija() {
        return prostorija;
    }

    public void setProstorija(String prostorija) {
        this.prostorija = prostorija;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public TipSmene getTipSmene() {
        return tipSmene;
    }

    public void setTipSmene(TipSmene tipSmene) {
        this.tipSmene = tipSmene;
    }

    @Override
    public String tableName() {
        return "smena";
    }

    @Override
    public String selectColumns() {
        return "idSmena, prostorija, komentar, tipSmene";
    }

    @Override
    public List<DomainObject> mapMany(ResultSet rs) throws SQLException {
        List<DomainObject> smene = new ArrayList<>();
        while (rs.next()) {
            smene.add(mapSmena(rs));
        }
        return smene;
    }

    @Override
    public DomainObject mapOne(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return mapSmena(rs);
        }
        return null;
    }

    @Override
    public String selectWhereClause() {
        return "idSmena=?";
    }

    @Override
    public void bindSelectParams(PreparedStatement ps) throws SQLException {
        ps.setLong(1, idSmena);
    }

    @Override
    public String insertColumns() {
        return "prostorija, komentar, tipSmene";
    }

    @Override
    public String insertValuesClause() {
        return "?, ?, ?";
    }

    @Override
    public void bindInsertParams(PreparedStatement ps) throws SQLException {
        ps.setString(1, prostorija);
        ps.setString(2, komentar);
        ps.setString(3, tipSmene.name());
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

    private Smena mapSmena(ResultSet rs) throws SQLException {
        Smena smena = new Smena();
        smena.setIdSmena(rs.getLong("idSmena"));
        smena.setProstorija(rs.getString("prostorija"));
        smena.setKomentar(rs.getString("komentar"));

        String tipSmeneVrednost = rs.getString("tipSmene");
        if (tipSmeneVrednost != null) {
            smena.setTipSmene(TipSmene.valueOf(tipSmeneVrednost));
        }

        return smena;
    }
}
