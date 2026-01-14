package Client.RequestCommand;

import Shared.GsonAdapters.RecommendPacket;
import Shared.GsonAdapters.RequestPacket;
import Shared.Requests.Request;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Comando di richiesta utilizzato dagli amministratori
 * per inviare raccomandazioni al server.
 * Estende {@link AbstractRequestCommand} e invia al server
 * la richiesta {@link Request#ADMIN_RECOMMENDS}.
 */
public class AdminRecommendsRequestCommand extends AbstractRequestCommand<RecommendPacket, Void>{

    /**
     * Invia al server una richiesta contenente le informazioni
     * relative alle raccomandazioni da registrare.
     * @param recommendPacket pacchetto contenente i dati della raccomandazione
     * @return {@code null}, in quanto la richiesta non prevede un valore di ritorno
     * @throws SQLException se si verifica un errore di accesso al database
     * @throws IOException se si verifica un errore di comunicazione
     */
    @Override
    public Void makeRequest(RecommendPacket recommendPacket) throws SQLException, IOException {
        //Sending request
        RequestPacket requestPacket = new RequestPacket(Request.ADMIN_RECOMMENDS);
        server.sendData(requestPacket);

        //Sending request parameters
        server.sendData(recommendPacket);

        return null;
    }
}
