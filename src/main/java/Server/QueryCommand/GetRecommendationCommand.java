package Server.QueryCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.GetRecommendationQuery;

import javax.print.DocFlavor;
import java.sql.SQLException;
import java.util.List;

/**
 * Comando di query utilizzato per ottenere raccomandazioni di prodotti
 * per un utente specifico.
 * Estende {@link AbstractQueryCommand} e utilizza {@link GetRecommendationQuery}
 * per recuperare dal database la lista dei prodotti consigliati.
 */
public class GetRecommendationCommand extends AbstractQueryCommand<String, List<ProductQueryResult>> {

    /**
     * Costruttore che inizializza l'accesso al database.
     * @throws SQLException se si verifica un errore durante l'inizializzazione del database
     */
    public GetRecommendationCommand() throws SQLException {
    }

    /**
     * Esegue la query per ottenere i prodotti raccomandati per un utente.
     * @param params identificativo dell'utente o parametro necessario per generare le raccomandazioni
     * @return lista di {@link ProductQueryResult} contenente i prodotti consigliati
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    public List<ProductQueryResult> execute(String params) throws SQLException {
        AbstractQueryStrategy query = new GetRecommendationQuery();
        return (List<ProductQueryResult>) query.executeQuery(params);
    }
}
