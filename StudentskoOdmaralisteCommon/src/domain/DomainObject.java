package domain;

import java.sql.*;
import java.util.List;

public interface DomainObject {

    // TBL
    String getTableName();

    // SELECT
    String getColumnsForSelect();

    List<DomainObject> getResultParamsForSelectMultiple(ResultSet rs) throws SQLException;

    DomainObject getResultParamsForSelectOne(ResultSet rs) throws SQLException;

    String getSelectWhereClause();

    void setParamsForSelect(PreparedStatement ps) throws SQLException;

}
