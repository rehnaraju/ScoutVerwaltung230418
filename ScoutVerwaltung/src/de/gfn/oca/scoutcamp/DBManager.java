package de.gfn.oca.scoutcamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tlubowiecki
 */
public class DBManager {
    
    static private DBManager instance;
    
    private static final String HOST = "jdbc:mysql://localhost";
    // Standardport MySQL 3306
    private static final int PORT = 8889;
    private static final String DB_NAME = "scoutbase2018";
    private static final String USER = "root";
    // XAMPP DB Passwort für root ist leer
    private static final String PASSWORD = "root";

    private DBManager() {
    }

    public static DBManager getInstance() {
        if(instance == null) {
            instance = new DBManager();
        }
        return instance;
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(HOST + ":" + PORT + "/" + DB_NAME, USER, PASSWORD);
    }
}
