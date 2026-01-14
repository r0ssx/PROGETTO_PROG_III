package Server.QueryCommand;

import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.AdminGetTopSaleQuery;

import java.sql.SQLException;

/**
 * Comando di query utilizzato per ottenere la vendita migliore di un utente,
 * destinato alle operazioni amministrative.
 * Estende {@link AbstractQueryCommand} e utilizza {@link AdminGetTopSaleQuery}
 * per eseguire la query sul database.
 */
public class AdminGetTopSaleCommand extends AbstractQueryCommand<String, String>{

    /**
     * Costruttore che inizializza l'accesso al database.
     * @throws SQLException se si verifica un errore durante l'inizializzazione del database
     */
    public AdminGetTopSaleCommand() throws SQLException {
    }

    /**
     * Esegue la query per ottenere la vendita migliore di un utente specifico.
     * @param params identificativo o email dell'utente di cui ottenere la top sale
     * @return codice o descrizione della vendita migliore dell'utente
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    public String execute(String params) throws SQLException {
        AbstractQueryStrategy query = new AdminGetTopSaleQuery();

        return (String) query.executeQuery(params);
    }
}
