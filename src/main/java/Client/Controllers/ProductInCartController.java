package Client.Controllers;

import Client.Utilities.CartSingleton;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * Controller JavaFX per la visualizzazione di un prodotto all'interno del carrello.
 *
 * Gestisce l'aggiornamento delle etichette della UI per mostrare
 * i dettagli del prodotto selezionato nel carrello.
 */
public class ProductInCartController {
    @FXML
    public Label priceLabel;

    @FXML
    public Label nameLabel;

    @FXML
    public Label inventoryLabel;

    @FXML
    public Label descriptionLabel;

    @FXML
    public Label categoryLabel;

    /**
     * Imposta il prodotto da visualizzare nel carrello e aggiorna
     * le etichette della UI con le informazioni del prodotto.
     *
     * @param product oggetto {@link ProductQueryResult} da visualizzare
     */
    public void setProduct(ProductQueryResult product) {
        priceLabel.setText(product.costo);
        nameLabel.setText(product.nome);
        inventoryLabel.setText(product.codice);
        descriptionLabel.setText(product.descrizione);
        categoryLabel.setText(product.categoria);
    }
}
