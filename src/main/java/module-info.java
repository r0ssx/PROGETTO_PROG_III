module com.example.progetto_prog_iii {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;


    opens Client to javafx.fxml;
    opens Server.QueryCommand.QueryResultObject to com.google.gson;
    opens Shared.Requests to com.google.gson;
    opens Shared.GsonAdapters to com.google.gson;
    opens Server.QueryCommand to com.google.gson;
}