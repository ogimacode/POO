package org.example.exercicio9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ProductController {

    private TableController tableController;
    private Stage stage;

    private Product product;
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtSku;

    @FXML
    private Button closeButton;

    @FXML
    private Button saveButton;
    @FXML
    private Button updateButton;

    @FXML private void initialize(){}

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setProduct(Product product) {
        this.product = product;
        if (product != null) {
            txtSku.setText(product.getSku());
            txtName.setText(product.getName());
            txtPrice.setText(String.valueOf(product.getPrice()));
            txtQuantity.setText(String.valueOf(product.getQuantity()));
        }
    }
    public void setFunction(String function){
            if(function.equals("detail")){
                txtSku.setDisable(true);
                txtName.setDisable(true);
                txtQuantity.setDisable(true);
                txtPrice.setDisable(true);

                saveButton.setVisible(false);
                updateButton.setVisible(false);
            } else if (function.equals("update")) {
                txtSku.setDisable(true);

                saveButton.setVisible(false);
            } else {
                updateButton.setVisible(false);
            }
    }

    public void setTableController(TableController tableController) {
        this.tableController = tableController;
    }

    @FXML
    void saveChanges(ActionEvent event) throws SQLException {
        Product newProduct = new Product(txtSku.getText(),
                txtName.getText(),
                Double.parseDouble(txtPrice.getText()),
                Integer.parseInt(txtQuantity.getText())
        );
        tableController.addProduct(newProduct);
    }
    @FXML
    void updateChanges(ActionEvent event) throws SQLException {
        product.setName(txtName.getText());
        product.setPrice(Double.parseDouble(txtPrice.getText()));
        product.setQuantity(Integer.parseInt(txtQuantity.getText()));
        tableController.updateProduct(product);
    }

    @FXML
    void closeWindow(ActionEvent event) {
        stage.close();
    }
}
