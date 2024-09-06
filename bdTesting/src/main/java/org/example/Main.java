package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Product.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product product = new Product("SCL0001", "Computer", 2, 4_532.99);
        save(product);
        findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not Found"));
        product = new Product("SCL0001", "Notebook", 3, 5_352.89);
        update(product);
        findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
        delete("SCL0001");
        findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));

    }
}