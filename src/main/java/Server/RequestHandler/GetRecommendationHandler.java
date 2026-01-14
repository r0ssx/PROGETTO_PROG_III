package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.GetRecommendationCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.DataIO;
import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

/**
 * Gestisce le richieste di raccomandazioni di prodotti per un utente.
 * Questo handler riceve l'email di un utente dal client, esegue la query
 * {@link GetRecommendationCommand} per ottenere la lista dei prodotti raccomandati
 * e restituisce il risultato al client.
 */
public class GetRecommendationHandler extends AbstractRequestHandler {
    /**
     * Costruisce un handler associato a uno specifico tipo di richiesta.
     * @param request il tipo di {@link Request} che questo handler può gestire
     */
    public GetRecommendationHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce la richiesta ricevuta dal client.
     * Legge l'email dell'utente inviata dal client, esegue la query {@link GetRecommendationCommand}
     * per ottenere i prodotti raccomandati e invia la lista di {@link ProductQueryResult} al client.
     * @param request il tipo di richiesta ricevuta
     * @param socket  socket attraverso il quale comunicare con il client
     * @throws SQLException se si verifica un errore nell'esecuzione della query
     * @throws IOException  se si verifica un errore nella lettura o scrittura dei dati sul socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        System.out.println("chiamata handleRequest di GetRecommendationHandler");

        DataIO dataIO = new DataIO(socket);

        // Legge l'email dell'utente inviata dal client
        String email = dataIO.getData(String.class);

        // Esegue la query per ottenere le raccomandazioni
        AbstractQueryCommand command = new GetRecommendationCommand();
        List<ProductQueryResult> recommendations = (List<ProductQueryResult>) command.execute(email);

        // Invia la lista dei prodotti raccomandati al client
        dataIO.sendData(recommendations);
    }
}
