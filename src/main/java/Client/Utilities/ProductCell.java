package Client.Utilities;

import Client.Controllers.ProductController;
import Client.MainApp;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Custom {@link ListCell} per visualizzare oggetti {@link ProductQueryResult}
 * all'interno di una {@link ListView}.
 *
 * Utilizza un file FXML separato ("Product.fxml") per il layout
 * di ciascuna cella e il {@link ProductController} per popolare
 * le informazioni del prodotto.
 */
public class ProductCell extends ListCell<ProductQueryResult> {

    /**
     * Aggiorna il contenuto della cella con le informazioni del prodotto.
     *
     * Se la cella è vuota o il prodotto è nullo, la cella viene svuotata.
     * Altrimenti, carica il layout FXML della cella e imposta i dati del prodotto.
     *
     * @param product oggetto {@link ProductQueryResult} da visualizzare nella cella
     * @param empty indica se la cella è vuota
     */
    @Override
    protected void updateItem(ProductQueryResult product, boolean empty) {
        super.updateItem(product, empty);

        if (empty || product == null) {
            setText(null);
            setGraphic(null);
            return;
        }

        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("Product.fxml"));

        try {
            AnchorPane root = loader.load();
            ProductController controller = loader.getController();
            controller.setProduct(product);

            setText(null);
            setGraphic(root);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
