package org.example;

import java.sql.*;
import java.util.Objects;
import java.util.Optional;

import static java.util.FormatProcessor.FMT;

public class Product {
    private final String sku;
    private String name;
    private int quantity;
    private double price;


    public Product(String sku, String name, int quantity, double price) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;

    }

    public static void save(Product product){
        String sql = "INSERT INTO products(code, name, price, quantity) VALUES(?,?,?,?)";
        try(final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getSku());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getQuantity());
            statement.setDouble(4, product.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;
    }

    public static Optional<Product> findOne(String sku){
        String sql = "SELECT * FROM products WHERE code = ?";
        try(final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            final PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, sku);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) return Optional.of(new Product(rs.getString("code"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public static void update(Product product){
        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE code = ?";
        try(final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            final PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getSku());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(String sku){
        String sql = "DELETE FROM products WHERE code = ?";
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            final PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, sku);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double getTotal() {
        return quantity * price;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
    @Override
    public String toString() {
        //FMT is the formatter processor for String templates (it works just like a String.formatter())
        return FMT."| Product | \{sku} | %-15s\{name} | %8.2f\{price} | %4d\{quantity} | %10.2f\{getTotal()} |";
    }

}
