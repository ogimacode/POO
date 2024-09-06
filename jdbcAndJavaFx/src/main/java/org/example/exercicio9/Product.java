package org.example.exercicio9;

import java.util.Objects;

public class Product {
    private final String sku;
    private String name;
    private int quantity;
    private double price;

    public Product(String sku, String name, double price, int quantity) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal(){ return quantity * price; }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity && Double.compare(price, product.price) == 0 && Objects.equals(sku, product.sku) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, quantity, price);
    }

    @Override
    public String toString() {
        return String.format("Product: [%s | %s] | Price: %s | Quantity: %s | Total: %s", sku, name, price, quantity, getTotal());
    }
}
