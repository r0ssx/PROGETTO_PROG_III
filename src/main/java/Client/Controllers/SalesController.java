package Client.Controllers;

import Client.Adapters.TreeMapToSalesResult;
import Client.RequestCommand.AbstractRequestCommand;
import Client.RequestCommand.AdminGetSalesRequestCommand;
import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class SalesController implements Initializable {
    @FXML
    public ListView<String> listView;

    @FXML
    public void backClick() {
        System.out.println("backClick");

        Stage thisStage = (Stage) listView.getScene().getWindow();
        thisStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize");

        AbstractRequestCommand adminGetSalesRequest = new AdminGetSalesRequestCommand();
        List<AdminGetSalesQueryResult> adminGetSalesresult = null;
        try {
            adminGetSalesresult = (List<AdminGetSalesQueryResult>) adminGetSalesRequest.makeRequest(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(adminGetSalesresult);

        List<AdminGetSalesQueryResult> sales = TreeMapToSalesResult.convert(adminGetSalesresult);

        for (AdminGetSalesQueryResult sale : sales) {
            listView.getItems().add(sale.toString());
        }
    }
}
