package Client.Controllers;

import Client.Utilities.CartSingleton;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller JavaFX per la visualizzazione di un singolo prodotto.
 *
 * Gestisce la visualizzazione dei dettagli del prodotto e l'aggiunta
 * dello stesso al carrello tramite {@link CartSingleton}.
 */
public class ProductController {
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

    public ProductQueryResult product;

    /**
     * Gestisce il click sul pulsante "Aggiungi al carrello".
     *
     * Aggiunge il prodotto corrente al carrello gestito da {@link CartSingleton}.
     */
    @FXML
    public void addToCartClick() {
        System.out.println("addToCartClick on" + inventoryLabel + " (" + nameLabel + ")");
        CartSingleton.addToCart(product);
    }

    /**
     * Imposta il prodotto da visualizzare e aggiorna le etichette
     * della UI con le informazioni del prodotto.
     *
     * @param product oggetto {@link ProductQueryResult} da visualizzare
     */
    public void setProduct(ProductQueryResult product) {
        this.product = product;
        priceLabel.setText(product.costo);
        nameLabel.setText(product.nome);
        inventoryLabel.setText(product.codice);
        descriptionLabel.setText(product.descrizione);
        categoryLabel.setText(product.categoria);
    }
}
