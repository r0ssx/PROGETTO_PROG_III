package Client.Controllers;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProductController implements Controller {
    @FXML
    private Label nameLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label inventoryCodeLabel;

    @FXML
    private Label categoryLabel;

    @FXML
    private Button addToCartButton;

    public void setProduct(ProductQueryResult product) {
        System.out.println("Prodotto passato a setProduct: " + product);
        nameLabel.setText(product.nome);
        descriptionLabel.setText(product.descrizione);
        priceLabel.setText(product.costo);
        inventoryCodeLabel.setText(product.codice);
        categoryLabel.setText(product.categoria);
    }

    @FXML
    private void handleAddToCart() {
        ProductQueryResult newProduct = new ProductQueryResult();
        newProduct.nome = nameLabel.getText();
        newProduct.descrizione = descriptionLabel.getText();
        newProduct.costo = priceLabel.getText();
        newProduct.codice = inventoryCodeLabel.getText();
        newProduct.categoria = categoryLabel.getText();
        CartSingleton.addToCart(newProduct);
    }
}
