package org.example.model;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.example.model.DataBaseBuilder.createTables;
import static org.example.model.Product.*;
import static org.example.model.SQLiteProductDAO.toDto;
import static org.example.model.SQLiteProductDAO.fromDto;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public void main(String[] args) throws SQLException {
        createTables();
    }

}