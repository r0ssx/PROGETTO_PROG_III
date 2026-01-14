package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principale dell'applicazione JavaFX.
 * Estende {@link javafx.application.Application} e avvia
 * l'applicazione mostrando la finestra principale
 */
public class MainApp extends Application {

    /**
     * Punto di ingresso dell'applicazione JavaFX.
     * Mostra la finestra principale dell'applicazione
     * @param stage stage primario fornito da JavaFX
     * @throws Exception se si verifica un errore durante l'inizializzazione della GUI
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}


