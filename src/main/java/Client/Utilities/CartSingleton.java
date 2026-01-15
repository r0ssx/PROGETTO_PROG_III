package Client.Utilities;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;

import java.util.ArrayList;
import java.util.List;


/**
 * Singleton che gestisce il carrello dell'utente.
 *
 * Fornisce metodi per aggiungere prodotti, ottenere la lista dei prodotti
 * e svuotare il carrello. Garantisce che esista una sola istanza
 * condivisa dell'oggetto carrello.
 */
public class CartSingleton {

    /**
     * Istanza singola del {@link CartSingleton}.
     */
    private static CartSingleton instance;

    /**
     * Lista dei prodotti presenti nel carrello.
     */
    private static List<ProductQueryResult> cart;

    /**
     * Costruttore privato per implementare il pattern singleton.
     * Inizializza la lista dei prodotti.
     */
    private CartSingleton() {
        cart = new ArrayList<>();
    }

    /**
     * Restituisce l'istanza unica del {@link CartSingleton}.
     *
     * @return istanza singola del carrello
     */
    public static CartSingleton getInstance() {
        if (instance == null) {
            instance = new CartSingleton();
        }
        return instance;
    }

    /**
     * Aggiunge un prodotto al carrello.
     *
     * Se il prodotto è già presente, non viene aggiunto nuovamente.
     *
     * @param product prodotto da aggiungere al carrello
     */
    public static void addToCart(ProductQueryResult product) {
        System.out.println("Inserendo nel carrello" + product.codice + "...");
        int index = cart.indexOf(product);
        if (index != -1) {
            return;
        }
        System.out.println("Inserito!");
        cart.add(product);
    }

    /**
     * Restituisce la lista dei prodotti presenti nel carrello.
     *
     * @return lista dei prodotti nel carrello
     */
    public static List<ProductQueryResult> getCart() {
        return cart;
    }

    /**
     * Svuota completamente il carrello.
     */
    public static void flushCart() {
        cart.clear();
    }
}
