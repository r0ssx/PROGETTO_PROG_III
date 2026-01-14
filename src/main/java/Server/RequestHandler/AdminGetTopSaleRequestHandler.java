package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.AdminGetTopSaleCommand;
import Shared.DataIO;
import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Gestisce le richieste di tipo {@link Request#ADMIN_GET_USER_TOP_SALE}.
 * Questo handler riceve l'email di un utente dal client, esegue la query
 * {@link AdminGetTopSaleCommand} per ottenere la categoria con il maggior numero di acquisti
 * e restituisce il risultato al client.
 */
public class AdminGetTopSaleRequestHandler extends AbstractRequestHandler{

    /**
     * Costruisce un handler associato a uno specifico tipo di richiesta.
     * @param request il tipo di {@link Request} che questo handler può gestire
     */
    public AdminGetTopSaleRequestHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce la richiesta ricevuta dal client.
     * Legge i dati inviati dal client (email), esegue la query
     * {@link AdminGetTopSaleCommand} e invia il risultato indietro al client.
     * @param request il tipo di richiesta ricevuta
     * @param socket socket attraverso il quale comunicare con il client
     * @throws SQLException se si verifica un errore nell'esecuzione della query
     * @throws IOException  se si verifica un errore nella lettura o scrittura dei dati sul socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        System.out.println("Chiamata handleRequest di AdminGetTopSaleRequestHandler");
        AbstractQueryCommand queryCommand = new AdminGetTopSaleCommand();
        DataIO dataIO = new DataIO(socket);

        // Legge l'email dell'utente inviata dal client
        String readData = dataIO.getData(String.class);
        System.out.println(readData);

        // Esegue la query e ottiene il risultato
        String result = (String) queryCommand.execute(readData);

        // Invia il risultato al client
        dataIO.sendData(result);


    }
}
