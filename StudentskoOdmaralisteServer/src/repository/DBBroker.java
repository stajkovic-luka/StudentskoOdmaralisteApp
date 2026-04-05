package repository;

import domain.DomainObject;
import java.sql.*;

public class DBBroker {

    private final Connection connection;

    public DBBroker(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public DomainObject getSingleInstance(DomainObject domainObject) throws SQLException {
        try {
            String query = "SELECT " + domainObject.selectColumns()
                    + " FROM " + domainObject.tableName()
                    + " WHERE " + domainObject.selectWhereClause();

            PreparedStatement ps = connection.prepareStatement(query);
            domainObject.bindSelectParams(ps);

            System.out.println("QUERY: " + ps.toString());

            ResultSet rs = ps.executeQuery();

            DomainObject domainObject2 = domainObject.mapOne(rs);
            System.out.println("DBB: Uspesno ucitan objekat iz baze");

            ps.close();
            rs.close();
            return domainObject2;

        } catch (SQLException ex) {
            System.out.println("DBB: Greska prilikom ucitavanja objekta iz baze.");
            ex.printStackTrace();
            throw ex;
        }
    }

}
