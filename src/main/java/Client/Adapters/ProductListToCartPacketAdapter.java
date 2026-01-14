package Client.Adapters;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.GsonAdapters.CartPacket;

import java.util.List;

public class ProductListToCartPacketAdapter {
    public static CartPacket convert(List<ProductQueryResult> productList) {
        CartPacket cartPacket = new CartPacket();

        for (ProductQueryResult p : productList) {
            cartPacket.codici_prodotto.add(p.codice);
            cartPacket.quantità_acquistata.add("1");
        }

        return cartPacket;
    }
}
