package org.example.productexercise;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class TableProductsSceneLoader extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final Pane layout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("table-view.fxml")));
        Scene scene = new Scene(layout, 600, 500);
        stage.setTitle("Products Management");
        stage.setScene(scene);
        stage.show();
    }
}
