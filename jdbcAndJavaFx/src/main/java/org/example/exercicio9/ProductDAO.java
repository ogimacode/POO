package org.example.exercicio9;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    void adicionarNoBanco(ProductDTO newProduct);
    void removerNoBanco(String sku);
    void updateNoBanco(ProductDTO productDTO);
    Optional<ProductDTO> acharNoBanco(String sku);
    List<ProductDTO> listarNoBanco();

    void sale(Sale sale) throws SQLException;

    static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getSku(), product.getName(), product.getPrice(), product.getQuantity());
    }
    static Product toProduct(ProductDTO dto){
        return new Product(dto.code(), dto.name(), dto.price(), dto.quantity());
    }
}
