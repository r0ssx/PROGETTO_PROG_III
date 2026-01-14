package Server.QueryCommand;

import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.AdminLoginQuery;

import java.sql.SQLException;

/**
 * Comando di query utilizzato per l'autenticazione degli amministratori.
 * Estende {@link AbstractQueryCommand} e utilizza {@link AdminLoginQuery}
 * per verificare le credenziali dell'amministratore nel database.
 */
public class AdminLoginCommand extends AbstractQueryCommand<String, String> {

    /**
     * Costruttore che inizializza l'accesso al database.
     * @throws SQLException se si verifica un errore durante l'inizializzazione del database
     */
    public AdminLoginCommand() throws SQLException {
    }

    /**
     * Esegue la query di login per un amministratore.
     * @param params credenziali dell'amministratore (ad esempio stringa contenente "email:password")
     * @return risultato della query, tipicamente un messaggio di conferma o un token
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    public String execute(String params) throws SQLException {
        AbstractQueryStrategy query = new AdminLoginQuery();

        return (String) query.executeQuery(params);
    }

}
