package repository;

import domain.DomainObject;
import java.sql.*;
import java.util.List;

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

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                domainObject.bindSelectParams(ps);

                System.out.println("QUERY: " + ps.toString());

                try (ResultSet rs = ps.executeQuery()) {
                    DomainObject domainObject2 = domainObject.mapOne(rs);
                    System.out.println("DBB: Uspesno ucitan objekat iz baze");

                    return domainObject2;
                }
            }

        } catch (SQLException ex) {
            System.out.println("DBB: Greska prilikom ucitavanja objekta iz baze.");
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<DomainObject> getAll(DomainObject domainObject) throws SQLException {
        try {
            String query = "SELECT " + domainObject.selectColumns()
                    + " FROM " + domainObject.tableName();

            System.out.println("QUERY: " + query);

            try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
                List<DomainObject> list = domainObject.mapMany(rs);
                System.out.println("DBB: Uspesno ucitani objekti iz baze");
                return list;
            }
        } catch (SQLException ex) {
            System.out.println("DBB: Greska prilikom ucitavanja objekata iz baze.");
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean add(DomainObject domainObject) throws SQLException {
        try {
            String query = "INSERT INTO " + domainObject.tableName()
                    + " (" + domainObject.insertColumns() + ") VALUES (" + domainObject.insertValuesClause() + ")";

            try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                domainObject.bindInsertParams(ps);
                System.out.println("QUERY: " + ps.toString());

                int result = ps.executeUpdate();

                if (result > 0 && domainObject.hasAutoIncrementPrimaryKey()) {
                    try (ResultSet rsID = ps.getGeneratedKeys()) {
                        if (rsID.next()) {
                            domainObject.setGeneratedPrimaryKey(rsID.getLong(1));
                        }
                    }
                }

                return result > 0;
            }
        } catch (SQLException ex) {
            System.out.println("DBB: Greska prilikom dodavanja objekta u bazu.");
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean update(DomainObject domainObject) throws SQLException {
        try {
            String query = "UPDATE " + domainObject.tableName()
                    + " SET " + domainObject.updateSetClause()
                    + " WHERE " + domainObject.updateWhereClause();

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                domainObject.bindUpdateParams(ps);
                System.out.println("QUERY: " + ps.toString());
                int result = ps.executeUpdate();
                return result > 0;
            }
        } catch (SQLException ex) {
            System.out.println("DBB: Greska prilikom azuriranja objekta u bazi.");
            ex.printStackTrace();
            throw ex;
        }
    }

    public void delete(DomainObject domainObject) throws SQLException, Exception {
        try {
            String query = "DELETE FROM " + domainObject.tableName()
                    + " WHERE " + domainObject.deleteWhereClause();

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                domainObject.bindDeleteParams(ps);
                System.out.println("QUERY: " + ps.toString());
                ps.executeUpdate();
                System.out.println("DBB: Objekat uspesno izbrisan iz baze");
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("DBB: Ne mozete obrisati objekat jer se koristi u drugoj tabeli.");
            ex.printStackTrace();
            throw new Exception("Ne mozete da obrisete objekat jer se koristi u drugoj tabeli!");
        } catch (SQLException ex) {
            System.out.println("DBB: Greska prilikom brisanja objekta iz baze.");
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<DomainObject> search(DomainObject domainObject) throws SQLException {
        try {
            String whereClause = domainObject.searchWhereClause();
            String query = "SELECT " + domainObject.selectColumns()
                    + " FROM " + domainObject.tableName();

            boolean hasWhere = whereClause != null && !whereClause.isBlank();
            if (hasWhere) {
                query += " WHERE " + whereClause;
            }

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                if (hasWhere) {
                    domainObject.bindSearchParams(ps);
                }

                System.out.println("QUERY: " + ps.toString());

                try (ResultSet rs = ps.executeQuery()) {
                    List<DomainObject> list = domainObject.mapMany(rs);
                    System.out.println("DBB: Uspesno ucitani objekti iz baze");
                    return list;
                }
            }
        } catch (SQLException ex) {
            System.out.println("DBB: Greska prilikom pretrage objekata u bazi.");
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<DomainObject> getAllJoinTables(DomainObject domainObject) throws SQLException {
        try {
            String query = "SELECT " + domainObject.selectJoinColumns()
                    + " FROM " + domainObject.joinFromClause();

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                System.out.println("QUERY: " + ps.toString());
                try (ResultSet rs = ps.executeQuery()) {
                    List<DomainObject> list = domainObject.mapJoined(rs);
                    System.out.println("DBB: Uspesno ucitani JOIN objekti iz baze");
                    return list;
                }
            }
        } catch (SQLException ex) {
            System.out.println("DBB: Greska prilikom ucitavanja JOIN objekata iz baze.");
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<DomainObject> getAllJoinTablesWhere(DomainObject domainObject) throws SQLException {
        try {
            String whereClause = domainObject.joinWhereClause();
            String query = "SELECT " + domainObject.selectJoinColumns()
                    + " FROM " + domainObject.joinFromClause();

            boolean hasWhere = whereClause != null && !whereClause.isBlank();
            if (hasWhere) {
                query += " WHERE " + whereClause;
            }

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                if (hasWhere) {
                    domainObject.bindJoinParams(ps);
                }

                System.out.println("QUERY: " + ps.toString());

                try (ResultSet rs = ps.executeQuery()) {
                    List<DomainObject> list = domainObject.mapJoined(rs);
                    System.out.println("DBB: Uspesno ucitani JOIN objekti iz baze");
                    return list;
                }
            }
        } catch (SQLException ex) {
            System.out.println("DBB: Greska prilikom ucitavanja JOIN objekata iz baze.");
            ex.printStackTrace();
            throw ex;
        }
    }

}
