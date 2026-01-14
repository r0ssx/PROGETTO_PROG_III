package Client.Utilities;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.util.ArrayList;
import java.util.List;


public class CartSingleton {
    private static CartSingleton instance;
    private static List<ProductQueryResult> cart;

    private CartSingleton() {
        cart = new ArrayList<>();
    }

    public static CartSingleton getInstance() {
        if (instance == null) {
            instance = new CartSingleton();
        }
        return instance;
    }

    public static void addToCart(ProductQueryResult product) {
        cart.add(product);
    }

    public static List<ProductQueryResult> getCart() {
        return cart;
    }

    public static void flushCart() {
        cart.clear();
    }
}
