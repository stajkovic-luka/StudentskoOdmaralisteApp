package repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.lang.System.Logger;
import java.util.LinkedList;
import java.util.Properties;

// Uspostavljanje konekcije sa bazom
public class DBConnection {

    private Logger logger;
    private static DBConnection instance;
    private LinkedList<Connection> pool = new LinkedList<>();
    private final int MAX_CONNECTIONS = 20; // Velicina pool-a

    private DBConnection() throws SQLException {
        // Inicijalizacija connection pool-a
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            // Ucitavanje kredencijala za bazu iz properties fajla
            InputStream input = DBConnection.class.getResourceAsStream("/db.properties");
            Properties properties = new Properties();

            try {
                properties.load(input);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(DBConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

            }
            String url = properties.getProperty("database.url");
            String user = properties.getProperty("database.user");
            String password = properties.getProperty("database.password");

            Connection connection = DriverManager.getConnection(url, user, password);
            addToPool(connection);

            // Transakcije
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

    public synchronized Connection fetchConnection() throws SQLException {
        if (pool.size() == 0) {
            throw new SQLException("Nema slobodnih konekcija.");
        }

        Connection connection = pool.removeFirst();
        System.out.println("Uzeta konekcija, ostalo: " + pool.size());
        return connection;

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
