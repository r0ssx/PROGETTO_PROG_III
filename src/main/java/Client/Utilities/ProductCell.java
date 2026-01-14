package Client.Utilities;

import Client.Controllers.ProductController;
import Client.MainApp;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ProductCell extends ListCell<ProductQueryResult> {
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
