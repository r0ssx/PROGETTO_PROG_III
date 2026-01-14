package Server.QueryCommand;

import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.UserLoginQuery;

import java.sql.SQLException;

/**
 * Comando di query utilizzato per l'autenticazione degli utenti.
 * Estende {@link AbstractQueryCommand} e utilizza {@link UserLoginQuery}
 * per verificare le credenziali dell'utente nel database.
 */
public class UserLoginCommand extends AbstractQueryCommand<String, String> {

    /**
     * Costruttore che inizializza l'accesso al database.
     * @throws SQLException se si verifica un errore durante l'inizializzazione del database
     */
    public UserLoginCommand() throws SQLException {
    }

    /**
     * Esegue la query di login per un utente.
     * @param params credenziali dell'utente (ad esempio stringa contenente "email:password")
     * @return risultato della query, tipicamente un messaggio di conferma o un token
     * @throws SQLException se si verifica un errore durante l'esecuzione della query
     */
    @Override
    public String execute(String params) throws SQLException {
        AbstractQueryStrategy query = new UserLoginQuery();

        return (String) query.executeQuery(params);
    }
}
