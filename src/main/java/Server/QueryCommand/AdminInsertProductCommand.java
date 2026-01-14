package Server.QueryCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.AdminInsertProducQuery;

import java.sql.SQLException;

/**
 * Comando di query utilizzato dagli amministratori per inserire un nuovo prodotto nel database.
 * Estende {@link AbstractQueryCommand} e utilizza {@link AdminInsertProducQuery}
 * per eseguire l'inserimento del prodotto.
 */
public class AdminInsertProductCommand extends AbstractQueryCommand<ProductQueryResult, Boolean>{

    /**
     * Costruttore che inizializza l'accesso al database.
     * @throws SQLException se si verifica un errore durante l'inizializzazione del database
     */
    public AdminInsertProductCommand() throws SQLException {
    }

    /**
     * Esegue l'inserimento di un nuovo prodotto nel database.
     * @param params oggetto {@link ProductQueryResult} contenente i dati del prodotto da inserire
     * @return {@code true} se l'inserimento ha avuto successo, {@code false} altrimenti
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    public Boolean execute(ProductQueryResult params) throws SQLException {
        AbstractQueryStrategy query = new AdminInsertProducQuery();

        return (Boolean) query.executeQuery(params);
    }
}
