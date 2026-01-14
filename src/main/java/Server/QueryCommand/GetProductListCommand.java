package Server.QueryCommand;
import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Server.QueryStrategy.GetProductListQuery;
import Server.QueryStrategy.AbstractQueryStrategy;

import java.sql.SQLException;
import java.util.List;

/**
 * Comando di query utilizzato per ottenere la lista completa dei prodotti dal database.
 * Estende {@link AbstractQueryCommand} e utilizza {@link GetProductListQuery}
 * per eseguire la query e restituire tutti i prodotti disponibili.
 */
public class GetProductListCommand extends AbstractQueryCommand<Void, List<ProductQueryResult>> {

    /**
     * Costruttore che inizializza l'accesso al database.
     * @throws SQLException se si verifica un errore durante l'inizializzazione del database
     */
    public GetProductListCommand() throws SQLException {
    }

    /**
     * Esegue la query per ottenere tutti i prodotti disponibili.
     * @param params parametro non utilizzato (nessun input richiesto)
     * @return lista di {@link ProductQueryResult} contenente tutti i prodotti
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    public List<ProductQueryResult> execute(Void params) throws SQLException {
        AbstractQueryStrategy query = new GetProductListQuery();

        return (List<ProductQueryResult>) query.executeQuery(null);

    }
}
