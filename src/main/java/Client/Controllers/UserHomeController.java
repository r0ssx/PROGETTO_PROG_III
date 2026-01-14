package Client.Controllers;

import Client.MainApp;
import Client.Utilities.CartSingleton;
import Client.Utilities.ProductCell;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserHomeController implements Initializable {
    @FXML
    public ListView<ProductQueryResult> listView;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // inizializza il carrello
        CartSingleton cartSingleton = CartSingleton.getInstance();

        listView.setCellFactory(listView -> new ProductCell());
        List<ProductQueryResult> productList = new ArrayList<>();
        ProductQueryResult newProduct = new ProductQueryResult();

        newProduct.nome = "Detergente Viso";
        newProduct.quantità_scorta = "3";
        newProduct.codice = "DT67891";
        newProduct.costo = "15";
        newProduct.descrizione = "Detergente Viso per pelli delicate";
        newProduct.categoria = "Bellezza";

        productList.add(newProduct);

        ProductQueryResult newProduct2 = new ProductQueryResult();
        newProduct2.nome = "Detergente Intimo";
        newProduct2.quantità_scorta = "3";
        newProduct2.codice = "DT678D1";
        newProduct2.costo = "1";
        newProduct2.descrizione = "Detergente intimo per intimo delicato";
        newProduct2.categoria = "Bellezza";

        productList.add(newProduct2);

        ProductQueryResult newProduct23 = new ProductQueryResult();
        newProduct23.nome = "Detergente";
        newProduct23.quantità_scorta = "3";
        newProduct23.codice = "DT678D1sfs";
        newProduct23.costo = "154";
        newProduct23.descrizione = "delicato";
        newProduct23.categoria = "Bellezza";

        productList.add(newProduct23);

        ProductQueryResult newProduct4 = new ProductQueryResult();
        newProduct4.nome = "Intimo";
        newProduct4.quantità_scorta = "3";
        newProduct4.codice = "DTddsaa678D1";
        newProduct4.costo = "9999";
        newProduct4.descrizione = "intimo per intimo delicato";
        newProduct4.categoria = "Bellezza";

        productList.add(newProduct4);

        listView.getItems().addAll(productList);
    }
}
