package org.example.exercicio9;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLiteProductDAO  implements ProductDAO{
    @Override
    public void adicionarNoBanco(ProductDTO dto) {
        String sql = "INSERT INTO products (code, name, price, quantity) VALUES (?, ?, ?, ?)";

        try (var statement = ConnectionFactory.getPreparedStatement(sql) ){
            statement.setString(1, dto.code());
            statement.setString(2, dto.name());
            statement.setDouble(3, dto.price());
            statement.setInt(4, dto.quantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerNoBanco(String sku) {
        String sql = "DELETE FROM products WHERE code = ?";

        try(var statement = ConnectionFactory.getPreparedStatement(sql)){
            statement.setString(1, sku);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateNoBanco(ProductDTO dto) {
        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE code = ?";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)){
            statement.setString(1, dto.name());
            statement.setDouble(2, dto.price());
            statement.setInt(3, dto.quantity());
            statement.setString(4, dto.code());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ProductDTO> acharNoBanco(String sku) {
        String sql = "SELECT * FROM products WHERE code = ?";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)){
            statement.setString(1, sku);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return Optional.of(new ProductDTO(rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<ProductDTO> listarNoBanco() {
        String sql = "SELECT * FROM products";
        List<ProductDTO> productDTOList = new ArrayList<>();
        try(var statement = ConnectionFactory.getPreparedStatement(sql)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                productDTOList.add(new ProductDTO(rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDTOList;
    }
    @Override
    public void sale(Sale sale) throws SQLException {
        final Product product = sale.getProduct();
        final int updatedQuantity = product.getQuantity() - sale.getQuantity();
        product.setQuantity(updatedQuantity);

        String saleSql = "INSERT INTO sales (quantity, seller, product) VALUES (?, ?, ?)";
        String productSql = "UPDATE products SET quantity = ? WHERE code = ?";

        try(var statementSale = ConnectionFactory.getPreparedStatement(saleSql);
            var statementProduct = ConnectionFactory.getPreparedStatement(productSql)){
            ConnectionFactory.getConnection().setAutoCommit(false);

            statementProduct.setInt(1, product.getQuantity());
            statementProduct.setString(2, product.getSku());
            statementProduct.executeUpdate();

            statementSale.setInt(1, sale.getQuantity());
            statementSale.setString(2, sale.getSeller());
            statementSale.setString(3, product.getSku());
            statementSale.executeUpdate();
            ConnectionFactory.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            ConnectionFactory.getConnection().commit();
        }
    }
}
