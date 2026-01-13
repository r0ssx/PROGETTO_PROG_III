package Client;


import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ListprodottiController {

    @FXML
    private ListView<ProductQueryResult> listaProdotti;

    @FXML
    public void initialize() {
        ObservableList<ProductQueryResult> prodotti =
                FXCollections.observableArrayList();

        // Prodotti di esempio
        ProductQueryResult p1 = new ProductQueryResult();
        p1.nome = "Mouse";
        p1.quantità_scorta = "10";
        p1.codice = "A01";
        p1.costo = "20€";
        p1.descrizione = "Mouse wireless";
        p1.categoria = "Elettronica";

        ProductQueryResult p2 = new ProductQueryResult();
        p2.nome = "Tastiera";
        p2.quantità_scorta = "5";
        p2.codice = "A02";
        p2.costo = "30€";
        p2.descrizione = "Tastiera meccanica";
        p2.categoria = "Elettronica";

        prodotti.addAll(p1, p2);

        listaProdotti.setItems(prodotti);
    }
}

