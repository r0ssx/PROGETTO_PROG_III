package Server.QueryCommand;

import Server.QueryCommand.QueryResultObject.AdminGetSalesQueryResult;
import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.AdminGetSalesQuery;

import java.sql.SQLException;
import java.util.List;

/**
 * Comando di query utilizzato per ottenere le vendite aggregate
 * per categoria, destinato alle operazioni amministrative.
 * Estende {@link AbstractQueryCommand} e utilizza {@link AdminGetSalesQuery}
 * per eseguire la query sul database.
 */
public class AdminGetSalesCommand extends AbstractQueryCommand<Void, List<AdminGetSalesQueryResult>>{

    /**
     * Costruttore che inizializza l'accesso al database.
     * @throws SQLException se si verifica un errore durante l'inizializzazione del database
     */
    public AdminGetSalesCommand() throws SQLException {
    }

    /**
     * Esegue la query per ottenere le vendite aggregate per categoria.
     * @param params parametro non utilizzato (nessun input richiesto)
     * @return lista di {@link AdminGetSalesQueryResult} con i risultati della query
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    public List<AdminGetSalesQueryResult> execute(Void params) throws SQLException {
        AbstractQueryStrategy query = new AdminGetSalesQuery();

        return (List<AdminGetSalesQueryResult>) query.executeQuery(null);
    }
}
