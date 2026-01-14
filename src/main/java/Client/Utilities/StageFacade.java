package Client.Utilities;

import Client.Controller;
import Client.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Facade per la gestione degli {@link Stage} di JavaFX.
 * Fornisce metodi per creare, mostrare e cambiare scena di uno stage
 * in modo semplificato, gestendo automaticamente il caricamento dei FXML
 * e l'associazione dei controller.
 */
public class StageFacade {

    /**
     * Stage principale gestito dalla facade.
     */
    protected final Stage STAGE;

    /**
     * Loader FXML utilizzato per caricare le scene.
     */
    protected final FXMLLoader LOADER;

    /**
     * Costruisce uno stage senza controller specifico.
     *
     * @param fxmlName  nome del file FXML (senza .fxml) della GUI
     * @param windowName titolo della finestra
     * @throws IOException se il file FXML non viene trovato
     */
    public StageFacade(String fxmlName, String windowName) throws IOException {
        System.out.println("Trying to load fxml: " + fxmlName);

        LOADER = new FXMLLoader(getClass().getResource(fxmlName));

        STAGE = new Stage();

        STAGE.setTitle(windowName);
        STAGE.setScene(new Scene(LOADER.load()));
    }

    /**
     * Costruisce uno stage e assegna un controller per gestire la GUI.
     * @param fxmlName  nome del file FXML (senza .fxml) della GUI
     * @param windowName titolo della finestra
     * @param controller controller associato allo stage
     * @throws IOException se il file FXML non viene trovato
     */
    public StageFacade(String fxmlName, String windowName, Controller controller) throws IOException {
        System.out.println("Trying to load fxml: " + fxmlName);

        LOADER = new FXMLLoader(MainApp.class.getResource(fxmlName));

        setController(controller);
        Parent root = LOADER.load();

        STAGE = new Stage();

        STAGE.setTitle(windowName);
        STAGE.setScene(new Scene(root));
    }

    /**
     * Mostra lo stage sullo schermo.
     */
    public void show() {
        STAGE.show();
    }

    /**
     * Assegna un controller allo stage a runtime.
     * @param controller controller da associare allo stage
     */
    public void setController(Controller controller) {
        LOADER.setController(controller);
    }

    /**
     * Chiude lo stage corrente utilizzando un riferimento a un pulsante presente nella GUI.
     *
     * @param button pulsante della scena corrente, utile per ottenere lo stage da chiudere
     */
    public static void closeStageFromBtn(Button button) {
        ((Stage) button.getScene().getWindow()).close();
    }
}
