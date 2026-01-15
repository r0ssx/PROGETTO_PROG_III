package Client.Adapters;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.GsonAdapters.CartPacket;

import java.util.List;

/**
 * Adapter responsabile della conversione di una lista di {@link ProductQueryResult}
 * in un {@link CartPacket} utilizzabile per operazioni di carrello o acquisto.
 */
public class ProductListToCartPacketAdapter {

    /**
     * Converte una lista di prodotti in un {@code CartPacket}.
     *
     * Per ogni prodotto viene inserito il codice prodotto nel packet e viene
     * associata una quantità acquistata pari a "1".
     *
     * @param productList lista di {@code ProductQueryResult} da convertire
     * @return {@code CartPacket} popolato con codici prodotto e quantità
     * @throws NullPointerException se {@code productList} è null
     */
    public static CartPacket convert(List<ProductQueryResult> productList) {
        CartPacket cartPacket = new CartPacket();

        for (ProductQueryResult p : productList) {
            cartPacket.codici_prodotto.add(p.codice);
            cartPacket.quantità_acquistata.add("1");
        }

        return cartPacket;
    }
}
