package org.example.exercicio9;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.example.exercicio9.MainBancoBonitinha.*;
import static org.example.exercicio9.ProductDAO.toDTO;


public class TableController {

    private ProductDAO banco = new SQLiteProductDAO();
    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product, String> clSku;

    @FXML
    private TableColumn<Product, Double> clPrice;

    @FXML
    private TableColumn<Product, String> clName;

    @FXML
    private TableColumn<Product, Double> clTotal;

    @FXML
    private TableColumn<Product, Integer> clQuantity;

    @FXML private ObservableList<Product> data;

    @FXML
    public void initialize(){
        bindTableColumnsToProperties();
        bindSourceToTable();
        loadData();
    }

    private void openProductManagerWindow(Product product, String mode){
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("product-manager.fxml")));
            Pane pane = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(pane, 400, 500);
            stage.setScene(scene);
            ProductController controller = loader.getController();

            controller.setStage(stage);
            controller.setTableController(this);
            controller.setProduct(product);
            controller.setFunction(mode);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void bindTableColumnsToProperties() {
        clSku.setCellValueFactory(new PropertyValueFactory<>("sku"));
        clName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        clQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        clTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }
    private void bindSourceToTable() {
        data = FXCollections.observableArrayList();
        table.setItems(data);
    }
    private void loadData() {
        data.clear();
        List<Product> products = banco.listarNoBanco().stream().map(ProductDAO::toProduct).toList();
        data.addAll(products);
    }
    @FXML
    void clickInsert(ActionEvent event) {
        openProductManagerWindow(null, "insert");
    }

    @FXML
    void clickUpdate(ActionEvent event) {
        Product updateProduct = table.getSelectionModel().getSelectedItem();
        openProductManagerWindow(updateProduct, "update");
    }

    @FXML
    void clickDelete(ActionEvent event) throws SQLException {
        Product deleteProduct = table.getSelectionModel().getSelectedItem();
        removeProduct(deleteProduct);
    }

    @FXML
    void clickDetail(ActionEvent event) {
        Product detailProduct = table.getSelectionModel().getSelectedItem();
        openProductManagerWindow(detailProduct, "detail");
    }
    public void addProduct(Product newProduct) throws SQLException {
        banco.adicionarNoBanco(toDTO(newProduct));
        loadData();
    }
    public void updateProduct(Product updatedProduct) throws SQLException {
        banco.updateNoBanco(toDTO(updatedProduct));
        loadData();
    }

    public void removeProduct(Product product) throws SQLException {
        banco.removerNoBanco(product.getSku());
        loadData();
    }

}
