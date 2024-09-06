package org.example.exercicio9;

import java.util.Objects;

import static java.util.FormatProcessor.FMT;

public class Sale {
    private long id;
    private String seller;
    private int quantity;
    private Product product;

    public Sale(String seller, int quantity, Product product) {
        this.id = id;
        this.seller = seller;
        this.quantity = quantity;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public String getSeller() {
        return seller;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id == sale.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return FMT."| Sale | %7d\{id} | %-15s\{seller} | \{product.getName()} | %4d\{quantity} |";
    }
}
