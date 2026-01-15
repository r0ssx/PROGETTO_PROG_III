package Client.Controllers;

import Client.MainApp;
import Client.RequestCommand.AdminLoginRequestCommand;
import Client.RequestCommand.UserLoginRequestCommand;
import Client.Utilities.SingletonSession;
import Shared.GsonAdapters.AuthPacket;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller JavaFX per la schermata di login dell'amministratore.
 *
 * Gestisce l'autenticazione admin, la validazione dei campi di input,
 * l'invio della richiesta di login al server e la transizione
 * verso la schermata principale dell'area amministratore.
 */
public class AdminLoginController {
    /**
     * Etichetta utilizzata per mostrare messaggi di errore all'utente.
     */
    @FXML
    public Label errorText;

    /**
     * Campo di input per l'inserimento dello username.
     */
    @FXML
    public TextField usernameField;

    /**
     * Campo di input per l'inserimento della password.
     */
    @FXML
    protected PasswordField passwordField;

    /**
     * Gestisce il click sul pulsante di submit del login admin.
     *
     * Recupera le credenziali inserite, valida i campi,
     * invia la richiesta di autenticazione al server e,
     * in caso di successo, inizializza la sessione e apre
     * la schermata di home admin.
     *
     * @throws IOException se il file FXML non può essere caricato
     * @throws SQLException se si verifica un errore durante la richiesta al server
     */
    @FXML
    protected void submitClick() throws IOException, SQLException {
        System.out.println("submitClick");

        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("Username: " + username + " Password: " + password);

        if (username.isEmpty() || password.isEmpty()) {
            errorText.setText("Username or password cannot be empty!");
            return;
        }

        // USER REGISTER SERVER OPERATION

        AdminLoginRequestCommand userRegisterRequestCommand = new AdminLoginRequestCommand();
        Boolean result = userRegisterRequestCommand.makeRequest(new AuthPacket(username, password));

        // se result false allora password o nome utente sbagliati
        if (!result) {
            errorText.setText("Password or username are wrong.");
            return;
        }

        // imposta la sessione
        SingletonSession.getInstance().setSessionUser(username);

        // Passa ad admin home
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("AdminHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Admin Home");
        stage.setScene(scene);
        stage.show();

        // chiude lo stage corrente
        Stage thisStage = (Stage) usernameField.getScene().getWindow();
        thisStage.close();
    }

    /**
     * Gestisce il click sul pulsante di ritorno alla schermata home.
     *
     * Apre la schermata principale dell'applicazione e chiude
     * lo stage corrente.
     *
     * @throws IOException se il file FXML non può essere caricato
     */
    @FXML
    protected void backClick() throws IOException {
        System.out.println("backClick");

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) usernameField.getScene().getWindow();
        thisStage.close();
    }
}
