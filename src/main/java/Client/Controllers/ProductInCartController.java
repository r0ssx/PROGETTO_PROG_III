package Client.Controllers;

import Client.Utilities.CartSingleton;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

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

    public void setProduct(ProductQueryResult product) {
        priceLabel.setText(product.costo);
        nameLabel.setText(product.nome);
        inventoryLabel.setText(product.codice);
        descriptionLabel.setText(product.descrizione);
        categoryLabel.setText(product.categoria);
    }
}
