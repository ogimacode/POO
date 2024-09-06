    package org.example.exercicio9;

    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.scene.layout.Pane;
    import javafx.stage.Stage;

    import java.util.Objects;

    public class TableLoader extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            Pane layout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("table-products.fxml")));
            Scene scene = new Scene(layout, 600, 500);
            stage.setTitle("Products Management");
            stage.setScene(scene);
            stage.show();
        }
    }
