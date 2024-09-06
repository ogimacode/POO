module org.example.productexercise {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.productexercise to javafx.fxml;
    exports org.example.productexercise;
}