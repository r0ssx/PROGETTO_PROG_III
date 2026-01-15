package Client.Controllers;

import Client.Adapters.ProductListToCartPacketAdapter;
import Client.MainApp;
import Client.RequestCommand.CheckoutRequestCommand;
import Client.Utilities.CartSingleton;
import Client.Utilities.SingletonSession;
import Shared.GsonAdapters.CartPacket;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller JavaFX per la schermata di pagamento.
 *
 * Gestisce le azioni di pagamento tramite bancomat o carta di credito
 * e la navigazione di ritorno al carrello.
 */
public class PaymentController {
    public Label welcomeText;

    /**
     * Gestisce il click sul pulsante di ritorno al carrello.
     *
     * Apre la schermata del carrello e chiude lo stage corrente.
     *
     * @throws IOException se il file FXML non può essere caricato
     */
    public void backClick() throws IOException {
        // torna al carrello
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Cart.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Cart");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) welcomeText.getScene().getWindow();
        thisStage.close();
    }

    /**
     * Gestisce il pagamento tramite bancomat.
     *
     * Invia la richiesta di checkout al server specificando il metodo di pagamento,
     * svuota il carrello e apre la schermata home utente.
     *
     * @throws IOException se il file FXML non può essere caricato
     * @throws SQLException se si verifica un errore durante la richiesta di checkout
     */
    public void bancomatClick() throws IOException, SQLException {
        // "esegui il pagamento" (insert come "bancomat")
        CheckoutRequestCommand checkoutRequestCommand = new CheckoutRequestCommand();
        CartPacket cartPacket = ProductListToCartPacketAdapter.convert(CartSingleton.getCart());
        cartPacket.email = SingletonSession.getInstance().getSessionUser();
        cartPacket.metodo_pagamento = "Bancomat";

        String orderId = checkoutRequestCommand.makeRequest(cartPacket);
        System.out.println("Order id:" + orderId);

        // svuota il carrello e torna alla home
        CartSingleton.flushCart();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Cart");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) welcomeText.getScene().getWindow();
        thisStage.close();
    }

    /**
     * Gestisce il pagamento tramite carta di credito.
     *
     * Invia la richiesta di checkout al server specificando il metodo di pagamento,
     * svuota il carrello e apre la schermata home utente.
     *
     * @throws IOException se il file FXML non può essere caricato
     * @throws SQLException se si verifica un errore durante la richiesta di checkout
     */
    public void creditCardClick() throws IOException, SQLException {
        // "esegui il pagamento" (insert come "bancomat")
        CheckoutRequestCommand checkoutRequestCommand = new CheckoutRequestCommand();
        CartPacket cartPacket = ProductListToCartPacketAdapter.convert(CartSingleton.getCart());
        cartPacket.email = SingletonSession.getInstance().getSessionUser();
        cartPacket.metodo_pagamento = "Carta";

        String orderId = checkoutRequestCommand.makeRequest(cartPacket);
        System.out.println("Order id:" + orderId);

        // svuota il carrello e torna alla home
        CartSingleton.flushCart();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("UserHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Cart");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) welcomeText.getScene().getWindow();
        thisStage.close();
    }
}
