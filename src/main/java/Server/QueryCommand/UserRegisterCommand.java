package Server.QueryCommand;

import Server.QueryStrategy.AbstractQueryStrategy;
import Server.QueryStrategy.UserExistsQuery;
import Server.QueryStrategy.UserRegisterQuery;
import Shared.GsonAdapters.AuthPacket;

import java.sql.SQLException;

/**
 * Comando di query utilizzato per registrare un nuovo utente.
 * Estende {@link AbstractQueryCommand} e verifica prima se l'utente esiste
 * tramite {@link UserExistsQuery}. Se l'utente non esiste, esegue la registrazione
 * con {@link UserRegisterQuery}.
 */
public class UserRegisterCommand extends AbstractQueryCommand<AuthPacket, Boolean> {

    /**
     * Costruttore che inizializza l'accesso al database.
     * @throws SQLException se si verifica un errore durante l'inizializzazione del database
     */
    public UserRegisterCommand() throws SQLException {
    }

    /**
     * Esegue la registrazione di un nuovo utente.
     * Prima controlla se l'utente esiste già. Se esiste, restituisce {@code false}.
     * Altrimenti registra l'utente e restituisce {@code true} se la registrazione ha successo.
     * @param params oggetto {@link AuthPacket} contenente le credenziali dell'utente
     * @return {@code true} se la registrazione ha successo, {@code false} altrimenti
     * @throws SQLException se si verifica un errore durante l'esecuzione delle query
     */

    @Override
    public Boolean execute(AuthPacket params) throws SQLException {
        //check se l'utente esiste
       AbstractQueryStrategy query = new UserExistsQuery();
       String check = (String) query.executeQuery(params.id);

       if(check.equals(params.id)){
           return false;
       }

       // Esegue la registrazione se l'utente non esiste
        AbstractQueryStrategy query2 = new UserRegisterQuery();
        Integer check2 = (Integer) query2.executeQuery(params);

        if(check2 > 0){
            return true;
        } else {
            return false;
        }

    }
}
