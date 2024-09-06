//package org.example;
//
//import java.sql.DriverManager;
//
//import static java.util.FormatProcessor.FMT;
//
//public class Sale {
//    private long id;
//    private String seller;
//    private int quantity;
//    private Product product;
//
//    public Sale(String seller, int quantity, Product product) {
//        this.seller = seller;
//        this.quantity = quantity;
//        this.product = product;
//    }
//
//    public static void sale(Sale sale) {
//        final Product product = sale.getProduct();
//        final int updatedQuantity = product.getQuantity() - sale.getQuantity();
//        product.setQuantity(updatedQuantity);
//        String saleSql = "INSERT INTO sales (quantity, seller, product) VALUES (?, ?, ?)";
//        String productSql = "UPDATE products SET quantity = ? WHERE code = ?";
//        try (var connection = DriverManager.getConnection("jdbc:sqlite:database.db");
//             var saleStatement = connection.prepareStatement(saleSql);
//             var productStatement = connection.prepareStatement(productSql)) {
//            productStatement.setInt(1, product.getQuantity());
//            productStatement.setString(2, product.getSku());
//            productStatement.executeUpdate();
//            saleStatement.setInt(1, sale.getQuantity());
//            saleStatement.setString(2, sale.getSeller());
//            saleStatement.setString(3, product.getSku());
//            saleStatement.executeUpdate(); // <= Something unforeseen can happen here
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getSeller() {
//        return seller;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    @Override
//    public String toString() {
//        //FMT is the formatter processor for String templates
//        return FMT."| Sale | %7d\{id} | %-15s\{seller} | \{product.getName()} | %4d\{quantity} |";
//    }
//}
