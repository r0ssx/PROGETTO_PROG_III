package Client.Controllers;

import Client.Adapters.TreeMapToProductList;
import Client.MainApp;
import Client.RequestCommand.AbstractRequestCommand;
import Client.RequestCommand.GetProductListRequestCommand;
import Client.RequestCommand.GetRecommendationsCommand;
import Client.SingletonSession;
import Client.SingletonStage;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UserHomeController implements Controller, Initializable {
    @FXML
    private VBox productListVBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // crea command e lista per ottenere le raccomandazioni
        AbstractRequestCommand<String, List<ProductQueryResult>> getRecommendationsCommand = new GetRecommendationsCommand();
        List<ProductQueryResult> recommendedList;

        // crea command e lista per ottenere tutti i prodotti
        AbstractRequestCommand<Void, List<ProductQueryResult>> getProducts = new GetProductListRequestCommand();
        List<ProductQueryResult> productsList;

        // ottieni effettivamente prodotti e raccomandazioni dell'utente loggato
        try {
            recommendedList = getRecommendationsCommand.makeRequest(SingletonSession.getInstance().getSessionUser());
            productsList = getProducts.makeRequest(null);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        // stampa check
        System.out.println(recommendedList);
        System.out.println(productsList);

        // converti la lista con un adapter per risolvere un problema di gson
        List<ProductQueryResult> recommendedConvertedList = TreeMapToProductList.convert(productsList);

        // inserisci ogni elemento della lista in vbox
        for (int i = 0; i < recommendedConvertedList.size(); i++) {
            System.out.println(recommendedConvertedList.get(i));

            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("Product.fxml"));
            Parent productAnchor;
            try {
                productAnchor = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            productListVBox.getChildren().add(productAnchor);

            ProductController controller = loader.getController();
            controller.setProduct(recommendedConvertedList.get(i));
        }

        // converti la lista con un adapter per risolvere un problema di gson
        List<ProductQueryResult> convertedList = TreeMapToProductList.convert(productsList);

        // inserisci ogni elemento della lista in vbox
        for (int i = 0; i < convertedList.size(); i++) {
            System.out.println(convertedList.get(i));

            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("Product.fxml"));
            Parent productAnchor;
            try {
                 productAnchor = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            productListVBox.getChildren().add(productAnchor);

            ProductController controller = loader.getController();
            controller.setProduct(convertedList.get(i));
        }
    }

    @FXML
    private void handleCheckout() throws IOException {
        SingletonStage.fastChangeScene("Auth.fxml", "User Register", new UserRegisterController());

    }

}


