package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("Home.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }
}


