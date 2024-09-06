package org.example.exercicio9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection connection;
    public ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {
        if(connection == null) connection = DriverManager.getConnection("jdbc:sqlite:dataAmigos");
        return connection;
    }
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

}
