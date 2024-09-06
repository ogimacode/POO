package org.example.exercicio9;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.example.exercicio9.ProductDAO.toDTO;

public class MainBancoBonitinha {

    public static void addBanco(Product newProduct) throws SQLException {
        String sql = "INSERT INTO products (code, name, price, quantity) VALUES (?, ?, ?, ?)";

        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:dataAmigos")) {
            try (final PreparedStatement statement = connection.prepareStatement(sql)) {
                connection.setAutoCommit(false);

                statement.setString(1, newProduct.getSku());
                statement.setString(2, newProduct.getName());
                statement.setDouble(3, newProduct.getPrice());
                statement.setInt(4, newProduct.getQuantity());

                statement.executeUpdate();
                connection.commit();

            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
            }
        }
    }
    public static void  deleteBanco(String sku) throws SQLException {
        String sql = "DELETE FROM products WHERE code = ?";

        try(final Connection connection = DriverManager.getConnection("jdbc:sqlite:dataAmigos")){
            try(final PreparedStatement statement = connection.prepareStatement(sql)) {
                connection.setAutoCommit(false);

                statement.setString(1, sku);

                statement.executeUpdate();
                connection.commit();

            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
            }
        }
    }

    public static void updateBanco(Product updateProduct) throws SQLException {
        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE code = ?";

        try(final Connection connection = DriverManager.getConnection("jdbc:sqlite:dataAmigos")){
            try(final PreparedStatement statement = connection.prepareStatement(sql)){
                connection.setAutoCommit(false);

                statement.setString(1, updateProduct.getName());
                statement.setDouble(2, updateProduct.getPrice());
                statement.setInt(3, updateProduct.getQuantity());
                statement.setString(4, updateProduct.getSku());

                statement.executeUpdate();
                connection.commit();

            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
            }
        }
    }

    public static Optional<Product> findOne(String sku){
        String sql = "SELECT * FROM products WHERE code = ?";

        try(final Connection connection = DriverManager.getConnection("jdbc:sqlite:dataAmigos");
            final PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, sku);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return Optional.of(new Product(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static List<Product> findAll(){
        String sql = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();
        try(final Connection connection = DriverManager.getConnection("jdbc:sqlite:dataAmigos");
            final PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                products.add(new Product(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) throws SQLException {
        ProductDAO dao = new SQLiteProductDAO();
        Product product = new Product("SCL0001", "Corote", 5, 500);
        Product product2 = new Product("SCL0002", "Revolver", 4_532.992, 10);
        Product product3 = new Product("SCL0003", "Opala", 30_000, 1);
//        dao.adicionarNoBanco(toDTO(product));
//        dao.adicionarNoBanco(toDTO(product2));
//        dao.adicionarNoBanco(toDTO(product3));
//        dao.listarNoBanco().forEach(System.out::println);
//        dao.adicionarNoBanco(toDTO(product));
//        dao.acharNoBanco("SCL0001").map(ProductDAO::toProduct).ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
//
//        product.setPrice(5_352.89);
//        dao.updateNoBanco(toDTO(product));
//
//        dao.acharNoBanco("SCL0001").map(ProductDAO::toProduct).ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
//        dao.removerNoBanco("SCL0001");
//        dao.acharNoBanco("SCL0001").map(ProductDAO::toProduct).ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));

//        Product productruim = new Product("SCL0001", "Computer", 2, 4532_99);
//        dao.adicionarNoBanco(toDTO(productruim));
//        dao.acharNoBanco("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Product not found!"));
//        Sale computer = new Sale("Claude Shannon", 1, product);
//        dao.sale(computer);
//        dao.acharNoBanco("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Product not found!"));
//

    }
}
