module com.example.progetto_prog_iii {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;


    opens Client to javafx.fxml;
    opens QueryCommand.QueryResultObject to com.google.gson;
    exports Client;
}