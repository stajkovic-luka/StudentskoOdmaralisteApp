package repository;

import java.sql.*;
import java.lang.System.Logger;

// Uspostavljanje konekcije sa bazom
public class DBConnection {
    private Logger logger;
    private Connection connection;
    private static DBConnection instance;

    private DBConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsko_odmaraliste", "root", "");
        System.out.println("Uspesno uspostavljena konekcija sa bazom!");
        
        connection.setAutoCommit(false);
        
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
