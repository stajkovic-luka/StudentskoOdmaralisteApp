package repository;

import java.sql.*;
import java.lang.System.Logger;
import java.util.LinkedList;

// Uspostavljanje konekcije sa bazom
public class DBConnection {

    private Logger logger;
    private Connection connection;
    private static DBConnection instance;
    private final String conUsername = "root";
    private final String conPassword = "";
    private String conUrl = "jdbc:mysql://localhost:3306/studentsko_odmaraliste";
    private LinkedList<Connection> pool = new LinkedList<>();
    private final int MAX_CONNECTIONS = 20; // Velicina pool-a

    private DBConnection() throws SQLException {
        // Inicijalizacija connection pool-a
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            connection = DriverManager.getConnection(conUrl, conUsername, conPassword);
            addToPool(connection);

            connection.setAutoCommit(false);
        }
        System.out.println("Connection pool kreiran.");
    }

    public static synchronized DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public synchronized Connection getConnection() throws SQLException {

        return fetchConnection();
    }

    private synchronized Connection fetchConnection() throws SQLException {
        if (pool.size() == 0) {
            throw new SQLException("Nema slobodnih konekcija.");
        }

        return pool.removeFirst();
    }

    public synchronized void returnToPool(Connection con) throws SQLException {
        if (!pool.contains(con) && !con.isClosed()) {
            pool.add(con);

            System.out.println("Konekcija vracena u pool.");
        } else {
            System.out.println("GRESKA! Konekcija se vec nalazi u pool-u");
        }
    }

    // Metoda za inicijalizaciju iz constructora
    private synchronized void addToPool(Connection connection) {
        pool.add(connection);
        int freeConnections = pool.size();
        System.out.println("------------------------");
        System.out.println("Konekcija dodata u pool.");
        System.out.println("Preostalo: " + freeConnections + "slobodnih konekcija");
    }

}
