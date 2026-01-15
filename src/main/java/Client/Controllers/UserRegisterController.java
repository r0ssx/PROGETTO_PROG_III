package Client.Controllers;

import Client.MainApp;
import Client.RequestCommand.UserRegisterRequestCommand;
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
 * Controller JavaFX per la schermata di registrazione utente.
 *
 * Gestisce la creazione di un nuovo account utente, la validazione dei campi,
 * l'invio della richiesta di registrazione al server e la navigazione verso la home utente.
 */
public class UserRegisterController {
    @FXML
    public Label errorText;

    @FXML
    public TextField emailField;

    @FXML
    protected PasswordField passwordField;

    /**
     * Gestisce il click sul pulsante di submit per la registrazione utente.
     *
     * Recupera le credenziali inserite, valida i campi,
     * invia la richiesta di registrazione al server e,
     * in caso di successo, inizializza la sessione e apre
     * la schermata home dell'utente.
     *
     * @throws IOException se il file FXML non può essere caricato
     * @throws SQLException se si verifica un errore durante la richiesta al server
     */
    @FXML
    protected void submitClick() throws IOException, SQLException {
        System.out.println("submitClick");

        String email = emailField.getText();
        String password = passwordField.getText();

        System.out.println("Email: " + email + " Password: " + password);

        if (email.isEmpty() || password.isEmpty()) {
            errorText.setText("Email or password cannot be empty!");
            return;
        }

        // USER REGISTER SERVER OPERATION

        UserRegisterRequestCommand userRegisterRequestCommand = new UserRegisterRequestCommand();
        Boolean result = userRegisterRequestCommand.makeRequest(new AuthPacket(email, password));

        // se result false allora utente esiste
        if (!result) {
            errorText.setText("User already exists.");
            return;
        }

        // imposta la sessione
        SingletonSession.getInstance().setSessionUser(email);

        // Passa a User Home
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Shopping");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) emailField.getScene().getWindow();
        thisStage.close();
    }

    /**
     * Gestisce il click sul pulsante di ritorno.
     *
     * Apre la schermata home principale e chiude lo stage corrente.
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

        Stage thisStage = (Stage) emailField.getScene().getWindow();
        thisStage.close();
    }
}