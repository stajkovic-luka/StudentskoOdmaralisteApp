package domain;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

public abstract class DomainObject implements Serializable {

    // Iz koje tabele citamo podatke
    public abstract String tableName();

    // Koje kolone vracamo u SELECT delu
    public abstract String selectColumns();

    // Mapiranje vise redova iz ResultSet-a
    public abstract List<DomainObject> mapMany(ResultSet rs) throws SQLException;

    // Mapiranje jednog reda iz ResultSet-a
    public abstract DomainObject mapOne(ResultSet rs) throws SQLException;

    // WHERE deo za SELECT upit
    public abstract String selectWhereClause();

    // Popunjavanje parametara za PreparedStatement
    public abstract void bindSelectParams(PreparedStatement ps) throws SQLException;

    // Koje kolone popunjavamo u INSERT delu
    public abstract String insertColumns();

    // VALUES deo za INSERT upit (npr: ?, ?, ?)
    public abstract String insertValuesClause();

    // Popunjavanje parametara za INSERT
    public abstract void bindInsertParams(PreparedStatement ps) throws SQLException;

    // SET deo za UPDATE upit
    public abstract String updateSetClause();

    // WHERE deo za UPDATE upit
    public abstract String updateWhereClause();

    // Popunjavanje parametara za UPDATE
    public abstract void bindUpdateParams(PreparedStatement ps) throws SQLException;

    // WHERE deo za DELETE upit
    public abstract String deleteWhereClause();

    // Popunjavanje parametara za DELETE
    public abstract void bindDeleteParams(PreparedStatement ps) throws SQLException;

    // WHERE deo za SEARCH scenarije
    public abstract String searchWhereClause();

    // Popunjavanje parametara za SEARCH
    public abstract void bindSearchParams(PreparedStatement ps) throws SQLException;

    // FROM deo kada se radi JOIN (podrazumevano ista tabela)
    public abstract String joinFromClause();

    // Dodatni WHERE deo za JOIN upit (opciono)
    public abstract String joinWhereClause();

    // Parametri za JOIN upit (opciono)
    public abstract void bindJoinParams(PreparedStatement ps) throws SQLException;

    // Mapiranje rezultata kada se radi JOIN
    public abstract List<DomainObject> mapJoined(ResultSet rs) throws SQLException;

    // Da li tabela koristi auto-increment primarni kljuc
    public boolean hasAutoIncrementPrimaryKey() {
        return true;
    }

    // Postavljanje generisanog primarnog kljuca nakon INSERT-a
    public void setGeneratedPrimaryKey(long generatedPrimaryKey) {
        // Override po potrebi
    }

}
