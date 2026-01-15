package Client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Client.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller JavaFX per la schermata principale dell'area amministratore.
 *
 * Gestisce le azioni dell'utente sui pulsanti della home admin e apre
 * le relative finestre (vendite, raccomandazioni, inserimento e modifica prodotti).
 */
public class AdminHomeController {

    /**
     * Etichetta mostrata nella schermata principale.
     */
    @FXML
    private Label welcomeText;

    /**
     * Gestisce il click sul pulsante delle vendite per categoria.
     *
     * Apre una nuova finestra che mostra la schermata del numero totale di
     * vendite per categoria.
     *
     * @throws IOException se il file FXML non può essere caricato
     */
    @FXML
    protected void salesClick() throws IOException {
        System.out.println("salesClick");

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Sales.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 440);
        Stage stage = new Stage();
        stage.setTitle("Top Sales");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Gestisce il click sul pulsante di raccomandazione.
     *
     * Apre una nuova finestra per la gestione delle raccomandazioni
     * senza chiudere lo stage corrente.
     *
     * @throws IOException se il file FXML non può essere caricato
     */
    @FXML
    protected void recommendClick() throws IOException {
        System.out.println("recommendClick");

        // Apre recommend senza chiudere questo stage
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Recommend.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Recommend");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Gestisce il click sul pulsante di inserimento prodotto.
     *
     * Apre una nuova finestra per l'inserimento di un prodotto
     * senza chiudere lo stage corrente.
     *
     * @throws IOException se il file FXML non può essere caricato
     */
    @FXML
    public void insertClick() throws IOException {
        System.out.println("insertClick");

        // Apre insert product senza chiudere questo stage
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("InsertProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 640);
        Stage stage = new Stage();
        stage.setTitle("Insert Product");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Gestisce il click sul pulsante di modifica prodotto.
     *
     * Apre una nuova finestra per la modifica di un prodotto
     * senza chiudere lo stage corrente.
     *
     * @throws IOException se il file FXML non può essere caricato
     */
    @FXML
    public void modifyClick() throws IOException {
        System.out.println("modifyClick");

        // Apre insert product senza chiudere questo stage
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("ModifyProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 640);
        Stage stage = new Stage();
        stage.setTitle("Modify Product");
        stage.setScene(scene);
        stage.show();
    }
}

