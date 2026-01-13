package Client.Controllers;


import Client.RequestCommand.AbstractRequestCommand;
import Client.RequestCommand.GetProductListRequestCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ListprodottiController {

    @FXML
    private ListView<ProductQueryResult> listaProdotti;

    @FXML
    public void initialize() throws SQLException, IOException {
        AbstractRequestCommand getProductRequest = new GetProductListRequestCommand();
        List<ProductQueryResult> productQueryResultList = (List<ProductQueryResult>) getProductRequest.makeRequest(null);

        ObservableList<ProductQueryResult> prodotti = FXCollections.observableList(productQueryResultList);

        listaProdotti.setItems(prodotti);
    }
}

