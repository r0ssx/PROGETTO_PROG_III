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

public class CartController implements Initializable {
    @FXML
    public ListView<ProductQueryResult> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setCellFactory(listView -> new ProductInCartCell());
        List<ProductQueryResult> cart = CartSingleton.getCart();

        System.out.println("Carrello:");
        System.out.println(cart);
        listView.getItems().addAll(cart);
    }

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