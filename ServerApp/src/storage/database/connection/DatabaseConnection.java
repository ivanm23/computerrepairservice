/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Ivan
 */
public class DatabaseConnection {
    private final Connection connection;
    private static DatabaseConnection instance;

    public DatabaseConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/servis_racunara";
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance==null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void commit() throws SQLException{
        connection.commit();
    }
    public void rollback() throws SQLException{
        connection.rollback();
    }
    
}
