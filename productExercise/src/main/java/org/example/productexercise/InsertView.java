package org.example.productexercise;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InsertView{
    public void showInsertView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            final Pane pane = loader.load(getClass().getResource("insert-view").openStream());

            final InsertViewController controller = loader.getController();
            Scene scene = new Scene(pane, 250, 200);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
