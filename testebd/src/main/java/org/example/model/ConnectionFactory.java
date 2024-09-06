package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection; // A single connection is created for the whole application
    private ConnectionFactory(){}
    public static Connection getConnection() throws SQLException {
        if(connection == null) connection = DriverManager.getConnection("jdbc:sqlite:database.db"); // Complex config goes here …
        return connection;
    }
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}
