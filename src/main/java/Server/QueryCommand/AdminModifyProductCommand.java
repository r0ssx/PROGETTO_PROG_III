package Server.QueryCommand;

import Server.QueryCommand.QueryResultObject.ProductQueryResult;
import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.AdminModifyProductQuery;

import java.sql.SQLException;

/**
 * Comando di query utilizzato dagli amministratori per modificare un prodotto esistente nel database.
 * Estende {@link AbstractQueryCommand} e utilizza {@link AdminModifyProductQuery}
 * per eseguire la modifica dei dati del prodotto.
 */
public class AdminModifyProductCommand extends AbstractQueryCommand<ProductQueryResult, Boolean>{

    /**
     * Costruttore che inizializza l'accesso al database.
     * @throws SQLException se si verifica un errore durante l'inizializzazione del database
     */
    public AdminModifyProductCommand() throws SQLException {
    }

    /**
     * Esegue la modifica di un prodotto nel database.
     * @param params oggetto {@link ProductQueryResult} contenente i dati aggiornati del prodotto
     * @return {@code true} se la modifica ha avuto successo, {@code false} altrimenti
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    public Boolean execute(ProductQueryResult params) throws SQLException {
        AbstractQueryStrategy query = new AdminModifyProductQuery();

        return (Boolean) query.executeQuery(params);
    }
}
