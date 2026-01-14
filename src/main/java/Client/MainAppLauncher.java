package Client;

import Client.Utilities.SingletonServerFacade;
import Client.Utilities.SingletonSession;
import javafx.application.Application;

/**
 * Classe di avvio dell'applicazione.
 * Configura e connette il {@link SingletonServerFacade} al server
 * e avvia l'applicazione JavaFX tramite {@link MainApp}.
 */
public class MainAppLauncher {

    /**
     * Punto di ingresso principale dell'applicazione.
     * Configura la connessione al server sulla macchina locale
     * e sulla porta 9000, quindi avvia l'applicazione JavaFX.
     * In caso di errore viene stampato lo stack trace.
     * @param args argomenti passati da linea di comando
     */
    public static void main(String[] args) {
        try {
            SingletonServerFacade server = SingletonServerFacade.getInstance();
            SingletonSession session = SingletonSession.getInstance();
            server.config("localhost", 9000);
            server.connect();
            Application.launch(MainApp.class, args);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
}