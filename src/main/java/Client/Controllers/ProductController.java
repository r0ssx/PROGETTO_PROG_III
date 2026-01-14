package Client.Controllers;

import Client.Utilities.CartSingleton;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

    @FXML
    public void addToCartClick() {
        System.out.println("addToCartClick on" + inventoryLabel + " (" + nameLabel + ")");
        CartSingleton.addToCart(product);
    }

    public void setProduct(ProductQueryResult product) {
        this.product = product;
        priceLabel.setText(product.costo);
        nameLabel.setText(product.nome);
        inventoryLabel.setText(product.codice);
        descriptionLabel.setText(product.descrizione);
        categoryLabel.setText(product.categoria);
    }
}
