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

}
