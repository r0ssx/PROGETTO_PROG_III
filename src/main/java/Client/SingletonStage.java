package Client;

import Client.Controllers.Controller;
import Client.Controllers.HomeController;

import java.io.IOException;

/**
 * Singleton che gestisce la scena principale dell'applicazione JavaFX.
 * Fornisce metodi per ottenere e modificare lo stage principale
 * e per cambiare rapidamente scena tramite {@link StageFacade}.
 */
public class SingletonStage {
    /**
     * Istanza unica del singleton.
     */
    private static SingletonStage instance;

    /**
     * Facade dello stage principale.
     */
    private static StageFacade stageFacade;

    /**
     * Costruttore privato.
     * Inizializza la scena principale con "Home.fxml" e {@link HomeController}.
     * @throws IOException se il caricamento della scena fallisce
     */
    private SingletonStage() throws IOException {
        stageFacade = new StageFacade("Home.fxml", "Home", new HomeController());
    }

    /**
     * Restituisce l'istanza unica del singleton.
     * @return istanza di {@link SingletonStage}
     * @throws IOException se il caricamento iniziale della scena fallisce
     */
    public static SingletonStage getInstance() throws IOException {
        if (instance == null)
            instance = new SingletonStage();
        return instance;
    }

    /**
     * Restituisce il {@link StageFacade} associato allo stage principale.
     * @return stageFacade principale
     */
    public static StageFacade getStageFacade() {
        return stageFacade;
    }

    /**
     * Cambia rapidamente la scena corrente dello stage principale.
     * @param fxmlName nome del file FXML della nuova scena
     * @param windowName titolo della finestra
     * @param controller controller associato alla nuova scena
     * @throws IOException se il caricamento della scena fallisce
     */
    public static void fastChangeScene(String fxmlName, String windowName, Controller controller) throws IOException {
        stageFacade.changeScene(fxmlName, windowName, controller);
    }
}
