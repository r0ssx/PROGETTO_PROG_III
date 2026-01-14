package Client.RequestCommand;

import Shared.GsonAdapters.CartPacket;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Comando di richiesta utilizzato dagli utenti per completare
 * il processo di checkout del carrello.
 * Estende {@link AbstractRequestCommand} e invia al server
 * la richiesta {@link Request#USER_CHECKOUT}.
 */
public class CheckoutRequestCommand extends AbstractRequestCommand<CartPacket, String> {

    /**
     * Invia al server la richiesta di checkout con i prodotti
     * presenti nel carrello e restituisce un identificativo o messaggio
     * relativo all'ordine completato.
     * @param cartPacket pacchetto contenente i dati del carrello dell'utente
     * @return stringa contenente informazioni relative all'ordine completato
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    public String makeRequest(CartPacket cartPacket) throws SQLException, IOException {
        RequestPacket requestPacket = new RequestPacket(Request.USER_CHECKOUT);
        server.sendData(requestPacket);

        server.sendData(cartPacket);

        return server.getData(String.class);
    }
}