package Server.RequestHandler;

import Server.QueryCommand.AbstractQueryCommand;
import Server.QueryCommand.AdminInsertProductCommand;
import Server.QueryCommand.AdminModifyProductCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Shared.DataIO;
import Shared.Requests.Request;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 * Gestisce le richieste di modifica o inserimento di un prodotto da parte di un admin.
 * Questo handler riceve un {@link ProductQueryResult} dal client. Prova prima a inserire
 * il prodotto con {@link AdminInsertProductCommand}. Se il prodotto esiste già, esegue
 * la modifica con {@link AdminModifyProductCommand}. In entrambi i casi invia al client
 * un {@link Boolean} indicante il successo dell'operazione.
 */
public class AdminModifyProductHandler extends AbstractRequestHandler{

    /**
     * Costruisce un handler associato a uno specifico tipo di richiesta.
     * @param request il tipo di {@link Request} che questo handler può gestire
     */
    public AdminModifyProductHandler(Request request) {
        super(request);
    }

    /**
     * Gestisce la richiesta ricevuta dal client.
     * Riceve i dati del prodotto dal client, tenta di inserirlo nel database.
     * Se il prodotto già esiste, viene modificato. Infine invia al client un
     * booleano indicante il successo dell'operazione.
     * @param request il tipo di richiesta ricevuta
     * @param socket socket attraverso il quale comunicare con il client
     * @throws SQLException se si verifica un errore nell'esecuzione della query
     * @throws IOException  se si verifica un errore nella lettura o scrittura dei dati sul socket
     */
    @Override
    public void handleRequest(Request request, Socket socket) throws SQLException, IOException {
        System.out.println("chiamata handleRequest di AdminModifyProductHandler");

        DataIO dataIO = new DataIO(socket);

        // Riceve il prodotto dal client
        ProductQueryResult prodotto = dataIO.getData(ProductQueryResult.class);

        Boolean productInserted;
        try {
            // Prova a inserire il prodotto
            AbstractQueryCommand commandCheck = new AdminInsertProductCommand();
            productInserted = (Boolean) commandCheck.execute(prodotto);
        }
        catch (SQLException e) {
            productInserted = false;
        }

// Se l'inserimento ha successo, invia true, altrimenti modifica il prodotto esistente
        if(productInserted){
            dataIO.sendData(productInserted);
        } else {
            AbstractQueryCommand command = new AdminModifyProductCommand();
            Boolean modify = (Boolean) command.execute(prodotto);

            dataIO.sendData(modify);
        }

    }
}
