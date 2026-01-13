package Client.Controllers;

import Client.RequestCommand.AbstractRequestCommand;
import Client.RequestCommand.GetProductListRequestCommand;
import Client.RequestCommand.GetRecommendationsCommand;
import Client.SingletonSession;
import Server.QueryCommand.GetProductListCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UserHomeController implements Controller, Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AbstractRequestCommand getRecommendationsCommand = new GetRecommendationsCommand();
        List<ProductQueryResult> recommendedList;

        AbstractRequestCommand getProducts = new GetProductListRequestCommand();
        List<ProductQueryResult> productsList;

        // ottieni prodotti e raccomandazioni dell'utente loggato
        try {
            recommendedList = (List<ProductQueryResult>) getRecommendationsCommand.makeRequest(SingletonSession.getInstance().getSessionUser());
            productsList = (List<ProductQueryResult>) getProducts.makeRequest(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(recommendedList);
        System.out.println(productsList);
    }
}
