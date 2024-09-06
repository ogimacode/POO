package org.example.model;

import java.math.BigDecimal;
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
