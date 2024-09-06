package org.example.productexercise;


import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableController {

    @FXML private TableView<Product> table;

    @FXML private TableColumn<Product, Integer> quantityColumn;

    @FXML private TableColumn<Product, String> nameColumn;

    @FXML private TableColumn<Product, Double> totalColumn;

    @FXML private TableColumn<Product, String> skuColumn;

    @FXML private TableColumn<Product, Double> priceColumn;

    @FXML private ObservableList<Product> data;

    @FXML
    private void initialize(){
        bindColumnsToAttributes();
        bindTableToData();
        loadData();
    }

    private void bindColumnsToAttributes(){
        skuColumn.setCellValueFactory(new PropertyValueFactory<>("sku"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    private void bindTableToData(){
        data = FXCollections.observableArrayList();
        table.setItems(data);
    }

    private void loadData(){
        final List<Product> products = List.of(
                new Product("scl01", "Corote", 2, 3.99),
                new Product("scl02", "Revolver", 1, 500),
                new Product("scl03", "Opala", 1, 50000)
        );
        data.clear();
        data.addAll(products);
    }

    public void showInsertView(ActionEvent actionEvent) {
        InsertView insertView = new InsertView();
        insertView.showInsertView();
    }
}
