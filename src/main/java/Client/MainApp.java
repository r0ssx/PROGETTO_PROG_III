package Client;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Classe principale dell'applicazione JavaFX.
 * Estende {@link javafx.application.Application} e avvia
 * l'applicazione mostrando la finestra principale tramite
 * {@link SingletonStage}.
 */
public class MainApp extends Application {

    /**
     * Punto di ingresso dell'applicazione JavaFX.
     * Mostra la finestra principale dell'applicazione
     * utilizzando la classe {@link SingletonStage}.
     * @param stage stage primario fornito da JavaFX
     * @throws Exception se si verifica un errore durante l'inizializzazione della GUI
     */
    @Override
    public void start(Stage stage) throws Exception {
        SingletonStage.getInstance().getStageFacade().show();
    }
}


