package Client.Controllers;

import Client.Adapters.TreeMapToProductList;
import Client.MainApp;
import Client.RequestCommand.AbstractRequestCommand;
import Client.RequestCommand.GetProductListRequestCommand;
import Client.RequestCommand.GetRecommendationsCommand;
import Client.Utilities.CartSingleton;
import Client.Utilities.ProductCell;
import Client.Utilities.SingletonSession;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller JavaFX per la schermata home dell'utente.
 *
 * Gestisce la visualizzazione dei prodotti e delle raccomandazioni
 * nella {@link #listView}, l'inizializzazione del carrello tramite
 * {@link CartSingleton} e l'accesso alla schermata di checkout.
 */
public class UserHomeController implements Initializable {
    @FXML
    public ListView<ProductQueryResult> listView;

    /**
     * Gestisce il click sul pulsante di checkout.
     *
     * Apre la schermata del carrello e chiude lo stage corrente.
     *
     * @throws IOException se il file FXML del carrello non può essere caricato
     */
    @FXML
    public void checkoutClick() throws IOException {
        // Apre il carrello
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Cart.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        Stage stage = new Stage();
        stage.setTitle("Cart");
        stage.setScene(scene);
        stage.show();

        Stage thisStage = (Stage) listView.getScene().getWindow();
        thisStage.close();
    }

    /**
     * Inizializza il controller.
     *
     * Recupera i prodotti raccomandati e la lista completa dei prodotti dal server,
     * converte i risultati grezzi in oggetti tipizzati tramite {@link TreeMapToProductList},
     * inizializza la cell factory della {@link #listView} e popola la lista.
     *
     * @param url posizione utilizzata per risolvere i percorsi relativi, può essere null
     * @param resourceBundle risorse utilizzate per la localizzazione, può essere null
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // inizializza il carrello
        CartSingleton cartSingleton = CartSingleton.getInstance();

        listView.setCellFactory(listView -> new ProductCell());

        // Inizializza liste per raccomandazioni e prodotti normali
        List<ProductQueryResult> recommendedList = new ArrayList<>();
        List<ProductQueryResult> productList = new ArrayList<>();

        // Inizializza liste per prodotti "raw"
        List<ProductQueryResult> getreclist;
        List<ProductQueryResult> getprodlist;

        GetRecommendationsCommand getRecommendations = new GetRecommendationsCommand();
        GetProductListRequestCommand getProductRequest = new GetProductListRequestCommand();

        // get recommendations and products raw lists
        try {
            getreclist = (List<ProductQueryResult>) getRecommendations.makeRequest(SingletonSession.getInstance().getSessionUser());
            getprodlist = (List<ProductQueryResult>) getProductRequest.makeRequest(null);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        // Converti con adapter i prodotti da raw a oggetti
        recommendedList = TreeMapToProductList.convert(getreclist);
        productList = TreeMapToProductList.convert(getprodlist);

        // Popola la listview con i prodotti ottenuti dal server
        listView.getItems().addAll(recommendedList);
        listView.getItems().addAll(productList);
    }
}
