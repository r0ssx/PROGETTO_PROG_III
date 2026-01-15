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

/**
 * Controller JavaFX per la schermata delle vendite (Sales).
 *
 * Si occupa di recuperare i dati di vendita dal server, popolare
 * la lista delle vendite e gestire la navigazione di ritorno.
 */
public class SalesController implements Initializable {
    @FXML
    public ListView<String> listView;

    /**
     * Gestisce il click sul pulsante di ritorno.
     *
     * Chiude lo stage corrente della schermata vendite.
     */
    @FXML
    public void backClick() {
        System.out.println("backClick");

        Stage thisStage = (Stage) listView.getScene().getWindow();
        thisStage.close();
    }

    /**
     * Inizializza il controller.
     *
     * Recupera le informazioni sulle vendite tramite {@link AdminGetSalesRequestCommand},
     * converte i risultati in oggetti tipizzati e popola la {@link #listView}.
     *
     * @param url posizione utilizzata per risolvere i percorsi relativi, può essere null
     * @param resourceBundle risorse utilizzate per la localizzazione, può essere null
     */
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
