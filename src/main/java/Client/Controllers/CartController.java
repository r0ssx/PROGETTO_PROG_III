package Client.Controllers;

import Client.Adapters.ProductListToCartPacketAdapter;
import Client.MainApp;
import Client.RequestCommand.CheckoutRequestCommand;
import Client.Utilities.CartSingleton;
import Client.Utilities.ProductCell;
import Client.Utilities.ProductInCartCell;
import Client.Utilities.SingletonSession;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.GsonAdapters.CartPacket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller JavaFX per la schermata del carrello.
 *
 * Si occupa dell'inizializzazione della lista dei prodotti nel carrello
 * e della gestione delle azioni di pagamento e navigazione.
 */
public class CartController implements Initializable {
    /**
     * ListView che visualizza i prodotti presenti nel carrello.
     */
    @FXML
    public ListView<ProductQueryResult> listView;

    /**
     * Inizializza il controller.
     *
     * Imposta il cell factory per la visualizzazione dei prodotti nel carrello
     * e popola la lista con i prodotti presenti nel {@code CartSingleton}.
     *
     * @param url posizione utilizzata per risolvere i percorsi relativi, può essere null
     * @param resourceBundle risorse utilizzate per localizzazione, può essere null
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setCellFactory(listView -> new ProductInCartCell());
        List<ProductQueryResult> cart = CartSingleton.getCart();

        System.out.println("Carrello:");
        System.out.println(cart);
        listView.getItems().addAll(cart);
    }

    /**
     * Gestisce il pagamento in contanti.
     *
     * Invia la richiesta di checkout al server specificando il metodo di pagamento
     * come contanti, svuota il carrello e reindirizza l'utente alla home.
     *
     * @throws IOException se il file FXML non può essere caricato
     * @throws SQLException se si verifica un errore durante la richiesta di checkout
     */
    @FXML
    public void cashPaymentClick() throws IOException, SQLException {
        System.out.println("cashPaymentClick");

        // "esegui il pagamento" (insert come "contanti")
        CheckoutRequestCommand checkoutRequestCommand = new CheckoutRequestCommand();
        CartPacket cartPacket = ProductListToCartPacketAdapter.convert(CartSingleton.getCart());
        cartPacket.email = SingletonSession.getInstance().getSessionUser();
        cartPacket.metodo_pagamento = "Contanti";

        String orderId = checkoutRequestCommand.makeRequest(cartPacket);
        System.out.println("Order id:" + orderId);

        // Svuota il carrello e torna alla home
        CartSingleton.flushCart();

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Shopping");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) listView.getScene().getWindow();
        thisStage.close();
    }

    /**
     * Gestisce il pagamento con carta o bancomat.
     *
     * Apre la schermata di pagamento dedicata e chiude
     * lo stage corrente del carrello.
     *
     * @throws IOException se il file FXML non può essere caricato
     */
    @FXML
    public void cardPaymentClick() throws IOException {
        // passa al pagamento con carta o bancomat
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Payment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 440);
        Stage stage = new Stage();
        stage.setTitle("Payment");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) listView.getScene().getWindow();
        thisStage.close();

    }

    /**
     * Gestisce il ritorno alla schermata home utente.
     *
     * Apre la schermata principale dello shopping e chiude
     * lo stage corrente del carrello.
     *
     * @throws IOException se il file FXML non può essere caricato
     */
    @FXML
    public void backClick() throws IOException {
        // Torna al carrello
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Shopping");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) listView.getScene().getWindow();
        thisStage.close();
    }
}