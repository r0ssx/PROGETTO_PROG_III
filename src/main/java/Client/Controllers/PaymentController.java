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

public class PaymentController {
    public Label welcomeText;

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
