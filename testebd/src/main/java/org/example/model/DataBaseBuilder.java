package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseBuilder {
    public static void createTables() throws SQLException {
        String sql = """
                CREATE TABLE `products` (
                 `code` TEXT NOT NULL,
                 `name` TEXT,
                 `price` REAL,
                 `quantity` INTEGER,
                 PRIMARY KEY(`code`)
                );
                """;
    }
}
