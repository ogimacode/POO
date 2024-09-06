module org.example.exercicio9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.exercicio9 to javafx.fxml;
    exports org.example.exercicio9;
}