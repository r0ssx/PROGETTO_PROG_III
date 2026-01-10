module com.example.progetto_prog_iii {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens Client to javafx.fxml;
    exports Client;
}